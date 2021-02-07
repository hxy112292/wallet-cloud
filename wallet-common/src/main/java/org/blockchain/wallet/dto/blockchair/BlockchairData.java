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
public class BlockchairData implements Serializable {

    private List<BlockchairOmni> _omni;

    public void set_omni(List<BlockchairOmni> _omni) {
        this._omni = _omni;
    }
    public List<BlockchairOmni> get_omni() {
        return _omni;
    }

}
