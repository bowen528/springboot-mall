package com.bowen.springbootmall.dao;

import com.bowen.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
