package com.almawashi.features.home.di.module;

import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.model.local.LocalDataSource;
import com.almawashi.base.mvp.model.remote.RemoteDataSource;
import com.almawashi.features.home.mvp.contract.HomeContract;
import com.almawashi.features.home.mvp.model.HomeModel;
import com.almawashi.features.home.mvp.repository.IHomeRepository;
import com.almawashi.features.home.mvp.repository.IHomeRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {
    private HomeContract.View view;

    public HomeModule(HomeContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    HomeContract.View provideHomeView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    HomeContract.Model provideHomeModel(HomeModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    IHomeRepository provideHomeRepository(
            RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        return new IHomeRepositoryImpl(remoteDataSource, localDataSource);
    }
}