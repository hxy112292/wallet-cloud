package org.blockchain.wallet.service;

import com.github.pagehelper.Page;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.Product;

/**
 * @author hxy
 */
public interface ProductService {

    Product oneById(Integer id);

    int insert(Product product);

    int update(Product product);

    int delete(Integer id);

    Page<Product> pageBySelective(PageDto pageDto);
}
