package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.base.BaseResponse;
import org.blockchain.wallet.base.ResultResponse;
import org.blockchain.wallet.resttemplate.JinseIRestAPI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/liveNews")
@RequiredArgsConstructor
public class LiveNewsController {

    private final JinseIRestAPI jinseIRestAPI;

    @GetMapping
    public Object getLiveNews(@RequestParam(value = "id", required = false) String id) {
        if(id == null) {
            return jinseIRestAPI.getLive("");
        } else {
            return jinseIRestAPI.getLive(id);
        }

    }

    @GetMapping(value = "/deep")
    public Object getDeepNewsList(@RequestParam(value = "id", required = false) String id) {
        if(id == null) {
            return jinseIRestAPI.getDeepNewsList("");
        } else {
            return jinseIRestAPI.getDeepNewsList(id);
        }

    }

    @GetMapping(value = "/deep/detail")
    public BaseResponse<String> getDeepNewsDetail(@RequestParam String url) {
        return new ResultResponse<>(jinseIRestAPI.getDeepNewsDetail(url));
    }
}
