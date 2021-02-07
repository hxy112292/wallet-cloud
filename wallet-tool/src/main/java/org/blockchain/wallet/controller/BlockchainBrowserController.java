package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.base.ResultResponse;
import org.blockchain.wallet.entity.BlockchainBrowser;
import org.blockchain.wallet.service.BlockchainBrowserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/blockchainBrowser")
@RequiredArgsConstructor
public class BlockchainBrowserController {

    private final BlockchainBrowserService blockchainBrowserService;

    @GetMapping
    public ResultResponse<List<BlockchainBrowser>> getBlockchainBrowser() {

        return new ResultResponse<>(blockchainBrowserService.selectBySelective(new BlockchainBrowser()));
    }
}
