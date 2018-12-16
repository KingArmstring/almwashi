package com.almawashi.base.mvp.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemDetailsResponse {

    @SerializedName("fk_Item_Id")
    @Expose
    private int fkItemId;
    @SerializedName("quantities")
    @Expose
    private List<Quantity> quantities;
    @SerializedName("cuttings")
    @Expose
    private List<Cutting> cuttings;

    public int getFkItemId() {
        return fkItemId;
    }

    public void setFkItemId(int fkItemId) {
        this.fkItemId = fkItemId;
    }

    public List<Quantity> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Quantity> quantities) {
        this.quantities = quantities;
    }

    public List<Cutting> getCuttings() {
        return cuttings;
    }

    public void setCuttings(List<Cutting> cuttings) {
        this.cuttings = cuttings;
    }
}
