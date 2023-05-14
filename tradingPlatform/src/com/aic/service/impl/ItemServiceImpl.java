package com.aic.service.impl;

import com.aic.dao.ItemDao;
import com.aic.dao.impl.ItemDaoImpl;
import com.aic.pojo.Item;
import com.aic.service.ItemService;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    ItemDao itemDao = new ItemDaoImpl();

    @Override
    public void addItem(Item item) {
        itemDao.saveItem(item);
    }

    @Override
    public void modifyItem(Integer itemId, Item item) {
        itemDao.modifyItem(itemId,item);
    }

    @Override
    public List<Item> showUserItem(Integer userId) {
        return itemDao.queryItemByUserId(userId);
    }

    @Override
    public List<Item> showAllItem() {
        return itemDao.queryAllItems();
    }

    @Override
    public Item findItem(Integer itemId) {
        return itemDao.queryItemById(itemId);
    }

    @Override
    public int removeItem(int itemId) {
        return itemDao.deleteItemById(itemId);
    }

    @Override
    public int addViews(Integer itemId) {
        Item item = itemDao.queryItemById(itemId);
        item.setViews(item.getViews() + 1);
        return itemDao.modifyItem(itemId,item);
    }

    @Override
    public List<Item> recommend() {
        return itemDao.recommend();
    }
}
