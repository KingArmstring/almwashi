package com.almawashi.features.home.mvp.presenter;

import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.base.BasePresenter;
import com.almawashi.features.home.mvp.contract.HomeContract;

import javax.inject.Inject;

@ActivityScope
public class HomePresenter extends BasePresenter<HomeContract.Model, HomeContract.View>
        implements HomeContract.Presenter {

    @Inject
    public HomePresenter(HomeContract.View rootView, HomeContract.Model model) {
        super(rootView, model);
    }

    @Override
    public void onViewReady() {
        subscribe(getModel().getCategories().toObservable(), categories -> {
            getRootView().onCategoriesLoadedSuccessfully(categories);
        }, true);
    }

}