package com.almawashi.features.basket.mvp.contract;


import com.almawashi.base.mvp.base.BaseIModel;
import com.almawashi.base.mvp.base.BaseIPresenter;
import com.almawashi.base.mvp.base.BaseIView;
import com.almawashi.base.mvp.model.entity.BaseResponse;
import com.almawashi.base.mvp.model.entity.Cutting;
import com.almawashi.base.mvp.model.entity.ItemDetailsResponse;
import com.almawashi.base.mvp.model.entity.Quantity;

import java.util.List;

import io.reactivex.Single;

public interface BasketContract {

    public interface View extends BaseIView {
        public void updateQuantitySpinner(List<Quantity> quantities);
        public void updateCuttingSpinner(List<Cutting> cuttings);
    }

    public interface Model extends BaseIModel {

        public Single<BaseResponse<ItemDetailsResponse>> getItemDetailsById(int id);
    }

    public interface Presenter extends BaseIPresenter {

        void bringPurchaseData(int id);
    }
}
