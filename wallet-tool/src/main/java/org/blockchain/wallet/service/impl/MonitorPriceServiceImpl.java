package org.blockchain.wallet.service.impl;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.constant.Constant;
import org.blockchain.wallet.entity.MonitorPrice;
import org.blockchain.wallet.mapper.MonitorPriceMapper;
import org.blockchain.wallet.service.MonitorPriceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author hxy
 */
@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class MonitorPriceServiceImpl implements MonitorPriceService {

    private final MonitorPriceMapper monitorPriceMapper;

    @Override
    public List<MonitorPrice> selectBySelective(MonitorPrice monitorPrice) {
        return monitorPriceMapper.selectBySelective(monitorPrice);
    }

    @Override
    public int insert(MonitorPrice monitorPrice) {
        monitorPrice.setNotification(Constant.NOTIFICATION_ON);
        monitorPrice.setCreateTime(new Date());
        return monitorPriceMapper.insert(monitorPrice);
    }

    @Override
    public int updateBySelective(MonitorPrice monitorPrice) {
        monitorPrice.setUpdateTime(new Date());
        return monitorPriceMapper.updateByPrimaryKeySelective(monitorPrice);
    }

    @Override
    public int deleteByPrimaryKey(int id) {
        return monitorPriceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByOneMonth() {
        return monitorPriceMapper.deleteByOneMonth();
    }
}
