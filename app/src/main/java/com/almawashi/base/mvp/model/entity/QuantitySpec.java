package com.almawashi.base.mvp.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class QuantitySpec {

    @SerializedName("value")
    @Expose
    private int value;
    @SerializedName("allowableItemsQuantity")
    @Expose
    private List<Object> allowableItemsQuantity = null;
    @SerializedName("nameAR")
    @Expose
    private String nameAR;
    @SerializedName("nameEN")
    @Expose
    private String nameEN;
    @SerializedName("isSystemKey")
    @Expose
    private Object isSystemKey;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("currentUserId")
    @Expose
    private Object currentUserId;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Object> getAllowableItemsQuantity() {
        return allowableItemsQuantity;
    }

    public void setAllowableItemsQuantity(List<Object> allowableItemsQuantity) {
        this.allowableItemsQuantity = allowableItemsQuantity;
    }

    public String getNameAR() {
        return nameAR;
    }

    public void setNameAR(String nameAR) {
        this.nameAR = nameAR;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public Object getIsSystemKey() {
        return isSystemKey;
    }

    public void setIsSystemKey(Object isSystemKey) {
        this.isSystemKey = isSystemKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(Object currentUserId) {
        this.currentUserId = currentUserId;
    }
}

