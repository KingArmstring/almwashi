package com.almawashi.features.cart.di.component;

import com.almawashi.base.di.component.ApplicationComponent;
import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.features.cart.di.module.CartModule;
import com.almawashi.features.cart.mvp.ui.activity.CartActivity;

import dagger.Component;

@ActivityScope
@Component(modules = CartModule.class, dependencies = ApplicationComponent.class)
public interface CartComponent {
    void inject(CartActivity activity);
}
