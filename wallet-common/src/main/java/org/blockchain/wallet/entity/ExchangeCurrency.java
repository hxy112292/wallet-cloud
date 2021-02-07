package org.blockchain.wallet.entity;

import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hxy
 */
@ToString
public class ExchangeCurrency implements Serializable {
    private Integer id;

    private BigDecimal exchangeUsdTotal;

    private BigDecimal exchangeBtc;

    private BigDecimal exchangeEth;

    private BigDecimal exchangeUsdt;

    private BigDecimal marketUsdTotal;

    private BigDecimal marketBtc;

    private BigDecimal marketEth;

    private BigDecimal marketUsdt;

    private Double percentage;

    private BigDecimal btcPrice;

    private BigDecimal ethPrice;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getExchangeUsdTotal() {
        return exchangeUsdTotal;
    }

    public void setExchangeUsdTotal(BigDecimal exchangeUsdTotal) {
        this.exchangeUsdTotal = exchangeUsdTotal;
    }

    public BigDecimal getExchangeBtc() {
        return exchangeBtc;
    }

    public void setExchangeBtc(BigDecimal exchangeBtc) {
        this.exchangeBtc = exchangeBtc;
    }

    public BigDecimal getExchangeEth() {
        return exchangeEth;
    }

    public void setExchangeEth(BigDecimal exchangeEth) {
        this.exchangeEth = exchangeEth;
    }

    public BigDecimal getExchangeUsdt() {
        return exchangeUsdt;
    }

    public void setExchangeUsdt(BigDecimal exchangeUsdt) {
        this.exchangeUsdt = exchangeUsdt;
    }

    public BigDecimal getMarketUsdTotal() {
        return marketUsdTotal;
    }

    public void setMarketUsdTotal(BigDecimal marketUsdTotal) {
        this.marketUsdTotal = marketUsdTotal;
    }

    public BigDecimal getMarketBtc() {
        return marketBtc;
    }

    public void setMarketBtc(BigDecimal marketBtc) {
        this.marketBtc = marketBtc;
    }

    public BigDecimal getMarketEth() {
        return marketEth;
    }

    public void setMarketEth(BigDecimal marketEth) {
        this.marketEth = marketEth;
    }

    public BigDecimal getMarketUsdt() {
        return marketUsdt;
    }

    public void setMarketUsdt(BigDecimal marketUsdt) {
        this.marketUsdt = marketUsdt;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public BigDecimal getBtcPrice() {
        return btcPrice;
    }

    public void setBtcPrice(BigDecimal btcPrice) {
        this.btcPrice = btcPrice;
    }

    public BigDecimal getEthPrice() {
        return ethPrice;
    }

    public void setEthPrice(BigDecimal ethPrice) {
        this.ethPrice = ethPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
