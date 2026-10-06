package com.android.launcher66;

import android.os.SystemClock;
import com.android.launcher66.settings.FytRating;
import com.android.launcher66.settings.Keys;
import com.android.launcher66.settings.WakeDetectionService;
import com.syu.util.WindowHost;
import com.syu.util.WindowUtil;
import com.syu.widget.Widget;

/**
 * What the launcher itself does after the device wakes: the widget bar refresh WakeDetectionService
 * asks for, and waking the fYT Rating bridge once the panes are up. The layout repair passes of a
 * wake are in HomeLayoutRecovery. Split out of Launcher.
 */
final class LauncherWake {

    // Not final: field initializers below use it in lambdas, which javac rejects for a blank final.
    private Launcher mLauncher;

    LauncherWake(Launcher launcher) {
        mLauncher = launcher;
    }

    /**
     * Widget bar repair after a wake. Scheduled both from the WAKE_REFRESH broadcast and directly
     * from WakeDetectionService, because the dynamic receiver is unregistered in onStop() and the
     * broadcast is lost whenever the launcher is still stopped when it is sent. If the launcher
     * cannot act yet (paused), the pending flag makes onResume() finish the job.
     */
    static final long WIDGET_BAR_WAKE_REFRESH_DELAY_MS = 700L;

    Runnable mWidgetBarWakeRefreshRunnable;

    boolean mWidgetBarWakeRefreshPending = false;

    /**
     * Direct entry point for WakeDetectionService. Does not depend on the dynamic receiver,
     * which is unregistered while the launcher is stopped.
     */
    public void onDeviceWake(String source) {
        scheduleWidgetBarWakeRefresh(source == null ? "wakeService" : source);
    }

    void scheduleWidgetBarWakeRefresh(String source) {
        mWidgetBarWakeRefreshPending = true;
        if (mWidgetBarWakeRefreshRunnable != null) {
            mLauncher.mHandler.removeCallbacks(mWidgetBarWakeRefreshRunnable);
        }
        mWidgetBarWakeRefreshRunnable = () -> {
            mWidgetBarWakeRefreshRunnable = null;
            if (mLauncher.mPaused || mLauncher.mWorkspace == null || mLauncher.isAppsCustomizeVisibleOrOpening()) {
                // Keep the pending flag - onResume() schedules the refresh again.
                return;
            }
            mWidgetBarWakeRefreshPending = false;
            mLauncher.mWorkspace.refreshWidgetBarAfterWake(source);
        };
        mLauncher.mHandler.postDelayed(mWidgetBarWakeRefreshRunnable, WIDGET_BAR_WAKE_REFRESH_DELAY_MS);
    }

    /**
     * FytRating.wakeIfNeeded() starts vasyl.fytrating/.WakeActivity. It draws nothing and finishes
     * in onCreate(), but starting any activity still takes the top: the launcher loses its
     * top-resumed state and is paused until that activity is gone. Called first thing in onResume()
     * it did exactly that on every wake -- about 735 ms with the launcher paused, during which
     * allowPip is false and the panes cannot be built. Nothing about the wake depends on it being
     * immediate, so it now waits for the PiP rebuild to finish.
     */
    static final long FYT_RATING_WAKE_DELAY_MS = 1500L;

    static final long FYT_RATING_WAKE_RECHECK_MS = 400L;

    static final int  FYT_RATING_WAKE_MAX_WAITS = 12;

    /**
     * At a cold boot the wake waits until this uptime. Right after the boot-time stall the pane
     * apps are still cold-starting (YouTube's onCreate alone took 8 s, capture 29-09-2026 08:09),
     * and fYT Rating, woken into that at 45 s, did not answer its status request within 8 s.
     * Nothing needs it earlier.
     */
    static final long FYT_RATING_BOOT_UPTIME_MS = 90_000L;

    int mFytRatingWakeWaits = 0;

    final Runnable mFytRatingWake = new Runnable() {
        @Override
        public void run() {
            // Paused again (or gone): the next onResume() reschedules it.
            if (mLauncher.mPaused || mLauncher.isDestroyed() || mLauncher.isFinishing()) return;

            // When the bridge is woken by the status broadcast alone, nothing is paused and the
            // waits below only delayed it: YouTube's like state came 80 s into a cold boot
            // (capture 06-10 03:28). Only the boot stall is still waited out.
            boolean byBroadcast = FytRating.wakesByBroadcast();
            // Starting an activity is a call into system_server too: at boot, after the stall and
            // after the pane apps' cold starts (see FYT_RATING_BOOT_UPTIME_MS).
            long bootWait = byBroadcast ? Launcher.bootStallDelayMs() : Math.max(Launcher.bootStallDelayMs(),
                    FYT_RATING_BOOT_UPTIME_MS - SystemClock.elapsedRealtime());
            if (bootWait > 0L) {
                mLauncher.mHandler.postDelayed(this, bootWait);
                return;
            }
            if (!byBroadcast && arePanesStillComing() && mFytRatingWakeWaits < FYT_RATING_WAKE_MAX_WAITS) {
                mFytRatingWakeWaits++;
                mLauncher.mHandler.postDelayed(this, FYT_RATING_WAKE_RECHECK_MS);
                return;
            }
            mFytRatingWakeWaits = 0;
            FytRating.wakeIfNeeded(mLauncher);
        }
    };

    /**
     * Panes are configured but not up yet. isPipRebuildInProgress() alone missed the gap between
     * onResume() and the start of the rebuild: at boot the wake fired right there, paused the
     * launcher, and the rebuild that followed had to retry and dismissed a pane (capture 23:13,
     * 40.777). Same expectations as WakeDetectionService.isPipExpected().
     */
    boolean arePanesStillComing() {
        if (WindowUtil.isPipRebuildInProgress()) return true;
        if (!mLauncher.mPrefs.getBoolean(Keys.DISPLAY_PIP, true)) return false;
        boolean anyPane = mLauncher.mPrefs.getBoolean(Keys.PIP_DUAL, false)
                || mLauncher.mPrefs.getBoolean(Keys.PIP_FIRST, false)
                || mLauncher.mPrefs.getBoolean(Keys.PIP_SECOND, false)
                || mLauncher.mPrefs.getBoolean(Keys.PIP_THIRD, false)
                || mLauncher.mPrefs.getBoolean(Keys.PIP_FOURTH, false);
        if (!anyPane) return false;
        WindowHost host = WindowUtil.getActiveWindowHost();
        return host == null || host.isAnyPaneAwaitingBounds();
    }

    void scheduleFytRatingWake() {
        mLauncher.mHandler.removeCallbacks(mFytRatingWake);
        mFytRatingWakeWaits = 0;
        mLauncher.mHandler.postDelayed(mFytRatingWake, FYT_RATING_WAKE_DELAY_MS);
    }
}
