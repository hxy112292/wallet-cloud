package org.blockchain.wallet.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.blockchain.wallet.entity.MonitorTxHistory;

import java.util.List;
import java.util.Map;

@Mapper
public interface MonitorTxHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MonitorTxHistory record);

    int insertSelective(MonitorTxHistory record);

    MonitorTxHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MonitorTxHistory record);

    int updateByPrimaryKey(MonitorTxHistory record);

    Page<MonitorTxHistory> selectBySelective(Map<String, Object> param);

    List<MonitorTxHistory> selectBySelective(MonitorTxHistory record);
}
