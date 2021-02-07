package org.blockchain.wallet.service;

import com.github.pagehelper.Page;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.TxHistory;

import java.util.List;

/**
 * @author hxy
 */
public interface TxHistoryService {

    int selectCount();

    int deleteAll();

    int deleteByCreateTime();

    Page<TxHistory> pageBySelective(PageDto pageDto);

    List<TxHistory> selectBySelective(TxHistory txHistory);

    int insertTxHistory(TxHistory txHistory);

    TxHistory selectOldest(TxHistory txHistory);

    int deleteByPrimaryKey(int id);
}
