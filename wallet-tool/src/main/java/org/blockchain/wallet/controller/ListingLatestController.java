package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.resttemplate.DNCIRestAPI;
import org.blockchain.wallet.resttemplate.JinseIRestAPI;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/listingLatest")
@RequiredArgsConstructor
public class ListingLatestController {

    private final DNCIRestAPI dncIRestAPI;

    private final JinseIRestAPI jinseIRestAPI;

    @GetMapping
    public Object getListingLatest() {

//        return coinMarketCapRestAPI.getListingLatest();
        return dncIRestAPI.getListingLatest();
    }

    @GetMapping(value = "/search")
    public Object searchCoin(@RequestParam String coin) {
        return dncIRestAPI.searchCoin(coin);
    }

    @GetMapping(value = "/coinInfo")
    public Object getCoinInfo(@RequestParam String code) {
        return dncIRestAPI.coinDetail(code);
    }

    @GetMapping(value = "/coinMarket")
    public Object getCoinMarket(@RequestParam String code) {
        return dncIRestAPI.getCoinMarket(code);
    }

    @GetMapping(value = "/globalInfo")
    public Object getGlobalInfo() {
        return dncIRestAPI.getGlobalInfo();
    }

    @GetMapping(value = "/holders")
    @PreAuthorize("hasRole('VIP')")
    public Object getHolders(String code) {
        return dncIRestAPI.getHolderList(code);
    }

    @GetMapping(value = "/hotSocial")
    @PreAuthorize("hasRole('VIP')")
    public Object getHotSocial(String code) {
        return dncIRestAPI.getHotSocial(code);
    }

    @GetMapping(value = "/news")
    public Object getCoinNews(String code, String page) {
        return jinseIRestAPI.getCoinNews(code, page);
    }

    @GetMapping(value = "/reduceHalf")
    public Object getReduceHalf(String code) {
        return dncIRestAPI.getReduceHalf(code);
    }

    @GetMapping(value = "/marketTrend")
    public Object getMarketTrend() {
        return dncIRestAPI.getMarketTrend();
    }

    @GetMapping(value = "/fomo")
    public Object getFomoGroup() {
        return jinseIRestAPI.getFomoGroup();
    }
}
