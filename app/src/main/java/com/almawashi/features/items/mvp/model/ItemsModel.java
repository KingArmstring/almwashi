package com.almawashi.features.items.mvp.model;

import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.base.BaseModel;
import com.almawashi.base.mvp.base.ICommonRepository;
import com.almawashi.base.mvp.model.entity.Item;
import com.almawashi.features.items.mvp.contract.ItemsContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

@ActivityScope
public class ItemsModel extends BaseModel implements ItemsContract.Model {

    @Inject
    public ItemsModel(ICommonRepository commonRepository) {
        super(commonRepository);
    }

    @Override
    public Single<List<Item>> getItemsByCategoryId(int categoryId) {
        return getRemoteDataSource()
                .getInventory()
                .getItemsByCategoryId(categoryId)
                .flatMap(categoryBaseResponse -> Single.just(categoryBaseResponse.getData()));
    }
}