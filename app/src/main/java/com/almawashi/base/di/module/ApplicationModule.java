package com.almawashi.base.di.module;


import android.app.Application;
import android.content.Context;

import com.almawashi.BuildConfig;
import com.almawashi.base.di.scope.ApplicationQualifier;
import com.almawashi.base.utils.CacheUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import timber.log.Timber;


@Module
public class ApplicationModule {
    public static final String DATE_FORMAT = "MM/dd/yyyy HH:mm:ss a";
    private final Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    @ApplicationQualifier
    Context provideContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat(DATE_FORMAT);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    Picasso providePicasso(OkHttpClient client, Application app) {
        File cache = CacheUtils.createDefaultCacheDir(app);

        OkHttpClient picassoOkHttpClient = client
                .newBuilder()
                .cache(new Cache(cache, CacheUtils.calculateDiskCacheSize(cache)))
                .build();

        Picasso.Builder builder = new Picasso
                .Builder(app)
                .downloader(new OkHttp3Downloader(picassoOkHttpClient))
//                .indicatorsEnabled(BuildConfig.DEBUG)
                .loggingEnabled(BuildConfig.DEBUG)
                .listener((picasso, uri, exception) ->
                        Timber.e(exception, "Error while loading image %s", uri));

        return builder.build();
    }
}
