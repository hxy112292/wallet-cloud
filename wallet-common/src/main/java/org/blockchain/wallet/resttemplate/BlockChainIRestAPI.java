package org.blockchain.wallet.resttemplate;

import org.blockchain.wallet.dto.blockchain.BlockChainSingleAdr;

public interface BlockChainIRestAPI {
    BlockChainSingleAdr getSingleAddress(String address);
}
