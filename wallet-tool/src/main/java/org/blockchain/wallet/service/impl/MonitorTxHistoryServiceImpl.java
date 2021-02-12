package org.blockchain.wallet.service.impl;

import com.github.pagehelper.Page;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.MonitorTxHistory;
import org.blockchain.wallet.mapper.MonitorTxHistoryMapper;
import org.blockchain.wallet.service.MonitorTxHistoryService;
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
public class MonitorTxHistoryServiceImpl implements MonitorTxHistoryService {

    private final MonitorTxHistoryMapper txHistoryMapper;

    @Override
    public List<MonitorTxHistory> selectBySelective(MonitorTxHistory txHistory) {
        return txHistoryMapper.selectBySelective(txHistory);
    }

    @Override
    public Page<MonitorTxHistory> pageByUserId(PageDto pageDto) {
        return txHistoryMapper.selectByUserId(pageDto.putParam().getParamAsMap());
    }

    @Override
    public Page<MonitorTxHistory> pageBySelective(PageDto pageDto) {
        return txHistoryMapper.selectBySelective(pageDto.putParam().getParamAsMap());
    }

    @Override
    public int insert(MonitorTxHistory txHistory) {

        return txHistoryMapper.insert(txHistory);
    }

    @Override
    public int deleteByPrimaryKey(int id) {
        return txHistoryMapper.deleteByPrimaryKey(id);
    }
}
