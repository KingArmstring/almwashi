package com.almawashi.base.mvp.model.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.almawashi.base.di.scope.ApplicationQualifier;
import com.almawashi.base.di.scope.ConfigSharedPreferencesNameQualifier;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;



@Singleton
public class SharedPreferencesUtils {

    private SharedPreferences pref;
    private Context context;
    private Gson gson;

    @Inject
    public SharedPreferencesUtils(@ApplicationQualifier Context context, @ConfigSharedPreferencesNameQualifier String sharedPreferencesName, Gson gson) {
        this.pref = context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
        this.context = context;
        this.gson = gson;
    }

    private SharedPreferences getPref() {
        return pref;
    }

    // Primitive
    private void putInt(String key, int value) {
        pref.edit().putInt(key, value).apply();
    }

    private int getInt(String key, int def) {
        return pref.getInt(key, def);
    }

    private void putLong(String key, long value) {
        pref.edit().putLong(key, value).apply();
    }

    private long getLong(String key, long def) {
        return pref.getLong(key, def);
    }

    private void putFloat(String key, float value) {
        pref.edit().putFloat(key, value).apply();
    }

    private float getFloat(String key, float def) {
        return pref.getFloat(key, def);
    }

    private void putBoolean(String key, boolean value) {
        pref.edit().putBoolean(key, value).apply();
    }

    private boolean getBoolean(String key, boolean def) {
        return pref.getBoolean(key, def);
    }

    private void putString(String key, String value) {
        pref.edit().putString(key, value).apply();
    }

    private String getString(String key, String def) {
        return pref.getString(key, def);
    }

    private Set<String> getStringSet(String key, HashSet<String> def) {
        return pref.getStringSet(key, def);
    }

    private void putStringSet(String key, HashSet<String> value) {
        pref.edit().putStringSet(key, value).apply();
    }

    // Date
    private void putDate(String key, Date date) {
        pref.edit().putLong(key, date.getTime()).apply();
    }

    private Date getDate(String key) {
        return new Date(pref.getLong(key, 0));
    }

    // Gson
    private <T> void putObject(String key, T t) {
        pref.edit().putString(key, gson.toJson(t)).apply();
    }

    private <T> T getObject(String key, TypeToken<T> typeToken) {
        String objectString = pref.getString(key, null);
        if (objectString != null) {
            return gson.fromJson(objectString, typeToken.getType());
        }
        return null;
    }

    private void clearData() {
        pref.edit().clear().apply();
    }

    public void putAccessToken(String token) {
        putString(PreferencesContract.ACCESS_TOKEN, token);
    }

    public void putUserName(String userName) {
        putString(PreferencesContract.USER_NAME, userName);
    }

    public boolean isLoggedInUser() {
        String token = getAccessToken();
        return token != null;
    }

    public String getAccessToken() {
        return getString(PreferencesContract.ACCESS_TOKEN, null);
    }

    private static final class PreferencesContract {

        public static final String USER_NAME = "user-name";
        private static final String ACCESS_TOKEN = "access-token";
    }
}
