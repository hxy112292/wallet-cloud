package org.blockchain.wallet.resttemplate;

import org.blockchain.wallet.dto.blockchair.BlockchairAddrAbstract;
import org.blockchain.wallet.dto.blockchair.BlockchairBTCTxObj;
import org.blockchain.wallet.dto.blockchair.BlockchairBroadcast;

import java.util.List;

public interface BlockChairIRestAPI {
    BlockchairAddrAbstract getBTCAddress(String address);

    BlockchairBTCTxObj getBTCTx(List<String> txidList);

    String getBTCAddressInfo(String address);

    String getBTCTxInfo(String txid);

    String getBTCFee();

    String broadcastBTC(BlockchairBroadcast blockchairBroadcast);
}
