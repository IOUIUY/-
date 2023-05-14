package com.aic.service.impl;

import com.aic.dao.OrderDao;
import com.aic.dao.impl.OrderDaoImpl;
import com.aic.pojo.Item;
import com.aic.pojo.Order;
import com.aic.pojo.OrderItem;
import com.aic.pojo.User;
import com.aic.service.ItemService;
import com.aic.service.OrderService;
import com.aic.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();
    UserService userService = new UserServiceImpl();
    ItemService itemService = new ItemServiceImpl();

    @Override
    public Integer addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    public Integer removeOrder(Integer orderId) {
        return orderDao.deleteOrder(orderId);
    }

    @Override
    public Order findOrder(Integer orderId) {
        return orderDao.queryOrderById(orderId);
    }

    @Override
    public List<OrderItem> queryUserOrder(Integer userId) {
        List<OrderItem> orderItemList = new ArrayList<>();
        List<Order> orders = orderDao.queryOrderByUserId(userId);
        for(Order order : orders){
            OrderItem orderItem = new OrderItem();
            User user = userService.findUserById(order.getUserId());
            orderItem.setId(order.getId());
            orderItem.setUserId(user.getId());
            orderItem.setUsername(user.getUsername());
            orderItem.setSellerId(order.getSellerId());
            orderItem.setSellerName(userService.findUserById(order.getSellerId()).getUsername());
            Item item = itemService.findItem(order.getCargoId());
            orderItem.setCargoId(item.getId());
            orderItem.setName(item.getName());
            orderItem.setPrice(item.getPrice());
            orderItem.setDetail(item.getDetail());
            orderItem.setCreateTime(order.getCreateTime());
            orderItem.setImgPath(item.getImgPath());

            orderItemList.add(orderItem);
        }
        return orderItemList;
    }

    @Override
    public List<OrderItem> querySellerOrder(Integer sellerId) {
        List<OrderItem> orderItemList = new ArrayList<>();
        List<Order> orders = orderDao.queryOrderBySellerId(sellerId);
        for(Order order : orders){
            OrderItem orderItem = new OrderItem();
            User user = userService.findUserById(order.getUserId());
            orderItem.setId(order.getId());
            orderItem.setUserId(user.getId());
            orderItem.setUsername(user.getUsername());
            orderItem.setSellerId(order.getSellerId());
            orderItem.setSellerName(userService.findUserById(order.getSellerId()).getUsername());
            Item item = itemService.findItem(order.getCargoId());
            orderItem.setCargoId(item.getId());
            orderItem.setName(item.getName());
            orderItem.setPrice(item.getPrice());
            orderItem.setDetail(item.getDetail());
            orderItem.setCreateTime(order.getCreateTime());
            orderItem.setImgPath(item.getImgPath());

            orderItemList.add(orderItem);
        }
        return orderItemList;
    }
}
