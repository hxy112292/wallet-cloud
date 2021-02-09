package org.blockchain.wallet.async;

import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Reference;
import org.blockchain.wallet.dto.BiyouExchangeCurrency;
import org.blockchain.wallet.dto.DNCCoinMarket;
import org.blockchain.wallet.entity.ExchangeCurrency;
import org.blockchain.wallet.resttemplate.BiyouIRestAPI;
import org.blockchain.wallet.resttemplate.DNCIRestAPI;
import org.blockchain.wallet.service.ExchangeCurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author hxy
 */
@Component
@RequiredArgsConstructor
@EnableScheduling
public class MonitorExchangeCurrencyTask {

    @Reference(check = false)
    DNCIRestAPI dncIRestAPI;

    @Reference(check = false)
    BiyouIRestAPI biyouIRestAPI;

    @Reference(check = false)
    ExchangeCurrencyService exchangeCurrencyService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async
    @Scheduled(cron = "0 20 */12 * * ?")
    public void monitorExchangeCurrency() {

        JSONObject exchangeJsonObject = JSONObject.parseObject(biyouIRestAPI.getExchangeCurrencyRank());
        List<BiyouExchangeCurrency> biyouExchangeCurrencyList = JSONObject.parseArray(exchangeJsonObject.getJSONObject("data").getJSONArray("reserves_list").toJSONString(), BiyouExchangeCurrency.class);

        JSONObject marketJsonObject = JSONObject.parseObject(dncIRestAPI.getListingLatest());
        List<DNCCoinMarket> dncCoinMarketList = JSONObject.parseArray(marketJsonObject.getJSONArray("data").toJSONString(), DNCCoinMarket.class);

        ExchangeCurrency exchangeCurrency = new ExchangeCurrency();
        exchangeCurrency.setExchangeBtc(new BigDecimal("0"));
        exchangeCurrency.setExchangeEth(new BigDecimal("0"));
        exchangeCurrency.setExchangeUsdt(new BigDecimal("0"));
        exchangeCurrency.setExchangeUsdTotal(new BigDecimal("0"));
        exchangeCurrency.setMarketUsdTotal(new BigDecimal("0"));

        for(BiyouExchangeCurrency biyouExchangeCurrency : biyouExchangeCurrencyList) {
            if(biyouExchangeCurrency.getBTC_reserves() == null) {
                biyouExchangeCurrency.setBTC_reserves(new BigDecimal("0"));
            }
            exchangeCurrency.setExchangeBtc(exchangeCurrency.getExchangeBtc().add(biyouExchangeCurrency.getBTC_reserves()));
            if(biyouExchangeCurrency.getETH_reserves() == null) {
                biyouExchangeCurrency.setETH_reserves(new BigDecimal("0"));
            }
            exchangeCurrency.setExchangeEth(exchangeCurrency.getExchangeEth().add(biyouExchangeCurrency.getETH_reserves()));
            if(biyouExchangeCurrency.getUSDT_reserves() == null) {
                biyouExchangeCurrency.setUSDT_reserves(new BigDecimal("0"));
            }
            exchangeCurrency.setExchangeUsdt(exchangeCurrency.getExchangeUsdt().add(biyouExchangeCurrency.getUSDT_reserves()));
            exchangeCurrency.setExchangeUsdTotal(exchangeCurrency.getExchangeUsdTotal().add(biyouExchangeCurrency.getTotal_reserves_USD()));
        }

        for(DNCCoinMarket dncCoinMarket : dncCoinMarketList) {
            if(dncCoinMarket.getName().equals("BTC")) {
                exchangeCurrency.setMarketBtc(dncCoinMarket.getSupply());
                exchangeCurrency.setBtcPrice(dncCoinMarket.getCurrent_price_usd());
                exchangeCurrency.setMarketUsdTotal(exchangeCurrency.getMarketUsdTotal().add(dncCoinMarket.getMarket_value_usd()));
            }
            if(dncCoinMarket.getName().equals("ETH")) {
                exchangeCurrency.setMarketEth(dncCoinMarket.getSupply());
                exchangeCurrency.setEthPrice(dncCoinMarket.getCurrent_price_usd());
                exchangeCurrency.setMarketUsdTotal(exchangeCurrency.getMarketUsdTotal().add(dncCoinMarket.getMarket_value_usd()));
            }
            if(dncCoinMarket.getName().equals("USDT")) {
                exchangeCurrency.setMarketUsdt(dncCoinMarket.getSupply());
                exchangeCurrency.setMarketUsdTotal(exchangeCurrency.getMarketUsdTotal().add(dncCoinMarket.getMarket_value_usd()));
            }
        }
        BigDecimal exchangeCoinUsdTotal = exchangeCurrency.getExchangeUsdTotal().subtract(exchangeCurrency.getExchangeUsdt());
        exchangeCurrency.setPercentage(exchangeCoinUsdTotal.divide(exchangeCurrency.getMarketUsdTotal(), 4, BigDecimal.ROUND_HALF_DOWN).doubleValue());

        exchangeCurrencyService.insert(exchangeCurrency);
    }
}
