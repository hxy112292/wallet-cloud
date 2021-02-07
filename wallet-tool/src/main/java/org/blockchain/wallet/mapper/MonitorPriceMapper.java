package org.blockchain.wallet.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.blockchain.wallet.entity.MonitorPrice;

import java.util.List;

/**
 * @author hxy
 */
@Mapper
public interface MonitorPriceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MonitorPrice record);

    int insertSelective(MonitorPrice record);

    MonitorPrice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MonitorPrice record);

    int updateByPrimaryKey(MonitorPrice record);

    List<MonitorPrice> selectBySelective(MonitorPrice record);

    int deleteByOneMonth();
}
