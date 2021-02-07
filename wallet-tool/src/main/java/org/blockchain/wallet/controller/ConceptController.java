package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.resttemplate.DNCIRestAPI;
import org.blockchain.wallet.service.ConceptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/concept")
@RequiredArgsConstructor
public class ConceptController {

    private final DNCIRestAPI dncIRestAPI;

    private final ConceptService conceptService;

    @GetMapping
    public String getConcepList(String sort) {
        return dncIRestAPI.getConceptList(sort);
    }

    @GetMapping(value = "detail")
    public String getConceptDetail(@RequestParam String id) {
        return dncIRestAPI.getConceptDetail(id);
    }

    @GetMapping(value = "backup")
    public void backupConcept() {
        conceptService.backupConcept();
    }
}
