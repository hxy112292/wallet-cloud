package org.blockchain.wallet.service;

import org.blockchain.wallet.entity.ReceiverAddress;

import java.util.List;

/**
 * @author hxy
 */
public interface ReceiverAddressService {

    List<ReceiverAddress> selectBySelective(ReceiverAddress receiverAddress);
}
