package org.blockchain.wallet.service.impl;

import com.github.pagehelper.Page;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.Order;
import org.blockchain.wallet.mapper.OrderMapper;
import org.blockchain.wallet.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author hxy
 */
@org.apache.dubbo.config.annotation.Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    @Override
    public Order oneById(String id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Order order) {
        order.setCreateTime(new Date());
        return orderMapper.insertSelective(order);
    }

    @Override
    public int update(Order order) {
        order.setUpdateTime(new Date());
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public int delete(String id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<Order> pageBySelective(PageDto pageDto) {
        return orderMapper.selectBySelective(pageDto.putParam().getParamAsMap());
    }
}
