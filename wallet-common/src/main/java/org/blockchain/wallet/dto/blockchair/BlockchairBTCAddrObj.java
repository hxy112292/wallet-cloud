/**
  * Copyright 2019 bejson.com 
  */
package org.blockchain.wallet.dto.blockchair;

/**
 * Auto-generated: 2019-05-29 9:41:5
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BlockchairBTCAddrObj {

    private BlockchairAddrAbstract blockchairAddrAbstract;
    private BlockchairData data;
    //private BlockchairContext context;

    public BlockchairAddrAbstract getBlockchairAddrAbstract() {
        return blockchairAddrAbstract;
    }

    public void setBlockchairAddrAbstract(BlockchairAddrAbstract blockchairAddrAbstract) {
        this.blockchairAddrAbstract = blockchairAddrAbstract;
    }

    public void setData(BlockchairData data) {
         this.data = data;
     }
     public BlockchairData getData() {
         return data;
     }

//    public void setContext(BlockchairContext context) {
//         this.context = context;
//     }
//     public BlockchairContext getContext() {
//         return context;
//     }

}