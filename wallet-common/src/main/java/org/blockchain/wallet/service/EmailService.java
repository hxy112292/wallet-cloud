package org.blockchain.wallet.service;

/**
 * @author hxy
 */
public interface EmailService {

    void sendSimpleEmail(String toEmailAdr, String subject, String text);
}
