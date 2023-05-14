package com.aic.dao;

import com.aic.pojo.Item;

import java.util.List;

public interface ItemDao {

    public int saveItem(Item item);

    public int modifyItem(Integer itemId,Item item);

    public List<Item> queryItemByUserId(Integer userId);

    public List<Item> queryAllItems();

    Item queryItemById(Integer itemId);

    int deleteItemById(int itemId);

    List<Item> recommend();
}
