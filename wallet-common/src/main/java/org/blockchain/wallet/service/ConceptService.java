package org.blockchain.wallet.service;

import org.blockchain.wallet.entity.Concept;

import java.util.List;

/**
 * @author hxy
 */
public interface ConceptService {

    int insertConcept(Concept concept);

    void backupConcept();

    List<Concept> selectBySelective(Concept concept);
}
