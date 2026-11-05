package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements FlexContainer, RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DEBUG = false;
    private static final String TAG = "FlexboxLayoutManager";
    private static final Rect TEMP_RECT = new Rect();
    private int mAlignItems;
    private AnchorInfo mAnchorInfo;
    private final Context mContext;
    private int mDirtyPosition;
    private int mFlexDirection;
    private List<FlexLine> mFlexLines;
    private FlexboxHelper.FlexLinesResult mFlexLinesResult;
    private int mFlexWrap;
    private final FlexboxHelper mFlexboxHelper;
    private boolean mFromBottomToTop;
    private boolean mIsRtl;
    private int mJustifyContent;
    private int mLastHeight;
    private int mLastWidth;
    private LayoutState mLayoutState;
    private int mMaxLine;
    private OrientationHelper mOrientationHelper;
    private View mParent;
    private SavedState mPendingSavedState;
    private int mPendingScrollPosition;
    private int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private RecyclerView.Recycler mRecycler;
    private RecyclerView.State mState;
    private OrientationHelper mSubOrientationHelper;
    private SparseArray<View> mViewCache;

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignContent() {
        return 5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexLineAdded(FlexLine flexLine) {
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    public FlexboxLayoutManager(Context context, int flexDirection) {
        this(context, flexDirection, 1);
    }

    public FlexboxLayoutManager(Context context, int flexDirection, int flexWrap) {
        this.mMaxLine = -1;
        this.mFlexLines = new ArrayList();
        this.mFlexboxHelper = new FlexboxHelper(this);
        this.mAnchorInfo = new AnchorInfo();
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLastWidth = Integer.MIN_VALUE;
        this.mLastHeight = Integer.MIN_VALUE;
        this.mViewCache = new SparseArray<>();
        this.mDirtyPosition = -1;
        this.mFlexLinesResult = new FlexboxHelper.FlexLinesResult();
        setFlexDirection(flexDirection);
        setFlexWrap(flexWrap);
        setAlignItems(4);
        this.mContext = context;
    }

    public FlexboxLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.mMaxLine = -1;
        this.mFlexLines = new ArrayList();
        this.mFlexboxHelper = new FlexboxHelper(this);
        this.mAnchorInfo = new AnchorInfo();
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLastWidth = Integer.MIN_VALUE;
        this.mLastHeight = Integer.MIN_VALUE;
        this.mViewCache = new SparseArray<>();
        this.mDirtyPosition = -1;
        this.mFlexLinesResult = new FlexboxHelper.FlexLinesResult();
        RecyclerView.LayoutManager.Properties properties = getProperties(context, attrs, defStyleAttr, defStyleRes);
        int i = properties.orientation;
        if (i != 0) {
            if (i == 1) {
                if (properties.reverseLayout) {
                    setFlexDirection(3);
                } else {
                    setFlexDirection(2);
                }
            }
        } else if (properties.reverseLayout) {
            setFlexDirection(1);
        } else {
            setFlexDirection(0);
        }
        setFlexWrap(1);
        setAlignItems(4);
        this.mContext = context;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexDirection() {
        return this.mFlexDirection;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexDirection(int flexDirection) {
        if (this.mFlexDirection != flexDirection) {
            removeAllViews();
            this.mFlexDirection = flexDirection;
            this.mOrientationHelper = null;
            this.mSubOrientationHelper = null;
            clearFlexLines();
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexWrap() {
        return this.mFlexWrap;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexWrap(int flexWrap) {
        if (flexWrap == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i = this.mFlexWrap;
        if (i != flexWrap) {
            if (i == 0 || flexWrap == 0) {
                removeAllViews();
                clearFlexLines();
            }
            this.mFlexWrap = flexWrap;
            this.mOrientationHelper = null;
            this.mSubOrientationHelper = null;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getJustifyContent() {
        return this.mJustifyContent;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setJustifyContent(int justifyContent) {
        if (this.mJustifyContent != justifyContent) {
            this.mJustifyContent = justifyContent;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignItems() {
        return this.mAlignItems;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignItems(int alignItems) {
        int i = this.mAlignItems;
        if (i != alignItems) {
            if (i == 4 || alignItems == 4) {
                removeAllViews();
                clearFlexLines();
            }
            this.mAlignItems = alignItems;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignContent(int alignContent) {
        throw new UnsupportedOperationException("Setting the alignContent in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to use this attribute.");
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getMaxLine() {
        return this.mMaxLine;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setMaxLine(int maxLine) {
        if (this.mMaxLine != maxLine) {
            this.mMaxLine = maxLine;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<FlexLine> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.mFlexLines.size());
        int size = this.mFlexLines.size();
        for (int i = 0; i < size; i++) {
            FlexLine flexLine = this.mFlexLines.get(i);
            if (flexLine.getItemCount() != 0) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthMainAxis(View view, int index, int indexInFlexLine) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (isMainAxisDirectionHorizontal()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthCrossAxis(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (isMainAxisDirectionHorizontal()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexItemAdded(View view, int index, int indexInFlexLine, FlexLine flexLine) {
        calculateItemDecorationsForChild(view, TEMP_RECT);
        if (isMainAxisDirectionHorizontal()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            flexLine.mMainSize += leftDecorationWidth;
            flexLine.mDividerLengthInMainSize += leftDecorationWidth;
        } else {
            int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
            flexLine.mMainSize += topDecorationHeight;
            flexLine.mDividerLengthInMainSize += topDecorationHeight;
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getFlexItemAt(int index) {
        View view = this.mViewCache.get(index);
        return view != null ? view : this.mRecycler.getViewForPosition(index);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getReorderedFlexItemAt(int index) {
        return getFlexItemAt(index);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildWidthMeasureSpec(int widthSpec, int padding, int childDimension) {
        return getChildMeasureSpec(getWidth(), getWidthMode(), padding, childDimension, canScrollHorizontally());
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildHeightMeasureSpec(int heightSpec, int padding, int childDimension) {
        return getChildMeasureSpec(getHeight(), getHeightMode(), padding, childDimension, canScrollVertically());
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getLargestMainSize() {
        if (this.mFlexLines.size() == 0) {
            return 0;
        }
        int size = this.mFlexLines.size();
        int iMax = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            iMax = Math.max(iMax, this.mFlexLines.get(i).mMainSize);
        }
        return iMax;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getSumOfCrossSize() {
        int size = this.mFlexLines.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.mFlexLines.get(i2).mCrossSize;
        }
        return i;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexLines(List<FlexLine> flexLines) {
        this.mFlexLines = flexLines;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<FlexLine> getFlexLinesInternal() {
        return this.mFlexLines;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void updateViewCache(int position, View view) {
        this.mViewCache.put(position, view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int targetPosition) {
        View childAt;
        if (getChildCount() == 0 || (childAt = getChildAt(0)) == null) {
            return null;
        }
        int i = targetPosition < getPosition(childAt) ? -1 : 1;
        if (isMainAxisDirectionHorizontal()) {
            return new PointF(0.0f, i);
        }
        return new PointF(i, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context c, AttributeSet attrs) {
        return new LayoutParams(c, attrs);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
        return lp instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter oldAdapter, RecyclerView.Adapter newAdapter) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            View childClosestToStart = getChildClosestToStart();
            savedState.mAnchorPosition = getPosition(childClosestToStart);
            savedState.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            savedState.invalidateAnchor();
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof SavedState) {
            this.mPendingSavedState = (SavedState) state;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsAdded(recyclerView, positionStart, itemCount);
        updateDirtyPosition(positionStart);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int positionStart, int itemCount, Object payload) {
        super.onItemsUpdated(recyclerView, positionStart, itemCount, payload);
        updateDirtyPosition(positionStart);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsUpdated(recyclerView, positionStart, itemCount);
        updateDirtyPosition(positionStart);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsRemoved(recyclerView, positionStart, itemCount);
        updateDirtyPosition(positionStart);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int from, int to, int itemCount) {
        super.onItemsMoved(recyclerView, from, to, itemCount);
        updateDirtyPosition(Math.min(from, to));
    }

    private void updateDirtyPosition(int positionStart) {
        if (positionStart >= findLastVisibleItemPosition()) {
            return;
        }
        int childCount = getChildCount();
        this.mFlexboxHelper.ensureMeasureSpecCache(childCount);
        this.mFlexboxHelper.ensureMeasuredSizeCache(childCount);
        this.mFlexboxHelper.ensureIndexToFlexLine(childCount);
        if (positionStart >= this.mFlexboxHelper.mIndexToFlexLine.length) {
            return;
        }
        this.mDirtyPosition = positionStart;
        View childClosestToStart = getChildClosestToStart();
        if (childClosestToStart == null) {
            return;
        }
        this.mPendingScrollPosition = getPosition(childClosestToStart);
        if (!isMainAxisDirectionHorizontal() && this.mIsRtl) {
            this.mPendingScrollPositionOffset = this.mOrientationHelper.getDecoratedEnd(childClosestToStart) + this.mOrientationHelper.getEndPadding();
        } else {
            this.mPendingScrollPositionOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart) - this.mOrientationHelper.getStartAfterPadding();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        this.mRecycler = recycler;
        this.mState = state;
        int itemCount = state.getItemCount();
        if (itemCount == 0 && state.isPreLayout()) {
            return;
        }
        resolveLayoutDirection();
        ensureOrientationHelper();
        ensureLayoutState();
        this.mFlexboxHelper.ensureMeasureSpecCache(itemCount);
        this.mFlexboxHelper.ensureMeasuredSizeCache(itemCount);
        this.mFlexboxHelper.ensureIndexToFlexLine(itemCount);
        this.mLayoutState.mShouldRecycle = false;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.hasValidAnchor(itemCount)) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        if (!this.mAnchorInfo.mValid || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            this.mAnchorInfo.reset();
            updateAnchorInfoForLayout(state, this.mAnchorInfo);
            this.mAnchorInfo.mValid = true;
        }
        detachAndScrapAttachedViews(recycler);
        if (this.mAnchorInfo.mLayoutFromEnd) {
            updateLayoutStateToFillStart(this.mAnchorInfo, false, true);
        } else {
            updateLayoutStateToFillEnd(this.mAnchorInfo, false, true);
        }
        updateFlexLines(itemCount);
        fill(recycler, state, this.mLayoutState);
        if (this.mAnchorInfo.mLayoutFromEnd) {
            i2 = this.mLayoutState.mOffset;
            updateLayoutStateToFillEnd(this.mAnchorInfo, true, false);
            fill(recycler, state, this.mLayoutState);
            i = this.mLayoutState.mOffset;
        } else {
            i = this.mLayoutState.mOffset;
            updateLayoutStateToFillStart(this.mAnchorInfo, true, false);
            fill(recycler, state, this.mLayoutState);
            i2 = this.mLayoutState.mOffset;
        }
        if (getChildCount() > 0) {
            if (this.mAnchorInfo.mLayoutFromEnd) {
                fixLayoutStartGap(i2 + fixLayoutEndGap(i, recycler, state, true), recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int startOffset, RecyclerView.Recycler recycler, RecyclerView.State state, boolean canOffsetChildren) {
        int iHandleScrollingMainOrientation;
        int startAfterPadding;
        if (!isMainAxisDirectionHorizontal() && this.mIsRtl) {
            int endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - startOffset;
            if (endAfterPadding <= 0) {
                return 0;
            }
            iHandleScrollingMainOrientation = handleScrollingMainOrientation(-endAfterPadding, recycler, state);
        } else {
            int startAfterPadding2 = startOffset - this.mOrientationHelper.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            iHandleScrollingMainOrientation = -handleScrollingMainOrientation(startAfterPadding2, recycler, state);
        }
        int i = startOffset + iHandleScrollingMainOrientation;
        if (!canOffsetChildren || (startAfterPadding = i - this.mOrientationHelper.getStartAfterPadding()) <= 0) {
            return iHandleScrollingMainOrientation;
        }
        this.mOrientationHelper.offsetChildren(-startAfterPadding);
        return iHandleScrollingMainOrientation - startAfterPadding;
    }

    private int fixLayoutEndGap(int endOffset, RecyclerView.Recycler recycler, RecyclerView.State state, boolean canOffsetChildren) {
        int iHandleScrollingMainOrientation;
        int endAfterPadding;
        if (!isMainAxisDirectionHorizontal() && this.mIsRtl) {
            int startAfterPadding = endOffset - this.mOrientationHelper.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            iHandleScrollingMainOrientation = handleScrollingMainOrientation(startAfterPadding, recycler, state);
        } else {
            int endAfterPadding2 = this.mOrientationHelper.getEndAfterPadding() - endOffset;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            iHandleScrollingMainOrientation = -handleScrollingMainOrientation(-endAfterPadding2, recycler, state);
        }
        int i = endOffset + iHandleScrollingMainOrientation;
        if (!canOffsetChildren || (endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - i) <= 0) {
            return iHandleScrollingMainOrientation;
        }
        this.mOrientationHelper.offsetChildren(endAfterPadding);
        return endAfterPadding + iHandleScrollingMainOrientation;
    }

    private void updateFlexLines(int childCount) {
        boolean z;
        int i;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (isMainAxisDirectionHorizontal()) {
            int i2 = this.mLastWidth;
            z = (i2 == Integer.MIN_VALUE || i2 == width) ? false : true;
            i = this.mLayoutState.mInfinite ? this.mContext.getResources().getDisplayMetrics().heightPixels : this.mLayoutState.mAvailable;
        } else {
            int i3 = this.mLastHeight;
            z = (i3 == Integer.MIN_VALUE || i3 == height) ? false : true;
            i = this.mLayoutState.mInfinite ? this.mContext.getResources().getDisplayMetrics().widthPixels : this.mLayoutState.mAvailable;
        }
        int i4 = i;
        this.mLastWidth = width;
        this.mLastHeight = height;
        int i5 = this.mDirtyPosition;
        if (i5 != -1 || (this.mPendingScrollPosition == -1 && !z)) {
            int iMin = i5 != -1 ? Math.min(i5, this.mAnchorInfo.mPosition) : this.mAnchorInfo.mPosition;
            this.mFlexLinesResult.reset();
            if (isMainAxisDirectionHorizontal()) {
                if (this.mFlexLines.size() > 0) {
                    this.mFlexboxHelper.clearFlexLines(this.mFlexLines, iMin);
                    this.mFlexboxHelper.calculateFlexLines(this.mFlexLinesResult, iMakeMeasureSpec, iMakeMeasureSpec2, i4, iMin, this.mAnchorInfo.mPosition, this.mFlexLines);
                } else {
                    this.mFlexboxHelper.ensureIndexToFlexLine(childCount);
                    this.mFlexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, iMakeMeasureSpec, iMakeMeasureSpec2, i4, 0, this.mFlexLines);
                }
            } else if (this.mFlexLines.size() > 0) {
                this.mFlexboxHelper.clearFlexLines(this.mFlexLines, iMin);
                this.mFlexboxHelper.calculateFlexLines(this.mFlexLinesResult, iMakeMeasureSpec2, iMakeMeasureSpec, i4, iMin, this.mAnchorInfo.mPosition, this.mFlexLines);
            } else {
                this.mFlexboxHelper.ensureIndexToFlexLine(childCount);
                this.mFlexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, iMakeMeasureSpec, iMakeMeasureSpec2, i4, 0, this.mFlexLines);
            }
            this.mFlexLines = this.mFlexLinesResult.mFlexLines;
            this.mFlexboxHelper.determineMainSize(iMakeMeasureSpec, iMakeMeasureSpec2, iMin);
            this.mFlexboxHelper.stretchViews(iMin);
            return;
        }
        if (this.mAnchorInfo.mLayoutFromEnd) {
            return;
        }
        this.mFlexLines.clear();
        this.mFlexLinesResult.reset();
        if (isMainAxisDirectionHorizontal()) {
            this.mFlexboxHelper.calculateHorizontalFlexLinesToIndex(this.mFlexLinesResult, iMakeMeasureSpec, iMakeMeasureSpec2, i4, this.mAnchorInfo.mPosition, this.mFlexLines);
        } else {
            this.mFlexboxHelper.calculateVerticalFlexLinesToIndex(this.mFlexLinesResult, iMakeMeasureSpec, iMakeMeasureSpec2, i4, this.mAnchorInfo.mPosition, this.mFlexLines);
        }
        this.mFlexLines = this.mFlexLinesResult.mFlexLines;
        this.mFlexboxHelper.determineMainSize(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.mFlexboxHelper.stretchViews();
        this.mAnchorInfo.mFlexLinePosition = this.mFlexboxHelper.mIndexToFlexLine[this.mAnchorInfo.mPosition];
        this.mLayoutState.mFlexLinePosition = this.mAnchorInfo.mFlexLinePosition;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mDirtyPosition = -1;
        this.mAnchorInfo.reset();
        this.mViewCache.clear();
    }

    boolean isLayoutRtl() {
        return this.mIsRtl;
    }

    private void resolveLayoutDirection() {
        int layoutDirection = getLayoutDirection();
        int i = this.mFlexDirection;
        if (i == 0) {
            this.mIsRtl = layoutDirection == 1;
            this.mFromBottomToTop = this.mFlexWrap == 2;
            return;
        }
        if (i == 1) {
            this.mIsRtl = layoutDirection != 1;
            this.mFromBottomToTop = this.mFlexWrap == 2;
            return;
        }
        if (i == 2) {
            boolean z = layoutDirection == 1;
            this.mIsRtl = z;
            if (this.mFlexWrap == 2) {
                this.mIsRtl = !z;
            }
            this.mFromBottomToTop = false;
            return;
        }
        if (i == 3) {
            boolean z2 = layoutDirection == 1;
            this.mIsRtl = z2;
            if (this.mFlexWrap == 2) {
                this.mIsRtl = !z2;
            }
            this.mFromBottomToTop = true;
            return;
        }
        this.mIsRtl = false;
        this.mFromBottomToTop = false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (updateAnchorFromPendingState(state, anchorInfo, this.mPendingSavedState) || updateAnchorFromChildren(state, anchorInfo)) {
            return;
        }
        anchorInfo.assignCoordinateFromPadding();
        anchorInfo.mPosition = 0;
        anchorInfo.mFlexLinePosition = 0;
    }

    private boolean updateAnchorFromPendingState(RecyclerView.State state, AnchorInfo anchorInfo, SavedState savedState) {
        int i;
        View childAt;
        int decoratedStart;
        if (!state.isPreLayout() && (i = this.mPendingScrollPosition) != -1) {
            if (i < 0 || i >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                anchorInfo.mPosition = this.mPendingScrollPosition;
                anchorInfo.mFlexLinePosition = this.mFlexboxHelper.mIndexToFlexLine[anchorInfo.mPosition];
                SavedState savedState2 = this.mPendingSavedState;
                if (savedState2 == null || !savedState2.hasValidAnchor(state.getItemCount())) {
                    if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                        View viewFindViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                        if (viewFindViewByPosition != null) {
                            if (this.mOrientationHelper.getDecoratedMeasurement(viewFindViewByPosition) <= this.mOrientationHelper.getTotalSpace()) {
                                if (this.mOrientationHelper.getDecoratedStart(viewFindViewByPosition) - this.mOrientationHelper.getStartAfterPadding() >= 0) {
                                    if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(viewFindViewByPosition) < 0) {
                                        anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                                        anchorInfo.mLayoutFromEnd = true;
                                        return true;
                                    }
                                    if (anchorInfo.mLayoutFromEnd) {
                                        decoratedStart = this.mOrientationHelper.getDecoratedEnd(viewFindViewByPosition) + this.mOrientationHelper.getTotalSpaceChange();
                                    } else {
                                        decoratedStart = this.mOrientationHelper.getDecoratedStart(viewFindViewByPosition);
                                    }
                                    anchorInfo.mCoordinate = decoratedStart;
                                } else {
                                    anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
                                    anchorInfo.mLayoutFromEnd = false;
                                    return true;
                                }
                            } else {
                                anchorInfo.assignCoordinateFromPadding();
                                return true;
                            }
                        } else {
                            if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
                                anchorInfo.mLayoutFromEnd = this.mPendingScrollPosition < getPosition(childAt);
                            }
                            anchorInfo.assignCoordinateFromPadding();
                        }
                        return true;
                    }
                    if (isMainAxisDirectionHorizontal() || !this.mIsRtl) {
                        anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    } else {
                        anchorInfo.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                    }
                    return true;
                }
                anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
                anchorInfo.mAssignedFromSavedState = true;
                anchorInfo.mFlexLinePosition = -1;
                return true;
            }
        }
        return false;
    }

    private boolean updateAnchorFromChildren(RecyclerView.State state, AnchorInfo anchorInfo) {
        View viewFindFirstReferenceChild;
        int startAfterPadding;
        if (getChildCount() == 0) {
            return false;
        }
        if (anchorInfo.mLayoutFromEnd) {
            viewFindFirstReferenceChild = findLastReferenceChild(state.getItemCount());
        } else {
            viewFindFirstReferenceChild = findFirstReferenceChild(state.getItemCount());
        }
        if (viewFindFirstReferenceChild == null) {
            return false;
        }
        anchorInfo.assignFromView(viewFindFirstReferenceChild);
        if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
            if (this.mOrientationHelper.getDecoratedStart(viewFindFirstReferenceChild) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(viewFindFirstReferenceChild) < this.mOrientationHelper.getStartAfterPadding()) {
                if (anchorInfo.mLayoutFromEnd) {
                    startAfterPadding = this.mOrientationHelper.getEndAfterPadding();
                } else {
                    startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
                }
                anchorInfo.mCoordinate = startAfterPadding;
            }
        }
        return true;
    }

    private View findFirstReferenceChild(int itemCount) {
        View viewFindReferenceChild = findReferenceChild(0, getChildCount(), itemCount);
        if (viewFindReferenceChild == null) {
            return null;
        }
        int i = this.mFlexboxHelper.mIndexToFlexLine[getPosition(viewFindReferenceChild)];
        if (i == -1) {
            return null;
        }
        return findFirstReferenceViewInLine(viewFindReferenceChild, this.mFlexLines.get(i));
    }

    private View findLastReferenceChild(int itemCount) {
        View viewFindReferenceChild = findReferenceChild(getChildCount() - 1, -1, itemCount);
        if (viewFindReferenceChild == null) {
            return null;
        }
        return findLastReferenceViewInLine(viewFindReferenceChild, this.mFlexLines.get(this.mFlexboxHelper.mIndexToFlexLine[getPosition(viewFindReferenceChild)]));
    }

    private View findReferenceChild(int start, int end, int itemCount) {
        int position;
        ensureOrientationHelper();
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        int i = end > start ? 1 : -1;
        View view = null;
        View view2 = null;
        while (start != end) {
            View childAt = getChildAt(start);
            if (childAt != null && (position = getPosition(childAt)) >= 0 && position < itemCount) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.getDecoratedStart(childAt) >= startAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) <= endAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            start += i;
        }
        return view != null ? view : view2;
    }

    private View getChildClosestToStart() {
        return getChildAt(0);
    }

    private int fill(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState) {
        if (layoutState.mScrollingOffset != Integer.MIN_VALUE) {
            if (layoutState.mAvailable < 0) {
                LayoutState.access$2012(layoutState, layoutState.mAvailable);
            }
            recycleByLayoutState(recycler, layoutState);
        }
        int i = layoutState.mAvailable;
        int crossSize = layoutState.mAvailable;
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int iLayoutFlexLine = 0;
        while (true) {
            if ((crossSize <= 0 && !this.mLayoutState.mInfinite) || !layoutState.hasMore(state, this.mFlexLines)) {
                break;
            }
            FlexLine flexLine = this.mFlexLines.get(layoutState.mFlexLinePosition);
            layoutState.mPosition = flexLine.mFirstIndex;
            iLayoutFlexLine += layoutFlexLine(flexLine, layoutState);
            if (zIsMainAxisDirectionHorizontal || !this.mIsRtl) {
                LayoutState.access$1012(layoutState, flexLine.getCrossSize() * layoutState.mLayoutDirection);
            } else {
                LayoutState.access$1020(layoutState, flexLine.getCrossSize() * layoutState.mLayoutDirection);
            }
            crossSize -= flexLine.getCrossSize();
        }
        LayoutState.access$1220(layoutState, iLayoutFlexLine);
        if (layoutState.mScrollingOffset != Integer.MIN_VALUE) {
            LayoutState.access$2012(layoutState, iLayoutFlexLine);
            if (layoutState.mAvailable < 0) {
                LayoutState.access$2012(layoutState, layoutState.mAvailable);
            }
            recycleByLayoutState(recycler, layoutState);
        }
        return i - layoutState.mAvailable;
    }

    private void recycleByLayoutState(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.mShouldRecycle) {
            if (layoutState.mLayoutDirection == -1) {
                recycleFlexLinesFromEnd(recycler, layoutState);
            } else {
                recycleFlexLinesFromStart(recycler, layoutState);
            }
        }
    }

    private void recycleFlexLinesFromStart(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int childCount;
        View childAt;
        if (layoutState.mScrollingOffset < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(0)) == null) {
            return;
        }
        int i = this.mFlexboxHelper.mIndexToFlexLine[getPosition(childAt)];
        int i2 = -1;
        if (i == -1) {
            return;
        }
        FlexLine flexLine = this.mFlexLines.get(i);
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            if (childAt2 != null) {
                if (!canViewBeRecycledFromStart(childAt2, layoutState.mScrollingOffset)) {
                    break;
                }
                if (flexLine.mLastIndex != getPosition(childAt2)) {
                    continue;
                } else if (i >= this.mFlexLines.size() - 1) {
                    i2 = i3;
                    break;
                } else {
                    i += layoutState.mLayoutDirection;
                    flexLine = this.mFlexLines.get(i);
                    i2 = i3;
                }
            }
        }
        recycleChildren(recycler, 0, i2);
    }

    private boolean canViewBeRecycledFromStart(View view, int scrollingOffset) {
        if (isMainAxisDirectionHorizontal() || !this.mIsRtl) {
            return this.mOrientationHelper.getDecoratedEnd(view) <= scrollingOffset;
        }
        return this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= scrollingOffset;
    }

    private void recycleFlexLinesFromEnd(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int childCount;
        int i;
        View childAt;
        int i2;
        if (layoutState.mScrollingOffset < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt((i = childCount - 1))) == null || (i2 = this.mFlexboxHelper.mIndexToFlexLine[getPosition(childAt)]) == -1) {
            return;
        }
        FlexLine flexLine = this.mFlexLines.get(i2);
        for (int i3 = i; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            if (childAt2 != null) {
                if (!canViewBeRecycledFromEnd(childAt2, layoutState.mScrollingOffset)) {
                    break;
                }
                if (flexLine.mFirstIndex != getPosition(childAt2)) {
                    continue;
                } else if (i2 <= 0) {
                    childCount = i3;
                    break;
                } else {
                    i2 += layoutState.mLayoutDirection;
                    flexLine = this.mFlexLines.get(i2);
                    childCount = i3;
                }
            }
        }
        recycleChildren(recycler, childCount, i);
    }

    private boolean canViewBeRecycledFromEnd(View view, int scrollingOffset) {
        if (isMainAxisDirectionHorizontal() || !this.mIsRtl) {
            return this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - scrollingOffset;
        }
        return this.mOrientationHelper.getDecoratedEnd(view) <= scrollingOffset;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int startIndex, int endIndex) {
        while (endIndex >= startIndex) {
            removeAndRecycleViewAt(endIndex, recycler);
            endIndex--;
        }
    }

    private int layoutFlexLine(FlexLine flexLine, LayoutState layoutState) {
        if (isMainAxisDirectionHorizontal()) {
            return layoutFlexLineMainAxisHorizontal(flexLine, layoutState);
        }
        return layoutFlexLineMainAxisVertical(flexLine, layoutState);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:45:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:49:0x011a  */
    /* JADX WARN: Code duplicated, block: B:52:0x013b  */
    /* JADX WARN: Code duplicated, block: B:53:0x015b  */
    /* JADX WARN: Code duplicated, block: B:60:0x019e A[SYNTHETIC] */
    private int layoutFlexLineMainAxisHorizontal(FlexLine flexLine, LayoutState layoutState) {
        float f;
        float f2;
        float f3;
        float measuredWidth;
        float measuredWidth2;
        float fMax;
        int itemCount;
        int i;
        int i2;
        View flexItemAt;
        int iExtractLowerInt;
        int iExtractHigherInt;
        LayoutParams layoutParams;
        float leftDecorationWidth;
        float rightDecorationWidth;
        int topDecorationHeight;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int width = getWidth();
        int i3 = layoutState.mOffset;
        if (layoutState.mLayoutDirection == -1) {
            i3 -= flexLine.mCrossSize;
        }
        int i4 = i3;
        int i5 = layoutState.mPosition;
        int i6 = this.mJustifyContent;
        int i7 = 1;
        if (i6 != 0) {
            if (i6 == 1) {
                float f4 = (width - flexLine.mMainSize) + paddingRight;
                f3 = 0.0f;
                f2 = flexLine.mMainSize - paddingLeft;
                f = f4;
            } else if (i6 == 2) {
                f = paddingLeft + ((width - flexLine.mMainSize) / 2.0f);
                f2 = (width - paddingRight) - ((width - flexLine.mMainSize) / 2.0f);
            } else if (i6 == 3) {
                f = paddingLeft;
                f3 = (width - flexLine.mMainSize) / (flexLine.mItemCount != 1 ? flexLine.mItemCount - 1 : 1.0f);
                f2 = width - paddingRight;
            } else if (i6 == 4) {
                f3 = flexLine.mItemCount != 0 ? (width - flexLine.mMainSize) / flexLine.mItemCount : 0.0f;
                float f5 = f3 / 2.0f;
                f = paddingLeft + f5;
                f2 = (width - paddingRight) - f5;
            } else if (i6 == 5) {
                f3 = flexLine.mItemCount != 0 ? (width - flexLine.mMainSize) / (flexLine.mItemCount + 1) : 0.0f;
                f = paddingLeft + f3;
                f2 = (width - paddingRight) - f3;
            } else {
                throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
            }
            measuredWidth = f - this.mAnchorInfo.mPerpendicularCoordinate;
            measuredWidth2 = f2 - this.mAnchorInfo.mPerpendicularCoordinate;
            fMax = Math.max(f3, 0.0f);
            itemCount = flexLine.getItemCount();
            i = 0;
            i2 = i5;
            while (i2 < i5 + itemCount) {
                flexItemAt = getFlexItemAt(i2);
                if (flexItemAt != null) {
                    if (layoutState.mLayoutDirection == i7) {
                        calculateItemDecorationsForChild(flexItemAt, TEMP_RECT);
                        addView(flexItemAt);
                    } else {
                        calculateItemDecorationsForChild(flexItemAt, TEMP_RECT);
                        addView(flexItemAt, i);
                        i++;
                    }
                    int i8 = i;
                    long j = this.mFlexboxHelper.mMeasureSpecCache[i2];
                    iExtractLowerInt = this.mFlexboxHelper.extractLowerInt(j);
                    iExtractHigherInt = this.mFlexboxHelper.extractHigherInt(j);
                    layoutParams = (LayoutParams) flexItemAt.getLayoutParams();
                    if (shouldMeasureChild(flexItemAt, iExtractLowerInt, iExtractHigherInt, layoutParams)) {
                        flexItemAt.measure(iExtractLowerInt, iExtractHigherInt);
                    }
                    leftDecorationWidth = measuredWidth + layoutParams.leftMargin + getLeftDecorationWidth(flexItemAt);
                    rightDecorationWidth = measuredWidth2 - (layoutParams.rightMargin + getRightDecorationWidth(flexItemAt));
                    topDecorationHeight = i4 + getTopDecorationHeight(flexItemAt);
                    if (this.mIsRtl) {
                        this.mFlexboxHelper.layoutSingleChildHorizontal(flexItemAt, flexLine, Math.round(rightDecorationWidth) - flexItemAt.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + flexItemAt.getMeasuredHeight());
                    } else {
                        this.mFlexboxHelper.layoutSingleChildHorizontal(flexItemAt, flexLine, Math.round(leftDecorationWidth), topDecorationHeight, Math.round(leftDecorationWidth) + flexItemAt.getMeasuredWidth(), topDecorationHeight + flexItemAt.getMeasuredHeight());
                    }
                    i = i8;
                    measuredWidth = leftDecorationWidth + flexItemAt.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(flexItemAt) + fMax;
                    measuredWidth2 = rightDecorationWidth - (((flexItemAt.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(flexItemAt)) + fMax);
                }
                i2++;
                i7 = 1;
            }
            LayoutState.access$1512(layoutState, this.mLayoutState.mLayoutDirection);
            return flexLine.getCrossSize();
        }
        f = paddingLeft;
        f2 = width - paddingRight;
        f3 = 0.0f;
        measuredWidth = f - this.mAnchorInfo.mPerpendicularCoordinate;
        measuredWidth2 = f2 - this.mAnchorInfo.mPerpendicularCoordinate;
        fMax = Math.max(f3, 0.0f);
        itemCount = flexLine.getItemCount();
        i = 0;
        i2 = i5;
        while (i2 < i5 + itemCount) {
            flexItemAt = getFlexItemAt(i2);
            if (flexItemAt != null) {
                if (layoutState.mLayoutDirection == i7) {
                    calculateItemDecorationsForChild(flexItemAt, TEMP_RECT);
                    addView(flexItemAt);
                } else {
                    calculateItemDecorationsForChild(flexItemAt, TEMP_RECT);
                    addView(flexItemAt, i);
                    i++;
                }
                int i9 = i;
                long j2 = this.mFlexboxHelper.mMeasureSpecCache[i2];
                iExtractLowerInt = this.mFlexboxHelper.extractLowerInt(j2);
                iExtractHigherInt = this.mFlexboxHelper.extractHigherInt(j2);
                layoutParams = (LayoutParams) flexItemAt.getLayoutParams();
                if (shouldMeasureChild(flexItemAt, iExtractLowerInt, iExtractHigherInt, layoutParams)) {
                    flexItemAt.measure(iExtractLowerInt, iExtractHigherInt);
                }
                leftDecorationWidth = measuredWidth + layoutParams.leftMargin + getLeftDecorationWidth(flexItemAt);
                rightDecorationWidth = measuredWidth2 - (layoutParams.rightMargin + getRightDecorationWidth(flexItemAt));
                topDecorationHeight = i4 + getTopDecorationHeight(flexItemAt);
                if (this.mIsRtl) {
                    this.mFlexboxHelper.layoutSingleChildHorizontal(flexItemAt, flexLine, Math.round(rightDecorationWidth) - flexItemAt.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + flexItemAt.getMeasuredHeight());
                } else {
                    this.mFlexboxHelper.layoutSingleChildHorizontal(flexItemAt, flexLine, Math.round(leftDecorationWidth), topDecorationHeight, Math.round(leftDecorationWidth) + flexItemAt.getMeasuredWidth(), topDecorationHeight + flexItemAt.getMeasuredHeight());
                }
                i = i9;
                measuredWidth = leftDecorationWidth + flexItemAt.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(flexItemAt) + fMax;
                measuredWidth2 = rightDecorationWidth - (((flexItemAt.getMeasuredWidth() + layoutParams.leftMargin) + getLeftDecorationWidth(flexItemAt)) + fMax);
            }
            i2++;
            i7 = 1;
        }
        LayoutState.access$1512(layoutState, this.mLayoutState.mLayoutDirection);
        return flexLine.getCrossSize();
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:45:0x010b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0129  */
    /* JADX WARN: Code duplicated, block: B:49:0x0132  */
    /* JADX WARN: Code duplicated, block: B:52:0x014e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0152  */
    /* JADX WARN: Code duplicated, block: B:55:0x017c  */
    /* JADX WARN: Code duplicated, block: B:56:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:58:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:59:0x01ca  */
    private int layoutFlexLineMainAxisVertical(FlexLine flexLine, LayoutState layoutState) {
        float f;
        float f2;
        float f3;
        float measuredHeight;
        float measuredHeight2;
        float fMax;
        int itemCount;
        int i;
        int i2;
        View flexItemAt;
        int iExtractLowerInt;
        int iExtractHigherInt;
        LayoutParams layoutParams;
        float topDecorationHeight;
        float bottomDecorationHeight;
        int leftDecorationWidth;
        int rightDecorationWidth;
        boolean z;
        boolean z2;
        View view;
        int i3;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i4 = layoutState.mOffset;
        int i5 = layoutState.mOffset;
        if (layoutState.mLayoutDirection == -1) {
            i4 -= flexLine.mCrossSize;
            i5 += flexLine.mCrossSize;
        }
        int i6 = i4;
        int i7 = i5;
        int i8 = layoutState.mPosition;
        int i9 = this.mJustifyContent;
        boolean z3 = true;
        if (i9 != 0) {
            if (i9 == 1) {
                float f4 = (height - flexLine.mMainSize) + paddingBottom;
                f3 = 0.0f;
                f2 = flexLine.mMainSize - paddingTop;
                f = f4;
            } else if (i9 == 2) {
                f = paddingTop + ((height - flexLine.mMainSize) / 2.0f);
                f2 = (height - paddingBottom) - ((height - flexLine.mMainSize) / 2.0f);
            } else if (i9 == 3) {
                f = paddingTop;
                f3 = (height - flexLine.mMainSize) / (flexLine.mItemCount != 1 ? flexLine.mItemCount - 1 : 1.0f);
                f2 = height - paddingBottom;
            } else if (i9 == 4) {
                f3 = flexLine.mItemCount != 0 ? (height - flexLine.mMainSize) / flexLine.mItemCount : 0.0f;
                float f5 = f3 / 2.0f;
                f = paddingTop + f5;
                f2 = (height - paddingBottom) - f5;
            } else if (i9 == 5) {
                f3 = flexLine.mItemCount != 0 ? (height - flexLine.mMainSize) / (flexLine.mItemCount + 1) : 0.0f;
                f = paddingTop + f3;
                f2 = (height - paddingBottom) - f3;
            } else {
                throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
            }
            measuredHeight = f - this.mAnchorInfo.mPerpendicularCoordinate;
            measuredHeight2 = f2 - this.mAnchorInfo.mPerpendicularCoordinate;
            fMax = Math.max(f3, 0.0f);
            itemCount = flexLine.getItemCount();
            i = 0;
            i2 = i8;
            while (i2 < i8 + itemCount) {
                flexItemAt = getFlexItemAt(i2);
                if (flexItemAt == null) {
                    i3 = i2;
                    z2 = z3;
                } else {
                    long j = this.mFlexboxHelper.mMeasureSpecCache[i2];
                    iExtractLowerInt = this.mFlexboxHelper.extractLowerInt(j);
                    iExtractHigherInt = this.mFlexboxHelper.extractHigherInt(j);
                    layoutParams = (LayoutParams) flexItemAt.getLayoutParams();
                    if (shouldMeasureChild(flexItemAt, iExtractLowerInt, iExtractHigherInt, layoutParams)) {
                        flexItemAt.measure(iExtractLowerInt, iExtractHigherInt);
                    }
                    topDecorationHeight = measuredHeight + layoutParams.topMargin + getTopDecorationHeight(flexItemAt);
                    bottomDecorationHeight = measuredHeight2 - (layoutParams.rightMargin + getBottomDecorationHeight(flexItemAt));
                    if (layoutState.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(flexItemAt, TEMP_RECT);
                        addView(flexItemAt);
                    } else {
                        calculateItemDecorationsForChild(flexItemAt, TEMP_RECT);
                        addView(flexItemAt, i);
                        i++;
                    }
                    int i10 = i;
                    leftDecorationWidth = i6 + getLeftDecorationWidth(flexItemAt);
                    rightDecorationWidth = i7 - getRightDecorationWidth(flexItemAt);
                    z = this.mIsRtl;
                    if (z) {
                        if (this.mFromBottomToTop) {
                            z2 = true;
                            view = flexItemAt;
                            i3 = i2;
                            this.mFlexboxHelper.layoutSingleChildVertical(flexItemAt, flexLine, z, rightDecorationWidth - flexItemAt.getMeasuredWidth(), Math.round(bottomDecorationHeight) - flexItemAt.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            z2 = true;
                            view = flexItemAt;
                            i3 = i2;
                            this.mFlexboxHelper.layoutSingleChildVertical(view, flexLine, z, rightDecorationWidth - view.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, Math.round(topDecorationHeight) + view.getMeasuredHeight());
                        }
                    } else {
                        z2 = true;
                        view = flexItemAt;
                        i3 = i2;
                        if (this.mFromBottomToTop) {
                            this.mFlexboxHelper.layoutSingleChildVertical(view, flexLine, z, leftDecorationWidth, Math.round(bottomDecorationHeight) - view.getMeasuredHeight(), leftDecorationWidth + view.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                        } else {
                            this.mFlexboxHelper.layoutSingleChildVertical(view, flexLine, z, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + view.getMeasuredWidth(), Math.round(topDecorationHeight) + view.getMeasuredHeight());
                        }
                    }
                    View view2 = view;
                    i = i10;
                    measuredHeight = topDecorationHeight + view.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(view2) + fMax;
                    measuredHeight2 = bottomDecorationHeight - (((view2.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(view2)) + fMax);
                }
                i2 = i3 + 1;
                z3 = z2;
            }
            LayoutState.access$1512(layoutState, this.mLayoutState.mLayoutDirection);
            return flexLine.getCrossSize();
        }
        f = paddingTop;
        f2 = height - paddingBottom;
        f3 = 0.0f;
        measuredHeight = f - this.mAnchorInfo.mPerpendicularCoordinate;
        measuredHeight2 = f2 - this.mAnchorInfo.mPerpendicularCoordinate;
        fMax = Math.max(f3, 0.0f);
        itemCount = flexLine.getItemCount();
        i = 0;
        i2 = i8;
        while (i2 < i8 + itemCount) {
            flexItemAt = getFlexItemAt(i2);
            if (flexItemAt == null) {
                i3 = i2;
                z2 = z3;
            } else {
                long j2 = this.mFlexboxHelper.mMeasureSpecCache[i2];
                iExtractLowerInt = this.mFlexboxHelper.extractLowerInt(j2);
                iExtractHigherInt = this.mFlexboxHelper.extractHigherInt(j2);
                layoutParams = (LayoutParams) flexItemAt.getLayoutParams();
                if (shouldMeasureChild(flexItemAt, iExtractLowerInt, iExtractHigherInt, layoutParams)) {
                    flexItemAt.measure(iExtractLowerInt, iExtractHigherInt);
                }
                topDecorationHeight = measuredHeight + layoutParams.topMargin + getTopDecorationHeight(flexItemAt);
                bottomDecorationHeight = measuredHeight2 - (layoutParams.rightMargin + getBottomDecorationHeight(flexItemAt));
                if (layoutState.mLayoutDirection == 1) {
                    calculateItemDecorationsForChild(flexItemAt, TEMP_RECT);
                    addView(flexItemAt);
                } else {
                    calculateItemDecorationsForChild(flexItemAt, TEMP_RECT);
                    addView(flexItemAt, i);
                    i++;
                }
                int i11 = i;
                leftDecorationWidth = i6 + getLeftDecorationWidth(flexItemAt);
                rightDecorationWidth = i7 - getRightDecorationWidth(flexItemAt);
                z = this.mIsRtl;
                if (z) {
                    if (this.mFromBottomToTop) {
                        z2 = true;
                        view = flexItemAt;
                        i3 = i2;
                        this.mFlexboxHelper.layoutSingleChildVertical(flexItemAt, flexLine, z, rightDecorationWidth - flexItemAt.getMeasuredWidth(), Math.round(bottomDecorationHeight) - flexItemAt.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                    } else {
                        z2 = true;
                        view = flexItemAt;
                        i3 = i2;
                        this.mFlexboxHelper.layoutSingleChildVertical(view, flexLine, z, rightDecorationWidth - view.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, Math.round(topDecorationHeight) + view.getMeasuredHeight());
                    }
                } else {
                    z2 = true;
                    view = flexItemAt;
                    i3 = i2;
                    if (this.mFromBottomToTop) {
                        this.mFlexboxHelper.layoutSingleChildVertical(view, flexLine, z, leftDecorationWidth, Math.round(bottomDecorationHeight) - view.getMeasuredHeight(), leftDecorationWidth + view.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.mFlexboxHelper.layoutSingleChildVertical(view, flexLine, z, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + view.getMeasuredWidth(), Math.round(topDecorationHeight) + view.getMeasuredHeight());
                    }
                }
                View view3 = view;
                i = i11;
                measuredHeight = topDecorationHeight + view.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(view3) + fMax;
                measuredHeight2 = bottomDecorationHeight - (((view3.getMeasuredHeight() + layoutParams.bottomMargin) + getTopDecorationHeight(view3)) + fMax);
            }
            i2 = i3 + 1;
            z3 = z2;
        }
        LayoutState.access$1512(layoutState, this.mLayoutState.mLayoutDirection);
        return flexLine.getCrossSize();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public boolean isMainAxisDirectionHorizontal() {
        int i = this.mFlexDirection;
        return i == 0 || i == 1;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo anchorInfo, boolean fromNextLine, boolean considerInfinite) {
        if (considerInfinite) {
            resolveInfiniteAmount();
        } else {
            this.mLayoutState.mInfinite = false;
        }
        if (!isMainAxisDirectionHorizontal() && this.mIsRtl) {
            this.mLayoutState.mAvailable = anchorInfo.mCoordinate - getPaddingRight();
        } else {
            this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - anchorInfo.mCoordinate;
        }
        this.mLayoutState.mPosition = anchorInfo.mPosition;
        this.mLayoutState.mItemDirection = 1;
        this.mLayoutState.mLayoutDirection = 1;
        this.mLayoutState.mOffset = anchorInfo.mCoordinate;
        this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
        this.mLayoutState.mFlexLinePosition = anchorInfo.mFlexLinePosition;
        if (!fromNextLine || this.mFlexLines.size() <= 1 || anchorInfo.mFlexLinePosition < 0 || anchorInfo.mFlexLinePosition >= this.mFlexLines.size() - 1) {
            return;
        }
        FlexLine flexLine = this.mFlexLines.get(anchorInfo.mFlexLinePosition);
        LayoutState.access$1508(this.mLayoutState);
        LayoutState.access$2212(this.mLayoutState, flexLine.getItemCount());
    }

    private void updateLayoutStateToFillStart(AnchorInfo anchorInfo, boolean fromPreviousLine, boolean considerInfinite) {
        if (considerInfinite) {
            resolveInfiniteAmount();
        } else {
            this.mLayoutState.mInfinite = false;
        }
        if (!isMainAxisDirectionHorizontal() && this.mIsRtl) {
            this.mLayoutState.mAvailable = (this.mParent.getWidth() - anchorInfo.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            this.mLayoutState.mAvailable = anchorInfo.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        }
        this.mLayoutState.mPosition = anchorInfo.mPosition;
        this.mLayoutState.mItemDirection = 1;
        this.mLayoutState.mLayoutDirection = -1;
        this.mLayoutState.mOffset = anchorInfo.mCoordinate;
        this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
        this.mLayoutState.mFlexLinePosition = anchorInfo.mFlexLinePosition;
        if (!fromPreviousLine || anchorInfo.mFlexLinePosition <= 0 || this.mFlexLines.size() <= anchorInfo.mFlexLinePosition) {
            return;
        }
        FlexLine flexLine = this.mFlexLines.get(anchorInfo.mFlexLinePosition);
        LayoutState.access$1510(this.mLayoutState);
        LayoutState.access$2220(this.mLayoutState, flexLine.getItemCount());
    }

    private void resolveInfiniteAmount() {
        int widthMode;
        if (isMainAxisDirectionHorizontal()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.mLayoutState.mInfinite = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void ensureOrientationHelper() {
        if (this.mOrientationHelper != null) {
            return;
        }
        if (isMainAxisDirectionHorizontal()) {
            if (this.mFlexWrap == 0) {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.mSubOrientationHelper = OrientationHelper.createVerticalHelper(this);
                return;
            } else {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mSubOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                return;
            }
        }
        if (this.mFlexWrap == 0) {
            this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
            this.mSubOrientationHelper = OrientationHelper.createHorizontalHelper(this);
        } else {
            this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
            this.mSubOrientationHelper = OrientationHelper.createVerticalHelper(this);
        }
    }

    private void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = new LayoutState();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int position) {
        this.mPendingScrollPosition = position;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public void setRecycleChildrenOnDetach(boolean recycleChildrenOnDetach) {
        this.mRecycleChildrenOnDetach = recycleChildrenOnDetach;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.mParent = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView view, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(view, recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.mFlexWrap == 0) {
            return isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            int width = getWidth();
            View view = this.mParent;
            if (width <= (view != null ? view.getWidth() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.mFlexWrap == 0) {
            return !isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            return true;
        }
        int height = getHeight();
        View view = this.mParent;
        return height > (view != null ? view.getHeight() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!isMainAxisDirectionHorizontal() || this.mFlexWrap == 0) {
            int iHandleScrollingMainOrientation = handleScrollingMainOrientation(dx, recycler, state);
            this.mViewCache.clear();
            return iHandleScrollingMainOrientation;
        }
        int iHandleScrollingSubOrientation = handleScrollingSubOrientation(dx);
        AnchorInfo.access$2412(this.mAnchorInfo, iHandleScrollingSubOrientation);
        this.mSubOrientationHelper.offsetChildren(-iHandleScrollingSubOrientation);
        return iHandleScrollingSubOrientation;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (isMainAxisDirectionHorizontal() || (this.mFlexWrap == 0 && !isMainAxisDirectionHorizontal())) {
            int iHandleScrollingMainOrientation = handleScrollingMainOrientation(dy, recycler, state);
            this.mViewCache.clear();
            return iHandleScrollingMainOrientation;
        }
        int iHandleScrollingSubOrientation = handleScrollingSubOrientation(dy);
        AnchorInfo.access$2412(this.mAnchorInfo, iHandleScrollingSubOrientation);
        this.mSubOrientationHelper.offsetChildren(-iHandleScrollingSubOrientation);
        return iHandleScrollingSubOrientation;
    }

    private int handleScrollingMainOrientation(int delta, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || delta == 0) {
            return 0;
        }
        ensureOrientationHelper();
        int i = 1;
        this.mLayoutState.mShouldRecycle = true;
        boolean z = !isMainAxisDirectionHorizontal() && this.mIsRtl;
        if (!z ? delta <= 0 : delta >= 0) {
            i = -1;
        }
        int iAbs = Math.abs(delta);
        updateLayoutState(i, iAbs);
        int iFill = this.mLayoutState.mScrollingOffset + fill(recycler, state, this.mLayoutState);
        if (iFill < 0) {
            return 0;
        }
        if (z) {
            if (iAbs > iFill) {
                delta = (-i) * iFill;
            }
        } else if (iAbs > iFill) {
            delta = i * iFill;
        }
        this.mOrientationHelper.offsetChildren(-delta);
        this.mLayoutState.mLastScrollDelta = delta;
        return delta;
    }

    private int handleScrollingSubOrientation(int delta) {
        int iMin;
        if (getChildCount() == 0 || delta == 0) {
            return 0;
        }
        ensureOrientationHelper();
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        View view = this.mParent;
        int width = zIsMainAxisDirectionHorizontal ? view.getWidth() : view.getHeight();
        int width2 = zIsMainAxisDirectionHorizontal ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int iAbs = Math.abs(delta);
            if (delta < 0) {
                iMin = Math.min((width2 + this.mAnchorInfo.mPerpendicularCoordinate) - width, iAbs);
            } else {
                if (this.mAnchorInfo.mPerpendicularCoordinate + delta <= 0) {
                    return delta;
                }
                iMin = this.mAnchorInfo.mPerpendicularCoordinate;
            }
        } else {
            if (delta > 0) {
                return Math.min((width2 - this.mAnchorInfo.mPerpendicularCoordinate) - width, delta);
            }
            if (this.mAnchorInfo.mPerpendicularCoordinate + delta >= 0) {
                return delta;
            }
            iMin = this.mAnchorInfo.mPerpendicularCoordinate;
        }
        return -iMin;
    }

    private void updateLayoutState(int layoutDirection, int absDelta) {
        this.mLayoutState.mLayoutDirection = layoutDirection;
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !zIsMainAxisDirectionHorizontal && this.mIsRtl;
        if (layoutDirection == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt == null) {
                return;
            }
            this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View viewFindLastReferenceViewInLine = findLastReferenceViewInLine(childAt, this.mFlexLines.get(this.mFlexboxHelper.mIndexToFlexLine[position]));
            this.mLayoutState.mItemDirection = 1;
            LayoutState layoutState = this.mLayoutState;
            layoutState.mPosition = position + layoutState.mItemDirection;
            if (this.mFlexboxHelper.mIndexToFlexLine.length <= this.mLayoutState.mPosition) {
                this.mLayoutState.mFlexLinePosition = -1;
            } else {
                this.mLayoutState.mFlexLinePosition = this.mFlexboxHelper.mIndexToFlexLine[this.mLayoutState.mPosition];
            }
            if (z) {
                this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(viewFindLastReferenceViewInLine);
                this.mLayoutState.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(viewFindLastReferenceViewInLine)) + this.mOrientationHelper.getStartAfterPadding();
                LayoutState layoutState2 = this.mLayoutState;
                layoutState2.mScrollingOffset = Math.max(layoutState2.mScrollingOffset, 0);
            } else {
                this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(viewFindLastReferenceViewInLine);
                this.mLayoutState.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(viewFindLastReferenceViewInLine) - this.mOrientationHelper.getEndAfterPadding();
            }
            if ((this.mLayoutState.mFlexLinePosition == -1 || this.mLayoutState.mFlexLinePosition > this.mFlexLines.size() - 1) && this.mLayoutState.mPosition <= getFlexItemCount()) {
                int i = absDelta - this.mLayoutState.mScrollingOffset;
                this.mFlexLinesResult.reset();
                if (i > 0) {
                    if (zIsMainAxisDirectionHorizontal) {
                        this.mFlexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, iMakeMeasureSpec, iMakeMeasureSpec2, i, this.mLayoutState.mPosition, this.mFlexLines);
                    } else {
                        this.mFlexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, iMakeMeasureSpec, iMakeMeasureSpec2, i, this.mLayoutState.mPosition, this.mFlexLines);
                    }
                    this.mFlexboxHelper.determineMainSize(iMakeMeasureSpec, iMakeMeasureSpec2, this.mLayoutState.mPosition);
                    this.mFlexboxHelper.stretchViews(this.mLayoutState.mPosition);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 == null) {
                return;
            }
            this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View viewFindFirstReferenceViewInLine = findFirstReferenceViewInLine(childAt2, this.mFlexLines.get(this.mFlexboxHelper.mIndexToFlexLine[position2]));
            this.mLayoutState.mItemDirection = 1;
            int i2 = this.mFlexboxHelper.mIndexToFlexLine[position2];
            if (i2 == -1) {
                i2 = 0;
            }
            if (i2 > 0) {
                this.mLayoutState.mPosition = position2 - this.mFlexLines.get(i2 - 1).getItemCount();
            } else {
                this.mLayoutState.mPosition = -1;
            }
            this.mLayoutState.mFlexLinePosition = i2 > 0 ? i2 - 1 : 0;
            if (z) {
                this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(viewFindFirstReferenceViewInLine);
                this.mLayoutState.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(viewFindFirstReferenceViewInLine) - this.mOrientationHelper.getEndAfterPadding();
                LayoutState layoutState3 = this.mLayoutState;
                layoutState3.mScrollingOffset = Math.max(layoutState3.mScrollingOffset, 0);
            } else {
                this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(viewFindFirstReferenceViewInLine);
                this.mLayoutState.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(viewFindFirstReferenceViewInLine)) + this.mOrientationHelper.getStartAfterPadding();
            }
        }
        LayoutState layoutState4 = this.mLayoutState;
        layoutState4.mAvailable = absDelta - layoutState4.mScrollingOffset;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    private View findFirstReferenceViewInLine(View firstView, FlexLine firstVisibleLine) {
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int i = firstVisibleLine.mItemCount;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !zIsMainAxisDirectionHorizontal) {
                    if (this.mOrientationHelper.getDecoratedEnd(firstView) < this.mOrientationHelper.getDecoratedEnd(childAt)) {
                        firstView = childAt;
                    }
                } else if (this.mOrientationHelper.getDecoratedStart(firstView) > this.mOrientationHelper.getDecoratedStart(childAt)) {
                    firstView = childAt;
                }
            }
        }
        return firstView;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0047  */
    private View findLastReferenceViewInLine(View lastView, FlexLine lastVisibleLine) {
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int childCount = (getChildCount() - lastVisibleLine.mItemCount) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.mIsRtl && !zIsMainAxisDirectionHorizontal) {
                    if (this.mOrientationHelper.getDecoratedStart(lastView) > this.mOrientationHelper.getDecoratedStart(childAt)) {
                        lastView = childAt;
                    }
                } else if (this.mOrientationHelper.getDecoratedEnd(lastView) < this.mOrientationHelper.getDecoratedEnd(childAt)) {
                    lastView = childAt;
                }
            }
        }
        return lastView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        ensureOrientationHelper();
        View viewFindFirstReferenceChild = findFirstReferenceChild(itemCount);
        View viewFindLastReferenceChild = findLastReferenceChild(itemCount);
        if (state.getItemCount() == 0 || viewFindFirstReferenceChild == null || viewFindLastReferenceChild == null) {
            return 0;
        }
        return Math.min(this.mOrientationHelper.getTotalSpace(), this.mOrientationHelper.getDecoratedEnd(viewFindLastReferenceChild) - this.mOrientationHelper.getDecoratedStart(viewFindFirstReferenceChild));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View viewFindFirstReferenceChild = findFirstReferenceChild(itemCount);
        View viewFindLastReferenceChild = findLastReferenceChild(itemCount);
        if (state.getItemCount() != 0 && viewFindFirstReferenceChild != null && viewFindLastReferenceChild != null) {
            int position = getPosition(viewFindFirstReferenceChild);
            int position2 = getPosition(viewFindLastReferenceChild);
            int iAbs = Math.abs(this.mOrientationHelper.getDecoratedEnd(viewFindLastReferenceChild) - this.mOrientationHelper.getDecoratedStart(viewFindFirstReferenceChild));
            int i = this.mFlexboxHelper.mIndexToFlexLine[position];
            if (i != 0 && i != -1) {
                return Math.round((i * (iAbs / ((this.mFlexboxHelper.mIndexToFlexLine[position2] - i) + 1))) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(viewFindFirstReferenceChild)));
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View viewFindFirstReferenceChild = findFirstReferenceChild(itemCount);
        View viewFindLastReferenceChild = findLastReferenceChild(itemCount);
        if (state.getItemCount() == 0 || viewFindFirstReferenceChild == null || viewFindLastReferenceChild == null) {
            return 0;
        }
        return (int) ((Math.abs(this.mOrientationHelper.getDecoratedEnd(viewFindLastReferenceChild) - this.mOrientationHelper.getDecoratedStart(viewFindFirstReferenceChild)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition()) + 1)) * state.getItemCount());
    }

    private boolean shouldMeasureChild(View child, int widthSpec, int heightSpec, RecyclerView.LayoutParams lp) {
        return (!child.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(child.getWidth(), widthSpec, lp.width) && isMeasurementUpToDate(child.getHeight(), heightSpec, lp.height)) ? false : true;
    }

    private static boolean isMeasurementUpToDate(int childSize, int spec, int dimension) {
        int mode = View.MeasureSpec.getMode(spec);
        int size = View.MeasureSpec.getSize(spec);
        if (dimension > 0 && childSize != dimension) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= childSize;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == childSize;
        }
        return true;
    }

    private void clearFlexLines() {
        this.mFlexLines.clear();
        this.mAnchorInfo.reset();
        this.mAnchorInfo.mPerpendicularCoordinate = 0;
    }

    private int getChildLeft(View view) {
        return getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }

    private int getChildRight(View view) {
        return getDecoratedRight(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
    }

    private int getChildTop(View view) {
        return getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    private int getChildBottom(View view) {
        return getDecoratedBottom(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    private boolean isViewVisible(View view, boolean completelyVisible) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int childLeft = getChildLeft(view);
        int childTop = getChildTop(view);
        int childRight = getChildRight(view);
        int childBottom = getChildBottom(view);
        boolean z = paddingLeft <= childLeft && width >= childRight;
        boolean z2 = childLeft >= width || childRight >= paddingLeft;
        boolean z3 = paddingTop <= childTop && height >= childBottom;
        boolean z4 = childTop >= height || childBottom >= paddingTop;
        if (completelyVisible) {
            return z && z3;
        }
        return z2 && z4;
    }

    public int findFirstVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    private View findOneVisibleChild(int fromIndex, int toIndex, boolean completelyVisible) {
        int i = toIndex > fromIndex ? 1 : -1;
        while (fromIndex != toIndex) {
            View childAt = getChildAt(fromIndex);
            if (isViewVisible(childAt, completelyVisible)) {
                return childAt;
            }
            fromIndex += i;
        }
        return null;
    }

    int getPositionToFlexLineIndex(int position) {
        return this.mFlexboxHelper.mIndexToFlexLine[position];
    }

    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() { // from class: com.google.android.flexbox.FlexboxLayoutManager.LayoutParams.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LayoutParams createFromParcel(Parcel source) {
                return new LayoutParams(source);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LayoutParams[] newArray(int size) {
                return new LayoutParams[size];
            }
        };
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
        private boolean mWrapBefore;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return this.width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWidth(int width) {
            this.width = width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return this.height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setHeight(int height) {
            this.height = height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexGrow(float flexGrow) {
            this.mFlexGrow = flexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexShrink(float flexShrink) {
            this.mFlexShrink = flexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setAlignSelf(int alignSelf) {
            this.mAlignSelf = alignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int minWidth) {
            this.mMinWidth = minWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinHeight(int minHeight) {
            this.mMinHeight = minHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxWidth(int maxWidth) {
            this.mMaxWidth = maxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxHeight(int maxHeight) {
            this.mMaxHeight = maxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWrapBefore(boolean wrapBefore) {
            this.mWrapBefore = wrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexBasisPercent(float flexBasisPercent) {
            this.mFlexBasisPercent = flexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return this.bottomMargin;
        }

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(RecyclerView.LayoutParams source) {
            super(source);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(LayoutParams source) {
            super((RecyclerView.LayoutParams) source);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mFlexGrow = source.mFlexGrow;
            this.mFlexShrink = source.mFlexShrink;
            this.mAlignSelf = source.mAlignSelf;
            this.mFlexBasisPercent = source.mFlexBasisPercent;
            this.mMinWidth = source.mMinWidth;
            this.mMinHeight = source.mMinHeight;
            this.mMaxWidth = source.mMaxWidth;
            this.mMaxHeight = source.mMaxHeight;
            this.mWrapBefore = source.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setOrder(int order) {
            throw new UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.mWrapBefore ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }

        protected LayoutParams(Parcel in) {
            super(-2, -2);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mFlexGrow = in.readFloat();
            this.mFlexShrink = in.readFloat();
            this.mAlignSelf = in.readInt();
            this.mFlexBasisPercent = in.readFloat();
            this.mMinWidth = in.readInt();
            this.mMinHeight = in.readInt();
            this.mMaxWidth = in.readInt();
            this.mMaxHeight = in.readInt();
            this.mWrapBefore = in.readByte() != 0;
            this.bottomMargin = in.readInt();
            this.leftMargin = in.readInt();
            this.rightMargin = in.readInt();
            this.topMargin = in.readInt();
            this.height = in.readInt();
            this.width = in.readInt();
        }
    }

    private class AnchorInfo {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean mAssignedFromSavedState;
        private int mCoordinate;
        private int mFlexLinePosition;
        private boolean mLayoutFromEnd;
        private int mPerpendicularCoordinate;
        private int mPosition;
        private boolean mValid;

        private AnchorInfo() {
            this.mPerpendicularCoordinate = 0;
        }

        static /* synthetic */ int access$2412(AnchorInfo anchorInfo, int i) {
            int i2 = anchorInfo.mPerpendicularCoordinate + i;
            anchorInfo.mPerpendicularCoordinate = i2;
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.mFlexLinePosition = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mValid = false;
            this.mAssignedFromSavedState = false;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal()) {
                if (FlexboxLayoutManager.this.mFlexWrap == 0) {
                    this.mLayoutFromEnd = FlexboxLayoutManager.this.mFlexDirection == 1;
                    return;
                } else {
                    this.mLayoutFromEnd = FlexboxLayoutManager.this.mFlexWrap == 2;
                    return;
                }
            }
            if (FlexboxLayoutManager.this.mFlexWrap == 0) {
                this.mLayoutFromEnd = FlexboxLayoutManager.this.mFlexDirection == 3;
            } else {
                this.mLayoutFromEnd = FlexboxLayoutManager.this.mFlexWrap == 2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            if (!FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() && FlexboxLayoutManager.this.mIsRtl) {
                this.mCoordinate = this.mLayoutFromEnd ? FlexboxLayoutManager.this.mOrientationHelper.getEndAfterPadding() : FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.mOrientationHelper.getStartAfterPadding();
            } else {
                this.mCoordinate = this.mLayoutFromEnd ? FlexboxLayoutManager.this.mOrientationHelper.getEndAfterPadding() : FlexboxLayoutManager.this.mOrientationHelper.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void assignFromView(View anchor) {
            OrientationHelper orientationHelper = FlexboxLayoutManager.this.mFlexWrap == 0 ? FlexboxLayoutManager.this.mSubOrientationHelper : FlexboxLayoutManager.this.mOrientationHelper;
            if (!FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() && FlexboxLayoutManager.this.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = orientationHelper.getDecoratedStart(anchor) + orientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = orientationHelper.getDecoratedEnd(anchor);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = orientationHelper.getDecoratedEnd(anchor) + orientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = orientationHelper.getDecoratedStart(anchor);
            }
            this.mPosition = FlexboxLayoutManager.this.getPosition(anchor);
            this.mAssignedFromSavedState = false;
            int[] iArr = FlexboxLayoutManager.this.mFlexboxHelper.mIndexToFlexLine;
            int i = this.mPosition;
            if (i == -1) {
                i = 0;
            }
            int i2 = iArr[i];
            this.mFlexLinePosition = i2 != -1 ? i2 : 0;
            if (FlexboxLayoutManager.this.mFlexLines.size() > this.mFlexLinePosition) {
                this.mPosition = ((FlexLine) FlexboxLayoutManager.this.mFlexLines.get(this.mFlexLinePosition)).mFirstIndex;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.mFlexLinePosition + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.mPerpendicularCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.mAssignedFromSavedState + '}';
        }
    }

    private static class LayoutState {
        private static final int ITEM_DIRECTION_TAIL = 1;
        private static final int LAYOUT_END = 1;
        private static final int LAYOUT_START = -1;
        private static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
        private int mAvailable;
        private int mFlexLinePosition;
        private boolean mInfinite;
        private int mItemDirection;
        private int mLastScrollDelta;
        private int mLayoutDirection;
        private int mOffset;
        private int mPosition;
        private int mScrollingOffset;
        private boolean mShouldRecycle;

        private LayoutState() {
            this.mItemDirection = 1;
            this.mLayoutDirection = 1;
        }

        static /* synthetic */ int access$1012(LayoutState layoutState, int i) {
            int i2 = layoutState.mOffset + i;
            layoutState.mOffset = i2;
            return i2;
        }

        static /* synthetic */ int access$1020(LayoutState layoutState, int i) {
            int i2 = layoutState.mOffset - i;
            layoutState.mOffset = i2;
            return i2;
        }

        static /* synthetic */ int access$1220(LayoutState layoutState, int i) {
            int i2 = layoutState.mAvailable - i;
            layoutState.mAvailable = i2;
            return i2;
        }

        static /* synthetic */ int access$1508(LayoutState layoutState) {
            int i = layoutState.mFlexLinePosition;
            layoutState.mFlexLinePosition = i + 1;
            return i;
        }

        static /* synthetic */ int access$1510(LayoutState layoutState) {
            int i = layoutState.mFlexLinePosition;
            layoutState.mFlexLinePosition = i - 1;
            return i;
        }

        static /* synthetic */ int access$1512(LayoutState layoutState, int i) {
            int i2 = layoutState.mFlexLinePosition + i;
            layoutState.mFlexLinePosition = i2;
            return i2;
        }

        static /* synthetic */ int access$2012(LayoutState layoutState, int i) {
            int i2 = layoutState.mScrollingOffset + i;
            layoutState.mScrollingOffset = i2;
            return i2;
        }

        static /* synthetic */ int access$2212(LayoutState layoutState, int i) {
            int i2 = layoutState.mPosition + i;
            layoutState.mPosition = i2;
            return i2;
        }

        static /* synthetic */ int access$2220(LayoutState layoutState, int i) {
            int i2 = layoutState.mPosition - i;
            layoutState.mPosition = i2;
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasMore(RecyclerView.State state, List<FlexLine> flexLines) {
            int i;
            int i2 = this.mPosition;
            return i2 >= 0 && i2 < state.getItemCount() && (i = this.mFlexLinePosition) >= 0 && i < flexLines.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.mFlexLinePosition + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
        }
    }

    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.flexbox.FlexboxLayoutManager.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel source) {
                return new SavedState(source);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        private int mAnchorOffset;
        private int mAnchorPosition;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.mAnchorPosition);
            dest.writeInt(this.mAnchorOffset);
        }

        SavedState() {
        }

        private SavedState(Parcel in) {
            this.mAnchorPosition = in.readInt();
            this.mAnchorOffset = in.readInt();
        }

        private SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasValidAnchor(int itemCount) {
            int i = this.mAnchorPosition;
            return i >= 0 && i < itemCount;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }
    }
}
