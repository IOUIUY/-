package com.aic.test;

import com.aic.pojo.Order;
import com.aic.service.OrderService;
import com.aic.service.impl.OrderServiceImpl;
import com.aic.utils.JdbcUtils;
import com.aic.utils.WebUtils;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    OrderService orderService = new OrderServiceImpl();

    @Test
    void addOrder() {
        System.out.println(orderService.addOrder(new Order(null, 2, 5, new Date(), 39)));
        JdbcUtils.commitAndClose();
    }

    @Test
    void removeOrder() {
        System.out.println(orderService.removeOrder(3));
    }

    @Test
    void findOrder() {
        System.out.println(orderService.findOrder(3));
    }

    @Test
    void queryUserOrder() {
        System.out.println(orderService.queryUserOrder(2));
    }

    @Test
    void querySellerOrder() {
        System.out.println(orderService.querySellerOrder(5));
    }
}