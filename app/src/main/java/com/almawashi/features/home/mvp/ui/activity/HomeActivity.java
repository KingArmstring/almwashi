package com.almawashi.features.home.mvp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.almawashi.R;
import com.almawashi.base.di.component.ApplicationComponent;
import com.almawashi.base.mvp.base.BaseActivity;
import com.almawashi.base.mvp.model.entity.Category;
import com.almawashi.features.home.di.component.DaggerHomeComponent;
import com.almawashi.features.home.di.module.HomeModule;
import com.almawashi.features.home.mvp.contract.HomeContract;
import com.almawashi.features.home.mvp.presenter.HomePresenter;
import com.almawashi.features.home.mvp.ui.adapter.CategoriesAdapter;
import com.almawashi.features.items.mvp.ui.activity.ItemsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeActivity extends BaseActivity<HomePresenter> implements HomeContract.View {

    @BindView(R.id.rv_categories)
    RecyclerView rvCategories;
    private CategoriesAdapter adapter;

    public static void start(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_home;
    }

    @Override
    public void onViewReady(Bundle savedInstanceState, Intent intent) {
        adapter = new CategoriesAdapter(new ArrayList<>(0));
        adapter.setOnItemClickListener((view, data, position) -> {
            ItemsActivity.start(HomeActivity.this, data.getId(), data.getNameEN());
        });
        rvCategories.setLayoutManager(new LinearLayoutManager(this));
        rvCategories.setAdapter(adapter);
    }

    @Override
    public void resolveDaggerDependency(ApplicationComponent appComponent) {
        DaggerHomeComponent
                .builder()
                .applicationComponent(appComponent)
                .homeModule(new HomeModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onCategoriesLoadedSuccessfully(List<Category> categories) {
        adapter.replaceItems(categories);
    }
}