package com.almawashi.features.basket.mvp.model;

import com.almawashi.base.mvp.base.BaseModel;
import com.almawashi.base.mvp.base.ICommonRepository;
import com.almawashi.base.mvp.model.entity.BaseResponse;
import com.almawashi.base.mvp.model.entity.ItemDetailsResponse;
import com.almawashi.features.basket.mvp.contract.BasketContract;

import javax.inject.Inject;

import io.reactivex.Single;


public class BasketModel extends BaseModel implements BasketContract.Model {

    @Inject
    public BasketModel(ICommonRepository commonRepository) {
        super(commonRepository);
    }

    @Override
    public Single<BaseResponse<ItemDetailsResponse>> getItemDetailsById(int id) {
        return getRemoteDataSource()
                .getInventory()
                .getItemDetailsById(id);
    }
}
