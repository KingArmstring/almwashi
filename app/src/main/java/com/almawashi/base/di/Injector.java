package com.almawashi.base.di;


import com.almawashi.base.di.component.ApplicationComponent;
import com.almawashi.base.di.component.DaggerApplicationComponent;
import com.almawashi.base.di.module.ApplicationModule;
import com.almawashi.base.di.module.MainDataSourceModule;
import com.almawashi.base.di.module.NetworkModule;
import com.almawashi.base.mvp.base.BaseApplication;


public enum Injector {
    INSTANCE;

    private ApplicationComponent applicationComponent;

    public ApplicationComponent initializeAppComponent(BaseApplication application) {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(application))
                .networkModule(new NetworkModule())
                .mainDataSourceModule(new MainDataSourceModule())
                .build();
        return applicationComponent;
    }

    public ApplicationComponent getAppComponent() {
        return applicationComponent;
    }
}
