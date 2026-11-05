package com.yanzhenjie.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.yanzhenjie.recyclerview.x.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SwipeMenuLayout extends FrameLayout implements Controller {
    public static final int DEFAULT_SCROLLER_DURATION = 200;
    private View mContentView;
    private int mContentViewId;
    private int mDownX;
    private int mDownY;
    private boolean mDragging;
    private int mLastX;
    private int mLastY;
    private int mLeftViewId;
    private float mOpenPercent;
    private int mRightViewId;
    private int mScaledMaximumFlingVelocity;
    private int mScaledMinimumFlingVelocity;
    private int mScaledTouchSlop;
    private OverScroller mScroller;
    private int mScrollerDuration;
    private Horizontal mSwipeCurrentHorizontal;
    private LeftHorizontal mSwipeLeftHorizontal;
    private RightHorizontal mSwipeRightHorizontal;
    private VelocityTracker mVelocityTracker;
    private boolean shouldResetSwipe;
    private boolean swipeEnable;

    public SwipeMenuLayout(Context context) {
        this(context, null);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLeftViewId = 0;
        this.mContentViewId = 0;
        this.mRightViewId = 0;
        this.mOpenPercent = 0.5f;
        this.mScrollerDuration = 200;
        this.swipeEnable = true;
        setClickable(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwipeMenuLayout);
        this.mLeftViewId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SwipeMenuLayout_leftViewId, this.mLeftViewId);
        this.mContentViewId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SwipeMenuLayout_contentViewId, this.mContentViewId);
        this.mRightViewId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SwipeMenuLayout_rightViewId, this.mRightViewId);
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mScaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mScaledMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new OverScroller(getContext());
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i = this.mLeftViewId;
        if (i != 0 && this.mSwipeLeftHorizontal == null) {
            this.mSwipeLeftHorizontal = new LeftHorizontal(findViewById(i));
        }
        int i2 = this.mRightViewId;
        if (i2 != 0 && this.mSwipeRightHorizontal == null) {
            this.mSwipeRightHorizontal = new RightHorizontal(findViewById(i2));
        }
        int i3 = this.mContentViewId;
        if (i3 != 0 && this.mContentView == null) {
            this.mContentView = findViewById(i3);
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setClickable(true);
        textView.setGravity(17);
        textView.setTextSize(16.0f);
        textView.setText("You may not have set the ContentView.");
        this.mContentView = textView;
        addView(textView);
    }

    public void setSwipeEnable(boolean z) {
        this.swipeEnable = z;
    }

    public boolean isSwipeEnable() {
        return this.swipeEnable;
    }

    public void setOpenPercent(float f) {
        this.mOpenPercent = f;
    }

    public float getOpenPercent() {
        return this.mOpenPercent;
    }

    public void setScrollerDuration(int i) {
        this.mScrollerDuration = i;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (!isSwipeEnable()) {
            return zOnInterceptTouchEvent;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            int x = (int) motionEvent.getX();
            this.mLastX = x;
            this.mDownX = x;
            this.mDownY = (int) motionEvent.getY();
            return false;
        }
        if (action == 1) {
            Horizontal horizontal = this.mSwipeCurrentHorizontal;
            boolean z = horizontal != null && horizontal.isClickOnContentView(getWidth(), motionEvent.getX());
            if (!isMenuOpen() || !z) {
                return false;
            }
            smoothCloseMenu();
            return true;
        }
        if (action == 2) {
            int x2 = (int) (motionEvent.getX() - this.mDownX);
            return Math.abs(x2) > this.mScaledTouchSlop && Math.abs(x2) > Math.abs((int) (motionEvent.getY() - ((float) this.mDownY)));
        }
        if (action != 3) {
            return zOnInterceptTouchEvent;
        }
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isSwipeEnable()) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastX = (int) motionEvent.getX();
            this.mLastY = (int) motionEvent.getY();
        } else if (action == 1) {
            int x = (int) (this.mDownX - motionEvent.getX());
            int y = (int) (this.mDownY - motionEvent.getY());
            this.mDragging = false;
            this.mVelocityTracker.computeCurrentVelocity(1000, this.mScaledMaximumFlingVelocity);
            int xVelocity = (int) this.mVelocityTracker.getXVelocity();
            int iAbs = Math.abs(xVelocity);
            if (iAbs > this.mScaledMinimumFlingVelocity) {
                if (this.mSwipeCurrentHorizontal != null) {
                    int swipeDuration = getSwipeDuration(motionEvent, iAbs);
                    if (this.mSwipeCurrentHorizontal instanceof RightHorizontal) {
                        if (xVelocity < 0) {
                            smoothOpenMenu(swipeDuration);
                        } else {
                            smoothCloseMenu(swipeDuration);
                        }
                    } else if (xVelocity > 0) {
                        smoothOpenMenu(swipeDuration);
                    } else {
                        smoothCloseMenu(swipeDuration);
                    }
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            } else {
                judgeOpenClose(x, y);
            }
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            if (Math.abs(this.mDownX - motionEvent.getX()) > this.mScaledTouchSlop || Math.abs(this.mDownY - motionEvent.getY()) > this.mScaledTouchSlop || isLeftMenuOpen() || isRightMenuOpen()) {
                motionEvent.setAction(3);
                super.onTouchEvent(motionEvent);
                return true;
            }
        } else if (action == 2) {
            int x2 = (int) (this.mLastX - motionEvent.getX());
            int y2 = (int) (this.mLastY - motionEvent.getY());
            if (!this.mDragging && Math.abs(x2) > this.mScaledTouchSlop && Math.abs(x2) > Math.abs(y2)) {
                this.mDragging = true;
            }
            if (this.mDragging) {
                if (this.mSwipeCurrentHorizontal == null || this.shouldResetSwipe) {
                    if (x2 < 0) {
                        LeftHorizontal leftHorizontal = this.mSwipeLeftHorizontal;
                        if (leftHorizontal != null) {
                            this.mSwipeCurrentHorizontal = leftHorizontal;
                        } else {
                            this.mSwipeCurrentHorizontal = this.mSwipeRightHorizontal;
                        }
                    } else {
                        RightHorizontal rightHorizontal = this.mSwipeRightHorizontal;
                        if (rightHorizontal != null) {
                            this.mSwipeCurrentHorizontal = rightHorizontal;
                        } else {
                            this.mSwipeCurrentHorizontal = this.mSwipeLeftHorizontal;
                        }
                    }
                }
                scrollBy(x2, 0);
                this.mLastX = (int) motionEvent.getX();
                this.mLastY = (int) motionEvent.getY();
                this.shouldResetSwipe = false;
            }
        } else if (action == 3) {
            this.mDragging = false;
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            } else {
                judgeOpenClose((int) (this.mDownX - motionEvent.getX()), (int) (this.mDownY - motionEvent.getY()));
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private int getSwipeDuration(MotionEvent motionEvent, int i) {
        int iAbs;
        int x = (int) (motionEvent.getX() - getScrollX());
        int menuWidth = this.mSwipeCurrentHorizontal.getMenuWidth();
        int i2 = menuWidth / 2;
        float f = menuWidth;
        float f2 = i2;
        float fDistanceInfluenceForSnapDuration = f2 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(x) * 1.0f) / f)) * f2);
        if (i > 0) {
            iAbs = Math.round(Math.abs(fDistanceInfluenceForSnapDuration / i) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(x) / f) + 1.0f) * 100.0f);
        }
        return Math.min(iAbs, this.mScrollerDuration);
    }

    float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((float) (((double) (f - 0.5f)) * 0.4712389167638204d));
    }

    private void judgeOpenClose(int i, int i2) {
        if (this.mSwipeCurrentHorizontal != null) {
            if (Math.abs(getScrollX()) >= this.mSwipeCurrentHorizontal.getMenuView().getWidth() * this.mOpenPercent) {
                if (Math.abs(i) > this.mScaledTouchSlop || Math.abs(i2) > this.mScaledTouchSlop) {
                    if (isMenuOpenNotEqual()) {
                        smoothCloseMenu();
                        return;
                    } else {
                        smoothOpenMenu();
                        return;
                    }
                }
                if (isMenuOpen()) {
                    smoothCloseMenu();
                    return;
                } else {
                    smoothOpenMenu();
                    return;
                }
            }
            smoothCloseMenu();
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        Horizontal horizontal = this.mSwipeCurrentHorizontal;
        if (horizontal == null) {
            super.scrollTo(i, i2);
            return;
        }
        Horizontal.Checker checkerCheckXY = horizontal.checkXY(i, i2);
        this.shouldResetSwipe = checkerCheckXY.shouldResetSwipe;
        if (checkerCheckXY.x != getScrollX()) {
            super.scrollTo(checkerCheckXY.x, checkerCheckXY.y);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        Horizontal horizontal;
        if (!this.mScroller.computeScrollOffset() || (horizontal = this.mSwipeCurrentHorizontal) == null) {
            return;
        }
        if (horizontal instanceof RightHorizontal) {
            scrollTo(Math.abs(this.mScroller.getCurrX()), 0);
            invalidate();
        } else {
            scrollTo(-Math.abs(this.mScroller.getCurrX()), 0);
            invalidate();
        }
    }

    public boolean hasLeftMenu() {
        LeftHorizontal leftHorizontal = this.mSwipeLeftHorizontal;
        return leftHorizontal != null && leftHorizontal.canSwipe();
    }

    public boolean hasRightMenu() {
        RightHorizontal rightHorizontal = this.mSwipeRightHorizontal;
        return rightHorizontal != null && rightHorizontal.canSwipe();
    }

    @Override // com.yanzhenjie.recyclerview.Controller
    public boolean isMenuOpen() {
        return isLeftMenuOpen() || isRightMenuOpen();
    }

    @Override // com.yanzhenjie.recyclerview.Controller
    public boolean isLeftMenuOpen() {
        LeftHorizontal leftHorizontal = this.mSwipeLeftHorizontal;
        return leftHorizontal != null && leftHorizontal.isMenuOpen(getScrollX());
    }

    @Override // com.yanzhenjie.recyclerview.Controller
    public boolean isRightMenuOpen() {
        RightHorizontal rightHorizontal = this.mSwipeRightHorizontal;
        return rightHorizontal != null && rightHorizontal.isMenuOpen(getScrollX());
    }

    @Override // com.yanzhenjie.recyclerview.Controller
    public boolean isCompleteOpen() {
        return isLeftCompleteOpen() || isRightMenuOpen();
    }

    @Override // com.yanzhenjie.recyclerview.Controller
    public boolean isLeftCompleteOpen() {
        LeftHorizontal leftHorizontal = this.mSwipeLeftHorizontal;
        return (leftHorizontal == null || leftHorizontal.isCompleteClose(getScrollX())) ? false : true;
    }

    @Override // com.yanzhenjie.recyclerview.Controller
    public boolean isRightCompleteOpen() {
        RightHorizontal rightHorizontal = this.mSwipeRightHorizontal;
        return (rightHorizontal == null || rightHorizontal.isCompleteClose(getScrollX())) ? false : true;
    }

    @Override // com.yanzhenjie.recyclerview.Controller
    public boolean isMenuOpenNotEqual() {
        return isLeftMenuOpenNotEqual() || isRightMenuOpenNotEqual();
    }

    @Override // com.yanzhenjie.recyclerview.Controller
    public boolean isLeftMenuOpenNotEqual() {
        LeftHorizontal leftHorizontal = this.mSwipeLeftHorizontal;
        return leftHorizontal != null && leftHorizontal.isMenuOpenNotEqual(getScrollX());
    }

    @Override // com.yanzhenjie.recyclerview.Controller
    public boolean isRightMenuOpenNotEqual() {
        RightHorizontal rightHorizontal = this.mSwipeRightHorizontal;
        return rightHorizontal != null && rightHorizontal.isMenuOpenNotEqual(getScrollX());
    }

    @Override // com.yanzhenjie.recyclerview.Controller
    public void smoothOpenMenu() {
        smoothOpenMenu(this.mScrollerDuration);
    }

    @Override // com.yanzhenjie.recyclerview.Controller
    public void smoothOpenLeftMenu() {
        smoothOpenLeftMenu(this.mScrollerDuration);
    }

    @Override // com.yanzhenjie.recyclerview.Controller
    public void smoothOpenRightMenu() {
        smoothOpenRightMenu(this.mScrollerDuration);
    }

    @Override // com.yanzhenjie.recyclerview.Controller
    public void smoothOpenLeftMenu(int i) {
        LeftHorizontal leftHorizontal = this.mSwipeLeftHorizontal;
        if (leftHorizontal != null) {
            this.mSwipeCurrentHorizontal = leftHorizontal;
            smoothOpenMenu(i);
        }
    }

    @Override // com.yanzhenjie.recyclerview.Controller
    public void smoothOpenRightMenu(int i) {
        RightHorizontal rightHorizontal = this.mSwipeRightHorizontal;
        if (rightHorizontal != null) {
            this.mSwipeCurrentHorizontal = rightHorizontal;
            smoothOpenMenu(i);
        }
    }

    private void smoothOpenMenu(int i) {
        Horizontal horizontal = this.mSwipeCurrentHorizontal;
        if (horizontal != null) {
            horizontal.autoOpenMenu(this.mScroller, getScrollX(), i);
            invalidate();
        }
    }

    @Override // com.yanzhenjie.recyclerview.Controller
    public void smoothCloseMenu() {
        smoothCloseMenu(this.mScrollerDuration);
    }

    @Override // com.yanzhenjie.recyclerview.Controller
    public void smoothCloseLeftMenu() {
        LeftHorizontal leftHorizontal = this.mSwipeLeftHorizontal;
        if (leftHorizontal != null) {
            this.mSwipeCurrentHorizontal = leftHorizontal;
            smoothCloseMenu();
        }
    }

    @Override // com.yanzhenjie.recyclerview.Controller
    public void smoothCloseRightMenu() {
        RightHorizontal rightHorizontal = this.mSwipeRightHorizontal;
        if (rightHorizontal != null) {
            this.mSwipeCurrentHorizontal = rightHorizontal;
            smoothCloseMenu();
        }
    }

    @Override // com.yanzhenjie.recyclerview.Controller
    public void smoothCloseMenu(int i) {
        Horizontal horizontal = this.mSwipeCurrentHorizontal;
        if (horizontal != null) {
            horizontal.autoCloseMenu(this.mScroller, getScrollX(), i);
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view = this.mContentView;
        if (view != null) {
            int measuredWidthAndState = view.getMeasuredWidthAndState();
            int measuredHeightAndState = this.mContentView.getMeasuredHeightAndState();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mContentView.getLayoutParams();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop() + layoutParams.topMargin;
            this.mContentView.layout(paddingLeft, paddingTop, measuredWidthAndState + paddingLeft, measuredHeightAndState + paddingTop);
        }
        LeftHorizontal leftHorizontal = this.mSwipeLeftHorizontal;
        if (leftHorizontal != null) {
            View menuView = leftHorizontal.getMenuView();
            int measuredWidthAndState2 = menuView.getMeasuredWidthAndState();
            int measuredHeightAndState2 = menuView.getMeasuredHeightAndState();
            int paddingTop2 = getPaddingTop() + ((FrameLayout.LayoutParams) menuView.getLayoutParams()).topMargin;
            menuView.layout(-measuredWidthAndState2, paddingTop2, 0, measuredHeightAndState2 + paddingTop2);
        }
        RightHorizontal rightHorizontal = this.mSwipeRightHorizontal;
        if (rightHorizontal != null) {
            View menuView2 = rightHorizontal.getMenuView();
            int measuredWidthAndState3 = menuView2.getMeasuredWidthAndState();
            int measuredHeightAndState3 = menuView2.getMeasuredHeightAndState();
            int paddingTop3 = getPaddingTop() + ((FrameLayout.LayoutParams) menuView2.getLayoutParams()).topMargin;
            int measuredWidthAndState4 = getMeasuredWidthAndState();
            menuView2.layout(measuredWidthAndState4, paddingTop3, measuredWidthAndState3 + measuredWidthAndState4, measuredHeightAndState3 + paddingTop3);
        }
    }
}
