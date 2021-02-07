package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.CryptoBroadcast;
import org.blockchain.wallet.resttemplate.CryptoIRestAPI;
import org.springframework.web.bind.annotation.*;

/**
 * @author terry.huang
 */
@RestController
@RequestMapping(value = "/BCHTEST")
@RequiredArgsConstructor
public class BchTestController {

    private final CryptoIRestAPI cryptoIRestAPI;

    @GetMapping(value = "/address/{address}")
    public String getAddressInfo(@PathVariable String address) {
        return cryptoIRestAPI.getBCHTestAddressInfo(address);
    }

    @GetMapping(value = "/address/{address}/transaction")
    public String getTxList(@PathVariable String address) {
        return cryptoIRestAPI.getBCHTestTxList(address);
    }

    @GetMapping(value = "/txid/{hash}")
    public String getTxid(@PathVariable String hash) {
        return cryptoIRestAPI.getBCHTestTxInfo(hash);
    }

    @GetMapping(value = "/tx/fee")
    public String getTxFee() {
        return cryptoIRestAPI.getBCHTestTxFee();
    }

    @PostMapping(value = "/send_tx")
    public String broadcast(@RequestBody CryptoBroadcast cryptoBroadcast) {
        return cryptoIRestAPI.broadcastBchTest(cryptoBroadcast);
    }
}
