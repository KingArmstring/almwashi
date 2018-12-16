package com.almawashi.base.mvp.base;

import com.almawashi.base.mvp.model.local.LocalDataSource;
import com.almawashi.base.mvp.model.remote.RemoteDataSource;



public interface ICommonRepository {
    RemoteDataSource getRemoteDataSource();

    LocalDataSource getLocalDataSource();
}
