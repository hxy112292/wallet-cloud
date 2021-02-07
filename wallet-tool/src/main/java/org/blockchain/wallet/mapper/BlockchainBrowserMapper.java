package org.blockchain.wallet.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.blockchain.wallet.entity.BlockchainBrowser;

import java.util.List;

/**
 * @author hxy
 */
@Mapper
public interface BlockchainBrowserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlockchainBrowser record);

    int insertSelective(BlockchainBrowser record);

    BlockchainBrowser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlockchainBrowser record);

    int updateByPrimaryKey(BlockchainBrowser record);

    List<BlockchainBrowser> selectBySelective(BlockchainBrowser record);
}
