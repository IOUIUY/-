package com.aic.dao.impl;

import com.aic.dao.CartItemDao;
import com.aic.pojo.CartItem;

import java.util.List;

public class CartItemImpl extends BaseDao implements CartItemDao {
    @Override
    public Integer insertItem(CartItem cartItem) {
        String sql = "insert into t_cart_item(user_id , cargo_id) values(? , ?)";
        return update(sql , cartItem.getUserId(),cartItem.getCargoId());
    }

    @Override
    public Integer deleteItem(Integer itemId) {
        String sql = "delete from t_cart_item where id = ?";
        return update(sql,itemId);
    }

    @Override
    public List<CartItem> queryCartItemsByUserId(Integer userId) {
        String sql = "select id , user_id userId , cargo_id cargoId from t_cart_item where user_id = ?";
        return queryForList(CartItem.class , sql , userId);
    }
}
