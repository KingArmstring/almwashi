package com.almawashi.features.login.di.module;

import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.model.local.LocalDataSource;
import com.almawashi.base.mvp.model.remote.RemoteDataSource;
import com.almawashi.features.login.mvp.contract.LoginContract;
import com.almawashi.features.login.mvp.model.LoginModel;
import com.almawashi.features.login.mvp.repository.ILoginRepository;
import com.almawashi.features.login.mvp.repository.ILoginRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {
    private LoginContract.View view;

    public LoginModule(LoginContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    LoginContract.View provideLoginView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    LoginContract.Model provideLoginModel(LoginModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    ILoginRepository provideLoginRepository(
            RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        return new ILoginRepositoryImpl(remoteDataSource, localDataSource);
    }
}