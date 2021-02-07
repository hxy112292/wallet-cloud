package org.blockchain.wallet.service;

import org.blockchain.wallet.entity.MonitorCoin;

import java.util.List;

/**
 * @author hxy
 */
public interface MonitorCoinService {

    List<MonitorCoin> selectBySelective(MonitorCoin monitorCoin);
}
