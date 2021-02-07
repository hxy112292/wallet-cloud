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
@RequiredArgsConstructor
@RequestMapping(value = "/grayscale")
public class GrayscaleController {

    private final DNCIRestAPI dncIRestAPI;

    @GetMapping(value = "coinInfo")
    public String getCoinInfo() {
        return dncIRestAPI.getGrayscaleCoinInfo();
    }

    @GetMapping(value = "price")
    public String getPrice() {
        return dncIRestAPI.getGrayscaleGBTCPrice();
    }

    @GetMapping(value = "coinList")
    public String getCoinList() {
        return dncIRestAPI.getGrayscaleCoinList();
    }

    @GetMapping(value = "openTrend")
    public String getOpenTrend() {
        return dncIRestAPI.getGrayscaleOpenTrend();
    }

    @GetMapping(value = "organization")
    public String getOrganization() {
        return dncIRestAPI.getGrayScaleOrganization();
    }
}
