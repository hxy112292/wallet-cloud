package org.blockchain.wallet.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hxy
 */
@Getter
@Setter
@ToString
public class MonitorPrice implements Serializable {
    private Integer id;

    private String code;

    private Integer userId;

    private String userEmail;

    private Double upPrice;

    private Double downPrice;

    private Double upChangePercent;

    private Double downChangePercent;

    private String notification;

    private String email;

    private String sms;

    private String voice;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
