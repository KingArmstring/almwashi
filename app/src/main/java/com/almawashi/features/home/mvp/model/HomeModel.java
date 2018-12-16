package com.almawashi.features.home.mvp.model;

import com.almawashi.base.di.scope.ActivityScope;
import com.almawashi.base.mvp.base.BaseModel;
import com.almawashi.base.mvp.base.ICommonRepository;
import com.almawashi.base.mvp.model.entity.Category;
import com.almawashi.features.home.mvp.contract.HomeContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

@ActivityScope
public class HomeModel extends BaseModel implements HomeContract.Model {
    @Inject
    public HomeModel(ICommonRepository commonRepository) {
        super(commonRepository);
    }

    @Override
    public Single<List<Category>> getCategories() {
        return getRemoteDataSource()
                .getInventory()
                .getCategories()
                .flatMap(categoryBaseResponse -> Single.just(categoryBaseResponse.getData()));
    }
}