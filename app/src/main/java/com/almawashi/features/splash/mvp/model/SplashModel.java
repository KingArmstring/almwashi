package com.almawashi.features.splash.mvp.model;

import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.base.BaseModel;
import com.almawashi.features.splash.mvp.contract.SplashContract;
import com.almawashi.features.splash.mvp.ui.activity.ISplashRepository;

import javax.inject.Inject;

@ActivityScope
public class SplashModel extends BaseModel implements SplashContract.Model {

    @Inject
    public SplashModel(ISplashRepository splashRepository) {
        super(splashRepository);
    }

    @Override
    public boolean isLoggedInUser() {
        return getLocalDataSource().getSharedPreferences().isLoggedInUser();
    }
}