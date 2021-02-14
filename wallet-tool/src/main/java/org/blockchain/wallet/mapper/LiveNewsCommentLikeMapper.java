package org.blockchain.wallet.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.blockchain.wallet.entity.DeepNewsCommentLike;
import org.blockchain.wallet.entity.LiveNewsCommentLike;

import java.util.List;

@Mapper
public interface LiveNewsCommentLikeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LiveNewsCommentLike record);

    int insertSelective(LiveNewsCommentLike record);

    LiveNewsCommentLike selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LiveNewsCommentLike record);

    int updateByPrimaryKey(LiveNewsCommentLike record);

    List<LiveNewsCommentLike> selectBySelective(LiveNewsCommentLike liveNewsCommentLike);

    int deleteBySelective(LiveNewsCommentLike liveNewsCommentLike);
}
