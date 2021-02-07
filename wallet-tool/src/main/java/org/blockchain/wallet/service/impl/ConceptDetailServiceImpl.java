package org.blockchain.wallet.service.impl;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.entity.ConceptDetail;
import org.blockchain.wallet.mapper.ConceptDetailMapper;
import org.blockchain.wallet.service.ConceptDetailService;
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
public class ConceptDetailServiceImpl implements ConceptDetailService {

    private final ConceptDetailMapper conceptDetailMapper;

    @Override
    public int insertConceptDetail(ConceptDetail conceptDetail) {

        conceptDetail.setCreateTime(new Date());
        return conceptDetailMapper.insert(conceptDetail);
    }
}
