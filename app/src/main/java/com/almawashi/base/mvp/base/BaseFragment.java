package com.almawashi.base.mvp.base;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public abstract class BaseFragment<P extends BasePresenter> extends Fragment
        implements BaseIView {
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Inject
    protected P mPresenter;
    @Inject
    protected Observable<Location> locationObservable;
    private Unbinder mUnbinder;
    private CompositeDisposable compositeDisposable;
    private RxPermissions rxPermissions;
    private ActivityUtils activityUtils;

    @CallSuper
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        compositeDisposable = new CompositeDisposable();
        super.onCreate(savedInstanceState);
    }

    @Override
    @CallSuper
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        activityUtils = new ActivityUtils(getActivity());
        View view = inflater.inflate(getViewLayoutResId(), container, false);
        mUnbinder = ButterKnife.bind(this, view);
        ComponentInject(Injector.INSTANCE.getAppComponent());
        onViewReady(view, savedInstanceState);
        return view;
    }

    protected abstract void onViewReady(View rootView, Bundle savedInstanceState);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null && mUnbinder != Unbinder.EMPTY) mUnbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDestroy();
        this.mPresenter = null;
        this.mUnbinder = null;
        dispose(compositeDisposable);
        compositeDisposable = null;
    }

    protected abstract void ComponentInject(ApplicationComponent appComponent);

    @LayoutRes
    protected abstract int getViewLayoutResId();

    public void setData(Object data) {

    }

    @Override
    public void showLoading() {
        activityUtils.showLoading("");
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
    public void hideKeyboard() {
        // TODO: 9/18/2017
    }

    @Override
    public boolean checkPlayServices() {
        // TODO: 9/18/2017
        return false;
    }

    @Override
    public RxPermissions getRxPermissions() {
        if (rxPermissions == null) {
            rxPermissions = new RxPermissions(getActivity());
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
    public void showLoading(String message) {
        activityUtils.showLoading(message);
    }

    @Override
    public void showLoading(@StringRes int messageId) {
        activityUtils.showLoading(messageId);
    }

    @Override
    public void showConfirmationDialog(@Nullable String positiveActionText,
                                       @Nullable String negativeActionText,
                                       @NonNull String message,
                                       ConfirmationDialogActionsListener listener) {
        activityUtils.showConfirmationDialog(positiveActionText, negativeActionText, message, listener);
    }

    @Override
    public void showMessage(@StringRes int messageStringRes, MessageType type) {
        activityUtils.showMessage(messageStringRes, type);
    }

    @Override
    public void showMessage(String message, MessageType type, MessageActionListener listener) {
        activityUtils.showMessage(message, type, listener);
    }

    @Override
    public void showMessage(String message, MessageType type) {
        activityUtils.showMessage(message, type);
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
        return ActivityUtils.isNetworkAvailable(getActivity());
    }

    public P getPresenter() {
        return mPresenter;
    }
}
