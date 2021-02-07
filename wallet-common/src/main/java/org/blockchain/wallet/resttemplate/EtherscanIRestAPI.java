package org.blockchain.wallet.resttemplate;

public interface EtherscanIRestAPI {
    String getRopstenAddressInfo(String address);

    String getRopstenERC20TxList(String address, String contractAddress);

    String getRopstenTxList(String address);

    String getAddressInfo(String address);

    String getERC20TxList(String address, String contractAddress);

    String getTxList(String address);

    String getTxInfo(String txId);
}
