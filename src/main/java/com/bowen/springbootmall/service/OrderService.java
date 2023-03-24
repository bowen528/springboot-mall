package com.bowen.springbootmall.service;

import com.bowen.springbootmall.dto.CreateOrderRequst;
import com.bowen.springbootmall.dto.OrderQueryParams;
import com.bowen.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequst createOrderRequst);
}
