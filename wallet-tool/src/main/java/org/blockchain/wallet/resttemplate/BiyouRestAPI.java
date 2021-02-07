package org.blockchain.wallet.resttemplate;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @author hxy
 */
@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
public class BiyouRestAPI implements BiyouIRestAPI {

    private final RestTemplate restTemplate;

    @Value("${biyou.root.url}")
    String rootUrl;


    @Override
    public String getExchangeCurrencyRank() {

        String url = rootUrl + "/coincap/query_markets_rank_with_reserves";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        return response.getBody();
    }
}
