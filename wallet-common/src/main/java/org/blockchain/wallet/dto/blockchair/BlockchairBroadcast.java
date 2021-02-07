package org.blockchain.wallet.dto.blockchair;

import java.io.Serializable;

/**
 * @author hxy
 */
public class BlockchairBroadcast implements Serializable {

    String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
