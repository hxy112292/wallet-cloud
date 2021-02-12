package org.blockchain.wallet.async;

import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Reference;
import org.blockchain.wallet.constant.Constant;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.dto.blockchain.BlockChainTxs;
import org.blockchain.wallet.dto.blockchain.BlockChainTxsInput;
import org.blockchain.wallet.dto.blockchain.BlockChainTxsOut;
import org.blockchain.wallet.entity.MonitorAddress;
import org.blockchain.wallet.entity.MonitorTxHistory;
import org.blockchain.wallet.resttemplate.BlockChainIRestAPI;
import org.blockchain.wallet.resttemplate.SochainIRestAPI;
import org.blockchain.wallet.service.*;
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
import java.util.*;
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

    @Reference(check = false)
    EmailService emailService;

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
        List<MonitorAddress> monitorAddressList = monitorAddressService.selectBySelective(findMonitorAddressCoindition);
        Instant instant = Instant.now();
        try {
            monitorBTCByBlockChain(monitorAddressList, instant.getEpochSecond());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void monitorBTCByBlockChain(List<MonitorAddress> monitorAddressList, Long currentTime) {

        PageDto pageDto = new PageDto();
        pageDto.setPageNum(1);
        pageDto.setPageSize(1000);
        pageDto.getParamAsMap().put("symbol", "BTC");
        List<MonitorTxHistory> txHistoryList = monitorTxHistoryService.pageBySelective(pageDto).getResult();

        String networkInfo = sochainIRestAPI.getBTCNetWork();
        Integer blockHeight = JSONObject.parseObject(networkInfo).getJSONObject("data").getInteger("blocks");
        List<BlockChainTxs> transactionsAll = blockChainIRestAPI.getBlockTxs(blockHeight);

        transactionsAll = transactionsAll.stream().filter((item) -> !txHistoryList.contains(item.getHash())).collect(Collectors.toList());
        List<String> addressList = monitorAddressList.stream().map(item -> item.getAddress()).collect(Collectors.toList());

        for(BlockChainTxs blockChainTx : transactionsAll) {
            Map<String, Long> map = new HashMap<>(addressList.size());
            Long timeLimit = timeOffset*60*1000L;
            if(currentTime - blockChainTx.getTime()*1000 <= timeLimit) {
                for(BlockChainTxsInput blockChainTxsInput : blockChainTx.getInputs()) {
                    if(blockChainTxsInput.getPrev_out() != null && blockChainTxsInput.getPrev_out().getAddr() != null && addressList.contains(blockChainTxsInput.getPrev_out().getAddr())) {
                        String key = blockChainTx.getHash() + blockChainTxsInput.getPrev_out().getAddr();
                        Long inValue = map.get(key);
                        if(inValue == null) {
                            inValue = -blockChainTxsInput.getPrev_out().getValue();
                        } else {
                            inValue -= blockChainTxsInput.getPrev_out().getValue();
                        }
                        map.put(key, inValue);
                    }
                }
                for(BlockChainTxsOut blockChainTxsOut : blockChainTx.getOut()) {
                    if(blockChainTxsOut != null && blockChainTxsOut.getAddr()!= null && addressList.contains(blockChainTxsOut.getAddr())) {
                        String key = blockChainTx.getHash() + blockChainTxsOut.getAddr();
                        Long outValue =map.get(key);
                        if(outValue == null) {
                            outValue = blockChainTxsOut.getValue();
                        } else {
                            outValue += blockChainTxsOut.getValue();
                        }
                        map.put(key, outValue);
                    }
                }
                for(MonitorAddress monitorAddress : monitorAddressList) {
                    String address = monitorAddress.getAddress();
                    String key = blockChainTx.getHash() + address;
                    Long valueChange = map.get(key);
                    if(valueChange == null) {
                        continue;
                    }
                    valueChange = new BigDecimal(valueChange).divide(new BigDecimal(100000000), 8, RoundingMode.HALF_DOWN).longValue();
                    if(Math.abs(valueChange) >= warnValueInBlockChain) {
                        if(valueChange < 0) {
                            if(monitorAddress.getNotification().equals(Constant.NOTIFICATION_ON)) {
                                fcmService.sendAllNotification("大额转账预警", "地址：" + address + "\n转出："+ valueChange + " BTC");
                            }
                            if(monitorAddress.getEmail().equals(Constant.NOTIFICATION_EMAIL_TRUE) && monitorAddress.getUserEmail() != null) {
                                emailService.sendSimpleEmail(monitorAddress.getUserEmail(), "大额转账预警", "地址：" + address + "\n转出："+ valueChange + " BTC\nHash："+blockChainTx.getHash());
                            }
                            insertTxHistory(blockChainTx.getHash(), "out", address, Math.abs(valueChange) + "", "BTC", new Date(blockChainTx.getTime()*1000));
                        }
                        else {
                            if(monitorAddress.getNotification().equals(Constant.NOTIFICATION_ON)) {
                                fcmService.sendAllNotification("大额转账预警", "地址：" + address + "\n转入："+ valueChange + " BTC");
                            }
                            if(monitorAddress.getEmail().equals(Constant.NOTIFICATION_EMAIL_TRUE) && monitorAddress.getUserEmail() != null) {
                                emailService.sendSimpleEmail(monitorAddress.getUserEmail(), "大额转账预警", "地址：" + address + "\n转入："+ valueChange + " BTC\nHash："+blockChainTx.getHash());
                            }
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
        txHistory.setCreateTime(new Date());

        monitorTxHistoryService.insert(txHistory);
    }

    private List removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }
}
