package com.bowen.springbootmall.controller;


import com.bowen.springbootmall.dto.CreateOrderRequst;
import com.bowen.springbootmall.model.Order;
import com.bowen.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/users/{userId}/orders")
    public ResponseEntity<?> createOder(@PathVariable Integer userId,
                                        @RequestBody @Valid CreateOrderRequst createOrderRequst){

        Integer orderId = orderService.createOrder(userId,createOrderRequst);

        Order order = orderService.getOrderById(orderId);

        return ResponseEntity.status(HttpStatus.CREATED).body(order);

    }
}
