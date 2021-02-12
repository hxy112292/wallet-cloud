package org.blockchain.wallet.resttemplate;

import org.blockchain.wallet.dto.blockchain.BlockChainSingleAdr;
import org.blockchain.wallet.dto.blockchain.BlockChainTxs;

import java.util.List;

/**
 * @author hxy
 */
public interface BlockChainIRestAPI {
    BlockChainSingleAdr getSingleAddress(String address);

    List<BlockChainTxs> getBlockTxs(Integer height);
}
