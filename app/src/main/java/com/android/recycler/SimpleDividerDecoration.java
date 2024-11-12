package com.android.recycler;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class SimpleDividerDecoration extends RecyclerView.ItemDecoration {
    private int dividerHeight = 0;

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(this.dividerHeight, 0, 0, 0);
    }
}
