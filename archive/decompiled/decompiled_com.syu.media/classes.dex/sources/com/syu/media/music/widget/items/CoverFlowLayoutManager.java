package com.syu.media.music.widget.items;

import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CoverFlowLayoutManager extends RecyclerView.LayoutManager {
    private int mIntervalWidth;
    private int mItemHeight;
    private int mItemWidth;
    private int mStartX;
    private int mSumDx = 0;
    private int mTotalWidth = 0;
    private SparseArray<Rect> mItemRects = new SparseArray<>();
    private SparseBooleanArray mHasAttachedItems = new SparseBooleanArray();
    private float M_MAX_ROTATION_Y = 30.0f;

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Log.d("LZP", "onLayoutChildren");
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(recycler);
            return;
        }
        this.mHasAttachedItems.clear();
        this.mItemRects.clear();
        detachAndScrapAttachedViews(recycler);
        View viewForPosition = recycler.getViewForPosition(0);
        measureChildWithMargins(viewForPosition, 0, 0);
        this.mItemWidth = getDecoratedMeasuredWidth(viewForPosition);
        this.mItemHeight = getDecoratedMeasuredHeight(viewForPosition);
        this.mIntervalWidth = getIntervalWidth();
        this.mStartX = (getWidth() / 2) - this.mIntervalWidth;
        int i = 0;
        for (int i2 = 0; i2 < getItemCount(); i2++) {
            int i3 = this.mStartX;
            this.mItemRects.put(i2, new Rect(i3 + i, 0, i3 + i + this.mItemWidth, this.mItemHeight));
            this.mHasAttachedItems.put(i2, false);
            i += this.mIntervalWidth;
        }
        int horizontalSpace = getHorizontalSpace() / this.mIntervalWidth;
        Rect visibleArea = getVisibleArea();
        for (int i4 = 0; i4 < horizontalSpace; i4++) {
            insertView(i4, visibleArea, recycler, false);
        }
        this.mTotalWidth = Math.max(i, getHorizontalSpace());
    }

    private int getHorizontalSpace() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Log.d("LZP", "scrollHorizontallyBy");
        if (getChildCount() <= 0) {
            return i;
        }
        int i2 = this.mSumDx;
        if (i2 + i < 0) {
            i = -i2;
        } else if (i2 + i > getMaxOffset()) {
            i = getMaxOffset() - this.mSumDx;
        }
        this.mSumDx += i;
        Rect visibleArea = getVisibleArea();
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int position = getPosition(childAt);
            Rect rect = this.mItemRects.get(position);
            if (!Rect.intersects(rect, visibleArea)) {
                removeAndRecycleView(childAt, recycler);
                this.mHasAttachedItems.put(position, false);
            } else {
                layoutDecoratedWithMargins(childAt, rect.left - this.mSumDx, rect.top, rect.right - this.mSumDx, rect.bottom);
                handleChildView(childAt, (rect.left - this.mStartX) - this.mSumDx);
                this.mHasAttachedItems.put(position, true);
            }
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        View childAt3 = getChildAt(0);
        if (i >= 0) {
            for (int position2 = getPosition(childAt3); position2 < getItemCount(); position2++) {
                insertView(position2, visibleArea, recycler, false);
            }
        } else {
            for (int position3 = getPosition(childAt2); position3 >= 0; position3--) {
                insertView(position3, visibleArea, recycler, true);
            }
        }
        return i;
    }

    private void insertView(int i, Rect rect, RecyclerView.Recycler recycler, boolean z) {
        Rect rect2 = this.mItemRects.get(i);
        if (!Rect.intersects(rect, rect2) || this.mHasAttachedItems.get(i)) {
            return;
        }
        View viewForPosition = recycler.getViewForPosition(i);
        if (z) {
            addView(viewForPosition, 0);
        } else {
            addView(viewForPosition);
        }
        measureChildWithMargins(viewForPosition, 0, 0);
        layoutDecoratedWithMargins(viewForPosition, rect2.left - this.mSumDx, rect2.top, rect2.right - this.mSumDx, rect2.bottom);
        this.mHasAttachedItems.put(i, true);
        handleChildView(viewForPosition, (rect2.left - this.mSumDx) - this.mStartX);
    }

    private Rect getVisibleArea() {
        return new Rect(getPaddingLeft() + this.mSumDx, getPaddingTop(), (getWidth() - getPaddingRight()) + this.mSumDx, getHeight() - getPaddingBottom());
    }

    public int getIntervalWidth() {
        return this.mItemWidth / 2;
    }

    public int getCenterPosition() {
        int intervalWidth = this.mSumDx / getIntervalWidth();
        return ((float) (this.mSumDx % getIntervalWidth())) > ((float) getIntervalWidth()) * 0.5f ? intervalWidth + 1 : intervalWidth;
    }

    public int getFirstVisiblePosition() {
        if (getChildCount() <= 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    private void handleChildView(View view, int i) {
        computeScale(i);
        computeRotationY(i);
    }

    private float computeScale(int i) {
        float fAbs = 1.0f - Math.abs((i * 2.0f) / (getIntervalWidth() * 8.0f));
        if (fAbs < 0.0f) {
            fAbs = 0.0f;
        }
        if (fAbs > 1.0f) {
            return 1.0f;
        }
        return fAbs;
    }

    private int getMaxOffset() {
        return (getItemCount() - 1) * getIntervalWidth();
    }

    public double calculateDistance(int i, double d) {
        int intervalWidth = this.mSumDx % getIntervalWidth();
        if (i <= 0) {
            return d < ((double) getIntervalWidth()) ? intervalWidth : (d - (d % ((double) getIntervalWidth()))) + ((double) intervalWidth);
        }
        if (d < getIntervalWidth()) {
            return getIntervalWidth() - intervalWidth;
        }
        return (d - (d % ((double) getIntervalWidth()))) - ((double) intervalWidth);
    }

    private float computeRotationY(int i) {
        float intervalWidth = ((-this.M_MAX_ROTATION_Y) * i) / getIntervalWidth();
        float fAbs = Math.abs(intervalWidth);
        float f = this.M_MAX_ROTATION_Y;
        if (fAbs > f) {
            return intervalWidth > 0.0f ? f : -f;
        }
        return intervalWidth;
    }
}
