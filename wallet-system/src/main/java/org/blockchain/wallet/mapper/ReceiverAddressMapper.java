package org.blockchain.wallet.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.blockchain.wallet.entity.ReceiverAddress;

import java.util.List;

@Mapper
public interface ReceiverAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReceiverAddress record);

    int insertSelective(ReceiverAddress record);

    ReceiverAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReceiverAddress record);

    int updateByPrimaryKey(ReceiverAddress record);

    List<ReceiverAddress> selectBySelective(ReceiverAddress receiverAddress);
}
