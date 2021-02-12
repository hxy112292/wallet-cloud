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
public class MonitorTxHistory implements Serializable {
    private Integer id;

    private String txHash;

    private String address;

    private String symbol;

    private String amount;

    private String inOrOut;

    private String addressTag;

    private Date createTime;

    private Date updateTime;

    private Date tradeTime;

    private static final long serialVersionUID = 1L;
}
