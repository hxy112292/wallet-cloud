package org.blockchain.wallet.service;

import org.blockchain.wallet.entity.BlockchainBrowser;

import java.util.List;

/**
 * @author hxy
 */
public interface BlockchainBrowserService {

    List<BlockchainBrowser> selectBySelective(BlockchainBrowser blockchainBrowser);
}
