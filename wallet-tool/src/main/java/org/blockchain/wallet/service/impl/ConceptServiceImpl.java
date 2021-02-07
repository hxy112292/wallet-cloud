package org.blockchain.wallet.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.entity.Concept;
import org.blockchain.wallet.entity.ConceptDetail;
import org.blockchain.wallet.entity.ConceptDto;
import org.blockchain.wallet.mapper.ConceptDetailMapper;
import org.blockchain.wallet.mapper.ConceptMapper;
import org.blockchain.wallet.resttemplate.DNCIRestAPI;
import org.blockchain.wallet.service.ConceptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author hxy
 */
@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class ConceptServiceImpl implements ConceptService {

    private final ConceptMapper conceptMapper;

    private final ConceptDetailMapper conceptDetailMapper;

    private final DNCIRestAPI dncIRestAPI;

    @Override
    public int insertConcept(Concept concept) {

        concept.setCreateTime(new Date());
        return conceptMapper.insert(concept);
    }

    @Override
    public void backupConcept() {
        String conceptListStr = JSONObject.parseObject(dncIRestAPI.getConceptList("change")).getJSONArray("data").toJSONString();
        List<ConceptDto> conceptDtoList = JSONObject.parseArray(conceptListStr, ConceptDto.class);
        for(ConceptDto conceptDto : conceptDtoList) {
            Concept concept = new Concept();
            concept.setConceptId(conceptDto.getId());
            concept.setName(conceptDto.getName());
            if(conceptMapper.selectBySelective(concept).size() == 0) {
                insertConcept(concept);
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String conceptDetailListStr = JSONObject.parseObject(dncIRestAPI.getConceptDetail(conceptDto.getId())).getJSONArray("data").toJSONString();
            List<ConceptDetail> conceptDetailList = JSONObject.parseArray(conceptDetailListStr, ConceptDetail.class);
            for(ConceptDetail conceptDetail : conceptDetailList) {
                conceptDetail.setConceptId(conceptDto.getId());
                if(conceptDetailMapper.selectBySelective(conceptDetail).size() == 0) {
                    conceptDetail.setCreateTime(new Date());
                    conceptDetailMapper.insert(conceptDetail);
                }
            }
        }
    }

    @Override
    public List<Concept> selectBySelective(Concept concept) {
        return conceptMapper.selectBySelective(concept);
    }
}
