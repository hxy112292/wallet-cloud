package org.blockchain.wallet.dto;

import java.io.Serializable;

/**
 * @author hxy
 */
public class CryptoBroadcast implements Serializable {
    private String hex;

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }
}
