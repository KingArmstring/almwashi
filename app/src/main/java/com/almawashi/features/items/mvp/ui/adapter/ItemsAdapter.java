package com.almawashi.features.items.mvp.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.almawashi.R;
import com.almawashi.base.di.Injector;
import com.almawashi.base.mvp.base.BaseHolder;
import com.almawashi.base.mvp.base.DefaultAdapter;
import com.almawashi.base.mvp.model.entity.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;



public class ItemsAdapter extends DefaultAdapter<Item> {

    Picasso picasso;

    public ItemsAdapter(List<Item> items) {
        super(items);
        picasso = Injector.INSTANCE.getAppComponent().exposePicasso();
    }

    @Override
    public BaseHolder<Item> getHolder(View v, int viewType) {
        return new ViewHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_single_item;
    }

    public class ViewHolder extends BaseHolder<Item> {
        @BindView(R.id.imv_item_picture)
        ImageView imvItemPicture;
        @BindView(R.id.tv_item_name)
        TextView tvItemName;
        @BindView(R.id.tv_item_weight)
        TextView tvItemWeight;
        @BindView(R.id.tv_item_price)
        TextView tvItemPrice;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setData(Item data) {
            tvItemName.setText(data.getNameEN());
            tvItemPrice.setText(data.getFinalPrice() + " AED");
            tvItemWeight.setText(data.getWeight());

            picasso.load(data.getPictureURL())
                    .fit()
                    .centerCrop()
                    .into(imvItemPicture);
        }
    }
}
