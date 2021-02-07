package org.blockchain.wallet.controller;

import com.github.pagehelper.Page;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.base.BaseResponse;
import org.blockchain.wallet.base.PageResponse;
import org.blockchain.wallet.base.ResultResponse;
import org.blockchain.wallet.constant.Constant;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.ExchangeCurrency;
import org.blockchain.wallet.resttemplate.BiyouIRestAPI;
import org.blockchain.wallet.resttemplate.DNCIRestAPI;
import org.blockchain.wallet.service.ExchangeCurrencyService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/exchange")
@RequiredArgsConstructor
public class ExchangeController {

    private final DNCIRestAPI dncIRestAPI;

    private final BiyouIRestAPI biyouIRestAPI;

    private final ExchangeCurrencyService exchangeCurrencyService;

    @GetMapping
    public String getExchangeList() {
        return dncIRestAPI.getExchangeList();
    }

    @GetMapping(value = "/currency/rank")
    @PreAuthorize("hasRole('VIP')")
    public String getExchangeCurrencyRank() {
        return biyouIRestAPI.getExchangeCurrencyRank();
    }

    @GetMapping(value = "/detail")
    public String getExchangeDetail(@RequestParam String code) {
        return dncIRestAPI.getExchangeDetail(code);
    }

    @GetMapping(value = "/currency/list")
    @PreAuthorize("hasRole('VIP')")
    public BaseResponse<Page<ExchangeCurrency>> getExchangeCurrencyTotalList(PageDto pageDto) {
        Page<ExchangeCurrency> page = exchangeCurrencyService.pageBySelective(pageDto);
        return new PageResponse<>(page, page.getTotal());
    }

    @GetMapping(value = "/currency/cal")
    @PreAuthorize("hasRole('ADMIN')")
    public BaseResponse<String> calPercentage() {
        PageDto pageDto = new PageDto();
        pageDto.setPageNum(1);
        pageDto.setPageSize(10000);
        List<ExchangeCurrency> exchangeCurrencyList = exchangeCurrencyService.pageBySelective(pageDto).getResult();
        for (ExchangeCurrency exchangeCurrency : exchangeCurrencyList) {
            BigDecimal exchangeCoinUsdTotal = exchangeCurrency.getExchangeUsdTotal().subtract(exchangeCurrency.getExchangeUsdt());
            exchangeCurrency.setPercentage(exchangeCoinUsdTotal.divide(exchangeCurrency.getMarketUsdTotal(), 4, BigDecimal.ROUND_HALF_DOWN).doubleValue());
            exchangeCurrencyService.update(exchangeCurrency);
        }
        return new ResultResponse<>(Constant.SUCCESS);
    }
}
