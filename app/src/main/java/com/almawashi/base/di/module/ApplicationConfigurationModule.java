package com.almawashi.base.di.module;

import com.almawashi.BuildConfig;
import com.almawashi.base.di.scope.ConfigApiBaseUrlQualifier;
import com.almawashi.base.di.scope.ConfigSharedPreferencesNameQualifier;
import com.almawashi.base.mvp.base.ApplicationConfiguration;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationConfigurationModule {

    @Provides
    @ConfigSharedPreferencesNameQualifier
    String provideSharedPreferencesName() {
        // FIXME: replace with actual shared preferences name
        return "almawashi";
    }


    @Provides
    @ConfigApiBaseUrlQualifier
    String provideApiBaseUrl() {
        return BuildConfig.MAIN_HOST;
    }


    @Provides
    @Singleton
    ApplicationConfiguration provideApplicationConfiguration() {
        return new ApplicationConfiguration() {
            @Override
            public boolean isDebug() {
                return BuildConfig.DEBUG;
            }
        };
    }
}
