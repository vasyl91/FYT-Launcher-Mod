package com.android.launcher66;

import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import com.android.launcher66.settings.Keys;
import com.syu.util.WindowHost;
import com.syu.util.WindowUtil;

/**
 * When the launcher asks WindowUtil for its PiP panes: the throttled initPip() every resume, home
 * and workspace path goes through, and the watchdog that forces the panes when they did not come
 * up. The panes themselves are built by WindowUtil and WindowHost. Split out of Launcher.
 */
final class LauncherPipStarter {

    // Not final: field initializers below use it in lambdas, which javac rejects for a blank final.
    private Launcher mLauncher;

    LauncherPipStarter(Launcher launcher) {
        mLauncher = launcher;
    }

    static final long PIP_INIT_THROTTLE_MS = 700L;

    static final long PIP_WATCHDOG_DELAY_MS = 1200L;

    static final int  PIP_WATCHDOG_MAX_RETRIES = 2;

    boolean mPipInitPending = false;

    long mLastPipInitMs = 0L;

    Runnable mPipWatchdogRunnable;

    int mPipWatchdogRetries = 0;

    void schedulePipWatchdog(String source) {
        cancelPipWatchdog();
        if (!mLauncher.mPrefs.getBoolean(Keys.USER_LAYOUT, false)) return;
        if (!mLauncher.mPrefs.getBoolean(Keys.DISPLAY_PIP, true)) return;

        mPipWatchdogRunnable = () -> {
            mPipWatchdogRunnable = null;
            runPipWatchdog(source);
        };
        mLauncher.mHandler.postDelayed(mPipWatchdogRunnable, PIP_WATCHDOG_DELAY_MS);
    }

    public void cancelPipWatchdog() {
        if (mPipWatchdogRunnable != null) {
            mLauncher.mHandler.removeCallbacks(mPipWatchdogRunnable);
            mPipWatchdogRunnable = null;
        }
    }

    void runPipWatchdog(String source) {
        if (mLauncher.mPaused || mLauncher.mWorkspace == null) return;
        if (mLauncher.isAllAppsVisible()) return;
        if (mLauncher.mState != Launcher.State.WORKSPACE) return;
        if (mLauncher.helpers.isInOverviewMode() || mLauncher.helpers.isInAllApps() || mLauncher.helpers.isInWidgets()) return;
        if (mLauncher.mDragController != null && mLauncher.mDragController.isDragging()) return;

        if (WindowUtil.isPipOnScreen()) {
            mPipWatchdogRetries = 0;
            return;
        }

        if (mPipWatchdogRetries >= PIP_WATCHDOG_MAX_RETRIES) {
        Log.e(Launcher.TAG, "pipWatchdog(" + source + "): PiP still did not start after "
                + mPipWatchdogRetries + " attempts - giving up");
        mPipWatchdogRetries = 0;
        return;
        }

        mPipWatchdogRetries++;
        Log.w(Launcher.TAG, "pipWatchdog(" + source + "): PiP did not start, forcing it (attempt "
                + mPipWatchdogRetries + ")");
        mLauncher.onResumePip = false;
        mLauncher.onBackPip = false;
        mLauncher.onWorkspacePip = false;
        initPip("pipWatchdog", null, true);          

        mPipWatchdogRunnable = () -> {
            mPipWatchdogRunnable = null;
            runPipWatchdog(source + "+retry");
        };
        mLauncher.mHandler.postDelayed(mPipWatchdogRunnable, PIP_WATCHDOG_DELAY_MS);
    }

    boolean initPip(String whereInitiated, View view, boolean forceOpen) {
        // Reopening the panes makes the players hosted there announce playback
        // on their own; that must not be taken for the user switching source.
        // Set before the throttle below, so coalesced calls still extend it.
        NotificationListener mediaListener = NotificationListener.getInstance();
        if (mediaListener != null) {
            mediaListener.suppressAutoSourceSwitch();
        }

        long now = SystemClock.uptimeMillis();
        if (!forceOpen && (mPipInitPending || now - mLastPipInitMs < PIP_INIT_THROTTLE_MS)) {
            Log.d(whereInitiated, "startMapPip coalesced");
            return false;
        }
        mPipInitPending = true;

        // mWorkspace.getCurrentPage() is determined with slight delay
        mLauncher.mHandler.postDelayed(()-> {
            mPipInitPending = false;
            boolean shouldStartPip = (mLauncher.helpers.displayStateBoolean()
                    && !mLauncher.helpers.isFirstPreferenceWindow()
                    && !mLauncher.helpers.isWallpaperWindow()
                    && !mLauncher.helpers.isInOverviewMode()
                    && !mLauncher.mDragController.isDragging()
                    && !mLauncher.helpers.allAppsVisibility(mLauncher.mAppsCustomizeTabHost.getVisibility()))
                    || (!mLauncher.helpers.userWasInRecents() && mLauncher.helpers.isListOpen() && !mLauncher.helpers.pipsAdded())
                    || forceOpen;

            if (shouldStartPip) {
                Log.d(whereInitiated, "startMapPip");
                mLastPipInitMs = SystemClock.uptimeMillis();
                WindowUtil.startMapPip(forceOpen);
            } else {
                Log.w(whereInitiated, "startMapPip SKIPPED"
                        + " display=" + mLauncher.helpers.displayStateBoolean()
                        + " prefWin=" + mLauncher.helpers.isFirstPreferenceWindow()
                        + " wallpaper=" + mLauncher.helpers.isWallpaperWindow()
                        + " overview=" + mLauncher.helpers.isInOverviewMode()
                        + " dragging=" + mLauncher.mDragController.isDragging()
                        + " allApps=" + mLauncher.helpers.allAppsVisibility(mLauncher.mAppsCustomizeTabHost.getVisibility())
                        + " wasInRecents=" + mLauncher.helpers.userWasInRecents()
                        + " listOpen=" + mLauncher.helpers.isListOpen());
            }
            mLauncher.helpers.setFirstPreferenceWindow(false);
            mLauncher.helpers.setWallpaperWindow(false);
            mLauncher.helpers.setWasInRecents(false);
        }, 250);

        return true;
    }
}
