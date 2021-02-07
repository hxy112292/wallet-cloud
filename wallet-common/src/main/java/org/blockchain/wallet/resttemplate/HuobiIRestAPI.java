package org.blockchain.wallet.resttemplate;

import org.blockchain.wallet.dto.HuobiMarketDetail;

public interface HuobiIRestAPI {
    HuobiMarketDetail getPrice(String symbol);
}
