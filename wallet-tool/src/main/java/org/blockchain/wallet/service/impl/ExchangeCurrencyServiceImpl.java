package org.blockchain.wallet.service.impl;

import com.github.pagehelper.Page;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.ExchangeCurrency;
import org.blockchain.wallet.mapper.ExchangeCurrencyMapper;
import org.blockchain.wallet.service.ExchangeCurrencyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author hxy
 */
@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class ExchangeCurrencyServiceImpl implements ExchangeCurrencyService {

    private final ExchangeCurrencyMapper exchangeCurrencyMapper;

    @Override
    public int insert(ExchangeCurrency exchangeCurrency) {
        exchangeCurrency.setCreateTime(new Date());
        return exchangeCurrencyMapper.insertSelective(exchangeCurrency);
    }

    @Override
    public int update(ExchangeCurrency exchangeCurrency) {
        exchangeCurrency.setUpdateTime(new Date());
        return exchangeCurrencyMapper.updateByPrimaryKeySelective(exchangeCurrency);
    }

    @Override
    public Page<ExchangeCurrency> pageBySelective(PageDto pageDto) {
        return exchangeCurrencyMapper.selectBySelective(pageDto.putParam().getParamAsMap());
    }
}
