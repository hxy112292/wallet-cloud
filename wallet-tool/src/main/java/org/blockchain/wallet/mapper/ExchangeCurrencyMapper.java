package org.blockchain.wallet.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.blockchain.wallet.entity.ExchangeCurrency;

import java.util.Map;

/**
 * @author hxy
 */
@Mapper
public interface ExchangeCurrencyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExchangeCurrency record);

    int insertSelective(ExchangeCurrency record);

    ExchangeCurrency selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExchangeCurrency record);

    int updateByPrimaryKey(ExchangeCurrency record);

    Page<ExchangeCurrency> selectBySelective(Map<String, Object> param);
}
