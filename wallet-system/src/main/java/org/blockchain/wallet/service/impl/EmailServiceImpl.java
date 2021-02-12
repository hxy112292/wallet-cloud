package org.blockchain.wallet.service.impl;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author hxy
 */
@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@EnableAsync
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    String fromEmailAdr;

    private final JavaMailSenderImpl javaMailSender;

    @Override
    @Async
    public void sendSimpleEmail(String toEmailAdr, String subject, String text) {

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            //邮件发送人
            simpleMailMessage.setFrom(fromEmailAdr);
            //邮件接收人
            simpleMailMessage.setTo(toEmailAdr);
            //邮件主题
            subject = "[HD-Wallet] " + subject;
            simpleMailMessage.setSubject(subject);
            //邮件内容
            simpleMailMessage.setText(text);

            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
