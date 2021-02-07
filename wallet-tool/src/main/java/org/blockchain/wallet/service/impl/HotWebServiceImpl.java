package org.blockchain.wallet.service.impl;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.entity.HotWeb;
import org.blockchain.wallet.mapper.HotWebMapper;
import org.blockchain.wallet.service.HotWebService;
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
public class HotWebServiceImpl implements HotWebService {

    private final HotWebMapper hotWebMapper;

    @Override
    public List<HotWeb> selectBySelective(HotWeb hotWeb) {
        return hotWebMapper.selectBySelective(hotWeb);
    }
}
