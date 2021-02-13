package org.blockchain.wallet.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.blockchain.wallet.entity.LiveNewsComment;

import java.util.Map;

/**
 * @author hxy
 */
@Mapper
public interface LiveNewsCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LiveNewsComment record);

    int insertSelective(LiveNewsComment record);

    LiveNewsComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LiveNewsComment record);

    int updateByPrimaryKey(LiveNewsComment record);

    Page<LiveNewsComment> selectBySelective(Map<String, Object> param);
}
