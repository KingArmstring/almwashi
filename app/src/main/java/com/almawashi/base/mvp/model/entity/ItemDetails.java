package com.almawashi.base.mvp.model.entity;


import io.realm.RealmObject;

public class ItemDetails extends RealmObject{

    private int itemId;
    private String itemName;
    private int quantityNum;
    private int cuttingNum;
    private String description;
    private String weight;
    private double price;
    private int currentStock;
    private String imgUrl;

    public ItemDetails() {
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantityNum() {
        return quantityNum;
    }

    public void setQuantityNum(int quantityNum) {
        this.quantityNum = quantityNum;
    }

    public int getCuttingNum() {
        return cuttingNum;
    }

    public void setCuttingNum(int cuttingNum) {
        this.cuttingNum = cuttingNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
