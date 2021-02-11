package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.base.BaseResponse;
import org.blockchain.wallet.base.ResultResponse;
import org.blockchain.wallet.entity.User;
import org.blockchain.wallet.service.EmailService;
import org.blockchain.wallet.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    private final EmailService emailService;

    @PostMapping(value = "/login")
    public BaseResponse<User> login(@RequestBody User user) {

        return new ResultResponse<>(userService.login(user));
    }

    @PostMapping(value = "/register")
    public BaseResponse<User> register(@RequestBody User user) {

        return new ResultResponse<>(userService.createUser(user));
    }

    @PostMapping(value = "/forgetPassword")
    public BaseResponse<User> forgetPassword(@RequestBody User user) {
        User userInfo = userService.forgetPassword(user);
        String subject = "重置密码";
        String text = "新密码：" + userInfo.getPassword() + "。请在登录后，前往个人信息页面修改密码";
        emailService.sendSimpleEmail(userInfo.getEmail(), subject, text);
        return new ResultResponse<>(userInfo);
    }
}
