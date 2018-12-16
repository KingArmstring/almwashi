package com.almawashi.base.utils;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class HorizontalSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private final int horizontalSpaceHeight;

    public HorizontalSpaceItemDecoration(Context context, int horizontalSpaceHeightDp) {
        this.horizontalSpaceHeight = (int) Utils.convertDpToPixel(context, horizontalSpaceHeightDp);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.right = horizontalSpaceHeight / 2;
        outRect.left = horizontalSpaceHeight / 2;
    }
}