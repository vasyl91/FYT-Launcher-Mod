package com.android.launcher66;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridLayout;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class PagedViewGridLayout extends GridLayout implements Page {
    static final String TAG = "PagedViewGridLayout";
    private int mCellCountX;
    private int mCellCountY;
    private Runnable mOnLayoutListener;

    public PagedViewGridLayout(Context context, int cellCountX, int cellCountY) {
        super(context, null, 0);
        this.mCellCountX = cellCountX;
        this.mCellCountY = cellCountY;
    }

    int getCellCountX() {
        return this.mCellCountX;
    }

    int getCellCountY() {
        return this.mCellCountY;
    }

    public void resetChildrenOnKeyListeners() {
        int childCount = getChildCount();
        for (int j = 0; j < childCount; j++) {
            getChildAt(j).setOnKeyListener(null);
        }
    }

    @Override // android.widget.GridLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpecSize = Math.min(getSuggestedMinimumWidth(), View.MeasureSpec.getSize(widthMeasureSpec));
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(widthSpecSize, MeasureSpec.EXACTLY), heightMeasureSpec);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mOnLayoutListener = null;
    }

    public void setOnLayoutListener(Runnable r) {
        this.mOnLayoutListener = r;
    }

    @Override // android.widget.GridLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.mOnLayoutListener != null) {
            this.mOnLayoutListener.run();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = super.onTouchEvent(event);
        int count = getPageChildCount();
        if (count > 0) {
            View child = getChildOnPageAt(count - 1);
            int bottom = child.getBottom();
            return result || event.getY() < ((float) bottom);
        }
        return result;
    }

    @Override // com.android.launcher66.Page
    public void removeAllViewsOnPage() {
        removeAllViews();
        this.mOnLayoutListener = null;
        setLayerType(View.LAYER_TYPE_NONE, null);
    }

    @Override // com.android.launcher66.Page
    public void removeViewOnPageAt(int index) {
        removeViewAt(index);
    }

    @Override // com.android.launcher66.Page
    public int getPageChildCount() {
        return getChildCount();
    }

    @Override // com.android.launcher66.Page
    public View getChildOnPageAt(int i) {
        return getChildAt(i);
    }

    @Override // com.android.launcher66.Page
    public int indexOfChildOnPage(View v) {
        return indexOfChild(v);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public LayoutParams(int width, int height) {
            super(width, height);
        }
    }
}
