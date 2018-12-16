package com.almawashi.features.items.mvp.contract;

import com.almawashi.base.mvp.base.BaseIModel;
import com.almawashi.base.mvp.base.BaseIPresenter;
import com.almawashi.base.mvp.base.BaseIView;
import com.almawashi.base.mvp.model.entity.Item;

import java.util.List;

import io.reactivex.Single;

public interface ItemsContract {

    interface View extends BaseIView {

        void onItemsLoadedSuccessfully(List<Item> items);
        void startBasket();
    }

    interface Model extends BaseIModel {

        Single<List<Item>> getItemsByCategoryId(int categoryId);
    }

    interface Presenter extends BaseIPresenter {

        void startWithData(int categoryId);
    }

}
