package org.blockchain.wallet.resttemplate;

import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.blockchain.BlockChainSingleAdr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


/**
 * @author hxy
 */
@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
public class BlockChainRestAPI implements BlockChainIRestAPI {

    @Value("${com.blockchain.monitor.http.rootUrl}")
    String rootUrl;

    private final RestTemplate restTemplate;

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public BlockChainSingleAdr getSingleAddress(String address) {
        String url =rootUrl + "/rawaddr/" + address;

        Map<String, Object> map = new HashMap<>();

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        if(response.getStatusCode().equals(HttpStatus.OK)) {
            String result = response.getBody();
            BlockChainSingleAdr blockChainSingleAdr = JSONObject.parseObject(result, BlockChainSingleAdr.class);
            return blockChainSingleAdr;
        } else {
            logger.info("getSingleAddress failed");
            return null;
        }
    }
}
