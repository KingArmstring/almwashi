package com.almawashi.features.basket.di.module;


import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.model.local.LocalDataSource;
import com.almawashi.base.mvp.model.remote.RemoteDataSource;
import com.almawashi.features.basket.mvp.contract.BasketContract;
import com.almawashi.features.basket.mvp.model.BasketModel;
import com.almawashi.features.basket.mvp.repository.IBasketRepository;
import com.almawashi.features.basket.mvp.repository.IBasketRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class BasketModule {
    private BasketContract.View view;

    public BasketModule(BasketContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    BasketContract.View provideHomeView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    BasketContract.Model provideHomeModel(BasketModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    IBasketRepository provideHomeRepository(
            RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        return new IBasketRepositoryImpl(remoteDataSource, localDataSource);
    }
}
