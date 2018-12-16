package com.almawashi.features.cart.mvp.repository;


import com.almawashi.base.mvp.base.CommonRepository;
import com.almawashi.base.mvp.model.local.LocalDataSource;
import com.almawashi.base.mvp.model.remote.RemoteDataSource;

import javax.inject.Inject;

public class ICartRepositoryImpl extends CommonRepository implements ICartRepository{

    @Inject
    public ICartRepositoryImpl(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        super(remoteDataSource, localDataSource);
    }
}
