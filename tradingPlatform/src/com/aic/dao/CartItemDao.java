package com.aic.dao;

import com.aic.pojo.CartItem;

import java.util.List;

public interface CartItemDao {
    public Integer insertItem(CartItem cartItem);

    public Integer deleteItem(Integer itemId);

    public List<CartItem> queryCartItemsByUserId(Integer userId);
}
