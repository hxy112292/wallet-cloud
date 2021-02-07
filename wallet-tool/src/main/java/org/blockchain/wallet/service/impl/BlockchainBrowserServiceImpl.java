package org.blockchain.wallet.service.impl;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.entity.BlockchainBrowser;
import org.blockchain.wallet.mapper.BlockchainBrowserMapper;
import org.blockchain.wallet.service.BlockchainBrowserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hxy
 */
@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class BlockchainBrowserServiceImpl implements BlockchainBrowserService {

    private final BlockchainBrowserMapper blockchainBrowserMapper;

    @Override
    public List<BlockchainBrowser> selectBySelective(BlockchainBrowser blockchainBrowser) {
        return blockchainBrowserMapper.selectBySelective(blockchainBrowser);
    }
}
