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
 *       move made before the long press timeout: then this takes it (the pages do not scroll). It fires as soon as the
 *       swipe is long enough, and a short fast flick when the finger is lifted ({@link HomeSwipe}).</li>
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

    private final DoubleTap mDoubleTap = new DoubleTap();
    private long mLastTapEvent = -1L;

    private final HomeSwipe mSwipe;
    private VelocityTracker mVelocity;

    HomeGestures(Workspace workspace) {
        mWorkspace = workspace;
        Context context = workspace.getContext();
        mSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mDensity = context.getResources().getDisplayMetrics().density;
        mSwipe = new HomeSwipe(mSlop, ViewConfiguration.getLongPressTimeout());
    }

    /** Whether this is a gesture of the home screen now: the pages and the touch's other users leave it alone. */
    boolean taking() {
        return mSwipe.taking();
    }

    private SharedPreferences prefs() {
        return mWorkspace.homePrefs();
    }

    private boolean wantsUp() {
        SharedPreferences prefs = prefs();
        if (prefs == null) {
            return false;
        }
        CreatorPrefs creator = CreatorPrefs.of(prefs);
        boolean stored = creator.getBoolean(Keys.SWIPE_UP_APP_DRAWER, false);
        // Without the horizontal bar (and its drawer button) the swipe is the way to the drawer (DrawerAccess)
        return DrawerAccess.swipeUpActive(stored, creator.getBoolean(Keys.DISPLAY_HORIZONTAL_BAR, true),
                prefs.getBoolean(Keys.USER_LAYOUT, false) && creator.getBoolean(Keys.HORIZONTAL_BAR_NO_DRAWER, false));
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
            case MotionEvent.ACTION_DOWN: {
                recycleVelocity();
                boolean armed = armedAt(ev);
                mSwipe.down(ev.getEventTime(), ev.getX(), ev.getY(), armed, armed && wantsUp(), armed && wantsDown(),
                        Math.min(mWorkspace.getWidth(), mWorkspace.getHeight()));
                if (mSwipe.armed()) {
                    mVelocity = VelocityTracker.obtain();
                    mVelocity.addMovement(ev);
                }
                return false;
            }
            case MotionEvent.ACTION_MOVE:
                return maybeTake(ev);
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                release();
                return false;
            default:
                return mSwipe.taking();
        }
    }

    /**
     * A move of a touch that was armed: whether it has become a gesture of the home screen ({@link HomeSwipe}). Asked
     * from {@link #onIntercept} when an icon has the touch, and from {@link Workspace#onTouchEvent} when the workspace
     * has it itself (a touch on empty space never passes the intercept again after its first event). A drag that has
     * begun disarms it.
     */
    boolean maybeTake(MotionEvent ev) {
        if (mSwipe.taking()) {
            return true;
        }
        if (!mSwipe.armed()) {
            return false;
        }
        Launcher launcher = mWorkspace.homeLauncher();
        DragController drag = launcher == null ? null : launcher.getDragController();
        if (drag != null && drag.isDragging()) {
            mSwipe.cancel();
            recycleVelocity();
            return false;
        }
        if (mVelocity != null) {
            mVelocity.addMovement(ev);
        }
        act(mSwipe.move(ev.getEventTime(), ev.getX(), ev.getY()), ev, 0f);
        if (!mSwipe.armed() && !mSwipe.taking()) {
            recycleVelocity();
        }
        return mSwipe.taking();
    }

    /** The touch ended without being a gesture of this class. */
    void release() {
        if (!mSwipe.taking()) {
            mSwipe.cancel();
            recycleVelocity();
        }
    }

    /** Workspace.onTouchEvent while {@link #taking()}: follows the finger, fires when the swipe is long enough. */
    boolean onTouch(MotionEvent ev) {
        if (mVelocity != null) {
            mVelocity.addMovement(ev);
        }
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_MOVE:
                act(mSwipe.move(ev.getEventTime(), ev.getX(), ev.getY()), ev, 0f);
                break;
            case MotionEvent.ACTION_UP: {
                float speed = 0f;
                if (mVelocity != null) {
                    mVelocity.computeCurrentVelocity(1000);
                    speed = mVelocity.getYVelocity() / mDensity;
                }
                boolean firedBefore = mSwipe.fired();
                float dy = mSwipe.dy(ev.getY());
                HomeSwipe.Step step = mSwipe.up(ev.getX(), ev.getY(), speed);
                if (step == HomeSwipe.Step.NONE && !firedBefore) {
                    Log.d(TAG, "Home swipe: nothing to do (dy " + Math.round(dy) + " px, " + Math.round(speed)
                            + " dp/s)");
                }
                act(step, ev, speed);
                recycleVelocity();
                break;
            }
            case MotionEvent.ACTION_CANCEL:
                mSwipe.cancel();
                recycleVelocity();
                break;
            default:
                break;
        }
        return true;
    }

    /** Opens what a swipe that fired asks for. */
    private void act(HomeSwipe.Step step, MotionEvent ev, float speed) {
        if (step != HomeSwipe.Step.UP && step != HomeSwipe.Step.DOWN) {
            return;
        }
        Launcher launcher = mWorkspace.homeLauncher();
        if (launcher == null) {
            return;
        }
        String how = "(dy " + Math.round(mSwipe.dy(ev.getY())) + " px"
                + (ev.getActionMasked() == MotionEvent.ACTION_UP ? ", " + Math.round(speed) + " dp/s, lifted)"
                : ", moving)");
        if (step == HomeSwipe.Step.UP) {
            Log.i(TAG, "Home swipe up: the app drawer " + how);
            launcher.showAllApps(true, AppsCustomizePagedView.ContentType.Applications, true, true);
        } else {
            Log.i(TAG, "Home swipe down: the notification shade " + how);
            StatusBarPanel.expand(launcher);
        }
    }

    /**
     * A tap on empty space of the home screen (the up of a touch that began on no icon and no widget): the second of two
     * close in time and place ({@link DoubleTap}, with the system's timeout and slop) does what "Double-tap action" says.
     * Both ways a tap reaches the workspace may report the same up: the same event counts once.
     */
    void onEmptyTap(MotionEvent up) {
        SharedPreferences prefs = prefs();
        Launcher launcher = mWorkspace.homeLauncher();
        if (prefs == null || launcher == null || launcher.mState != Launcher.State.WORKSPACE
                || mWorkspace.isInOverviewMode() || mWorkspace.isSmall()) {
            return;
        }
        String action = DoubleTapActions.chosen(prefs);
        if (DoubleTapActions.NONE.equals(action)) {
            mDoubleTap.reset();
            return;
        }
        if (up.getEventTime() == mLastTapEvent) {
            return;
        }
        mLastTapEvent = up.getEventTime();
        ViewConfiguration configuration = ViewConfiguration.get(mWorkspace.getContext());
        if (mDoubleTap.onTap(up.getEventTime(), up.getX(), up.getY(), ViewConfiguration.getDoubleTapTimeout(),
                configuration.getScaledDoubleTapSlop())) {
            Log.i(TAG, "Home double tap: " + action);
            DoubleTapActions.perform(launcher, action);
        }
    }

    private void recycleVelocity() {
        if (mVelocity != null) {
            mVelocity.recycle();
            mVelocity = null;
        }
    }
}
