package org.blockchain.wallet.resttemplate;

import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.SochainBroadcast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @author hxy
 */
@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
public class SochainRestAPI implements SochainIRestAPI {

    private final RestTemplate restTemplate;

    @Value("${sochain.root.url}")
    String rootUrl;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getLTCTestAddressInfo(String address) {
        String url = rootUrl + "/api/v2/address/LTCTEST/" + address;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getLTCTestTxInfo(String txid) {
        String url = rootUrl + "/api/v2/tx/LTCTEST/" + txid;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getLTCTESTUnSpentTxInfo(String address) {
        String url = rootUrl + "/api/v2/get_tx_unspent/LTCTEST/" + address;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String broadcastLTCTest(SochainBroadcast sochainBroadcast) {
        String url = rootUrl + "/api/v2/send_tx/LTCTEST";

        String requestBody = JSONObject.toJSONString(sochainBroadcast);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestBody,headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getBTCTESTAddressInfo(String address) {
        String url = rootUrl + "/api/v2/address/BTCTEST/" + address;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getBTCTESTTxInfo(String txid) {
        String url = rootUrl + "/api/v2/tx/BTCTEST/" + txid;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getBTCTESTUnSpentTxInfo(String address) {
        String url = rootUrl + "/api/v2/get_tx_unspent/BTCTEST/" + address;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String broadcastBTCTEST(SochainBroadcast sochainBroadcast) {
        String url = rootUrl + "/api/v2/send_tx/BTCTEST";

        String requestBody = JSONObject.toJSONString(sochainBroadcast);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestBody,headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getBTCTxInfo(String txid) {
        String url = rootUrl + "/api/v2/tx/BTC/" + txid;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getLTCAddressInfo(String address) {
        String url = rootUrl + "/api/v2/address/LTC/" + address;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getLTCTxInfo(String txid) {
        String url = rootUrl + "/api/v2/tx/LTC/" + txid;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getLTCUnSpentTxInfo(String address) {
        String url = rootUrl + "/api/v2/get_tx_unspent/LTC/" + address;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String broadcastLTC(SochainBroadcast sochainBroadcast) {
        String url = rootUrl + "/api/v2/send_tx/LTC";

        String requestBody = JSONObject.toJSONString(sochainBroadcast);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestBody,headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getBTCAddressInfo(String address) {
        String url = rootUrl + "/api/v2/address/BTC/" + address;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getBTCUnSpentTxInfo(String address) {
        String url = rootUrl + "/api/v2/get_tx_unspent/BTC/" + address;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String broadcastBTC(SochainBroadcast sochainBroadcast) {
        String url = rootUrl + "/api/v2/send_tx/BTC";

        String requestBody = JSONObject.toJSONString(sochainBroadcast);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestBody,headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new HashMap<>());

        return response.getBody();
    }
}
