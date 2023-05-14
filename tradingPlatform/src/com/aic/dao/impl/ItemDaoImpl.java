package com.aic.dao.impl;

import com.aic.dao.ItemDao;
import com.aic.pojo.Item;

import java.util.List;

public class ItemDaoImpl extends BaseDao implements ItemDao {
    @Override
    public int saveItem(Item item) {
        String sql = "insert into t_cargo(seller_id , name , price , detail , img_path) values(? , ? , ? , ? , ?) ";
        return update(sql , item.getSellerId() , item.getName() , item.getPrice() , item.getDetail() , item.getImgPath());
    }

    @Override
    public int modifyItem(Integer itemId, Item item) {
        String sql = "update t_cargo set name = ? , price = ?, detail = ?, img_path = ? , views = ? , status = ? where id = ?";
        return update(sql , item.getName() , item.getPrice() , item.getDetail() , item.getImgPath() , item.getViews() , item.getStatus(),itemId);
    }

    @Override
    public List<Item> queryItemByUserId(Integer userId) {
        String sql = "select id , name , detail , price , img_path as imgPath , seller_id as sellerId , views ,status from t_cargo where seller_id = ?";
        return queryForList(Item.class,sql,userId);
    }

    @Override
    public List<Item> queryAllItems() {
        String sql = "select id , name , detail , price , img_path as imgPath , seller_id as sellerId , views , status from t_cargo where status != 1";
        return queryForList(Item.class,sql);
    }

    @Override
    public Item queryItemById(Integer itemId) {
        String sql = "select id , name , detail , price , img_path as imgPath , seller_id as sellerId , views , status from t_cargo where id = ?";
        return queryForOne(Item.class , sql , itemId);
    }

    @Override
    public int deleteItemById(int itemId) {
        String sql = "delete from t_cargo where id = ?";
        return update(sql,itemId);
    }

    @Override
    public List<Item> recommend() {
        String sql = "select id , name , detail , price , img_path as imgPath , seller_id as sellerId , views from t_cargo where status != 1 order by views desc limit 10";
        return queryForList(Item.class , sql);
    }
}
