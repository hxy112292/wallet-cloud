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
@RequestMapping(value = "/change")
@RequiredArgsConstructor
public class ChangeController {

    private final DNCIRestAPI dncIRestAPI;

    @GetMapping(value = "/max")
    public String getMaxChange(String sort, String isUp) {
        return dncIRestAPI.getMaxChange(sort, isUp);
    }

    @GetMapping(value = "/vol")
    public String getVolChange(String sort) {
        return dncIRestAPI.getVolList(sort);
    }
}
