package com.almawashi.base.mvp.base;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.almawashi.base.di.Injector;
import com.almawashi.base.di.component.ApplicationComponent;
import com.almawashi.base.utils.ActivityUtils;
import com.almawashi.base.utils.ConfirmationDialogActionsListener;
import com.almawashi.base.utils.MessageActionListener;
import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import static com.almawashi.base.utils.Utils.RxUtils.dispose;

public abstract class BaseActivity<P extends BaseIPresenter> extends AppCompatActivity
        implements BaseIView {
    static final long LOCATION_TIMEOUT_IN_SECONDS = 12;
    static final float SUFFICIENT_ACCURACY = 200;
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private final static int REQUEST_CHECK_SETTINGS = 10000;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Inject
    protected P mPresenter;

    private CompositeDisposable compositeDisposable;
    private RxPermissions rxPermissions;
    private Unbinder mUnbinder;
    private ActivityUtils activityUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(getContentView());
        mUnbinder = ButterKnife.bind(this);
        activityUtils = new ActivityUtils(this);
        resolveDaggerDependency(Injector.INSTANCE.getAppComponent());
        rxPermissions = new RxPermissions(this);
        compositeDisposable = new CompositeDisposable();
        onViewReady(savedInstanceState, getIntent());
        mPresenter.onViewReady();
    }

    protected NavigationView getNavigationView() {
        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPresenter != null) {
            mPresenter.onPause();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mPresenter != null) {
            mPresenter.onStart();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mPresenter != null) {
            mPresenter.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDestroy();
        if (mUnbinder != Unbinder.EMPTY) mUnbinder.unbind();
        this.mPresenter = null;
        this.mUnbinder = null;
        dispose(compositeDisposable);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void showLoading() {
        activityUtils.showLoading("");
    }

    @Override
    public void showLoading(String message) {
        activityUtils.showLoading(message);
    }

    @Override
    public void showLoading(@StringRes int messageId) {
        activityUtils.showLoading(messageId);
    }

    @Override
    public void hideLoading() {
        activityUtils.hideLoading();
    }

    @Override
    public void showMessage(String message) {
        activityUtils.showMessage(message);
    }

    @Override
    public void showMessage(@StringRes int messageStringRes, MessageType type,
                            MessageActionListener listener) {
        activityUtils.showMessage(messageStringRes, type, listener);
    }

    @Override
    public void showMessage(String message, MessageType type,
                            MessageActionListener listener) {
        activityUtils.showMessage(message, type, listener);
    }

    @Override
    public void showMessage(@StringRes int messageStringRes, MessageType type) {
        activityUtils.showMessage(messageStringRes, type, () -> {
            // pass
        });
    }

    @Override
    public void showMessage(String message, MessageType type) {
        activityUtils.showMessage(message, type, () -> {
            // pass
        });
    }

    @Override
    public void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public boolean checkPlayServices() {
        // FIXME: 1/23/2018
        /*int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                finish();
            }
            return false;
        }*/
        return true;
    }

    public void fullScreenCall() {
        if (Build.VERSION.SDK_INT < 19) {
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public RxPermissions getRxPermissions() {
        if (rxPermissions == null) {
            rxPermissions = new RxPermissions(this);
        }
        return rxPermissions;
    }

    @Override
    public Observable<Boolean> checkLocationPermission() {
        return getRxPermissions().request(Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                .doOnNext(aBoolean -> {
                    if (!aBoolean) {
                        throw new SecurityException("Permission is Denied");
                    }
                });
    }

    @Override
    public void subscribe(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    @Override
    public void showConfirmationDialog(@Nullable String positiveActionText,
                                       @Nullable String negativeActionText,
                                       @NonNull String message,
                                       ConfirmationDialogActionsListener listener) {
        activityUtils.showConfirmationDialog(positiveActionText, negativeActionText, message, listener);
    }

    @Override
    public void showConfirmationDialog(@Nullable String positiveActionText,
                                       @Nullable String negativeActionText,
                                       @StringRes int stringRes,
                                       ConfirmationDialogActionsListener listener) {
        activityUtils.showConfirmationDialog(positiveActionText, negativeActionText, stringRes, listener);
    }

    @Override
    public void showConfirmationDialog(@StringRes int positiveActionText,
                                       @StringRes int negativeActionText,
                                       @StringRes int stringRes,
                                       ConfirmationDialogActionsListener listener) {
        activityUtils.showConfirmationDialog(positiveActionText, negativeActionText, stringRes, listener);
    }

    @Override
    public boolean isNetworkAvailable() {
        return ActivityUtils.isNetworkAvailable(this);
    }

    @LayoutRes
    protected abstract int getContentView();

    public abstract void onViewReady(Bundle savedInstanceState, Intent intent);

    protected abstract void resolveDaggerDependency(ApplicationComponent appComponent);

}
