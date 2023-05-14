package com.aic.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class OrderItem {
    private Integer id;
    private Integer sellerId;
    private String sellerName;
    private Integer userId;
    private String username;
    private Integer cargoId;
    private String name;
    private BigDecimal price;
    private String detail;
    private Date createTime;
    private String imgPath;

    public OrderItem() {
    }

    public OrderItem(Integer id, Integer sellerId, String sellerName, Integer userId, String username, Integer cargoId, String name, BigDecimal price, String detail, Date createTime, String imgPath) {
        this.id = id;
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.userId = userId;
        this.username = username;
        this.cargoId = cargoId;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.createTime = createTime;
        this.imgPath = imgPath;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", sellerId=" + sellerId +
                ", sellerName='" + sellerName + '\'' +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", cargoId=" + cargoId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
