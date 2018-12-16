package com.almawashi.base.mvp.base;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.almawashi.base.utils.ActivityUtils;
import com.almawashi.base.utils.ConfirmationDialogActionsListener;
import com.almawashi.base.utils.MessageActionListener;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;



public abstract class FullScreenDialogFragment extends DialogFragment implements BaseIView {
    private Unbinder unbinder;
    private CompositeDisposable compositeDisposable;

    public FullScreenDialogFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    @Override
    @CallSuper
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    @CallSuper
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getContentView(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @LayoutRes
    protected abstract int getContentView();

    @NonNull
    @Override
    @CallSuper
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        if (showAsFullScreen())
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    protected abstract boolean showAsFullScreen();

    @Override
    @CallSuper
    public void onDestroyView() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroyView();
    }

    @Override
    @CallSuper
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    @Override
    @CallSuper
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewReady(view, savedInstanceState);
    }

    @Override
    @CallSuper
    public void onDestroy() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
            compositeDisposable = null;
        }
        super.onDestroy();
    }

    public abstract void onViewReady(View view, @Nullable Bundle savedInstanceState);

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(@StringRes int messageStringRes, MessageType type,
                            MessageActionListener listener) {

    }

    @Override
    public void showMessage(@StringRes int messageStringRes, MessageType type) {
        showMessage(messageStringRes, type, () -> {
        });
    }

    @Override
    public void hideKeyboard() {

    }

    @Override
    public boolean checkPlayServices() {
        return false;
    }

    @Override
    public com.tbruyelle.rxpermissions2.RxPermissions getRxPermissions() {
        return null;
    }

    @Override
    public Observable<Boolean> checkLocationPermission() {
        return null;
    }

    @Override
    public void subscribe(Disposable disposable) {

    }

    public <T> void subscribe(Observable<T> observable, Observer<T> observer) {

    }

    @Override
    public void showLoading(String message) {

    }

    @Override
    public void showLoading(@StringRes int messageId) {

    }

    @Override
    public void showConfirmationDialog(@Nullable String positiveActionText,
                                       @Nullable String negativeActionText,
                                       @NonNull String message,
                                       ConfirmationDialogActionsListener listener) {
    }

    @Override
    public void showMessage(String message, MessageType type, MessageActionListener listener) {

    }

    @Override
    public void showMessage(String message, MessageType type) {

    }

    @Override
    public void showConfirmationDialog(@Nullable String positiveActionText,
                                       @Nullable String negativeActionText,
                                       @StringRes int stringRes,
                                       ConfirmationDialogActionsListener listener) {

    }

    @Override
    public void showConfirmationDialog(@StringRes int positiveActionText,
                                       @StringRes int negativeActionText,
                                       @StringRes int stringRes,
                                       ConfirmationDialogActionsListener listener) {

    }

    @Override
    public boolean isNetworkAvailable() {
        return ActivityUtils.isNetworkAvailable(getActivity());
    }
}
