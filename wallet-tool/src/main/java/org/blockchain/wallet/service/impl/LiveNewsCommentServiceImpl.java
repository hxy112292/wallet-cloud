package org.blockchain.wallet.service.impl;

import com.github.pagehelper.Page;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.LiveNewsComment;
import org.blockchain.wallet.entity.LiveNewsCommentLike;
import org.blockchain.wallet.mapper.LiveNewsCommentLikeMapper;
import org.blockchain.wallet.mapper.LiveNewsCommentMapper;
import org.blockchain.wallet.service.LiveNewsCommentService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author hxy
 */
@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class LiveNewsCommentServiceImpl implements LiveNewsCommentService {

    private final LiveNewsCommentMapper liveNewsCommentMapper;
    private final LiveNewsCommentLikeMapper liveNewsCommentLikeMapper;

    @Override
    public Page<LiveNewsComment> pageBySelective(PageDto pageDto) {
        return liveNewsCommentMapper.selectBySelective(pageDto.putParam().getParamAsMap());
    }

    @Override
    public int insert(LiveNewsComment liveNewsComment) {
        liveNewsComment.setCreateTime(new Date());
        return liveNewsCommentMapper.insertSelective(liveNewsComment);
    }

    @Override
    public int update(LiveNewsComment liveNewsComment) {
        liveNewsComment.setUpdateTime(new Date());
        return liveNewsCommentMapper.updateByPrimaryKeySelective(liveNewsComment);
    }

    @Override
    public int delete(int id) {
        return liveNewsCommentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertLike(LiveNewsCommentLike liveNewsCommentLike) {
        return liveNewsCommentLikeMapper.insert(liveNewsCommentLike);
    }

    @Override
    public int deleteLike(LiveNewsCommentLike liveNewsCommentLike) {
        return liveNewsCommentLikeMapper.deleteBySelective(liveNewsCommentLike);
    }

    @Override
    public boolean isLike(LiveNewsCommentLike liveNewsCommentLike) {
        return liveNewsCommentLikeMapper.selectBySelective(liveNewsCommentLike).size() != 0;
    }
}
