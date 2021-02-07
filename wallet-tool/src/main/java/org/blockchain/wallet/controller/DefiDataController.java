package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.resttemplate.DNCIRestAPI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author terry.huang
 */
@RestController
@RequestMapping(value = "defi")
@RequiredArgsConstructor
public class DefiDataController {

    private final DNCIRestAPI dncIRestAPI;

    @GetMapping(value = "worthTrend")
    public String getWorthTrend(){
        return dncIRestAPI.getDefiWorthTrend();
    }

    @GetMapping(value = "lockUpList")
    public String getLockUpList() {
        return dncIRestAPI.getLockUpList();
    }

    @GetMapping(value = "rateList")
    public String getRateList(String type) {
        return dncIRestAPI.getRateList(type);
    }

    @GetMapping(value = "worthList")
    public String getWorthList() {
        return dncIRestAPI.getWorthList();
    }

    @GetMapping(value = "miningList")
    public String getMiningList() {
        return dncIRestAPI.getMiningPoolList();
    }

    @GetMapping(value = "worth")
    public String getDefiWorth() {
        return dncIRestAPI.getDefiWorth();
    }

    @GetMapping(value = "ethData")
    public String getEthData() {
        return dncIRestAPI.getEthData();
    }
}
