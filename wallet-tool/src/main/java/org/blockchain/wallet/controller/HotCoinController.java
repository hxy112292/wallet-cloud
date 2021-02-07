package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.resttemplate.DNCIRestAPI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/hotcoin")
@RequiredArgsConstructor
public class HotCoinController {

    private final DNCIRestAPI dncIRestAPI;

    @GetMapping
    public String getHotCoin() {

        return dncIRestAPI.getHotCoin();
    }
}
