package com.bowen.springbootmall.service.impl;

import com.bowen.springbootmall.dao.OrderDao;
import com.bowen.springbootmall.dao.ProductDao;
import com.bowen.springbootmall.dao.UserDao;
import com.bowen.springbootmall.dto.BuyItem;
import com.bowen.springbootmall.dto.CreateOrderRequst;
import com.bowen.springbootmall.model.Order;
import com.bowen.springbootmall.model.OrderItem;
import com.bowen.springbootmall.model.Product;
import com.bowen.springbootmall.model.User;
import com.bowen.springbootmall.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceimpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    private final static Logger log = LoggerFactory.getLogger(OrderServiceimpl.class);

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);

        order.setOrderItemList(orderItemList);

        return order;
    }

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequst createOrderRequst) {
        //檢查 user 是否存在
        User user = userDao.getUserById(userId);

        if(user == null){
            log.warn("此 userId {} 不存在", userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();
        for(BuyItem buyItem : createOrderRequst.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());

            //檢查 product 是否存在、庫存是否足夠
            if(product == null){
                log.warn("商品 {} 不存在",buyItem.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }else if(product.getStock() < buyItem.getQuantity()){
                log.warn("商品 {} 庫存數量不足，無法購買。 剩餘庫存 {} ，欲購買數量 {} ",
                        buyItem.getProductId(),product.getStock(),buyItem.getQuantity());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            //扣除商品庫存
            productDao.updateStock(product.getProductId(),product.getStock() - buyItem.getQuantity());

            //計算總價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            //轉換 BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }


        //創建訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);
        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }
}
