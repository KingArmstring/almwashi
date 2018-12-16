package com.almawashi.base.mvp.base;

import com.almawashi.base.mvp.model.local.LocalDataSource;
import com.almawashi.base.mvp.model.remote.RemoteDataSource;

import javax.inject.Inject;

public class BaseModel<T extends ICommonRepository> implements BaseIModel {
    private T commonRepository;
    private LocalDataSource mLocalDataSource;

    @Inject
    public BaseModel(T commonRepository) {
        this.commonRepository = commonRepository;
    }

    public T getCommonRepository() {
        return commonRepository;
    }

    @Override
    public LocalDataSource getLocalDataSource() {
        return getCommonRepository().getLocalDataSource();
    }

    @Override
    public RemoteDataSource getRemoteDataSource() {
        return getCommonRepository().getRemoteDataSource();
    }
}
