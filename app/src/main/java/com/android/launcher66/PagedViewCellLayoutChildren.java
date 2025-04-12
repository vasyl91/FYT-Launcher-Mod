package com.android.launcher66;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

public class PagedViewCellLayoutChildren extends ViewGroup {
    static final String TAG = "PagedViewCellLayout";
    private int mCellHeight;
    private int mCellWidth;
    private boolean mCenterContent;
    private int mHeightGap;
    private int mWidthGap;

    public PagedViewCellLayoutChildren(Context context) {
        super(context);
    }

    @Override
    public void cancelLongPress() {
        super.cancelLongPress();
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            child.cancelLongPress();
        }
    }

    public void setGap(int widthGap, int heightGap) {
        this.mWidthGap = widthGap;
        this.mHeightGap = heightGap;
        requestLayout();
    }

    public void setCellDimensions(int width, int height) {
        this.mCellWidth = width;
        this.mCellHeight = height;
        requestLayout();
    }

    @Override
    public void requestChildFocus(View child, View focused) {
        super.requestChildFocus(child, focused);
        if (child != null) {
            Rect r = new Rect();
            child.getDrawingRect(r);
            requestRectangleOnScreen(r);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpecMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = View.MeasureSpec.getSize(heightMeasureSpec);
        if (widthSpecMode == 0 || heightSpecMode == 0) {
            throw new RuntimeException("CellLayout cannot have UNSPECIFIED dimensions");
        }
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            PagedViewCellLayout.LayoutParams lp = (PagedViewCellLayout.LayoutParams) child.getLayoutParams();
            lp.setup(getContext(), this.mCellWidth, this.mCellHeight, this.mWidthGap, this.mHeightGap, getPaddingLeft(), getPaddingTop());
            int childWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(lp.width, MeasureSpec.EXACTLY);
            int childheightMeasureSpec = View.MeasureSpec.makeMeasureSpec(lp.height, MeasureSpec.EXACTLY);
            child.measure(childWidthMeasureSpec, childheightMeasureSpec);
        }
        setMeasuredDimension(widthSpecSize, heightSpecSize);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        int offsetX = 0;
        if (this.mCenterContent && count > 0) {
            int maxRowX = 0;
            int minRowX = Integer.MAX_VALUE;
            for (int i = 0; i < count; i++) {
                View child = getChildAt(i);
                if (child.getVisibility() != View.GONE) {
                    PagedViewCellLayout.LayoutParams lp = (PagedViewCellLayout.LayoutParams) child.getLayoutParams();
                    minRowX = Math.min(minRowX, lp.x);
                    maxRowX = Math.max(maxRowX, lp.x + lp.width);
                }
            }
            int maxRowWidth = maxRowX - minRowX;
            offsetX = (getMeasuredWidth() - maxRowWidth) / 2;
        }
        for (int i2 = 0; i2 < count; i2++) {
            View child2 = getChildAt(i2);
            if (child2.getVisibility() != View.GONE) {
                PagedViewCellLayout.LayoutParams lp2 = (PagedViewCellLayout.LayoutParams) child2.getLayoutParams();
                int childLeft = offsetX + lp2.x;
                int childTop = lp2.y;
                child2.layout(childLeft, childTop, lp2.width + childLeft, lp2.height + childTop);
            }
        }
    }

    public void enableCenteredContent(boolean enabled) {
        this.mCenterContent = enabled;
    }

    @Override
    protected void setChildrenDrawingCacheEnabled(boolean enabled) {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            view.setDrawingCacheEnabled(enabled);
            if (!view.isHardwareAccelerated()) {
                view.buildDrawingCache(true);
            }
        }
    }
}
