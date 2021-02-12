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
public class MonitorAddress implements Serializable {
    private Integer id;

    private String address;

    private String symbol;

    private String tag;

    private Integer userId;

    private Date createTime;

    private Date updateTime;

    private String notification;

    private String email;

    private String sms;

    private String phone;

    private static final long serialVersionUID = 1L;
}
