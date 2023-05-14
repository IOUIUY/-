package com.aic.pojo;

import java.math.BigDecimal;

public class CartItemDetail {
    private Integer id;
    private Integer userId;
    private Integer cargoId;
    private String name;
    private String sellerName;
    private BigDecimal price;
    private String detail;

    private String imgPath;

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public CartItemDetail() {
    }

    public CartItemDetail(Integer id, Integer userId, Integer cargoId, String name, String sellerName, BigDecimal price, String detail, String imgPath) {
        this.id = id;
        this.userId = userId;
        this.cargoId = cargoId;
        this.name = name;
        this.sellerName = sellerName;
        this.price = price;
        this.detail = detail;
        this.imgPath = imgPath;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "CartItemDetail{" +
                "id=" + id +
                ", userId=" + userId +
                ", cargoId=" + cargoId +
                ", name='" + name + '\'' +
                ", sellerName='" + sellerName + '\'' +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
