package com.almawashi.features.cart.di.module;

import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.model.local.LocalDataSource;
import com.almawashi.base.mvp.model.remote.RemoteDataSource;
import com.almawashi.features.cart.mvp.contract.CartContract;
import com.almawashi.features.cart.mvp.model.CartModel;
import com.almawashi.features.cart.mvp.repository.ICartRepository;
import com.almawashi.features.cart.mvp.repository.ICartRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class CartModule {

    private CartContract.View view;

    @ActivityScope
    @Provides
    CartContract.View providesCartView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    CartContract.Model providesCartModel(CartModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    ICartRepository providesCartRepository(
            RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        return new ICartRepositoryImpl(remoteDataSource, localDataSource);
    }
}
