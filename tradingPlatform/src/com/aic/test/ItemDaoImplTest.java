package com.aic.test;

import com.aic.dao.ItemDao;
import com.aic.dao.impl.ItemDaoImpl;
import com.aic.pojo.Item;
import com.aic.utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ItemDaoImplTest {
    ItemDao itemDao = new ItemDaoImpl();

    @Test
    void saveItem() {
        System.out.println(itemDao.saveItem(new Item(null,"自行车", "九成新", new BigDecimal(24.5), "dfsdf/sdfjlsj/sdfjlsj", 2,null,null)));
        JdbcUtils.commitAndClose();
    }

    @Test
    void modifyItem() {
        System.out.println(itemDao.modifyItem(3 ,new Item(null,"自行车", "九九成新", new BigDecimal(24.5), "dfsdf/sdfjlsj/sdfjlsj", 2,null,null)));
        JdbcUtils.commitAndClose();
    }

    @Test
    void queryItemByUserId() {
        System.out.println(itemDao.queryItemByUserId(2));
    }

    @Test
    void queryAllItems(){
        System.out.println(itemDao.queryAllItems());
    }
}