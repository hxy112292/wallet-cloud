package org.blockchain.wallet.dto;

import java.io.Serializable;

/**
 * @author hxy
 */
public class SochainBroadcast implements Serializable {

    private String tx_hex;

    public String getTx_hex() {
        return tx_hex;
    }

    public void setTx_hex(String tx_hex) {
        this.tx_hex = tx_hex;
    }
}
