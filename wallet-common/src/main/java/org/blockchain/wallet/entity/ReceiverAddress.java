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
public class ReceiverAddress implements Serializable {
    private Integer id;

    private String receiveAddr;

    private String type;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
