package com.aic.dao;

import com.aic.pojo.Order;

import java.util.List;

public interface OrderDao {
    public Integer addOrder(Order order);

    public Integer deleteOrder(Integer orderId);

    public Order queryOrderById(Integer orderId);

    public List<Order> queryOrderByUserId(Integer userId);

    public List<Order> queryOrderBySellerId(Integer sellerId);
}
