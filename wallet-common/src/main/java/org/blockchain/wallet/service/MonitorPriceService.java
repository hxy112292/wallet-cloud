package org.blockchain.wallet.service;

import org.blockchain.wallet.entity.MonitorPrice;

import java.util.List;

/**
 * @author hxy
 */
public interface MonitorPriceService {

    List<MonitorPrice> selectBySelective(MonitorPrice monitorPrice);

    int insert(MonitorPrice monitorPrice);

    int updateBySelective(MonitorPrice monitorPrice);

    int deleteByPrimaryKey(int id);

    int deleteByOneMonth();
}
