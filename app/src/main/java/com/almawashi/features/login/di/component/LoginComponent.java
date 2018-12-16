package com.almawashi.features.login.di.component;

import com.almawashi.base.di.component.ApplicationComponent;
import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.features.login.di.module.LoginModule;
import com.almawashi.features.login.mvp.ui.activity.LoginActivity;

import dagger.Component;

@ActivityScope
@Component(modules = LoginModule.class, dependencies = ApplicationComponent.class)
public interface LoginComponent {
    void inject(LoginActivity activity);
}
