package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.base.ResultResponse;
import org.blockchain.wallet.entity.HotWeb;
import org.blockchain.wallet.service.HotWebService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/hotWeb")
@RequiredArgsConstructor
public class HotWebController {

    private final HotWebService hotWebService;

    @GetMapping
    public ResultResponse<List<HotWeb>> getHotWeb() {

        return new ResultResponse<>(hotWebService.selectBySelective(new HotWeb()));
    }
}
