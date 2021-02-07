package org.blockchain.wallet.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author hxy
 */
@Getter
@Setter
@ToString
public class ProductSku implements Serializable {

    private Integer id;
    private String sku;
    private Integer price;
}
