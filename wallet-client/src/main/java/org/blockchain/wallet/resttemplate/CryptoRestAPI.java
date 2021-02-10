package org.blockchain.wallet.resttemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.CryptoBroadcast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
public class CryptoRestAPI implements CryptoIRestAPI {

    private final RestTemplate restTemplate;

    @Value("${crypto.root.url}")
    String rootUrl;

    @Value("${crypto.api.key}")
    String apiKey;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getBCHTestAddressInfo(String address) {
        String url = rootUrl + "/v1/bc/bch/testnet/address/" + address;

        HttpHeaders headers = new HttpHeaders();

        headers.add("X-API-KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getBCHTestTxList(String address) {
        String url = rootUrl + "/v1/bc/bch/testnet/address/" + address + "/unconfirmed-transactions";

        HttpHeaders headers = new HttpHeaders();

        headers.add("X-API-KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new HashMap<>());

        JSONArray result = JSON.parseObject(response.getBody()).getJSONArray("payload");
        List<String> txList = JSON.parseArray(result.toJSONString(), String.class);

        url = rootUrl + "/v1/bc/bch/testnet/address/" + address + "/transactions";

        response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new HashMap<>());

        result = JSON.parseObject(response.getBody()).getJSONArray("payload");

        txList.addAll(JSON.parseArray(result.toJSONString(), String.class));

        return txList.toString();
    }

    @Override
    public String getBCHTestTxInfo(String hash) {
        String url = rootUrl + "/v1/bc/bch/testnet/txs/txid/" + hash;

        HttpHeaders headers = new HttpHeaders();

        headers.add("X-API-KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getBCHTestTxFee() {
        String url = rootUrl + "/v1/bc/bch/testnet/txs/fee";

        HttpHeaders headers = new HttpHeaders();

        headers.add("X-API-KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String broadcastBchTest(CryptoBroadcast cryptoBroadcast) {
        String url = rootUrl + "/v1/bc/bch/testnet/txs/send";

        String requestBody = JSONObject.toJSONString(cryptoBroadcast);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X-API-KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(requestBody,headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getLTCTestTxFee() {
        String url = rootUrl + "/v1/bc/ltc/testnet/txs/fee";

        HttpHeaders headers = new HttpHeaders();

        headers.add("X-API-KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getBTCTestTxFee() {
        String url = rootUrl + "/v1/bc/btc/testnet/txs/fee";

        HttpHeaders headers = new HttpHeaders();

        headers.add("X-API-KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getBCHAddressInfo(String address) {
        String url = rootUrl + "/v1/bc/bch/mainnet/address/" + address;

        HttpHeaders headers = new HttpHeaders();

        headers.add("X-API-KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getBCHTxList(String address) {
        String url = rootUrl + "/v1/bc/bch/mainnet/address/" + address + "/unconfirmed-transactions";

        HttpHeaders headers = new HttpHeaders();

        headers.add("X-API-KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new HashMap<>());

        JSONArray result = JSON.parseObject(response.getBody()).getJSONArray("payload");
        List<String> txList = JSON.parseArray(result.toJSONString(), String.class);

        url = rootUrl + "/v1/bc/bch/testnet/address/" + address + "/transactions";

        response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new HashMap<>());

        result = JSON.parseObject(response.getBody()).getJSONArray("payload");

        txList.addAll(JSON.parseArray(result.toJSONString(), String.class));

        return txList.toString();
    }

    @Override
    public String getBCHTxInfo(String hash) {
        String url = rootUrl + "/v1/bc/bch/mainnet/txs/txid/" + hash;

        HttpHeaders headers = new HttpHeaders();

        headers.add("X-API-KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getBCHTxFee() {
        String url = rootUrl + "/v1/bc/bch/mainnet/txs/fee";

        HttpHeaders headers = new HttpHeaders();

        headers.add("X-API-KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String broadcastBch(CryptoBroadcast cryptoBroadcast) {
        String url = rootUrl + "/v1/bc/bch/mainnet/txs/send";

        String requestBody = JSONObject.toJSONString(cryptoBroadcast);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X-API-KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(requestBody,headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getLTCTxFee() {
        String url = rootUrl + "/v1/bc/ltc/mainnet/txs/fee";

        HttpHeaders headers = new HttpHeaders();

        headers.add("X-API-KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getBTCTxFee() {
        String url = rootUrl + "/v1/bc/btc/mainnet/txs/fee";

        HttpHeaders headers = new HttpHeaders();

        headers.add("X-API-KEY", apiKey);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new HashMap<>());

        return response.getBody();
    }
}
