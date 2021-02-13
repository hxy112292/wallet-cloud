package org.blockchain.wallet.service.impl;

import com.github.pagehelper.Page;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.LiveNewsComment;
import org.blockchain.wallet.mapper.LiveNewsCommentMapper;
import org.blockchain.wallet.service.LiveNewsCommentService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hxy
 */
@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class LiveNewsCommentServiceImpl implements LiveNewsCommentService {

    private final LiveNewsCommentMapper liveNewsCommentMapper;

    @Override
    public Page<LiveNewsComment> pageBySelective(PageDto pageDto) {
        return liveNewsCommentMapper.selectBySelective(pageDto.putParam().getParamAsMap());
    }

    @Override
    public int insert(LiveNewsComment liveNewsComment) {
        return liveNewsCommentMapper.insertSelective(liveNewsComment);
    }

    @Override
    public int update(LiveNewsComment liveNewsComment) {
        return liveNewsCommentMapper.updateByPrimaryKeySelective(liveNewsComment);
    }

    @Override
    public int delete(int id) {
        return liveNewsCommentMapper.deleteByPrimaryKey(id);
    }
}
