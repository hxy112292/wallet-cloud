package org.blockchain.wallet.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.blockchain.wallet.entity.MonitorBlock;

@Mapper
public interface MonitorBlockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MonitorBlock record);

    int insertSelective(MonitorBlock record);

    MonitorBlock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MonitorBlock record);

    int updateByPrimaryKey(MonitorBlock record);
}