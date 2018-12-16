package com.almawashi.features.splash.mvp.presenter;

import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.base.BasePresenter;
import com.almawashi.features.splash.mvp.contract.SplashContract;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

@ActivityScope
public class SplashPresenter extends BasePresenter<SplashContract.Model, SplashContract.View>
        implements SplashContract.Presenter {

    @Inject
    public SplashPresenter(SplashContract.View rootView, SplashContract.Model model) {
        super(rootView, model);
    }

    @Override
    public void onViewReady() {
        addSubscription(Observable.timer(3000, TimeUnit.MILLISECONDS)
                .take(1)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Timber::e)
                .subscribe(aLong -> {
                    if (getModel().isLoggedInUser()) {
                        getRootView().startHome();
                    } else {
                        getRootView().startLogin();
                    }
                }));
    }

}