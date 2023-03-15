package com.bowen.springbootmall.dao;

import com.bowen.springbootmall.dto.ProductRequest;
import com.bowen.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProudct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

}
