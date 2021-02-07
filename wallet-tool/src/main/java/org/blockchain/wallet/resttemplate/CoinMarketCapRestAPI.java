package org.blockchain.wallet.resttemplate;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hxy
 */
@Component
@RequiredArgsConstructor
public class CoinMarketCapRestAPI implements CoinMarketCapIRestAPI {

    private final RestTemplate restTemplate;

    @Value("${coinmarketcap.root.url}")
    String rootUrl;

    @Value("${coinmarketcap.api.key}")
    String apiKey;

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getListingLatest() {
        String url = rootUrl + "/v1/cryptocurrency/listings/latest?limit={limit}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("limit","100");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-CMC_PRO_API_KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, map);

        return response.getBody();
    }
}
