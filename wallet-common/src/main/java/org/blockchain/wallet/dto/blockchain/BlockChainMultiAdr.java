package org.blockchain.wallet.dto.blockchain;

import java.io.Serializable;
import java.util.List;

/**
 * @author hxy
 */
public class BlockChainMultiAdr implements Serializable {
    private List<BlockChainAdr> addresses;
    private BlockChainWallet wallet;
    private List<BlockChainTxs> txs;

    public List<BlockChainAdr> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<BlockChainAdr> addresses) {
        this.addresses = addresses;
    }

    public BlockChainWallet getWallet() {
        return wallet;
    }

    public void setWallet(BlockChainWallet wallet) {
        this.wallet = wallet;
    }

    public List<BlockChainTxs> getTxs() {
        return txs;
    }

    public void setTxs(List<BlockChainTxs> txs) {
        this.txs = txs;
    }
}
