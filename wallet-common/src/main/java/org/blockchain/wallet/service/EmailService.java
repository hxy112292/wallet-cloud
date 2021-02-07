package org.blockchain.wallet.service;

/**
 * @author hxy
 */
public interface EmailService {

    void sendSimpleEmail(String toEmailAdr, String subject, String text);

    void sendEmailByUid(int userId, String subject, String text);
}
