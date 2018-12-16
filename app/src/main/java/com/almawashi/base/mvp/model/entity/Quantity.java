package com.almawashi.base.mvp.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Quantity {

    @SerializedName("fK_Item_Id")
    @Expose
    private int fKItemId;
    @SerializedName("fK_Quatity_Id")
    @Expose
    private int fKQuantityId;
    @SerializedName("quantity")
    @Expose
    private QuantitySpec quantity;
    @SerializedName("item")
    @Expose
    private Object item;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("currentUserId")
    @Expose
    private Object currentUserId;

    public int getfKItemId() {
        return fKItemId;
    }

    public void setfKItemId(int fKItemId) {
        this.fKItemId = fKItemId;
    }

    public int getfKQuantityId() {
        return fKQuantityId;
    }

    public void setfKQuantityId(int fKQuantityId) {
        this.fKQuantityId = fKQuantityId;
    }

    public QuantitySpec getQuantity() {
        return quantity;
    }

    public void setQuantity(QuantitySpec quantity) {
        this.quantity = quantity;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
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