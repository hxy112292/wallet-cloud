package org.blockchain.wallet.service;

import org.blockchain.wallet.entity.Fcm;

import java.util.List;

/**
 * @author hxy
 */
public interface FcmService {

    Fcm findFcmById(int id);

    List<Fcm> findFcmBySelective(Fcm fcm);

    int insertFcm(Fcm fcm);

    int updateFcm(Fcm fcm);

    int register(Fcm fcm);

    void sendPersonalNotification(int userId, String title, String body);

    List<String> selectAllTokens();

    void sendAllNotification(String title, String body);
}
