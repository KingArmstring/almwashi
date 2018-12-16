package com.almawashi.features.splash.mvp.contract;

import com.almawashi.base.mvp.base.BaseIModel;
import com.almawashi.base.mvp.base.BaseIPresenter;
import com.almawashi.base.mvp.base.BaseIView;

public interface SplashContract {

    interface View extends BaseIView {

        void startHome();

        void startLogin();
    }

    interface Model extends BaseIModel {

        boolean isLoggedInUser();
    }

    interface Presenter extends BaseIPresenter {

    }

}
