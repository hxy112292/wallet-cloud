package org.blockchain.wallet.service;

import com.github.pagehelper.Page;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.Order;

/**
 * @author hxy
 */
public interface OrderService {

    Order oneById(String id);

    int insert(Order order);

    int update(Order order);

    int delete(String id);

    Page<Order> pageBySelective(PageDto pageDto);
}
