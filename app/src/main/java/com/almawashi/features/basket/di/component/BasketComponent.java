package com.almawashi.features.basket.di.component;


import com.almawashi.base.di.component.ApplicationComponent;
import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.features.basket.di.module.BasketModule;
import com.almawashi.features.basket.mvp.ui.activity.BasketActivity;

import dagger.Component;

@ActivityScope
@Component(modules = BasketModule.class, dependencies = ApplicationComponent.class)
public interface BasketComponent {
    void inject(BasketActivity activity);
}
