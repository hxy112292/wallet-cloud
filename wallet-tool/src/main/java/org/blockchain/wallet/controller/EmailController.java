package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.service.EmailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @GetMapping(value = "/send")
    public void sendEmail(@RequestParam int userId, @RequestParam String subject, @RequestParam String text) {
        emailService.sendEmailByUid(userId, subject, text);

    }
}
