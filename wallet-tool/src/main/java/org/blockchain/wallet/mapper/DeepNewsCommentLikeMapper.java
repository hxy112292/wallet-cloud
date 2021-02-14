package org.blockchain.wallet.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.blockchain.wallet.entity.DeepNewsComment;
import org.blockchain.wallet.entity.DeepNewsCommentLike;

import java.util.List;

@Mapper
public interface DeepNewsCommentLikeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeepNewsCommentLike record);

    int insertSelective(DeepNewsCommentLike record);

    DeepNewsCommentLike selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeepNewsCommentLike record);

    int updateByPrimaryKey(DeepNewsCommentLike record);

    List<DeepNewsCommentLike> selectBySelective(DeepNewsCommentLike deepNewsCommentLike);

    int deleteBySelective(DeepNewsCommentLike deepNewsCommentLike);
}
