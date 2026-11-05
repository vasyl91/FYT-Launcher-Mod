package com.syu.media.music.widget;

import android.animation.ValueAnimator;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class SpinLayoutManager extends RecyclerView.LayoutManager {
    private ValueAnimator mAnimation;
    private int mItemCount;
    private final float mItemHeightWidthRatio;
    private int mItemViewHeight;
    private int mItemViewWidth;
    private RecyclerView.Recycler mRecycle;
    private final float mScale;
    private RecyclerView.State mState;
    private final String TAG = "SpinLayoutManager";
    private boolean mHasChild = false;
    private final int ROTATION_Y = 115;
    private int mScrollOffset = Integer.MAX_VALUE;
    private float mOffsetPercent = 0.67f;
    public boolean isReverseDirection = true;
    private final SpinSnapHelper mSkidRightSnapHelper = new SpinSnapHelper();

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return true;
    }

    public SpinLayoutManager(float f, float f2) {
        this.mItemHeightWidthRatio = f;
        this.mScale = f2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.mSkidRightSnapHelper.attachToRecyclerView(recyclerView);
    }

    public int getFixedScrollPosition(int i, float f) {
        if (!this.mHasChild || this.mScrollOffset % this.mItemViewWidth == 0) {
            return -1;
        }
        float fPosition = position();
        int i2 = ((int) (i > 0 ? fPosition + f : fPosition + (1.0f - f))) - 1;
        int iConvert2AdapterPosition = convert2AdapterPosition(i2);
        Log.d("SpinLayoutManager", "layoutPosition:" + i2 + ",pos:" + iConvert2AdapterPosition);
        return iConvert2AdapterPosition;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getItemCount() == 0 || state.isPreLayout()) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        if (!this.mHasChild) {
            View viewForPosition = recycler.getViewForPosition(0);
            addView(viewForPosition);
            measureChildWithMargins(viewForPosition, 0, 0);
            this.mItemViewWidth = getDecoratedMeasuredWidth(viewForPosition);
            this.mItemViewHeight = getVerticalSpace();
            this.mHasChild = true;
            this.mRecycle = recycler;
            this.mState = state;
        }
        Log.d("SpinLayoutManager", "mItemViewWidth:" + this.mItemViewWidth);
        this.mScrollOffset = makeScrollOffsetWithinRange(this.mScrollOffset);
        fill(recycler);
    }

    private float position() {
        int i = this.mItemViewWidth;
        if (i == 0) {
            return -1.0f;
        }
        if (!this.isReverseDirection) {
            return (this.mScrollOffset * 1.0f) / i;
        }
        int i2 = this.mScrollOffset;
        int itemCount = getItemCount();
        int i3 = this.mItemViewWidth;
        return ((i2 + (itemCount * i3)) * 1.0f) / i3;
    }

    public void fill(RecyclerView.Recycler recycler) {
        int i;
        int i2;
        String str;
        int i3;
        int i4;
        String str2;
        String str3 = "SpinLayoutManager";
        Log.d("SpinLayoutManager", "fill mItemViewWidth:" + this.mItemViewWidth);
        if (getItemCount() == 0 || this.mItemViewWidth == 0) {
            return;
        }
        int iFloor = (int) Math.floor(position());
        int horizontalSpace = getHorizontalSpace();
        if (this.isReverseDirection) {
            int itemCount = getItemCount() - 1;
            i2 = this.mItemViewWidth;
            i = (itemCount * i2) + this.mScrollOffset;
        } else {
            i = this.mScrollOffset;
            i2 = this.mItemViewWidth;
        }
        int i5 = i % i2;
        int i6 = this.mItemViewWidth;
        float f = (i5 * 1.0f) / i6;
        boolean z = this.isReverseDirection;
        int i7 = z ? 0 : horizontalSpace - i6;
        int horizontalSpace2 = z ? (int) (i6 - (i6 * this.mOffsetPercent)) : getHorizontalSpace() - this.mItemViewWidth;
        ArrayList arrayList = new ArrayList();
        int i8 = iFloor - 1;
        int i9 = 1;
        while (true) {
            if (i8 < 0) {
                str = str3;
                i3 = i5;
                i4 = 0;
                break;
            }
            int i10 = i7;
            int i11 = horizontalSpace2;
            String str4 = str3;
            double dPow = ((double) horizontalSpace2) * Math.pow(this.mScale, i9);
            double d = i10;
            int i12 = (int) (d - (((double) (this.isReverseDirection ? -f : f)) * dPow));
            i3 = i5;
            str = str4;
            int i13 = i8;
            int i14 = i9;
            double d2 = i9 - 1;
            float f2 = horizontalSpace;
            LayoutState layoutState = new LayoutState(i12, (float) (Math.pow(this.mScale, d2) * ((double) (1.0f - ((1.0f - this.mScale) * f)))), f, (i12 * 1.0f) / f2);
            i4 = 0;
            arrayList.add(0, layoutState);
            boolean z2 = this.isReverseDirection;
            if (!z2) {
                dPow = -dPow;
            }
            int i15 = (int) (d + dPow);
            if (!z2 ? i15 > 0 : i15 <= getHorizontalSpace() + (-50)) {
                layoutState.setTop((int) (((double) i15) - dPow));
                layoutState.setPositionOffset(0.0f);
                layoutState.setLayoutPercent((layoutState.getTop() * 1.0f) / f2);
                layoutState.setScaleXY((float) Math.pow(this.mScale, d2));
                break;
            }
            i8 = i13 - 1;
            i9 = i14 + 1;
            i7 = i15;
            i5 = i3;
            horizontalSpace2 = i11;
            str3 = str;
        }
        if (iFloor < getItemCount()) {
            int i16 = this.isReverseDirection ? i3 - this.mItemViewWidth : horizontalSpace - i3;
            arrayList.add(new LayoutState(i16, 1.0f, f, (i16 * 1.0f) / horizontalSpace));
        } else {
            iFloor--;
        }
        int size = arrayList.size();
        int i17 = iFloor - (size - 1);
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int iConvert2LayoutPosition = convert2LayoutPosition(getPosition(childAt));
            if (iConvert2LayoutPosition > iFloor || iConvert2LayoutPosition < i17) {
                childAt.animate().rotationY(0.0f).setDuration(0L).start();
                removeAndRecycleView(childAt, recycler);
            }
        }
        detachAndScrapAttachedViews(recycler);
        int i18 = i4;
        while (i18 < size) {
            try {
                fillChild(recycler.getViewForPosition(convert2AdapterPosition(i17 + i18)), (LayoutState) arrayList.get(i18));
                str2 = str;
            } catch (IndexOutOfBoundsException e) {
                str2 = str;
                Log.d(str2, "IndexOutOfBoundsException:" + e);
            }
            i18++;
            str = str2;
        }
    }

    private void fillChild(View view, LayoutState layoutState) {
        int i;
        int i2;
        view.setAlpha(1.0f);
        addView(view);
        measureChildWithExactlySize(view);
        int scaleXY = (int) (this.mItemViewWidth * (1.0f - layoutState.getScaleXY()));
        int top = layoutState.getTop() - scaleXY;
        int paddingTop = getPaddingTop();
        int top2 = (layoutState.getTop() + this.mItemViewWidth) - scaleXY;
        int i3 = paddingTop + this.mItemViewHeight;
        if (layoutState.getScaleXY() == 1.0f) {
            int i4 = this.mItemViewWidth;
            view.setCameraDistance(view.getResources().getDisplayMetrics().density * 10000.0f);
            view.setPivotX(0.0f);
            greyItem(view, layoutState.getScaleXY());
            i2 = i4;
            i = 0;
        } else {
            view.setPivotX((this.mItemViewHeight * 1.0f) / 2.0f);
            greyItem(view, 1.0f - ((1.0f - layoutState.getScaleXY()) * 1.75f));
            i = top;
            i2 = top2;
        }
        view.setPivotY((getVerticalSpace() * 1.0f) / 1.76f);
        layoutDecoratedWithMargins(view, i, paddingTop, i2, i3);
        ViewCompat.setScaleX(view, layoutState.getScaleXY());
        ViewCompat.setScaleY(view, layoutState.getScaleXY());
        view.animate().rotationY(layoutState.getScaleXY() == 1.0f ? -((Math.abs(this.mScrollOffset + (getPosition(view) * this.mItemViewWidth)) * 115) / this.mItemViewWidth) : 0).setDuration(0L).start();
    }

    private void greyItem(View view, float f) {
        float f2 = (1.0f - f) * 110.0f;
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{f, 0.0f, 0.0f, 0.0f, f2, 0.0f, f, 0.0f, 0.0f, f2, 0.0f, 0.0f, f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        view.setLayerType(2, paint);
        if (f >= 1.0f) {
            view.setLayerType(0, null);
        }
    }

    private float computeGreyScale(int i) {
        float fAbs = 1.0f - ((Math.abs((i + ((this.mItemViewWidth * 1.0f) / 2.0f)) - (getHorizontalSpace() / 2.0f)) * 1.0f) / (getHorizontalSpace() / 2));
        if (fAbs < 0.1d) {
            fAbs = 0.1f;
        }
        return (float) Math.pow(fAbs <= 1.0f ? fAbs : 1.0f, 0.8d);
    }

    public int getFirstVisiblePosition() {
        View childAt = getChildAt(0);
        if (getChildCount() <= 0 || childAt == null) {
            return 0;
        }
        return getPosition(childAt);
    }

    private int getMaxOffset() {
        return (getItemCount() - 1) * this.mItemViewWidth;
    }

    private void measureChildWithExactlySize(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec((this.mItemViewWidth - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((this.mItemViewHeight - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824));
    }

    private int makeScrollOffsetWithinRange(int i) {
        if (this.isReverseDirection) {
            return Math.max(Math.min(0, i), (-(getItemCount() - 1)) * this.mItemViewWidth);
        }
        return Math.min(Math.max(this.mItemViewWidth, i), getItemCount() * this.mItemViewWidth);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.getItemCount() != 0 && !state.isPreLayout()) {
            ValueAnimator valueAnimator = this.mAnimation;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mAnimation.cancel();
            }
            this.mScrollOffset = makeScrollOffsetWithinRange(this.mScrollOffset + (this.isReverseDirection ? -i : i));
            fill(recycler);
        }
        return i;
    }

    public int calculateDistanceToPosition(int i) {
        Log.d("SpinLayoutManager", "calculateDistanceToPosition:" + i);
        if (this.isReverseDirection) {
            return (this.mItemViewWidth * i) + this.mScrollOffset;
        }
        return (this.mItemViewWidth * (convert2LayoutPosition(i) + 1)) - this.mScrollOffset;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        Log.d("SpinLayoutManager", "scrollToPosition:" + i + "getItemCount:" + getItemCount());
        if (i < 0 || i >= getItemCount()) {
            return;
        }
        this.mScrollOffset = calculateOffsetForPosition(i);
        fill(this.mRecycle);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        int iCalculateOffsetForPosition = calculateOffsetForPosition(i);
        if (this.mRecycle == null || this.mState == null || i < 0 || i >= getItemCount()) {
            return;
        }
        Log.d("SpinLayoutManager", "smoothScrollToPosition mScrollOffset:" + this.mScrollOffset + ",finalOffset:" + iCalculateOffsetForPosition);
        startScroll(this.mScrollOffset, iCalculateOffsetForPosition);
    }

    private void startScroll(int i, int i2) {
        ValueAnimator valueAnimator = this.mAnimation;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAnimation.cancel();
        }
        int iAbs = (Math.abs(i - i2) / this.mItemViewWidth) * 100;
        Log.d("SpinLayoutManager", "startScroll duration:" + iAbs);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(i, i2);
        this.mAnimation = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(iAbs);
        this.mAnimation.setInterpolator(new DecelerateInterpolator());
        this.mAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.syu.media.music.widget.SpinLayoutManager$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f$0.m192lambda$startScroll$0$comsyumediamusicwidgetSpinLayoutManager(valueAnimator2);
            }
        });
        this.mAnimation.start();
    }

    /* JADX INFO: renamed from: lambda$startScroll$0$com-syu-media-music-widget-SpinLayoutManager, reason: not valid java name */
    /* synthetic */ void m192lambda$startScroll$0$comsyumediamusicwidgetSpinLayoutManager(ValueAnimator valueAnimator) {
        this.mScrollOffset = Math.round(((Float) valueAnimator.getAnimatedValue()).floatValue());
        Log.d("SpinLayoutManager", "startScroll mScrollOffset:" + this.mScrollOffset + ",getMaxOffset:" + getMaxOffset());
        Log.d("SpinLayoutManager", "startScroll getItemCount:" + getItemCount());
        if (this.mScrollOffset < getMaxOffset()) {
            fill(this.mRecycle);
        }
    }

    private int calculateOffsetForPosition(int i) {
        return -(this.mItemViewWidth * i);
    }

    public int convert2AdapterPosition(int i) {
        return (getItemCount() - 1) - i;
    }

    public int convert2LayoutPosition(int i) {
        return (getItemCount() - 1) - i;
    }

    public int getVerticalSpace() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public int getHorizontalSpace() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    static class LayoutState {
        private float mLayoutPercent;
        private int mLeft;
        private float mPositionOffset;
        private float mScaleXY;
        private int mTop;

        public LayoutState(int i, float f, float f2, int i2) {
            this.mTop = i;
            this.mScaleXY = f;
            this.mPositionOffset = f2;
            this.mLeft = i2;
        }

        public LayoutState(int i, float f, float f2, float f3) {
            this.mTop = i;
            this.mScaleXY = f;
            this.mPositionOffset = f2;
            this.mLayoutPercent = f3;
        }

        public float getScaleXY() {
            return this.mScaleXY;
        }

        public void setScaleXY(float f) {
            this.mScaleXY = f;
        }

        public float getLayoutPercent() {
            return this.mLayoutPercent;
        }

        public void setLayoutPercent(float f) {
            this.mLayoutPercent = f;
        }

        public float getPositionOffset() {
            return this.mPositionOffset;
        }

        public void setPositionOffset(float f) {
            this.mPositionOffset = f;
        }

        public int getTop() {
            return this.mTop;
        }

        public void setTop(int i) {
            this.mTop = i;
        }

        public int getLeft() {
            return this.mLeft;
        }

        public void setLeft(int i) {
            this.mLeft = i;
        }
    }
}
