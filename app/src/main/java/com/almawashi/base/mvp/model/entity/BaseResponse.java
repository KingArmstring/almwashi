package com.almawashi.base.mvp.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class BaseResponse<T> {

    @SerializedName("isSucceeded")
    @Expose
    private Boolean isSucceeded;
    @SerializedName("methodName")
    @Expose
    private String methodName;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("data")
    @Expose
    private T data;

    public Boolean getIsSucceeded() {
        return isSucceeded;
    }

    public String getMethodName() {
        return methodName;
    }

    public Status getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }
}
