package com.aic.pojo;

public class CartItem {
    private Integer id;
    private Integer userId;
    private Integer cargoId;

    public CartItem() {
    }

    public CartItem(Integer id, Integer userId, Integer cargoId) {
        this.id = id;
        this.userId = userId;
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

    public Integer getCargoId() {
        return cargoId;
    }

    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", userId=" + userId +
                ", cargoId=" + cargoId +
                '}';
    }
}
