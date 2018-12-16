package com.almawashi.features.basket.mvp.presenter;

import com.almawashi.R;
import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.base.BasePresenter;
import com.almawashi.base.mvp.base.MessageType;
import com.almawashi.features.basket.mvp.contract.BasketContract;

import javax.inject.Inject;

@ActivityScope
public class BasketPresenter extends BasePresenter<BasketContract.Model, BasketContract.View>
        implements BasketContract.Presenter {

    @Inject
    public BasketPresenter(BasketContract.View rootView, BasketContract.Model model) {
        super(rootView, model);
    }

    @Override
    public void onViewReady() {

    }

    @Override
    public void bringPurchaseData(int id) {
        //I need tro get some data response to update the UI with it. just that so we need to type: getRootView().updateUI();
        subscribe(
                getModel().getItemDetailsById(id).toObservable(),
                listBaseResponse -> {
                    ///*These two method calls update the UI Spinners.
                    getRootView().updateQuantitySpinner(listBaseResponse.getData().getQuantities());
                    getRootView().updateCuttingSpinner(listBaseResponse.getData().getCuttings());
                },
                throwable -> {
                    getRootView().showMessage(R.string.error_unexpected_error_happened,
                            MessageType.Error);
                },
                true, "", 0);
    }
}