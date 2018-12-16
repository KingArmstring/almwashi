package com.almawashi.base.utils;

import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;


public class LocalLogger implements HttpLoggingInterceptor.Logger {
    @Override
    public void log(String message) {
        Timber.tag("OkHttpClient").d(message);
    }
}
