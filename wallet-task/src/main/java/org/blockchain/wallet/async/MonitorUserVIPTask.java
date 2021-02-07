package org.blockchain.wallet.async;

import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Reference;
import org.blockchain.wallet.constant.Constant;
import org.blockchain.wallet.entity.User;
import org.blockchain.wallet.service.UserService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author hxy
 */
@Component
@RequiredArgsConstructor
@EnableScheduling
public class MonitorUserVIPTask {

    @Reference
    UserService userService;

    @Scheduled(cron = "0 */1 * * * ?")
    public void checkUserVIPStatus() {
        User userDto = new User();
        userDto.setVipTime(new Date());
        List<User> userList = userService.findVipExpiration(userDto);
        for(User user : userList) {
            List<String> role = user.getRole();
            role.remove(Constant.ROLE_PREFIX + Constant.VIP);
            user.setRole(role);
            userService.updateUser(user);
        }
    }
}
