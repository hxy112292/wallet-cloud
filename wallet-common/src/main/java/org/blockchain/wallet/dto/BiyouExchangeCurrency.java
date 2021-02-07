package org.blockchain.wallet.dto;

import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author hxy
 */
@ToString
public class BiyouExchangeCurrency implements Serializable {

    private BigDecimal total_reserves_USD;
    private BigDecimal ETH_reserves;
    private BigDecimal USDT_reserves;
    private BigDecimal BTC_reserves;
    private String market;
    private String full_name;

    public BigDecimal getTotal_reserves_USD() {
        return total_reserves_USD;
    }

    public void setTotal_reserves_USD(BigDecimal total_reserves_USD) {
        this.total_reserves_USD = total_reserves_USD;
    }

    public BigDecimal getETH_reserves() {
        return ETH_reserves;
    }

    public void setETH_reserves(BigDecimal ETH_reserves) {
        this.ETH_reserves = ETH_reserves;
    }

    public BigDecimal getUSDT_reserves() {
        return USDT_reserves;
    }

    public void setUSDT_reserves(BigDecimal USDT_reserves) {
        this.USDT_reserves = USDT_reserves;
    }

    public BigDecimal getBTC_reserves() {
        return BTC_reserves;
    }

    public void setBTC_reserves(BigDecimal BTC_reserves) {
        this.BTC_reserves = BTC_reserves;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
