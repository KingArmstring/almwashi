package com.almawashi.base.mvp.model.remote.api;

import com.almawashi.base.mvp.model.entity.LoginRequest;
import com.almawashi.base.mvp.model.entity.LoginResponse;
import com.almawashi.base.mvp.model.remote.API;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Authentication {

    @POST(API.Authentication.LOGIN)
    Single<LoginResponse> login(@Body LoginRequest loginRequest);

}
