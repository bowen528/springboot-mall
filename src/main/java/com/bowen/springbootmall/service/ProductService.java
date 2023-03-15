package com.bowen.springbootmall.service;

import com.bowen.springbootmall.dto.ProductRequest;
import com.bowen.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProudct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
