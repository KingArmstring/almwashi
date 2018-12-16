package com.almawashi.features.home.mvp.ui.adapter;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.almawashi.R;
import com.almawashi.base.di.Injector;
import com.almawashi.base.mvp.base.BaseHolder;
import com.almawashi.base.mvp.base.DefaultAdapter;
import com.almawashi.base.mvp.model.entity.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;

public class CategoriesAdapter extends DefaultAdapter<Category> {

    Picasso picasso;

    public CategoriesAdapter(List<Category> items) {
        super(items);
        picasso = Injector.INSTANCE.getAppComponent().exposePicasso();
    }

    @Override
    public BaseHolder<Category> getHolder(View v, int viewType) {
        return new ViewHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_category;
    }

    public class ViewHolder extends BaseHolder<Category> {
        @BindView(R.id.imv_category_picture)
        AppCompatImageView imvMainPicture;
        @BindView(R.id.tv_category_name)
        AppCompatTextView tvCategoryName;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setData(Category data) {
            tvCategoryName.setText(data.getNameEN());
            picasso.load(data.getPictureURL())
                    .fit()
                    .centerCrop()
                    .into(imvMainPicture);
        }
    }
}
