package com.android.launcher66;

import android.content.Intent;
import android.os.Looper;
import com.android.launcher66.settings.FabOverlayService;
import com.android.launcher66.settings.Keys;
import com.syu.util.WindowUtil;

/**
 * The PiP swap buttons: whether they are configured, when FabOverlayService may show them (only
 * together with the panes) and starting it once the boot stall is over. Split out of Launcher,
 * which keeps showOverlayFab(), hideOverlayFab() and canShowOverlayFab() for WindowUtil and the
 * service.
 */
final class LauncherFab {

    private final Launcher mLauncher;

    LauncherFab(Launcher launcher) {
        mLauncher = launcher;
    }

    /** The overlay step has been asked for the swap buttons; see onPostResume(). */
    static boolean sOverlayStepArmedForFab = false;

    boolean checkIfFloatingButton() {
        boolean floatingBtn = mLauncher.mPrefs.getBoolean(Keys.FAB_OVERLAY_BUTTON, false);
        boolean floatingBtnLeft = mLauncher.mPrefs.getBoolean(Keys.FAB_OVERLAY_BUTTON_LEFT, false);
        boolean floatingBtnRight = mLauncher.mPrefs.getBoolean(Keys.FAB_OVERLAY_BUTTON_RIGHT, false);
        if (!floatingBtn && !floatingBtnLeft && !floatingBtnRight) return false;
        String firstPkg = mLauncher.mPrefs.getString(Keys.PIP_FIRST_PACKAGE, "");
        String secondPkg = mLauncher.mPrefs.getString(Keys.PIP_SECOND_PACKAGE, "");
        String thirdPkg = mLauncher.mPrefs.getString(Keys.PIP_THIRD_PACKAGE, "");
        String fourthPkg = mLauncher.mPrefs.getString(Keys.PIP_FOURTH_PACKAGE, "");

        if (!firstPkg.isEmpty() && !secondPkg.isEmpty() && !thirdPkg.isEmpty() && !fourthPkg.isEmpty()) {
            return true;
        } else return false;
    }

    /**
     * FabOverlayService adds up to three overlay windows on the main thread, and a new window
     * needs a relayout from system_server on its first traversal. Started 0.4 s after the boot
     * resume, that relayout waited out the whole boot-time stall and froze the launcher for 12 s
     * (capture 29-09-2026 08:09: IWindowSession.relayout, with the workspace binding queued
     * behind it). The buttons control the panes, which only come up after the stall anyway, so
     * at boot the service starts once the stall is over; otherwise at once, as before.
     */
    void startFabOverlayServiceAfterBootStall() {
        mLauncher.mHandler.removeCallbacks(mDeferredFabStart);
        long wait = Launcher.bootStallDelayMs();
        if (wait > 0L) {
            mLauncher.mHandler.postDelayed(mDeferredFabStart, wait);
            return;
        }
        startFabOverlayService();
    }

    final Runnable mDeferredFabStart = () -> {
        // Paused (or gone) by then: the next onResume() starts it.
        if (mLauncher.mPaused || mLauncher.isDestroyed() || mLauncher.isFinishing()) return;
        mLauncher.floatingButton = checkIfFloatingButton();
        if (mLauncher.floatingButton && mLauncher.hasOverlayPermission()) {
            startFabOverlayService();
        }
    };

    /**
     * Starts FabOverlayService, or brings its buttons back if it is already running - but only
     * while a PiP is on the screen (see canShowOverlayFab()). Otherwise the buttons are hidden.
     */
    void startFabOverlayService() {
        if (!canShowOverlayFab()) {
            // E.g. back from an app that showed no window of its own, with the app drawer still
            // open: there is no pane, and none is coming. WindowUtil calls showOverlayFab() once
            // it has added the panes again.
            hideOverlayFab();
            return;
        }
        if (!Launcher.isServiceRunning(FabOverlayService.class)) {
            Intent serviceIntent = new Intent(LauncherApplication.sApp, FabOverlayService.class);
            if (ServiceIntentGate.startIfAvailable(mLauncher, serviceIntent, "fab overlay")) {
                Launcher.setServiceRunningCache(FabOverlayService.class, true);
            }
        } else {
            SysCalls.sendBroadcast(mLauncher, new Intent(Keys.SHOW_FAB));
        }
    }

    /**
     * The swap buttons act on the PiP panes, so they belong on the screen only together with them:
     * the launcher resumed on the home screen (the app drawer, the widget list and overview mode
     * all remove the panes), the user layout with PiP enabled (the only case in which WindowUtil
     * adds panes at all), and the panes actually added (WindowUtil.isPipOnScreen()).
     * <p>
     * onPostResume() used to show the buttons on every resume. Starting an app that shows no
     * window of its own from the app drawer pauses and resumes the launcher with the drawer still
     * open: onResume() removed the panes again, and onPostResume() still brought the buttons up.
     * <p>
     * Main thread only. FabOverlayService asks it as well, when it is created.
     */
    public boolean canShowOverlayFab() {
        if (mLauncher.mPaused || mLauncher.isFinishing() || mLauncher.isDestroyed() || mLauncher.mWorkspace == null || mLauncher.mPrefs == null) {
            return false;
        }
        if (mLauncher.mState != Launcher.State.WORKSPACE || mLauncher.isAllAppsVisible() || mLauncher.mWorkspace.isInOverviewMode()) {
            return false;
        }
        if (!mLauncher.mPrefs.getBoolean(Keys.USER_LAYOUT, false) || !mLauncher.mPrefs.getBoolean(Keys.DISPLAY_PIP, true)) {
            return false;
        }
        return WindowUtil.isPipOnScreen();
    }

    /**
     * Shows the PiP swap buttons. WindowUtil calls this once it has added the panes. Ignored while
     * canShowOverlayFab() sees no PiP on the screen, which also covers a call that is still
     * pending when the app drawer opens or the launcher is paused.
     * <p>
     * Starts FabOverlayService if it is not running yet: onPostResume() no longer starts it while
     * the panes are still coming up (at boot, or after recreateView() has stopped it).
     */
    public void showOverlayFab() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            mLauncher.mHandler.post(this::showOverlayFab);
            return;
        }
        if (!canShowOverlayFab()) {
            return;
        }
        if (Launcher.isServiceRunning(FabOverlayService.class)) {
            SysCalls.sendBroadcast(mLauncher, new Intent(Keys.SHOW_FAB));
            return;
        }
        mLauncher.floatingButton = checkIfFloatingButton();
        if (mLauncher.floatingButton && mLauncher.hasOverlayPermission()) {
            startFabOverlayServiceAfterBootStall();
        }
    }

    public void hideOverlayFab() {
        Intent intent = new Intent(Keys.HIDE_FAB);
        SysCalls.sendBroadcast(mLauncher, intent);
    }
}
