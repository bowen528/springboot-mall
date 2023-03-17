package com.bowen.springbootmall.service;

import com.bowen.springbootmall.constant.ProductCategory;
import com.bowen.springbootmall.dto.ProductRequest;
import com.bowen.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductCategory category,String search);

    Product getProductById(Integer productId);

    Integer createProudct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);


}
