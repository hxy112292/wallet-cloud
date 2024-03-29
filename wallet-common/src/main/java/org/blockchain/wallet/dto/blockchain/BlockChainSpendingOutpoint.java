package org.blockchain.wallet.dto.blockchain;

import java.io.Serializable;

/**
 * @author hxy
 */
public class BlockChainSpendingOutpoint implements Serializable {

    private Long tx_index;
    private Long n;

    public Long getTx_index() {
        return tx_index;
    }

    public void setTx_index(Long tx_index) {
        this.tx_index = tx_index;
    }

    public Long getN() {
        return n;
    }

    public void setN(Long n) {
        this.n = n;
    }
}
