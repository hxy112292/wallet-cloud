package org.blockchain.wallet.service.impl;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.entity.MonitorAddress;
import org.blockchain.wallet.mapper.MonitorAddressMapper;
import org.blockchain.wallet.service.MonitorAddressService;
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
public class MonitorAddressServiceImpl implements MonitorAddressService {

    private final MonitorAddressMapper monitorAddressMapper;

    @Override
    public List<MonitorAddress> selectBySelective(MonitorAddress monitorAddress) {
        return monitorAddressMapper.selectBySelective(monitorAddress);
    }

    @Override
    public MonitorAddress selectByPrimaryKey(int id) {
        return monitorAddressMapper.selectByPrimaryKey(id);
    }
}
