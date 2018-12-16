package com.almawashi.features.cart.mvp.model;


import com.almawashi.base.mvp.base.BaseModel;
import com.almawashi.base.mvp.base.ICommonRepository;
import com.almawashi.features.cart.mvp.contract.CartContract;

import javax.inject.Inject;

public class CartModel extends BaseModel implements CartContract.Model{

    @Inject
    public CartModel(ICommonRepository commonRepository) {
        super(commonRepository);
    }
}
