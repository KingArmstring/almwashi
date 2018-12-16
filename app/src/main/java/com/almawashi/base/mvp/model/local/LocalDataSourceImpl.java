package com.almawashi.base.mvp.model.local;

import android.content.Context;

import com.almawashi.base.di.scope.ApplicationQualifier;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import timber.log.Timber;

@Singleton
public class LocalDataSourceImpl implements LocalDataSource {

    private final SharedPreferencesUtils mSharedPreferencesUtils;
    private Context mContext;
    private Gson mGson;

    @Inject
    public LocalDataSourceImpl(@ApplicationQualifier Context context, Gson gson,
                               SharedPreferencesUtils sharedPreferencesUtils) {
        this.mContext = context;
        mGson = gson;
        this.mSharedPreferencesUtils = sharedPreferencesUtils;
    }

    @Override
    public SharedPreferencesUtils getSharedPreferences() {
        return mSharedPreferencesUtils;
    }

    @Override
    public Observable<String> loadStringFromAsset(String fileName) {
        return Observable.create(subscriber -> {
            try {
                InputStream is = mContext.getAssets().open(fileName);
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                subscriber.onNext(new String(buffer, "UTF-8"));
                subscriber.onComplete();
            } catch (IOException ex) {
                Timber.e(ex, "loadStringFromAsset: %s", "Error Load File");
                subscriber.onError(ex);
                subscriber.onComplete();
            }
        });
    }

    @Override
    public Gson getGson() {
        return mGson;
    }
}
