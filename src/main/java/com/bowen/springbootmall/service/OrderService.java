package com.bowen.springbootmall.service;

import com.bowen.springbootmall.dto.CreateOrderRequst;
import com.bowen.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequst createOrderRequst);
}
