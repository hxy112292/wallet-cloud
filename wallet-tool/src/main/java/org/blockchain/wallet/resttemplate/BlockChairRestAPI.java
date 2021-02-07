package org.blockchain.wallet.resttemplate;

import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.blockchair.BlockchairAddrAbstract;
import org.blockchain.wallet.dto.blockchair.BlockchairBTCTxObj;
import org.blockchain.wallet.dto.blockchair.BlockchairBroadcast;
import org.blockchain.wallet.dto.blockchair.BlockchairTxAbstract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author hxy
 */
@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
public class BlockChairRestAPI implements BlockChairIRestAPI {

    @Value("${com.blockchair.monitor.http.rootUrl}")
    String rootUrl;

    private final RestTemplate restTemplate;

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public BlockchairAddrAbstract getBTCAddress(String address) {
        String url =rootUrl + "/bitcoin/dashboards/address/" + address + "?transaction_details={transaction_details}&limit={limit}";

        Map<String, String> map = new HashMap<>();
        map.put("transaction_details", "true");
        map.put("limit", "50,0");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        if(response.getStatusCode().equals(HttpStatus.OK)) {
            String result = response.getBody();

            JSONObject resultMap = JSONObject.parseObject(result);
            String addressJsonStr = resultMap.getJSONObject("data").getJSONObject(address).toString();
            BlockchairAddrAbstract blockchairAddrAbstract = JSONObject.parseObject(addressJsonStr, BlockchairAddrAbstract.class);

            return blockchairAddrAbstract;
        } else {
            logger.error("getBTCAddress failed: " + response.getBody());
            return null;
        }
    }

    @Override
    public BlockchairBTCTxObj getBTCTx(List<String> txidList) {

        String txidListStr = txidList.toString().replaceAll("[\\[ \\]]", "");
        String url =rootUrl + "/bitcoin/dashboards/transactions/" + txidListStr;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        if(response.getStatusCode().equals(HttpStatus.OK)) {
            String result = response.getBody();

            BlockchairBTCTxObj blockchairBTCTxObj = JSONObject.parseObject(result, BlockchairBTCTxObj.class);

            JSONObject resultMap = JSONObject.parseObject(result);

            List<BlockchairTxAbstract> blockchairTxAbstractList = new ArrayList<>();
            for(String txid : txidList) {
                String txJsonStr = resultMap.getJSONObject("data").getJSONObject(txid).toString();
                BlockchairTxAbstract blockchairTxAbstract = JSONObject.parseObject(txJsonStr, BlockchairTxAbstract.class);
                blockchairTxAbstractList.add(blockchairTxAbstract);
            }

            blockchairBTCTxObj.setBlockchairTxAbstractList(blockchairTxAbstractList);

            return blockchairBTCTxObj;
        } else {
            logger.error("getBTCTx failed: " + response.getBody());
            return null;
        }
    }

    @Override
    public String getBTCAddressInfo(String address) {
        String url = rootUrl + "/bitcoin/testnet/dashboards/address/" + address;

        Map<String, String> map = new HashMap<>();
        map.put("transaction_details", "true");
        map.put("limit", "30,30");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }

    @Override
    public String getBTCTxInfo(String txid) {
        String url = rootUrl + "/bitcoin/testnet/dashboards/transaction/" + txid;

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String getBTCFee() {
        String url = rootUrl + "/bitcoin/testnet/stats";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new HashMap<>());

        return response.getBody();
    }

    @Override
    public String broadcastBTC(BlockchairBroadcast blockchairBroadcast) {
        String url = rootUrl + "/bitcoin/testnet/push/transaction";

        String requestBody = JSONObject.toJSONString(blockchairBroadcast);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestBody,headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new HashMap<>());

        return response.getBody();
    }
}
