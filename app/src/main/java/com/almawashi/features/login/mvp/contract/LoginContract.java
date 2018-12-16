package com.almawashi.features.login.mvp.contract;

import android.support.annotation.StringRes;

import com.almawashi.base.mvp.base.BaseIModel;
import com.almawashi.base.mvp.base.BaseIPresenter;
import com.almawashi.base.mvp.base.BaseIView;
import com.almawashi.base.mvp.model.entity.LoginResponse;

import io.reactivex.Single;

public interface LoginContract {

    interface View extends BaseIView {

        String getEmail();

        String getPassword();

        void showEmailError(@StringRes int error);

        void showPasswordError(@StringRes int error);

        void clearErrors();

        void startHome();
    }

    interface Model extends BaseIModel {

        Single<LoginResponse> login(String userName, String password);
    }

    interface Presenter extends BaseIPresenter {

        void onLoginClicked();

        void onForgetPasswordClicked();

        void onContinueAsGuestClicked();

        void onSignUpClicked();
    }

}
