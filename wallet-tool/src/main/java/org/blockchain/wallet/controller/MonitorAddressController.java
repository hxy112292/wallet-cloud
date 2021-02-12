package org.blockchain.wallet.controller;

import com.github.pagehelper.Page;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.base.BaseResponse;
import org.blockchain.wallet.base.PageResponse;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.dto.blockchain.BlockChainSingleAdr;
import org.blockchain.wallet.dto.blockchain.BlockChainTxs;
import org.blockchain.wallet.entity.MonitorAddress;
import org.blockchain.wallet.dto.blockchair.BlockchairAddrAbstract;
import org.blockchain.wallet.entity.MonitorTxHistory;
import org.blockchain.wallet.resttemplate.BlockChainIRestAPI;
import org.blockchain.wallet.resttemplate.BlockChairIRestAPI;
import org.blockchain.wallet.service.MonitorAddressService;
import org.blockchain.wallet.service.MonitorTxHistoryService;
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

    private final BlockChainIRestAPI blockChainIRestAPI;

    private final MonitorTxHistoryService monitorTxHistoryService;

    @GetMapping
    public List<BlockChainSingleAdr> findSingleAddress(@RequestParam String symbol) {

        MonitorAddress findMonitorAddress = new MonitorAddress();
        findMonitorAddress.setSymbol(symbol);
        List<MonitorAddress> monitorAddressList =  monitorAddressService.selectBySelective(findMonitorAddress);
        List<BlockChainSingleAdr> blockChainSingleAdrList = new ArrayList<>();

        for(MonitorAddress monitorAddress : monitorAddressList) {
            blockChainSingleAdrList.add(blockChainIRestAPI.getSingleAddress(monitorAddress.getAddress()));
        }

        return blockChainSingleAdrList;
    }

    @GetMapping(value = "/address")
    public MonitorAddress findAddressById(@RequestParam int id) {

        return monitorAddressService.selectByPrimaryKey(id);
    }

    @GetMapping(value = "/blockTxs")
    public List<BlockChainTxs> findTxsByBlock(int height) {
        return blockChainIRestAPI.getBlockTxs(height);
    }

    @GetMapping(value = "/history")
    @PreAuthorize("hasRole('VIP')")
    public BaseResponse<Page<MonitorTxHistory>> getAllTxHistory(PageDto pageDto) {

        Page<MonitorTxHistory> txHistoryPage = monitorTxHistoryService.pageBySelective(pageDto);

        return new PageResponse<>(txHistoryPage, txHistoryPage.getTotal());
    }
}
