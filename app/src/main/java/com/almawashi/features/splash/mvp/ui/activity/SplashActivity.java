package com.almawashi.features.splash.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.almawashi.R;
import com.almawashi.base.di.component.ApplicationComponent;
import com.almawashi.base.mvp.base.BaseActivity;
import com.almawashi.features.home.mvp.ui.activity.HomeActivity;
import com.almawashi.features.login.mvp.ui.activity.LoginActivity;
import com.almawashi.features.splash.di.component.DaggerSplashComponent;
import com.almawashi.features.splash.di.module.SplashModule;
import com.almawashi.features.splash.mvp.contract.SplashContract;
import com.almawashi.features.splash.mvp.presenter.SplashPresenter;

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {

    @Override
    protected int getContentView() {
        return R.layout.activity_splash;
    }

    @Override
    public void onViewReady(Bundle savedInstanceState, Intent intent) {
        // pass
    }

    @Override
    public void resolveDaggerDependency(ApplicationComponent appComponent) {
        DaggerSplashComponent
                .builder()
                .applicationComponent(appComponent)
                .splashModule(new SplashModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void startHome() {
        HomeActivity.start(this);
    }

    @Override
    public void startLogin() {
        LoginActivity.start(this);
    }
}