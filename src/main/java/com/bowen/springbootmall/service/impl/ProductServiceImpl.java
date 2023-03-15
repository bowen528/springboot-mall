package com.bowen.springbootmall.service.impl;


import com.bowen.springbootmall.dao.ProductDao;
import com.bowen.springbootmall.dto.ProductRequest;
import com.bowen.springbootmall.model.Product;
import com.bowen.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProudct(ProductRequest productRequest) {
        return productDao.createProudct(productRequest) ;
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId,productRequest);
    }
}
