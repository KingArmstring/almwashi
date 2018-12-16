package com.almawashi.features.items.di.module;

import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.model.local.LocalDataSource;
import com.almawashi.base.mvp.model.remote.RemoteDataSource;
import com.almawashi.features.items.mvp.contract.ItemsContract;
import com.almawashi.features.items.mvp.model.ItemsModel;
import com.almawashi.features.items.mvp.repository.IItemsRepository;
import com.almawashi.features.items.mvp.repository.IItemsRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class ItemsModule {
    private ItemsContract.View view;

    public ItemsModule(ItemsContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ItemsContract.View provideItemsView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ItemsContract.Model provideItemsModel(ItemsModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    IItemsRepository provideItemsRepository(
            RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        return new IItemsRepositoryImpl(remoteDataSource, localDataSource);
    }
}