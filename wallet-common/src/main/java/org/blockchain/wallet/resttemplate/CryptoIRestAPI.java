package org.blockchain.wallet.resttemplate;

import org.blockchain.wallet.dto.CryptoBroadcast;

public interface CryptoIRestAPI {
    String getBCHTestAddressInfo(String address);

    String getBCHTestTxList(String address);

    String getBCHTestTxInfo(String hash);

    String getBCHTestTxFee();

    String broadcastBchTest(CryptoBroadcast cryptoBroadcast);

    String getLTCTestTxFee();

    String getBTCTestTxFee();

    String getBCHAddressInfo(String address);

    String getBCHTxList(String address);

    String getBCHTxInfo(String hash);

    String getBCHTxFee();

    String broadcastBch(CryptoBroadcast cryptoBroadcast);

    String getLTCTxFee();

    String getBTCTxFee();
}
