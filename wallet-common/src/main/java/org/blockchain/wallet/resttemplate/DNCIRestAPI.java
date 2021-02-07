package org.blockchain.wallet.resttemplate;

import org.blockchain.wallet.dto.DNCCoinPrice;

public interface DNCIRestAPI {
    String getHotCoin();

    String getConceptList(String sort);

    String getConceptDetail(String id);

    String getTurnOver();

    String getListingLatest();

    String getGithub();

    String searchCoin(String code);

    String coinDetail(String code);

    DNCCoinPrice getCoinPrice(String code);

    String getExchangeList();

    String getExchangeDetail(String code);

    String getGlobalInfo();

    String getCoinMarket(String code);

    String getMaxChange(String sort, String isUp);

    String getVolList(String sort);

    String getLargePosition(String type);

    String getAddressRank(String type);

    String getHolderList(String code);

    String getHotSocial(String code);

    String getReduceHalf(String code);

    String getMarketTrend();

    String getGrayscaleCoinInfo();

    String getGrayscaleGBTCPrice();

    String getGrayScaleOrganization();

    String getGrayscaleCoinList();

    String getGrayscaleOpenTrend();

    String getDefiWorthTrend();

    String getLockUpList();

    String getRateList(String type);

    String getMiningPoolList();

    String getWorthList();

    String getDefiWorth();

    String getEthData();
}
