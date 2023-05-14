package com.aic.service;

import com.aic.pojo.Item;

import java.util.List;

public interface ItemService {

    public void addItem(Item item);

    public void modifyItem(Integer itemId , Item item);

    public List<Item> showUserItem(Integer userId);

    public List<Item> showAllItem();

    Item findItem(Integer itemId);

    int removeItem(int itemId);

    int addViews(Integer itemId);

    List<Item> recommend();
}
