package org.blockchain.wallet.resttemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.blockchain.BlockChainSingleAdr;
import org.blockchain.wallet.dto.blockchain.BlockChainTxs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
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

    @Override
    public List<BlockChainTxs> getBlockTxs(Integer height) {
        String url =rootUrl + "/block-height/" + height + "?format={format}";

        Map<String, Object> map = new HashMap<>();

        map.put("format", "json");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        if(response.getStatusCode().equals(HttpStatus.OK)) {
            JSONObject result = JSONObject.parseObject(response.getBody());
            JSONArray blocks = result.getJSONArray("blocks");
            JSONArray txs = blocks.getJSONObject(0).getJSONArray("tx");
            List<BlockChainTxs> blockChainTxsList = JSONArray.parseArray(txs.toJSONString(), BlockChainTxs.class);
            return blockChainTxsList;
        } else {
            logger.info("getBlockTxs failed");
            return null;
        }
    }
}
