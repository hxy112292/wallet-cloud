package org.blockchain.wallet.resttemplate;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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
public class EtherscanRestAPI implements EtherscanIRestAPI {

    private final RestTemplate restTemplate;

    @Value("${ropsten.etherscan.root.url}")
    String rootTestUrl;

    @Value("${etherscan.root.url}")
    String rootUrl;

    @Value("${ropsten.etherscan.api.key}")
    String apiKey;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    
    @Override
    public String getRopstenAddressInfo(String address) {
        String url = rootTestUrl + "/api?module={module}&action={action}&address={address}&apiKey={apiKey}&tag={tag}";

        Map<String, String> map = new HashMap();

        map.put("module", "account");
        map.put("action", "balance");
        map.put("address", address);
        map.put("apiKey", apiKey);
        map.put("tag", "latest");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }

    
    @Override
    public String getRopstenERC20TxList(String address, String contractAddress) {
        String url = rootTestUrl + "/api?module={module}&action={action}&contractaddress={contractaddress}" +
                "&address={address}&apiKey={apiKey}&sort={sort}";

        Map<String, String> map = new HashMap();

        map.put("module", "account");
        map.put("action", "tokentx");
        map.put("contractaddress", contractAddress);
        map.put("address", address);
        map.put("apiKey", apiKey);
        map.put("sort", "desc");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }

    
    @Override
    public String getRopstenTxList(String address) {

        String url = rootTestUrl + "/api?module={module}&action={action}&address={address}&apiKey={apiKey}&sort={sort}";

        Map<String, String> map = new HashMap();

        map.put("module", "account");
        map.put("action", "txlist");
        map.put("address", address);
        map.put("apiKey", apiKey);
        map.put("sort", "desc");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }

    
    @Override
    public String getAddressInfo(String address) {
        String url = rootUrl + "/api?module={module}&action={action}&address={address}&apiKey={apiKey}&tag={tag}";

        Map<String, String> map = new HashMap();

        map.put("module", "account");
        map.put("action", "balance");
        map.put("address", address);
        map.put("apiKey", apiKey);
        map.put("tag", "latest");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }

    
    @Override
    public String getERC20TxList(String address, String contractAddress) {
        String url = rootUrl + "/api?module={module}&action={action}&contractaddress={contractaddress}" +
                "&address={address}&apiKey={apiKey}&sort={sort}";

        Map<String, String> map = new HashMap();

        map.put("module", "account");
        map.put("action", "tokentx");
        map.put("contractaddress", contractAddress);
        map.put("address", address);
        map.put("apiKey", apiKey);
        map.put("sort", "desc");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }

    
    @Override
    public String getTxList(String address) {

        String url = rootUrl + "/api?module={module}&action={action}&address={address}&apiKey={apiKey}&sort={sort}";

        Map<String, String> map = new HashMap();

        map.put("module", "account");
        map.put("action", "txlist");
        map.put("address", address);
        map.put("apiKey", apiKey);
        map.put("sort", "desc");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }

    
    @Override
    public String getTxInfo(String txId) {
        String url = rootUrl + "/api?module={module}&action={action}&txhash={txhash}&apikey={apikey}";

        Map<String, String> map = new HashMap();

        map.put("module", "transaction");
        map.put("action", "gettxreceiptstatus");
        map.put("txhash", txId);
        map.put("apikey", apiKey);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }
}
