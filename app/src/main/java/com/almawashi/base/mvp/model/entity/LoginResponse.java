package com.almawashi.base.mvp.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class LoginResponse {
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("expirationTimeUTC")
    @Expose
    private String expirationTimeUTC;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("roles")
    @Expose
    private List<String> roles = new ArrayList<>(0);

    public String getToken() {
        return token;
    }

    public String getExpirationTimeUTC() {
        return expirationTimeUTC;
    }

    public String getUserName() {
        return userName;
    }

    public List<String> getRoles() {
        return roles;
    }
}
