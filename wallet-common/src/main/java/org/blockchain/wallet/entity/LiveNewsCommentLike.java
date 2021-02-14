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
public class LiveNewsCommentLike implements Serializable {
    private Integer id;

    private Integer commentId;

    private Integer userId;

    private static final long serialVersionUID = 1L;
}
