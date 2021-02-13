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
@ToString
@Getter
@Setter
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private String sex;

    private Date birthday;

    private String description;

    private List<String> role;

    private Date createTime;

    private Date updateTime;

    private Date vipTime;

    private Integer status;

    private String token;

    private static final long serialVersionUID = 1L;
}
