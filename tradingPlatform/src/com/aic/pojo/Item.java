package com.aic.pojo;

import java.math.BigDecimal;

public class Item {

    private Integer id;
    private String name;
    private String detail;
    private BigDecimal price;
    private String imgPath;
    private Integer sellerId;
    private Integer views;
    private Integer status;

    public Item() {
    }

    public Item(Integer id, String name, String detail, BigDecimal price, String imgPath, Integer sellerId, Integer views, Integer status) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.imgPath = imgPath;
        this.sellerId = sellerId;
        this.views = views;
        this.status = status;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getViews() {
        return views;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                ", imgPath='" + imgPath + '\'' +
                ", sellerId=" + sellerId +
                ", views=" + views +
                ", status=" + status +
                '}';
    }
}
