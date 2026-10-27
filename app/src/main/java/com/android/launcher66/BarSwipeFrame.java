package com.android.launcher66;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

/**
 * Root of the auto-hide bar's window. That window is separate from the launcher's, so a horizontal
 * swipe on it never reached the workspace and the pages did not move, unlike a swipe on the
 * regular bar. Every touch is therefore shown to the workspace's paging as well (the way the
 * status bar swipe strip does it, Workspace.handleExternalSwipe()), while the bar's own views keep
 * receiving it until the pages take the gesture over. {@link BarSwipeGesture} holds the rules.
 *
 * The window stays until the finger is lifted: removing it in the middle of a gesture would cancel
 * it, and the pages would stop following the finger.
 */
final class BarSwipeFrame extends FrameLayout {

    interface Host {
        /** The event goes through the workspace's paging; false if the workspace cannot page now. */
        boolean feed(MotionEvent e);

        /** The workspace's paging has the gesture. */
        boolean isPaging();

        /** A finger is on the window. */
        void onTouchStarted();

        /** The pages started to move under the finger. */
        void onPagingStarted();

        /** The gesture is over (or the window is gone). */
        void onTouchEnded();
    }

    private final Host host;
    private final BarSwipeGesture gesture = new BarSwipeGesture();
    private final long longPressMs;
    private boolean childDisallowed;
    private boolean touching;
    private long downTime;
    private float lastX;
    private float lastY;

    BarSwipeFrame(Context context, Host host) {
        super(context);
        this.host = host;
        this.longPressMs = ViewConfiguration.getLongPressTimeout();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        final int action = ev.getActionMasked();
        if (ev.getAction() == MotionEvent.ACTION_OUTSIDE) {
            // A touch on the launcher: it hides the bar (setupOverlayView()), the pages are not ours.
            return super.dispatchTouchEvent(ev);
        }
        if (action == MotionEvent.ACTION_DOWN) {
            childDisallowed = false;
            downTime = ev.getEventTime();
            touching = true;
            host.onTouchStarted();
        }
        lastX = ev.getX();
        lastY = ev.getY();

        final boolean feed = gesture.shouldFeed(
                action, ev.getEventTime() - downTime, longPressMs, childDisallowed);
        final boolean fed = feed && host.feed(ev);
        final int mask = gesture.afterFeed(action, fed, fed && host.isPaging(), childDisallowed);

        if ((mask & BarSwipeGesture.STOP_FEEDING) != 0) {
            feedCancel(ev);
        }
        if ((mask & BarSwipeGesture.CANCEL_CHILDREN) != 0) {
            final MotionEvent cancel = MotionEvent.obtain(ev);
            cancel.setAction(MotionEvent.ACTION_CANCEL);
            super.dispatchTouchEvent(cancel);
            cancel.recycle();
        }
        if ((mask & BarSwipeGesture.HIDE_BAR) != 0) {
            host.onPagingStarted();
        }
        if ((mask & BarSwipeGesture.DISPATCH) != 0) {
            super.dispatchTouchEvent(ev);
            if (action == MotionEvent.ACTION_DOWN
                    && (gesture.afterDownDispatch(childDisallowed) & BarSwipeGesture.STOP_FEEDING) != 0) {
                feedCancel(ev);
            }
        }
        if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
            touching = false;
            host.onTouchEnded();
        }
        // The window is the bar's all through: it must get the rest of the gesture.
        return true;
    }

    private void feedCancel(MotionEvent ev) {
        final MotionEvent cancel = MotionEvent.obtain(ev);
        cancel.setAction(MotionEvent.ACTION_CANCEL);
        host.feed(cancel);
        cancel.recycle();
    }

    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallow) {
        childDisallowed = disallow;
        super.requestDisallowInterceptTouchEvent(disallow);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (touching) {
            // The window went in the middle of a gesture: the pages settle instead of stopping
            // half way (as StatusBarSwipeDetector.onDestroy() does).
            if (gesture.isFeeding()) {
                final long now = SystemClock.uptimeMillis();
                final MotionEvent cancel =
                        MotionEvent.obtain(downTime, now, MotionEvent.ACTION_CANCEL, lastX, lastY, 0);
                host.feed(cancel);
                cancel.recycle();
            }
            touching = false;
            host.onTouchEnded();
        }
    }
}
