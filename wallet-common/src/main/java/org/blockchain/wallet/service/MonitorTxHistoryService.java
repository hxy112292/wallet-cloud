package org.blockchain.wallet.service;

import com.github.pagehelper.Page;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.MonitorTxHistory;

import java.util.List;

/**
 * @author hxy
 */
public interface MonitorTxHistoryService {

    Page<MonitorTxHistory> pageBySelective(PageDto pageDto);

    List<MonitorTxHistory> selectBySelective(MonitorTxHistory txHistory);

    int insert(MonitorTxHistory txHistory);

    int deleteByPrimaryKey(int id);
}
