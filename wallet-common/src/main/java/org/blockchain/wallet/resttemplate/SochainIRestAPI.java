package org.blockchain.wallet.resttemplate;

import org.blockchain.wallet.dto.SochainBroadcast;

public interface SochainIRestAPI {
    String getLTCTestAddressInfo(String address);

    String getLTCTestTxInfo(String txid);

    String getLTCTESTUnSpentTxInfo(String address);

    String broadcastLTCTest(SochainBroadcast sochainBroadcast);

    String getBTCTESTAddressInfo(String address);

    String getBTCTESTTxInfo(String txid);

    String getBTCTESTUnSpentTxInfo(String address);

    String broadcastBTCTEST(SochainBroadcast sochainBroadcast);

    String getBTCTxInfo(String txid);

    String getLTCAddressInfo(String address);

    String getLTCTxInfo(String txid);

    String getLTCUnSpentTxInfo(String address);

    String broadcastLTC(SochainBroadcast sochainBroadcast);

    String getBTCAddressInfo(String address);

    String getBTCUnSpentTxInfo(String address);

    String broadcastBTC(SochainBroadcast sochainBroadcast);
}
