package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.SochainBroadcast;
import org.blockchain.wallet.resttemplate.CryptoIRestAPI;
import org.blockchain.wallet.resttemplate.SochainIRestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/BTCTEST")
@RequiredArgsConstructor
public class BtcTestController {

    private final SochainIRestAPI sochainIRestAPI;

    private final CryptoIRestAPI cryptoIRestAPI;

    @GetMapping(value = "/address/{address}")
    public String getAddressInfo(@PathVariable String address) {
        return sochainIRestAPI.getBTCTESTAddressInfo(address);
    }

    @GetMapping(value = "/tx/{hash}")
    public String getTxInfo(@PathVariable String hash) {
        return sochainIRestAPI.getBTCTESTTxInfo(hash);
    }

    @GetMapping(value = "/tx/fee")
    public String getTxFee() {
        return cryptoIRestAPI.getBTCTestTxFee();
    }

    @PostMapping(value = "/send_tx")
    public String broadcast(@RequestBody SochainBroadcast sochainBroadcast) {
        return sochainIRestAPI.broadcastBTCTEST(sochainBroadcast);
    }

    @GetMapping(value = "/unspent/{address}")
    public String getUnspentTx(@PathVariable String address) {
        return sochainIRestAPI.getBTCTESTUnSpentTxInfo(address);
    }
}
