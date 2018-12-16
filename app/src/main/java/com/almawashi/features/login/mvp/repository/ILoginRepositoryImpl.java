package com.almawashi.features.login.mvp.repository;

import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.base.CommonRepository;
import com.almawashi.base.mvp.model.local.LocalDataSource;
import com.almawashi.base.mvp.model.remote.RemoteDataSource;

import javax.inject.Inject;

@ActivityScope
public class ILoginRepositoryImpl extends CommonRepository implements ILoginRepository {

    @Inject
    public ILoginRepositoryImpl(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        super(remoteDataSource, localDataSource);
    }

}
