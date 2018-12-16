package com.almawashi.features.home.di.component;

import com.almawashi.base.di.component.ApplicationComponent;
import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.features.home.di.module.HomeModule;
import com.almawashi.features.home.mvp.ui.activity.HomeActivity;

import dagger.Component;

@ActivityScope
@Component(modules = HomeModule.class, dependencies = ApplicationComponent.class)
public interface HomeComponent {
    void inject(HomeActivity activity);
}
