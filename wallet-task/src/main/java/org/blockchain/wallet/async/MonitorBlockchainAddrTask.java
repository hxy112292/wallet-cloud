package org.blockchain.wallet.async;

import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Reference;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.MonitorAddress;
import org.blockchain.wallet.dto.blockchain.BlockChainSingleAdr;
import org.blockchain.wallet.dto.blockchain.BlockChainTxs;
import org.blockchain.wallet.dto.blockchain.BlockChainTxsInput;
import org.blockchain.wallet.dto.blockchain.BlockChainTxsOut;
import org.blockchain.wallet.entity.MonitorTxHistory;
import org.blockchain.wallet.resttemplate.BlockChainIRestAPI;
import org.blockchain.wallet.resttemplate.SochainIRestAPI;
import org.blockchain.wallet.service.FcmService;
import org.blockchain.wallet.service.MonitorAddressService;
import org.blockchain.wallet.service.MonitorTxHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hxy
 */
@Component
@RequiredArgsConstructor
@EnableScheduling
@EnableAsync
public class MonitorBlockchainAddrTask {

    @Reference(check = false)
    BlockChainIRestAPI blockChainIRestAPI;

    @Reference(check = false)
    SochainIRestAPI sochainIRestAPI;

    @Reference(check = false)
    MonitorTxHistoryService monitorTxHistoryService;

    @Reference(check = false)
    FcmService fcmService;

    @Reference(check = false)
    MonitorAddressService monitorAddressService;

    @Value("${monitor.address.txHistory.maxsize}")
    int txMaxSize;

    @Value("${monitor.address.time.offset}")
    int timeOffset;

    @Value("${monitor.address.warn.value}")
    Double warnValueInBlockChain;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Scheduled(cron = "0 12 */1 * * ?")
    public void monitorTask1() {
        monitorBlockChainAddress();
    }

    @Scheduled(cron = "0 25 */1 * * ?")
    public void monitorTask2() {
        monitorBlockChainAddress();
    }

    @Scheduled(cron = "0 39 */1 * * ?")
    public void monitorTask3() {
        monitorBlockChainAddress();
    }

    @Scheduled(cron = "0 54 */1 * * ?")
    public void monitorTask4() {
        monitorBlockChainAddress();
    }

    public void monitorBlockChainAddress() {
        MonitorAddress findMonitorAddressCoindition = new MonitorAddress();
        findMonitorAddressCoindition.setSymbol("BTC");
        List<String> addressList = monitorAddressService.selectBySelective(findMonitorAddressCoindition).stream().map((item)->item.getAddress()).collect(Collectors.toList());
        Instant instant = Instant.now();
        try {
            monitorBTCByBlockChain(addressList, instant.getEpochSecond());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void monitorBTCByBlockChain(List<String> addressList, Long currentTime) {

        PageDto pageDto = new PageDto();
        pageDto.setPageNum(1);
        pageDto.setPageSize(1000);
        pageDto.getParamAsMap().put("symbol", "BTC");
        List<MonitorTxHistory> txHistoryList = monitorTxHistoryService.pageBySelective(pageDto).getResult();

        String networkInfo = sochainIRestAPI.getBTCNetWork();
        Integer blockHeight = JSONObject.parseObject(networkInfo).getJSONObject("data").getInteger("blocks");
        List<BlockChainTxs> transactionsAll = blockChainIRestAPI.getBlockTxs(blockHeight);

        for(MonitorTxHistory txHistory : txHistoryList) {
            for(int i=0;i<transactionsAll.size(); i++ ){
                if(transactionsAll.get(i).getHash().equals(txHistory.getTxHash())) {
                    transactionsAll.remove(i);
                }
            }
        }

        for(String address : addressList) {
            for(BlockChainTxs blockChainTx : transactionsAll) {

                Long timeLimit = timeOffset*60*1000L;

                if(currentTime - blockChainTx.getTime()*1000 <= timeLimit) {
                    Long inValue = 0L;
                    for(BlockChainTxsInput blockChainTxsInput : blockChainTx.getInputs()) {
                        if(blockChainTxsInput.getPrev_out() != null && blockChainTxsInput.getPrev_out().getAddr() != null && blockChainTxsInput.getPrev_out().getAddr().equals(address)) {
                            inValue += blockChainTxsInput.getPrev_out().getValue();
                        }
                    }
                    Long outValue = 0L;
                    for(BlockChainTxsOut blockChainTxsOut : blockChainTx.getOut()) {
                        if(blockChainTxsOut != null && blockChainTxsOut.getAddr()!= null && blockChainTxsOut.getAddr().equals(address)) {
                            outValue += blockChainTxsOut.getValue();
                        }
                    }

                    Long valueChange = outValue - inValue;
                    valueChange = new BigDecimal(valueChange).divide(new BigDecimal(100000000), 8, RoundingMode.HALF_DOWN).longValue();

                    if(Math.abs(valueChange) >= warnValueInBlockChain) {
                        if(valueChange < 0) {
                            fcmService.sendAllNotification("大额转账预警", "地址：" + address + "\n转出："+ valueChange + " BTC");
                            insertTxHistory(blockChainTx.getHash(), "out", address, Math.abs(valueChange) + "", "BTC", new Date(blockChainTx.getTime()*1000));
                        }
                        else {
                            fcmService.sendAllNotification("大额转账预警", "地址：" + address + "\n转入："+ valueChange + " BTC");
                            insertTxHistory(blockChainTx.getHash(), "in", address,  Math.abs(valueChange) + "", "BTC", new Date(blockChainTx.getTime()*1000));
                        }

                    }
                }
            }
        }
    }

    @Async
    public void insertTxHistory(String hash, String inOrOut, String address, String amount, String symbol, Date create_time) {

        MonitorTxHistory txHistory = new MonitorTxHistory();
        txHistory.setTxHash(hash);
        txHistory.setSymbol(symbol);
        if(monitorTxHistoryService.selectBySelective(txHistory).size() != 0) {
            return;
        }

        txHistory.setInOrOut(inOrOut);
        txHistory.setAddress(address);
        txHistory.setAmount(amount);
        txHistory.setCreateTime(create_time);

        monitorTxHistoryService.insert(txHistory);
    }
}
