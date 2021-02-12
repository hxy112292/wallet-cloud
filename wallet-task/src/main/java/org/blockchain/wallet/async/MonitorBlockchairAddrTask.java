package org.blockchain.wallet.async;

import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Reference;
import org.blockchain.wallet.entity.MonitorAddress;
import org.blockchain.wallet.dto.blockchair.BlockchairAddrAbstract;
import org.blockchain.wallet.dto.blockchair.BlockchairAddrTx;
import org.blockchain.wallet.entity.MonitorTxHistory;
import org.blockchain.wallet.resttemplate.BlockChairIRestAPI;
import org.blockchain.wallet.service.FcmService;
import org.blockchain.wallet.service.MonitorAddressService;
import org.blockchain.wallet.service.MonitorTxHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * @author hxy
 */
@Component
@RequiredArgsConstructor
public class MonitorBlockchairAddrTask {

    @Reference(check = false)
    BlockChairIRestAPI blockChairIRestAPI;

    @Reference(check = false)
    MonitorTxHistoryService monitorTxHistoryService;

    @Reference(check = false)
    FcmService fcmService;

    @Reference(check = false)
    MonitorAddressService monitorAddressService;


    @Value("${monitor.address.warn.value}")
    Double warnValueInBlockChair;

    @Value("${monitor.address.time.offset}")
    int timeOffset;

    @Value("${monitor.address.txHistory.maxsize}")
    int txMaxSize;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void monitorBlockChairAddress(int i) {
        MonitorAddress findMonitorAddressCoindition = new MonitorAddress();
        findMonitorAddressCoindition.setSymbol("BTC");
        List<MonitorAddress> monitorAddressList = monitorAddressService.selectBySelective(findMonitorAddressCoindition);
        Instant instant = Instant.now();
        try {
            monitorBTCByBlockChair(monitorAddressList.get(i).getAddress(), instant.getEpochSecond());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    @Async
    public void monitorBTCByBlockChair(String address, Long currentTime) {

        BlockchairAddrAbstract blockchairAddrAbstract = blockChairIRestAPI.getBTCAddress(address);

        Long lastReceiveTime = currentTime - blockchairAddrAbstract.getAddress().getLast_seen_receiving().getTime();
        Long lastSendTime = currentTime-blockchairAddrAbstract.getAddress().getLast_seen_spending().getTime();
        Long timeLimit = timeOffset*60*1000L;

        if(lastReceiveTime > timeLimit && lastSendTime > timeLimit) {
            return;
        }

        List<BlockchairAddrTx> transactionsAll = blockchairAddrAbstract.getTransactions();

        MonitorTxHistory txHistoryFind = new MonitorTxHistory();
        txHistoryFind.setSymbol("BTC");
        List<MonitorTxHistory> txHistoryList = monitorTxHistoryService.selectBySelective(txHistoryFind);
        for(MonitorTxHistory txHistory : txHistoryList) {
            for(int i=0;i<transactionsAll.size(); i++ ){
                if(transactionsAll.get(i).getHash().equals(txHistory.getTxHash())) {
                    transactionsAll.remove(i);
                }
            }
        }

        for(BlockchairAddrTx blockchairAddrTx : transactionsAll) {

            Long txTime = 0L;
            try {
                txTime = blockchairAddrTx.getTime().getTime();
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                continue;
            }

            if(currentTime - txTime <= timeLimit) {
                if (blockchairAddrTx.getBalance_change() < 0) {
                    Long inValue = 0 - blockchairAddrTx.getBalance_change();
                    inValue = new BigDecimal(inValue).divide(new BigDecimal(100000000), 8, RoundingMode.HALF_DOWN).longValue();
                    if(inValue >= warnValueInBlockChair) {
                        fcmService.sendAllNotification("大额转账预警", "地址：" + address + "\n转出："+ inValue + " BTC");
                        insertTxHistory(blockchairAddrTx.getHash(), "out", address, inValue.toString(), "BTC", blockchairAddrTx.getTime());
                    }
                }
                if (blockchairAddrTx.getBalance_change() > 0) {
                    Long outValue = blockchairAddrTx.getBalance_change();
                    outValue = new BigDecimal(outValue).divide(new BigDecimal(100000000), 8, RoundingMode.HALF_DOWN).longValue();
                    if(outValue >= warnValueInBlockChair) {
                        fcmService.sendAllNotification("大额转账预警", "地址：" + address + "\n转入："+ outValue + " BTC");
                        insertTxHistory(blockchairAddrTx.getHash(), "in", address,  outValue.toString(), "BTC", blockchairAddrTx.getTime());
                    }
                }
            } else {
                return;
            }
        }
    }

    private void insertTxHistory(String hash, String inOrOut, String address, String amount, String symbol, Date create_time) {

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
