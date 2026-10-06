package com.android.launcher66;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.launcher66.settings.Keys;
import com.syu.util.WindowUtil;

/**
 * Keeps the home screen whole: after a home press, a focus change or a wake it checks the
 * workspace, hotseat, app bars and custom elements, repairs what it can and retries for a while
 * (the home layout watchdog, the wake home recovery and the wake layout repair passes).
 * Split out of Launcher, whose views and state it works on.
 */
final class HomeLayoutRecovery {

    private final Launcher mLauncher;

    HomeLayoutRecovery(Launcher launcher) {
        mLauncher = launcher;
    }

    static final long WAKE_HOME_RECOVERY_WINDOW_MS = 30000L;

    static final long FOCUS_HOME_RECOVERY_THROTTLE_MS = 1200L;

    static final int MAX_HOME_LAYOUT_HEALTH_RETRIES = 8;

    static final long HOME_LAYOUT_HEALTH_FIRST_RETRY_MS = 900L;

    static final long HOME_LAYOUT_HEALTH_RETRY_MS = 300L;

    /** Cheap re-checks while the model is still binding; see isHomeLayoutInitPending(). */
    static final long HOME_LAYOUT_INIT_WAIT_MS = 400L;

    long mHomeRecoveryInitWaitUntil = 0L;

    static final long HOME_LAYOUT_WATCHDOG_DELAY_MS = 350L;

    boolean mWakeHomeRecoveryPending = false;

    long mLastWakeRefreshMs = 0L;

    long mLastFocusHomeRecoveryMs = 0L;

    Runnable mWakeHomeRecoveryRunnable;

    Runnable mHomeLayoutWatchdogRunnable;

    void cancelHomeLayoutWatchdog() {
        if (mHomeLayoutWatchdogRunnable != null) {
            mLauncher.mHandler.removeCallbacks(mHomeLayoutWatchdogRunnable);
            mHomeLayoutWatchdogRunnable = null;
        }
    }

    void cancelWakeHomeRecovery(String source) {
        boolean hadPendingRecovery = mWakeHomeRecoveryPending || mWakeHomeRecoveryRunnable != null;
        if (mWakeHomeRecoveryRunnable != null) {
            mLauncher.mHandler.removeCallbacks(mWakeHomeRecoveryRunnable);
            mWakeHomeRecoveryRunnable = null;
        }
        mWakeHomeRecoveryPending = false;
        if (hadPendingRecovery) {
            Log.d(Launcher.TAG, "Wake home recovery cancelled: " + source);
        }
    }

    boolean refreshWorkspaceAfterHome() {
        if (mLauncher.mWorkspace == null) {
            return false;
        }

        if (mLauncher.mState != Launcher.State.WORKSPACE) {
            mLauncher.showWorkspace(false, null);
        } else if (mLauncher.mWorkspace.isInOverviewMode()) {
            mLauncher.mWorkspace.exitOverviewMode(false);
            mLauncher.helpers.setInOverviewMode(false);
        }

        mLauncher.mWorkspace.setVisibility(View.VISIBLE);
        mLauncher.mWorkspace.requestLayout();
        mLauncher.mWorkspace.invalidate();

        if (mLauncher.mAppsCustomizeTabHost != null) {
            mLauncher.mAppsCustomizeTabHost.setVisibility(View.GONE);
        }
        mLauncher.showHotseat(false, true);
        mLauncher.updateWallpaperVisibility(true);
        forceWorkspaceLayoutPass();
        return true;
    }

    void repairLayoutAfterWake(String phase) {
        String wakePhase = phase == null ? "unknown" : phase;
        mWakeHomeRecoveryPending = true;
        mLastWakeRefreshMs = SystemClock.uptimeMillis();
        Log.d(Launcher.TAG, "Wake layout repair: " + wakePhase);
        runWakeHomeRecoveryPass("wake:" + wakePhase + ":now");
        scheduleWakeLayoutRepair(250L, wakePhase);
        scheduleWakeHomeRecoveryRetry("wake:" + wakePhase, 0, HOME_LAYOUT_HEALTH_FIRST_RETRY_MS);
        mLauncher.mDeviceWake.scheduleWidgetBarWakeRefresh("wake:" + wakePhase);
    }

    void scheduleWakeLayoutRepair(long delayMs, String phase) {
        Runnable repair = () -> {
            if (mLauncher.mPaused || mLauncher.mWorkspace == null) {
                mWakeHomeRecoveryPending = true;
                return;
            }
            Log.d(Launcher.TAG, "Wake layout repair pass: " + phase + " +" + delayMs + "ms");
            boolean healthy = runWakeHomeRecoveryPass("wakeLayout:" + phase + "+" + delayMs);
            if (!healthy) {
                scheduleWakeHomeRecoveryRetry("wakeLayout:" + phase + "+" + delayMs, 0,
                        HOME_LAYOUT_HEALTH_RETRY_MS);
            }
        };
        mLauncher.mHandler.postDelayed(repair, delayMs);
    }

    boolean shouldRunWakeHomeRecovery() {
        if (mWakeHomeRecoveryPending) {
            return true;
        }
        return mLastWakeRefreshMs > 0L
                && SystemClock.uptimeMillis() - mLastWakeRefreshMs <= WAKE_HOME_RECOVERY_WINDOW_MS;
    }

    void scheduleWakeHomeRecovery(String source) {
        if (mLauncher.mWorkspace == null) {
            mWakeHomeRecoveryPending = true;
            return;
        }
        if (mWakeHomeRecoveryRunnable != null) {
            mLauncher.mHandler.removeCallbacks(mWakeHomeRecoveryRunnable);
            mWakeHomeRecoveryRunnable = null;
        }
        mHomeRecoveryInitWaitUntil = SystemClock.uptimeMillis() + Launcher.HOME_RECOVERY_INIT_WAIT_MAX_MS;
        if (isHomeLayoutInitPending()) {
            // The model is still binding (or the custom elements are on their way): a repair
            // pass now cannot attach anything and only adds layout work to the busiest moment of
            // a cold start. The retry below waits for the end cheaply and checks then.
            mWakeHomeRecoveryPending = true;
            scheduleWakeHomeRecoveryRetry(source, 0, HOME_LAYOUT_INIT_WAIT_MS);
            return;
        }
        runWakeHomeRecoveryPass(source + ":now");
        scheduleWakeHomeRecoveryRetry(source, 0, HOME_LAYOUT_HEALTH_FIRST_RETRY_MS);
    }

    /**
     * True while the layout cannot be judged yet because app data has not been attached.
     *
     * isRecyclerViewHealthy() reports "recycler has no adapter" until initAppData() runs, and that
     * only happens once the model has finished binding. Nothing runWakeHomeRecoveryPass() does can
     * attach an adapter, so retrying against it burned eight full repair passes -- measured as
     * 3.5 s of continuous main-thread layout work, overlapping the PiP rebuild.
     */
    boolean isHomeLayoutInitPending() {
        if (mLauncher.mWorkspaceLoading) return true;
        if (AllAppsList.data == null || AllAppsList.data.isEmpty()) return true;
        if (isCustomElementsSetupInFlight()) return true;
        if (mLauncher.mWorkspace == null || mLauncher.mPrefs == null) return false;
        if (mLauncher.mPrefs.getBoolean(Keys.AUTO_HIDE_BOTTOM_BAR, false)) return false;

        RecyclerView recycler = (RecyclerView) mLauncher.mWorkspace.findViewById(R.id.recycler_view);
        return recycler != null && recycler.getAdapter() == null;
    }

    /**
     * A custom elements setup is queued here or in a CellLayout and has not added the elements yet.
     * A repair pass in that window cannot help (see isHomeLayoutInitPending()); and the urgent
     * retry the layout check sends used to restart a setup whose add was already queued, so
     * addWidgetsToAllExistingPages() and stripEmptyScreens() ran two or three times in a row
     * (CellLayout.triggerAddCustomElements() now ignores it then).
     */
    boolean isCustomElementsSetupInFlight() {
        if (mLauncher.mCustomElementsSetupRunnable != null || mLauncher.mCustomElementsSetupAfterBind) {
            return true;
        }
        if (mLauncher.mWorkspace == null) {
            return false;
        }
        for (int i = 0; i < mLauncher.mWorkspace.getChildCount(); i++) {
            View child = mLauncher.mWorkspace.getChildAt(i);
            if (child instanceof CellLayout && ((CellLayout) child).isCustomElementSetupPending()) {
                return true;
            }
        }
        return false;
    }

    void scheduleWakeHomeRecoveryRetry(String source, int attempt, long delayMs) {
        if (attempt >= MAX_HOME_LAYOUT_HEALTH_RETRIES) {
            mWakeHomeRecoveryPending = !isLauncherLayoutHealthy(source + ":max");
            if (mWakeHomeRecoveryPending) {
                Log.w(Launcher.TAG, "Wake home recovery stopped with unhealthy layout: " + source);
            }
            return;
        }
        if (mWakeHomeRecoveryRunnable != null) {
            mLauncher.mHandler.removeCallbacks(mWakeHomeRecoveryRunnable);
        }
        mWakeHomeRecoveryPending = true;
        mWakeHomeRecoveryRunnable = () -> {
            mWakeHomeRecoveryRunnable = null;

            // Wait it out cheaply rather than running a repair pass that cannot help, and do not
            // spend a retry attempt on it.
            if (isHomeLayoutInitPending() && SystemClock.uptimeMillis() < mHomeRecoveryInitWaitUntil) {
                mWakeHomeRecoveryPending = true;
                scheduleWakeHomeRecoveryRetry(source, attempt, HOME_LAYOUT_INIT_WAIT_MS);
                return;
            }

            boolean healthy = runWakeHomeRecoveryPass(source + ":retry" + attempt);
            if (!healthy) {
                scheduleWakeHomeRecoveryRetry(source, attempt + 1, HOME_LAYOUT_HEALTH_RETRY_MS);
            }
        };
        mLauncher.mHandler.postDelayed(mWakeHomeRecoveryRunnable, delayMs);
    }

    boolean runWakeHomeRecoveryPass(String source) {
        if (mLauncher.mPaused || mLauncher.mWorkspace == null) {
            mWakeHomeRecoveryPending = true;
            return false;
        }
        if (mLauncher.isAppsCustomizeVisibleOrOpening()) {
            cancelWakeHomeRecovery("overlay:" + source);
            return true;
        }
        refreshWorkspaceAfterHome();
        repairWorkspaceChromeAfterHome(source);
        forceWorkspaceLayoutPass();
        WindowUtil.updatePipPositionsForScroll(mLauncher.mWorkspace.mUnboundedScrollX);
        boolean healthy = isLauncherLayoutHealthy(source);
        mWakeHomeRecoveryPending = !healthy;
        if (!healthy) {
            Log.w(Launcher.TAG, "Wake home recovery layout still unhealthy: " + source);
        }
        return healthy;
    }

    boolean isLauncherLayoutHealthy(String source) {
        if (mLauncher.mWorkspace == null) {
            return false;
        }

        boolean healthy = true;
        View decor = mLauncher.getWindow() != null ? mLauncher.getWindow().getDecorView() : null;
        healthy &= isRootViewSizeHealthy(decor, "decor", source);
        healthy &= isRootViewSizeHealthy(mLauncher.mWorkspace, "workspace", source);
        if (mLauncher.mDragLayer != null) {
            healthy &= isRootViewSizeHealthy(mLauncher.mDragLayer, "dragLayer", source);
        }
        if (shouldValidateHotseatForHealth()) {
            healthy &= isMeasuredViewHealthy(mLauncher.mHotseat, "hotseat", source);
        }
        if (mLauncher.mWorkspace.getVisibility() != View.VISIBLE) {
            Log.w(Launcher.TAG, "Layout unhealthy: workspace hidden during " + source);
            healthy = false;
        }

        RecyclerView recycler = (RecyclerView) mLauncher.mWorkspace.findViewById(R.id.recycler_view);
        if (recycler != null && !mLauncher.mPrefs.getBoolean(Keys.AUTO_HIDE_BOTTOM_BAR, false)) {
            healthy &= isRecyclerViewHealthy(recycler, false, source);
        }
        RecyclerView leftRecycler = (RecyclerView) mLauncher.mWorkspace.findViewById(R.id.left_recycler_view);
        if (leftRecycler != null && mLauncher.shouldUseLeftRecycler()) {
            healthy &= isRecyclerViewHealthy(leftRecycler, true, source);
        }

        boolean customElementsHealthy = true;
        for (int i = 0; i < mLauncher.mWorkspace.getChildCount(); i++) {
            View child = mLauncher.mWorkspace.getChildAt(i);
            if (child instanceof CellLayout) {
                customElementsHealthy &= ((CellLayout) child).hasHealthyCustomElements();
            }
        }
        if (!customElementsHealthy) {
            healthy = false;
            if (isCustomElementsSetupInFlight()) {
                // Not a fault, the setup is on its way. Still hurried along: an urgent request skips
                // CellLayout's 1.5 s initial delay, and CellLayout ignores it once the add is queued.
                Log.d(Launcher.TAG, "Custom elements still being set up during " + source + ", hurrying it");
            } else {
                Log.w(Launcher.TAG, "Custom elements pending during " + source + ", scheduling widget retry");
            }
            mLauncher.requestCustomElementsHealthRetry(source);
        }
        return healthy;
    }

    /** Every configured custom element is attached, or on its way, on its page. */
    boolean areCustomElementsInPlace() {
        if (mLauncher.mWorkspace == null) {
            return false;
        }
        for (int i = 0; i < mLauncher.mWorkspace.getChildCount(); i++) {
            View child = mLauncher.mWorkspace.getChildAt(i);
            if (child instanceof CellLayout && !((CellLayout) child).hasHealthyCustomElements()) {
                return false;
            }
        }
        return true;
    }

    boolean shouldValidateHotseatForHealth() {
        if (mLauncher.mHotseat == null || mLauncher.mHotseat.getVisibility() != View.VISIBLE || mLauncher.mHotseat.getAlpha() == 0.0f) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams = mLauncher.mHotseat.getLayoutParams();
        if (layoutParams != null && (layoutParams.width == 0 || layoutParams.height == 0)) {
            return false;
        }
        return true;
    }

    boolean isRootViewSizeHealthy(View view, String label, String source) {
        if (!isMeasuredViewHealthy(view, label, source)) {
            return false;
        }
        DisplayMetrics metrics = mLauncher.getResources().getDisplayMetrics();
        int displayWidth = Math.max(Launcher.screenWidth, metrics.widthPixels);
        int displayHeight = Math.max(Launcher.screenHeight, metrics.heightPixels);
        int minWidth = Math.max(320, displayWidth / 2);
        int minHeight = Math.max(240, displayHeight / 2);
        if (view.getWidth() < minWidth || view.getHeight() < minHeight) {
            Log.w(Launcher.TAG, "Layout unhealthy: " + label + " too small "
                    + view.getWidth() + "x" + view.getHeight() + " during " + source);
            return false;
        }
        return true;
    }

    boolean isMeasuredViewHealthy(View view, String label, String source) {
        if (view == null) {
            Log.w(Launcher.TAG, "Layout unhealthy: missing " + label + " during " + source);
            return false;
        }
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            Log.w(Launcher.TAG, "Layout unhealthy: " + label + " has zero size during " + source);
            return false;
        }
        return true;
    }

    boolean isRecyclerViewHealthy(RecyclerView recycler, boolean vertical, String source) {
        if (!isMeasuredViewHealthy(recycler, vertical ? "leftRecycler" : "bottomRecycler", source)) {
            return false;
        }
        if (recycler.getAdapter() == null) {
            Log.w(Launcher.TAG, "Layout unhealthy: recycler has no adapter during " + source);
            return false;
        }
        if (recycler.getLayoutManager() == null) {
            Log.w(Launcher.TAG, "Layout unhealthy: recycler has no layout manager during " + source);
            return false;
        }
        if (recycler.getAdapter().getItemCount() > 0 && recycler.getChildCount() > 0) {
            View child = recycler.getChildAt(0);
            int childSize = vertical ? child.getHeight() : child.getWidth();
            if (childSize <= 0) {
                Log.w(Launcher.TAG, "Layout unhealthy: recycler child has zero size during " + source);
                return false;
            }
        }
        return true;
    }

    void scheduleFocusHomeRecovery(String source) {
        if (mLauncher.mWorkspace == null || mLauncher.isAppsCustomizeVisibleOrOpening()) {
            return;
        }
        if (mLauncher.mWorkspaceLoading) {
            // Mid-bind the probe can only report the recycler without its adapter (cold start,
            // return from the settings). finishBindingItems() runs the layout watchdog anyway.
            return;
        }
        if (!shouldRunWakeHomeRecovery() && isLauncherLayoutHealthy(source + ":probe")) {
            return;
        }
        long now = SystemClock.uptimeMillis();
        if (now - mLastFocusHomeRecoveryMs < FOCUS_HOME_RECOVERY_THROTTLE_MS) {
            return;
        }
        mLastFocusHomeRecoveryMs = now;
        mWakeHomeRecoveryPending = true;
        scheduleWakeHomeRecovery(source);
    }

    void scheduleHomeLayoutWatchdog(String source, boolean forceWorkspace) {
        // While the model is still binding the watchdog can only report what it cannot fix, so
        // give it enough delay to land after initAppData() instead of racing it.
        long delay = isHomeLayoutInitPending()
                ? HOME_LAYOUT_WATCHDOG_DELAY_MS + HOME_LAYOUT_INIT_WAIT_MS
                : HOME_LAYOUT_WATCHDOG_DELAY_MS;
        scheduleHomeLayoutWatchdog(source, forceWorkspace, delay);
    }

    void scheduleHomeLayoutWatchdog(String source, boolean forceWorkspace, long delayMs) {
        if (mHomeLayoutWatchdogRunnable != null) {
            mLauncher.mHandler.removeCallbacks(mHomeLayoutWatchdogRunnable);
            mHomeLayoutWatchdogRunnable = null;
        }
        mHomeLayoutWatchdogRunnable = () -> {
            mHomeLayoutWatchdogRunnable = null;
            runHomeLayoutWatchdog(source, forceWorkspace);
        };
        mLauncher.mHandler.postDelayed(mHomeLayoutWatchdogRunnable, Math.max(0L, delayMs));
    }

    void runHomeLayoutWatchdog(String source, boolean forceWorkspace) {
        if (mLauncher.mPaused) {
            if (forceWorkspace) {
                mWakeHomeRecoveryPending = true;
            }
            return;
        }
        if (mLauncher.mWorkspace == null) {
            mWakeHomeRecoveryPending = true;
            mLauncher.requestWorkspaceReloadFromRecovery("watchdog:" + source);
            return;
        }
        if (mLauncher.isAppsCustomizeVisibleOrOpening()) {
            return;
        }
        if (forceWorkspace) {
            refreshWorkspaceAfterHome();
        }
        if (!isLauncherLayoutHealthy(source + ":watchdog")) {
            mWakeHomeRecoveryPending = true;
            scheduleWakeHomeRecovery("watchdog:" + source);
        }
    }

    void repairWorkspaceChromeAfterHome(String source) {
        boolean currentUserLayout = mLauncher.mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        if (mLauncher.bottomButtons != null && mLauncher.bottomButtonsWidgets != null) {
            mLauncher.bottomButtons.setVisibility(currentUserLayout ? View.GONE : View.VISIBLE);
            mLauncher.bottomButtonsWidgets.setVisibility(currentUserLayout ? View.VISIBLE : View.GONE);
        }

        if (mLauncher.mWorkspace != null) {
            mLauncher.mWorkspace.post(() -> {
                if (mLauncher.mWorkspace == null) return;
                // Only when something is missing. Each request ends in addWidgetsToAllExistingPages()
                // and a stripEmptyScreens() pass ~2 s later, and a wake asked for it five times
                // (early, late, +250 ms, focus, retry) with every element already in place
                // ("Stats placeholder already exists", capture 05-10-2026 21:14:30-38).
                if (currentUserLayout && !areCustomElementsInPlace()) {
                    mLauncher.requestCustomElementsSetup(source);
                }
                restoreBottomRecyclerAfterHome(source);
                mLauncher.mWorkspace.requestLayout();
                mLauncher.mWorkspace.invalidate();
            });
        }

        // Rebuilding the bars when they are in place only redraws them -- the second rebuild seen
        // after the settings, run because a custom element was still on its way.
        if (areAppBarsAttached()) {
            return;
        }
        mLauncher.markAppDataDirty();
        if (mLauncher.atomicInitAppData.get()) {
            mLauncher.requestPostResumeAppDataRefresh();
        } else {
            mLauncher.triggerAppData();
        }
    }

    /** Both app bars of the current page show the adapters, and those have their apps. */
    boolean areAppBarsAttached() {
        if (mLauncher.mWorkspace == null || mLauncher.mAppListAdapter == null || mLauncher.mAppListAdapter.getItemCount() == 0) {
            return false;
        }
        RecyclerView recycler = (RecyclerView) mLauncher.mWorkspace.findViewById(R.id.recycler_view);
        if (recycler != null && recycler.getAdapter() != mLauncher.mAppListAdapter) {
            return false;
        }
        RecyclerView leftRecycler = (RecyclerView) mLauncher.mWorkspace.findViewById(R.id.left_recycler_view);
        if (leftRecycler != null && mLauncher.shouldUseLeftRecycler()
                && (mLauncher.mLeftAppListAdapter == null || leftRecycler.getAdapter() != mLauncher.mLeftAppListAdapter)) {
            return false;
        }
        return true;
    }

    void restoreBottomRecyclerAfterHome(String source) {
        if (mLauncher.mWorkspace == null) return;

        RecyclerView recycler = (RecyclerView) mLauncher.mWorkspace.findViewById(R.id.recycler_view);
        if (recycler != null) {
            mLauncher.mRecyclerView = recycler;
            mLauncher.ensureResizableBottomBar("restore:" + source);
            boolean autoHideBottomBar = mLauncher.mPrefs.getBoolean(Keys.AUTO_HIDE_BOTTOM_BAR, false);
            if (mLauncher.mAppListAdapter != null && recycler.getAdapter() != mLauncher.mAppListAdapter) {
                recycler.setAdapter(mLauncher.mAppListAdapter);
            }
            if (recycler.getLayoutManager() == null) {
                recycler.setLayoutManager(new LinearLayoutManager(mLauncher.getApplicationContext(), RecyclerView.HORIZONTAL, false));
            }
            mLauncher.installBottomRecyclerDecorations(recycler);
            recycler.clearAnimation();
            if (!autoHideBottomBar) {
                recycler.setVisibility(View.VISIBLE);
            }
            recycler.setEnabled(true);
            recycler.setClickable(true);
            recycler.setLongClickable(true);
            mLauncher.refreshRecyclerDecorationsAfterLayout(recycler);
        }

        RecyclerView leftRecycler = (RecyclerView) mLauncher.mWorkspace.findViewById(R.id.left_recycler_view);
        if (leftRecycler != null && mLauncher.shouldUseLeftRecycler()) {
            if (mLauncher.mLeftAppListAdapter != null && leftRecycler.getAdapter() != mLauncher.mLeftAppListAdapter) {
                leftRecycler.setAdapter(mLauncher.mLeftAppListAdapter);
            }
            if (!(leftRecycler.getLayoutManager() instanceof Launcher.EvenVerticalLayoutManager)) {
                leftRecycler.setLayoutManager(
                        new Launcher.EvenVerticalLayoutManager(mLauncher.getApplicationContext(), Launcher.MAX_LEFT));
            }
            mLauncher.installLeftRecyclerDecorations(leftRecycler);
            leftRecycler.clearAnimation();
            leftRecycler.setVisibility(View.VISIBLE);
        }
        Log.d(Launcher.TAG, "Wake home recycler restore: " + source);
    }

    void forceWorkspaceLayoutPass() {
        if (mLauncher.mDragLayer != null) {
            mLauncher.mDragLayer.clearAnimation();
            mLauncher.mDragLayer.requestLayout();
            mLauncher.mDragLayer.invalidate();
        }
        if (mLauncher.mWorkspace != null) {
            mLauncher.mWorkspace.clearAnimation();
            mLauncher.mWorkspace.requestLayout();
            mLauncher.mWorkspace.invalidate();
        }
        if (mLauncher.mHotseat != null) {
            mLauncher.mHotseat.clearAnimation();
            mLauncher.mHotseat.refreshLayoutAfterWake();
        }
    }
}
