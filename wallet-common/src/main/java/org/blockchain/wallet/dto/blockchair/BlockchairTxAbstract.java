/**
 * Copyright 2019 bejson.com
 */
package org.blockchain.wallet.dto.blockchair;
import java.io.Serializable;
import java.util.List;

/**
 * Auto-generated: 2019-05-29 10:1:48
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BlockchairTxAbstract implements Serializable {

    private BlockchairTx transaction;
    private List<BlockchairInputOrOutput> inputs;
    private List<BlockchairInputOrOutput> outputs;

    public void setTransaction(BlockchairTx transaction) {
        this.transaction = transaction;
    }
    public BlockchairTx getTransaction() {
        return transaction;
    }

    public List<BlockchairInputOrOutput> getInputs() {
        return inputs;
    }

    public void setInputs(List<BlockchairInputOrOutput> inputs) {
        this.inputs = inputs;
    }

    public List<BlockchairInputOrOutput> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<BlockchairInputOrOutput> outputs) {
        this.outputs = outputs;
    }
}
