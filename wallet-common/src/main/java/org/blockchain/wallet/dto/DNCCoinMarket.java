package org.blockchain.wallet.dto;

import java.math.BigDecimal;

public class DNCCoinMarket {

    private BigDecimal market_value_usd;
    private String name;
    private BigDecimal current_price_usd;
    private BigDecimal supply;

    public BigDecimal getMarket_value_usd() {
        return market_value_usd;
    }

    public void setMarket_value_usd(BigDecimal market_value_usd) {
        this.market_value_usd = market_value_usd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCurrent_price_usd() {
        return current_price_usd;
    }

    public void setCurrent_price_usd(BigDecimal current_price_usd) {
        this.current_price_usd = current_price_usd;
    }

    public BigDecimal getSupply() {
        return supply;
    }

    public void setSupply(BigDecimal supply) {
        this.supply = supply;
    }
}
