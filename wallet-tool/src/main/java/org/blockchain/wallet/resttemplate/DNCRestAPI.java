package org.blockchain.wallet.resttemplate;

import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.DNCCoinPrice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hxy
 */
@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
public class DNCRestAPI implements DNCIRestAPI {

    private final RestTemplate restTemplate;

    @Value("${dnc.root.url}")
    String rootUrl;

    @Value("${dnc.rank.url}")
    String rankUrl;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public String getHotCoin() {
        String url = rootUrl + "/api/coin/hotcoin_search?page={page}&pagesize={pagesize}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("page","1");
        map.put("pagesize","30");
        map.put("webp","1");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getConceptList(String sort) {
        String url = rootUrl + "/api/v2/ranking/concept?page={page}&per_page={per_page}&sort={sort}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("page", "1");
        map.put("per_page", "100");
        map.put("webp", "1");
        map.put("sort", sort);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getConceptDetail(String id) {

        String url = rootUrl + "/api/concept/web-conceptdetail?webp={webp}&id={id}&page={page}&pagesize={pagesize}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("page", "1");
        map.put("id", id);
        map.put("webp","1");
        map.put("pagesize","100");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getTurnOver() {
        String url = rootUrl + "/api/v2/ranking/turnover?pagesize={pagesize}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("pagesize", "30");
        map.put("webp", "1");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getListingLatest() {
        String url = rootUrl + "/api/coin/web-coinrank?webp={webp}&pagesize={pagesize}&page={page}&type={type}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("page", "1");
        map.put("type", "-1");
        map.put("webp","1");
        map.put("pagesize","100");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getGithub() {
        String url = rootUrl + "/api/coin/hotprojectgithub?page={page}&pagesize={pagesize}&sort={sort}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("page", "1");
        map.put("sort", "submit");
        map.put("webp","1");
        map.put("pagesize","30");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String searchCoin(String code) {
        String url = rootUrl + "/api/search/websearch?webp={webp}&page={page}&exchange_page={exchange_page}" +
                "&pagesize={pagesize}&code={code}&wallet_page={wallet_page}&token={token}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("page", "1");
        map.put("exchange_page", "1");
        map.put("webp","1");
        map.put("pagesize","100");
        map.put("code", code);
        map.put("wallet_page", "1");
        map.put("token", "");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String coinDetail(String code) {

        String url = rootUrl + "/api/coin/web-coininfo";

        Map<String,String> map=new HashMap<String,String>();
        map.put("webp","1");
        map.put("code", code);
        map.put("token", "");

        String requestBody = JSONObject.toJSONString(map);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestBody,headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new HashMap<>());

        return response.getBody();
    }


    @Override
    public DNCCoinPrice getCoinPrice(String code) {

        String result = coinDetail(code);

        String dataStr = JSONObject.parseObject(result).get("data").toString();
        DNCCoinPrice dncCoinPrice = JSONObject.parseObject(dataStr, DNCCoinPrice.class);

        return dncCoinPrice;
    }


    @Override
    public String getExchangeList() {
        String url = rootUrl + "/api/v2/exchange/web-exchange?page={page}&pagesize={pagesize}&sort_type={sort_type}" +
                "&asc={asc}&isinnovation={isinnovation}&type={type}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("page", "1");
        map.put("isinnovation","1");
        map.put("type", "all");
        map.put("webp","1");
        map.put("pagesize","30");
        map.put("sort_type","exrank");
        map.put("asc","1");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getExchangeDetail(String code) {
        String url = rootUrl + "/api/exchange/web-exchangeinfo?code={code}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("code", code);
        map.put("webp","1");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getGlobalInfo() {
        String url = rootUrl + "/api/home/global?webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("webp","1");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getCoinMarket(String code) {
        String url = rootUrl + "/api/coin/market_ticker?webp={webp}&page={page}&pagesize={pagesize}&code={code}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("webp","1");
        map.put("page","1");
        map.put("pagesize","50");
        map.put("code", code);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getMaxChange(String sort, String isUp) {
        String url = rootUrl + "/api/v2/coin/maxchange?isup={isup}&filtertype={filtertype}&sort_type={sort_type}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("isup",isUp);
        map.put("filtertype","0");
        map.put("sort_type", sort);
        map.put("webp", "1");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getVolList(String sort) {
        String url = rootUrl + "/api/v2/ranking/coinvol?page={page}&per_page={per_page}&sort={sort}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("page", "1");
        map.put("per_page", "100");
        map.put("webp", "1");
        map.put("sort", sort);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getLargePosition(String type) {
        String url = rankUrl + "/api/v3/discover/large_position?page={page}&pre_page={pre_page}&type={type}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("page", "1");
        map.put("pre_page", "30");
        map.put("webp", "1");
        map.put("type", type);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getAddressRank(String type) {
        String url = rankUrl + "/api/v3/discover/address_rank?page={page}&pre_page={pre_page}&type={type}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("page", "1");
        map.put("pre_page", "30");
        map.put("webp", "1");
        map.put("type", type);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getHolderList(String code) {
        String url = rankUrl + "/api/v3/coin/holders?code={code}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("webp","1");
        map.put("code", code);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getHotSocial(String code) {
        String url = rankUrl + "/api/v3/coin/hotsocial?coincode={coincode}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("webp","1");
        map.put("coincode", code);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getReduceHalf(String code) {
        String url = rankUrl + "/api/v4/reducehalf/info?coincode={coincode}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("webp","1");
        map.put("coincode", code);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getMarketTrend() {
        String url = rankUrl + "/api/v3/coin/markettrend?webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("webp","1");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getGrayscaleCoinInfo() {
        String url = rankUrl + "/api/v2/grayscale/info?coincode={coincode}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("webp","1");
        map.put("coincode", "bitcoin");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getGrayscaleGBTCPrice() {
        String url = rankUrl + "/api/v2/grayscale/index_price?coincode={coincode}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("webp","1");
        map.put("coincode", "bitcoin");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getGrayScaleOrganization() {
        String url = rankUrl + "/api/v2/grayscale/Index_Orgnization?webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("webp","1");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getGrayscaleCoinList() {
        String url = rankUrl + "/api/v3/grayscale/index_list?webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("webp","1");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getGrayscaleOpenTrend() {
        String url = rankUrl + "/api/v2/grayscale/Index_trend?symbol={symbol}&type={type}&length={length}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("symbol","BTC");
        map.put("type", "2");
        map.put("length", "200");
        map.put("webp","1");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getDefiWorthTrend() {
        String url = rankUrl + "/api/v2/defi/worth/trend?type={type}&datetype={datetype}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("datetype","all");
        map.put("type", "2");
        map.put("webp","1");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getLockUpList() {
        String url = rankUrl + "/api/v2/Defi/newlockup/list/page?per_page={per_page}&typeid={typeid}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("per_page","100");
        map.put("typeid", "1");
        map.put("webp","1");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getRateList(String type) {
        String url = rankUrl + "/api/v2/defi/rate/list?type={type}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("type", type);
        map.put("webp","1");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getMiningPoolList() {
        String url = rankUrl + "/api/v2/Defi/mining/pool?webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("webp","1");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getWorthList() {
        String url = rankUrl + "/api/v2/defi/worth/list?type={type}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("type", "0");
        map.put("webp", "1");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }


    @Override
    public String getDefiWorth() {
        String url = rankUrl + "/api/v2/defi/worth?type={type}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("type", "2");
        map.put("webp", "1");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }

    @Override
    public String getEthData() {
        String url = rankUrl + "/api/v2/defi/ethdata?datetype={datetype}&webp={webp}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("datetype", "3");
        map.put("webp", "1");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }
}
