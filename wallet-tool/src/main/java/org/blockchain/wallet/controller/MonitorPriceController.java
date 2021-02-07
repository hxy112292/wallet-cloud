package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.base.ResultResponse;
import org.blockchain.wallet.dto.HuobiMarketDetail;
import org.blockchain.wallet.entity.MonitorCoin;
import org.blockchain.wallet.entity.MonitorPrice;
import org.blockchain.wallet.resttemplate.DNCIRestAPI;
import org.blockchain.wallet.resttemplate.HuobiIRestAPI;
import org.blockchain.wallet.service.MonitorCoinService;
import org.blockchain.wallet.service.MonitorPriceService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/monitorPrice")
@RequiredArgsConstructor
public class MonitorPriceController {

    private final DNCIRestAPI dncIRestAPI;

    private final HuobiIRestAPI huobiIRestAPI;

    private final MonitorPriceService monitorPriceService;

    private final MonitorCoinService monitorCoinService;

    @GetMapping(value ="/coinPrice")
    @PreAuthorize("hasRole('VIP')")
    public ResultResponse<HuobiMarketDetail> getCoinPrice(@RequestParam String symbol) {
        return new ResultResponse<>(huobiIRestAPI.getPrice(symbol));
    }

    @PostMapping
    @PreAuthorize("hasRole('VIP')")
    public ResultResponse<Integer> insert(@RequestBody MonitorPrice monitorPrice) {
        return new ResultResponse<>(monitorPriceService.insert(monitorPrice));
    }

    @PutMapping
    @PreAuthorize("hasRole('VIP')")
    public ResultResponse<Integer> update(@RequestBody MonitorPrice monitorPrice) {
        return new ResultResponse<>(monitorPriceService.updateBySelective(monitorPrice));
    }

    @GetMapping
    @PreAuthorize("hasRole('VIP')")
    public ResultResponse<List<MonitorPrice>> selectBySelective(@RequestParam int userId, @RequestParam String notification) {

        MonitorPrice monitorPrice = new MonitorPrice();
        monitorPrice.setUserId(userId);
        monitorPrice.setNotification(notification);

        return new ResultResponse<>(monitorPriceService.selectBySelective(monitorPrice));
    }

    @GetMapping(value = "/coin")
    @PreAuthorize("hasRole('VIP')")
    public ResultResponse<List<MonitorCoin>> selectCoins() {
        return new ResultResponse<>(monitorCoinService.selectBySelective(new MonitorCoin()));
    }

}
