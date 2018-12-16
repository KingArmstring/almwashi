package com.almawashi.features.home.mvp.contract;

import com.almawashi.base.mvp.base.BaseIModel;
import com.almawashi.base.mvp.base.BaseIPresenter;
import com.almawashi.base.mvp.base.BaseIView;
import com.almawashi.base.mvp.model.entity.Category;

import java.util.List;

import io.reactivex.Single;

public interface HomeContract {

    interface View extends BaseIView {

        void onCategoriesLoadedSuccessfully(List<Category> categories);
    }

    interface Model extends BaseIModel {

        Single<List<Category>> getCategories();
    }

    interface Presenter extends BaseIPresenter {

    }

}
