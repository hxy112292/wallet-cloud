package org.blockchain.wallet.dto.blockchain;

import java.io.Serializable;
import java.util.List;

/**
 * @author hxy
 */
public class BlockChainSingleAdr implements Serializable {

    private String hash160;
    private String address;
    private Long n_tx;
    private Long total_received;
    private Long total_sent;
    private Long final_balance;
    private List<BlockChainTxs> txs;

    public String getHash160() {
        return hash160;
    }

    public void setHash160(String hash160) {
        this.hash160 = hash160;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getN_tx() {
        return n_tx;
    }

    public void setN_tx(Long n_tx) {
        this.n_tx = n_tx;
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

    public List<BlockChainTxs> getTxs() {
        return txs;
    }

    public void setTxs(List<BlockChainTxs> txs) {
        this.txs = txs;
    }
}
