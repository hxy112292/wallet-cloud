package org.blockchain.wallet.controller;

import com.github.pagehelper.Page;
import lombok.RequiredArgsConstructor;
import org.blockchain.wallet.base.BaseResponse;
import org.blockchain.wallet.base.PageResponse;
import org.blockchain.wallet.base.ResultResponse;
import org.blockchain.wallet.dto.PageDto;
import org.blockchain.wallet.entity.Product;
import org.blockchain.wallet.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hxy
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public BaseResponse<Product> oneById(Integer id) {
        return new ResultResponse<>(productService.oneById(id));
    }

    @GetMapping(value = "list")
    public BaseResponse<Page<Product>> list(PageDto pageDto) {
        Page<Product> productPage = productService.pageBySelective(pageDto);
        return new PageResponse<>(productPage, productPage.getTotal());
    }
}
