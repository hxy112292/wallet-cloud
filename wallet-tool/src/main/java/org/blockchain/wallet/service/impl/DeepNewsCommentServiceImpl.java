package org.blockchain.wallet.service.impl;

import com.github.pagehelper.Page;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.DeepNewsComment;
import org.blockchain.wallet.mapper.DeepNewsCommentMapper;
import org.blockchain.wallet.service.DeepNewsCommentService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hxy
 */
@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class DeepNewsCommentServiceImpl implements DeepNewsCommentService {

    private final DeepNewsCommentMapper deepNewsCommentMapper;

    @Override
    public Page<DeepNewsComment> pageBySelective(PageDto pageDto) {
        return deepNewsCommentMapper.selectBySelective(pageDto.putParam().getParamAsMap());
    }

    @Override
    public int insert(DeepNewsComment deepNewsComment) {
        return deepNewsCommentMapper.insertSelective(deepNewsComment);
    }

    @Override
    public int update(DeepNewsComment deepNewsComment) {
        return deepNewsCommentMapper.updateByPrimaryKeySelective(deepNewsComment);
    }

    @Override
    public int delete(int id) {
        return deepNewsCommentMapper.deleteByPrimaryKey(id);
    }
}
