package com.almawashi.base.di.component;

import android.content.Context;

import com.almawashi.base.di.module.ApplicationConfigurationModule;
import com.almawashi.base.di.module.ApplicationModule;
import com.almawashi.base.di.module.MainDataSourceModule;
import com.almawashi.base.di.module.NetworkModule;
import com.almawashi.base.di.scope.ApplicationQualifier;
import com.almawashi.base.mvp.base.ICommonRepository;
import com.almawashi.base.mvp.model.local.LocalDataSource;
import com.almawashi.base.mvp.model.remote.RemoteDataSource;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;


@Singleton
@Component(modules =
        {
                ApplicationModule.class,
                ApplicationConfigurationModule.class,
                NetworkModule.class,
                MainDataSourceModule.class
        })
public interface ApplicationComponent {
    @ApplicationQualifier
    Context exposeContext();

    Gson exposeGson();

    Retrofit exposeRetrofit();

    RemoteDataSource exposeRemoteDataSource();

    LocalDataSource exposeLocalDataSource();

    ICommonRepository exposeCommonRepository();

    Picasso exposePicasso();
}
