package com.almawashi.features.items.mvp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.almawashi.R;
import com.almawashi.base.di.component.ApplicationComponent;
import com.almawashi.base.mvp.base.BaseActivity;
import com.almawashi.base.mvp.base.DefaultAdapter;
import com.almawashi.base.mvp.model.entity.Item;
import com.almawashi.features.basket.mvp.ui.activity.BasketActivity;
import com.almawashi.features.items.di.component.DaggerItemsComponent;
import com.almawashi.features.items.di.module.ItemsModule;
import com.almawashi.features.items.mvp.contract.ItemsContract;
import com.almawashi.features.items.mvp.presenter.ItemsPresenter;
import com.almawashi.features.items.mvp.ui.adapter.ItemsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ItemsActivity extends BaseActivity<ItemsPresenter> implements ItemsContract.View {
    private static final String PARAM_CATEGORY_ID = "PARAM_CATEGORY_ID";
    private static final String PARAM_CATEGORY_NAME = "PARAM_CATEGORY_NAME";
    String categoryName;
    @BindView(R.id.tv_main_title)
    AppCompatTextView tvMainTitle;
    @BindView(R.id.rv_items)
    RecyclerView rvItems;
    private ItemsAdapter adapter;

    public static void start(Context context, int categoryId, String categoryName) {
        Intent intent = new Intent(context, ItemsActivity.class);
        intent.putExtra(PARAM_CATEGORY_ID, categoryId);
        intent.putExtra(PARAM_CATEGORY_NAME, categoryName);
        context.startActivity(intent);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_items;
    }

    @Override
    public void onViewReady(Bundle savedInstanceState, Intent intent) {

        Bundle extras = intent.getExtras();
        if (extras != null) {
            categoryName = extras.getString(PARAM_CATEGORY_NAME);
            int categoryId = extras.getInt(PARAM_CATEGORY_ID);

            if (categoryId > 0) getPresenter().startWithData(categoryId);
            else finish();
        } else finish();

        if (!TextUtils.isEmpty(categoryName)) {
            tvMainTitle.setText(categoryName);
        } else {
            // FIXME: 2/28/2018
            tvMainTitle.setText("Items");
        }

        adapter = new ItemsAdapter(new ArrayList<>(0));
        adapter.setOnItemClickListener(
                new DefaultAdapter.OnRecyclerViewItemClickListener<Item>() {
                    @Override
                    public void onItemClick(View view, Item data, int position) {
                        BasketActivity.start(ItemsActivity.this, data);
                    }
                }
        );
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        rvItems.setAdapter(adapter);
    }

    @Override
    public void resolveDaggerDependency(ApplicationComponent appComponent) {
        DaggerItemsComponent
                .builder()
                .applicationComponent(appComponent)
                .itemsModule(new ItemsModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onItemsLoadedSuccessfully(List<Item> items) {
        adapter.replaceItems(items);
    }

    @Override
    public void startBasket() {

    }
}