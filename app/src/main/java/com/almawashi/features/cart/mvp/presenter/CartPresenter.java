package com.almawashi.features.cart.mvp.presenter;

import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.base.BasePresenter;
import com.almawashi.features.cart.mvp.contract.CartContract;

import javax.inject.Inject;

@ActivityScope
public class CartPresenter extends BasePresenter<CartContract.Model, CartContract.View>
        implements CartContract.Presenter{

    @Inject
    public CartPresenter(CartContract.View rootView, CartContract.Model model) {
        super(rootView, model);
    }

    @Override
    public void onViewReady() {

    }
}
