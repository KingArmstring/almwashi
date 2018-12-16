package com.almawashi.features.login.mvp.presenter;

import com.almawashi.R;
import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.base.BasePresenter;
import com.almawashi.base.mvp.base.MessageType;
import com.almawashi.base.utils.Preconditions;
import com.almawashi.features.login.mvp.contract.LoginContract;

import javax.inject.Inject;

@ActivityScope
public class LoginPresenter extends BasePresenter<LoginContract.Model, LoginContract.View>
        implements LoginContract.Presenter {

    @Inject
    public LoginPresenter(LoginContract.View rootView, LoginContract.Model model) {
        super(rootView, model);
    }

    @Override
    public void onViewReady() {
        // pass
    }

    @Override
    public void onLoginClicked() {
        getRootView().clearErrors();

        String email = getRootView().getEmail();
        String password = getRootView().getPassword();

        if (!Preconditions.checkisNotNullOrEmpty(email)) {
            getRootView().showEmailError(R.string.error_email_required);
            return;
        }

        // FIXME: 3/4/2018
        /*if (!Preconditions.checkValidEmail(email)) {
            getRootView().showEmailError(R.string.error_email_invalid);
            return;
        }*/

        if (!Preconditions.checkisNotNullOrEmpty(password)) {
            getRootView().showPasswordError(R.string.error_password_required);
            return;
        }

        subscribe(getModel().login(email, password).toObservable(),
                loginResponse -> {
                    getRootView().startHome();
                }, throwable -> {
                    getRootView().showMessage(R.string.error_email_or_password_are_invalid,
                            MessageType.Error);
                }, true, "", 0);

    }

    @Override
    public void onForgetPasswordClicked() {
        // FIXME: 3/4/2018
    }

    @Override
    public void onContinueAsGuestClicked() {
        getRootView().startHome();
    }

    @Override
    public void onSignUpClicked() {
        // FIXME: 3/4/2018
    }
}