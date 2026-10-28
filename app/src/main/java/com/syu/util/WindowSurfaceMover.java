package com.syu.util;

import android.util.Log;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Moves a window's surface straight in SurfaceFlinger, in step with the frames of another window
 * of the process: the position is applied with the buffer that window draws in the same frame.
 * What SurfaceView does with its own surface, and android.view.SyncRtSurfaceTransactionApplier
 * with the surfaces of a remote animation: a frame callback of the other window's render thread
 * gives the frame number, and the transaction waits for that frame (deferTransactionUntilSurface).
 *
 * <p>Hidden API of Android 10, reached by reflection; create() answers null where any part of it
 * is missing (deferTransactionUntilSurface() is gone from Android 12 on) or refused (an app
 * without system privileges). WindowManager is not told: the window's frame there stays where it
 * was, so the caller tells it the final place with updateViewLayout() once the moves are over.
 * Only for a window that takes no touch, as its input frame stays behind meanwhile.
 */
public final class WindowSurfaceMover {

    private static final String TAG = "WindowSurfaceMover";

    /** Registrations whose callback did not run before the next one; more and the mover gives up. */
    private static final int MAX_UNANSWERED = 6;

    private static final Method GET_VIEW_ROOT_IMPL;
    private static final Method GET_SURFACE_CONTROL;
    private static final Field VIEW_ROOT_SURFACE;
    private static final Method REGISTER_RT_FRAME_CALLBACK;
    private static final Class<?> FRAME_DRAWING_CALLBACK;
    private static final Method SET_POSITION;
    private static final Method DEFER_UNTIL_SURFACE;

    static {
        Method getViewRootImpl = null, getSurfaceControl = null, register = null, setPosition = null,
                defer = null;
        Field viewRootSurface = null;
        Class<?> frameCallback = null;
        try {
            getViewRootImpl = View.class.getMethod("getViewRootImpl");
            Class<?> viewRootImpl = Class.forName("android.view.ViewRootImpl");
            getSurfaceControl = viewRootImpl.getMethod("getSurfaceControl");
            viewRootSurface = viewRootImpl.getField("mSurface");
            frameCallback = Class.forName("android.graphics.HardwareRenderer$FrameDrawingCallback");
            register = viewRootImpl.getMethod("registerRtFrameCallback", frameCallback);
            setPosition = SurfaceControl.Transaction.class.getMethod("setPosition",
                    SurfaceControl.class, float.class, float.class);
            defer = SurfaceControl.Transaction.class.getMethod("deferTransactionUntilSurface",
                    SurfaceControl.class, Surface.class, long.class);
        } catch (ReflectiveOperationException | RuntimeException | LinkageError e) {
            Log.i(TAG, "not available: " + e);
            getViewRootImpl = null;
        }
        GET_VIEW_ROOT_IMPL = getViewRootImpl;
        GET_SURFACE_CONTROL = getSurfaceControl;
        VIEW_ROOT_SURFACE = viewRootSurface;
        FRAME_DRAWING_CALLBACK = frameCallback;
        REGISTER_RT_FRAME_CALLBACK = register;
        SET_POSITION = setPosition;
        DEFER_UNTIL_SURFACE = defer;
    }

    private final View window;
    private final View frameSource;
    /** Moves older than this are not applied any more; see cancel(). Any thread. */
    private final AtomicInteger generation = new AtomicInteger();
    private final AtomicInteger unanswered = new AtomicInteger();
    private volatile boolean broken;
    /** The place last asked for; Integer.MIN_VALUE when none is on its way. Main thread. */
    private int lastX = Integer.MIN_VALUE, lastY = Integer.MIN_VALUE;

    private WindowSurfaceMover(View window, View frameSource) {
        this.window = window;
        this.frameSource = frameSource;
    }

    /**
     * A mover for the window of window, in step with the frames of frameSource's window; null if
     * this cannot be done here.
     */
    public static WindowSurfaceMover create(View window, View frameSource) {
        if (GET_VIEW_ROOT_IMPL == null || window == null || frameSource == null) return null;
        if (!frameSource.isHardwareAccelerated()) return null; // no render thread frames to follow
        return new WindowSurfaceMover(window, frameSource);
    }

    /**
     * Main thread: puts the window's surface at (x, y) of the screen with the next frame frameSource's
     * window draws. Several calls before that frame: the last one counts. False if it could not
     * be done; the caller moves the window through WindowManager then.
     */
    public boolean moveTo(int x, int y) {
        if (broken) return false;
        // Asked again for the same place (pages held still): frameSource draws no frame for it,
        // and a callback per frame would only go unanswered.
        if (x == lastX && y == lastY) return true;
        try {
            Object targetRoot = GET_VIEW_ROOT_IMPL.invoke(window);
            Object sourceRoot = GET_VIEW_ROOT_IMPL.invoke(frameSource);
            if (targetRoot == null || sourceRoot == null) return false;
            SurfaceControl surfaceControl = (SurfaceControl) GET_SURFACE_CONTROL.invoke(targetRoot);
            Surface barrier = (Surface) VIEW_ROOT_SURFACE.get(sourceRoot);
            if (surfaceControl == null || !surfaceControl.isValid()
                    || barrier == null || !barrier.isValid()) {
                return false;
            }
            // A render thread that never draws would leave the window where it is for good.
            if (unanswered.incrementAndGet() > MAX_UNANSWERED) {
                broken = true;
                Log.w(TAG, "frame callbacks do not come, moves go through WindowManager");
                return false;
            }
            final int gen = generation.get();
            InvocationHandler handler = (proxy, method, args) -> {
                switch (method.getName()) {
                    case "onFrameDraw":
                        unanswered.set(0);
                        apply(surfaceControl, barrier, (Long) args[0], x, y, gen);
                        return null;
                    case "hashCode":
                        return System.identityHashCode(proxy);
                    case "equals":
                        return proxy == args[0];
                    case "toString":
                        return "WindowSurfaceMover.FrameCallback";
                    default:
                        return null;
                }
            };
            Object callback = Proxy.newProxyInstance(WindowSurfaceMover.class.getClassLoader(),
                    new Class<?>[]{FRAME_DRAWING_CALLBACK}, handler);
            REGISTER_RT_FRAME_CALLBACK.invoke(sourceRoot, callback);
            lastX = x;
            lastY = y;
            return true;
        } catch (ReflectiveOperationException | RuntimeException e) {
            broken = true;
            Log.w(TAG, "moveTo failed, moves go through WindowManager: " + e);
            return false;
        }
    }

    /** Main thread: moves asked for so far are not applied any more if their frame is still to come. */
    public void cancel() {
        generation.incrementAndGet();
        unanswered.set(0);
        lastX = Integer.MIN_VALUE;
        lastY = Integer.MIN_VALUE;
    }

    /**
     * Main thread: puts the window's surface at (x, y) at once, not with a frame of frameSource,
     * and drops the moves still waiting for theirs (one of them would put it back). For the end of
     * a series of moves, when frameSource stops drawing. False if it could not be done.
     */
    public boolean moveNow(int x, int y) {
        cancel();
        if (broken) return false;
        try {
            Object targetRoot = GET_VIEW_ROOT_IMPL.invoke(window);
            if (targetRoot == null) return false;
            SurfaceControl surfaceControl = (SurfaceControl) GET_SURFACE_CONTROL.invoke(targetRoot);
            if (surfaceControl == null || !surfaceControl.isValid()) return false;
            SurfaceControl.Transaction t = new SurfaceControl.Transaction();
            SET_POSITION.invoke(t, surfaceControl, (float) x, (float) y);
            t.apply();
            lastX = x;
            lastY = y;
            return true;
        } catch (ReflectiveOperationException | RuntimeException e) {
            broken = true;
            Log.w(TAG, "moveNow failed: " + e);
            return false;
        }
    }

    /** On a render thread worker, for the frame of frameSource's window with this number. */
    private void apply(SurfaceControl surfaceControl, Surface barrier, long frame, int x, int y,
            int gen) {
        if (gen != generation.get() || !surfaceControl.isValid() || !barrier.isValid()) return;
        try {
            SurfaceControl.Transaction t = new SurfaceControl.Transaction();
            DEFER_UNTIL_SURFACE.invoke(t, surfaceControl, barrier, frame);
            SET_POSITION.invoke(t, surfaceControl, (float) x, (float) y);
            t.apply();
        } catch (ReflectiveOperationException | RuntimeException e) {
            broken = true;
            Log.w(TAG, "apply failed: " + e);
        }
    }
}
