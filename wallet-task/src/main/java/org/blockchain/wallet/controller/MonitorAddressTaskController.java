package org.blockchain.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.async.MonitorBlockchainAddrTask;
import org.blockchain.wallet.constant.Constant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hxy
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "monitorAddressTask")
public class MonitorAddressTaskController {

    private final MonitorBlockchainAddrTask monitorBlockchainAddrTask;

    @GetMapping(value = "monitorBTC")
    public String monitorBTC() {
        monitorBlockchainAddrTask.monitorBlockChainAddress();
        return Constant.SUCCESS;
    }
}
