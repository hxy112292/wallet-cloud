package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.base.BaseResponse;
import org.blockchain.wallet.base.ResultResponse;
import org.blockchain.wallet.entity.Fcm;
import org.blockchain.wallet.fcm.FcmClient;
import org.blockchain.wallet.service.FcmService;
import org.springframework.web.bind.annotation.*;


/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/fcm")
@RequiredArgsConstructor
public class FcmController {

    private final FcmService fcmService;

    private final FcmClient fcmClient;

    @PostMapping
    public BaseResponse<Integer> registerFcm(@RequestBody Fcm fcm) {
        return new ResultResponse<>(fcmService.register(fcm));
    }

    @GetMapping(value = "/test")
    public BaseResponse<Integer> test() {

        fcmService.sendAllNotification("Hi", "Hello world");
        return new ResultResponse<>(1);
    }
}
