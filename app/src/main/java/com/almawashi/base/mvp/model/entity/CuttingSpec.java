package com.almawashi.base.mvp.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CuttingSpec {

    @SerializedName("value")
    @Expose
    private int value;
    @SerializedName("price")
    @Expose
    private int price;
    @SerializedName("vatValue")
    @Expose
    private double vatValue;
    @SerializedName("discountValue")
    @Expose
    private double discountValue;
    @SerializedName("finalPrice")
    @Expose
    private double finalPrice;
    @SerializedName("fK_VAT_Id")
    @Expose
    private int fKVATId;
    @SerializedName("fK_Discount_Id")
    @Expose
    private int fKDiscountId;
    @SerializedName("allowableItemsCutting")
    @Expose
    private List<Object> allowableItemsCutting;
    @SerializedName("category")
    @Expose
    private Object category;
    @SerializedName("vat")
    @Expose
    private Object vat;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getVatValue() {
        return vatValue;
    }

    public void setVatValue(double vatValue) {
        this.vatValue = vatValue;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getfKVATId() {
        return fKVATId;
    }

    public void setfKVATId(int fKVATId) {
        this.fKVATId = fKVATId;
    }

    public int getfKDiscountId() {
        return fKDiscountId;
    }

    public void setfKDiscountId(int fKDiscountId) {
        this.fKDiscountId = fKDiscountId;
    }

    public List<Object> getAllowableItemsCutting() {
        return allowableItemsCutting;
    }

    public void setAllowableItemsCutting(List<Object> allowableItemsCutting) {
        this.allowableItemsCutting = allowableItemsCutting;
    }

    public Object getCategory() {
        return category;
    }

    public void setCategory(Object category) {
        this.category = category;
    }

    public Object getVat() {
        return vat;
    }

    public void setVat(Object vat) {
        this.vat = vat;
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