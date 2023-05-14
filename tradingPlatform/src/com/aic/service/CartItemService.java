package com.aic.service;

import com.aic.pojo.CartItem;
import com.aic.pojo.CartItemDetail;

import java.util.List;

public interface CartItemService {
    public Integer addCartItem(CartItem cartItem);

    public Integer removeCartItem(Integer cartItemId);

    public List<CartItemDetail> showUserCartItems(Integer userId);
}
