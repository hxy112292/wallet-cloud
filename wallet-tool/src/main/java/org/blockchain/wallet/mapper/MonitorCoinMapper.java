package org.blockchain.wallet.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.blockchain.wallet.entity.MonitorCoin;

import java.util.List;

/**
 * @author hxy
 */
@Mapper
public interface MonitorCoinMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MonitorCoin record);

    int insertSelective(MonitorCoin record);

    MonitorCoin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MonitorCoin record);

    int updateByPrimaryKey(MonitorCoin record);

    List<MonitorCoin> selectBySelective(MonitorCoin record);
}
