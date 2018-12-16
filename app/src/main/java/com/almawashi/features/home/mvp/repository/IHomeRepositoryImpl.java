package com.almawashi.features.home.mvp.repository;

import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.base.CommonRepository;
import com.almawashi.base.mvp.model.local.LocalDataSource;
import com.almawashi.base.mvp.model.remote.RemoteDataSource;

import javax.inject.Inject;

@ActivityScope
public class IHomeRepositoryImpl extends CommonRepository implements IHomeRepository {

    @Inject
    public IHomeRepositoryImpl(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        super(remoteDataSource, localDataSource);
    }

}
