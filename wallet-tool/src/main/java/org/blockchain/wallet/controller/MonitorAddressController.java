package org.blockchain.wallet.controller;

import com.github.pagehelper.Page;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.base.BaseResponse;
import org.blockchain.wallet.base.PageResponse;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.MonitorAddress;
import org.blockchain.wallet.entity.TxHistory;
import org.blockchain.wallet.dto.blockchair.BlockchairAddrAbstract;
import org.blockchain.wallet.resttemplate.BlockChairIRestAPI;
import org.blockchain.wallet.service.MonitorAddressService;
import org.blockchain.wallet.service.TxHistoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/monitorAddress")
@RequiredArgsConstructor
public class MonitorAddressController {

    private final MonitorAddressService monitorAddressService;

    private final BlockChairIRestAPI blockChairIRestAPI;

    private final TxHistoryService txHistoryService;

    @GetMapping
    public List<BlockchairAddrAbstract> findSingleAddress(@RequestParam String symbol) {

        MonitorAddress findMonitorAddress = new MonitorAddress();
        findMonitorAddress.setSymbol(symbol);
        List<MonitorAddress> monitorAddressList =  monitorAddressService.selectBySelective(findMonitorAddress);
        List<BlockchairAddrAbstract> blockchairAddrAbstracts = new ArrayList<>();

        for(MonitorAddress monitorAddress : monitorAddressList) {
            blockchairAddrAbstracts.add(blockChairIRestAPI.getBTCAddress(monitorAddress.getAddress()));
        }

        return blockchairAddrAbstracts;
    }

    @GetMapping(value = "/address")
    public MonitorAddress findAddressById(@RequestParam int id) {

        return monitorAddressService.selectByPrimaryKey(id);
    }

    @GetMapping(value = "/history")
    @PreAuthorize("hasRole('VIP')")
    public BaseResponse<Page<TxHistory>> getAllTxHistory(PageDto pageDto) {

        Page<TxHistory> txHistoryPage = txHistoryService.pageBySelective(pageDto);

        return new PageResponse<>(txHistoryPage, txHistoryPage.getTotal());
    }
}
