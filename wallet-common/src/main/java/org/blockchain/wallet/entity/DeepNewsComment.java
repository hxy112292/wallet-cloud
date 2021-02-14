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
public class DeepNewsComment implements Serializable {
    private Integer id;

    private String newsId;

    private Integer userId;

    private String username;

    private String content;

    private List subList;

    private Date createTime;

    private Date updateTime;

    private Integer likeTotal;

    private Integer isLike;

    private static final long serialVersionUID = 1L;
}
