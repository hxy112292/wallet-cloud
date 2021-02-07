package org.blockchain.wallet.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author hxy
 */
@Getter
@Setter
@ToString
public class CartProduct {

    private Integer id;

    private Integer productId;

    private Integer num;

    private String name;

    private String description;

    private Integer originalPrice;

    private Integer price;

    private String type;

    private Integer status;

    private String imageUrl;

    private Date createTime;

    private Date updateTime;

    ProductSku sku;
}
