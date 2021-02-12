package org.blockchain.wallet.service;

import org.blockchain.wallet.entity.MonitorAddress;

import java.util.List;


/**
 * @author hxy
 */
public interface MonitorAddressService {

    List<MonitorAddress> selectBySelective(MonitorAddress monitorAddress);

    MonitorAddress selectByPrimaryKey(int id);

    int insert(MonitorAddress monitorAddress);

    int update(MonitorAddress monitorAddress);

    int delete(Integer id);
}
