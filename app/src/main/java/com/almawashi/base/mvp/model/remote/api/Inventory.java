package com.almawashi.base.mvp.model.remote.api;

import com.almawashi.base.mvp.model.entity.BaseResponse;
import com.almawashi.base.mvp.model.entity.Category;
import com.almawashi.base.mvp.model.entity.Item;
import com.almawashi.base.mvp.model.entity.ItemDetailsResponse;
import com.almawashi.base.mvp.model.remote.API;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface Inventory {
    @GET(API.Inventory.GET_ALL_CATEGORIES)
    Single<BaseResponse<List<Category>>> getCategories();

    @GET(API.Inventory.GET_ITEMS_BY_CATEGORY_ID)
    Single<BaseResponse<List<Item>>> getItemsByCategoryId(@Path(API.PARAM_ID) int categoryId);

    @GET(API.Inventory.GET_PURCHASES_DATA)
    Single<BaseResponse<ItemDetailsResponse>> getItemDetailsById(@Path(API.PARAM_ID) int categoryId);
}
