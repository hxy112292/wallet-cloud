package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.SochainBroadcast;
import org.blockchain.wallet.resttemplate.CryptoIRestAPI;
import org.blockchain.wallet.resttemplate.SochainIRestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/LTCTEST")
@RequiredArgsConstructor
public class LtcTestController {

    private final SochainIRestAPI sochainIRestAPI;

    private final CryptoIRestAPI cryptoIRestAPI;

    @GetMapping(value = "/address/{address}")
    public String getAddressInfo(@PathVariable String address) {
        return sochainIRestAPI.getLTCTestAddressInfo(address);
    }

    @GetMapping(value = "/tx/{hash}")
    public String getTxInfo(@PathVariable String hash) {
        return sochainIRestAPI.getLTCTestTxInfo(hash);
    }

    @GetMapping(value = "/tx/fee")
    public String getTxFee() {
        return cryptoIRestAPI.getLTCTestTxFee();
    }

    @PostMapping(value = "/send_tx")
    public String broadcast(@RequestBody SochainBroadcast sochainBroadcast) {
        return sochainIRestAPI.broadcastLTCTest(sochainBroadcast);
    }

    @GetMapping(value = "/unspent/{address}")
    public String getUnspentTx(@PathVariable String address) {
        return sochainIRestAPI.getLTCTESTUnSpentTxInfo(address);
    }
}
