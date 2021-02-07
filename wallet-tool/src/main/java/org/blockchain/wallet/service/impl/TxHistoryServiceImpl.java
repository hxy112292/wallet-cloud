package org.blockchain.wallet.service.impl;

import com.github.pagehelper.Page;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.TxHistory;
import org.blockchain.wallet.mapper.TxHistoryMapper;
import org.blockchain.wallet.service.TxHistoryService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hxy
 */
@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class TxHistoryServiceImpl implements TxHistoryService {

    private final TxHistoryMapper txHistoryMapper;


    @Override
    public int selectCount() {
        return txHistoryMapper.selectCount();
    }

    @Override
    public int deleteAll() {
        return txHistoryMapper.deleteAll();
    }

    @Override
    public int deleteByCreateTime() {
        return txHistoryMapper.deleteByCreateTime();
    }

    @Override
    public List<TxHistory> selectBySelective(TxHistory txHistory) {
        return txHistoryMapper.selectBySelective(txHistory);
    }

    @Override
    public Page<TxHistory> pageBySelective(PageDto pageDto) {
        return txHistoryMapper.selectBySelective(pageDto.putParam().getParamAsMap());
    }

    @Override
    public int insertTxHistory(TxHistory txHistory) {

        return txHistoryMapper.insert(txHistory);
    }

    @Override
    public TxHistory selectOldest(TxHistory txHistory) {
        return txHistoryMapper.selectOldest(txHistory);
    }

    @Override
    public int deleteByPrimaryKey(int id) {
        return txHistoryMapper.deleteByPrimaryKey(id);
    }
}
