package org.blockchain.wallet.service;


import com.github.pagehelper.Page;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.User;

import java.util.List;

/**
 * @author hxy
 */
public interface UserService {

    User createUser(User user);

    User findUserById(Integer id);

    List<User> findUserBySelective(User user);

    Page<User> pageUserBySelective(PageDto pageDto);

    User login(User user);

    User updateUser(User user);

    User forgetPassword(User user);

    List<User> findVipExpiration(User user);
}
