package com.almawashi.base.mvp.base;

import com.almawashi.base.mvp.model.local.LocalDataSource;
import com.almawashi.base.mvp.model.remote.RemoteDataSource;

import javax.inject.Inject;



public class CommonRepository implements ICommonRepository {
    private RemoteDataSource remoteDataSource;
    private LocalDataSource localDataSource;

    @Inject
    public CommonRepository(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public RemoteDataSource getRemoteDataSource() {
        return remoteDataSource;
    }

    @Override
    public LocalDataSource getLocalDataSource() {
        return localDataSource;
    }
}
