package com.almawashi.base.di.module;

import android.content.Context;

import com.almawashi.base.di.scope.ApplicationQualifier;
import com.almawashi.base.mvp.base.CommonRepository;
import com.almawashi.base.mvp.base.ICommonRepository;
import com.almawashi.base.mvp.model.local.LocalDataSource;
import com.almawashi.base.mvp.model.local.LocalDataSourceImpl;
import com.almawashi.base.mvp.model.local.SharedPreferencesUtils;
import com.almawashi.base.mvp.model.remote.RemoteDataSource;
import com.almawashi.base.mvp.model.remote.ServiceManager;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
public class MainDataSourceModule {
    @Provides
    @Singleton
    LocalDataSource provideLocalStorage(@ApplicationQualifier Context context, Gson gson,
                                        SharedPreferencesUtils sharedPreferencesUtils) {
        return new LocalDataSourceImpl(context, gson, sharedPreferencesUtils);
    }

    @Provides
    @Singleton
    RemoteDataSource provideRemoteDataSource(Retrofit retrofit) {
        return new ServiceManager(retrofit);
    }

    @Provides
    @Singleton
    ICommonRepository provideCommonRepository(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        return new CommonRepository(remoteDataSource, localDataSource);
    }
}
