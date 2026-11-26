package com.android.launcher66;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

import com.android.launcher66.settings.Keys;

/**
 * The gestures of the home screen that are not paging: a swipe up opens the app drawer, a swipe down opens the
 * notification shade ("Swipe up to open the app drawer", "Swipe down for notifications").
 *
 * <p>The rules (the owner, 2026-11-25, D-91; the arithmetic is {@link HomeGesture}):
 * <ul>
 *   <li>Both are settings of the layout creator, off by default, and so off with "Stock layout" ({@link CreatorPrefs}).
 *       The swipe up is on whatever is stored when the drawer has no other way to be opened ({@link DrawerAccess}).</li>
 *   <li>A touch is looked at only on the home screen at rest: not in the overview, the drawer or an open folder, not while
 *       an item is dragged, and not when it begins on an app's widget, on an element of the user's layout or on the
 *       music slider (the touches those own). The pages keep every other touch until it is a clearly vertical
 *       move: then this takes it (the pages do not scroll) and, when the finger is lifted, decides by the length or the
 *       speed of the swipe.</li>
 *   <li>The drawer comes up from the bottom with a slide (Launcher.showAllApps with {@code fromSwipe}); the shade is
 *       opened by {@link StatusBarPanel}.</li>
 * </ul>
 * Main thread only; made and used by {@link Workspace}.
 */
final class HomeGestures {

    private static final String TAG = "HomeGestures";

    private final Workspace mWorkspace;
    private final int mSlop;
    private final float mDensity;

    private boolean mArmed;
    private boolean mTaking;
    private float mDownX;
    private float mDownY;
    private VelocityTracker mVelocity;

    HomeGestures(Workspace workspace) {
        mWorkspace = workspace;
        Context context = workspace.getContext();
        mSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mDensity = context.getResources().getDisplayMetrics().density;
    }

    /** Whether this is a gesture of the home screen now: the pages and the touch's other users leave it alone. */
    boolean taking() {
        return mTaking;
    }

    private SharedPreferences prefs() {
        return mWorkspace.homePrefs();
    }

    private boolean wantsUp() {
        SharedPreferences prefs = prefs();
        if (prefs == null) {
            return false;
        }
        boolean stored = CreatorPrefs.of(prefs).getBoolean(Keys.SWIPE_UP_APP_DRAWER, false);
        return DrawerAccess.swipeUpActive(stored, true, false);
    }

    private boolean wantsDown() {
        SharedPreferences prefs = prefs();
        return prefs != null && CreatorPrefs.of(prefs).getBoolean(Keys.SWIPE_DOWN_NOTIFICATIONS, false);
    }

    /** Whether a touch that begins at x, y (the workspace's coordinates) may become a gesture. */
    private boolean armedAt(MotionEvent down) {
        Launcher launcher = mWorkspace.homeLauncher();
        if (launcher == null || !(wantsUp() || wantsDown())) {
            return false;
        }
        View item = mWorkspace.itemAt(down.getX(), down.getY());
        boolean onAppWidget = item instanceof LauncherAppWidgetHostView;
        boolean onUserElement = item != null && mWorkspace.isUserElement(item);
        boolean onSlider = TouchOwner.wants(down.getRawX(), down.getRawY());
        DragController drag = launcher.getDragController();
        return HomeGesture.mayStart(onAppWidget, onUserElement, onSlider,
                mWorkspace.isInOverviewMode() || mWorkspace.isSmall(),
                launcher.mState != Launcher.State.WORKSPACE,
                mWorkspace.getOpenFolder() != null,
                drag != null && drag.isDragging());
    }

    /**
     * Workspace.onInterceptTouchEvent: true when this touch has become a gesture of the home screen, that is, when it has
     * moved clearly upward or downward from a place where nothing else owns it.
     */
    boolean onIntercept(MotionEvent ev) {
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                reset();
                mDownX = ev.getX();
                mDownY = ev.getY();
                mArmed = armedAt(ev);
                if (mArmed) {
                    mVelocity = VelocityTracker.obtain();
                    mVelocity.addMovement(ev);
                }
                return false;
            case MotionEvent.ACTION_MOVE:
                return maybeTake(ev);
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                release();
                return false;
            default:
                return mTaking;
        }
    }

    /**
     * A move of a touch that was armed: whether it has become a gesture of the home screen, that is, moved past the touch
     * slop and clearly vertical (steeper than 60 degrees). Asked from {@link #onIntercept} when an icon has the touch, and
     * from {@link Workspace#onTouchEvent} when the workspace has it itself (a touch on empty space never passes the
     * intercept again after its first event).
     */
    boolean maybeTake(MotionEvent ev) {
        if (mTaking) {
            return true;
        }
        if (!mArmed || mVelocity == null) {
            return false;
        }
        mVelocity.addMovement(ev);
        float dx = ev.getX() - mDownX;
        float dy = ev.getY() - mDownY;
        if (Math.abs(dy) > mSlop && HomeGesture.steep(dx, dy)) {
            mTaking = true;
            return true;
        }
        return false;
    }

    /** The touch ended without being a gesture of this class. */
    void release() {
        if (!mTaking) {
            reset();
        }
    }

    /** Workspace.onTouchEvent while {@link #taking()}: follows the finger and decides when it is lifted. */
    boolean onTouch(MotionEvent ev) {
        if (mVelocity != null) {
            mVelocity.addMovement(ev);
        }
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_UP:
                finish(ev);
                reset();
                break;
            case MotionEvent.ACTION_CANCEL:
                reset();
                break;
            default:
                break;
        }
        return true;
    }

    private void finish(MotionEvent up) {
        float dx = up.getX() - mDownX;
        float dy = up.getY() - mDownY;
        float speed = 0f;
        if (mVelocity != null) {
            mVelocity.computeCurrentVelocity(1000);
            speed = mVelocity.getYVelocity() / mDensity;
        }
        int shortSide = Math.min(mWorkspace.getWidth(), mWorkspace.getHeight());
        HomeGesture.Result result = HomeGesture.classify(dx, dy, shortSide, speed);
        if (!HomeGesture.wanted(result, wantsUp(), wantsDown())) {
            Log.d(TAG, "Home swipe " + result + " (dy " + Math.round(dy) + " px, " + Math.round(speed)
                    + " dp/s): nothing to do");
            return;
        }
        Launcher launcher = mWorkspace.homeLauncher();
        if (launcher == null) {
            return;
        }
        if (result == HomeGesture.Result.UP) {
            Log.i(TAG, "Home swipe up: the app drawer (dy " + Math.round(dy) + " px, " + Math.round(speed) + " dp/s)");
            launcher.showAllApps(true, AppsCustomizePagedView.ContentType.Applications, true, true);
        } else {
            Log.i(TAG, "Home swipe down: the notification shade (dy " + Math.round(dy) + " px, "
                    + Math.round(speed) + " dp/s)");
            StatusBarPanel.expand(launcher);
        }
    }

    private void reset() {
        mArmed = false;
        mTaking = false;
        if (mVelocity != null) {
            mVelocity.recycle();
            mVelocity = null;
        }
    }
}
