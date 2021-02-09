package org.blockchain.wallet.async;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Reference;
import org.blockchain.wallet.constant.Constant;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.CartProduct;
import org.blockchain.wallet.entity.Order;
import org.blockchain.wallet.entity.ReceiverAddress;
import org.blockchain.wallet.entity.User;
import org.blockchain.wallet.resttemplate.EtherscanIRestAPI;
import org.blockchain.wallet.service.OrderService;
import org.blockchain.wallet.service.ReceiverAddressService;
import org.blockchain.wallet.service.UserService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hxy
 */
@RequiredArgsConstructor
@Component
@EnableScheduling
public class MonitorOrderTask {

    @Reference(check = false)
    EtherscanIRestAPI etherscanIRestAPI;

    @Reference(check = false)
    ReceiverAddressService receiverAddressService;

    @Reference(check = false)
    OrderService orderService;

    @Reference(check = false)
    UserService userService;

    @Scheduled(cron = "0 */2 * * * ?")
    public void checkETHReceiveStatus() {

        ReceiverAddress receiverAddress = new ReceiverAddress();
        receiverAddress.setType("ETH");
        String addr = receiverAddressService.selectBySelective(receiverAddress).get(0).getReceiveAddr();
        PageDto pageDto = new PageDto();
        pageDto.setPageNum(1);
        pageDto.setPageSize(Constant.ETHERSCAN_MAX_QPS);
        pageDto.getParamAsMap().put("status", Constant.ORDER_STATUS_PAID);
        Page<Order> page = orderService.pageBySelective(pageDto);
        List<Order> orderList = page.getResult();
        List<String> orderTx = orderList.stream().map(item -> item.getPayNo()).collect(Collectors.toList());
        String res = etherscanIRestAPI.getRopstenTxList(addr);
        JSONObject jsonObject = JSONObject.parseObject(res);
        JSONArray resultList = jsonObject.getJSONArray("result");
        for(int i=0; i<resultList.size(); i++) {
            JSONObject tx = resultList.getJSONObject(i);
            if(orderTx.contains(tx.get("hash").toString()) && Integer.valueOf(tx.get("confirmations").toString()) > 3){
                Order order = orderList.stream().filter(item -> item.getPayNo().equals(tx.get("hash").toString())).collect(Collectors.toList()).get(0);
                BigDecimal fee = new BigDecimal(tx.get("value").toString()).divide(new BigDecimal(1000000000000000000L));
                BigDecimal orderFee = new BigDecimal(order.getTotalFee());
                if(fee.compareTo(orderFee) == 0) {
                    order.setStatus(Constant.ORDER_STATUS_SUCCESS);
                    List<CartProduct> productList = JSONArray.parseArray(JSONArray.toJSONString(order.getProductList()), CartProduct.class);
                    if(productList.get(0).getType().equals(Constant.VIP)) {
                        updateUserRole(order);
                    }
                } else {
                    order.setStatus(Constant.ORDER_STATUS_FAIL);
                }
                orderService.update(order);
            }
        }
    }

    private void updateUserRole(Order order) {
        User user = userService.findUserById(order.getUserId());
        List<String> roles = user.getRole();
        if(!roles.contains(Constant.ROLE_PREFIX + Constant.VIP)) {
            roles.add(Constant.ROLE_PREFIX + Constant.VIP);
            user.setRole(roles);
        }
        Long currentTime = System.currentTimeMillis();
        //VIP时间叠加
        if(user.getVipTime() != null) {
            Long lastVipTime = user.getVipTime().getTime();
            if(lastVipTime > currentTime) {
                currentTime = lastVipTime;
            }
        }
        List<CartProduct> productList = JSONArray.parseArray(JSONArray.toJSONString(order.getProductList()), CartProduct.class);
        if (productList.get(0).getSku().getSku().equals(Constant.VIP_30_DAY)) {
            user.setVipTime(new Date(currentTime + 30L*24*60*60*1000));
        } else if (productList.get(0).equals(Constant.VIP_90_DAY)) {
            user.setVipTime(new Date(currentTime + 90L*24*60*60*1000));
        } else if (productList.get(0).equals(Constant.VIP_90_DAY)) {
            user.setVipTime(new Date(currentTime + 365L*24*60*60*1000));
        }
        userService.updateUser(user);
    }
}
