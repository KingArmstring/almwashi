package com.almawashi.features.items.di.component;

import com.almawashi.base.di.component.ApplicationComponent;
import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.features.items.di.module.ItemsModule;
import com.almawashi.features.items.mvp.ui.activity.ItemsActivity;

import dagger.Component;

@ActivityScope
@Component(modules = ItemsModule.class, dependencies = ApplicationComponent.class)
public interface ItemsComponent {
    void inject(ItemsActivity activity);
}
