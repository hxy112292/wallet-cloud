package org.blockchain.wallet.dto.blockchain;

import java.io.Serializable;

/**
 * @author hxy
 */
public class BlockChainTxsInput implements Serializable {

    private Long sequence;
    private String witness;
    private String script;
    private BlockChainPrevOut prev_out;

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public String getWitness() {
        return witness;
    }

    public void setWitness(String witness) {
        this.witness = witness;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public BlockChainPrevOut getPrev_out() {
        return prev_out;
    }

    public void setPrev_out(BlockChainPrevOut prev_out) {
        this.prev_out = prev_out;
    }
}
