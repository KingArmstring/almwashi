package com.almawashi.features.basket.mvp.repository;

import com.almawashi.base.mvp.base.CommonRepository;
import com.almawashi.base.mvp.model.local.LocalDataSource;
import com.almawashi.base.mvp.model.remote.RemoteDataSource;

import javax.inject.Inject;

public class IBasketRepositoryImpl extends CommonRepository implements IBasketRepository{

    @Inject
    public IBasketRepositoryImpl(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        super(remoteDataSource, localDataSource);
    }
}
