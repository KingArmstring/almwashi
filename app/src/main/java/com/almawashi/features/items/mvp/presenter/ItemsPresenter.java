package com.almawashi.features.items.mvp.presenter;

import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.base.BasePresenter;
import com.almawashi.features.items.mvp.contract.ItemsContract;

import javax.inject.Inject;

@ActivityScope
public class ItemsPresenter extends BasePresenter<ItemsContract.Model, ItemsContract.View>
        implements ItemsContract.Presenter {

    @Inject
    public ItemsPresenter(ItemsContract.View rootView, ItemsContract.Model model) {
        super(rootView, model);
    }

    @Override
    public void onViewReady() {

    }

    @Override
    public void startWithData(int categoryId) {
        subscribe(getModel().getItemsByCategoryId(categoryId).toObservable(),
                items -> {
                    getRootView().onItemsLoadedSuccessfully(items);
                }, true);
    }
}