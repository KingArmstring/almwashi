package com.almawashi.base.mvp.model.remote;

import com.almawashi.base.mvp.model.remote.api.Authentication;
import com.almawashi.base.mvp.model.remote.api.Inventory;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Retrofit;

@Singleton
public class ServiceManager implements RemoteDataSource {

    private final Retrofit retrofit;

    @Inject
    public ServiceManager(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public Inventory getInventory() {
        return retrofit.create(Inventory.class);
    }

    @Override
    public Authentication getAuthentication() {
        return retrofit.create(Authentication.class);
    }
}
