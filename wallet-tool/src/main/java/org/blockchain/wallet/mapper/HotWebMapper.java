package org.blockchain.wallet.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.blockchain.wallet.entity.HotWeb;

import java.util.List;

/**
 * @author hxy
 */
@Mapper
public interface HotWebMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HotWeb record);

    int insertSelective(HotWeb record);

    HotWeb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HotWeb record);

    int updateByPrimaryKey(HotWeb record);

    List<HotWeb> selectBySelective(HotWeb record);
}
