package org.blockchain.wallet.service;

import com.github.pagehelper.Page;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.ExchangeCurrency;

/**
 * @author hxy
 */
public interface ExchangeCurrencyService {

    public int insert(ExchangeCurrency exchangeCurrency);

    int update(ExchangeCurrency exchangeCurrency);

    public Page<ExchangeCurrency> pageBySelective(PageDto pageDto);
}
