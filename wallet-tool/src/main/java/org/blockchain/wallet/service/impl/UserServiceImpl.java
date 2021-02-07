package org.blockchain.wallet.service.impl;

import com.github.pagehelper.Page;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.blockchain.wallet.constant.Constant;
import org.blockchain.wallet.constant.ErrorMessage;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.User;
import org.blockchain.wallet.mapper.UserMapper;
import org.blockchain.wallet.service.UserService;
import org.blockchain.wallet.util.JwtUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author hxy
 */
@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @Override
    public User createUser(User user) {
        User userDto = new User();
        if(user.getUsername() != null) {
            userDto.setUsername(user.getUsername());
            userDto = userMapper.findAccount(userDto);
            Preconditions.checkArgument((userDto == null), ErrorMessage.USERNAME_EXIST);
        }

        if(user.getEmail() != null) {
            userDto = new User();
            userDto.setEmail(user.getEmail());
            userDto = userMapper.findAccount(userDto);
            Preconditions.checkArgument((userDto==null), ErrorMessage.EMAIL_EXIST);
        }

        if(user.getPhone() != null) {
            userDto = new User();
            userDto.setPhone(user.getPhone());
            userDto = userMapper.findAccount(userDto);
            Preconditions.checkArgument((userDto == null), ErrorMessage.PHONE_EXIST);
        }
        List<String> roles = Lists.newArrayList(Constant.ROLE_PREFIX + Constant.USER);
        user.setRole(roles);
        user.setCreateTime(new Date());
        user.setStatus(Constant.USER_ENABLE);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.insert(user);
        String token =  jwtUtils.encode(user.getId(), user.getRole());
        user = findUserById(user.getId());
        user.setToken(token);
        return user;
    }

    @Override
    public User findUserById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setToken(jwtUtils.encode(user.getId(), user.getRole()));
        return user;
    }

    @Override
    public List<User> findUserBySelective(User user) {
        return userMapper.selectBySelective(user);
    }

    @Override
    public Page<User> pageUserBySelective(PageDto pageDto) {
        return userMapper.selectBySelective(pageDto.putParam().getParamAsMap());
    }

    @Override
    public User login(User userDto) {

        User user = userMapper.findAccount(userDto);
        Preconditions.checkNotNull(user, ErrorMessage.ACCOUNT_NOT_FOUND);
        Preconditions.checkArgument(passwordEncoder.matches(userDto.getPassword(), user.getPassword()), ErrorMessage.ACCOUNT_PASSWORD_ERROR);
        String token = jwtUtils.encode(user.getId(), user.getRole());
        user.setToken(token);
        return user;
    }

    @Override
    public User updateUser(User user) {
        user.setUpdateTime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
        user = findUserById(user.getId());
        return user;
    }

    @Override
    public User forgetPassword(User user) {
        Preconditions.checkArgument((findUserBySelective(user).size() != 0), ErrorMessage.ACCOUNT_NOT_FOUND);
        user.setPassword(RandomStringUtils.randomAlphanumeric(8));
        user.setUpdateTime(new Date());
        userMapper.forgetPassword(user);
        List<User> userList = findUserBySelective(user);
        return userList.get(0);
    }

    @Override
    public List<User> findVipExpiration(User user) {
        return userMapper.findVipExpiration(user);
    }
}
