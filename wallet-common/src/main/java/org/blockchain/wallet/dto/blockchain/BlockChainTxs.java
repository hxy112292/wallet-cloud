package org.blockchain.wallet.dto.blockchain;

import java.io.Serializable;
import java.util.List;

/**
 * @author hxy
 */
public class BlockChainTxs implements Serializable {

    private String hash;
    private Long ver;
    private Long vin_sz;
    private Long vout_sz;
    private Long size;
    private Long weight;
    private Long fee;
    private String relayed_by;
    private Long lock_time;
    private Long tx_index;
    private Boolean double_spend;
    private Long result;
    private Long balance;
    private Long time;
    private Long block_index;
    private Long block_height;
    private List<BlockChainTxsInput> inputs;
    private List<BlockChainTxsOut> out;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Long getVer() {
        return ver;
    }

    public void setVer(Long ver) {
        this.ver = ver;
    }

    public Long getVin_sz() {
        return vin_sz;
    }

    public void setVin_sz(Long vin_sz) {
        this.vin_sz = vin_sz;
    }

    public Long getVout_sz() {
        return vout_sz;
    }

    public void setVout_sz(Long vout_sz) {
        this.vout_sz = vout_sz;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public String getRelayed_by() {
        return relayed_by;
    }

    public void setRelayed_by(String relayed_by) {
        this.relayed_by = relayed_by;
    }

    public Long getLock_time() {
        return lock_time;
    }

    public void setLock_time(Long lock_time) {
        this.lock_time = lock_time;
    }

    public Long getTx_index() {
        return tx_index;
    }

    public void setTx_index(Long tx_index) {
        this.tx_index = tx_index;
    }

    public Boolean getDouble_spend() {
        return double_spend;
    }

    public void setDouble_spend(Boolean double_spend) {
        this.double_spend = double_spend;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getBlock_index() {
        return block_index;
    }

    public void setBlock_index(Long block_index) {
        this.block_index = block_index;
    }

    public Long getBlock_height() {
        return block_height;
    }

    public void setBlock_height(Long block_height) {
        this.block_height = block_height;
    }

    public List<BlockChainTxsInput> getInputs() {
        return inputs;
    }

    public void setInputs(List<BlockChainTxsInput> inputs) {
        this.inputs = inputs;
    }

    public List<BlockChainTxsOut> getOut() {
        return out;
    }

    public void setOut(List<BlockChainTxsOut> out) {
        this.out = out;
    }
}
