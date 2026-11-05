package com.syu.media.music.widget.items;

import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: XLayoutManager.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001ZB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020+J\u000e\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004J\b\u00100\u001a\u00020\bH\u0016J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0004H\u0002J\u0010\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0004H\u0002J\u0012\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u0004H\u0016J\b\u0010;\u001a\u00020<H\u0016J\u0006\u0010=\u001a\u00020\u0004J\u0006\u0010>\u001a\u00020\u0004J\u0006\u0010?\u001a\u00020\u0004J\u0010\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u0004H\u0002J\b\u0010B\u001a\u00020\u0004H\u0002J\b\u0010C\u001a\u00020\u0004H\u0002J\b\u0010D\u001a\u00020\u0004H\u0002J\b\u0010E\u001a\u00020\u0004H\u0002J\b\u0010F\u001a\u00020\u0006H\u0002J\b\u0010G\u001a\u00020\u0004H\u0002J\b\u0010H\u001a\u00020\u0018H\u0002J \u0010I\u001a\u00020J2\u0006\u0010K\u001a\u0002092\u0006\u0010L\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u0004H\u0002J\u001c\u0010M\u001a\u00020J2\n\u0010N\u001a\u00060\u001bR\u00020\u001c2\u0006\u0010O\u001a\u00020'H\u0002J$\u0010P\u001a\u00020J2\f\u0010Q\u001a\b\u0012\u0002\b\u0003\u0018\u00010R2\f\u0010S\u001a\b\u0012\u0002\b\u0003\u0018\u00010RH\u0016J\u0012\u0010T\u001a\u00020J2\b\u0010U\u001a\u0004\u0018\u00010\u001cH\u0016J\u001c\u0010V\u001a\u00020J2\n\u0010N\u001a\u00060\u001bR\u00020\u001c2\u0006\u0010O\u001a\u00020'H\u0016J\u0010\u0010W\u001a\u00020J2\u0006\u0010O\u001a\u00020\u0004H\u0016J$\u0010X\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020\u00042\n\u0010N\u001a\u00060\u001bR\u00020\u001c2\u0006\u0010O\u001a\u00020'H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0018\u00010\u001bR\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\u000e\u0010$\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/syu/media/music/widget/items/XLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "()V", "MAX_RECT_COUNT", FinalChip.BSP_PLATFORM_Null, "M_MAX_ROTATION_Y", FinalChip.BSP_PLATFORM_Null, "isReverseDirection", FinalChip.BSP_PLATFORM_Null, "()Z", "setReverseDirection", "(Z)V", "mDecoratedChildHeight", "mDecoratedChildWidth", "mHasAttachedItems", "Landroid/util/SparseBooleanArray;", "mIntervalRatio", "mIntervalWidth", "mIsLoop", "getMIsLoop", "setMIsLoop", "mItemHeightWidthRatio", "mItemRects", "Landroid/util/SparseArray;", "Landroid/graphics/Rect;", "mOffsetPercent", "mRecycle", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "mScale", "mSpinSnapHelper", "Lcom/syu/media/music/widget/items/XSnapHelper;", "getMSpinSnapHelper", "()Lcom/syu/media/music/widget/items/XSnapHelper;", "mSpinSnapHelper$delegate", "Lkotlin/Lazy;", "mStartX", "mStartY", "mState", "Landroidx/recyclerview/widget/RecyclerView$State;", "mSumDx", "mTotalWidth", "calculateDistance", FinalChip.BSP_PLATFORM_Null, "velocityX", "distance", "calculateDistanceToPosition", "targetPos", "canScrollHorizontally", "checkTag", "Lcom/syu/media/music/widget/items/XLayoutManager$TAG;", "tag", FinalChip.BSP_PLATFORM_Null, "computeRotationY", "x", "computeScale", "findViewByPosition", "Landroid/view/View;", "pos", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "getCenterPosition", "getFirstVisiblePosition", "getFixedScrollPosition", "getFrame", "index", "getHorizontalSpace", "getIntervalDistance", "getItemViewWidth", "getMaxOffset", "getScrollPosition", "getVerticalSpace", "getVisibleArea", "layoutCover", FinalChip.BSP_PLATFORM_Null, "child", "rect", "layoutItems", "recycler", "state", "onAdapterChanged", "oldAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "newAdapter", "onAttachedToWindow", "view", "onLayoutChildren", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "TAG", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class XLayoutManager extends RecyclerView.LayoutManager {
    private boolean isReverseDirection;
    private int mDecoratedChildHeight;
    private int mDecoratedChildWidth;
    private int mIntervalWidth;
    private boolean mIsLoop;
    private RecyclerView.Recycler mRecycle;
    private int mStartX;
    private int mStartY;
    private RecyclerView.State mState;
    private int mSumDx;
    private int mTotalWidth;

    /* JADX INFO: renamed from: mSpinSnapHelper$delegate, reason: from kotlin metadata */
    private final Lazy mSpinSnapHelper = LazyKt.lazy(new Function0<XSnapHelper>() { // from class: com.syu.media.music.widget.items.XLayoutManager$mSpinSnapHelper$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final XSnapHelper m193invoke() {
            return new XSnapHelper();
        }
    });
    private final int MAX_RECT_COUNT = 100;
    private float mIntervalRatio = 0.5f;
    private float mItemHeightWidthRatio = 1.0f;
    private final float mOffsetPercent = 0.8f;
    private float mScale = 0.9f;
    private final SparseArray<Rect> mItemRects = new SparseArray<>();
    private final SparseBooleanArray mHasAttachedItems = new SparseBooleanArray();
    private final float M_MAX_ROTATION_Y = 100.0f;

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return true;
    }

    private final XSnapHelper getMSpinSnapHelper() {
        return (XSnapHelper) this.mSpinSnapHelper.getValue();
    }

    /* JADX INFO: renamed from: isReverseDirection, reason: from getter */
    public final boolean getIsReverseDirection() {
        return this.isReverseDirection;
    }

    public final void setReverseDirection(boolean z) {
        this.isReverseDirection = z;
    }

    public final boolean getMIsLoop() {
        return this.mIsLoop;
    }

    public final void setMIsLoop(boolean z) {
        this.mIsLoop = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        if (state.getItemCount() == 0 || state.isPreLayout()) {
            this.mSumDx = 0;
            removeAndRecycleAllViews(recycler);
            return;
        }
        this.mItemRects.clear();
        this.mHasAttachedItems.clear();
        View viewForPosition = recycler.getViewForPosition(0);
        Intrinsics.checkNotNullExpressionValue(viewForPosition, "recycler.getViewForPosition(0)");
        addView(viewForPosition);
        measureChildWithMargins(viewForPosition, 0, 0);
        int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
        this.mDecoratedChildHeight = decoratedMeasuredHeight;
        this.mDecoratedChildWidth = (int) (decoratedMeasuredHeight / this.mItemHeightWidthRatio);
        int mDecoratedChildWidth = this.mStartX;
        this.mStartY = MathKt.roundToInt(((getVerticalSpace() - this.mDecoratedChildHeight) * 1.0f) / 2);
        this.mIntervalWidth = getMDecoratedChildWidth();
        for (int i = 0; i < getItemCount() && i < this.MAX_RECT_COUNT; i++) {
            int i2 = this.mStartY;
            this.mItemRects.put(i, new Rect(mDecoratedChildWidth, i2, this.mDecoratedChildWidth + mDecoratedChildWidth, this.mDecoratedChildHeight + i2));
            this.mHasAttachedItems.put(i, false);
            mDecoratedChildWidth += getMDecoratedChildWidth();
        }
        detachAndScrapAttachedViews(recycler);
        layoutItems(recycler, state);
        Log.d("LZP", "onLayoutChildren");
        this.mTotalWidth = Math.max(mDecoratedChildWidth, getHorizontalSpace());
        this.mRecycle = recycler;
        this.mState = state;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        if (!this.mIsLoop) {
            int i = this.mSumDx;
            if (i + dx < 0) {
                dx = -i;
            } else if (i + dx > getMaxOffset()) {
                dx = getMaxOffset() - this.mSumDx;
            }
        }
        this.mSumDx += dx;
        layoutItems(recycler, state);
        return dx;
    }

    private final void layoutItems(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            return;
        }
        int i = this.mSumDx;
        Rect rect = new Rect(i, 0, getHorizontalSpace() + i, getVerticalSpace());
        int childCount = getChildCount();
        int centerPosition = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                if (childAt.getTag() != null) {
                    Object tag = childAt.getTag();
                    Intrinsics.checkNotNullExpressionValue(tag, "child.tag");
                    centerPosition = checkTag(tag).getPos();
                } else {
                    centerPosition = getPosition(childAt);
                }
                Rect frame = getFrame(centerPosition);
                if (Rect.intersects(frame, rect)) {
                    layoutCover(childAt, frame, i2);
                    this.mHasAttachedItems.put(centerPosition, true);
                } else {
                    removeAndRecycleView(childAt, recycler);
                    this.mHasAttachedItems.delete(centerPosition);
                }
            }
        }
        Log.d("LZP", "pos:" + centerPosition);
        Log.d("LZP", "childCount:" + getChildCount());
        if (centerPosition == 0) {
            centerPosition = getCenterPosition();
        }
        int i3 = centerPosition - 20;
        int itemCount = centerPosition + 20;
        if (!this.mIsLoop) {
            if (i3 < 0) {
                i3 = 0;
            }
            if (itemCount > getItemCount()) {
                itemCount = getItemCount();
            }
        }
        while (i3 < itemCount) {
            Rect frame2 = getFrame(i3);
            if (Rect.intersects(frame2, rect) && !this.mHasAttachedItems.get(i3)) {
                int itemCount2 = i3 % getItemCount();
                if (itemCount2 < 0) {
                    itemCount2 += getItemCount();
                }
                Log.d("LZP", "insertView actualPos:" + itemCount2);
                View viewForPosition = recycler.getViewForPosition(itemCount2);
                Intrinsics.checkNotNullExpressionValue(viewForPosition, "recycler.getViewForPosition(actualPos)");
                viewForPosition.setTag(new TAG(i3));
                measureChildWithMargins(viewForPosition, 0, 0);
                addView(viewForPosition);
                layoutCover(viewForPosition, frame2, itemCount2 - getFirstVisiblePosition());
                this.mHasAttachedItems.put(i3, true);
            }
            i3++;
        }
    }

    private final void layoutCover(View child, Rect rect, int index) {
        int intervalDistance = (index * getIntervalDistance()) + this.mSumDx;
        layoutDecoratedWithMargins(child, rect.left - intervalDistance, rect.top, rect.right - intervalDistance, rect.bottom);
        float fComputeScale = computeScale(rect.left - this.mSumDx);
        computeRotationY(rect.left - this.mSumDx);
        Log.d("LZP", "layoutCover scale:" + fComputeScale);
        Log.d("LZP", "layoutCover getPosition(child):" + getPosition(child));
        Log.d("LZP", "layoutCover FirstVisiblePosition:" + getFirstVisiblePosition());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter<?> oldAdapter, RecyclerView.Adapter<?> newAdapter) {
        removeAllViews();
        this.mRecycle = null;
        this.mState = null;
        this.mHasAttachedItems.clear();
        this.mItemRects.clear();
        this.mSumDx = 0;
    }

    public final int calculateDistanceToPosition(int targetPos) {
        int mDecoratedChildWidth = (getMDecoratedChildWidth() * targetPos) - this.mSumDx;
        Log.d("LZP", "pendingScrollOffset:" + mDecoratedChildWidth + " ,mSumDx:" + this.mSumDx);
        return mDecoratedChildWidth;
    }

    private final float computeScale(int x) {
        float fAbs = 1 - ((Math.abs(x - this.mStartX) * 1.0f) / Math.abs(this.mStartX + (this.mDecoratedChildWidth / this.mIntervalRatio)));
        if (fAbs < 0.0f) {
            fAbs = 0.0f;
        }
        if (fAbs > 1.0f) {
            return 1.0f;
        }
        return fAbs;
    }

    private final float computeRotationY(int x) {
        float mDecoratedChildWidth = (this.M_MAX_ROTATION_Y * x) / getMDecoratedChildWidth();
        float fAbs = Math.abs(mDecoratedChildWidth);
        float f = this.M_MAX_ROTATION_Y;
        if (fAbs > f) {
            return mDecoratedChildWidth > 0.0f ? -f : f;
        }
        return mDecoratedChildWidth;
    }

    public final double calculateDistance(int velocityX, double distance) {
        int mDecoratedChildWidth = this.mSumDx % getMDecoratedChildWidth();
        if (velocityX <= 0) {
            return distance < ((double) getMDecoratedChildWidth()) ? mDecoratedChildWidth : (distance - (distance % ((double) getMDecoratedChildWidth()))) + ((double) mDecoratedChildWidth);
        }
        if (distance < getMDecoratedChildWidth()) {
            return getMDecoratedChildWidth() - mDecoratedChildWidth;
        }
        return (distance - (distance % ((double) getMDecoratedChildWidth()))) - ((double) mDecoratedChildWidth);
    }

    private final Rect getVisibleArea() {
        return new Rect(getPaddingLeft() + this.mSumDx, getPaddingTop(), (getWidth() - getPaddingRight()) + this.mSumDx, getHeight() - getPaddingBottom());
    }

    public final int getCenterPosition() {
        int mDecoratedChildWidth = this.mSumDx / getMDecoratedChildWidth();
        return ((float) (this.mSumDx % getMDecoratedChildWidth())) > ((float) getMDecoratedChildWidth()) * 0.5f ? mDecoratedChildWidth + 1 : mDecoratedChildWidth;
    }

    public final int getFirstVisiblePosition() {
        View childAt = getChildAt(0);
        if (getChildCount() <= 0 || childAt == null) {
            return 0;
        }
        return getPosition(childAt);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int pos) {
        int firstVisiblePosition = pos - getFirstVisiblePosition();
        boolean z = false;
        if (firstVisiblePosition >= 0 && firstVisiblePosition < getChildCount()) {
            z = true;
        }
        if (z) {
            View childAt = getChildAt(firstVisiblePosition);
            Intrinsics.checkNotNull(childAt);
            if (getPosition(childAt) == pos) {
                return childAt;
            }
        }
        return super.findViewByPosition(pos);
    }

    private final int getMaxOffset() {
        return (getItemCount() - 1) * getMDecoratedChildWidth();
    }

    private final float getScrollPosition() {
        return (this.mSumDx * 1.0f) / getMDecoratedChildWidth();
    }

    private final int getVerticalSpace() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private final int getHorizontalSpace() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    /* JADX INFO: renamed from: getItemViewWidth, reason: from getter */
    private final int getMDecoratedChildWidth() {
        return this.mDecoratedChildWidth;
    }

    private final int getIntervalDistance() {
        return MathKt.roundToInt(this.mDecoratedChildWidth * this.mOffsetPercent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView view) {
        super.onAttachedToWindow(view);
        getMSpinSnapHelper().attachToRecyclerView(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
    }

    public final int getFixedScrollPosition() {
        if (this.mDecoratedChildWidth == 0 || getMaxOffset() % this.mDecoratedChildWidth == 0) {
            return -1;
        }
        Log.d("LZP", "getFixedScrollPosition" + getFirstVisiblePosition());
        return MathKt.roundToInt(getScrollPosition());
    }

    private final Rect getFrame(int index) {
        Rect rect = this.mItemRects.get(index);
        if (rect != null) {
            return rect;
        }
        int mDecoratedChildWidth = this.mStartX + (getMDecoratedChildWidth() * index);
        int i = this.mStartY;
        return new Rect(mDecoratedChildWidth, i, this.mDecoratedChildWidth + mDecoratedChildWidth, this.mDecoratedChildHeight + i);
    }

    private final TAG checkTag(Object tag) {
        if (tag instanceof TAG) {
            return (TAG) tag;
        }
        throw new IllegalArgumentException("You should not use View#setTag(Object tag), use View#setTag(int key, Object tag) instead!");
    }

    /* JADX INFO: compiled from: XLayoutManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/syu/media/music/widget/items/XLayoutManager$TAG;", FinalChip.BSP_PLATFORM_Null, "pos", FinalChip.BSP_PLATFORM_Null, "(I)V", "getPos", "()I", "setPos", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class TAG {
        private int pos;

        public TAG(int i) {
            this.pos = i;
        }

        public final int getPos() {
            return this.pos;
        }

        public final void setPos(int i) {
            this.pos = i;
        }
    }
}
