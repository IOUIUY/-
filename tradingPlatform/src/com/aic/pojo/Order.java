package com.aic.pojo;

import java.util.Date;

public class Order {
    private Integer id;
    private Integer userId;
    private Integer sellerId;
    private Date createTime;
    private Integer cargoId;

    public Order() {
    }

    public Order(Integer id, Integer userId, Integer sellerId, Date createTime, Integer cargoId) {
        this.id = id;
        this.userId = userId;
        this.sellerId = sellerId;
        this.createTime = createTime;
        this.cargoId = cargoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Integer getCargoId() {
        return cargoId;
    }

    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", sellerId=" + sellerId +
                ", createTime=" + createTime +
                ", cargoId=" + cargoId +
                '}';
    }
}
