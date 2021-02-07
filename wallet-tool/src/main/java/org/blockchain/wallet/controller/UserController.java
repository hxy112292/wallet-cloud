package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.base.BaseResponse;
import org.blockchain.wallet.base.ResultResponse;
import org.blockchain.wallet.entity.User;
import org.blockchain.wallet.service.EmailService;
import org.blockchain.wallet.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/info")
    public BaseResponse<User> getUserInfo(@RequestParam Integer userId) {

        return new ResultResponse<>(userService.findUserById(userId));
    }

    @PutMapping(value = "/update")
    public BaseResponse<User> updateUserInfo(@RequestBody User user) {

        return new ResultResponse<>(userService.updateUser(user));
    }
}
