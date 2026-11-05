package com.lsec.core.frame.ctrl;

import android.view.MotionEvent;
import android.view.View;
import com.lsec.core.ipc.module.main.Main;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class SwipeListViewHelper {
    JListViewEx listView;
    private View mCurrentItemView;
    private final int mDuration = 100;
    private final int mDurationStep = 10;
    private float mFirstX;
    private float mFirstY;
    private Boolean mIsHorizontal;
    private boolean mIsShown;
    private View mPreItemView;
    private int mRightViewWidth;
    RunnableMove runnableMove;

    public SwipeListViewHelper(JListViewEx listView, int rightViewWidth) {
        this.mRightViewWidth = 0;
        this.listView = listView;
        this.mRightViewWidth = rightViewWidth;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0011 A[ORIG_RETURN, RETURN] */
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        float lastX = ev.getX();
        float lastY = ev.getY();
        switch (ev.getAction()) {
            case 0:
                this.mIsHorizontal = null;
                this.mFirstX = lastX;
                this.mFirstY = lastY;
                int motionPosition = this.listView.pointToPosition((int) this.mFirstX, (int) this.mFirstY);
                if (motionPosition >= 0) {
                    View currentItemView = this.listView.getChildAt(motionPosition - this.listView.getFirstVisiblePosition());
                    this.mPreItemView = this.mCurrentItemView;
                    this.mCurrentItemView = currentItemView;
                }
                return false;
            case 1:
            case 3:
                if (this.mIsShown && (this.mPreItemView != this.mCurrentItemView || isHitCurItemLeft(lastX))) {
                    hiddenRight(this.mPreItemView);
                }
                return false;
            case 2:
                float dx = lastX - this.mFirstX;
                float dy = lastY - this.mFirstY;
                if (Math.abs(dx) >= 5.0f && Math.abs(dy) >= 5.0f) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        float lastX = ev.getX();
        float lastY = ev.getY();
        switch (ev.getAction()) {
            case 1:
            case 3:
                clearPressedState();
                if (this.mIsShown) {
                    hiddenRight(this.mPreItemView);
                }
                if (this.mIsHorizontal != null && this.mIsHorizontal.booleanValue()) {
                    if (this.mFirstX - lastX > this.mRightViewWidth / 2) {
                        showRight(this.mCurrentItemView);
                    } else {
                        hiddenRight(this.mCurrentItemView);
                    }
                    ev.setAction(3);
                    this.listView.superTouchEvent(ev);
                    return true;
                }
                break;
            case 2:
                float dx = lastX - this.mFirstX;
                float dy = lastY - this.mFirstY;
                if (this.mIsHorizontal != null || judgeScrollDirection(dx, dy)) {
                    if (this.mIsHorizontal.booleanValue()) {
                        if (this.mIsShown && this.mPreItemView != this.mCurrentItemView) {
                            hiddenRight(this.mPreItemView);
                        }
                        if (this.mIsShown && this.mPreItemView == this.mCurrentItemView) {
                            dx -= this.mRightViewWidth;
                        }
                        if (this.mCurrentItemView.getId() == this.listView.idPageRowGroup || dx >= 0.0f || dx <= (-this.mRightViewWidth)) {
                            return true;
                        }
                        this.mCurrentItemView.scrollTo((int) (-dx), 0);
                        return true;
                    }
                    if (this.mIsShown) {
                        hiddenRight(this.mPreItemView);
                    }
                }
                break;
        }
        return false;
    }

    private boolean isHitCurItemLeft(float x) {
        return x < ((float) (this.listView.getWidth() - this.mRightViewWidth));
    }

    public class RunnableMove implements Runnable {
        private boolean bRun = true;
        int fromX;
        int stepX;
        int toX;
        public View view;

        public RunnableMove(View view, int fromX, int toX) {
            this.stepX = 0;
            this.view = view;
            this.fromX = fromX;
            this.toX = toX;
            this.stepX = (int) ((((double) ((toX - fromX) * 10)) * 1.0d) / 100.0d);
        }

        public void stopRun(boolean bZeroScroll) {
            this.bRun = false;
            if (bZeroScroll) {
                this.view.setScrollX(0);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.view != null) {
                if (Math.abs(this.toX - this.fromX) < 10) {
                    this.view.scrollTo(this.toX, 0);
                    stopRun(false);
                }
                if (this.bRun && this.view != null) {
                    if (this.view.getScrollX() == this.toX) {
                        stopRun(false);
                        return;
                    }
                    this.fromX += this.stepX;
                    boolean isLastStep = (this.stepX > 0 && this.fromX > this.toX) || (this.stepX < 0 && this.fromX < this.toX);
                    if (isLastStep) {
                        this.fromX = this.toX;
                    }
                    this.view.scrollTo(this.fromX, 0);
                    SwipeListViewHelper.this.listView.invalidate();
                    if (!isLastStep) {
                        Main.postRunnable_Ui(true, this, 10L);
                    } else {
                        stopRun(false);
                    }
                }
            }
        }
    }

    private boolean judgeScrollDirection(float dx, float dy) {
        if (Math.abs(dx) > 30.0f && Math.abs(dx) > Math.abs(dy) * 2.0f) {
            this.mIsHorizontal = true;
            return true;
        }
        if (Math.abs(dy) > 30.0f && Math.abs(dy) > Math.abs(dx) * 2.0f) {
            this.mIsHorizontal = false;
            return true;
        }
        return false;
    }

    private void clearPressedState() {
        this.mCurrentItemView.setPressed(false);
        this.listView.setPressed(false);
        this.listView.refreshDrawableState();
    }

    private void hiddenRight(View view) {
        if (this.mCurrentItemView != null) {
            if (this.runnableMove != null) {
                this.runnableMove.stopRun(true);
                this.runnableMove = null;
            }
            this.runnableMove = new RunnableMove(view, view.getScrollX(), 0);
            this.runnableMove.run();
            this.mIsShown = false;
        }
    }

    private void showRight(View view) {
        if (this.runnableMove != null) {
            this.runnableMove.stopRun(true);
            this.runnableMove = null;
        }
        if (view.getId() != this.listView.idPageRowGroup) {
            this.runnableMove = new RunnableMove(view, view.getScrollX(), this.mRightViewWidth);
            this.runnableMove.run();
        }
        this.mIsShown = true;
    }
}
