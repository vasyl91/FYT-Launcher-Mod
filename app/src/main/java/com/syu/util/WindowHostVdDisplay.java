package com.syu.util;

import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import android.view.Display;
import android.view.InputEvent;
import android.view.Surface;

import com.syu.vdhost.VdHostProtocol;

/**
 * A VirtualDisplay owned by the VD host, as seen from the launcher.
 *
 * Sits in WindowHostVdView.mVirtualDisplay, where Android 10's ActivityView keeps its
 * VirtualDisplay, and offers the methods WindowHost* call on that one by reflection:
 * getDisplay(), resize(int, int, int) and setDisplayState(boolean).
 */
public final class WindowHostVdDisplay {
    private static final String TAG = "WindowHostVdDisplay";

    private final VdHostProtocol.Proxy mHost;
    private final int mDisplayId;
    private final DisplayManager mDisplayManager;
    private volatile int mWidth;
    private volatile int mHeight;
    private volatile int mDensityDpi;
    private volatile boolean mReleased;
    /** The app last started on this display; it travels with the display (see WindowHostVdView). */
    private volatile String mPackage;

    private static final Handler MAIN = new Handler(Looper.getMainLooper());
    private final Runnable mDisplayOff = () -> setDisplayState(false);

    WindowHostVdDisplay(Context ctx, VdHostProtocol.Proxy host, int displayId, int width, int height, int densityDpi) {
        mHost = host;
        mDisplayId = displayId;
        mDisplayManager = ctx.getApplicationContext().getSystemService(DisplayManager.class);
        mWidth = width;
        mHeight = height;
        mDensityDpi = densityDpi;
    }

    public int getDisplayId() {
        return mDisplayId;
    }

    /** The display as the launcher sees it; null once released (or if it were not public). */
    public Display getDisplay() {
        if (mReleased || mDisplayManager == null) return null;
        return mDisplayManager.getDisplay(mDisplayId);
    }

    int getWidth() {
        return mWidth;
    }

    int getHeight() {
        return mHeight;
    }

    boolean isReleased() {
        return mReleased;
    }

    String getPackage() {
        return mPackage;
    }

    void setPackage(String pkg) {
        mPackage = pkg;
    }

    /** Whether this display still lives on the given host (a replaced host took its displays along). */
    boolean isOn(VdHostProtocol.Proxy host) {
        return !mReleased && host != null && host.asBinder() == mHost.asBinder();
    }

    public void resize(int width, int height, int densityDpi) {
        if (mReleased || width <= 0 || height <= 0) return;
        if (width == mWidth && height == mHeight && densityDpi == mDensityDpi) return;
        try {
            mHost.resize(mDisplayId, width, height, densityDpi);
            mWidth = width;
            mHeight = height;
            mDensityDpi = densityDpi;
        } catch (RemoteException | RuntimeException e) {
            Log.w(TAG, "resize " + mDisplayId + " failed", e);
        }
    }

    /**
     * Turns the display off after graceMs unless it is turned on again before: a pane swap or a
     * rebuild hand-over detaches the view only for a moment, and switching the display off and on
     * in between stopped and restarted the embedded app every time.
     */
    void setDisplayStateOffSoon(long graceMs) {
        if (mReleased) return;
        MAIN.removeCallbacks(mDisplayOff);
        MAIN.postDelayed(mDisplayOff, graceMs);
    }

    public void setDisplayState(boolean on) {
        MAIN.removeCallbacks(mDisplayOff);
        if (mReleased) return;
        try {
            mHost.setDisplayState(mDisplayId, on);
        } catch (RemoteException | RuntimeException e) {
            Log.w(TAG, "setDisplayState " + mDisplayId + " failed", e);
        }
    }

    public void setSurface(Surface surface) {
        if (mReleased) return;
        try {
            mHost.setSurface(mDisplayId, surface);
        } catch (RemoteException | RuntimeException e) {
            Log.w(TAG, "setSurface " + mDisplayId + " failed", e);
        }
    }

    public void release() {
        MAIN.removeCallbacks(mDisplayOff);
        if (mReleased) return;
        mReleased = true;
        WindowHostVdClient.noteDisplay(mDisplayId, false);
        try {
            mHost.releaseDisplay(mDisplayId);
        } catch (RemoteException | RuntimeException e) {
            Log.w(TAG, "release " + mDisplayId + " failed", e);
        }
    }

    /** The host died with the display; nothing left to release. */
    void markDead() {
        MAIN.removeCallbacks(mDisplayOff);
        mReleased = true;
        WindowHostVdClient.noteDisplay(mDisplayId, false);
    }

    void injectInput(InputEvent event) {
        if (mReleased) return;
        try {
            mHost.injectInput(mDisplayId, event);
        } catch (RemoteException | RuntimeException e) {
            Log.w(TAG, "injectInput " + mDisplayId + " failed", e);
        }
    }

    /** @return the ActivityManager start result, >= 0 on success */
    int startActivity(Intent intent, Bundle options) throws RemoteException {
        return mHost.startActivity(mDisplayId, intent, options);
    }
}
