package org.blockchain.wallet.controller;

import com.github.pagehelper.Page;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.base.BaseResponse;
import org.blockchain.wallet.base.PageResponse;
import org.blockchain.wallet.base.ResultResponse;
import org.blockchain.wallet.constant.Constant;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.Order;
import org.blockchain.wallet.entity.ReceiverAddress;
import org.blockchain.wallet.service.OrderService;
import org.blockchain.wallet.service.ReceiverAddressService;
import org.blockchain.wallet.util.UUIDUtil;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final ReceiverAddressService receiverAddressService;

    @GetMapping
    public BaseResponse<Order> oneById(String id) {
        return new ResultResponse<>(orderService.oneById(id));
    }

    @GetMapping(value = "list")
    public BaseResponse<Page<Order>> list(PageDto pageDto, Authentication auth) {
        pageDto.getParamAsMap().put("userId", auth.getPrincipal());
        Page<Order> orderPage = orderService.pageBySelective(pageDto);
        return new PageResponse<>(orderPage, orderPage.getTotal());
    }

    @GetMapping(value = "/receiverAddr")
    public BaseResponse<ReceiverAddress> getReceiverAddr() {
        return new ResultResponse<>(receiverAddressService.selectBySelective(new ReceiverAddress()).get(0));
    }

    @PostMapping(value = "/pay")
    public BaseResponse<Order> pay(@RequestBody Order order, Authentication auth) {
        order.setUserId((Integer)auth.getPrincipal());
        order.setStatus(Constant.ORDER_STATUS_PAID);
        order.setPaymentTime(new Date());
        orderService.update(order);
        return new ResultResponse<>(orderService.oneById(order.getId()));
    }

    @PostMapping
    public BaseResponse<Order> insert(@RequestBody Order order, Authentication auth) {
        order.setUserId((Integer)auth.getPrincipal());
        order.setStatus(Constant.ORDER_STATUS_PAID);
        String orderId = UUIDUtil.getUUID();
        order.setId(orderId);
        orderService.insert(order);
        return new ResultResponse<>(orderService.oneById(orderId));
    }

    @PutMapping
    public BaseResponse<Order> update(@RequestBody Order order, Authentication auth) {
        order.setUserId((Integer)auth.getPrincipal());
        orderService.update(order);
        return new ResultResponse<>(orderService.oneById(order.getId()));
    }
}
