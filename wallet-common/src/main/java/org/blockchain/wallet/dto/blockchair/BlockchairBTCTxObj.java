/**
 * Copyright 2019 bejson.com
 */
package org.blockchain.wallet.dto.blockchair;

import java.io.Serializable;
import java.util.List;

/**
 * Auto-generated: 2019-05-29 9:41:5
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BlockchairBTCTxObj implements Serializable {

    private List<BlockchairTxAbstract> blockchairTxAbstractList;
    private BlockchairData data;
//    private BlockchairContext context;

    public List<BlockchairTxAbstract> getBlockchairTxAbstractList() {
        return blockchairTxAbstractList;
    }

    public void setBlockchairTxAbstractList(List<BlockchairTxAbstract> blockchairTxAbstractList) {
        this.blockchairTxAbstractList = blockchairTxAbstractList;
    }

    public void setData(BlockchairData data) {
        this.data = data;
    }
    public BlockchairData getData() {
        return data;
    }

//    public void setContext(BlockchairContext context) {
//        this.context = context;
//    }
//    public BlockchairContext getContext() {
//        return context;
//    }

}
