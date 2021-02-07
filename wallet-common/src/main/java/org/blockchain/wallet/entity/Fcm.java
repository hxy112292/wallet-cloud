package org.blockchain.wallet.entity;

import java.io.Serializable;

public class Fcm implements Serializable {
    private Integer id;

    private Integer userId;

    private String fcmToken;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken == null ? null : fcmToken.trim();
    }
}