package com.aic.test;

import com.aic.pojo.CartItem;
import com.aic.service.CartItemService;
import com.aic.service.impl.CartItemServiceImpl;
import com.aic.utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartItemServiceImplTest {

    CartItemService cartItemService = new CartItemServiceImpl();

    @Test
    void addCartItem() {
        System.out.println(cartItemService.addCartItem(new CartItem(null, 2, 13)));
        JdbcUtils.commitAndClose();
    }

    @Test
    void removeCartItem() {
        System.out.println(cartItemService.removeCartItem(2));
        JdbcUtils.commitAndClose();
    }

    @Test
    void showUserCartItems() {
        System.out.println(cartItemService.showUserCartItems(2));
    }
}