package com.bowen.springbootmall.service;

import com.bowen.springbootmall.dto.CreateOrderRequst;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequst createOrderRequst);
}
