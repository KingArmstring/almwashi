package com.almawashi.features.items.mvp.repository;

import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.base.CommonRepository;
import com.almawashi.base.mvp.model.local.LocalDataSource;
import com.almawashi.base.mvp.model.remote.RemoteDataSource;

import javax.inject.Inject;

@ActivityScope
public class IItemsRepositoryImpl extends CommonRepository implements IItemsRepository {

    @Inject
    public IItemsRepositoryImpl(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        super(remoteDataSource, localDataSource);
    }

}
