package com.aic.test;

import com.aic.pojo.Item;
import com.aic.service.ItemService;
import com.aic.service.impl.ItemServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceImplTest {

    ItemService itemService = new ItemServiceImpl();

    @Test
    void addItem() {
        itemService.addItem(new Item(null , "fjls" , "fjdslk" , new BigDecimal(342) , "jfslkj" , 2,null,null));
    }

    @Test
    void modifyItem() {
    }

    @Test
    void showUserItem() {
        System.out.println(itemService.showUserItem(2));
    }
}