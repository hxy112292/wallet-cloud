package org.blockchain.wallet.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hxy
 */
@Getter
@Setter
@ToString
public class ProductSku {

    private Integer id;
    private String sku;
    private Integer price;
}
