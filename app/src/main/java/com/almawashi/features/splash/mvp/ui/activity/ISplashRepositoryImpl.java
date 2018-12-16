package com.almawashi.features.splash.mvp.ui.activity;

import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.base.CommonRepository;
import com.almawashi.base.mvp.model.local.LocalDataSource;
import com.almawashi.base.mvp.model.remote.RemoteDataSource;

import javax.inject.Inject;

@ActivityScope
public class ISplashRepositoryImpl extends CommonRepository implements ISplashRepository {

    @Inject
    public ISplashRepositoryImpl(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        super(remoteDataSource, localDataSource);
    }

}
