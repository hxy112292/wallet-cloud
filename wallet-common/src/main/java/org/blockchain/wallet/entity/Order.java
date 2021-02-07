package org.blockchain.wallet.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author hxy
 */
@Getter
@Setter
@ToString
public class Order implements Serializable {
    private String id;

    private Integer userId;

    private List<CartProduct> productList;

    private Integer totalFee;

    private Integer status;

    private String payNo;

    private Date createTime;

    private Date updateTime;

    private Date paymentTime;

    private String fromAddr;

    private String toAddr;

    private static final long serialVersionUID = 1L;
}
