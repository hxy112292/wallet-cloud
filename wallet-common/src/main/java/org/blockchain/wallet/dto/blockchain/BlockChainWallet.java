package org.blockchain.wallet.dto.blockchain;

import java.io.Serializable;

/**
 * @author hxy
 */
public class BlockChainWallet implements Serializable {

    private Long n_tx;
    private Long n_tx_filtered;
    private Long total_received;
    private Long total_sent;
    private Long final_balance;

    public Long getN_tx() {
        return n_tx;
    }

    public void setN_tx(Long n_tx) {
        this.n_tx = n_tx;
    }

    public Long getN_tx_filtered() {
        return n_tx_filtered;
    }

    public void setN_tx_filtered(Long n_tx_filtered) {
        this.n_tx_filtered = n_tx_filtered;
    }

    public Long getTotal_received() {
        return total_received;
    }

    public void setTotal_received(Long total_received) {
        this.total_received = total_received;
    }

    public Long getTotal_sent() {
        return total_sent;
    }

    public void setTotal_sent(Long total_sent) {
        this.total_sent = total_sent;
    }

    public Long getFinal_balance() {
        return final_balance;
    }

    public void setFinal_balance(Long final_balance) {
        this.final_balance = final_balance;
    }
}
