package com.almawashi.base.mvp.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Item {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("descriptionAR")
    @Expose
    private String descriptionAR;
    @SerializedName("descriptionEN")
    @Expose
    private String descriptionEN;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("currentStock")
    @Expose
    private Integer currentStock;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("vatValue")
    @Expose
    private Integer vatValue;
    @SerializedName("discountValue")
    @Expose
    private Integer discountValue;
    @SerializedName("finalPrice")
    @Expose
    private Integer finalPrice;
    @SerializedName("fK_VAT_Id")
    @Expose
    private Integer fKVATId;
    @SerializedName("fK_Discount_Id")
    @Expose
    private Integer fKDiscountId;
    @SerializedName("fK_Category_Id")
    @Expose
    private Integer fKCategoryId;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("isInStock")
    @Expose
    private Boolean isInStock;
    @SerializedName("hasCuttings")
    @Expose
    private Boolean hasCuttings;
    @SerializedName("hasQuantities")
    @Expose
    private Boolean hasQuantities;
    @SerializedName("availableDateFrom")
    @Expose
    private Object availableDateFrom;
    @SerializedName("availableDateTo")
    @Expose
    private Object availableDateTo;
    @SerializedName("pictureURL")
    @Expose
    private String pictureURL;
    @SerializedName("picturePath")
    @Expose
    private Object picturePath;
    @SerializedName("category")
    @Expose
    private Object category;
    @SerializedName("vat")
    @Expose
    private Object vat;
    @SerializedName("discount")
    @Expose
    private Object discount;
    @SerializedName("allowableItemsCutting")
    @Expose
    private List<Object> allowableItemsCutting = null;
    @SerializedName("allowableItemsQuatity")
    @Expose
    private List<Object> allowableItemsQuantity = null;
    @SerializedName("file")
    @Expose
    private Object file;
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
    private Integer id;
    @SerializedName("isDeleted")
    @Expose
    private Boolean isDeleted;

    public String getCode() {
        return code;
    }

    public String getDescriptionAR() {
        return descriptionAR;
    }

    public String getDescriptionEN() {
        return descriptionEN;
    }

    public String getWeight() {
        return weight;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getVatValue() {
        return vatValue;
    }

    public Integer getDiscountValue() {
        return discountValue;
    }

    public Integer getFinalPrice() {
        return finalPrice;
    }

    public Integer getfKVATId() {
        return fKVATId;
    }

    public Integer getfKDiscountId() {
        return fKDiscountId;
    }

    public Integer getfKCategoryId() {
        return fKCategoryId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Boolean getInStock() {
        return isInStock;
    }

    public Boolean getHasCuttings() {
        return hasCuttings;
    }

    public Boolean getHasQuantities() {
        return hasQuantities;
    }

    public Object getAvailableDateFrom() {
        return availableDateFrom;
    }

    public Object getAvailableDateTo() {
        return availableDateTo;
    }

    public String getPictureURL() {
        if (pictureURL == null) {
            // FIXME: 2/27/2018 change to real data
            pictureURL = "http://37.34.230.240:81/Enmaa-Client/assets/Images/item.jpg";
        }
        return pictureURL;
    }

    public Object getPicturePath() {
        return picturePath;
    }

    public Object getCategory() {
        return category;
    }

    public Object getVat() {
        return vat;
    }

    public Object getDiscount() {
        return discount;
    }

    public List<Object> getAllowableItemsCutting() {
        return allowableItemsCutting;
    }

    public List<Object> getAllowableItemsQuantity() {
        return allowableItemsQuantity;
    }

    public Object getFile() {
        return file;
    }

    public String getNameAR() {
        return nameAR;
    }

    public String getNameEN() {
        return nameEN;
    }

    public Object getIsSystemKey() {
        return isSystemKey;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }
}
