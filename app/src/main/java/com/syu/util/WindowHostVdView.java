package com.syu.util;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.InputDevice;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

import com.syu.vdhost.VdHostProtocol;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * Replacement for Android 10's android.app.ActivityView: on Android 11+, and on Android 8-10
 * for a launcher that is not a system app (see WindowHostVdClient.shouldUse()).
 *
 * ActivityView put the VirtualDisplay's own layer tree under its SurfaceView
 * (IWindowSession.reparentDisplayContent) and let the system route touches into it. That API is
 * gone from Android 12 on. Here the VirtualDisplay simply renders INTO the SurfaceView's Surface,
 * and the touches this view receives are injected into the display. Creating the display, starting
 * other apps on it and injecting input need system permissions, so the VD host does them -- see
 * WindowHostVdClient.
 *
 * The private member names copy ActivityView's on purpose (mVirtualDisplay, mSurfaceCallback,
 * mLocationInWindow, getBaseDisplayDensity(), updateLocationAndTapExcludeRegion(), ...):
 * WindowHost*, WindowUtil and WindowHostReparenter reach those by reflection and keep working.
 */
public class WindowHostVdView extends ViewGroup {
    private static final String TAG = "WindowHostVdView";

    private final SurfaceView mSurfaceView;
    private final SurfaceCallback mSurfaceCallback;
    private final int[] mLocationInWindow = new int[2];
    /** Lets the host release our displays if this process dies. */
    private final IBinder mClientToken = new Binder();
    private final WindowHostVdClient.Listener mHostListener = this::onHostChanged;

    private WindowHostVdDisplay mVirtualDisplay;
    private WindowHostActivityView.Callback mListener;
    private boolean mOpened = true;
    private boolean mReadyReported;
    /**
     * Set when the pane that owned this view took it off screen without releasing it (WindowHost
     * replaced by a rebuild): its display, and the app on it, may then be handed to the new pane
     * showing the same app. Cleared as soon as the view is attached again (a swap only moves it).
     */
    private boolean mDisplayDonor;
    /** The app the pane is about to show, if it said so (expectPackage()). */
    private String mExpectedPkg;
    /** Bumped by every surface change: drops a pending scheduleSurfaceAttach(). */
    private int mAttachGen;
    /** Set while the SurfaceView swaps its surface for a new one after a hand-over. */
    private boolean mRenewingSurface;
    /** What this pane last started, to start again on a fresh display after the host died. */
    private Intent mLastIntent;
    /**
     * The VD host died under this pane (Shizuku restarts its server, e.g. when ADB comes and
     * goes): its display and app are gone, and nothing but this view starts the app again -- the
     * pane's own launch sequence only runs once. Cleared by that start.
     */
    private boolean mLostToHostDeath;

    /**
     * The pane the user last touched, while the launcher itself has not been touched or focused
     * since. Main thread. See forwardBackToFocusedPane().
     */
    private static java.lang.ref.WeakReference<WindowHostVdView> sFocusedPane;

    /** Every open view, so a new pane can find the display its app already runs on. Main thread. */
    private static final Set<WindowHostVdView> sOpenViews =
            Collections.newSetFromMap(new WeakHashMap<WindowHostVdView, Boolean>());

    public WindowHostVdView(Context context) {
        super(context);
        mSurfaceView = new SurfaceView(context);
        mSurfaceCallback = new SurfaceCallback();
        mSurfaceView.getHolder().addCallback(mSurfaceCallback);
        addView(mSurfaceView);
        WindowHostVdClient.addListener(mHostListener);
        sOpenViews.add(this);
    }

    // =====================================================================================
    // ActivityView-shaped API
    // =====================================================================================

    /** Replaces ActivityView.setCallback(): readiness is reported like startReadinessWatch() does. */
    void setListener(WindowHostActivityView.Callback listener) {
        mListener = listener;
        post(this::reportReadyIfPossible);
    }

    public int getVirtualDisplayId() {
        WindowHostVdDisplay vd = mVirtualDisplay;
        return vd != null ? vd.getDisplayId() : -1;
    }

    public void release() {
        performRelease();
    }

    private void performRelease() {
        if (!mOpened) return;
        mOpened = false;
        sOpenViews.remove(this);
        mSurfaceView.getHolder().removeCallback(mSurfaceCallback);
        WindowHostVdClient.removeListener(mHostListener);

        WindowHostVdDisplay vd = mVirtualDisplay;
        mVirtualDisplay = null;
        if (vd != null) {
            vd.release();
            reportDestroyed();
        }
    }

    public void onLocationChanged() { }

    /** ActivityView kept the system's touch routing in sync; touches are forwarded here instead. */
    private void updateLocationAndTapExcludeRegion() { }

    private void updateTapExcludeRegion(int x, int y) { }

    private void cleanTapExcludeRegion() { }

    private int getBaseDisplayDensity() {
        WindowManager wm = getContext().getSystemService(WindowManager.class);
        if (wm != null) {
            DisplayMetrics metrics = new DisplayMetrics();
            wm.getDefaultDisplay().getMetrics(metrics);
            if (metrics.densityDpi > 0) return metrics.densityDpi;
        }
        return getResources().getDisplayMetrics().densityDpi;
    }

    public void performBackPress() {
        WindowHostVdDisplay vd = mVirtualDisplay;
        if (vd == null) return;
        vd.injectInput(createKeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK));
        vd.injectInput(createKeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BACK));
    }

    private static KeyEvent createKeyEvent(int action, int code) {
        long when = SystemClock.uptimeMillis();
        return new KeyEvent(when, when, action, code, 0, 0, KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                KeyEvent.FLAG_FROM_SYSTEM | KeyEvent.FLAG_VIRTUAL_HARD_KEY, InputDevice.SOURCE_KEYBOARD);
    }

    public void startActivity(Intent intent) {
        if (!startActivitySafely(intent)) {
            throw new IllegalStateException("could not start " + intent + " on the pane's display");
        }
    }

    /**
     * Starts the intent on this view's display.
     *
     * The VD host launches first: as system or shell it passes every "may launch on this display"
     * check, including for activities without android:allowEmbedded, and it hands the top focus
     * back to the main screen afterwards (see VdHostCore.scheduleFocusRestore()). The launcher's own
     * start is kept as a fallback; the display is public, so the system usually allows it too.
     */
    boolean startActivitySafely(Intent intent) {
        if (mVirtualDisplay == null || intent == null) return false;

        final String pkg = intent.getComponent() != null
                ? intent.getComponent().getPackageName() : intent.getPackage();
        adoptDisplayOf(pkg);
        final WindowHostVdDisplay vd = mVirtualDisplay;

        // A display taken over from the previous pane already runs this app: leave it alone.
        // Starting it again brought the task to front with a transition animation, and a static
        // app (no new frame after it) kept showing the frame composited halfway through it --
        // the app dimmed -- until a resize; apps whose launcher activity is not singleTask
        // (Docs) also stacked one more activity on every rebuild.
        if (pkg != null && pkg.equals(vd.getPackage())
                && Boolean.FALSE.equals(WindowHostVdClient.isDisplayEmpty(vd.getDisplayId()))) {
            Log.i(TAG, pkg + " already runs on display " + vd.getDisplayId() + ", not started again");
            return true;
        }

        Intent i = new Intent(intent).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // No launch bounds or freeform mode here: the task simply fills the display.
        Bundle options = ActivityOptions.makeBasic().setLaunchDisplayId(vd.getDisplayId()).toBundle();

        mLastIntent = new Intent(intent);
        try {
            int res = vd.startActivity(i, options);
            if (res >= 0) {
                vd.setPackage(pkg);
                return true;
            }
            Log.w(TAG, "VD host start of " + i.getComponent() + " returned " + res + ", starting directly");
        } catch (Throwable t) {
            Log.w(TAG, "VD host start failed, starting directly", t);
        }

        try {
            getContext().startActivity(i, options);
            vd.setPackage(pkg);
            return true;
        } catch (Throwable t) {
            Log.w(TAG, "direct start failed", t);
            return false;
        }
    }

    // =====================================================================================
    // Back for the pane the user works in
    // =====================================================================================

    /**
     * Touching a pane makes its display the top focused one, so its app gets the keyboard and
     * hardware keys. The Back GESTURE, though, is resolved on the screen it is made on: Android 16
     * hands it to the main screen's focused window -- the launcher -- even while the pane has the
     * focus, so an embedded app's keyboard or back stack could never be closed by it. The launcher
     * forwards it instead, as a Back key on the pane's display.
     *
     * @return true when Back went to a pane, and the launcher must not act on it
     */
    public static boolean forwardBackToFocusedPane() {
        WindowHostVdView pane = sFocusedPane != null ? sFocusedPane.get() : null;
        if (pane == null || !pane.mOpened || !pane.isAttachedToWindow() || pane.mVirtualDisplay == null) {
            sFocusedPane = null;
            return false;
        }
        Log.i(TAG, "Back forwarded to display " + pane.getVirtualDisplayId());
        pane.performBackPress();
        return true;
    }

    /** The launcher's own window was touched or got the focus back: Back is the launcher's again. */
    public static void noteLauncherInteraction() {
        sFocusedPane = null;
    }

    // =====================================================================================
    // Display hand-over between WindowHost rebuilds
    // =====================================================================================

    /**
     * A rebuild replaces every pane with a new one that has a display of its own. Starting the app
     * there would MOVE its task from the old display to the new one without recreating it, and an
     * app that handles configuration changes itself (Firefox) keeps talking to the old display:
     * its keyboard is refused ("display ID mismatch") and its next popup crashes once that display
     * is gone. So the new pane takes the old display over instead -- the task never changes
     * display, and its state is kept.
     */
    static void markDisplayDonor(Object av) {
        if (av instanceof WindowHostVdView) ((WindowHostVdView) av).mDisplayDonor = true;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mDisplayDonor = false;
    }

    /**
     * Tells the pane's view which app it is about to show, before it is attached: when a pane of
     * the previous WindowHost still has that app on its display, the view takes that display
     * right away (createDisplayIfPossible()) instead of making a fresh one first, which saves a
     * display's buffers and swapping the surface afterwards (adoptDisplayOf()).
     */
    static void expectPackage(Object av, String pkg) {
        if (av instanceof WindowHostVdView) ((WindowHostVdView) av).mExpectedPkg = pkg;
    }

    /** Main thread. Detaches and returns the display pkg runs on in a detached previous pane, if any. */
    private WindowHostVdDisplay takeDonorDisplay(String pkg) {
        if (pkg == null) return null;
        final VdHostProtocol.Proxy host = WindowHostVdClient.current();
        for (WindowHostVdView v : sOpenViews.toArray(new WindowHostVdView[0])) {
            if (v == this || v == null || !v.mOpened || !v.mDisplayDonor || v.isAttachedToWindow()) continue;
            WindowHostVdDisplay d = v.mVirtualDisplay;
            if (d == null || !pkg.equals(d.getPackage()) || !d.isOn(host)) continue;
            v.mVirtualDisplay = null;        // its release() must not take the display along
            return d;
        }
        return null;
    }

    /** Main thread. Swaps this view's fresh display for the one pkg already runs on, if any. */
    private void adoptDisplayOf(String pkg) {
        final WindowHostVdDisplay mine = mVirtualDisplay;
        // Only a display nothing was started on yet; a pane switching apps keeps its own.
        if (pkg == null || mine == null || mine.getPackage() != null) return;

        WindowHostVdDisplay donor = takeDonorDisplay(pkg);
        if (donor == null) return;

        mVirtualDisplay = donor;
        WindowHostVdClient.noteDisplay(donor.getDisplayId(), true);
        mine.release();
        // The fresh display had this view's surface, and SurfaceFlinger lets go of a released
        // display's surface whenever it gets to it -- sometimes only after the donor connected:
        // "connect: already connected", or later "no connected producer", and the pane stays
        // black or dimmed until a resize. So the donor never gets that surface: the SurfaceView
        // drops it and makes a new one, which surfaceCreated() hands to the donor.
        Surface surface = mSurfaceView.getHolder().getSurface();
        if (surface != null && surface.isValid()) {
            mRenewingSurface = true;
            mSurfaceView.setVisibility(View.GONE);
            // In case the surface goes without surfaceDestroyed() coming here.
            postDelayed(this::endSurfaceRenewal, SURFACE_RENEWAL_TIMEOUT_MS);
        }
        Log.i(TAG, "display " + donor.getDisplayId() + " with " + pkg + " handed over from the previous pane"
                + " (fresh display " + mine.getDisplayId() + " released)");
    }

    private static final long SURFACE_RENEWAL_TIMEOUT_MS = 500;

    /** How long a display stays on after its surface went, in case the surface comes back. */
    private static final long DISPLAY_OFF_GRACE_MS = 1000;

    /** Shows the SurfaceView again once its old surface is gone: a new one comes with it. */
    private void endSurfaceRenewal() {
        if (!mRenewingSurface) return;
        mRenewingSurface = false;
        mSurfaceView.setVisibility(getVisibility());
    }

    // =====================================================================================
    // Layout
    // =====================================================================================

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mSurfaceView.measure(
                MeasureSpec.makeMeasureSpec(getMeasuredWidth(), MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(getMeasuredHeight(), MeasureSpec.EXACTLY));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mSurfaceView.layout(0, 0, r - l, b - t);
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (mRenewingSurface) return;   // endSurfaceRenewal() shows it again
        mSurfaceView.setVisibility(visibility);
    }

    // =====================================================================================
    // Touch forwarding
    // =====================================================================================

    /**
     * ActivityView took the pane out of the launcher window's touchable region, so the launcher
     * never saw those touches. Here they arrive like any other, so keep the parents (workspace
     * paging) from stealing the gesture and hand everything to the embedded display.
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        WindowHostVdDisplay vd = mVirtualDisplay;
        if (vd == null || !mOpened) return super.dispatchTouchEvent(ev);

        if (ev.getActionMasked() == MotionEvent.ACTION_DOWN) {
            ViewParent p = getParent();
            if (p != null) p.requestDisallowInterceptTouchEvent(true);
            sFocusedPane = new java.lang.ref.WeakReference<>(this);
        }

        MotionEvent out = toDisplayEvent(ev, vd);
        if (out != null) {
            vd.injectInput(out);
            out.recycle();
        }
        return true;
    }

    /**
     * Rebuilds the event in display coordinates. A copy (MotionEvent.obtain(ev)) would keep the
     * window-relative raw coordinates plus an offset, and before Android 12 the input dispatcher
     * ignores that offset for injected events.
     */
    private MotionEvent toDisplayEvent(MotionEvent ev, WindowHostVdDisplay vd) {
        final int count = ev.getPointerCount();
        final float sx = (getWidth() > 0 && vd.getWidth() > 0) ? vd.getWidth() / (float) getWidth() : 1f;
        final float sy = (getHeight() > 0 && vd.getHeight() > 0) ? vd.getHeight() / (float) getHeight() : 1f;

        MotionEvent.PointerProperties[] props = new MotionEvent.PointerProperties[count];
        MotionEvent.PointerCoords[] coords = new MotionEvent.PointerCoords[count];
        for (int p = 0; p < count; p++) {
            props[p] = new MotionEvent.PointerProperties();
            ev.getPointerProperties(p, props[p]);
            coords[p] = new MotionEvent.PointerCoords();
        }

        final int history = ev.getHistorySize();
        MotionEvent out = null;
        for (int h = 0; h <= history; h++) {
            boolean current = h == history;
            for (int p = 0; p < count; p++) {
                if (current) ev.getPointerCoords(p, coords[p]);
                else ev.getHistoricalPointerCoords(p, h, coords[p]);
                coords[p].x *= sx;
                coords[p].y *= sy;
            }
            long time = current ? ev.getEventTime() : ev.getHistoricalEventTime(h);
            if (out == null) {
                out = MotionEvent.obtain(ev.getDownTime(), time, ev.getAction(), count, props, coords,
                        ev.getMetaState(), ev.getButtonState(), 1f, 1f, ev.getDeviceId(),
                        ev.getEdgeFlags(), InputDevice.SOURCE_TOUCHSCREEN, ev.getFlags());
            } else {
                out.addBatch(time, coords, ev.getMetaState());
            }
        }
        return out;
    }

    // =====================================================================================
    // Display lifecycle
    // =====================================================================================

    private void createDisplayIfPossible() {
        if (!mOpened || mVirtualDisplay != null) return;
        SurfaceHolder holder = mSurfaceView.getHolder();
        Surface surface = holder.getSurface();
        if (surface == null || !surface.isValid()) return;

        int w = mSurfaceView.getWidth();
        int h = mSurfaceView.getHeight();
        if (w <= 0 || h <= 0) return;   // surfaceChanged() comes back with a size

        VdHostProtocol.Proxy host = WindowHostVdClient.get(getContext());
        if (host == null) {
            Log.i(TAG, "VD host not attached yet; the display is created when it is");
            return;
        }

        int dpi = getBaseDisplayDensity();
        // The app this pane shows still runs on a previous pane's display: take that one. This
        // view's surface is new and has never been on another display, so it can go straight on.
        WindowHostVdDisplay donor = takeDonorDisplay(mExpectedPkg);
        if (donor != null) {
            mVirtualDisplay = donor;
            WindowHostVdClient.noteDisplay(donor.getDisplayId(), true);
            donor.resize(w, h, dpi);
            donor.setDisplayState(true);
            scheduleSurfaceAttach();
            Log.i(TAG, "display " + donor.getDisplayId() + " with " + mExpectedPkg
                    + " taken over from the previous pane, no fresh display");
            return;
        }
        try {
            int id = host.createDisplay(mClientToken, "WindowHostVd@" + System.identityHashCode(this),
                    w, h, dpi, VdHostProtocol.DEFAULT_FLAGS, null);
            mVirtualDisplay = new WindowHostVdDisplay(getContext(), host, id, w, h, dpi);
            WindowHostVdClient.noteDisplay(id, true);
            scheduleSurfaceAttach();
            Log.i(TAG, "display " + id + " created " + w + "x" + h + "@" + dpi);
        } catch (Throwable t) {
            Log.w(TAG, "createDisplay failed", t);
            return;
        }
        if (mLostToHostDeath && mLastIntent != null) {
            mLostToHostDeath = false;
            Intent again = mLastIntent;
            Log.i(TAG, "VD host back: starting " + again.getComponent() + " again on display "
                    + mVirtualDisplay.getDisplayId());
            if (!startActivitySafely(again)) {
                Log.w(TAG, "could not start " + again.getComponent() + " again after the VD host died");
            }
        }
    }

    /**
     * No display only because the VD host (root or Shizuku) has not attached yet: the panes come
     * up with the launcher, Shizuku's host can attach a second or more later (after an install from
     * Android Studio, or a long sleep). The display, and onReady(), come when it does.
     */
    boolean isAwaitingHost() {
        return mOpened && mVirtualDisplay == null && WindowHostVdClient.get(getContext()) == null;
    }

    private void onHostChanged(boolean available) {
        if (!mOpened) return;
        if (available) {
            createDisplayIfPossible();
            reportReadyIfPossible();
            return;
        }
        WindowHostVdDisplay vd = mVirtualDisplay;
        if (vd == null) return;
        vd.markDead();
        mVirtualDisplay = null;
        mLostToHostDeath = true;
        reportDestroyed();
    }

    private void reportReadyIfPossible() {
        if (mReadyReported || mListener == null || mVirtualDisplay == null) return;
        Surface surface = mSurfaceView.getHolder().getSurface();
        if (surface == null || !surface.isValid()) return;
        mReadyReported = true;
        try { mListener.onReady(); } catch (Throwable t) { Log.w(TAG, "onReady failed", t); }
    }

    private void reportDestroyed() {
        mReadyReported = false;
        if (mListener == null) return;
        try { mListener.onDestroyed(); } catch (Throwable t) { Log.w(TAG, "onDestroyed failed", t); }
    }

    /** Longest wait for the window's frame before the surface is handed over regardless. */
    private static final long SURFACE_ATTACH_BACKSTOP_MS = 500;
    /** After that frame, so its sync with the window manager is through as well. */
    private static final long SURFACE_ATTACH_SETTLE_MS = 32;

    /**
     * Hands the SurfaceView's surface to the display once the window has committed a frame, never
     * from inside the surface callbacks. Those run while a new (or relaid out) window is in its
     * BLAST sync with the window manager, and a display frame queued at that moment can get stuck
     * in the SurfaceView's sync: the pane then keeps that one frame -- black, or the app dimmed
     * halfway through its opening animation -- while the display goes on rendering (SurfaceFlinger
     * shows frame=1 on that SurfaceView), until a resize relays the window out.
     */
    private void scheduleSurfaceAttach() {
        final int gen = ++mAttachGen;
        final boolean[] done = new boolean[1];
        final Runnable attach = () -> {
            if (done[0] || gen != mAttachGen) return;
            done[0] = true;
            WindowHostVdDisplay vd = mVirtualDisplay;
            Surface surface = mSurfaceView.getHolder().getSurface();
            if (vd == null || !mOpened || surface == null || !surface.isValid()) return;
            vd.setSurface(surface);
            vd.setDisplayState(true);
            postDelayed(() -> recomposeDisplay(gen), SURFACE_RECOMPOSE_DELAY_MS);
        };
        ViewTreeObserver vto = isAttachedToWindow() ? getViewTreeObserver() : null;
        if (Build.VERSION.SDK_INT < 29) {
            // No frame commit callback, and no BLAST sync to wait out either (Android 12+).
            postDelayed(attach, SURFACE_ATTACH_SETTLE_MS);
        } else if (vto != null && vto.isAlive()) {
            vto.registerFrameCommitCallback(() -> postDelayed(attach, SURFACE_ATTACH_SETTLE_MS));
            invalidate();
        }
        postDelayed(attach, SURFACE_ATTACH_BACKSTOP_MS);
    }

    /** When the display is composited afresh after the surface went on; transitions are over by then. */
    private static final long SURFACE_RECOMPOSE_DELAY_MS = 1500;
    /** How long the display stays without the surface for that. */
    private static final long SURFACE_RECOMPOSE_GAP_MS = 150;

    /**
     * SurfaceFlinger composites a display only when something on it changes. Coming back on
     * screen the app's task animates in (display switched on, task brought to front); an app that
     * draws nothing afterwards (Firefox on a page, APK Analyzer) left the pane showing the last
     * frame composited during that animation -- the app dimmed -- for as long as it stayed
     * static (SurfaceFlinger: frame=1 on the pane's SurfaceView, while the display itself was
     * composed at full opacity), until a divider drag re-attached the surface. So re-attach it
     * once, after the animations: the display is composited from scratch. The SurfaceView keeps
     * its last frame meanwhile, nothing flickers.
     */
    private void recomposeDisplay(final int gen) {
        if (gen != mAttachGen) return;
        final WindowHostVdDisplay vd = mVirtualDisplay;
        Surface surface = mSurfaceView.getHolder().getSurface();
        if (vd == null || !mOpened || surface == null || !surface.isValid()) return;
        vd.setSurface(null);
        postDelayed(() -> {
            Surface s = mSurfaceView.getHolder().getSurface();
            // A new surface meanwhile has its own attach on the way.
            if (gen != mAttachGen || mVirtualDisplay != vd || !mOpened || s == null || !s.isValid()) return;
            vd.setSurface(s);
        }, SURFACE_RECOMPOSE_GAP_MS);
    }

    private class SurfaceCallback implements SurfaceHolder.Callback {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            WindowHostVdDisplay vd = mVirtualDisplay;
            if (vd == null) {
                createDisplayIfPossible();
            } else {
                vd.setDisplayState(true);
                scheduleSurfaceAttach();
            }
            reportReadyIfPossible();
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            WindowHostVdDisplay vd = mVirtualDisplay;
            if (vd == null) {
                createDisplayIfPossible();
            } else {
                vd.resize(width, height, getBaseDisplayDensity());
            }
            reportReadyIfPossible();
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            mAttachGen++;
            if (mRenewingSurface) {
                // The surface the fresh display had; the adopted display stays on for the new one.
                post(WindowHostVdView.this::endSurfaceRenewal);
                return;
            }
            WindowHostVdDisplay vd = mVirtualDisplay;
            Log.d(TAG, "surface destroyed, display " + (vd != null ? vd.getDisplayId() : -1)
                    + (vd != null ? " detached" : " (none)"));
            if (vd != null) {
                // As ActivityView: the embedded app stops while the pane is not on screen -- after
                // a grace period, so a swap or a hand-over (the surface is back at once) does not
                // stop and restart it.
                vd.setSurface(null);
                vd.setDisplayStateOffSoon(DISPLAY_OFF_GRACE_MS);
            }
            reportDestroyed();
        }
    }
}
