package com.almawashi.features.splash.di.component;

import com.almawashi.base.di.component.ApplicationComponent;
import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.features.splash.di.module.SplashModule;
import com.almawashi.features.splash.mvp.ui.activity.SplashActivity;

import dagger.Component;

@ActivityScope
@Component(modules = SplashModule.class, dependencies = ApplicationComponent.class)
public interface SplashComponent {
    void inject(SplashActivity activity);
}
