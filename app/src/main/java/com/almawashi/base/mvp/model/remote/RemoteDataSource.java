package com.almawashi.base.mvp.model.remote;


import com.almawashi.base.mvp.model.remote.api.Authentication;
import com.almawashi.base.mvp.model.remote.api.Inventory;

public interface RemoteDataSource {
    Inventory getInventory();

    Authentication getAuthentication();
}
