package com.aic.service.impl;

import com.aic.dao.CartItemDao;
import com.aic.dao.impl.CartItemImpl;
import com.aic.pojo.CartItem;
import com.aic.pojo.CartItemDetail;
import com.aic.pojo.Item;
import com.aic.pojo.User;
import com.aic.service.CartItemService;
import com.aic.service.ItemService;
import com.aic.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class CartItemServiceImpl implements CartItemService {

    CartItemDao cartItemDao = new CartItemImpl();
    ItemService itemService = new ItemServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    public Integer addCartItem(CartItem cartItem) {
        return cartItemDao.insertItem(cartItem);
    }

    @Override
    public Integer removeCartItem(Integer cartItemId) {
        return cartItemDao.deleteItem(cartItemId);
    }

    @Override
    public List<CartItemDetail> showUserCartItems(Integer userId) {
        List<CartItem> cartItems = cartItemDao.queryCartItemsByUserId(userId);
        List<CartItemDetail> cartItemDetails = new ArrayList<>();
        for(CartItem cartItem : cartItems){
            Item item = itemService.findItem(cartItem.getCargoId());
            User user = userService.findUserById(item.getSellerId());
            CartItemDetail cartItemDetail = new CartItemDetail(cartItem.getId(),cartItem.getUserId(),cartItem.getCargoId(),item.getName(),user.getUsername(),item.getPrice(), item.getDetail(),item.getImgPath());
            cartItemDetails.add(cartItemDetail);
        }
        return cartItemDetails;
    }
}
