package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.resttemplate.EtherscanIRestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author terry.huang
 */
@RestController
@RequestMapping(value = "/ETHTEST")
@RequiredArgsConstructor
public class EthRopstenController {

    private final EtherscanIRestAPI etherscanIRestAPI;

    @GetMapping(value = "/address/{address}")
    public String getAddressInfo(@PathVariable String address) {
        return etherscanIRestAPI.getRopstenAddressInfo(address);
    }

    @GetMapping(value = "/address/{address}/transaction")
    public String getTxList(@PathVariable String address) {
        return etherscanIRestAPI.getRopstenTxList(address);
    }

    @GetMapping(value = "/address/{address}/tokentx")
    public String getErc20TxList(@PathVariable String address, @RequestParam String contractAddress) {
        return etherscanIRestAPI.getRopstenERC20TxList(address, contractAddress);
    }

}
