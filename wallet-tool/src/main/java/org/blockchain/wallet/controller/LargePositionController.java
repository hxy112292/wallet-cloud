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
@RequiredArgsConstructor
@RequestMapping(value = "largePosition")
public class LargePositionController {

    private final DNCIRestAPI dncIRestAPI;

    @GetMapping
    public String getLargePosition(String sort) {
        return dncIRestAPI.getLargePosition(sort);
    }

    @GetMapping(value = "address")
    public String getAddressRank(String sort) {
        return dncIRestAPI.getAddressRank(sort);
    }
}
