package com.almawashi.base.di.module;

import com.almawashi.base.di.scope.ConfigApiBaseUrlQualifier;
import com.almawashi.base.mvp.base.ApplicationConfiguration;
import com.almawashi.base.mvp.model.remote.interceptor.GeneralInterceptor;
import com.almawashi.base.mvp.model.remote.interceptor.TokenAuthenticationInterceptor;
import com.almawashi.base.utils.LocalLogger;
import com.almawashi.base.utils.http.RxErrorHandlingCallAdapterFactory;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class NetworkModule {
    private static final int TIMEOUT = 60;

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor(new LocalLogger())
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor,
                                     TokenAuthenticationInterceptor tokenAuthenticationInterceptor,
                                     GeneralInterceptor generalInterceptor,
                                     ApplicationConfiguration configuration) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(tokenAuthenticationInterceptor)
                .addInterceptor(generalInterceptor);

        if (configuration.isDebug()) {
            builder.addInterceptor(httpLoggingInterceptor);
        }
        return builder.build();
    }

    @Provides
    @Singleton
    RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    RxErrorHandlingCallAdapterFactory provideRxErrorHandlingCallAdapterFactory() {
        return RxErrorHandlingCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(@ConfigApiBaseUrlQualifier String apiBaseUrl,
                             OkHttpClient okHttpClient,
                             Gson gson,
                             RxErrorHandlingCallAdapterFactory adapterFactory) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(adapterFactory)
                .baseUrl(apiBaseUrl)
                .client(okHttpClient)
                .build();
    }
}
