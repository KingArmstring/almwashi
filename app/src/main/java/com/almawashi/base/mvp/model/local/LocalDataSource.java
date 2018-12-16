package com.almawashi.base.mvp.model.local;

import com.google.gson.Gson;

import io.reactivex.Observable;


public interface LocalDataSource {
    SharedPreferencesUtils getSharedPreferences();

    Observable<String> loadStringFromAsset(String fileName);

    Gson getGson();
}
