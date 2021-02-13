package org.blockchain.wallet.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.blockchain.wallet.entity.DeepNewsComment;

import java.util.Map;

/**
 * @author hxy
 */
@Mapper
public interface DeepNewsCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeepNewsComment record);

    int insertSelective(DeepNewsComment record);

    DeepNewsComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeepNewsComment record);

    int updateByPrimaryKey(DeepNewsComment record);

    Page<DeepNewsComment> selectBySelective(Map<String, Object> param);
}
