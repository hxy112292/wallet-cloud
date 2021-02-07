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
public class Product implements Serializable {
    private Integer id;

    private String name;

    private String description;

    private Integer originalPrice;

    private Integer price;

    private String type;

    private Integer status;

    private String imageUrl;

    private Date createTime;

    private Date updateTime;

    private List<ProductSku> skuList;

    private static final long serialVersionUID = 1L;
}
