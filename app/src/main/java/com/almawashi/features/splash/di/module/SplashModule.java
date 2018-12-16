package com.almawashi.features.splash.di.module;

import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.model.local.LocalDataSource;
import com.almawashi.base.mvp.model.remote.RemoteDataSource;
import com.almawashi.features.splash.mvp.contract.SplashContract;
import com.almawashi.features.splash.mvp.model.SplashModel;
import com.almawashi.features.splash.mvp.ui.activity.ISplashRepository;
import com.almawashi.features.splash.mvp.ui.activity.ISplashRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashModule {
    private SplashContract.View view;

    public SplashModule(SplashContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    SplashContract.View provideSplashView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    SplashContract.Model provideSplashModel(SplashModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    ISplashRepository provideSplashRepository(
            RemoteDataSource remoteDataSource, LocalDataSource locatDataSource) {
        return new ISplashRepositoryImpl(remoteDataSource, locatDataSource);
    }
}