package com.aic.dao.impl;

import com.aic.dao.OrderDao;
import com.aic.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public Integer addOrder(Order order) {
        String sql = "insert into t_order(user_id , seller_id , create_time , cargo_id) values(? , ? , ? , ?)";
        return update(sql,order.getUserId(),order.getSellerId(),order.getCreateTime(),order.getCargoId());
    }

    @Override
    public Integer deleteOrder(Integer orderId) {
        String sql = "delete from t_order where id = ?";
        return update(sql , orderId);
    }

    @Override
    public Order queryOrderById(Integer orderId) {
        String sql = "select id , user_id userId , seller_id sellerId , cargo_id cargoId , create_time createTime from t_order where id = ?";
        return queryForOne(Order.class , sql , orderId);
    }

    @Override
    public List<Order> queryOrderByUserId(Integer userId) {
        String sql = "select id , user_id userId , seller_id sellerId , cargo_id cargoId , create_time createTime from t_order where user_id = ?";
        return queryForList(Order.class , sql,userId);
    }

    @Override
    public List<Order> queryOrderBySellerId(Integer sellerId) {
        String sql = "select id , user_id userId , seller_id sellerId , cargo_id cargoId , create_time createTime from t_order where seller_id = ?";
        return queryForList(Order.class,sql,sellerId);
    }
}
