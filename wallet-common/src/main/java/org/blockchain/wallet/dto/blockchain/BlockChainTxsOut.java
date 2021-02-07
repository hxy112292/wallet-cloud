package org.blockchain.wallet.dto.blockchain;

import java.util.List;

public class BlockChainTxsOut {

    private Long type;
    private Boolean spent;
    private Long value;
    private Long tx_index;
    private Long n;
    private String script;
    private String addr;
    private List<BlockChainSpendingOutpoint> spending_outpoints;

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Boolean getSpent() {
        return spent;
    }

    public void setSpent(Boolean spent) {
        this.spent = spent;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

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

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public List<BlockChainSpendingOutpoint> getSpending_outpoints() {
        return spending_outpoints;
    }

    public void setSpending_outpoints(List<BlockChainSpendingOutpoint> spending_outpoints) {
        this.spending_outpoints = spending_outpoints;
    }
}
