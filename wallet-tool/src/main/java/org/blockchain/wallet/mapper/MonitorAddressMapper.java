package org.blockchain.wallet.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.blockchain.wallet.entity.MonitorAddress;

import java.util.List;

/**
 * @author hxy
 */
@Mapper
public interface MonitorAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MonitorAddress record);

    int insertSelective(MonitorAddress record);

    List<MonitorAddress> selectBySelective(MonitorAddress record);

    MonitorAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MonitorAddress record);

    int updateByPrimaryKey(MonitorAddress record);
}
