package org.blockchain.wallet.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.blockchain.wallet.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author hxy
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectBySelective(User record);

    Page<User> selectBySelective(Map<String, Object> param);

    User findAccount(String account);

    int forgetPassword(User record);

    List<User> findVipExpiration(User record);
}
