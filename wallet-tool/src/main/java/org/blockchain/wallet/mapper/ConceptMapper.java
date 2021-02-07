package org.blockchain.wallet.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.blockchain.wallet.entity.Concept;

import java.util.List;

/**
 * @author hxy
 */
@Mapper
public interface ConceptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Concept record);

    int insertSelective(Concept record);

    Concept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Concept record);

    int updateByPrimaryKey(Concept record);

    List<Concept> selectBySelective(Concept record);
}
