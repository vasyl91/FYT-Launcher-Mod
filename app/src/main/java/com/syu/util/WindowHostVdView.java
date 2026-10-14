package com.syu.util;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Insets;
import android.os.Binder;
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
import android.view.WindowManager;

import com.syu.vdhost.VdHostProtocol;

/**
 * Android 11+ replacement for Android 10's android.app.ActivityView.
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

    public WindowHostVdView(Context context) {
        super(context);
        mSurfaceView = new SurfaceView(context);
        mSurfaceCallback = new SurfaceCallback();
        mSurfaceView.getHolder().addCallback(mSurfaceCallback);
        addView(mSurfaceView);
        WindowHostVdClient.addListener(mHostListener);
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

    public void setForwardedInsets(Insets insets) { }

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
        WindowHostVdDisplay vd = mVirtualDisplay;
        if (vd == null || intent == null) return false;

        Intent i = new Intent(intent).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // No launch bounds or freeform mode here: the task simply fills the display.
        Bundle options = ActivityOptions.makeBasic().setLaunchDisplayId(vd.getDisplayId()).toBundle();

        try {
            int res = vd.startActivity(i, options);
            if (res >= 0) return true;
            Log.w(TAG, "VD host start of " + i.getComponent() + " returned " + res + ", starting directly");
        } catch (Throwable t) {
            Log.w(TAG, "VD host start failed, starting directly", t);
        }

        try {
            getContext().startActivity(i, options);
            return true;
        } catch (Throwable t) {
            Log.w(TAG, "direct start failed", t);
            return false;
        }
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
        try {
            int id = host.createDisplay(mClientToken, "WindowHostVd@" + System.identityHashCode(this),
                    w, h, dpi, VdHostProtocol.DEFAULT_FLAGS, surface);
            mVirtualDisplay = new WindowHostVdDisplay(getContext(), host, id, w, h, dpi);
            WindowHostVdClient.noteDisplay(id, true);
            Log.i(TAG, "display " + id + " created " + w + "x" + h + "@" + dpi);
        } catch (Throwable t) {
            Log.w(TAG, "createDisplay failed", t);
        }
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

    private class SurfaceCallback implements SurfaceHolder.Callback {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            WindowHostVdDisplay vd = mVirtualDisplay;
            if (vd == null) {
                createDisplayIfPossible();
            } else {
                vd.setSurface(holder.getSurface());
                vd.setDisplayState(true);
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
            WindowHostVdDisplay vd = mVirtualDisplay;
            if (vd != null) {
                // As ActivityView: the embedded app stops while the pane is not on screen.
                vd.setDisplayState(false);
                vd.setSurface(null);
            }
            reportDestroyed();
        }
    }
}
