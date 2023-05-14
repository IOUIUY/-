package com.aic.test;

import com.aic.pojo.User;
import com.aic.service.UserService;
import com.aic.service.impl.UserServiceImpl;
import com.aic.utils.JdbcUtils;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @org.junit.jupiter.api.Test
    void registerUser() {
        System.out.println(userService.registerUser(new User(1, "jiajia", "jiajia", "aic.com")));
        JdbcUtils.commitAndClose();
    }

    @org.junit.jupiter.api.Test
    void existsUsername() {
        System.out.println(userService.existsUsername("jiajia"));
    }

    @org.junit.jupiter.api.Test
    void login() {
        System.out.println(userService.login(new User(null, "jiajia", "jiajia", null)));
    }

    @org.junit.jupiter.api.Test
    void tem(){
    }
}