package com.android.launcher66;

import static android.view.MotionEvent.ACTION_POINTER_INDEX_MASK;
import static android.view.accessibility.AccessibilityEvent.CONTENT_CHANGE_TYPE_ENABLED;
import static android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD;
import static android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;

import com.syu.ipc.data.FinalCanbus;
import java.util.ArrayList;

public abstract class PagedView extends ViewGroup implements ViewGroup.OnHierarchyChangeListener {
    protected static final float ALPHA_QUANTIZE_LEVEL = 1.0E-4f;
    private static final int ANIM_TAG_KEY = 100;
    static final int AUTOMATIC_PAGE_SPACING = -1;
    private static final boolean DEBUG = false;
    private static final boolean DISABLE_FLING_TO_DELETE = true;
    private static final boolean DISABLE_TOUCH_INTERACTION = false;
    private static final boolean DISABLE_TOUCH_SIDE_PAGES = true;
    private static final int FLING_THRESHOLD_VELOCITY = 500;
    protected static final int INVALID_PAGE = -1;
    protected static final int INVALID_POINTER = -1;
    public static final int INVALID_RESTORE_PAGE = -1001;
    private static final int MIN_FLING_VELOCITY = 250;
    private static final int MIN_LENGTH_FOR_FLING = 25;
    private static final int MIN_SNAP_VELOCITY = 1500;
    protected static final float NANOTIME_DIV = 1.0E9f;
    private static final float OVERSCROLL_ACCELERATE_FACTOR = 2.0f;
    private static final float OVERSCROLL_DAMP_FACTOR = 0.14f;
    protected static final int PAGE_SNAP_ANIMATION_DURATION = 750;
    private static final float RETURN_TO_ORIGINAL_PAGE_THRESHOLD = 0.33f;
    private static final float SIGNIFICANT_MOVE_THRESHOLD = 0.4f;
    protected static final int SLOW_PAGE_SNAP_ANIMATION_DURATION = 950;
    private static final String TAG = "PagedView";
    protected static final int TOUCH_STATE_NEXT_PAGE = 3;
    protected static final int TOUCH_STATE_PREV_PAGE = 2;
    protected static final int TOUCH_STATE_REORDERING = 4;
    protected static final int TOUCH_STATE_REST = 0;
    protected static final int TOUCH_STATE_SCROLLING = 1;
    private int DELETE_SLIDE_IN_SIDE_PAGE_DURATION;
    private int DRAG_TO_DELETE_FADE_OUT_DURATION;
    private int FLING_TO_DELETE_FADE_OUT_DURATION;
    private float FLING_TO_DELETE_FRICTION;
    private float FLING_TO_DELETE_MAX_FLING_DEGREES;
    private int NUM_ANIMATIONS_RUNNING_BEFORE_ZOOM_OUT;
    private int REORDERING_DROP_REPOSITION_DURATION;
    protected int REORDERING_REORDER_REPOSITION_DURATION;
    private int REORDERING_SIDE_PAGE_HOVER_TIMEOUT;
    protected int REORDERING_ZOOM_IN_OUT_DURATION;
    protected int mActivePointerId;
    protected boolean mAllowLongPress;
    protected boolean mAllowOverScroll;
    private boolean mAllowPagedViewAnimations;
    private Rect mAltTmpRect;
    private boolean mAutoComputePageSpacing;
    private boolean mCancelTap;
    protected int mCellCountX;
    protected int mCellCountY;
    protected boolean mCenterPagesVertically;
    protected int mChildCountOnLastLayout;
    protected boolean mContentIsRefreshable;
    protected int mCurrentPage;
    protected boolean mDeferLoadAssociatedPagesUntilScrollCompletes;
    protected boolean mDeferScrollUpdate;
    private boolean mDeferringForDelete;
    private View mDeleteDropTarget;
    protected float mDensity;
    protected ArrayList<Boolean> mDirtyPageContent;
    private float mDownMotionX;
    private float mDownMotionY;
    private float mDownScrollX;
    protected View mDragView;
    private float mDragViewBaselineLeft;
    protected boolean mFadeInAdjacentScreens;
    protected int mFirstChildLeft;
    protected boolean mFirstLayout;
    protected int mFlingThresholdVelocity;
    protected int mFlingToDeleteThresholdVelocity;
    protected boolean mForceDrawAllChildrenNextFrame;
    protected boolean mForceScreenScrolled;
    private boolean mFreeScroll;
    private int mFreeScrollMaxScrollX;
    private int mFreeScrollMinScrollX;
    protected final Rect mInsets;
    protected boolean mIsDataReady;
    protected boolean mIsPageMoving;
    private boolean mIsReordering;
    protected float mLastMotionX;
    protected float mLastMotionXRemainder;
    protected float mLastMotionY;
    private int mLastScreenCenter;
    protected View.OnLongClickListener mLongClickListener;
    protected int mMaxScrollX;
    private int mMaximumVelocity;
    protected int mMinFlingVelocity;
    private float mMinScale;
    protected int mMinSnapVelocity;
    protected int mNextPage;
    private int mNormalChildHeight;
    protected int mOverScrollX;
    private PageIndicator mPageIndicator;
    private int mPageIndicatorViewId;
    protected int mPageLayoutHeightGap;
    protected int mPageLayoutPaddingBottom;
    protected int mPageLayoutPaddingLeft;
    protected int mPageLayoutPaddingRight;
    protected int mPageLayoutPaddingTop;
    protected int mPageLayoutWidthGap;
    private int[] mPageScrolls;
    protected int mPageSpacing;
    private PageSwitchListener mPageSwitchListener;
    private int mPagingTouchSlop;
    private float mParentDownMotionX;
    private float mParentDownMotionY;
    private int mPostReorderingPreZoomInRemainingAnimationCount;
    private Runnable mPostReorderingPreZoomInRunnable;
    private boolean mRecomputePageSpacing;
    private boolean mReorderingStarted;
    protected int mRestorePage;
    protected Scroller mScroller;
    private int mSidePageHoverIndex;
    private Runnable mSidePageHoverRunnable;
    protected float mSmoothingTime;
    protected int[] mTempVisiblePagesRange;
    private int[] mTmpIntPoint;
    private Matrix mTmpInvMatrix;
    private float[] mTmpPoint;
    private Rect mTmpRect;
    private boolean mTopAlignPageWhenShrinkingForBouncer;
    protected float mTotalMotionX;
    protected int mTouchSlop;
    protected int mTouchState;
    protected float mTouchX;
    protected int mUnboundedScrollX;
    private boolean mUseMinScale;
    protected boolean mUsePagingTouchSlop;
    private VelocityTracker mVelocityTracker;
    private Rect mViewport;
    protected AnimatorSet mZoomInOutAnim;

    public interface PageSwitchListener {
        void onPageSwitch(View view, int i);
    }

    public abstract void syncPageItems(int i, boolean z);

    public abstract void syncPages();

    public PagedView(Context context) {
        this(context, null);
    }

    public PagedView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PagedView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mFreeScroll = false;
        this.mFreeScrollMinScrollX = -1;
        this.mFreeScrollMaxScrollX = -1;
        this.mFirstLayout = true;
        this.mRestorePage = INVALID_RESTORE_PAGE;
        this.mNextPage = -1;
        this.mLastScreenCenter = -1;
        this.mTouchState = 0;
        this.mForceScreenScrolled = false;
        this.mCellCountX = 0;
        this.mCellCountY = 0;
        this.mAllowOverScroll = true;
        this.mTempVisiblePagesRange = new int[2];
        this.mActivePointerId = -1;
        this.mContentIsRefreshable = true;
        this.mFadeInAdjacentScreens = false;
        this.mUsePagingTouchSlop = true;
        this.mDeferScrollUpdate = false;
        this.mDeferLoadAssociatedPagesUntilScrollCompletes = false;
        this.mIsPageMoving = false;
        this.mIsDataReady = false;
        this.mAllowLongPress = true;
        this.mAllowPagedViewAnimations = true;
        this.mViewport = new Rect();
        this.REORDERING_DROP_REPOSITION_DURATION = 200;
        this.REORDERING_REORDER_REPOSITION_DURATION = 300;
        this.REORDERING_ZOOM_IN_OUT_DURATION = 250;
        this.REORDERING_SIDE_PAGE_HOVER_TIMEOUT = 80;
        this.mMinScale = 1.0f;
        this.mUseMinScale = false;
        this.mSidePageHoverIndex = -1;
        this.mReorderingStarted = false;
        this.NUM_ANIMATIONS_RUNNING_BEFORE_ZOOM_OUT = 2;
        this.mTmpInvMatrix = new Matrix();
        this.mTmpPoint = new float[2];
        this.mTmpIntPoint = new int[2];
        this.mTmpRect = new Rect();
        this.mAltTmpRect = new Rect();
        this.FLING_TO_DELETE_FADE_OUT_DURATION = FinalCanbus.CAR_HAOZHENG_XP1_BmwSeries;
        this.FLING_TO_DELETE_FRICTION = 0.035f;
        this.FLING_TO_DELETE_MAX_FLING_DEGREES = 65.0f;
        this.mFlingToDeleteThresholdVelocity = -1400;
        this.mDeferringForDelete = false;
        this.DELETE_SLIDE_IN_SIDE_PAGE_DURATION = 250;
        this.DRAG_TO_DELETE_FADE_OUT_DURATION = FinalCanbus.CAR_HAOZHENG_XP1_BmwSeries;
        this.mAutoComputePageSpacing = false;
        this.mRecomputePageSpacing = false;
        this.mTopAlignPageWhenShrinkingForBouncer = false;
        this.mInsets = new Rect();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PagedView, defStyle, 0);
        setPageSpacing(a.getDimensionPixelSize(R.styleable.PagedView_pageSpacing, 0));
        if (this.mPageSpacing < 0) {
            this.mRecomputePageSpacing = true;
            this.mAutoComputePageSpacing = true;
        }
        mPageLayoutPaddingTop = a.getDimensionPixelSize(R.styleable.PagedView_pageLayoutPaddingTop, 0);
        mPageLayoutPaddingBottom = a.getDimensionPixelSize(R.styleable.PagedView_pageLayoutPaddingBottom, 0);
        mPageLayoutPaddingLeft = a.getDimensionPixelSize(R.styleable.PagedView_pageLayoutPaddingLeft, 0);
        mPageLayoutPaddingRight = a.getDimensionPixelSize(R.styleable.PagedView_pageLayoutPaddingRight, 0);
        mPageLayoutWidthGap = a.getDimensionPixelSize(R.styleable.PagedView_pageLayoutWidthGap, 0);
        mPageLayoutHeightGap = a.getDimensionPixelSize(R.styleable.PagedView_pageLayoutHeightGap, 0);
        mPageIndicatorViewId = a.getResourceId(R.styleable.PagedView_pageIndicator, -1);
        a.recycle();
        setHapticFeedbackEnabled(false);
        init();
    }

    protected void init() {
        this.mDirtyPageContent = new ArrayList<>();
        this.mDirtyPageContent.ensureCapacity(32);
        this.mScroller = new Scroller(getContext(), new ScrollInterpolator());
        this.mCurrentPage = 0;
        this.mCenterPagesVertically = true;
        ViewConfiguration configuration = ViewConfiguration.get(getContext());
        this.mTouchSlop = configuration.getScaledPagingTouchSlop();
        this.mPagingTouchSlop = configuration.getScaledPagingTouchSlop();
        this.mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
        this.mDensity = getResources().getDisplayMetrics().density;
        this.mFlingToDeleteThresholdVelocity = (int) (this.mFlingToDeleteThresholdVelocity * this.mDensity);
        this.mFlingThresholdVelocity = (int) (500.0f * this.mDensity);
        this.mMinFlingVelocity = (int) (250.0f * this.mDensity);
        this.mMinSnapVelocity = (int) (1500.0f * this.mDensity);
        setOnHierarchyChangeListener(this);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewGroup parent = (ViewGroup) getParent();
        if (this.mPageIndicator == null && this.mPageIndicatorViewId > -1) {
            this.mPageIndicator = (PageIndicator) parent.findViewById(this.mPageIndicatorViewId);
            this.mPageIndicator.removeAllMarkers(this.mAllowPagedViewAnimations);
            ArrayList<PageIndicator.PageMarkerResources> markers = new ArrayList<>();
            for (int i = 0; i < getChildCount(); i++) {
                markers.add(getPageIndicatorMarker(i));
            }
            this.mPageIndicator.addMarkers(markers, this.mAllowPagedViewAnimations);
            View.OnClickListener listener = getPageIndicatorClickListener();
            if (listener != null) {
                this.mPageIndicator.setOnClickListener(listener);
            }
            this.mPageIndicator.setContentDescription(getPageIndicatorDescription());
        }
    }

    protected String getPageIndicatorDescription() {
        return getCurrentPageDescription();
    }

    protected View.OnClickListener getPageIndicatorClickListener() {
        return null;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mPageIndicator = null;
    }

    void setDeleteDropTarget(View v) {
        this.mDeleteDropTarget = v;
    }

    float[] mapPointFromViewToParent(View v, float x, float y) {
        this.mTmpPoint[0] = x;
        this.mTmpPoint[1] = y;
        v.getMatrix().mapPoints(this.mTmpPoint);
        float[] fArr = this.mTmpPoint;
        fArr[0] = fArr[0] + v.getLeft();
        float[] fArr2 = this.mTmpPoint;
        fArr2[1] = fArr2[1] + v.getTop();
        return this.mTmpPoint;
    }

    float[] mapPointFromParentToView(View v, float x, float y) {
        this.mTmpPoint[0] = x - v.getLeft();
        this.mTmpPoint[1] = y - v.getTop();
        v.getMatrix().invert(this.mTmpInvMatrix);
        this.mTmpInvMatrix.mapPoints(this.mTmpPoint);
        return this.mTmpPoint;
    }

    void updateDragViewTranslationDuringDrag() {
        if (this.mDragView != null) {
            float x = (this.mLastMotionX - this.mDownMotionX) + (getScrollX() - this.mDownScrollX) + (this.mDragViewBaselineLeft - this.mDragView.getLeft());
            float y = this.mLastMotionY - this.mDownMotionY;
            this.mDragView.setTranslationX(x);
            this.mDragView.setTranslationY(y);
        }
    }

    public void setMinScale(float f) {
        this.mMinScale = f;
        this.mUseMinScale = true;
        requestLayout();
    }

    @Override
    public void setScaleX(float scaleX) {
        super.setScaleX(scaleX);
        if (isReordering(true)) {
            float[] p = mapPointFromParentToView(this, this.mParentDownMotionX, this.mParentDownMotionY);
            this.mLastMotionX = p[0];
            this.mLastMotionY = p[1];
            updateDragViewTranslationDuringDrag();
        }
    }

    int getViewportWidth() {
        return this.mViewport.width();
    }

    int getViewportHeight() {
        return this.mViewport.height();
    }

    int getViewportOffsetX() {
        return (getMeasuredWidth() - getViewportWidth()) / 2;
    }

    int getViewportOffsetY() {
        return (getMeasuredHeight() - getViewportHeight()) / 2;
    }

    PageIndicator getPageIndicator() {
        return this.mPageIndicator;
    }

    protected PageIndicator.PageMarkerResources getPageIndicatorMarker(int pageIndex) {
        return new PageIndicator.PageMarkerResources();
    }

    public void setPageSwitchListener(PageSwitchListener pageSwitchListener) {
        this.mPageSwitchListener = pageSwitchListener;
        if (this.mPageSwitchListener != null) {
            this.mPageSwitchListener.onPageSwitch(getPageAt(this.mCurrentPage), this.mCurrentPage);
        }
    }

    public boolean isLayoutRtl() {
        return getLayoutDirection() == View.LAYOUT_DIRECTION_RTL;
    }

    protected void setDataIsReady() {
        this.mIsDataReady = true;
    }

    protected boolean isDataReady() {
        return this.mIsDataReady;
    }

    int getCurrentPage() {
        return this.mCurrentPage;
    }

    int getNextPage() {
        return this.mNextPage != -1 ? this.mNextPage : this.mCurrentPage;
    }

    int getPageCount() {
        return getChildCount();
    }

    View getPageAt(int index) {
        return getChildAt(index);
    }

    protected int indexToPage(int index) {
        return index;
    }

    protected void updateCurrentPageScroll() {
        int newX = 0;
        if (this.mCurrentPage >= 0 && this.mCurrentPage < getPageCount()) {
            newX = getScrollForPage(this.mCurrentPage);
        }
        scrollTo(newX, 0);
        this.mScroller.setFinalX(newX);
        this.mScroller.forceFinished(true);
    }

    void pauseScrolling() {
        this.mScroller.forceFinished(true);
    }

    void resumeScrolling() {
    }

    void setCurrentPage(int currentPage) {
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
            this.mNextPage = -1;
        }
        if (getChildCount() != 0) {
            this.mForceScreenScrolled = true;
            this.mCurrentPage = Math.max(0, Math.min(currentPage, getPageCount() - 1));
            updateCurrentPageScroll();
            notifyPageSwitchListener();
            invalidate();
        }
    }

    void setRestorePage(int restorePage) {
        this.mRestorePage = restorePage;
    }

    protected void notifyPageSwitchListener() {
        if (this.mPageSwitchListener != null) {
            this.mPageSwitchListener.onPageSwitch(getPageAt(this.mCurrentPage), this.mCurrentPage);
        }
        if (this.mPageIndicator != null && !isReordering(false)) {
            this.mPageIndicator.setActiveMarker(getNextPage());
        }
    }

    protected void pageBeginMoving() {
        if (!this.mIsPageMoving) {
            this.mIsPageMoving = true;
            onPageBeginMoving();
        }
    }

    protected void pageEndMoving() {
        if (this.mIsPageMoving) {
            this.mIsPageMoving = false;
            onPageEndMoving();
        }
    }

    protected boolean isPageMoving() {
        return this.mIsPageMoving;
    }

    protected void onPageBeginMoving() {
    }

    protected void onPageEndMoving() {
    }

    @Override
    public void setOnLongClickListener(View.OnLongClickListener l) {
        this.mLongClickListener = l;
        int count = getPageCount();
        for (int i = 0; i < count; i++) {
            getPageAt(i).setOnLongClickListener(l);
        }
        super.setOnLongClickListener(l);
    }

    @Override
    public void scrollBy(int x, int y) {
        scrollTo(this.mUnboundedScrollX + x, getScrollY() + y);
    }

    @Override
    public void scrollTo(int x, int y) {
        if (this.mFreeScroll) {
            x = Math.max(Math.min(x, this.mFreeScrollMaxScrollX), this.mFreeScrollMinScrollX);
        }
        boolean isRtl = isLayoutRtl();
        this.mUnboundedScrollX = x;
        boolean isXBeforeFirstPage = isRtl ? x > this.mMaxScrollX : x < 0;
        boolean isXAfterLastPage = isRtl ? x < 0 : x > this.mMaxScrollX;
        if (isXBeforeFirstPage) {
            super.scrollTo(0, y);
            if (this.mAllowOverScroll) {
                if (isRtl) {
                    overScroll(x - this.mMaxScrollX);
                } else {
                    overScroll(x);
                }
            }
        } else if (isXAfterLastPage) {
            super.scrollTo(this.mMaxScrollX, y);
            if (this.mAllowOverScroll) {
                if (isRtl) {
                    overScroll(x);
                } else {
                    overScroll(x - this.mMaxScrollX);
                }
            }
        } else {
            this.mOverScrollX = x;
            super.scrollTo(x, y);
        }
        this.mTouchX = x;
        this.mSmoothingTime = ((float) System.nanoTime()) / NANOTIME_DIV;
        if (isReordering(true)) {
            float[] p = mapPointFromParentToView(this, this.mParentDownMotionX, this.mParentDownMotionY);
            this.mLastMotionX = p[0];
            this.mLastMotionY = p[1];
            updateDragViewTranslationDuringDrag();
        }
    }

    private void sendScrollAccessibilityEvent() {
        int action;
        AccessibilityManager am = (AccessibilityManager) getContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (am.isEnabled()) {
            AccessibilityEvent ev;
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
                ev = AccessibilityEvent.obtain(CONTENT_CHANGE_TYPE_ENABLED);
            } else {
                ev = new AccessibilityEvent(CONTENT_CHANGE_TYPE_ENABLED);
            }
            ev.setItemCount(getChildCount());
            ev.setFromIndex(this.mCurrentPage);
            if (getNextPage() >= this.mCurrentPage) {
                action = 4096;
            } else {
                action = 8192;
            }
            ev.setAction(action);
            sendAccessibilityEventUnchecked(ev);
        }
    }

    protected boolean computeScrollHelper() {
        if (this.mScroller.computeScrollOffset()) {
            if (getScrollX() != this.mScroller.getCurrX() || getScrollY() != this.mScroller.getCurrY() || this.mOverScrollX != this.mScroller.getCurrX()) {
                float scaleX = this.mFreeScroll ? getScaleX() : 1.0f;
                int scrollX = (int) ((1.0f / scaleX) * this.mScroller.getCurrX());
                scrollTo(scrollX, this.mScroller.getCurrY());
            }
            invalidate();
            return true;
        }
        if (this.mNextPage == -1) {
            return false;
        }
        sendScrollAccessibilityEvent();
        this.mCurrentPage = Math.max(0, Math.min(this.mNextPage, getPageCount() - 1));
        this.mNextPage = -1;
        notifyPageSwitchListener();
        if (this.mDeferLoadAssociatedPagesUntilScrollCompletes) {
            loadAssociatedPages(this.mCurrentPage);
            this.mDeferLoadAssociatedPagesUntilScrollCompletes = false;
        }
        if (this.mTouchState == 0) {
            pageEndMoving();
        }
        onPostReorderingAnimationCompleted();
        AccessibilityManager am = (AccessibilityManager) getContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (am.isEnabled()) {
            announceForAccessibility(getCurrentPageDescription());
        }
        return true;
    }

    @Override
    public void computeScroll() {
        computeScrollHelper();
    }

    protected boolean shouldSetTopAlignedPivotForWidget(int childIndex) {
        return this.mTopAlignPageWhenShrinkingForBouncer;
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        public boolean isFullScreenPage;

        public LayoutParams(int width, int height) {
            super(width, height);
            this.isFullScreenPage = false;
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            this.isFullScreenPage = false;
        }
    }

    
    @Override
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public void addFullScreenPage(View page) {
        LayoutParams lp = generateDefaultLayoutParams();
        lp.isFullScreenPage = true;
        super.addView(page, 0, lp);
    }

    public int getNormalChildHeight() {
        return this.mNormalChildHeight;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int scaledWidthSize;
        int scaledHeightSize;
        int childWidthMode;
        int childHeightMode;
        int childWidth;
        int childHeight;
        if (!this.mIsDataReady || getChildCount() == 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int maxSize = Math.max(dm.widthPixels, dm.heightPixels + this.mInsets.top + this.mInsets.bottom);
        if (this.mUseMinScale) {
            int parentWidthSize = (int) (1.5f * maxSize);
            scaledWidthSize = (int) (parentWidthSize / this.mMinScale);
            scaledHeightSize = (int) (maxSize / this.mMinScale);
        } else {
            scaledWidthSize = widthSize;
            scaledHeightSize = heightSize;
        }
        this.mViewport.set(0, 0, widthSize, heightSize);
        if (widthMode == 0 || heightMode == 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        if (widthSize <= 0 || heightSize <= 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int verticalPadding = getPaddingTop() + getPaddingBottom();
        int horizontalPadding = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getPageAt(i);
            if (child.getVisibility() != View.GONE) {
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (!lp.isFullScreenPage) {
                    if (lp.width == -2) {
                        childWidthMode = Integer.MIN_VALUE;
                    } else {
                        childWidthMode = 1073741824;
                    }
                    if (lp.height == -2) {
                        childHeightMode = Integer.MIN_VALUE;
                    } else {
                        childHeightMode = 1073741824;
                    }
                    childWidth = widthSize - horizontalPadding;
                    childHeight = ((heightSize - verticalPadding) - this.mInsets.top) - this.mInsets.bottom;
                    this.mNormalChildHeight = childHeight;
                } else {
                    childWidthMode = 1073741824;
                    childHeightMode = 1073741824;
                    if (this.mUseMinScale) {
                        childWidth = getViewportWidth();
                        childHeight = getViewportHeight();
                    } else {
                        childWidth = (widthSize - getPaddingLeft()) - getPaddingRight();
                        childHeight = (heightSize - getPaddingTop()) - getPaddingBottom();
                    }
                }
                int childWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY);
                int childHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY);
                child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
            }
        }
        setMeasuredDimension(scaledWidthSize, scaledHeightSize);
        if (childCount > 0 && this.mAutoComputePageSpacing && this.mRecomputePageSpacing) {
            int offset = (getViewportWidth() - getChildWidth(0)) / 2;
            int spacing = Math.max(offset, (widthSize - offset) - getChildAt(0).getMeasuredWidth());
            setPageSpacing(spacing);
            this.mRecomputePageSpacing = false;
        }
    }

    public void setPageSpacing(int pageSpacing) {
        this.mPageSpacing = pageSpacing;
        requestLayout();
    }

    protected int getFirstChildLeft() {
        return this.mFirstChildLeft;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int childTop;
        if (this.mIsDataReady && getChildCount() != 0) {
            int childCount = getChildCount();
            int screenWidth = getViewportWidth();
            int offsetX = getViewportOffsetX();
            int offsetY = getViewportOffsetY();
            this.mViewport.offset(offsetX, offsetY);
            boolean isRtl = isLayoutRtl();
            int startIndex = isRtl ? childCount - 1 : 0;
            int endIndex = isRtl ? -1 : childCount;
            int delta = isRtl ? -1 : 1;
            int verticalPadding = getPaddingTop() + getPaddingBottom();
            int childLeft = offsetX + ((screenWidth - getChildWidth(startIndex)) / 2);
            this.mFirstChildLeft = childLeft;
            if (this.mPageScrolls == null || getChildCount() != this.mChildCountOnLastLayout) {
                this.mPageScrolls = new int[getChildCount()];
            }
            for (int i = startIndex; i != endIndex; i += delta) {
                View child = getPageAt(i);
                if (child.getVisibility() != View.GONE) {
                    LayoutParams lp = (LayoutParams) child.getLayoutParams();
                    if (lp.isFullScreenPage) {
                        childTop = offsetY;
                    } else {
                        childTop = getPaddingTop() + offsetY + this.mInsets.top;
                        if (this.mCenterPagesVertically) {
                            childTop += ((((getViewportHeight() - this.mInsets.top) - this.mInsets.bottom) - verticalPadding) - child.getMeasuredHeight()) / 2;
                        }
                    }
                    int childWidth = child.getMeasuredWidth();
                    int childHeight = child.getMeasuredHeight();
                    child.layout(childLeft, childTop, child.getMeasuredWidth() + childLeft, childTop + childHeight);
                    int scrollOffset = (getViewportWidth() - childWidth) / 2;
                    this.mPageScrolls[i] = (childLeft - scrollOffset) - offsetX;
                    if (i != endIndex - delta) {
                        int nextScrollOffset = (getViewportWidth() - getChildWidth(i + delta)) / 2;
                        childLeft = childLeft + childWidth + scrollOffset + nextScrollOffset;
                    }
                }
            }
            if (this.mFirstLayout && this.mCurrentPage >= 0 && this.mCurrentPage < getChildCount()) {
                setHorizontalScrollBarEnabled(false);
                updateCurrentPageScroll();
                setHorizontalScrollBarEnabled(true);
                this.mFirstLayout = false;
            }
            if (childCount > 0) {
                int index = isLayoutRtl() ? 0 : childCount - 1;
                this.mMaxScrollX = getScrollForPage(index);
            } else {
                this.mMaxScrollX = 0;
            }
            if (this.mScroller.isFinished() && this.mChildCountOnLastLayout != getChildCount() && !this.mDeferringForDelete) {
                if (this.mRestorePage != -1001) {
                    setCurrentPage(this.mRestorePage);
                    this.mRestorePage = INVALID_RESTORE_PAGE;
                } else {
                    setCurrentPage(getNextPage());
                }
            }
            this.mChildCountOnLastLayout = getChildCount();
            if (isReordering(true)) {
                updateDragViewTranslationDuringDrag();
            }
        }
    }

    protected void screenScrolled(int screenCenter) {
        boolean isInOverscroll = this.mOverScrollX < 0 || this.mOverScrollX > this.mMaxScrollX;
        if (this.mFadeInAdjacentScreens && !isInOverscroll) {
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                if (child != null) {
                    float scrollProgress = getScrollProgress(screenCenter, child, i);
                    float alpha = 1.0f - Math.abs(scrollProgress);
                    child.setAlpha(alpha);
                }
            }
            invalidate();
        }
    }

    protected void enablePagedViewAnimations() {
        this.mAllowPagedViewAnimations = true;
    }

    protected void disablePagedViewAnimations() {
        this.mAllowPagedViewAnimations = false;
    }

    @Override
    public void onChildViewAdded(View parent, View child) {
        if (this.mPageIndicator != null && !isReordering(false)) {
            int pageIndex = indexOfChild(child);
            this.mPageIndicator.addMarker(pageIndex, getPageIndicatorMarker(pageIndex), this.mAllowPagedViewAnimations);
        }
        this.mForceScreenScrolled = true;
        this.mRecomputePageSpacing = true;
        updateFreescrollBounds();
        invalidate();
    }

    @Override
    public void onChildViewRemoved(View parent, View child) {
        this.mForceScreenScrolled = true;
        updateFreescrollBounds();
        invalidate();
    }

    private void removeMarkerForView(int index) {
        if (this.mPageIndicator != null && !isReordering(false)) {
            this.mPageIndicator.removeMarker(index, this.mAllowPagedViewAnimations);
        }
    }

    @Override
    public void removeView(View v) {
        removeMarkerForView(indexOfChild(v));
        super.removeView(v);
    }

    @Override
    public void removeViewInLayout(View v) {
        removeMarkerForView(indexOfChild(v));
        super.removeViewInLayout(v);
    }

    @Override
    public void removeViewAt(int index) {
        removeViewAt(index);
        super.removeViewAt(index);
    }

    @Override
    public void removeAllViewsInLayout() {
        if (this.mPageIndicator != null) {
            this.mPageIndicator.removeAllMarkers(this.mAllowPagedViewAnimations);
        }
        super.removeAllViewsInLayout();
    }

    protected int getChildOffset(int index) {
        if (index < 0 || index > getChildCount() - 1) {
            return 0;
        }
        return getPageAt(index).getLeft() - getViewportOffsetX();
    }

    protected void getOverviewModePages(int[] range) {
        range[0] = 0;
        range[1] = Math.max(0, getChildCount() - 1);
    }

    protected void getVisiblePages(int[] range) {
        int pageCount = getChildCount();
        int[] iArr = this.mTmpIntPoint;
        this.mTmpIntPoint[1] = 0;
        iArr[0] = 0;
        range[0] = -1;
        range[1] = -1;
        if (pageCount > 0) {
            int viewportWidth = getViewportWidth();
            int curScreen = 0;
            int count = getChildCount();
            for (int i = 0; i < count; i++) {
                View currPage = getPageAt(i);
                this.mTmpIntPoint[0] = 0;
                Utilities.getDescendantCoordRelativeToParent(currPage, this, this.mTmpIntPoint, false);
                if (this.mTmpIntPoint[0] > viewportWidth) {
                    if (range[0] != -1) {
                        break;
                    }
                } else {
                    this.mTmpIntPoint[0] = currPage.getMeasuredWidth();
                    Utilities.getDescendantCoordRelativeToParent(currPage, this, this.mTmpIntPoint, false);
                    if (this.mTmpIntPoint[0] < 0) {
                        if (range[0] != -1) {
                            break;
                        }
                    } else {
                        curScreen = i;
                        if (range[0] < 0) {
                            range[0] = curScreen;
                        }
                    }
                }
            }
            range[1] = curScreen;
            return;
        }
        range[0] = -1;
        range[1] = -1;
    }

    protected boolean shouldDrawChild(View child) {
        return child.getAlpha() > 0.0f && child.getVisibility() == View.VISIBLE;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        int halfScreenSize = getViewportWidth() / 2;
        int screenCenter = this.mOverScrollX + halfScreenSize;
        if (screenCenter != this.mLastScreenCenter || this.mForceScreenScrolled) {
            this.mForceScreenScrolled = false;
            screenScrolled(screenCenter);
            this.mLastScreenCenter = screenCenter;
        }
        int pageCount = getChildCount();
        if (pageCount > 0) {
            getVisiblePages(this.mTempVisiblePagesRange);
            int leftScreen = this.mTempVisiblePagesRange[0];
            int rightScreen = this.mTempVisiblePagesRange[1];
            if (leftScreen != -1 && rightScreen != -1) {
                long drawingTime = getDrawingTime();
                canvas.save();
                canvas.clipRect(getScrollX(), getScrollY(), (getScrollX() + getRight()) - getLeft(), (getScrollY() + getBottom()) - getTop());
                for (int i = pageCount - 1; i >= 0; i--) {
                    View v = getPageAt(i);
                    if (v != this.mDragView && (this.mForceDrawAllChildrenNextFrame || (leftScreen <= i && i <= rightScreen && shouldDrawChild(v)))) {
                        drawChild(canvas, v, drawingTime);
                    }
                }
                if (this.mDragView != null) {
                    drawChild(canvas, this.mDragView, drawingTime);
                }
                this.mForceDrawAllChildrenNextFrame = false;
                canvas.restore();
            }
        }
    }

    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        int page = indexToPage(indexOfChild(child));
        if (page == this.mCurrentPage && this.mScroller.isFinished()) {
            return false;
        }
        snapToPage(page);
        return true;
    }

    @Override
    protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        int focusablePage;
        if (this.mNextPage != -1) {
            focusablePage = this.mNextPage;
        } else {
            focusablePage = this.mCurrentPage;
        }
        View v = getPageAt(focusablePage);
        if (v != null) {
            return v.requestFocus(direction, previouslyFocusedRect);
        }
        return false;
    }

    @Override
    public boolean dispatchUnhandledMove(View focused, int direction) {
        if (direction == 17) {
            if (getCurrentPage() > 0) {
                snapToPage(getCurrentPage() - 1);
                return true;
            }
        } else if (direction == 66 && getCurrentPage() < getPageCount() - 1) {
            snapToPage(getCurrentPage() + 1);
            return true;
        }
        return super.dispatchUnhandledMove(focused, direction);
    }

    @Override
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        if (this.mCurrentPage >= 0 && this.mCurrentPage < getPageCount()) {
            getPageAt(this.mCurrentPage).addFocusables(views, direction, focusableMode);
        }
        if (direction == 17) {
            if (this.mCurrentPage > 0) {
                getPageAt(this.mCurrentPage - 1).addFocusables(views, direction, focusableMode);
            }
        } else if (direction == 66 && this.mCurrentPage < getPageCount() - 1) {
            getPageAt(this.mCurrentPage + 1).addFocusables(views, direction, focusableMode);
        }
    }

    @Override
    public void focusableViewAvailable(View focused) {
        View current = getPageAt(this.mCurrentPage);
        for (View v = focused; v != current; v = (View) v.getParent()) {
            if (v != this) {
                ViewParent parent = v.getParent();
                if (!(parent instanceof View)) {
                    return;
                }
            } else {
                return;
            }
        }
        super.focusableViewAvailable(focused);
    }

    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        if (disallowIntercept) {
            View currentPage = getPageAt(this.mCurrentPage);
            currentPage.cancelLongPress();
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    protected boolean hitsPreviousPage(float x, float y) {
        int offset = (getViewportWidth() - getChildWidth(this.mCurrentPage)) / 2;
        return isLayoutRtl() ? x > ((float) (((getViewportOffsetX() + getViewportWidth()) - offset) + this.mPageSpacing)) : x < ((float) ((getViewportOffsetX() + offset) - this.mPageSpacing));
    }

    protected boolean hitsNextPage(float x, float y) {
        int offset = (getViewportWidth() - getChildWidth(this.mCurrentPage)) / 2;
        return isLayoutRtl() ? x < ((float) ((getViewportOffsetX() + offset) - this.mPageSpacing)) : x > ((float) (((getViewportOffsetX() + getViewportWidth()) - offset) + this.mPageSpacing));
    }

    private boolean isTouchPointInViewportWithBuffer(int x, int y) {
        this.mTmpRect.set(this.mViewport.left - (this.mViewport.width() / 2), this.mViewport.top, this.mViewport.right + (this.mViewport.width() / 2), this.mViewport.bottom);
        return this.mTmpRect.contains(x, y);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        acquireVelocityTrackerAndAddMovement(ev);
        if (getChildCount() <= 0) {
            return super.onInterceptTouchEvent(ev);
        }
        int action = ev.getAction();
        if (action == 2 && this.mTouchState == 1) {
            return true;
        }
        switch (action & 255) {
            case 0:
                float x = ev.getX();
                float y = ev.getY();
                this.mDownMotionX = x;
                this.mDownMotionY = y;
                this.mDownScrollX = getScrollX();
                this.mLastMotionX = x;
                this.mLastMotionY = y;
                float[] p = mapPointFromViewToParent(this, x, y);
                this.mParentDownMotionX = p[0];
                this.mParentDownMotionY = p[1];
                this.mLastMotionXRemainder = 0.0f;
                this.mTotalMotionX = 0.0f;
                this.mActivePointerId = ev.getPointerId(0);
                int xDist = Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX());
                boolean finishedScrolling = this.mScroller.isFinished() || xDist < this.mTouchSlop;
                if (finishedScrolling) {
                    this.mTouchState = 0;
                    this.mScroller.abortAnimation();
                    break;
                } else if (isTouchPointInViewportWithBuffer((int) this.mDownMotionX, (int) this.mDownMotionY)) {
                    this.mTouchState = 1;
                    break;
                } else {
                    this.mTouchState = 0;
                    break;
                }
            case 1:
            case 3:
                resetTouchState();
                break;
            case 2:
                if (this.mActivePointerId != -1) {
                    determineScrollingStart(ev);
                    break;
                }
                break;
            case 6:
                onSecondaryPointerUp(ev);
                releaseVelocityTracker();
                break;
        }
        return this.mTouchState != 0;
    }

    protected void determineScrollingStart(MotionEvent ev) {
        determineScrollingStart(ev, 1.0f);
    }

    protected void determineScrollingStart(MotionEvent ev, float touchSlopScale) {
        int pointerIndex = ev.findPointerIndex(this.mActivePointerId);
        if (pointerIndex != -1) {
            float x = ev.getX(pointerIndex);
            float y = ev.getY(pointerIndex);
            if (isTouchPointInViewportWithBuffer((int) x, (int) y)) {
                int xDiff = (int) Math.abs(x - this.mLastMotionX);
                int yDiff = (int) Math.abs(y - this.mLastMotionY);
                int touchSlop = Math.round(this.mTouchSlop * touchSlopScale);
                boolean xPaged = xDiff > this.mPagingTouchSlop;
                boolean xMoved = xDiff > touchSlop;
                boolean yMoved = yDiff > touchSlop;
                if (xMoved || xPaged || yMoved) {
                    if (this.mUsePagingTouchSlop) {
                        if (!xPaged) {
                            return;
                        }
                    } else if (!xMoved) {
                        return;
                    }
                    this.mTouchState = 1;
                    this.mTotalMotionX += Math.abs(this.mLastMotionX - x);
                    this.mLastMotionX = x;
                    this.mLastMotionXRemainder = 0.0f;
                    this.mTouchX = getViewportOffsetX() + getScrollX();
                    this.mSmoothingTime = ((float) System.nanoTime()) / NANOTIME_DIV;
                    pageBeginMoving();
                }
            }
        }
    }

    protected float getMaxScrollProgress() {
        return 1.0f;
    }

    protected void cancelCurrentPageLongPress() {
        View currentPage;
        if (this.mAllowLongPress && (currentPage = getPageAt(this.mCurrentPage)) != null) {
            currentPage.cancelLongPress();
        }
    }

    protected float getBoundedScrollProgress(int screenCenter, View v, int page) {
        int halfScreenSize = getViewportWidth() / 2;
        return getScrollProgress(Math.max(halfScreenSize, Math.min(getScrollX() + halfScreenSize, screenCenter)), v, page);
    }

    protected float getScrollProgress(int screenCenter, View v, int page) {
        int halfScreenSize = getViewportWidth() / 2;
        int totalDistance = v.getMeasuredWidth() + this.mPageSpacing;
        int delta = screenCenter - (getScrollForPage(page) + halfScreenSize);
        float scrollProgress = delta / (totalDistance * 1.0f);
        return Math.max(Math.min(scrollProgress, getMaxScrollProgress()), -getMaxScrollProgress());
    }

    public int getScrollForPage(int index) {
        if (this.mPageScrolls == null || index >= this.mPageScrolls.length || index < 0) {
            return 0;
        }
        return this.mPageScrolls[index];
    }

    public int getLayoutTransitionOffsetForPage(int index) {
        if (this.mPageScrolls == null || index >= this.mPageScrolls.length || index < 0) {
            return 0;
        }
        View child = getChildAt(index);
        int scrollOffset = (getViewportWidth() - child.getMeasuredWidth()) / 2;
        int baselineX = this.mPageScrolls[index] + scrollOffset + getViewportOffsetX();
        return (int) (child.getX() - baselineX);
    }

    private float overScrollInfluenceCurve(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2) + 1.0f;
    }

    protected void acceleratedOverScroll(float amount) {
        int screenSize = getViewportWidth();
        float f = OVERSCROLL_ACCELERATE_FACTOR * (amount / screenSize);
        if (f != 0.0f) {
            if (Math.abs(f) >= 1.0f) {
                f /= Math.abs(f);
            }
            int overScrollAmount = Math.round(screenSize * f);
            if (amount < 0.0f) {
                this.mOverScrollX = overScrollAmount;
                super.scrollTo(0, getScrollY());
            } else {
                this.mOverScrollX = this.mMaxScrollX + overScrollAmount;
                super.scrollTo(this.mMaxScrollX, getScrollY());
            }
            invalidate();
        }
    }

    protected void dampedOverScroll(float amount) {
        int screenSize = getViewportWidth();
        float f = amount / screenSize;
        if (f != 0.0f) {
            float f2 = (f / Math.abs(f)) * overScrollInfluenceCurve(Math.abs(f));
            if (Math.abs(f2) >= 1.0f) {
                f2 /= Math.abs(f2);
            }
            int overScrollAmount = Math.round(OVERSCROLL_DAMP_FACTOR * f2 * screenSize);
            if (amount < 0.0f) {
                this.mOverScrollX = overScrollAmount;
                super.scrollTo(0, getScrollY());
            } else {
                this.mOverScrollX = this.mMaxScrollX + overScrollAmount;
                super.scrollTo(this.mMaxScrollX, getScrollY());
            }
            invalidate();
        }
    }

    protected void overScroll(float amount) {
        dampedOverScroll(amount);
    }

    protected float maxOverScroll() {
        float f = (1.0f / Math.abs(1.0f)) * overScrollInfluenceCurve(Math.abs(1.0f));
        return OVERSCROLL_DAMP_FACTOR * f;
    }

    protected void enableFreeScroll() {
        setEnableFreeScroll(true, -1);
    }

    protected void disableFreeScroll(int snapPage) {
        setEnableFreeScroll(false, snapPage);
    }

    void updateFreescrollBounds() {
        getOverviewModePages(this.mTempVisiblePagesRange);
        if (isLayoutRtl()) {
            this.mFreeScrollMinScrollX = getScrollForPage(this.mTempVisiblePagesRange[1]);
            this.mFreeScrollMaxScrollX = getScrollForPage(this.mTempVisiblePagesRange[0]);
        } else {
            this.mFreeScrollMinScrollX = getScrollForPage(this.mTempVisiblePagesRange[0]);
            this.mFreeScrollMaxScrollX = getScrollForPage(this.mTempVisiblePagesRange[1]);
        }
    }

    private void setEnableFreeScroll(boolean freeScroll, int snapPage) {
        this.mFreeScroll = freeScroll;
        if (snapPage == -1) {
            snapPage = getPageNearestToCenterOfScreen();
        }
        if (!this.mFreeScroll) {
            snapToPage(snapPage);
        } else {
            updateFreescrollBounds();
            getOverviewModePages(this.mTempVisiblePagesRange);
            if (getCurrentPage() < this.mTempVisiblePagesRange[0]) {
                setCurrentPage(this.mTempVisiblePagesRange[0]);
            } else if (getCurrentPage() > this.mTempVisiblePagesRange[1]) {
                setCurrentPage(this.mTempVisiblePagesRange[1]);
            }
        }
        setEnableOverscroll(freeScroll ? false : true);
    }

    private void setEnableOverscroll(boolean enable) {
        this.mAllowOverScroll = enable;
    }

    int getNearestHoverOverPageIndex() {
        if (this.mDragView != null) {
            int dragX = (int) (this.mDragView.getLeft() + (this.mDragView.getMeasuredWidth() / 2) + this.mDragView.getTranslationX());
            getOverviewModePages(this.mTempVisiblePagesRange);
            int minDistance = Integer.MAX_VALUE;
            int minIndex = indexOfChild(this.mDragView);
            for (int i = this.mTempVisiblePagesRange[0]; i <= this.mTempVisiblePagesRange[1]; i++) {
                View page = getPageAt(i);
                int pageX = page.getLeft() + (page.getMeasuredWidth() / 2);
                int d = Math.abs(dragX - pageX);
                if (d < minDistance) {
                    minIndex = i;
                    minDistance = d;
                }
            }
            return minIndex;
        }
        return -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean isDeltaXLeft;
        boolean isVelocityXLeft;
        super.onTouchEvent(ev);
        if (getChildCount() <= 0) {
            return super.onTouchEvent(ev);
        }
        acquireVelocityTrackerAndAddMovement(ev);
        int action = ev.getAction();
        switch (action & 255) {
            case 0:
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                float x = ev.getX();
                this.mLastMotionX = x;
                this.mDownMotionX = x;
                float y = ev.getY();
                this.mLastMotionY = y;
                this.mDownMotionY = y;
                this.mDownScrollX = getScrollX();
                float[] p = mapPointFromViewToParent(this, this.mLastMotionX, this.mLastMotionY);
                this.mParentDownMotionX = p[0];
                this.mParentDownMotionY = p[1];
                this.mLastMotionXRemainder = 0.0f;
                this.mTotalMotionX = 0.0f;
                this.mActivePointerId = ev.getPointerId(0);
                if (this.mTouchState == 1) {
                    pageBeginMoving();
                }
                return true;
            case 1:
                if (this.mTouchState == 1) {
                    int activePointerId = this.mActivePointerId;
                    float x2 = ev.getX(ev.findPointerIndex(activePointerId));
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int velocityX = (int) velocityTracker.getXVelocity(activePointerId);
                    int deltaX = (int) (x2 - this.mDownMotionX);
                    int pageWidth = getPageAt(this.mCurrentPage).getMeasuredWidth();
                    boolean isSignificantMove = ((float) Math.abs(deltaX)) > ((float) pageWidth) * SIGNIFICANT_MOVE_THRESHOLD;
                    this.mTotalMotionX += Math.abs((this.mLastMotionX + this.mLastMotionXRemainder) - x2);
                    boolean isFling = this.mTotalMotionX > 25.0f && Math.abs(velocityX) > this.mFlingThresholdVelocity;
                    if (!this.mFreeScroll) {
                        boolean returnToOriginalPage = false;
                        if (Math.abs(deltaX) > pageWidth * RETURN_TO_ORIGINAL_PAGE_THRESHOLD && Math.signum(velocityX) != Math.signum(deltaX) && isFling) {
                            returnToOriginalPage = true;
                        }
                        boolean isRtl = isLayoutRtl();
                        if (isRtl) {
                            isDeltaXLeft = deltaX > 0;
                        } else {
                            isDeltaXLeft = deltaX < 0;
                        }
                        if (isRtl) {
                            isVelocityXLeft = velocityX > 0;
                        } else {
                            isVelocityXLeft = velocityX < 0;
                        }
                        if (((isSignificantMove && !isDeltaXLeft && !isFling) || (isFling && !isVelocityXLeft)) && this.mCurrentPage > 0) {
                            int finalPage = returnToOriginalPage ? this.mCurrentPage : this.mCurrentPage - 1;
                            snapToPageWithVelocity(finalPage, velocityX);
                        } else if (((isSignificantMove && isDeltaXLeft && !isFling) || (isFling && isVelocityXLeft)) && this.mCurrentPage < getChildCount() - 1) {
                            int finalPage2 = returnToOriginalPage ? this.mCurrentPage : this.mCurrentPage + 1;
                            snapToPageWithVelocity(finalPage2, velocityX);
                        } else {
                            snapToDestination();
                        }
                    } else if (this.mTouchState == 2) {
                        int nextPage = Math.max(0, this.mCurrentPage - 1);
                        if (nextPage != this.mCurrentPage) {
                            snapToPage(nextPage);
                        } else {
                            snapToDestination();
                        }
                    } else {
                        if (!this.mScroller.isFinished()) {
                            this.mScroller.abortAnimation();
                        }
                        float scaleX = getScaleX();
                        int vX = (int) ((-velocityX) * scaleX);
                        int initialScrollX = (int) (getScrollX() * scaleX);
                        this.mScroller.fling(initialScrollX, getScrollY(), vX, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
                        invalidate();
                    }
                } else if (this.mTouchState == 3) {
                    int nextPage2 = Math.min(getChildCount() - 1, this.mCurrentPage + 1);
                    if (nextPage2 != this.mCurrentPage) {
                        snapToPage(nextPage2);
                    } else {
                        snapToDestination();
                    }
                } else if (this.mTouchState == 4) {
                    this.mLastMotionX = ev.getX();
                    this.mLastMotionY = ev.getY();
                    float[] pt = mapPointFromViewToParent(this, this.mLastMotionX, this.mLastMotionY);
                    this.mParentDownMotionX = pt[0];
                    this.mParentDownMotionY = pt[1];
                    updateDragViewTranslationDuringDrag();
                    if (0 == 0 && isHoveringOverDeleteDropTarget((int) this.mParentDownMotionX, (int) this.mParentDownMotionY)) {
                        onDropToDelete();
                    }
                } else if (!this.mCancelTap) {
                    onUnhandledTap(ev);
                }
                removeCallbacks(this.mSidePageHoverRunnable);
                resetTouchState();
                return true;
            case 2:
                if (this.mTouchState == 1) {
                    int pointerIndex = ev.findPointerIndex(this.mActivePointerId);
                    if (pointerIndex == -1) {
                        return true;
                    }
                    float x3 = ev.getX(pointerIndex);
                    float deltaX2 = (this.mLastMotionX + this.mLastMotionXRemainder) - x3;
                    this.mTotalMotionX += Math.abs(deltaX2);
                    if (Math.abs(deltaX2) >= 1.0f) {
                        this.mTouchX += deltaX2;
                        this.mSmoothingTime = ((float) System.nanoTime()) / NANOTIME_DIV;
                        if (!this.mDeferScrollUpdate) {
                            scrollBy((int) deltaX2, 0);
                        } else {
                            invalidate();
                        }
                        this.mLastMotionX = x3;
                        this.mLastMotionXRemainder = deltaX2 - ((int) deltaX2);
                    } else {
                        awakenScrollBars();
                    }
                } else if (this.mTouchState == 4) {
                    this.mLastMotionX = ev.getX();
                    this.mLastMotionY = ev.getY();
                    float[] pt2 = mapPointFromViewToParent(this, this.mLastMotionX, this.mLastMotionY);
                    this.mParentDownMotionX = pt2[0];
                    this.mParentDownMotionY = pt2[1];
                    updateDragViewTranslationDuringDrag();
                    final int dragViewIndex = indexOfChild(this.mDragView);
                    boolean isHoveringOverDelete = isHoveringOverDeleteDropTarget((int) this.mParentDownMotionX, (int) this.mParentDownMotionY);
                    setPageHoveringOverDeleteDropTarget(dragViewIndex, isHoveringOverDelete);
                    final int pageUnderPointIndex = getNearestHoverOverPageIndex();
                    if (pageUnderPointIndex > -1 && pageUnderPointIndex != indexOfChild(this.mDragView) && !isHoveringOverDelete) {
                        this.mTempVisiblePagesRange[0] = 0;
                        this.mTempVisiblePagesRange[1] = getPageCount() - 1;
                        getOverviewModePages(this.mTempVisiblePagesRange);
                        if (this.mTempVisiblePagesRange[0] <= pageUnderPointIndex && pageUnderPointIndex <= this.mTempVisiblePagesRange[1] && pageUnderPointIndex != this.mSidePageHoverIndex && this.mScroller.isFinished()) {
                            this.mSidePageHoverIndex = pageUnderPointIndex;
                            this.mSidePageHoverRunnable = new Runnable() { 
                                @Override
                                public void run() {
                                    PagedView.this.snapToPage(pageUnderPointIndex);
                                    int shiftDelta = dragViewIndex < pageUnderPointIndex ? -1 : 1;
                                    int lowerIndex = dragViewIndex < pageUnderPointIndex ? dragViewIndex + 1 : pageUnderPointIndex;
                                    int upperIndex = dragViewIndex > pageUnderPointIndex ? dragViewIndex - 1 : pageUnderPointIndex;
                                    for (int i = lowerIndex; i <= upperIndex; i++) {
                                        View v = PagedView.this.getChildAt(i);
                                        int oldX = PagedView.this.getViewportOffsetX() + PagedView.this.getChildOffset(i);
                                        int newX = PagedView.this.getViewportOffsetX() + PagedView.this.getChildOffset(i + shiftDelta);
                                        AnimatorSet anim = (AnimatorSet) v.getTag(100);
                                        if (anim != null) {
                                            anim.cancel();
                                        }
                                        v.setTranslationX(oldX - newX);
                                        AnimatorSet anim2 = new AnimatorSet();
                                        anim2.setDuration(PagedView.this.REORDERING_REORDER_REPOSITION_DURATION);
                                        anim2.playTogether(ObjectAnimator.ofFloat(v, "translationX", 0.0f));
                                        anim2.start();
                                        v.setTag(anim2);
                                    }
                                    PagedView.this.removeView(PagedView.this.mDragView);
                                    PagedView.this.onRemoveView(PagedView.this.mDragView, false);
                                    PagedView.this.addView(PagedView.this.mDragView, pageUnderPointIndex);
                                    PagedView.this.onAddView(PagedView.this.mDragView, pageUnderPointIndex);
                                    PagedView.this.mSidePageHoverIndex = -1;
                                    PagedView.this.mPageIndicator.setActiveMarker(PagedView.this.getNextPage());
                                }
                            };
                            postDelayed(this.mSidePageHoverRunnable, this.REORDERING_SIDE_PAGE_HOVER_TIMEOUT);
                        }
                    } else {
                        removeCallbacks(this.mSidePageHoverRunnable);
                        this.mSidePageHoverIndex = -1;
                    }
                } else {
                    determineScrollingStart(ev);
                }
                return true;
            case 3:
                if (this.mTouchState == 1) {
                    snapToDestination();
                }
                resetTouchState();
                return true;
            case 4:
            case 5:
            default:
                return true;
            case 6:
                onSecondaryPointerUp(ev);
                releaseVelocityTracker();
                return true;
        }
    }

    public void onFlingToDelete(View v) {
    }

    public void onRemoveView(View v, boolean deletePermanently) {
    }

    public void onRemoveViewAnimationCompleted() {
    }

    public void onAddView(View v, int index) {
    }

    private void resetTouchState() {
        releaseVelocityTracker();
        endReordering();
        this.mCancelTap = false;
        this.mTouchState = 0;
        this.mActivePointerId = -1;
    }

    protected void onUnhandledTap(MotionEvent ev) {
        ((Launcher) getContext()).onClick(this);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        float vscroll;
        float hscroll;
        boolean isForwardScroll = false;
        if ((event.getSource() & 2) != 0) {
            switch (event.getAction()) {
                case 8:
                    if ((event.getMetaState() & 1) != 0) {
                        vscroll = 0.0f;
                        hscroll = event.getAxisValue(9);
                    } else {
                        vscroll = -event.getAxisValue(9);
                        hscroll = event.getAxisValue(10);
                    }
                    if (hscroll != 0.0f || vscroll != 0.0f) {
                        if (isLayoutRtl()) {
                            if (hscroll < 0.0f || vscroll < 0.0f) {
                                isForwardScroll = true;
                            }
                        } else if (hscroll > 0.0f || vscroll > 0.0f) {
                            isForwardScroll = true;
                        }
                        if (isForwardScroll) {
                            scrollRight();
                            return true;
                        }
                        scrollLeft();
                        return true;
                    }
                    break;
            }
        }
        return super.onGenericMotionEvent(event);
    }

    private void acquireVelocityTrackerAndAddMovement(MotionEvent ev) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(ev);
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void onSecondaryPointerUp(MotionEvent ev) {
        int pointerIndex = (ev.getAction() & ACTION_POINTER_INDEX_MASK) >> 8;
        int pointerId = ev.getPointerId(pointerIndex);
        if (pointerId == this.mActivePointerId) {
            int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            float x = ev.getX(newPointerIndex);
            this.mDownMotionX = x;
            this.mLastMotionX = x;
            this.mLastMotionY = ev.getY(newPointerIndex);
            this.mLastMotionXRemainder = 0.0f;
            this.mActivePointerId = ev.getPointerId(newPointerIndex);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    @Override
    public void requestChildFocus(View child, View focused) {
        super.requestChildFocus(child, focused);
        int page = indexToPage(indexOfChild(child));
        if (page >= 0 && page != getCurrentPage() && !isInTouchMode()) {
            snapToPage(page);
        }
    }

    protected int getChildWidth(int index) {
        return getPageAt(index).getMeasuredWidth();
    }

    int getPageNearestToPoint(float x) {
        int index = 0;
        for (int i = 0; i < getChildCount(); i++) {
            if (x < getChildAt(i).getRight() - getScrollX()) {
                return index;
            }
            index++;
        }
        return Math.min(index, getChildCount() - 1);
    }

    int getPageNearestToCenterOfScreen() {
        int minDistanceFromScreenCenter = Integer.MAX_VALUE;
        int minDistanceFromScreenCenterIndex = -1;
        int screenCenter = getViewportOffsetX() + getScrollX() + (getViewportWidth() / 2);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View layout = getPageAt(i);
            int childWidth = layout.getMeasuredWidth();
            int halfChildWidth = childWidth / 2;
            int childCenter = getViewportOffsetX() + getChildOffset(i) + halfChildWidth;
            int distanceFromScreenCenter = Math.abs(childCenter - screenCenter);
            if (distanceFromScreenCenter < minDistanceFromScreenCenter) {
                minDistanceFromScreenCenter = distanceFromScreenCenter;
                minDistanceFromScreenCenterIndex = i;
            }
        }
        return minDistanceFromScreenCenterIndex;
    }

    protected void snapToDestination() {
        snapToPage(getPageNearestToCenterOfScreen(), PAGE_SNAP_ANIMATION_DURATION);
    }

    private static class ScrollInterpolator implements Interpolator {
        @Override
        public float getInterpolation(float t) {
            float t2 = t - 1.0f;
            return (t2 * t2 * t2 * t2 * t2) + 1.0f;
        }
    }

    float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((float) ((f - 0.5f) * 0.4712389167638204d));
    }

    protected void snapToPageWithVelocity(int whichPage, int velocity) {
        int whichPage2 = Math.max(0, Math.min(whichPage, getChildCount() - 1));
        int halfScreenSize = getViewportWidth() / 2;
        int newX = getScrollForPage(whichPage2);
        int delta = newX - this.mUnboundedScrollX;
        if (Math.abs(velocity) < this.mMinFlingVelocity) {
            snapToPage(whichPage2, PAGE_SNAP_ANIMATION_DURATION);
            return;
        }
        float distanceRatio = Math.min(1.0f, (Math.abs(delta) * 1.0f) / (halfScreenSize * 2));
        float distance = halfScreenSize + (halfScreenSize * distanceInfluenceForSnapDuration(distanceRatio));
        int duration = Math.round(1000.0f * Math.abs(distance / Math.max(this.mMinSnapVelocity, Math.abs(velocity)))) * 4;
        snapToPage(whichPage2, delta, duration);
    }

    protected void snapToPage(int whichPage) {
        snapToPage(whichPage, PAGE_SNAP_ANIMATION_DURATION);
    }

    protected void snapToPageImmediately(int whichPage) {
        snapToPage(whichPage, PAGE_SNAP_ANIMATION_DURATION, true);
    }

    protected void snapToPage(int whichPage, int duration) {
        snapToPage(whichPage, duration, false);
    }

    protected void snapToPage(int whichPage, int duration, boolean immediate) {
        int whichPage2 = Math.max(0, Math.min(whichPage, getPageCount() - 1));
        int newX = getScrollForPage(whichPage2);
        int sX = this.mUnboundedScrollX;
        int delta = newX - sX;
        snapToPage(whichPage2, delta, duration, immediate);
    }

    protected void snapToPage(int whichPage, int delta, int duration) {
        snapToPage(whichPage, delta, duration, false);
    }

    protected void snapToPage(int whichPage, int delta, int duration, boolean immediate) {
        this.mNextPage = whichPage;
        View focusedChild = getFocusedChild();
        if (focusedChild != null && whichPage != this.mCurrentPage && focusedChild == getPageAt(this.mCurrentPage)) {
            focusedChild.clearFocus();
        }
        sendScrollAccessibilityEvent();
        pageBeginMoving();
        awakenScrollBars(duration);
        if (immediate) {
            duration = 0;
        } else if (duration == 0) {
            duration = Math.abs(delta);
        }
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        this.mScroller.startScroll(this.mUnboundedScrollX, 0, delta, 0, duration);
        notifyPageSwitchListener();
        if (immediate) {
            computeScroll();
        }
        this.mDeferLoadAssociatedPagesUntilScrollCompletes = true;
        this.mForceScreenScrolled = true;
        invalidate();
    }

    public void scrollLeft() {
        if (getNextPage() > 0) {
            snapToPage(getNextPage() - 1);
        }
    }

    public void scrollRight() {
        if (getNextPage() < getChildCount() - 1) {
            snapToPage(getNextPage() + 1);
        }
    }

    public int getPageForView(View v) {
        if (v != null) {
            ViewParent vp = v.getParent();
            int count = getChildCount();
            for (int i = 0; i < count; i++) {
                if (vp == getPageAt(i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean allowLongPress() {
        return this.mAllowLongPress;
    }

    @Override
    public boolean performLongClick() {
        this.mCancelTap = true;
        return super.performLongClick();
    }

    public void setAllowLongPress(boolean allowLongPress) {
        this.mAllowLongPress = allowLongPress;
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { 
            /* JADX WARN: Can't rename method to resolve collision */
            @Override
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        int currentPage;

        SavedState(Parcelable superState) {
            super(superState);
            this.currentPage = -1;
        }

        /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel in) {
            super(in);
            this.currentPage = -1;
            this.currentPage = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.currentPage);
        }
    }

    protected void loadAssociatedPages(int page) {
        loadAssociatedPages(page, false);
    }

    protected void loadAssociatedPages(int page, boolean immediateAndOnly) {
        int count;
        if (this.mContentIsRefreshable && page < (count = getChildCount())) {
            int lowerPageBound = getAssociatedLowerPageBound(page);
            int upperPageBound = getAssociatedUpperPageBound(page);
            for (int i = 0; i < count; i++) {
                Page layout = (Page) getPageAt(i);
                if (i < lowerPageBound || i > upperPageBound) {
                    if (layout.getPageChildCount() > 0) {
                        layout.removeAllViewsOnPage();
                    }
                    this.mDirtyPageContent.set(i, true);
                }
            }
            int i2 = 0;
            while (i2 < count) {
                if ((i2 == page || !immediateAndOnly) && lowerPageBound <= i2 && i2 <= upperPageBound && this.mDirtyPageContent.get(i2).booleanValue()) {
                    syncPageItems(i2, i2 == page && immediateAndOnly);
                    this.mDirtyPageContent.set(i2, false);
                }
                i2++;
            }
        }
    }

    protected int getAssociatedLowerPageBound(int page) {
        return Math.max(0, page - 1);
    }

    protected int getAssociatedUpperPageBound(int page) {
        int count = getChildCount();
        return Math.min(page + 1, count - 1);
    }

    protected void invalidatePageData() {
        invalidatePageData(-1, false);
    }

    protected void invalidatePageData(int currentPage) {
        invalidatePageData(currentPage, false);
    }

    protected void invalidatePageData(int currentPage, boolean immediateAndOnly) {
        if (this.mIsDataReady) {
            if (this.mContentIsRefreshable) {
                this.mScroller.forceFinished(true);
                this.mNextPage = -1;
                syncPages();
                measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), MeasureSpec.EXACTLY), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), MeasureSpec.EXACTLY));
                if (currentPage > -1) {
                    setCurrentPage(Math.min(getPageCount() - 1, currentPage));
                }
                int count = getChildCount();
                this.mDirtyPageContent.clear();
                for (int i = 0; i < count; i++) {
                    this.mDirtyPageContent.add(true);
                }
                loadAssociatedPages(this.mCurrentPage, immediateAndOnly);
                requestLayout();
            }
            if (isPageMoving()) {
                snapToDestination();
            }
        }
    }

    void animateDragViewToOriginalPosition() {
        if (this.mDragView != null) {
            AnimatorSet anim = new AnimatorSet();
            anim.setDuration(this.REORDERING_DROP_REPOSITION_DURATION);
            anim.playTogether(ObjectAnimator.ofFloat(this.mDragView, "translationX", 0.0f), ObjectAnimator.ofFloat(this.mDragView, "translationY", 0.0f), ObjectAnimator.ofFloat(this.mDragView, "scaleX", 1.0f), ObjectAnimator.ofFloat(this.mDragView, "scaleY", 1.0f));
            anim.addListener(new AnimatorListenerAdapter() { 
                @Override
                public void onAnimationEnd(Animator animation) {
                    PagedView.this.onPostReorderingAnimationCompleted();
                }
            });
            anim.start();
        }
    }

    protected void onStartReordering() {
        this.mTouchState = 4;
        this.mIsReordering = true;
        invalidate();
    }

    
    public void onPostReorderingAnimationCompleted() {
        this.mPostReorderingPreZoomInRemainingAnimationCount--;
        if (this.mPostReorderingPreZoomInRunnable != null && this.mPostReorderingPreZoomInRemainingAnimationCount == 0) {
            this.mPostReorderingPreZoomInRunnable.run();
            this.mPostReorderingPreZoomInRunnable = null;
        }
    }

    protected void onEndReordering() {
        this.mIsReordering = false;
    }

    public boolean startReordering(View v) {
        int dragViewIndex = indexOfChild(v);
        if (this.mTouchState != 0) {
            return false;
        }
        this.mTempVisiblePagesRange[0] = 0;
        this.mTempVisiblePagesRange[1] = getPageCount() - 1;
        getOverviewModePages(this.mTempVisiblePagesRange);
        this.mReorderingStarted = true;
        if (this.mTempVisiblePagesRange[0] > dragViewIndex || dragViewIndex > this.mTempVisiblePagesRange[1]) {
            return false;
        }
        this.mDragView = getChildAt(dragViewIndex);
        this.mDragView.animate().scaleX(1.15f).scaleY(1.15f).setDuration(100L).start();
        this.mDragViewBaselineLeft = this.mDragView.getLeft();
        disableFreeScroll(-1);
        onStartReordering();
        return true;
    }

    boolean isReordering(boolean testTouchState) {
        boolean state = this.mIsReordering;
        if (testTouchState) {
            return state & (this.mTouchState == 4);
        }
        return state;
    }

    void endReordering() {
        if (this.mReorderingStarted) {
            this.mReorderingStarted = false;
            final Runnable onCompleteRunnable = new Runnable() { 
                @Override
                public void run() {
                    PagedView.this.onEndReordering();
                }
            };
            if (!this.mDeferringForDelete) {
                this.mPostReorderingPreZoomInRunnable = new Runnable() { 
                    @Override
                    public void run() {
                        onCompleteRunnable.run();
                        PagedView.this.enableFreeScroll();
                    }
                };
                this.mPostReorderingPreZoomInRemainingAnimationCount = this.NUM_ANIMATIONS_RUNNING_BEFORE_ZOOM_OUT;
                snapToPage(indexOfChild(this.mDragView), 0);
                animateDragViewToOriginalPosition();
            }
        }
    }

    private PointF isFlingingToDelete() {
        ViewConfiguration config = ViewConfiguration.get(getContext());
        this.mVelocityTracker.computeCurrentVelocity(1000, config.getScaledMaximumFlingVelocity());
        if (this.mVelocityTracker.getYVelocity() < this.mFlingToDeleteThresholdVelocity) {
            PointF vel = new PointF(this.mVelocityTracker.getXVelocity(), this.mVelocityTracker.getYVelocity());
            PointF upVec = new PointF(0.0f, -1.0f);
            float theta = (float) Math.acos(((vel.x * upVec.x) + (vel.y * upVec.y)) / (vel.length() * upVec.length()));
            if (theta <= Math.toRadians(this.FLING_TO_DELETE_MAX_FLING_DEGREES)) {
                return vel;
            }
        }
        return null;
    }

    private static class FlingAlongVectorAnimatorUpdateListener implements ValueAnimator.AnimatorUpdateListener {
        private final TimeInterpolator mAlphaInterpolator = new DecelerateInterpolator(0.75f);
        private View mDragView;
        private float mFriction;
        private Rect mFrom;
        private long mPrevTime;
        private PointF mVelocity;

        public FlingAlongVectorAnimatorUpdateListener(View dragView, PointF vel, Rect from, long startTime, float friction) {
            this.mDragView = dragView;
            this.mVelocity = vel;
            this.mFrom = from;
            this.mPrevTime = startTime;
            this.mFriction = 1.0f - (this.mDragView.getResources().getDisplayMetrics().density * friction);
        }

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            float t = ((Float) animation.getAnimatedValue()).floatValue();
            long curTime = AnimationUtils.currentAnimationTimeMillis();

            mFrom.left += (mVelocity.x * (curTime - mPrevTime) / 1000f);
            mFrom.top += (mVelocity.y * (curTime - mPrevTime) / 1000f);

            mDragView.setTranslationX(mFrom.left);
            mDragView.setTranslationY(mFrom.top);
            mDragView.setAlpha(1f - mAlphaInterpolator.getInterpolation(t));

            mVelocity.x *= mFriction;
            mVelocity.y *= mFriction;
            mPrevTime = curTime;
        }
    };

    private Runnable createPostDeleteAnimationRunnable(final View dragView) {
        return new Runnable() { 
            @Override
            public void run() {
                int oldX;
                int newX;
                int dragViewIndex = PagedView.this.indexOfChild(dragView);
                PagedView.this.getOverviewModePages(PagedView.this.mTempVisiblePagesRange);
                boolean isLastWidgetPage = PagedView.this.mTempVisiblePagesRange[0] == PagedView.this.mTempVisiblePagesRange[1];
                boolean slideFromLeft = isLastWidgetPage || dragViewIndex > PagedView.this.mTempVisiblePagesRange[0];
                if (slideFromLeft) {
                    PagedView.this.snapToPageImmediately(dragViewIndex - 1);
                }
                int firstIndex = isLastWidgetPage ? 0 : PagedView.this.mTempVisiblePagesRange[0];
                int lastIndex = Math.min(PagedView.this.mTempVisiblePagesRange[1], PagedView.this.getPageCount() - 1);
                int lowerIndex = slideFromLeft ? firstIndex : dragViewIndex + 1;
                int upperIndex = slideFromLeft ? dragViewIndex - 1 : lastIndex;
                ArrayList<Animator> animations = new ArrayList<>();
                for (int i = lowerIndex; i <= upperIndex; i++) {
                    View v = PagedView.this.getChildAt(i);
                    if (slideFromLeft) {
                        if (i == 0) {
                            oldX = ((PagedView.this.getViewportOffsetX() + PagedView.this.getChildOffset(i)) - PagedView.this.getChildWidth(i)) - PagedView.this.mPageSpacing;
                        } else {
                            oldX = PagedView.this.getViewportOffsetX() + PagedView.this.getChildOffset(i - 1);
                        }
                        newX = PagedView.this.getViewportOffsetX() + PagedView.this.getChildOffset(i);
                    } else {
                        oldX = PagedView.this.getChildOffset(i) - PagedView.this.getChildOffset(i - 1);
                        newX = 0;
                    }
                    AnimatorSet anim = (AnimatorSet) v.getTag();
                    if (anim != null) {
                        anim.cancel();
                    }
                    v.setAlpha(Math.max(v.getAlpha(), 0.01f));
                    v.setTranslationX(oldX - newX);
                    AnimatorSet anim2 = new AnimatorSet();
                    anim2.playTogether(ObjectAnimator.ofFloat(v, "translationX", 0.0f), ObjectAnimator.ofFloat(v, "alpha", 1.0f));
                    animations.add(anim2);
                    v.setTag(100, anim2);
                }
                AnimatorSet slideAnimations = new AnimatorSet();
                slideAnimations.playTogether(animations);
                slideAnimations.setDuration(PagedView.this.DELETE_SLIDE_IN_SIDE_PAGE_DURATION);
                slideAnimations.addListener(new AnimatorListenerAdapter() { 
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        PagedView.this.mDeferringForDelete = false;
                        PagedView.this.onEndReordering();
                        PagedView.this.onRemoveViewAnimationCompleted();
                    }
                });
                slideAnimations.start();
                PagedView.this.removeView(dragView);
                PagedView.this.onRemoveView(dragView, true);
            }
        };
    }

    public void onFlingToDelete(PointF vel) {
        long startTime = AnimationUtils.currentAnimationTimeMillis();
        TimeInterpolator tInterpolator = new TimeInterpolator() { 
            private int mCount = -1;
            private float mOffset;
            private long mStartTime;

            {
                this.mStartTime = startTime;
            }

            @Override
            public float getInterpolation(float t) {
                if (this.mCount < 0) {
                    this.mCount++;
                } else if (this.mCount == 0) {
                    this.mOffset = Math.min(0.5f, ((float) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime)) / PagedView.this.FLING_TO_DELETE_FADE_OUT_DURATION);
                    this.mCount++;
                }
                return Math.min(1.0f, this.mOffset + t);
            }
        };
        Rect from = new Rect();
        View dragView = this.mDragView;
        from.left = (int) dragView.getTranslationX();
        from.top = (int) dragView.getTranslationY();
        ValueAnimator.AnimatorUpdateListener updateCb = new FlingAlongVectorAnimatorUpdateListener(dragView, vel, from, startTime, this.FLING_TO_DELETE_FRICTION);
        final Runnable onAnimationEndRunnable = createPostDeleteAnimationRunnable(dragView);
        ValueAnimator mDropAnim = new ValueAnimator();
        mDropAnim.setInterpolator(tInterpolator);
        mDropAnim.setDuration(this.FLING_TO_DELETE_FADE_OUT_DURATION);
        mDropAnim.setFloatValues(0.0f, 1.0f);
        mDropAnim.addUpdateListener(updateCb);
        mDropAnim.addListener(new AnimatorListenerAdapter() { 
            @Override
            public void onAnimationEnd(Animator animation) {
                onAnimationEndRunnable.run();
            }
        });
        mDropAnim.start();
        this.mDeferringForDelete = true;
    }

    private boolean isHoveringOverDeleteDropTarget(int x, int y) {
        if (this.mDeleteDropTarget == null) {
            return false;
        }
        this.mAltTmpRect.set(0, 0, 0, 0);
        View parent = (View) this.mDeleteDropTarget.getParent();
        if (parent != null) {
            parent.getGlobalVisibleRect(this.mAltTmpRect);
        }
        this.mDeleteDropTarget.getGlobalVisibleRect(this.mTmpRect);
        this.mTmpRect.offset(-this.mAltTmpRect.left, -this.mAltTmpRect.top);
        return this.mTmpRect.contains(x, y);
    }

    protected void setPageHoveringOverDeleteDropTarget(int viewIndex, boolean isHovering) {
    }

    private void onDropToDelete() {
        View dragView = this.mDragView;
        ArrayList<Animator> animations = new ArrayList<>();
        AnimatorSet motionAnim = new AnimatorSet();
        motionAnim.setInterpolator(new DecelerateInterpolator(OVERSCROLL_ACCELERATE_FACTOR));
        motionAnim.playTogether(ObjectAnimator.ofFloat(dragView, "scaleX", 0.0f), ObjectAnimator.ofFloat(dragView, "scaleY", 0.0f));
        animations.add(motionAnim);
        AnimatorSet alphaAnim = new AnimatorSet();
        alphaAnim.setInterpolator(new LinearInterpolator());
        alphaAnim.playTogether(ObjectAnimator.ofFloat(dragView, "alpha", 0.0f));
        animations.add(alphaAnim);
        final Runnable onAnimationEndRunnable = createPostDeleteAnimationRunnable(dragView);
        AnimatorSet anim = new AnimatorSet();
        anim.playTogether(animations);
        anim.setDuration(this.DRAG_TO_DELETE_FADE_OUT_DURATION);
        anim.addListener(new AnimatorListenerAdapter() { 
            @Override
            public void onAnimationEnd(Animator animation) {
                onAnimationEndRunnable.run();
            }
        });
        anim.start();
        this.mDeferringForDelete = true;
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setScrollable(getPageCount() > 1);
        if (getCurrentPage() < getPageCount() - 1) {
            info.addAction(ACTION_SCROLL_FORWARD);
        }
        if (getCurrentPage() > 0) {
            info.addAction(ACTION_SCROLL_BACKWARD);
        }
    }

    @Override
    public void sendAccessibilityEvent(int eventType) {
        if (eventType != 4096) {
            super.sendAccessibilityEvent(eventType);
        }
    }

    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setScrollable(true);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean performAccessibilityAction(int action, Bundle arguments) {
        if (super.performAccessibilityAction(action, arguments)) {
            return true;
        }
        switch (action) {
            case 4096:
                if (getCurrentPage() < getPageCount() - 1) {
                    scrollRight();
                    return true;
                }
                return false;
            case 8192:
                if (getCurrentPage() > 0) {
                    scrollLeft();
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    protected String getCurrentPageDescription() {
        return String.format(getContext().getString(R.string.default_scroll_format), Integer.valueOf(getNextPage() + 1), Integer.valueOf(getChildCount()));
    }

    @Override
    public boolean onHoverEvent(MotionEvent event) {
        return true;
    }
}
