package com.almawashi.base.mvp.model.remote.interceptor;

import com.almawashi.base.mvp.model.local.SharedPreferencesUtils;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;



@Singleton
public class GeneralInterceptor implements Interceptor {
    private SharedPreferencesUtils sharedPreferencesUtils;

    @Inject
    public GeneralInterceptor(SharedPreferencesUtils sharedPreferencesUtils) {
        this.sharedPreferencesUtils = sharedPreferencesUtils;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        // TODO: 9/12/2017 inject any data to all requests
        return chain.proceed(request);
    }
}
