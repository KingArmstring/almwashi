package com.almawashi.base.mvp.model.local;


import com.almawashi.application.AlmawashiApplication;

import io.realm.Realm;

public class LocalDataSourceRealm {

    public Realm getLocalDataSource() {
        return AlmawashiApplication.getLocalDatabase();
    }

}
