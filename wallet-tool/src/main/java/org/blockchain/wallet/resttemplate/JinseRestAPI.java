package org.blockchain.wallet.resttemplate;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
@Component
@RequiredArgsConstructor
public class JinseRestAPI implements JinseIRestAPI {

    private final RestTemplate restTemplate;

    @Value("${jinse.root.url}")
    String rootUrl;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getLive(String id) {
        String url = rootUrl + "/live/list?id={id}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("id", id);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }

    @Override
    public String getLiveDetail(String id) {
        String url = rootUrl + "/noah/v2/live/" + id;
        Map<String,String> map=new HashMap<String,String>();

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }

    @Override
    public String getDeepNewsList(String id) {
        String url = rootUrl + "/v6/information/list?catelogue_key={catelogue_key}&information_id={information_id}&flag={flag}&version={version}&_source={_source}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("catelogue_key", "capitalmarket");
        map.put("information_id", id);
        map.put("flag", "down");
        map.put("version", "9.9.9");
        map.put("_source", "www");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }

    @Override
    public String getDeepNewsDetail(String url) {

        Map<String,String> map=new HashMap<String,String>();

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        String result = response.getBody();

        Document doc =  Jsoup.parse(result);

        return doc.getElementById("article-content").toString();
    }

    @Override
    public String getCoinNews(String code, String page) {
        String url = rootUrl + "/v3/coin/news?slugs={slugs}&page={page}&_source=m";

        Map<String,String> map=new HashMap<String,String>();
        map.put("slugs", code);
        map.put("page", page);
        map.put("_source", "m");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }

    @Override
    public String getFomoGroup() {
        String url = rootUrl + "/new-market/v1/app/dashboard/group";

        Map<String,String> map=new HashMap<String,String>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{\"ordering\":[\"market_review\",\"fgi\",\"plate\",\"btc_metrics\",\"finance_metrics\",\"cme\"],\"cme\":\"\",\"market_review\":[\"marketcap\",\"bitcoin\",\"usdt_out\",\"ethereum\",\"chainlink\",\"polkadot\"],\"btc_metrics\":[\"gray_position\",\"gray_change\",\"sopr\",\"sentiment\",\"ahr999\",\"mvrv\"],\"finance_metrics\":[\"dollar\",\"gold\",\"oil\",\"silver\"],\"plate\":[\"alg\",\"coinbase\",\"gray\",\"ac\",\"defi\",\"belong\",\"nft\",\"dsto\"],\"fgi\":\"\"}";
        HttpEntity<String> entity = new HttpEntity<>(requestBody,headers);


        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class, map);

        return response.getBody();
    }

    @Override
    public String getCommonNewsList(String id) {
        String url = rootUrl + "/v6/information/list?catelogue_key={catelogue_key}&information_id={information_id}&flag={flag}&version={version}&limit={limit}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("catelogue_key", "capitalmarket");
        map.put("information_id", id);
        map.put("flag", "down");
        map.put("version", "9.9.9");
        map.put("limit", "10");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }

    @Override
    public String getCommonNewsDetail(String url) {
        Map<String,String> map=new HashMap<String,String>();

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        String result = response.getBody();

        Document doc =  Jsoup.parse(result);

        return doc.getElementById("article-content").toString();
    }
}
