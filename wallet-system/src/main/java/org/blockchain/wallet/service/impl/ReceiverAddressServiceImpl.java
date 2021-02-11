package org.blockchain.wallet.service.impl;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.entity.ReceiverAddress;
import org.blockchain.wallet.mapper.ReceiverAddressMapper;
import org.blockchain.wallet.service.ReceiverAddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hxy
 */
@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class ReceiverAddressServiceImpl implements ReceiverAddressService {

    private final ReceiverAddressMapper receiverAddressMapper;

    @Override
    public List<ReceiverAddress> selectBySelective(ReceiverAddress receiverAddress) {
        return receiverAddressMapper.selectBySelective(receiverAddress);
    }
}
