package android.support.v4.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class SwipeRefreshLayout extends ViewGroup {
    private static final float ACCELERATE_INTERPOLATION_FACTOR = 1.5f;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    private static final int INVALID_POINTER = -1;
    private static final float MAX_SWIPE_DISTANCE_FACTOR = 0.6f;
    private static final float PROGRESS_BAR_HEIGHT = 4.0f;
    private static final int REFRESH_TRIGGER_DISTANCE = 120;
    private static final long RETURN_TO_ORIGINAL_POSITION_TIMEOUT = 300;
    private final AccelerateInterpolator mAccelerateInterpolator;
    private int mActivePointerId;
    private final Animation mAnimateToStartPosition;
    private final Runnable mCancel;
    private float mCurrPercentage;
    private int mCurrentTargetOffsetTop;
    private final DecelerateInterpolator mDecelerateInterpolator;
    private float mDistanceToTriggerSync;
    private int mFrom;
    private float mFromPercentage;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private float mLastMotionY;
    private OnRefreshListener mListener;
    private int mMediumAnimationDuration;
    private int mOriginalOffsetTop;
    private SwipeProgressBar mProgressBar;
    private int mProgressBarHeight;
    private boolean mRefreshing;
    private final Runnable mReturnToStartPosition;
    private final Animation.AnimationListener mReturnToStartPositionListener;
    private boolean mReturningToStart;
    private final Animation.AnimationListener mShrinkAnimationListener;
    private Animation mShrinkTrigger;
    private View mTarget;
    private int mTouchSlop;
    private static final String LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
    private static final int[] LAYOUT_ATTRS = {R.attr.enabled};

    public interface OnRefreshListener {
        void onRefresh();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mRefreshing = false;
        this.mDistanceToTriggerSync = -1.0f;
        this.mFromPercentage = 0.0f;
        this.mCurrPercentage = 0.0f;
        this.mActivePointerId = -1;
        this.mAnimateToStartPosition = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.1
            @Override // android.view.animation.Animation
            public void applyTransformation(float interpolatedTime, Transformation t) {
                int targetTop = 0;
                if (SwipeRefreshLayout.this.mFrom != SwipeRefreshLayout.this.mOriginalOffsetTop) {
                    targetTop = SwipeRefreshLayout.this.mFrom + ((int) ((SwipeRefreshLayout.this.mOriginalOffsetTop - SwipeRefreshLayout.this.mFrom) * interpolatedTime));
                }
                int offset = targetTop - SwipeRefreshLayout.this.mTarget.getTop();
                int currentTop = SwipeRefreshLayout.this.mTarget.getTop();
                if (offset + currentTop < 0) {
                    offset = 0 - currentTop;
                }
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(offset);
            }
        };
        this.mShrinkTrigger = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float interpolatedTime, Transformation t) {
                float percent = SwipeRefreshLayout.this.mFromPercentage + ((0.0f - SwipeRefreshLayout.this.mFromPercentage) * interpolatedTime);
                SwipeRefreshLayout.this.mProgressBar.setTriggerPercentage(percent);
            }
        };
        this.mReturnToStartPositionListener = new BaseAnimationListener() { // from class: android.support.v4.widget.SwipeRefreshLayout.3
            @Override // android.support.v4.widget.SwipeRefreshLayout.BaseAnimationListener, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SwipeRefreshLayout.this.mCurrentTargetOffsetTop = 0;
            }
        };
        this.mShrinkAnimationListener = new BaseAnimationListener() { // from class: android.support.v4.widget.SwipeRefreshLayout.4
            @Override // android.support.v4.widget.SwipeRefreshLayout.BaseAnimationListener, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SwipeRefreshLayout.this.mCurrPercentage = 0.0f;
            }
        };
        this.mReturnToStartPosition = new Runnable() { // from class: android.support.v4.widget.SwipeRefreshLayout.5
            @Override // java.lang.Runnable
            public void run() {
                SwipeRefreshLayout.this.mReturningToStart = true;
                SwipeRefreshLayout.this.animateOffsetToStartPosition(SwipeRefreshLayout.this.mCurrentTargetOffsetTop + SwipeRefreshLayout.this.getPaddingTop(), SwipeRefreshLayout.this.mReturnToStartPositionListener);
            }
        };
        this.mCancel = new Runnable() { // from class: android.support.v4.widget.SwipeRefreshLayout.6
            @Override // java.lang.Runnable
            public void run() {
                SwipeRefreshLayout.this.mReturningToStart = true;
                if (SwipeRefreshLayout.this.mProgressBar != null) {
                    SwipeRefreshLayout.this.mFromPercentage = SwipeRefreshLayout.this.mCurrPercentage;
                    SwipeRefreshLayout.this.mShrinkTrigger.setDuration(SwipeRefreshLayout.this.mMediumAnimationDuration);
                    SwipeRefreshLayout.this.mShrinkTrigger.setAnimationListener(SwipeRefreshLayout.this.mShrinkAnimationListener);
                    SwipeRefreshLayout.this.mShrinkTrigger.reset();
                    SwipeRefreshLayout.this.mShrinkTrigger.setInterpolator(SwipeRefreshLayout.this.mDecelerateInterpolator);
                    SwipeRefreshLayout.this.startAnimation(SwipeRefreshLayout.this.mShrinkTrigger);
                }
                SwipeRefreshLayout.this.animateOffsetToStartPosition(SwipeRefreshLayout.this.mCurrentTargetOffsetTop + SwipeRefreshLayout.this.getPaddingTop(), SwipeRefreshLayout.this.mReturnToStartPositionListener);
            }
        };
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.mProgressBar = new SwipeProgressBar(this);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        this.mProgressBarHeight = (int) (metrics.density * PROGRESS_BAR_HEIGHT);
        this.mDecelerateInterpolator = new DecelerateInterpolator(DECELERATE_INTERPOLATION_FACTOR);
        this.mAccelerateInterpolator = new AccelerateInterpolator(ACCELERATE_INTERPOLATION_FACTOR);
        TypedArray a = context.obtainStyledAttributes(attrs, LAYOUT_ATTRS);
        setEnabled(a.getBoolean(0, true));
        a.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.mCancel);
        removeCallbacks(this.mReturnToStartPosition);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mReturnToStartPosition);
        removeCallbacks(this.mCancel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateOffsetToStartPosition(int from, Animation.AnimationListener listener) {
        this.mFrom = from;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(this.mMediumAnimationDuration);
        this.mAnimateToStartPosition.setAnimationListener(listener);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        this.mTarget.startAnimation(this.mAnimateToStartPosition);
    }

    public void setOnRefreshListener(OnRefreshListener listener) {
        this.mListener = listener;
    }

    private void setTriggerPercentage(float percent) {
        if (percent == 0.0f) {
            this.mCurrPercentage = 0.0f;
        } else {
            this.mCurrPercentage = percent;
            this.mProgressBar.setTriggerPercentage(percent);
        }
    }

    public void setRefreshing(boolean refreshing) {
        if (this.mRefreshing != refreshing) {
            ensureTarget();
            this.mCurrPercentage = 0.0f;
            this.mRefreshing = refreshing;
            if (this.mRefreshing) {
                this.mProgressBar.start();
            } else {
                this.mProgressBar.stop();
            }
        }
    }

    @Deprecated
    public void setColorScheme(int colorRes1, int colorRes2, int colorRes3, int colorRes4) {
        setColorSchemeResources(colorRes1, colorRes2, colorRes3, colorRes4);
    }

    public void setColorSchemeResources(int colorRes1, int colorRes2, int colorRes3, int colorRes4) {
        Resources res = getResources();
        setColorSchemeColors(res.getColor(colorRes1), res.getColor(colorRes2), res.getColor(colorRes3), res.getColor(colorRes4));
    }

    public void setColorSchemeColors(int color1, int color2, int color3, int color4) {
        ensureTarget();
        this.mProgressBar.setColorScheme(color1, color2, color3, color4);
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            if (getChildCount() > 1 && !isInEditMode()) {
                throw new IllegalStateException("SwipeRefreshLayout can host only one direct child");
            }
            this.mTarget = getChildAt(0);
            this.mOriginalOffsetTop = this.mTarget.getTop() + getPaddingTop();
        }
        if (this.mDistanceToTriggerSync == -1.0f && getParent() != null && ((View) getParent()).getHeight() > 0) {
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            this.mDistanceToTriggerSync = (int) Math.min(((View) getParent()).getHeight() * MAX_SWIPE_DISTANCE_FACTOR, 120.0f * metrics.density);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.mProgressBar.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        this.mProgressBar.setBounds(0, 0, width, this.mProgressBarHeight);
        if (getChildCount() != 0) {
            View child = getChildAt(0);
            int childLeft = getPaddingLeft();
            int childTop = this.mCurrentTargetOffsetTop + getPaddingTop();
            int childWidth = (width - getPaddingLeft()) - getPaddingRight();
            int childHeight = (height - getPaddingTop()) - getPaddingBottom();
            child.layout(childLeft, childTop, childLeft + childWidth, childTop + childHeight);
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getChildCount() > 1 && !isInEditMode()) {
            throw new IllegalStateException("SwipeRefreshLayout can host only one direct child");
        }
        if (getChildCount() > 0) {
            getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        }
    }

    public boolean canChildScrollUp() {
        if (Build.VERSION.SDK_INT < 14) {
            if (!(this.mTarget instanceof AbsListView)) {
                return this.mTarget.getScrollY() > 0;
            }
            AbsListView absListView = (AbsListView) this.mTarget;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
        return ViewCompat.canScrollVertically(this.mTarget, -1);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        ensureTarget();
        int action = MotionEventCompat.getActionMasked(ev);
        if (this.mReturningToStart && action == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp()) {
            return false;
        }
        switch (action) {
            case 0:
                float y = ev.getY();
                this.mInitialMotionY = y;
                this.mLastMotionY = y;
                this.mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
                this.mIsBeingDragged = false;
                this.mCurrPercentage = 0.0f;
                break;
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mCurrPercentage = 0.0f;
                this.mActivePointerId = -1;
                break;
            case 2:
                if (this.mActivePointerId == -1) {
                    Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }
                int pointerIndex = MotionEventCompat.findPointerIndex(ev, this.mActivePointerId);
                if (pointerIndex < 0) {
                    Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y2 = MotionEventCompat.getY(ev, pointerIndex);
                float yDiff = y2 - this.mInitialMotionY;
                if (yDiff > this.mTouchSlop) {
                    this.mLastMotionY = y2;
                    this.mIsBeingDragged = true;
                }
                break;
                break;
            case 6:
                onSecondaryPointerUp(ev);
                break;
        }
        return this.mIsBeingDragged;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean b) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        int action = MotionEventCompat.getActionMasked(ev);
        if (this.mReturningToStart && action == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp()) {
            return false;
        }
        switch (action) {
            case 0:
                float y = ev.getY();
                this.mInitialMotionY = y;
                this.mLastMotionY = y;
                this.mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
                this.mIsBeingDragged = false;
                this.mCurrPercentage = 0.0f;
                break;
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mCurrPercentage = 0.0f;
                this.mActivePointerId = -1;
                return false;
            case 2:
                int pointerIndex = MotionEventCompat.findPointerIndex(ev, this.mActivePointerId);
                if (pointerIndex < 0) {
                    Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y2 = MotionEventCompat.getY(ev, pointerIndex);
                float yDiff = y2 - this.mInitialMotionY;
                if (!this.mIsBeingDragged && yDiff > this.mTouchSlop) {
                    this.mIsBeingDragged = true;
                }
                if (this.mIsBeingDragged) {
                    if (yDiff > this.mDistanceToTriggerSync) {
                        startRefresh();
                    } else {
                        setTriggerPercentage(this.mAccelerateInterpolator.getInterpolation(yDiff / this.mDistanceToTriggerSync));
                        updateContentOffsetTop((int) yDiff);
                        if (this.mLastMotionY > y2 && this.mTarget.getTop() == getPaddingTop()) {
                            removeCallbacks(this.mCancel);
                        } else {
                            updatePositionTimeout();
                        }
                    }
                    this.mLastMotionY = y2;
                }
                break;
                break;
            case 5:
                int index = MotionEventCompat.getActionIndex(ev);
                this.mLastMotionY = MotionEventCompat.getY(ev, index);
                this.mActivePointerId = MotionEventCompat.getPointerId(ev, index);
                break;
            case 6:
                onSecondaryPointerUp(ev);
                break;
        }
        return true;
    }

    private void startRefresh() {
        removeCallbacks(this.mCancel);
        this.mReturnToStartPosition.run();
        setRefreshing(true);
        this.mListener.onRefresh();
    }

    private void updateContentOffsetTop(int targetTop) {
        int currentTop = this.mTarget.getTop();
        if (targetTop > this.mDistanceToTriggerSync) {
            targetTop = (int) this.mDistanceToTriggerSync;
        } else if (targetTop < 0) {
            targetTop = 0;
        }
        setTargetOffsetTopAndBottom(targetTop - currentTop);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetOffsetTopAndBottom(int offset) {
        this.mTarget.offsetTopAndBottom(offset);
        this.mCurrentTargetOffsetTop = this.mTarget.getTop();
    }

    private void updatePositionTimeout() {
        removeCallbacks(this.mCancel);
        postDelayed(this.mCancel, RETURN_TO_ORIGINAL_POSITION_TIMEOUT);
    }

    private void onSecondaryPointerUp(MotionEvent ev) {
        int pointerIndex = MotionEventCompat.getActionIndex(ev);
        int pointerId = MotionEventCompat.getPointerId(ev, pointerIndex);
        if (pointerId == this.mActivePointerId) {
            int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            this.mLastMotionY = MotionEventCompat.getY(ev, newPointerIndex);
            this.mActivePointerId = MotionEventCompat.getPointerId(ev, newPointerIndex);
        }
    }

    private class BaseAnimationListener implements Animation.AnimationListener {
        private BaseAnimationListener() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
