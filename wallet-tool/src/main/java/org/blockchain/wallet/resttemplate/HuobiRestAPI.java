package org.blockchain.wallet.resttemplate;

import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.HuobiMarketDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
public class HuobiRestAPI implements HuobiIRestAPI {

    private final RestTemplate restTemplate;

    @Value("${huobi.root.url}")
    String rootUrl;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public HuobiMarketDetail getPrice(String symbol) {
        String url = rootUrl + "/market/detail?symbol={symbol}";

        Map<String,String> map=new HashMap<String,String>();
        map.put("symbol",symbol);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        String result = response.getBody();

        String tick = JSONObject.parseObject(result).getJSONObject("tick").toJSONString();

        HuobiMarketDetail huobiMarketDetail = JSONObject.parseObject(tick, HuobiMarketDetail.class);

        return huobiMarketDetail;
    }
}
