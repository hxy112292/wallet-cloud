package org.blockchain.wallet.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hxy
 */
@Getter
@Setter
@ToString
public class Password {

    private String oldPassword;
    private String newPassword;
    private String repeatPassword;
}
