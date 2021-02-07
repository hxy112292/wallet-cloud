package org.blockchain.wallet.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.blockchain.wallet.entity.ConceptDetail;

import java.util.List;

/**
 * @author hxy
 */
@Mapper
public interface ConceptDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConceptDetail record);

    int insertSelective(ConceptDetail record);

    ConceptDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConceptDetail record);

    int updateByPrimaryKey(ConceptDetail record);

    List<ConceptDetail> selectBySelective(ConceptDetail record);
}
