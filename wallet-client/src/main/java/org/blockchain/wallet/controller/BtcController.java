package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.SochainBroadcast;
import org.blockchain.wallet.resttemplate.CryptoIRestAPI;
import org.blockchain.wallet.resttemplate.SochainIRestAPI;
import org.springframework.web.bind.annotation.*;


/**
 * @author terry.huang
 */
@RestController
@RequestMapping(value = "/BTC")
@RequiredArgsConstructor
public class BtcController {

    private final SochainIRestAPI sochainIRestAPI;

    private final CryptoIRestAPI cryptoIRestAPI;

    @GetMapping(value = "/tx/{hash}")
    public String getTxInfo(@PathVariable String hash) {
        return sochainIRestAPI.getBTCTxInfo(hash);
    }

    @GetMapping(value = "/address/{address}")
    public String getAddressInfo(@PathVariable String address) {
        return sochainIRestAPI.getBTCAddressInfo(address);
    }

    @GetMapping(value = "/tx/fee")
    public String getTxFee() {
        return cryptoIRestAPI.getBTCTxFee();
    }

    @PostMapping(value = "/send_tx")
    public String broadcast(@RequestBody SochainBroadcast sochainBroadcast) {
        return sochainIRestAPI.broadcastBTC(sochainBroadcast);
    }

    @GetMapping(value = "/unspent/{address}")
    public String getUnspentTx(@PathVariable String address) {
        return sochainIRestAPI.getBTCUnSpentTxInfo(address);
    }
}
