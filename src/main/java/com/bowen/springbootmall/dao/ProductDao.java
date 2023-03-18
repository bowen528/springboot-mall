package com.bowen.springbootmall.dao;

import com.bowen.springbootmall.constant.ProductCategory;
import com.bowen.springbootmall.dto.ProductQueryParams;
import com.bowen.springbootmall.dto.ProductRequest;
import com.bowen.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProudct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
