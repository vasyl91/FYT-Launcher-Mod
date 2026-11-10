package com.syu.media.music.widget.items;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CoverFlowLayoutManger1 extends RecyclerView.LayoutManager {
    private static final int MAX_RECT_COUNT = 100;
    private static final int SCROLL_TO_LEFT = 2;
    private static final int SCROLL_TO_RIGHT = 1;
    private ValueAnimator mAnimation;
    private float mIntervalRatio;
    private boolean mIsFlatFlow;
    private boolean mIsLoop;
    private boolean mItem3D;
    private boolean mItemGradualAlpha;
    private boolean mItemGradualGrey;
    private RecyclerView.Recycler mRecycle;
    private OnSelected mSelectedListener;
    private RecyclerView.State mState;
    private int mOffsetAll = 0;
    private int mDecoratedChildWidth = 0;
    private int mDecoratedChildHeight = 0;
    private int mStartX = 0;
    private int mStartY = 0;
    private SparseArray<Rect> mAllItemFrames = new SparseArray<>();
    private SparseBooleanArray mHasAttachedItems = new SparseBooleanArray();
    private int mSelectPosition = 0;
    private int mLastSelectPosition = 0;

    public interface OnSelected {
        void onItemSelected(int i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return true;
    }

    public CoverFlowLayoutManger1(boolean z, boolean z2, boolean z3, float f, boolean z4, boolean z5) {
        this.mIntervalRatio = 0.5f;
        this.mIsFlatFlow = z;
        this.mItemGradualGrey = z2;
        this.mItemGradualAlpha = z3;
        this.mIsLoop = z4;
        this.mItem3D = z5;
        if (f >= 0.0f) {
            this.mIntervalRatio = f;
        } else if (z) {
            this.mIntervalRatio = 1.1f;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        if (getItemCount() <= 0 || state.isPreLayout()) {
            this.mOffsetAll = 0;
            return;
        }
        this.mAllItemFrames.clear();
        this.mHasAttachedItems.clear();
        View viewForPosition = recycler.getViewForPosition(0);
        addView(viewForPosition);
        measureChildWithMargins(viewForPosition, 0, 0);
        this.mDecoratedChildWidth = getDecoratedMeasuredWidth(viewForPosition);
        this.mDecoratedChildHeight = getDecoratedMeasuredHeight(viewForPosition);
        this.mStartX = Math.round(((getHorizontalSpace() - this.mDecoratedChildWidth) * 1.0f) / 2.0f);
        this.mStartY = Math.round(((getVerticalSpace() - this.mDecoratedChildHeight) * 1.0f) / 2.0f);
        float intervalDistance = this.mStartX;
        for (int i2 = 0; i2 < getItemCount() && i2 < 100; i2++) {
            Rect rect = this.mAllItemFrames.get(i2);
            if (rect == null) {
                rect = new Rect();
            }
            rect.set(Math.round(intervalDistance), this.mStartY, Math.round(this.mDecoratedChildWidth + intervalDistance), this.mStartY + this.mDecoratedChildHeight);
            this.mAllItemFrames.put(i2, rect);
            this.mHasAttachedItems.put(i2, false);
            intervalDistance += getIntervalDistance();
        }
        detachAndScrapAttachedViews(recycler);
        if ((this.mRecycle == null || this.mState == null) && (i = this.mSelectPosition) != 0) {
            this.mOffsetAll = calculateOffsetForPosition(i);
            onSelectedCallBack();
        }
        layoutItems(recycler, state, 2);
        this.mRecycle = recycler;
        this.mState = state;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002f  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int maxOffset;
        ValueAnimator valueAnimator = this.mAnimation;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAnimation.cancel();
        }
        if (this.mIsLoop) {
            maxOffset = i;
        } else {
            int i2 = this.mOffsetAll;
            if (i + i2 < 0) {
                maxOffset = -i2;
            } else if (i2 + i > getMaxOffset()) {
                maxOffset = (int) (getMaxOffset() - this.mOffsetAll);
            } else {
                maxOffset = i;
            }
        }
        this.mOffsetAll += maxOffset;
        layoutItems(recycler, state, i > 0 ? 2 : 1);
        return maxOffset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void layoutItems(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        int position;
        if (state == null || state.isPreLayout()) {
            return;
        }
        int i2 = this.mOffsetAll;
        Rect rect = new Rect(i2, 0, getHorizontalSpace() + i2, getVerticalSpace());
        int i3 = 0;
        int centerPosition = 0;
        while (i3 < getChildCount()) {
            View childAt = getChildAt(i3);
            if (childAt.getTag() != null) {
                position = checkTag(childAt.getTag()).pos;
            } else {
                position = getPosition(childAt);
            }
            Rect frame = getFrame(position);
            if (!Rect.intersects(rect, frame)) {
                removeAndRecycleView(childAt, recycler);
                this.mHasAttachedItems.delete(position);
            } else {
                layoutItem(childAt, frame);
                this.mHasAttachedItems.put(position, true);
            }
            i3++;
            centerPosition = position;
        }
        if (centerPosition == 0) {
            centerPosition = getCenterPosition();
        }
        int i4 = centerPosition - 20;
        int itemCount = centerPosition + 20;
        if (!this.mIsLoop) {
            if (i4 < 0) {
                i4 = 0;
            }
            if (itemCount > getItemCount()) {
                itemCount = getItemCount();
            }
        }
        while (i4 < itemCount) {
            Rect frame2 = getFrame(i4);
            if (Rect.intersects(rect, frame2) && !this.mHasAttachedItems.get(i4)) {
                int itemCount2 = i4 % getItemCount();
                if (itemCount2 < 0) {
                    itemCount2 += getItemCount();
                }
                View viewForPosition = recycler.getViewForPosition(itemCount2);
                checkTag(viewForPosition.getTag());
                viewForPosition.setTag(new TAG(i4));
                measureChildWithMargins(viewForPosition, 0, 0);
                if (i == 1 || this.mIsFlatFlow) {
                    addView(viewForPosition, 0);
                } else {
                    addView(viewForPosition);
                }
                layoutItem(viewForPosition, frame2);
                this.mHasAttachedItems.put(i4, true);
            }
            i4++;
        }
    }

    private void layoutItem(View view, Rect rect) {
        layoutDecorated(view, rect.left - this.mOffsetAll, rect.top, rect.right - this.mOffsetAll, rect.bottom);
        if (!this.mIsFlatFlow) {
            view.setScaleX(computeScale(rect.left - this.mOffsetAll));
            view.setScaleY(computeScale(rect.left - this.mOffsetAll));
        }
        if (this.mItemGradualAlpha) {
            view.setAlpha(computeAlpha(rect.left - this.mOffsetAll));
        }
        if (this.mItemGradualGrey) {
            greyItem(view, rect);
        }
        if (this.mItem3D) {
            item3D(view, rect);
        }
    }

    private Rect getFrame(int i) {
        Rect rect = this.mAllItemFrames.get(i);
        if (rect != null) {
            return rect;
        }
        Rect rect2 = new Rect();
        float intervalDistance = this.mStartX + (getIntervalDistance() * i);
        rect2.set(Math.round(intervalDistance), this.mStartY, Math.round(intervalDistance + this.mDecoratedChildWidth), this.mStartY + this.mDecoratedChildHeight);
        return rect2;
    }

    private void greyItem(View view, Rect rect) {
        float fComputeGreyScale = computeGreyScale(rect.left - this.mOffsetAll);
        float f = 1.0f - fComputeGreyScale;
        float f2 = 120.0f * f;
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{fComputeGreyScale, 0.0f, 0.0f, 0.0f, f2, 0.0f, fComputeGreyScale, 0.0f, 0.0f, f2, 0.0f, 0.0f, fComputeGreyScale, 0.0f, f2, 0.0f, 0.0f, 0.0f, 1.0f, f * 250.0f});
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        view.setLayerType(2, paint);
        if (fComputeGreyScale >= 1.0f) {
            view.setLayerType(0, null);
        }
    }

    private void item3D(View view, Rect rect) {
        float f = ((rect.left + rect.right) - (this.mOffsetAll * 2)) / 2.0f;
        view.setRotationY((f > ((float) this.mStartX) + (((float) this.mDecoratedChildWidth) / 2.0f) ? -1.0f : 1.0f) * 50.0f * ((float) Math.sqrt(Math.abs(((f - (this.mStartX + (this.mDecoratedChildWidth / 2.0f))) * 1.0f) / (getItemCount() * getIntervalDistance())))));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        if (i != 0) {
            return;
        }
        fixOffsetWhenFinishScroll();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        RecyclerView.State state;
        if (i >= 0) {
            if (i > getItemCount() - 1) {
                return;
            }
            this.mOffsetAll = calculateOffsetForPosition(i);
            RecyclerView.Recycler recycler = this.mRecycle;
            if (recycler == null || (state = this.mState) == null) {
                this.mSelectPosition = i;
            } else {
                layoutItems(recycler, state, i > this.mSelectPosition ? 2 : 1);
                onSelectedCallBack();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        if (this.mIsLoop) {
            return;
        }
        int iCalculateOffsetForPosition = calculateOffsetForPosition(i);
        if (this.mRecycle == null || this.mState == null) {
            this.mSelectPosition = i;
        } else {
            startScroll(this.mOffsetAll, iCalculateOffsetForPosition);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
        this.mRecycle = null;
        this.mState = null;
        this.mOffsetAll = 0;
        this.mSelectPosition = 0;
        this.mLastSelectPosition = 0;
        this.mHasAttachedItems.clear();
        this.mAllItemFrames.clear();
    }

    private int getHorizontalSpace() {
        return (getWidth() - getPaddingRight()) - getPaddingLeft();
    }

    private int getVerticalSpace() {
        return (getHeight() - getPaddingBottom()) - getPaddingTop();
    }

    private float getMaxOffset() {
        return (getItemCount() - 1) * getIntervalDistance();
    }

    private float computeScale(int i) {
        float fAbs = 1.0f - ((Math.abs(i - this.mStartX) * 1.0f) / Math.abs(this.mStartX + (this.mDecoratedChildWidth / this.mIntervalRatio)));
        if (fAbs < 0.0f) {
            fAbs = 0.0f;
        }
        if (fAbs > 1.0f) {
            return 1.0f;
        }
        return fAbs;
    }

    private float computeGreyScale(int i) {
        float fAbs = 1.0f - ((Math.abs((i + (this.mDecoratedChildWidth / 2)) - (getHorizontalSpace() / 2.0f)) * 1.0f) / (getHorizontalSpace() / 2));
        if (fAbs < 0.1d) {
            fAbs = 0.1f;
        }
        return (float) Math.pow(fAbs <= 1.0f ? fAbs : 1.0f, 0.8d);
    }

    private float computeAlpha(int i) {
        float fAbs = 1.0f - ((Math.abs(i - this.mStartX) * 1.0f) / Math.abs(this.mStartX + (this.mDecoratedChildWidth / this.mIntervalRatio)));
        if (fAbs < 0.3f) {
            fAbs = 0.3f;
        }
        if (fAbs > 1.0f) {
            return 1.0f;
        }
        return fAbs;
    }

    private int calculateOffsetForPosition(int i) {
        return Math.round(getIntervalDistance() * i);
    }

    private void fixOffsetWhenFinishScroll() {
        if (getIntervalDistance() != 0) {
            int intervalDistance = (int) ((this.mOffsetAll * 1.0f) / getIntervalDistance());
            float intervalDistance2 = this.mOffsetAll % getIntervalDistance();
            if (Math.abs(intervalDistance2) > ((double) getIntervalDistance()) * 0.5d) {
                intervalDistance = intervalDistance2 > 0.0f ? intervalDistance + 1 : intervalDistance - 1;
            }
            int intervalDistance3 = intervalDistance * getIntervalDistance();
            startScroll(this.mOffsetAll, intervalDistance3);
            this.mSelectPosition = Math.abs(Math.round((intervalDistance3 * 1.0f) / getIntervalDistance())) % getItemCount();
        }
    }

    private void startScroll(int i, int i2) {
        ValueAnimator valueAnimator = this.mAnimation;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAnimation.cancel();
        }
        final int i3 = i < i2 ? 2 : 1;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(i, i2);
        this.mAnimation = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.mAnimation.setInterpolator(new DecelerateInterpolator());
        this.mAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.syu.media.music.widget.items.CoverFlowLayoutManger1.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CoverFlowLayoutManger1.this.mOffsetAll = Math.round(((Float) valueAnimator2.getAnimatedValue()).floatValue());
                CoverFlowLayoutManger1 coverFlowLayoutManger1 = CoverFlowLayoutManger1.this;
                coverFlowLayoutManger1.layoutItems(coverFlowLayoutManger1.mRecycle, CoverFlowLayoutManger1.this.mState, i3);
            }
        });
        this.mAnimation.addListener(new Animator.AnimatorListener() { // from class: com.syu.media.music.widget.items.CoverFlowLayoutManger1.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CoverFlowLayoutManger1.this.onSelectedCallBack();
            }
        });
        this.mAnimation.start();
    }

    private int getIntervalDistance() {
        return Math.round(this.mDecoratedChildWidth * this.mIntervalRatio);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSelectedCallBack() {
        int iRound = Math.round(this.mOffsetAll / getIntervalDistance());
        this.mSelectPosition = iRound;
        int iAbs = Math.abs(iRound % getItemCount());
        this.mSelectPosition = iAbs;
        OnSelected onSelected = this.mSelectedListener;
        if (onSelected != null && iAbs != this.mLastSelectPosition) {
            onSelected.onItemSelected(iAbs);
        }
        this.mLastSelectPosition = this.mSelectPosition;
    }

    private TAG checkTag(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof TAG) {
            return (TAG) obj;
        }
        throw new IllegalArgumentException("You should not use View#setTag(Object tag), use View#setTag(int key, Object tag) instead!");
    }

    public int getFirstVisiblePosition() {
        int i = this.mOffsetAll;
        Rect rect = new Rect(i, 0, getHorizontalSpace() + i, getVerticalSpace());
        int centerPosition = getCenterPosition();
        do {
            centerPosition--;
        } while (getFrame(centerPosition).left > rect.left);
        return Math.abs(centerPosition) % getItemCount();
    }

    public int getLastVisiblePosition() {
        int i = this.mOffsetAll;
        Rect rect = new Rect(i, 0, getHorizontalSpace() + i, getVerticalSpace());
        int centerPosition = getCenterPosition();
        do {
            centerPosition++;
        } while (getFrame(centerPosition).right < rect.right);
        return Math.abs(centerPosition) % getItemCount();
    }

    int getChildActualPos(int i) {
        View childAt = getChildAt(i);
        if (childAt.getTag() != null) {
            return checkTag(childAt.getTag()).pos;
        }
        return getPosition(childAt);
    }

    public int getMaxVisibleCount() {
        return (((getHorizontalSpace() - this.mStartX) / getIntervalDistance()) * 2) + 1;
    }

    int getCenterPosition() {
        int intervalDistance = this.mOffsetAll / getIntervalDistance();
        int intervalDistance2 = this.mOffsetAll % getIntervalDistance();
        if (Math.abs(intervalDistance2) >= getIntervalDistance() * 0.5f) {
            return intervalDistance2 >= 0 ? intervalDistance + 1 : intervalDistance - 1;
        }
        return intervalDistance;
    }

    public void setOnSelectedListener(OnSelected onSelected) {
        this.mSelectedListener = onSelected;
    }

    public int getSelectedPos() {
        return this.mSelectPosition;
    }

    private class TAG {
        int pos;

        TAG(int i) {
            this.pos = i;
        }
    }

    static class Builder {
        boolean isFlat = false;
        boolean isGreyItem = false;
        boolean isAlphaItem = false;
        float cstIntervalRatio = -1.0f;
        boolean isLoop = false;
        boolean is3DItem = false;

        Builder() {
        }

        Builder setFlat(boolean z) {
            this.isFlat = z;
            return this;
        }

        Builder setGreyItem(boolean z) {
            this.isGreyItem = z;
            return this;
        }

        Builder setAlphaItem(boolean z) {
            this.isAlphaItem = z;
            return this;
        }

        Builder setIntervalRatio(float f) {
            this.cstIntervalRatio = f;
            return this;
        }

        Builder loop() {
            this.isLoop = true;
            return this;
        }

        Builder set3DItem(boolean z) {
            this.is3DItem = true;
            return this;
        }

        public CoverFlowLayoutManger1 build() {
            return new CoverFlowLayoutManger1(this.isFlat, this.isGreyItem, this.isAlphaItem, this.cstIntervalRatio, this.isLoop, this.is3DItem);
        }
    }
}
