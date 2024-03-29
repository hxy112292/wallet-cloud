package org.blockchain.wallet.resttemplate;

public interface JinseIRestAPI {
    String getLive(String id);

    String getLiveDetail(String id);

    String getDeepNewsList(String id);

    String getDeepNewsDetail(String url);

    String getCoinNews(String code, String page);

    String getFomoGroup();

    String getCommonNewsList(String id);

    String getCommonNewsDetail(String url);
}
