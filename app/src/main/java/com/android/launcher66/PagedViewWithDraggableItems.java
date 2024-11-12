package com.android.launcher66;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public abstract class PagedViewWithDraggableItems extends PagedView implements View.OnLongClickListener, View.OnTouchListener {
    private float mDragSlopeThreshold;
    private boolean mIsDragEnabled;
    private boolean mIsDragging;
    private View mLastTouchedItem;
    private Launcher mLauncher;

    public PagedViewWithDraggableItems(Context context) {
        this(context, null);
    }

    public PagedViewWithDraggableItems(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PagedViewWithDraggableItems(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mLauncher = (Launcher) context;
    }

    protected boolean beginDragging(View v) {
        boolean wasDragging = this.mIsDragging;
        this.mIsDragging = true;
        return !wasDragging;
    }

    protected void cancelDragging() {
        this.mIsDragging = false;
        this.mLastTouchedItem = null;
        this.mIsDragEnabled = false;
    }

    private void handleTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action & 255) {
            case 0:
                cancelDragging();
                this.mIsDragEnabled = true;
                break;
            case 2:
                if (this.mTouchState != 1 && !this.mIsDragging && this.mIsDragEnabled) {
                    determineDraggingStart(ev);
                    break;
                }
                break;
        }
    }

    @Override // com.android.launcher66.PagedView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        handleTouchEvent(ev);
        return super.onInterceptTouchEvent(ev);
    }

    @Override // com.android.launcher66.PagedView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        handleTouchEvent(ev);
        return super.onTouchEvent(ev);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        this.mLastTouchedItem = v;
        this.mIsDragEnabled = true;
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v) {
        if (v.isInTouchMode() && this.mNextPage == -1 && this.mLauncher.isAllAppsVisible() && !this.mLauncher.getWorkspace().isSwitchingState() && this.mLauncher.isDraggingEnabled()) {
            return beginDragging(v);
        }
        return false;
    }

    @Override // com.android.launcher66.PagedView
    protected void determineScrollingStart(MotionEvent ev) {
        if (!this.mIsDragging) {
            super.determineScrollingStart(ev);
        }
    }

    protected void determineDraggingStart(MotionEvent ev) {
        int pointerIndex = ev.findPointerIndex(this.mActivePointerId);
        float x = ev.getX(pointerIndex);
        float y = ev.getY(pointerIndex);
        int xDiff = (int) Math.abs(x - this.mLastMotionX);
        int yDiff = (int) Math.abs(y - this.mLastMotionY);
        int touchSlop = this.mTouchSlop;
        boolean yMoved = yDiff > touchSlop;
        boolean isUpwardMotion = ((float) yDiff) / ((float) xDiff) > this.mDragSlopeThreshold;
        if (isUpwardMotion && yMoved && this.mLastTouchedItem != null) {
            beginDragging(this.mLastTouchedItem);
            if (this.mAllowLongPress) {
                this.mAllowLongPress = false;
                View currentPage = getPageAt(this.mCurrentPage);
                if (currentPage != null) {
                    currentPage.cancelLongPress();
                }
            }
        }
    }

    public void setDragSlopeThreshold(float dragSlopeThreshold) {
        this.mDragSlopeThreshold = dragSlopeThreshold;
    }

    @Override // com.android.launcher66.PagedView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        cancelDragging();
        super.onDetachedFromWindow();
    }
}
