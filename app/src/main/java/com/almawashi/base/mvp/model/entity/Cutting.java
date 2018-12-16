package com.almawashi.base.mvp.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Cutting {

    @SerializedName("fK_Item_Id")
    @Expose
    private int fKItemId;
    @SerializedName("fK_Cutting_Id")
    @Expose
    private int fKCuttingId;
    @SerializedName("cuttingSpec")
    @Expose
    private CuttingSpec cuttingSpec;
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

    public int getfKCuttingId() {
        return fKCuttingId;
    }

    public void setfKCuttingId(int fKCuttingId) {
        this.fKCuttingId = fKCuttingId;
    }

    public CuttingSpec getCuttingSpec() {
        return cuttingSpec;
    }

    public void setCuttingSpec(CuttingSpec cuttingSpec) {
        this.cuttingSpec = cuttingSpec;
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