package android.support.v4.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class GestureDetectorCompat {
    private final GestureDetectorCompatImpl mImpl;

    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent motionEvent);

        void setIsLongpressEnabled(boolean z);

        void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);
    }

    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        private static final int LONG_PRESS = 2;
        private static final int SHOW_PRESS = 1;
        private static final int TAP = 3;
        private boolean mAlwaysInBiggerTapRegion;
        private boolean mAlwaysInTapRegion;
        private MotionEvent mCurrentDownEvent;
        private boolean mDeferConfirmSingleTap;
        private GestureDetector.OnDoubleTapListener mDoubleTapListener;
        private int mDoubleTapSlopSquare;
        private float mDownFocusX;
        private float mDownFocusY;
        private final Handler mHandler;
        private boolean mInLongPress;
        private boolean mIsDoubleTapping;
        private boolean mIsLongpressEnabled;
        private float mLastFocusX;
        private float mLastFocusY;
        private final GestureDetector.OnGestureListener mListener;
        private int mMaximumFlingVelocity;
        private int mMinimumFlingVelocity;
        private MotionEvent mPreviousUpEvent;
        private boolean mStillDown;
        private int mTouchSlopSquare;
        private VelocityTracker mVelocityTracker;
        private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
        private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();

        private class GestureHandler extends Handler {
            GestureHandler() {
            }

            GestureHandler(Handler handler) {
                super(handler.getLooper());
            }

            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        GestureDetectorCompatImplBase.this.mListener.onShowPress(GestureDetectorCompatImplBase.this.mCurrentDownEvent);
                        return;
                    case 2:
                        GestureDetectorCompatImplBase.this.dispatchLongPress();
                        return;
                    case 3:
                        if (GestureDetectorCompatImplBase.this.mDoubleTapListener != null) {
                            if (!GestureDetectorCompatImplBase.this.mStillDown) {
                                GestureDetectorCompatImplBase.this.mDoubleTapListener.onSingleTapConfirmed(GestureDetectorCompatImplBase.this.mCurrentDownEvent);
                                return;
                            } else {
                                GestureDetectorCompatImplBase.this.mDeferConfirmSingleTap = true;
                                return;
                            }
                        }
                        return;
                    default:
                        throw new RuntimeException("Unknown message " + msg);
                }
            }
        }

        public GestureDetectorCompatImplBase(Context context, GestureDetector.OnGestureListener listener, Handler handler) {
            if (handler != null) {
                this.mHandler = new GestureHandler(handler);
            } else {
                this.mHandler = new GestureHandler();
            }
            this.mListener = listener;
            if (listener instanceof GestureDetector.OnDoubleTapListener) {
                setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) listener);
            }
            init(context);
        }

        private void init(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            if (this.mListener == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            this.mIsLongpressEnabled = true;
            ViewConfiguration configuration = ViewConfiguration.get(context);
            int touchSlop = configuration.getScaledTouchSlop();
            int doubleTapSlop = configuration.getScaledDoubleTapSlop();
            this.mMinimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
            this.mMaximumFlingVelocity = configuration.getScaledMaximumFlingVelocity();
            this.mTouchSlopSquare = touchSlop * touchSlop;
            this.mDoubleTapSlopSquare = doubleTapSlop * doubleTapSlop;
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.mDoubleTapListener = onDoubleTapListener;
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean isLongpressEnabled) {
            this.mIsLongpressEnabled = isLongpressEnabled;
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.mIsLongpressEnabled;
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean onTouchEvent(MotionEvent ev) {
            int action = ev.getAction();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(ev);
            boolean pointerUp = (action & 255) == 6;
            int skipIndex = pointerUp ? MotionEventCompat.getActionIndex(ev) : -1;
            float sumX = 0.0f;
            float sumY = 0.0f;
            int count = MotionEventCompat.getPointerCount(ev);
            for (int i = 0; i < count; i++) {
                if (skipIndex != i) {
                    sumX += MotionEventCompat.getX(ev, i);
                    sumY += MotionEventCompat.getY(ev, i);
                }
            }
            int div = pointerUp ? count - 1 : count;
            float focusX = sumX / div;
            float focusY = sumY / div;
            boolean handled = false;
            switch (action & 255) {
                case 0:
                    if (this.mDoubleTapListener != null) {
                        boolean hadTapMessage = this.mHandler.hasMessages(3);
                        if (hadTapMessage) {
                            this.mHandler.removeMessages(3);
                        }
                        if (this.mCurrentDownEvent != null && this.mPreviousUpEvent != null && hadTapMessage && isConsideredDoubleTap(this.mCurrentDownEvent, this.mPreviousUpEvent, ev)) {
                            this.mIsDoubleTapping = true;
                            handled = false | this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | this.mDoubleTapListener.onDoubleTapEvent(ev);
                        } else {
                            this.mHandler.sendEmptyMessageDelayed(3, DOUBLE_TAP_TIMEOUT);
                        }
                    }
                    this.mLastFocusX = focusX;
                    this.mDownFocusX = focusX;
                    this.mLastFocusY = focusY;
                    this.mDownFocusY = focusY;
                    if (this.mCurrentDownEvent != null) {
                        this.mCurrentDownEvent.recycle();
                    }
                    this.mCurrentDownEvent = MotionEvent.obtain(ev);
                    this.mAlwaysInTapRegion = true;
                    this.mAlwaysInBiggerTapRegion = true;
                    this.mStillDown = true;
                    this.mInLongPress = false;
                    this.mDeferConfirmSingleTap = false;
                    if (this.mIsLongpressEnabled) {
                        this.mHandler.removeMessages(2);
                        this.mHandler.sendEmptyMessageAtTime(2, this.mCurrentDownEvent.getDownTime() + ((long) TAP_TIMEOUT) + ((long) LONGPRESS_TIMEOUT));
                    }
                    this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + ((long) TAP_TIMEOUT));
                    return handled | this.mListener.onDown(ev);
                case 1:
                    this.mStillDown = false;
                    MotionEvent currentUpEvent = MotionEvent.obtain(ev);
                    if (this.mIsDoubleTapping) {
                        handled = false | this.mDoubleTapListener.onDoubleTapEvent(ev);
                    } else if (this.mInLongPress) {
                        this.mHandler.removeMessages(3);
                        this.mInLongPress = false;
                    } else if (this.mAlwaysInTapRegion) {
                        handled = this.mListener.onSingleTapUp(ev);
                        if (this.mDeferConfirmSingleTap && this.mDoubleTapListener != null) {
                            this.mDoubleTapListener.onSingleTapConfirmed(ev);
                        }
                    } else {
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        int pointerId = MotionEventCompat.getPointerId(ev, 0);
                        velocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
                        float velocityY = VelocityTrackerCompat.getYVelocity(velocityTracker, pointerId);
                        float velocityX = VelocityTrackerCompat.getXVelocity(velocityTracker, pointerId);
                        if (Math.abs(velocityY) > this.mMinimumFlingVelocity || Math.abs(velocityX) > this.mMinimumFlingVelocity) {
                            handled = this.mListener.onFling(this.mCurrentDownEvent, ev, velocityX, velocityY);
                        }
                    }
                    if (this.mPreviousUpEvent != null) {
                        this.mPreviousUpEvent.recycle();
                    }
                    this.mPreviousUpEvent = currentUpEvent;
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                    }
                    this.mIsDoubleTapping = false;
                    this.mDeferConfirmSingleTap = false;
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                    return handled;
                case 2:
                    if (this.mInLongPress) {
                        return false;
                    }
                    float scrollX = this.mLastFocusX - focusX;
                    float scrollY = this.mLastFocusY - focusY;
                    if (this.mIsDoubleTapping) {
                        return false | this.mDoubleTapListener.onDoubleTapEvent(ev);
                    }
                    if (!this.mAlwaysInTapRegion) {
                        if (Math.abs(scrollX) < 1.0f && Math.abs(scrollY) < 1.0f) {
                            return false;
                        }
                        boolean handled2 = this.mListener.onScroll(this.mCurrentDownEvent, ev, scrollX, scrollY);
                        this.mLastFocusX = focusX;
                        this.mLastFocusY = focusY;
                        return handled2;
                    }
                    int deltaX = (int) (focusX - this.mDownFocusX);
                    int deltaY = (int) (focusY - this.mDownFocusY);
                    int distance = (deltaX * deltaX) + (deltaY * deltaY);
                    if (distance > this.mTouchSlopSquare) {
                        handled = this.mListener.onScroll(this.mCurrentDownEvent, ev, scrollX, scrollY);
                        this.mLastFocusX = focusX;
                        this.mLastFocusY = focusY;
                        this.mAlwaysInTapRegion = false;
                        this.mHandler.removeMessages(3);
                        this.mHandler.removeMessages(1);
                        this.mHandler.removeMessages(2);
                    }
                    if (distance > this.mTouchSlopSquare) {
                        this.mAlwaysInBiggerTapRegion = false;
                        return handled;
                    }
                    return handled;
                case 3:
                    cancel();
                    return false;
                case 4:
                default:
                    return false;
                case 5:
                    this.mLastFocusX = focusX;
                    this.mDownFocusX = focusX;
                    this.mLastFocusY = focusY;
                    this.mDownFocusY = focusY;
                    cancelTaps();
                    return false;
                case 6:
                    this.mLastFocusX = focusX;
                    this.mDownFocusX = focusX;
                    this.mLastFocusY = focusY;
                    this.mDownFocusY = focusY;
                    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
                    int upIndex = MotionEventCompat.getActionIndex(ev);
                    int id1 = MotionEventCompat.getPointerId(ev, upIndex);
                    float x1 = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, id1);
                    float y1 = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, id1);
                    for (int i2 = 0; i2 < count; i2++) {
                        if (i2 != upIndex) {
                            int id2 = MotionEventCompat.getPointerId(ev, i2);
                            float x = x1 * VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, id2);
                            float y = y1 * VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, id2);
                            float dot = x + y;
                            if (dot < 0.0f) {
                                this.mVelocityTracker.clear();
                                return false;
                            }
                        }
                    }
                    return false;
            }
        }

        private void cancel() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mIsDoubleTapping = false;
            this.mStillDown = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void cancelTaps() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mIsDoubleTapping = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private boolean isConsideredDoubleTap(MotionEvent firstDown, MotionEvent firstUp, MotionEvent secondDown) {
            if (!this.mAlwaysInBiggerTapRegion || secondDown.getEventTime() - firstUp.getEventTime() > DOUBLE_TAP_TIMEOUT) {
                return false;
            }
            int deltaX = ((int) firstDown.getX()) - ((int) secondDown.getX());
            int deltaY = ((int) firstDown.getY()) - ((int) secondDown.getY());
            return (deltaX * deltaX) + (deltaY * deltaY) < this.mDoubleTapSlopSquare;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dispatchLongPress() {
            this.mHandler.removeMessages(3);
            this.mDeferConfirmSingleTap = false;
            this.mInLongPress = true;
            this.mListener.onLongPress(this.mCurrentDownEvent);
        }
    }

    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        private final GestureDetector mDetector;

        public GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector.OnGestureListener listener, Handler handler) {
            this.mDetector = new GestureDetector(context, listener, handler);
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.mDetector.isLongpressEnabled();
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean onTouchEvent(MotionEvent ev) {
            return this.mDetector.onTouchEvent(ev);
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean enabled) {
            this.mDetector.setIsLongpressEnabled(enabled);
        }

        @Override // android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener listener) {
            this.mDetector.setOnDoubleTapListener(listener);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener listener) {
        this(context, listener, null);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener listener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.mImpl = new GestureDetectorCompatImplJellybeanMr2(context, listener, handler);
        } else {
            this.mImpl = new GestureDetectorCompatImplBase(context, listener, handler);
        }
    }

    public boolean isLongpressEnabled() {
        return this.mImpl.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent event) {
        return this.mImpl.onTouchEvent(event);
    }

    public void setIsLongpressEnabled(boolean enabled) {
        this.mImpl.setIsLongpressEnabled(enabled);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener listener) {
        this.mImpl.setOnDoubleTapListener(listener);
    }
}
