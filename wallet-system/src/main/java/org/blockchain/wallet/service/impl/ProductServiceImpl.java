package org.blockchain.wallet.service.impl;

import com.github.pagehelper.Page;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.Product;
import org.blockchain.wallet.mapper.ProductMapper;
import org.blockchain.wallet.service.ProductService;
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
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Override
    public Product oneById(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Product product) {
        product.setCreateTime(new Date());
        return productMapper.insertSelective(product);
    }

    @Override
    public int update(Product product) {
        product.setUpdateTime(new Date());
        return productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public int delete(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<Product> pageBySelective(PageDto pageDto) {
        return productMapper.selectBySelective(pageDto.putParam().getParamAsMap());
    }
}
