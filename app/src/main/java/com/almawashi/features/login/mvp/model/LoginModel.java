package com.almawashi.features.login.mvp.model;

import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.base.BaseModel;
import com.almawashi.base.mvp.base.ICommonRepository;
import com.almawashi.base.mvp.model.entity.LoginRequest;
import com.almawashi.base.mvp.model.entity.LoginResponse;
import com.almawashi.features.login.mvp.contract.LoginContract;

import javax.inject.Inject;

import io.reactivex.Single;

@ActivityScope
public class LoginModel extends BaseModel implements LoginContract.Model {

    @Inject
    public LoginModel(ICommonRepository commonRepository) {
        super(commonRepository);
    }

    @Override
    public Single<LoginResponse> login(String userName, String password) {
        return getRemoteDataSource()
                .getAuthentication()
                .login(new LoginRequest(userName, password))
                .doOnSuccess(loginResponse -> {
                    getLocalDataSource().getSharedPreferences()
                            .putAccessToken(loginResponse.getToken());
                    getLocalDataSource().getSharedPreferences()
                            .putUserName(loginResponse.getUserName());
                });
    }
}