package com.almawashi.features.login.mvp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.TextInputEditText;
import android.view.View;

import com.almawashi.BuildConfig;
import com.almawashi.R;
import com.almawashi.base.di.component.ApplicationComponent;
import com.almawashi.base.mvp.base.BaseActivity;
import com.almawashi.features.home.mvp.ui.activity.HomeActivity;
import com.almawashi.features.login.di.component.DaggerLoginComponent;
import com.almawashi.features.login.di.module.LoginModule;
import com.almawashi.features.login.mvp.contract.LoginContract;
import com.almawashi.features.login.mvp.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.et_email)
    TextInputEditText etEmail;
    @BindView(R.id.et_password)
    TextInputEditText etPassword;




    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    public void onViewReady(Bundle savedInstanceState, Intent intent) {
        // pass
        if (BuildConfig.DEBUG) {
            etEmail.setText("Customer1");
            etPassword.setText("P@ssw0rd");
        }
    }

    @Override
    public void resolveDaggerDependency(ApplicationComponent appComponent) {
        DaggerLoginComponent
                .builder()
                .applicationComponent(appComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @OnClick({R.id.btn_login, R.id.btn_forget_password, R.id.btn_continue_as_guest,
            R.id.btn_sign_up})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                getPresenter().onLoginClicked();
                break;
            case R.id.btn_forget_password:
                getPresenter().onForgetPasswordClicked();
                break;
            case R.id.btn_continue_as_guest:
                getPresenter().onContinueAsGuestClicked();
                break;
            case R.id.btn_sign_up:
                getPresenter().onSignUpClicked();
                break;
        }
    }

    @Override
    public String getEmail() {
        return etEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void showEmailError(@StringRes int error) {
        etEmail.setError(getString(error));
    }

    @Override
    public void showPasswordError(@StringRes int error) {
        etPassword.setError(getString(error));
    }

    @Override
    public void clearErrors() {
        etEmail.setError(null);
        etPassword.setError(null);
    }

    @Override
    public void startHome() {
        HomeActivity.start(this);
    }
}