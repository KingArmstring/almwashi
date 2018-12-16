package com.almawashi.base.mvp.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import com.almawashi.base.utils.ConfirmationDialogActionsListener;
import com.almawashi.base.utils.MessageActionListener;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public interface BaseIView {

    void showLoading();

    void showLoading(String message);

    void showLoading(@StringRes int messageId);

    void hideLoading();

    void showMessage(String message);

    void showMessage(String message, MessageType type);

    void showMessage(String message, MessageType type, MessageActionListener listener);

    void showMessage(@StringRes int messageStringRes, MessageType type);

    void showMessage(@StringRes int messageStringRes, MessageType type, MessageActionListener listener);

    void showConfirmationDialog(@Nullable String positiveActionText,
                                @Nullable String negativeActionText,
                                @NonNull String message,
                                ConfirmationDialogActionsListener listener);

    void showConfirmationDialog(@Nullable String positiveActionText,
                                @Nullable String negativeActionText,
                                @StringRes int stringRes,
                                ConfirmationDialogActionsListener listener);

    void showConfirmationDialog(@StringRes int positiveActionText,
                                @StringRes int negativeActionText,
                                @StringRes int stringRes,
                                ConfirmationDialogActionsListener listener);

    com.tbruyelle.rxpermissions2.RxPermissions getRxPermissions();

    Observable<Boolean> checkLocationPermission();

    void subscribe(Disposable disposable);

    boolean isNetworkAvailable();

    boolean checkPlayServices();

    void hideKeyboard();
}
