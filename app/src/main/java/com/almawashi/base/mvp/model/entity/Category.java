package com.almawashi.base.mvp.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Category {
    @SerializedName("descriptionAR")
    @Expose
    private String descriptionAR;
    @SerializedName("descriptionEN")
    @Expose
    private String descriptionEN;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("pictureURL")
    @Expose
    private String pictureURL;
    @SerializedName("nameAR")
    @Expose
    private String nameAR;
    @SerializedName("nameEN")
    @Expose
    private String nameEN;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("isDeleted")
    @Expose
    private Boolean isDeleted;

    public String getDescriptionAR() {
        return descriptionAR;
    }

    public String getDescriptionEN() {
        return descriptionEN;
    }

    public String getCode() {
        return code;
    }

    public Boolean getActive() {
        return isActive;
    }

    public String getPictureURL() {
        if (pictureURL == null) {
            // FIXME: 2/27/2018 change to real data
            pictureURL = "http://37.34.230.240:81/Enmaa-Client/assets/Images/item.jpg";
        }
        return pictureURL;
    }

    public String getNameAR() {
        return nameAR;
    }

    public String getNameEN() {
        return nameEN;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }
}
