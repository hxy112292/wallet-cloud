package org.blockchain.wallet.service.impl;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.entity.MonitorCoin;
import org.blockchain.wallet.mapper.MonitorCoinMapper;
import org.blockchain.wallet.service.MonitorCoinService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hxy
 */
@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class MonitorCoinServiceImpl implements MonitorCoinService {

    private final MonitorCoinMapper monitorCoinMapper;

    @Override
    public List<MonitorCoin> selectBySelective(MonitorCoin monitorCoin) {
        return monitorCoinMapper.selectBySelective(monitorCoin);
    }
}
