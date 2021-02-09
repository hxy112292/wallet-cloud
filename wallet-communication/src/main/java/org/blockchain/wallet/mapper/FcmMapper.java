package org.blockchain.wallet.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.blockchain.wallet.entity.Fcm;

import java.util.List;

/**
 * @author hxy
 */
@Mapper
public interface FcmMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fcm record);

    int insertSelective(Fcm record);

    Fcm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fcm record);

    int updateByPrimaryKey(Fcm record);

    List<Fcm> selectBySelective(Fcm fcm);

    List<String> selectAllTokens();
}
