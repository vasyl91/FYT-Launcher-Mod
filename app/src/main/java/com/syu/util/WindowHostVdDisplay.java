package com.syu.util;

import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
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

    public void setDisplayState(boolean on) {
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
