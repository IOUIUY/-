package com.aic.service;

import com.aic.pojo.Order;
import com.aic.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    public Integer addOrder(Order order);

    public Integer removeOrder(Integer orderId);

    public Order findOrder(Integer orderId);

    public List<OrderItem> queryUserOrder(Integer userId);

    public List<OrderItem> querySellerOrder(Integer sellerId);
}
