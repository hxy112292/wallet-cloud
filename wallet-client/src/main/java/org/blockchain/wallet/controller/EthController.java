package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.resttemplate.EtherscanIRestAPI;
import org.springframework.web.bind.annotation.*;


/**
 * @author terry.huang
 */
@RestController
@RequestMapping(value = "/ETH")
@RequiredArgsConstructor
public class EthController {

    private final EtherscanIRestAPI etherscanIRestAPI;

    @GetMapping(value = "/address/{address}")
    public String getAddressInfo(@PathVariable String address) {
        return etherscanIRestAPI.getAddressInfo(address);
    }

    @GetMapping(value = "/address/{address}/transaction")
    public String getTxList(@PathVariable String address) {
        return etherscanIRestAPI.getTxList(address);
    }

    @GetMapping(value = "/address/{address}/tokentx")
    public String getErc20TxList(@PathVariable String address, @RequestParam String contractAddress) {
        return etherscanIRestAPI.getERC20TxList(address, contractAddress);
    }

}
