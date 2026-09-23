package com.syu.util;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.SystemProperties;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.graphics.PixelFormat;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.preference.PreferenceManager;

import com.android.launcher66.CellLayout;
import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.NotificationListener;
import com.android.launcher66.R;
import com.android.launcher66.Workspace;
import com.android.launcher66.settings.Helpers;
import com.android.launcher66.settings.Keys;
import com.fyt.thread.ThreadManager;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class WindowUtil {
    private static final String TAG = "WindowUtil";
    private static final String RESYNC_GEOMETRY_METHOD = "resyncGeometryAfterSurfaceSwap";
    private static SharedPreferences prefs;
    private static Helpers helpers;
    public static String AppPackageName = "";
    public static int delayMillis = 0;
    private static String firstPkg;
    private static String secondPkg;
    private static final Rect offscreen = new Rect(-3000, -3000, -2400, -2400);
    private static final Map<String, Rect> lastPipBounds = new HashMap<>();
    private static volatile boolean forcePipBoundsUpdate = false;
    private static final Map<View, Long> sReparentUnsettledUntil = new WeakHashMap<>();
    private static final long REPARENT_SETTLE_GRACE_MS = 250L;
    private static final Handler retryHandler = new Handler(Looper.getMainLooper());
    private static boolean pipRetryPending = false;

    /**
     * Short, bounded retries for a trigger that lands while the launcher is momentarily paused.
     *
     * During a wake the launcher resumes and pauses several times within a second while the ROM
     * brings its own activities up (three onResume and two onPause in 1.2 s in the capture).
     * onPause clears allowPip, and a startMapPip() landing in one of those gaps used to return
     * without a trace; nothing retried it until the launcher's pipWatchdog fired 1.2 s after the
     * LAST resume. That cost about two seconds per wake before any pane app was even started.
     */
    private static final int  MAX_ALLOW_PIP_RETRIES = 8;
    private static final long ALLOW_PIP_RETRY_MS = 200L;
    private static int allowPipRetries = 0;

    public static boolean dualPip = false;
    public static boolean firstPip = false;
    public static boolean secondPip = false;
    public static boolean thirdPip = false;
    public static boolean fourthPip = false;
    public static boolean firstPipPinned = false;
    public static boolean secondPipPinned = false;
    public static boolean thirdPipPinned = false;
    public static boolean fourthPipPinned = false;

    private static final int PANES_SETTLED_POLLS = 24; 

    /**
     * Whether a configured PiP package is installed.
     *
     * Helpers.isPackageInstalled() is a PackageManager query, and openMultiplePips() runs it once
     * per configured pane on the main thread immediately before the panes are built. The answer
     * only changes on install / uninstall, which the receiver below covers.
     */
    private static final Map<String, Boolean> sPackageInstalled = new ConcurrentHashMap<>();

    public static boolean isPipPackageInstalled(String pkg) {
        if (pkg == null || pkg.isEmpty()) return false;
        Boolean cached = sPackageInstalled.get(pkg);
        if (cached != null) return cached;
        boolean installed = Helpers.isPackageInstalled(pkg);
        sPackageInstalled.put(pkg, installed);
        return installed;
    }

    /** Call from the launcher's PACKAGE_ADDED / PACKAGE_REMOVED / PACKAGE_REPLACED receiver. */
    public static void invalidatePackageCaches(String pkg) {
        if (pkg == null) {
            sPackageInstalled.clear();
        } else {
            sPackageInstalled.remove(pkg);
            WindowHostSplash.invalidateIcon(pkg);
            WindowHostActivityView.invalidateLaunchCache(pkg);
        }
    }

    /**
     * Pane openings dispatched by runStaggered() but not yet started.
     *
     * WindowHost.areAllPanesRendering() reports a pane that has not been shown yet as "done",
     * because hasRenderedContent() answers true whenever the pane is not visible. Without this
     * counter the rebuild window closed while the last pane was still queued -- in the capture
     * "Panes settled" landed 80 ms before the fourth pane was even created, which released the
     * MCU channel arbitration into the middle of the launch sequence.
     */
    private static volatile int pendingPaneLaunches = 0;

    /**
     * True from the moment a rebuild is committed until its last pane has been dispatched.
     *
     * Used by WakeDetectionService so its ensure loop does not judge the panes, or reopen them,
     * while a rebuild is on its way.
     */
    public static boolean isPipRebuildInProgress() {
        final boolean hostAlive = host() != null;
        final boolean healthy = pipPanesLookHealthy();
        synchronized (OPEN_PIP_LOCK) {
            return rebuildInProgressLocked(openPipClock(), hostAlive, healthy);
        }
    }

    /**
     * Whether a rebuild is still under way. Call with OPEN_PIP_LOCK held.
     *
     * Covers the whole span, not just the dispatch: committed but not yet started, panes still
     * being queued by runStaggered(), and panes queued but not yet launched. The last case matters
     * because pipPanesLookHealthy() is false for a pane that has not called startActivity yet --
     * exactly the state a normal rebuild passes through. Bounded by OPEN_PIP_INFLIGHT_TIMEOUT_MS so
     * a rebuild that never finishes cannot block every later trigger.
     */
    private static boolean rebuildInProgressLocked(long now, boolean hostAlive, boolean panesHealthy) {
        if (openPipInFlight && now - openPipInFlightSinceMs < OPEN_PIP_INFLIGHT_TIMEOUT_MS) return true;
        if (now - lastRebuildStartedAtMs >= OPEN_PIP_INFLIGHT_TIMEOUT_MS) return false;
        if (pendingPaneLaunches > 0) return true;

        // No host means the panes are gone, not that they are being built. The launcher activity
        // can be recreated in the middle of a rebuild -- a display-scale change right after a wake
        // does exactly that -- and the panes built against the old instance die with it. Reporting
        // "in progress" there locked the recovery out for the whole timeout while the ensure loop
        // burned through its attempts, and PiP never came back.
        if (!hostAlive) return false;

        return !panesHealthy;
    }

    // -------------------------------------------------------------------------------------
    // Placeholder geometry cache
    //
    // openPip() runs from onWorkspaceShown(), which fires before the PiP placeholders have been
    // added to the CellLayouts. getPipPlaceholderPosition() then returns null, getInitialPipBounds()
    // falls back to the offscreen rect, and every pane sets startDeferredForBounds -- so the apps
    // are not launched until the workspace finishes laying out. Measured on the head unit that was
    // 1.19 s between "dual: show" and the first startActivity, and it also meant each
    // VirtualDisplay was created at the fallback size (600x600) and resized to its real size
    // afterwards, handing every embedded app a configuration change right after it started.
    //
    // The placeholder geometry is stable between runs, so it is remembered and used until the live
    // layout can answer. The signature covers everything that would invalidate it.
    // -------------------------------------------------------------------------------------
    private static final String KEY_PLACEHOLDER_CACHE = "pip_placeholder_";
    /**
     * What savePlaceholderPosition() last wrote, per pane.
     *
     * updatePipPosition() runs for all five pane types on every scroll frame. Without this guard
     * each of those frames rebuilt a signature string from half a dozen preference reads and
     * compared it against a stored string -- 300 of them a second at 60 fps, for data that only
     * changes when the user edits the layout.
     */
    private static final Map<String, int[]> lastSavedBasePos = new HashMap<>();

    /** The preference prefix CellLayout.addPipPlaceholder() reads this pane's geometry from. */
    private static String pipPreferenceKey(String pipType) {
        if (pipType == null) return "";
        switch (pipType) {
            case "dual":   return Keys.PIP_DUAL_KEY;
            case "first":  return Keys.PIP_FIRST_KEY;
            case "second": return Keys.PIP_SECOND_KEY;
            case "third":  return Keys.PIP_THIRD_KEY;
            case "fourth": return Keys.PIP_FOURTH_KEY;
            default:       return "";
        }
    }

    /**
     * Identifies the layout the cached geometry belongs to.
     *
     * It has to cover everything that changes the placeholder, not just the screen: the four corner
     * preferences the creator writes, the page the pane lives on, and the layout margin. With only
     * the display metrics in here, a pane resized in settings still matched its old cache entry, so
     * it launched at the previous size and was corrected about a second later -- handing the
     * embedded app a configuration change immediately after start, and leaving dual at the stale
     * size altogether.
     */
    private static String placeholderSignature(String pipType) {
        try {
            DisplayMetrics dm = LauncherApplication.sApp.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(dm.widthPixels).append('x').append(dm.heightPixels)
              .append('@').append(dm.densityDpi);

            if (prefs != null) {
                String pipKey = pipPreferenceKey(pipType);
                if (!pipKey.isEmpty()) {
                    sb.append('|').append(prefs.getInt(pipKey + "TopLeftX", Integer.MIN_VALUE))
                      .append(',').append(prefs.getInt(pipKey + "TopRightX", Integer.MIN_VALUE))
                      .append(',').append(prefs.getInt(pipKey + "TopLeftY", Integer.MIN_VALUE))
                      .append(',').append(prefs.getInt(pipKey + "BottomLeftY", Integer.MIN_VALUE));
                }
                sb.append('|').append(prefs.getString("layout_margin", "10"));
                sb.append('|').append(prefs.getBoolean(Keys.LEFT_BAR, false));
            }
            return sb.toString();
        } catch (Throwable t) {
            return "unknown";
        }
    }

    private static void savePlaceholderPosition(String pipType, int homeScreen, int[] basePos, int pageWidth) {
        if (prefs == null || basePos == null || basePos.length < 4 || pageWidth <= 0) return;

        // Cheap reject first: nothing below is worth doing while only the scroll offset moves.
        int[] prev = lastSavedBasePos.get(pipType);
        if (prev != null && prev.length == 6
                && prev[0] == homeScreen && prev[1] == pageWidth
                && prev[2] == basePos[0] && prev[3] == basePos[1]
                && prev[4] == basePos[2] && prev[5] == basePos[3]) {
            return;
        }
        lastSavedBasePos.put(pipType,
                new int[]{ homeScreen, pageWidth, basePos[0], basePos[1], basePos[2], basePos[3] });

        try {
            String value = placeholderSignature(pipType) + "|" + homeScreen + "," + pageWidth + ","
                    + basePos[0] + "," + basePos[1] + "," + basePos[2] + "," + basePos[3];
            if (value.equals(prefs.getString(KEY_PLACEHOLDER_CACHE + pipType, null))) return;
            prefs.edit().putString(KEY_PLACEHOLDER_CACHE + pipType, value).apply();
        } catch (Throwable ignore) {}
    }

    /** @return {x, y, w, h, pageWidth} from the last laid-out run, or null when unusable. */
    private static int[] loadPlaceholderPosition(String pipType, int expectedHomeScreen) {
        if (prefs == null) return null;
        try {
            String value = prefs.getString(KEY_PLACEHOLDER_CACHE + pipType, null);
            if (value == null) return null;

            // The signature itself contains '|', so split off exactly the trailing payload.
            int bar = value.lastIndexOf('|');
            if (bar <= 0) return null;
            if (!placeholderSignature(pipType).equals(value.substring(0, bar))) return null;

            String[] parts = value.substring(bar + 1).split(",");
            if (parts.length != 6) return null;
            if (Integer.parseInt(parts[0]) != expectedHomeScreen) return null;

            int pageWidth = Integer.parseInt(parts[1]);
            int w = Integer.parseInt(parts[4]);
            int h = Integer.parseInt(parts[5]);
            if (pageWidth <= 0 || w <= 0 || h <= 0) return null;

            return new int[]{ Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), w, h, pageWidth };
        } catch (Throwable t) {
            return null;
        }
    }

    public static void initDefaultApp() {
        if (!LauncherApplication.isFytDevice()) return;
        if (helpers == null) {
            helpers = new Helpers();
        }
        try {
            AppPackageName = SystemProperties.get("persist.launcher.packagename", "");
            if (AppPackageName == null || AppPackageName.isEmpty()) {
                if (prefs == null) {
                    prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);  
                }
                String pipFirstPackage = prefs.getString(Keys.PIP_FIRST_PACKAGE, "");
                if (Helpers.isPackageInstalled(FytPackage.GMAPS)) {
                    SystemProperties.set("persist.launcher.packagename", FytPackage.GMAPS);
                    AppPackageName = SystemProperties.get("persist.launcher.packagename", "");
                } else if (Helpers.isPackageInstalled(FytPackage.WAZE)) {
                    SystemProperties.set("persist.launcher.packagename", FytPackage.WAZE);
                    AppPackageName = SystemProperties.get("persist.launcher.packagename", "");
                } else if (!pipFirstPackage.isEmpty() && Helpers.isPackageInstalled(pipFirstPackage)) {
                    SystemProperties.set("persist.launcher.packagename", pipFirstPackage);
                    AppPackageName = SystemProperties.get("persist.launcher.packagename", "");
                } else if (Helpers.isPackageInstalled(FytPackage.GaodeACTION)) {
                    SystemProperties.set("persist.launcher.packagename", FytPackage.GaodeACTION);
                    AppPackageName = SystemProperties.get("persist.launcher.packagename", "");
                }              
            }
        } catch (Exception e) {
            String message = LauncherApplication.sApp.getString(R.string.init_default_app_error);
            Toast.makeText(LauncherApplication.sApp, message, Toast.LENGTH_LONG).show();
            Log.e(TAG, "Failed to init default app: " + e.getMessage());
        }
    }

    public static void startMapPip(final boolean show) {
        ThreadManager.getLongPool().execute(() -> WindowUtil.openPip(show));
    }

    public static void startMapPip(final boolean show, int millis) {
        delayMillis = millis;
        ThreadManager.getLongPool().execute(() -> WindowUtil.openPip(show));
    }

    /** Window in which a repeated call to openPip() with the same configuration is skipped. */
    /** Kept only for the log line below; the skip decision no longer depends on elapsed time. */
    private static final long OPEN_PIP_DEBOUNCE_MS = 4000L;
    private static volatile long lastOpenPipAtMs = 0L;
    private static volatile String lastOpenPipSignature = null;

    /**
     * Serialises the decision to rebuild.
     *
     * openPip() runs on the worker pool, and after a wake two triggers land there at the same
     * moment -- Launcher.onResume() and WakeDetectionService's ensure loop. shouldDebounceOpenPip()
     * was a plain check-then-act, so both read the old timestamp, both passed, and each went on to
     * build its own WindowHost. setHost() then kept only the second one and the first one's windows
     * were orphaned on screen: black panes with a divider that no longer follow the workspace
     * scroll, while the live panes travel over them. Everything downstream -- duplicated "show"
     * lines, "null receiver" from startActivity, a pane stuck on its splash -- followed from that.
     */
    private static final Object OPEN_PIP_LOCK = new Object();
    /** Set once a rebuild is committed, cleared when openMultiplePips() actually starts. */
    private static boolean openPipInFlight = false;
    private static long openPipInFlightSinceMs = 0L;

    /**
     * Clock for every openPip guard.
     *
     * SystemClock.uptimeMillis() does not advance while the SoC is suspended, so after the unit had
     * been asleep for a while every timestamp below still looked like it was taken moments ago.
     * With the panes left over from before the sleep, shouldDebounceOpenPip() then decided nothing
     * had changed and PiP never came back -- which is why short sleeps (no suspend, clock keeps
     * running) worked and long ones did not.
     */
    private static long openPipClock() {
        return SystemClock.elapsedRealtime();
    }
    /**
     * Upper bound on how long a rebuild may be considered "in progress".
     *
     * Only a backstop against a rebuild that never finishes -- a pane that genuinely fails is
     * recovered by the health check and the ensure loop, not by this. 3000 ms turned out to be
     * shorter than a real rebuild on a congested main thread: after a wake, "third: show" to
     * "dual: show" alone took 1956 ms, the window expired mid-rebuild, and the ensure loop's
     * openPip() dismissed panes that were still coming up. Every pane then went into the
     * black-screen restart loop -- four grey rectangles and nothing else.
     */
    private static final long OPEN_PIP_INFLIGHT_TIMEOUT_MS = 8000L;
    /** Second line of defence, inside openMultiplePips() itself. */
    private static long lastRebuildStartedAtMs = 0L;
    private static final long REBUILD_GUARD_MS = 1200L;

    /**
     * Signature of what openPip() is about to display: panel flags + packages + show mode.
     * Changing anything in the PiP settings changes the signature, so the rebuild will proceed.
     */
    private static String currentPipSignature(boolean show) {
        try {
            if (prefs == null) return null;
            return (show ? "S" : "-")
                    + "|" + prefs.getBoolean(Keys.PIP_DUAL, false)
                    + "|" + prefs.getBoolean(Keys.PIP_FIRST, false)
                    + "|" + prefs.getBoolean(Keys.PIP_SECOND, false)
                    + "|" + prefs.getBoolean(Keys.PIP_THIRD, false)
                    + "|" + prefs.getBoolean(Keys.PIP_FOURTH, false)
                    + "|" + prefs.getString(Keys.PIP_FIRST_PACKAGE, "")
                    + "|" + prefs.getString(Keys.PIP_SECOND_PACKAGE, "")
                    + "|" + prefs.getString(Keys.PIP_THIRD_PACKAGE, "")
                    + "|" + prefs.getString(Keys.PIP_FOURTH_PACKAGE, "");
        } catch (Throwable t) {
            return null;
        }
    }

    private static WindowHost host() {
        Launcher l = Launcher.getLauncher();
        return (l == null) ? null : l.getWindowHost();
    }

    private static void setHost(WindowHost host) {
        Launcher l = Launcher.getLauncher();
        if (l != null) l.setWindowHost(host);
    }

    public static WindowHost getActiveWindowHost() {
        return host();
    }

    /** Launcher.getWorkspace() is static; returns null before onCreate finishes or after onDestroy. */
    private static Workspace workspace() {
        try {
            Launcher l = Launcher.getLauncher();
            if (l != null) return l.getWorkspace();
        } catch (Throwable t) {
            return null;
        }
        return null;
    }

    /** Whether anything is still actually on the screen (not just the pipsAdded flag). */
    private static boolean panesStillOnScreen() {
        try {
            WindowHost host = host();
            if (host == null) return false;
            return host.isDualVisible()
                    || host.isFirstVisible()
                    || host.isSecondVisible()
                    || host.isThirdVisible()
                    || host.isFourthVisible();
        } catch (Throwable t) {
            return false;
        }
    }

    public static boolean isPipOnScreen() {
        try {
            if (panesStillOnScreen()) return true;     
            if (helpers != null && helpers.pipsAdded()) return true;
        } catch (Throwable ignore) { }
        return false;
    }

    /**
     * @return true if this openPip() call is a duplicate of the previous one and should be skipped.
     *         As a side effect, stores the current signature and timestamp.
     */
    private static boolean shouldDebounceOpenPip(boolean show) {
        final String sig = currentPipSignature(show);
        final long now = openPipClock();

        boolean awaitingBounds = true;
        try {
            final WindowHost h = host();
            awaitingBounds = h != null && h.isAnyPaneAwaitingBounds();
        } catch (Throwable ignore) { }
        final boolean panesHealthy = pipPanesLookHealthy();
        final boolean hostAlive = host() != null;

        synchronized (OPEN_PIP_LOCK) {
            // A rebuild that is already running must never be interrupted.
            //
            // openPipInFlight alone was not enough: it is cleared the moment openMultiplePips()
            // starts, while runStaggered() still has panes to open and the ones already shown have
            // not launched yet. pipPanesLookHealthy() is false in exactly that state, so sameLayout
            // below went false and a second trigger sailed through to dismiss(). In the capture that
            // landed 9 ms after "third: show com.spotify.music": the dismiss bumped the pane's
            // generation, its pending start died on the generation check, and because runStaggered()
            // had already moved past it nothing ever showed that pane again -- the single pane
            // stayed empty while dual and fourth came up normally.
            if (rebuildInProgressLocked(now, hostAlive, panesHealthy)) {
                String why = (openPipInFlight && now - openPipInFlightSinceMs < OPEN_PIP_INFLIGHT_TIMEOUT_MS)
                        ? "claimed " + (now - openPipInFlightSinceMs) + " ms ago by another trigger"
                        : "started " + (now - lastRebuildStartedAtMs) + " ms ago, pending=" + pendingPaneLaunches;
                Log.i(TAG, "openPip(): rebuild in progress (" + why + "), skipping this trigger");
                return true;
            }

            // No time window here on purpose.
            //
            // Identical layout + panes actually on screen means there is nothing to rebuild, no
            // matter how long ago the last open was. The 4 s window used to let a late second
            // trigger through: Launcher.onResume() opens the panes, then initializeAppList() calls
            // startMapPip() again once the app list finally arrives -- 6.5 s later in the capture --
            // and the panes were torn down and built a second time in front of the user.
            // invalidateOpenPipDebounce() is what forces a genuine re-evaluation after a wake.
            boolean sameLayout = sig != null
                    && sig.equals(lastOpenPipSignature)
                    && panesStillOnScreen()
                    && panesHealthy;

            if (sameLayout) {
                if (!awaitingBounds) {
                    Log.i(TAG, "openPip(): identical layout already up (" + (now - lastOpenPipAtMs)
                            + " ms since last open), skipping rebuild");
                    return true;
                }
                Log.i(TAG, "openPip(): panes up but awaiting bounds - pumping bounds instead of rebuilding");
                forcePipBoundsUpdate = true;
                final Launcher l = Launcher.getLauncher();
                if (l != null) l.handler.post(() -> pumpPipBoundsUntilReady(32));
                return true;
            }

            lastOpenPipSignature = sig;
            lastOpenPipAtMs = now;
            openPipInFlight = true;
            openPipInFlightSinceMs = now;
            return false;
        }
    }

    /**
     * A cheap sanity check so a broken set of panes is never mistaken for a good one.
     * Without it, dropping the debounce window would make a half-dead layout permanent.
     */
    private static boolean pipPanesLookHealthy() {
        try {
            WindowHost h = host();
            return h != null && h.areAllPanesRendering();
        } catch (Throwable t) {
            return false;
        }
    }

    /**
     * Forces the next openPip() to rebuild rather than trusting what is on screen.
     * Call on wake: the panes left over from before a suspend look fine but their displays are not.
     */
    public static void invalidateOpenPipDebounce() {
        synchronized (OPEN_PIP_LOCK) {
            lastOpenPipSignature = null;
            lastOpenPipAtMs = 0L;
            openPipInFlight = false;
            lastRebuildStartedAtMs = 0L;
        }
        // Every wake gets a fresh budget for the paused-launcher retries.
        allowPipRetries = 0;
        Log.i(TAG, "openPip debounce invalidated");
    }

    /** Releases the in-flight claim taken by shouldDebounceOpenPip(). */
    private static void clearOpenPipInFlight() {
        synchronized (OPEN_PIP_LOCK) {
            openPipInFlight = false;
        }
    }

    public static void openPip(boolean show) {
        if (!LauncherApplication.isFytDevice()) return;
        final Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;

        // openPip() runs on a worker thread and openMultiplePips() follows ~170 ms later on the
        // main thread, so this is the last free moment to resolve icons and launch intents.
        prewarmConfiguredPipPackages(launcher);

        if (launcher.allowPip) {
            allowPipRetries = 0;
            try {
                if (helpers == null) {
                    helpers = new Helpers();
                }
                Log.i(TAG, "openPip(): " +  "show: "+ show
                    + " helpers.pipsAdded(): " + helpers.pipsAdded()
                    + " Utils.topApp(): " + Utils.topApp()
                    + " AppPackageName.isEmpty() " + AppPackageName.isEmpty()
                    + " helpers.isInWidgets() " + helpers.isInWidgets()
                    + " helpers.isInAllApps() " + helpers.isInAllApps()
                    + " helpers.isInOverviewMode() " + helpers.isInOverviewMode()
                    + " helpers.isFirstPreferenceWindow() " + helpers.isFirstPreferenceWindow()
                    + " helpers.allAppsVisibility() " + helpers.allAppsVisibility(Launcher.getLauncher().mAppsCustomizeTabHost.getVisibility())
                    + " helpers.isWallpaperWindow() " + helpers.isWallpaperWindow()
                    + " helpers.isListOpen() " + helpers.isListOpen());

                boolean canOpen =
                        (show && !helpers.pipsAdded())
                                || (Utils.topApp()
                                && !helpers.pipsAdded()
                                && !helpers.isInWidgets()
                                && !helpers.isInAllApps()
                                && !helpers.isInOverviewMode()
                                && !helpers.isFirstPreferenceWindow()
                                && !helpers.isWallpaperWindow()
                                && !helpers.allAppsVisibility(Launcher.getLauncher().mAppsCustomizeTabHost.getVisibility()))
                                || (!helpers.userWasInRecents() && helpers.isListOpen() && !helpers.pipsAdded());

                if (!canOpen) {
                    if (!pipRetryPending) {
                        // Utils.topApp() might still return wrong app name after going back to home
                        // retry once
                        pipRetryPending = true;
                        retryHandler.postDelayed(() -> WindowUtil.startMapPip(show), 180);
                    }
                    return;
                }

                if (canOpen) {
                    pipRetryPending = false;

                    if (prefs == null) {
                        prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp); 
                    }

                    // A repeated trigger (onResume / startMapPip / retry) can enter here again
                    // within ~2 s and disrupt the panels that have just been restored. If the configuration
                    // is the same and the panels are still present, there is nothing to rebuild.
                    if (shouldDebounceOpenPip(show)) {
                        Log.i(TAG, "openPip(): debounced - identical layout already on screen");
                        delayMillis = 0;
                        helpers.setPipsAdded(true);
                        helpers.setFirstPreferenceWindow(false);
                        helpers.setWallpaperWindow(false);
                        helpers.setWasInRecents(false);
                        return;
                    }

                    if (checkIfPinned() && AppPackageName.equals("com.syu.camera360")) {
                        Launcher.mLauncher.sendBroadcast(new Intent("com.syu.camera360.show"));
                    }

                    boolean userLayout = prefs.getBoolean(Keys.USER_LAYOUT, false);
                   
                    if (userLayout) {
                        Launcher.mLauncher.sendBroadcast(new Intent(Keys.BLOCK_FLOATING_BUTTON));
                        // Always try to dismiss existing views before adding a new ones
                        // It prevents adding a view twice what results in persistent black rectangle
                        try {
                            // Dismiss windowed activity
                            final WindowHost host = host();
                            if (host != null) {
                                // Dismiss windowed activity on main thread (existing)
                                launcher.handler.post(host::dismiss);
                            }
                            // Get and call the setPinnedStackVisible(false) method via reflection to remove pinned PiP
                            Method getServiceMethod = ActivityManager.class.getMethod("getService");
                            Object activityManager = getServiceMethod.invoke(null);
                            Class<?> activityManagerClass = Class.forName("android.app.IActivityManager");
                            Method setPinnedStackVisibleMethod = activityManagerClass.getMethod("setPinnedStackVisible", boolean.class);
                            setPinnedStackVisibleMethod.invoke(activityManager, false);
                            Log.i(TAG, "openPip() pane: dismissed");
                        } catch (Throwable t) {
                            Log.w(TAG, "openPip() pane: dismiss failed", t);
                        }
                        // Add pips
                        boolean userMap = prefs.getBoolean(Keys.DISPLAY_PIP, true);
                        if (userMap) {
                            launcher.pipOverview();
                            launcher.handler.postDelayed(() -> {     
                                if (checkIfPinned()) {
                                    openPinnedPip();
                                }
                            }, delayMillis);
                            launcher.handler.postDelayed(WindowUtil::openMultiplePips, delayMillis + 100);
                            launcher.handler.postDelayed(launcher::showOverlayFab, delayMillis + 150);
                        } else {
                            clearOpenPipInFlight();
                        }
                    } else {
                        clearOpenPipInFlight();
                    }

                    delayMillis = 0;
                    helpers.setPipsAdded(true);
                    helpers.setFirstPreferenceWindow(false);
                    helpers.setWallpaperWindow(false);
                    helpers.setWasInRecents(false);
                } else {
                    // Nothing was scheduled, so nothing will clear the claim.
                    clearOpenPipInFlight();
                }
            } catch (ActivityNotFoundException e) {
                Log.e(TAG, "openPip() failed: " + e);
                clearOpenPipInFlight();
            }
        } else {
            clearOpenPipInFlight();
            // Paused right now -- most likely one of the brief pause/resume flips of a wake.
            // Try again shortly instead of waiting for the watchdog.
            if (!pipRetryPending && allowPipRetries < MAX_ALLOW_PIP_RETRIES) {
                allowPipRetries++;
                pipRetryPending = true;
                Log.i(TAG, "openPip(): launcher paused, retrying in " + ALLOW_PIP_RETRY_MS
                        + " ms (" + allowPipRetries + "/" + MAX_ALLOW_PIP_RETRIES + ")");
                retryHandler.postDelayed(() -> {
                    pipRetryPending = false;
                    WindowUtil.startMapPip(show);
                }, ALLOW_PIP_RETRY_MS);
            }
        }
    }

    public static void removePip(int millis) {
        delayMillis = millis;
        ThreadManager.getLongPool().execute(WindowUtil::removePip);
    }

    public static void removePip() {
        if (!LauncherApplication.isFytDevice()) return;
        final Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        launcher.handler.post(launcher::cancelPipWatchdog);
        if (helpers == null) {
            helpers = new Helpers();
        }
        pipRetryPending = false;
        // Whatever was being built is gone with these panes.
        synchronized (OPEN_PIP_LOCK) {
            openPipInFlight = false;
            lastRebuildStartedAtMs = 0L;
            pendingPaneLaunches = 0;
        }
        if (helpers.pipsAdded()) {
            Log.d(TAG, "removePip..");
            launcher.handler.postDelayed(() -> {
                if (checkIfPinned() && WindowUtil.AppPackageName.equals("com.syu.camera360")) {
                    LauncherApplication.sApp.sendBroadcast(new Intent("com.syu.camera360.hide"));
                }
            }, delayMillis);
            if (AppPackageName.equals(FytPackage.GaodeACTION)) {
                try {
                    LauncherApplication.sApp.removeGaoDeCoverView();
                } catch (Exception e) {
                    Log.e(TAG, "removeGaoDeCoverView() failed: " + e);
                }
            }
            delayMillis = 0;
        }
        if (prefs == null) {
            prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);  
        }
        boolean userLayout = prefs.getBoolean(Keys.USER_LAYOUT, false);
        boolean userStats = prefs.getBoolean(Keys.USER_STATS, false);
        if (userLayout) {
            if (userStats) {
                if (!helpers.isForegroundAppOpened() && !helpers.isInRecent() && !helpers.isInAllApps()) {
                    helpers.setPipStarted(false);
                    Intent intent = new Intent(Keys.PIP_REMOVED);
                    LauncherApplication.sApp.sendBroadcast(intent);
                } else if (helpers.isInOverviewMode()) {
                    Intent intentOverview = new Intent(Keys.OVERVIEW_MODE_OPEN);
                    LauncherApplication.sApp.sendBroadcast(intentOverview);
                }
            }
            try {
                launcher.hideOverlayFab();
                // Dismiss windowed activity
                final WindowHost host = host();
                if (host != null) {
                    // Dismiss windowed activity on main thread (existing)
                    launcher.handler.post(host::dismiss);
                }
                // Get and call the setPinnedStackVisible(false) method via reflection to remove pinned PiP
                Method getServiceMethod = ActivityManager.class.getMethod("getService");
                Object activityManager = getServiceMethod.invoke(null);
                Class<?> activityManagerClass = Class.forName("android.app.IActivityManager");
                Method setPinnedStackVisibleMethod = activityManagerClass.getMethod("setPinnedStackVisible", boolean.class);
                setPinnedStackVisibleMethod.invoke(activityManager, false);
                Log.i(TAG, "removePip() pane: dismissed");
            } catch (Throwable t) {
                Log.w(TAG, "removePip() pane: dismiss failed", t);
            }
            helpers.setPipsAdded(false);
        }
    }
    
    // =====================================================================================
    // LAUNCH ORDER AND MCU SOUND CHANNEL BUG
    // =====================================================================================

    /** 
     * com.syu.ms polls getRunningTasks(1) every 500ms and hands the MCU sound channel to "channel 10" 
     * the moment it sees a recognised media app become the focused activity - not when that app plays. 
     * That switch cannot be stopped on the launcher level so all we can do is to predict when
     * it fires, try to fool it (by keeping the launcher on top) and deal with the aftermath. 
     */

    private static volatile int pendingReasserts = 0;
    private static Runnable reassertTask;

    /** Gap after a source-stealing pane, so a slow starter cannot overtake a later one. */
    private static final long PANE_LAUNCH_STAGGER_MS = 250L;
    /** Gap after a pane that does not touch the MCU sound channel; ordering does not matter there. */
    private static final long PANE_LAUNCH_QUIET_STAGGER_MS = 90L;

    /**
     * How long, and how often, the launcher is pushed back to the front afterward.
     *
     * This runs off the main thread. getRunningTasks() is a binder call into the same
     * ActivityTaskManager lock the four pending activity starts need, so hammering it every 1 ms
     * from the launcher's main thread - 250 times - would contend with exactly the work it is
     * waiting on. 32 ms x 40 covers the same ~1.3 s window at 3% of the call volume.
     */
    private static final int LAUNCHER_TOP_REASSERTS = 40;
    private static final long LAUNCHER_TOP_REASSERT_MS = 32L;

    private static final ScheduledExecutorService REASSERT_EXEC =
            Executors.newSingleThreadScheduledExecutor(r -> {
                Thread t = new Thread(r, "PipReassertTop");
                t.setDaemon(true);
                return t;
            });
    /** Bumped on every call, so a still-queued run from a previous rebuild drops out. */
    private static volatile int reassertGeneration = 0;

    /** player_app.txt from com.syu.ms assets contains the list below. These apps steal the audio focus
     *  from com.syu.music/radio whenever com.syu.ms detects them as top app in getRunningTasks */
    private static final Set<String> DEFAULT_SOURCE_STEALERS = new HashSet<>(Arrays.asList(
        "com.kugou.playerHD",
        "com.ifeng.video",
        "com.omusicpad",
        "com.qiyi.video",
        "com.tencent.qqmusic",
        "com.tencent.qqlivehd",
        "com.youku.pad",
        "com.youku.phone",
        "com.duomi.android",
        "com.tudou.xoom.android",
        "cn.kuwo.player",
        "com.kugou.android",
        "com.kugou.android.tv",
        "org.videolan.vlc.betav7neon",
        "com.generalplus.GaGaPlayer",
        "cn.kuwo.kwmusichd",
        "com.sds.android.ttpod",
        "cn.kuwo.kwmusiccar",
        "com.kuwo.kwmusiccar",
        "cn.kuwo.player",
        "com.txznet.music",
        "com.maxmpz.audioplayer",
        "com.maxmpz.audioplayer.player.PlayerService",
        "com.jinpai.android.CarCoach",
        "com.edog.car",
        "com.mxtech.videoplayer.ad",
        "com.jetappfactory.jetaudioplus",
        "com.jetappfactory.jetaudio",
        "com.zjinnova.zbox",
        "com.elinkway.tvlive2",
        "com.storm.localplayer",
        "com.elinkway.tvlive2",
        "com.netease.cloudmusic",
        "com.syu.dvr",
        "com.didi365.miudrive.navi",
        "com.hongfans.rearview",
        "com.incarmedia",
        "com.mediacast.co.il.radioin2",
        "com.cyberserve.android.reco99fm",
        "com.tencent.qqmusiccar",
        "com.google.android.youtube",
        "com.google.android.youtube",
        "ru.yandex.music",
        "com.google.android.apps.youtube.music",
        "com.vkontakte.android",
        "io.stellio.player",
        "com.spotify.music",
        "com.google.android.music",
        "com.amazon.mp3",
        "com.zjinnova.zlink",
        "cn.manstep.phonemirrorBox",
        "com.incarmedia",
        "mbinc12.mb32b",
        "com.kugou.android.auto",
        "com.tencent.wecarflow",
        "com.xjcheng.simlosslessplay",
        "com.hiby.music",
        "com.syu.onlineradio",
        "com.djbox.product",
        "com.xingle",
        "com.ctappstudio.ytfind",
        "com.thunder.carplay",
        "com.qiyi.video.pad",
        "com.tencent.qqlivepad",
        "cn.kuwo.tingshucar",
        "com.ximalaya.ting.android.car",
        "com.disney.disneyplus",
        "com.netflix.mediaclient"
    ));

    private static final String KEY_SOURCE_STEALERS = "pip_source_stealing_packages";

    private static Set<String> sourceStealers() {
        try {
            if (prefs == null) {
                prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
            }
            String raw = prefs.getString(KEY_SOURCE_STEALERS, null);
            if (raw == null || raw.trim().isEmpty()) return DEFAULT_SOURCE_STEALERS;

            Set<String> out = new HashSet<>();
            for (String part : raw.split(",")) {
                String pkg = part.trim();
                if (!pkg.isEmpty()) out.add(pkg);
            }
            return out.isEmpty() ? DEFAULT_SOURCE_STEALERS : out;
        } catch (Throwable t) {
            return DEFAULT_SOURCE_STEALERS;
        }
    }

    /** True when launching this package makes the ROM take the sound channel. */
    static boolean isSourceStealer(String pkg) {
        return pkg != null && !pkg.isEmpty() && sourceStealers().contains(pkg);
    }

    private static boolean anySourceStealer(String... pkgs) {
        if (pkgs == null) return false;
        for (String pkg : pkgs) {
            if (isSourceStealer(pkg)) return true;
        }
        return false;
    }

    /** One pane opening, so the whole set can be ordered before anything is shown. */
    private record PaneLaunch(String label, Runnable action, boolean stealer) {
        private PaneLaunch(String label, Runnable action, String... stealer) {
            this(label, action, anySourceStealer(stealer));
        }
    }

    /**
     * Runs the pane openings with every source-stealing package first. The sort is stable, so
     * panes that do not steal keep their configured order relative to each other.
     */
    private static void runOrdered(List<PaneLaunch> launches) {
        pendingPaneLaunches = launches.size();
        if (launches.isEmpty()) return;

        launches.sort((a, b) -> Boolean.compare(!a.stealer, !b.stealer));

        StringBuilder order = new StringBuilder();
        for (PaneLaunch l : launches) {
            if (order.length() > 0) order.append(" -> ");
            order.append(l.label);
            if (l.stealer) order.append("*");
        }
        Log.i(TAG, "pane launch order: " + order);

        runStaggered(launches, 0);
    }

    /**
     * Runs the openings one every PANE_LAUNCH_STAGGER_MS instead of back to back.
     *
     * Four cold starts fired inside ~340 ms compete for the main thread, and a slow one can end up
     * resuming AFTER the panes that were launched later -- which defeats the ordering above, since
     * what the ROM reacts to is the last activity to gain focus.
     */
    private static void runStaggered(List<PaneLaunch> launches, int index) {
        if (index >= launches.size()) {
            pendingPaneLaunches = 0;
            return;
        }

        PaneLaunch l = launches.get(index);
        try {
            l.action.run();
        } catch (Throwable t) {
            Log.w(TAG, l.label + ": open failed", t);
        } finally {
            if (pendingPaneLaunches > 0) pendingPaneLaunches--;
        }
        
        if (l.stealer) {
            Log.i(TAG, "reassertLauncherTop() started for stealer in windowed PiP");
            reassertLauncherTop();
        }

        Launcher launcher = Launcher.getLauncher();
        if (launcher == null) {
            pendingPaneLaunches = 0;
            return;
        }
        // The full gap only exists so a source-stealing app cannot be overtaken by a later one.
        // Two panes that do not touch the sound channel have no such ordering requirement, so they
        // only need enough separation to keep four window additions off the same frame.
        long gap = l.stealer ? PANE_LAUNCH_STAGGER_MS : PANE_LAUNCH_QUIET_STAGGER_MS;
        launcher.handler.postDelayed(() -> runStaggered(launches, index + 1), gap);
    }

    /**
     * Brings the launcher back to the front after the panes are up to avoid app stealing audio focus
     * being detected by com.syu.ms - not foolproof, but reduces chance to stop stock players
     */
    private static void reassertLauncherTop() {
        final Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;

        // Captured on the main thread; everything below runs on REASSERT_EXEC.
        final int launcherTaskId = launcher.getTaskId();
        final ActivityManager am =
                (ActivityManager) launcher.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        if (am == null) return;

        final int myGeneration;
        synchronized (WindowUtil.class) {
            reassertGeneration++;
            myGeneration = reassertGeneration;
            pendingReasserts = LAUNCHER_TOP_REASSERTS;
        }

        // Self-rescheduling rather than scheduleWithFixedDelay: the task decides when it is done,
        // so there is no future left ticking after the window closes.
        reassertTask = new Runnable() {
            @Override public void run() {
                if (reassertGeneration != myGeneration) return;
                if (pendingReasserts <= 0) return;
                if (Launcher.getLauncher() == null) { pendingReasserts = 0; return; }

                try {
                    List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
                    boolean stealerOnTop = tasks != null && !tasks.isEmpty()
                            && tasks.get(0).topActivity != null
                            && DEFAULT_SOURCE_STEALERS.contains(tasks.get(0).topActivity.getPackageName());

                    if (stealerOnTop) {
                        am.moveTaskToFront(launcherTaskId, 0);
                        pendingReasserts = 0;
                        Log.i(TAG, "reassertLauncherTop moved launcher to top");
                        return;
                    }
                } catch (Throwable t) {
                    Log.w(TAG, "reassertLauncherTop failed, giving up", t);
                    pendingReasserts = 0;
                    return;
                }

                if (--pendingReasserts > 0) {
                    REASSERT_EXEC.schedule(this, LAUNCHER_TOP_REASSERT_MS, TimeUnit.MILLISECONDS);
                }
            }
        };
        REASSERT_EXEC.execute(reassertTask);
    }

    /**
     * Pushes the launcher back over any PiP app that comes up fullscreen right after a wake.
     *
     * com.syu.ms remembers the top app when the MCU goes off and relaunches it on wake with a
     * plain MAIN/LAUNCHER intent -- which, for an app that lives in a pane, means fullscreen on
     * the default display. In one long-sleep capture it relaunched YouTube 91 ms after the cold
     * reset had force-stopped it; the launcher was paused behind it, and pressHomeButton() --
     * posted 500 ms after the wake on a main thread that then stalled for two seconds -- only
     * brought it back at +2.2 s. The panes cannot be built while the launcher is paused, so every
     * app in them started that much later. Earlier this same restore is what left Maps fullscreen.
     *
     * Runs on REASSERT_EXEC, so a congested main thread cannot delay it, and only acts on the
     * configured PiP packages: anything else on top (a bridge activity, a fullscreen app the user
     * had open) is left for pressHomeButton() and the user's LAUNCHER_HOME preference to decide.
     */
    public static void reassertHomeOverPipAppsAfterWake(long windowMs) {
        final Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        final ActivityManager am =
                (ActivityManager) launcher.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        if (am == null) return;

        if (prefs == null) {
            prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        }
        final Set<String> pipPkgs = new HashSet<>();
        for (String k : new String[]{ Keys.PIP_FIRST_PACKAGE, Keys.PIP_SECOND_PACKAGE,
                                      Keys.PIP_THIRD_PACKAGE, Keys.PIP_FOURTH_PACKAGE }) {
            String pkg = prefs.getString(k, "");
            if (pkg != null && !pkg.isEmpty()) pipPkgs.add(pkg);
        }
        if (pipPkgs.isEmpty()) return;

        final int launcherTaskId = launcher.getTaskId();
        final long deadline = SystemClock.elapsedRealtime() + windowMs;
        final int myGeneration;
        synchronized (WindowUtil.class) {
            myGeneration = ++wakeReassertGeneration;
        }

        REASSERT_EXEC.execute(new Runnable() {
            @Override public void run() {
                if (wakeReassertGeneration != myGeneration) return;
                if (SystemClock.elapsedRealtime() > deadline) return;
                try {
                    // A PiP app restored fullscreen necessarily pauses the launcher. While the
                    // launcher is resumed, any PiP package reported on top is one of our own panes
                    // on its VirtualDisplay, and there is nothing to push back.
                    Launcher current = Launcher.getLauncher();
                    boolean launcherInFront = current != null && current.allowPip;

                    List<ActivityManager.RunningTaskInfo> tasks =
                            launcherInFront ? null : am.getRunningTasks(1);
                    if (tasks != null && !tasks.isEmpty() && tasks.get(0).topActivity != null) {
                        String top = tasks.get(0).topActivity.getPackageName();
                        if (pipPkgs.contains(top)) {
                            am.moveTaskToFront(launcherTaskId, 0);
                            Log.i(TAG, "wake reassert: " + top + " came up fullscreen, launcher moved back on top");
                        }
                    }
                } catch (Throwable t) {
                    Log.w(TAG, "wake reassert failed, stopping", t);
                    return;
                }
                REASSERT_EXEC.schedule(this, WAKE_REASSERT_POLL_MS, TimeUnit.MILLISECONDS);
            }
        });
    }

    private static final long WAKE_REASSERT_POLL_MS = 120L;
    private static volatile int wakeReassertGeneration = 0;

    /**
     * Reparents a swapped pair with the source-stealing side going first, for the same reason
     * the launch order matters: the steal has to land while the rebuild window is still open.
     */
    private static void reparentPairOrdered(ViewGroup hostA, View viewA, String pkgA,
                                            ViewGroup hostB, View viewB, String pkgB) {
        boolean bGoesFirst = !isSourceStealer(pkgA) && isSourceStealer(pkgB);
        if (bGoesFirst) {
            if (hostB != null) reparentHostChild(hostB, viewB);
            if (hostA != null) reparentHostChild(hostA, viewA);
        } else {
            if (hostA != null) reparentHostChild(hostA, viewA);
            if (hostB != null) reparentHostChild(hostB, viewB);
        }
    }

    /** Tells NotificationListener the moment the panes are genuinely up. */
    private static void notifyPanesSettled(int attemptsLeft) {
        try {
            // A pane that has not been shown yet reports hasRenderedContent() == true, so the
            // rendering check alone declares the rebuild finished while launches are still queued.
            if (pendingPaneLaunches > 0 && attemptsLeft > 0) {
                Launcher pending = Launcher.getLauncher();
                if (pending != null) {
                    pending.handler.postDelayed(() -> notifyPanesSettled(attemptsLeft - 1), 250);
                    return;
                }
            }

            WindowHost h = host();
            if (h == null || h.areAllPanesRendering() || attemptsLeft <= 0) {
                NotificationListener.onPaneRebuildSettled();
                // Construction is over -- from here the panes belong to the user.
                return;
            }
            Launcher l = Launcher.getLauncher();
            if (l == null) {
                NotificationListener.onPaneRebuildSettled();
                return;
            }
            l.handler.postDelayed(() -> notifyPanesSettled(attemptsLeft - 1), 250);
        } catch (Throwable t) {
            NotificationListener.onPaneRebuildSettled();
        }
    }

    /**
     * Reopening the panes makes the players hosted there announce playback on
     * their own. That is the launcher restarting them, not the user picking a
     * new source, so the media listener has to be told before it happens.
     */
    private static void suppressMediaSourceSwitch() {
        NotificationListener listener = NotificationListener.getInstance();
        if (listener != null) {
            listener.suppressAutoSourceSwitch();
        }
    }

    // =====================================================================================
    // WINDOWED PIPS
    // =====================================================================================

    /**
     * Loads the icons and launch intents for the configured PiP packages ahead of the rebuild.
     * Safe to call repeatedly -- both caches skip what they already hold.
     */
    public static void prewarmPipPackages(Context ctx, String... packages) {
        if (ctx == null) return;
        Set<String> wanted = new LinkedHashSet<>();
        for (String pkg : packages) {
            if (pkg != null && !pkg.isEmpty()) wanted.add(pkg);
        }
        if (wanted.isEmpty()) return;
        WindowHostSplash.prewarm(ctx, wanted);
        WindowHostActivityView.prewarmLaunchIntents(ctx, wanted);
    }

    /** Prewarms straight from the saved PiP configuration; call this once from Launcher.onCreate. */
    public static void prewarmConfiguredPipPackages(Context ctx) {
        if (ctx == null) return;
        try {
            if (prefs == null) {
                prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
            }
            prewarmPipPackages(ctx,
                    prefs.getString(Keys.PIP_FIRST_PACKAGE, ""),
                    prefs.getString(Keys.PIP_SECOND_PACKAGE, ""),
                    prefs.getString(Keys.PIP_THIRD_PACKAGE, ""),
                    prefs.getString(Keys.PIP_FOURTH_PACKAGE, ""));
        } catch (Throwable t) {
            Log.w(TAG, "prewarmConfiguredPipPackages failed", t);
        }
    }

    public static void openMultiplePips() {
        if (!LauncherApplication.isFytDevice()) return;

        // Second line of defence. Even with the in-flight claim, two runnables could already be
        // queued on the main handler; building a second WindowHost orphans the first one's windows.
        synchronized (OPEN_PIP_LOCK) {
            final long nowMs = openPipClock();
            boolean staggerStillRunning = pendingPaneLaunches > 0
                    && nowMs - lastRebuildStartedAtMs < OPEN_PIP_INFLIGHT_TIMEOUT_MS;
            if (nowMs - lastRebuildStartedAtMs < REBUILD_GUARD_MS || staggerStillRunning) {
                Log.w(TAG, "openMultiplePips(): a rebuild is already running ("
                        + (nowMs - lastRebuildStartedAtMs) + " ms ago, pending="
                        + pendingPaneLaunches + "), skipping duplicate");
                openPipInFlight = false;
                return;
            }
            lastRebuildStartedAtMs = nowMs;
            openPipInFlight = false;
        }
        // Fresh panes: force the next scroll update through even if the offset has not moved.
        lastScrollOffset = Integer.MIN_VALUE;
        lastSavedBasePos.clear();

        final Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        
        Workspace workspace = workspace();
        if (workspace == null) return;

        suppressMediaSourceSwitch();
        launcher.handler.postDelayed(() -> notifyPanesSettled(PANES_SETTLED_POLLS), 250);

        final WindowHost previousHost = host();
        if (previousHost != null) {
            try {
                previousHost.dismiss();
            } catch (Throwable ignore) {}
        }

        dualPip = prefs.getBoolean(Keys.PIP_DUAL, false);
        firstPip = prefs.getBoolean(Keys.PIP_FIRST, false);
        secondPip = prefs.getBoolean(Keys.PIP_SECOND, false);
        thirdPip = prefs.getBoolean(Keys.PIP_THIRD, false);
        fourthPip = prefs.getBoolean(Keys.PIP_FOURTH, false);

        final WindowHost host = new WindowHost(launcher);
        setHost(host);
        forcePipBoundsUpdate = true;

        firstPkg = prefs.getString(Keys.PIP_FIRST_PACKAGE, "");
        secondPkg = prefs.getString(Keys.PIP_SECOND_PACKAGE, "");
        final String thirdPkg = prefs.getString(Keys.PIP_THIRD_PACKAGE, "");
        final String fourthPkg = prefs.getString(Keys.PIP_FOURTH_PACKAGE, "");

        // Everything the launch path would otherwise ask PackageManager for on the main thread:
        // the splash icon, its plate colour and the launch intent. Warmed on a background thread
        // so the panes below never block on a binder round-trip.
        prewarmPipPackages(launcher, firstPkg, secondPkg, thirdPkg, fourthPkg);

        // Collect the openings first, then run them with the source-stealing packages leading --
        // see the LAUNCH ORDER section. Nothing is shown while the list is being built.
        final List<PaneLaunch> launches = new ArrayList<>();
        final String fFirstPkg = firstPkg;
        final String fSecondPkg = secondPkg;

        if (dualPip && !host.isDualVisible() && !firstPipPinned && !secondPipPinned 
            && isPipPackageInstalled(firstPkg) && isPipPackageInstalled(secondPkg)) {    
            launches.add(new PaneLaunch("dual", () -> {
                Rect rDual = getInitialPipBounds(workspace, "dual");
                if (rDual != null) {
                    host.showDual(fFirstPkg, fSecondPkg, rDual);
                    Log.i(TAG, "dual: show " + fFirstPkg + " and " + fSecondPkg);
                }
            }, firstPkg, secondPkg));
        } else {
            if (firstPip && !firstPipPinned && !host.isFirstVisible()
                    && isPipPackageInstalled(firstPkg)) {
                launches.add(new PaneLaunch("first", () -> {
                    Rect rFirst = getInitialPipBounds(workspace, "first");
                    if (rFirst != null) {
                        host.showFirst(fFirstPkg, rFirst);
                        Log.i(TAG, "first: show " + fFirstPkg);
                    }
                }, firstPkg));
            }

            if (secondPip && !secondPipPinned && !host.isSecondVisible()
                    && isPipPackageInstalled(secondPkg)) {
                launches.add(new PaneLaunch("second", () -> {
                    Rect rSecond = getInitialPipBounds(workspace, "second");
                    if (rSecond != null) {
                        host.showSecond(fSecondPkg, rSecond);
                        Log.i(TAG, "second: show " + fSecondPkg);
                    }
                }, secondPkg));
            }
        }

        if (thirdPip && !thirdPipPinned && !host.isThirdVisible()
                && isPipPackageInstalled(thirdPkg)) {
            launches.add(new PaneLaunch("third", () -> {
                Rect rThird = getInitialPipBounds(workspace, "third");
                if (rThird != null) {
                    host.showThird(thirdPkg, rThird);
                    Log.i(TAG, "third: show " + thirdPkg);
                }
            }, thirdPkg));
        }

        if (fourthPip && !fourthPipPinned && !host.isFourthVisible()
                && isPipPackageInstalled(fourthPkg)) {
            launches.add(new PaneLaunch("fourth", () -> {
                Rect rFourth = getInitialPipBounds(workspace, "fourth");
                if (rFourth != null) {
                    host.showFourth(fourthPkg, rFourth);
                    Log.i(TAG, "fourth: show " + fourthPkg);
                }
            }, fourthPkg));
        }

        runOrdered(launches);

        launcher.handler.postDelayed(() -> pumpPipBoundsUntilReady(32), 100);

        // The previous host's ActivityViews still hold the embedded tasks. Retire them: they are
        // released only once the freshly created panes have taken those tasks over, which is what
        // stops every open/remove PiP cycle from leaking a VirtualDisplay for good.
        if (previousHost != null && previousHost != host) {
            launcher.handler.postDelayed(previousHost::retireActivityViews, 1200);
        }          
    }

    /**
     * Applies the dimensions to newly created panels, retrying until none of the panels
     * reports that it is still waiting for bounds (WindowHost.isAnyPaneAwaitingBounds()).
     */
    private static void pumpPipBoundsUntilReady(int attemptsLeft) {
        try {
            final Launcher launcher = Launcher.getLauncher();
            final WindowHost host = host();
            if (launcher == null || host == null) return;
 
            Workspace workspace = workspace();
            if (workspace != null) {
                updatePipPositionsForScroll(workspace.mUnboundedScrollX);
            }
 
            if (!host.isAnyPaneAwaitingBounds()) return;
            if (attemptsLeft <= 0) {
                Log.w(TAG, "pumpPipBoundsUntilReady: gave up, panes still awaiting bounds");
                return;
            }
            forcePipBoundsUpdate = true;
            launcher.handler.postDelayed(() -> pumpPipBoundsUntilReady(attemptsLeft - 1), 120);
        } catch (Throwable t) {
            Log.w(TAG, "pumpPipBoundsUntilReady failed", t);
        }
    }

    private static String getScreenKeyForType(String pipType) {
        return switch (pipType) {
            case "dual" -> Keys.PIP_DUAL_SCREEN;
            case "first" -> Keys.PIP_FIRST_SCREEN;
            case "second" -> Keys.PIP_SECOND_SCREEN;
            case "third" -> Keys.PIP_THIRD_SCREEN;
            case "fourth" -> Keys.PIP_FOURTH_SCREEN;
            default -> "";
        };
    }

    private static Rect getInitialPipBounds(Workspace workspace, String pipType) {
        Rect fallback = new Rect(offscreen);
        try {
            if (workspace == null || prefs == null) return fallback;

            String screenKey = getScreenKeyForType(pipType);
            if (screenKey.isEmpty()) return fallback;

            int pipHomeScreen = prefs.getInt(screenKey, 1) - 1;
            if (pipHomeScreen < 0 || pipHomeScreen >= workspace.getChildCount()) {
                return fallback;
            }

            CellLayout pipHomeCellLayout = (CellLayout) workspace.getChildAt(pipHomeScreen);

            int pageWidth = workspace.getViewportWidth();
            int[] basePos = (pipHomeCellLayout != null)
                    ? pipHomeCellLayout.getPipPlaceholderPosition(pipType)
                    : null;

            if (basePos != null && pageWidth > 0) {
                savePlaceholderPosition(pipType, pipHomeScreen, basePos, pageWidth);
            } else {
                // CellLayout.getPipPlaceholderPosition() now derives the geometry from preferences
                // when the placeholder view has not been added yet, so this only runs when the page
                // itself is missing. The remembered geometry is the last resort; it is pixel data
                // from an earlier run, so it can be slightly stale and is only better than the
                // offscreen fallback, which would defer the whole pane.
                int[] cached = loadPlaceholderPosition(pipType, pipHomeScreen);
                if (cached == null) return fallback;
                basePos = cached;
                if (pageWidth <= 0) pageWidth = cached[4];
                Log.i(TAG, "getInitialPipBounds(" + pipType + "): page not ready, using cached placeholder geometry");
            }

            int pageCount = workspace.getChildCount();
            int maxScroll = Math.max(0, (pageCount - 1) * pageWidth);
            int currentScroll = Math.max(0, Math.min(workspace.mUnboundedScrollX, maxScroll));
            int pipAbsoluteX = (pipHomeScreen * pageWidth) + basePos[0];
            int pipScreenX = pipAbsoluteX - currentScroll;

            Rect bounds = new Rect(pipScreenX, basePos[1],
                    pipScreenX + basePos[2], basePos[1] + basePos[3]);

            // Record what the pane is actually being built with.
            //
            // updatePipPosition() skips the correction when the rect it computes equals
            // lastPipBounds, and that entry survives a rebuild. If the geometry changed in settings
            // while the launcher was running, lastPipBounds already held the NEW rect while the pane
            // was built from the cached OLD one -- the two matched, the correction was skipped, and
            // the pane stayed at the previous size indefinitely. That is what left dual unresized.
            lastPipBounds.put(pipType, new Rect(bounds));
            return bounds;
        } catch (Throwable t) {
            Log.w(TAG, "getInitialPipBounds failed for " + pipType, t);
            return fallback;
        }
    }

    public static void updatePipPositionsForScroll(int scrollOffset) {
        try {
            final Launcher launcher = Launcher.getLauncher();
            if (launcher == null) return;

            final Workspace workspace = workspace();
            if (workspace == null) return;

            final WindowHost host = host();
            if (host == null) return;

            if (prefs == null) {
                prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
            }

            // Nothing moved since the last frame, so there is nothing to push to any pane.
            // A fling delivers the same offset repeatedly once it settles, and every one of those
            // frames used to walk all five pane types and their window updates.
            if (!forcePipBoundsUpdate && scrollOffset == lastScrollOffset) return;
            lastScrollOffset = scrollOffset;

            // Update positions for currently visible PiPs without dismissing them
            if (dualPip)   updatePipPosition(host, workspace, "dual", scrollOffset);
            if (firstPip)  updatePipPosition(host, workspace, "first", scrollOffset);
            if (secondPip) updatePipPosition(host, workspace, "second", scrollOffset);
            if (thirdPip)  updatePipPosition(host, workspace, "third", scrollOffset);
            if (fourthPip) updatePipPosition(host, workspace, "fourth", scrollOffset);

            forcePipBoundsUpdate = false;
        } catch (Exception e) {
            Log.e(TAG, "Error updating PiP positions during scroll", e);
        }
    }

    /** Last offset actually pushed to the panes; see updatePipPositionsForScroll(). */
    private static int lastScrollOffset = Integer.MIN_VALUE;

    private static void updatePipPosition(WindowHost host, Workspace workspace,
                                          String pipType, int scrollOffset) {
        String screenKey = getScreenKeyForType(pipType);
        int pipHomeScreen = prefs.getInt(screenKey, 1) - 1;

        CellLayout pipHomeCellLayout = (CellLayout) workspace.getChildAt(pipHomeScreen);
        if (pipHomeCellLayout == null) return;

        int[] basePos = pipHomeCellLayout.getPipPlaceholderPosition(pipType);
        if (basePos == null) return;

        int pageWidth = workspace.getViewportWidth();
        savePlaceholderPosition(pipType, pipHomeScreen, basePos, pageWidth);

        int pageCount = workspace.getChildCount();
        int maxScroll = Math.max(0, (pageCount - 1) * pageWidth);
        int effectiveScroll = Math.max(0, Math.min(scrollOffset, maxScroll));

        int pipAbsoluteX = (pipHomeScreen * pageWidth) + basePos[0];
        int pipScreenX = pipAbsoluteX - effectiveScroll;

        Rect bounds = new Rect(pipScreenX, basePos[1],
                               pipScreenX + basePos[2], basePos[1] + basePos[3]);

        // If the new bounds are identical to the previously applied ones,
        // skip the update to avoid unnecessary IPC operations.
        Rect last = lastPipBounds.get(pipType);
        if (!forcePipBoundsUpdate && last != null && last.equals(bounds)) {
            return;
        }

        updatePipBounds(host, pipType, bounds);
        lastPipBounds.put(pipType, new Rect(bounds));
    }

    private static void updatePipBounds(WindowHost host, String pipType, Rect bounds) {
        try {
            switch (pipType) {
                case "dual":
                    if (host.isDualVisible()) {
                        host.updateDualBounds(bounds);
                    }
                    break;
                case "first":
                    if (host.isFirstVisible() && !firstPipPinned) {
                        host.updateFirstBounds(bounds);
                    }
                    break;
                case "second":
                    if (host.isSecondVisible() && !secondPipPinned) {
                        host.updateSecondBounds(bounds);
                    }
                    break;
                case "third":
                    if (host.isThirdVisible() && !thirdPipPinned) {
                        host.updateThirdBounds(bounds);
                    }
                    break;
                case "fourth":
                    if (host.isFourthVisible() && !fourthPipPinned) {
                        host.updateFourthBounds(bounds);
                    }
                    break;
            }
        } catch (Exception e) {
            Log.e(TAG, "Error updating bounds for " + pipType, e);
        }
    }

    public static void restartMultiplePips() {
        final Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        suppressMediaSourceSwitch();
        launcher.handler.postDelayed(() -> notifyPanesSettled(PANES_SETTLED_POLLS), 250);
        final WindowHost host = host();
        if (host != null) {
            launcher.handler.post(() -> {
                host.cleanup();
                setHost(null);
            });
        }
    }

    /**
     * Cold, orderly reset of the entire PiP stack. Used where we are discarding the
     * application state anyway, so the reaper's caution (do not release a display
     * with a live task) is unnecessary here -- and actually harmful, because the
     * surviving task carries stale configuration.
     *
     * The order is important and every step is confirmed:
     *   1. dismiss panels and wait until the windows actually disappear,
     *   2. host.cleanup() -> release ActivityView -> destroy VirtualDisplay together with its tasks,
     *   3. release everything the reaper parked during previous cycles,
     *   4. force-stop processes -- ONLY now, when there is no live display left,
     *   5. remove remaining task records (force-stop does not always clear them),
     *   6. wait until this is completed,
     *   7. onDone (usually openPip).
     */
    public static void coldResetPipStack(final Runnable onDone) {
        final Launcher launcher = Launcher.getLauncher();
        if (launcher == null) {
            if (onDone != null) onDone.run();
            return;
        }
        if (prefs == null) {
            prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        }

        final List<String> pkgs = pipPackages();
        Log.i(TAG, "coldResetPipStack: start, packages=" + pkgs);

        launcher.handler.post(() -> {
            try { removePip(); } catch (Throwable ignore) {}

            final WindowHost oldHost = host();

            final Runnable afterDismiss = () -> {
                try { if (oldHost != null) oldHost.cleanup(); } catch (Throwable ignore) {}
                setHost(null);

                try { WindowHostAvReaper.releaseAll(); } catch (Throwable ignore) {}

                lastPipBounds.clear();
                forcePipBoundsUpdate = true;
                lastOpenPipSignature = null;
                lastOpenPipAtMs = 0L;
                synchronized (OPEN_PIP_LOCK) {
                    openPipInFlight = false;
                    lastRebuildStartedAtMs = 0L;
                }

                ThreadManager.getLongPool().execute(() -> {
                    // Tasks first, processes only if that is not enough.
                    //
                    // Steps 1-3 already destroyed every VirtualDisplay together with the tasks on
                    // it, so the stale configuration the force-stop was there to clear is gone
                    // before we get here. Killing the processes on top of that made every PiP app
                    // cold-start twice: com.syu.ms relaunches the remembered top app within ~100 ms
                    // of the kill, fullscreen and cold, and the pane then starts it a second time.
                    // Four simultaneous cold starts are also what keeps the system busy enough that
                    // the launcher needs another 1.5 s to be resumed, which is time the panes wait.
                    for (String pkg : pkgs) {
                        removeTasksForPackage(pkg);
                    }

                    boolean clear = false;
                    boolean forced = false;
                    for (int i = 0; i < 12; i++) {
                        clear = arePipTasksClear(pkgs);
                        if (clear) break;

                        // Something is holding on to a task; fall back to the old behaviour for it.
                        if (!forced && i >= 2) {
                            forced = true;
                            Log.i(TAG, "coldResetPipStack: tasks still present, force-stopping");
                            for (String pkg : pkgs) {
                                forceStopPackageNow(pkg);
                                removeTasksForPackage(pkg);
                            }
                        }

                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException ie) {
                            Thread.currentThread().interrupt();
                            break;
                        }
                    }

                    Log.i(TAG, "coldResetPipStack: done (clear=" + clear
                            + ", forceStopped=" + forced + ")");
                    if (onDone != null) launcher.handler.post(onDone);
                });
            };

            if (oldHost != null) oldHost.awaitHandoff(500, afterDismiss);
            else afterDismiss.run();
        });
    }

    /** Packages that are actually present in the panels (dual uses FIRST and SECOND). */
    private static List<String> pipPackages() {
        List<String> out = new ArrayList<>();
        try {
            boolean dual = prefs.getBoolean(Keys.PIP_DUAL, false);
            addPipPackage(out, (dual || prefs.getBoolean(Keys.PIP_FIRST, false)),  Keys.PIP_FIRST_PACKAGE);
            addPipPackage(out, (dual || prefs.getBoolean(Keys.PIP_SECOND, false)), Keys.PIP_SECOND_PACKAGE);
            addPipPackage(out, prefs.getBoolean(Keys.PIP_THIRD, false),  Keys.PIP_THIRD_PACKAGE);
            addPipPackage(out, prefs.getBoolean(Keys.PIP_FOURTH, false), Keys.PIP_FOURTH_PACKAGE);
        } catch (Throwable t) {
            Log.w(TAG, "pipPackages failed", t);
        }
        return out;
    }

    private static void addPipPackage(List<String> out, boolean enabled, String key) {
        if (!enabled) return;
        String pkg = prefs.getString(key, "");
        if (pkg != null && !pkg.isEmpty() && !out.contains(pkg)) out.add(pkg);
    }

    private static void forceStopPackageNow(String pkg) {
        if (pkg == null || pkg.isEmpty()) return;
        try {
            ActivityManager am = (ActivityManager) LauncherApplication.sApp
                    .getSystemService(Context.ACTIVITY_SERVICE);
            Method m = am.getClass().getDeclaredMethod("forceStopPackage", String.class);
            m.setAccessible(true);
            m.invoke(am, pkg);
            Log.i(TAG, "coldResetPipStack: force-stopped " + pkg);
        } catch (Throwable t) {
            Log.w(TAG, "coldResetPipStack: force-stop failed for " + pkg, t);
        }
    }

    /**
     * Removes the task records for the package. These, rather than the process itself,
     * carry the old configuration: as long as the task exists, the next launch may
     * simply MOVE it to the new display instead of creating it from scratch.
     */
    private static void removeTasksForPackage(String pkg) {
        if (pkg == null || pkg.isEmpty()) return;
        try {
            Method getService = ActivityManager.class.getMethod("getService");
            Object am = getService.invoke(null);
            if (am == null) return;

            Method removeTask = am.getClass().getMethod("removeTask", int.class);
            removeTask.setAccessible(true);

            for (int i = 0; i < 4; i++) {
                int taskId = WindowHostActivityView.getTaskIdForPackage(LauncherApplication.sApp, pkg);
                if (taskId < 0) return;
                removeTask.invoke(am, taskId);
                Log.i(TAG, "coldResetPipStack: removed task " + taskId + " of " + pkg);
            }
        } catch (Throwable t) {
            Log.w(TAG, "coldResetPipStack: removeTask failed for " + pkg, t);
        }
    }

    /** Checks whether none of the packages has a live process or task record anymore. Called from a background thread. */
    /**
     * Whether no PiP package owns a task any more.
     *
     * Deliberately says nothing about the processes: after the change above they are expected to
     * stay alive, which is the whole point -- an app with no task builds a fresh Activity, with the
     * fresh configuration, when the pane starts it, and does so warm instead of cold.
     */
    private static boolean arePipTasksClear(List<String> pkgs) {
        for (String pkg : pkgs) {
            if (WindowHostActivityView.getTaskIdForPackage(LauncherApplication.sApp, pkg) >= 0) return false;
        }
        return true;
    }

    private static boolean isPipStackClear(List<String> pkgs) {
        for (String pkg : pkgs) {
            if (WindowHostActivityView.isProcessAlive(LauncherApplication.sApp, pkg)) return false;
            if (WindowHostActivityView.getTaskIdForPackage(LauncherApplication.sApp, pkg) >= 0) return false;
        }
        return true;
    }


    // =====================================================================================
    // PINNED PIP
    // =====================================================================================

    public static void openPinnedPip() {
        if (!LauncherApplication.isFytDevice()) return;
        final Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        suppressMediaSourceSwitch();
        // Without this the rebuild window here only expires on its 2.5 s timer, and a user
        // pressing play inside it is discarded as "pane rebuild, not a source switch".
        launcher.handler.postDelayed(() -> notifyPanesSettled(PANES_SETTLED_POLLS), 250);
        if (helpers == null) {
            helpers = new Helpers();
        }
        if (launcher.allowPip
            && Utils.topApp()
            && !helpers.isInWidgets()
            && !helpers.isInAllApps()
            && !helpers.isInOverviewMode()
            && !helpers.isFirstPreferenceWindow()
            && !helpers.isWallpaperWindow()
            && launcher.mAppsCustomizeTabHost != null
            && !helpers.allAppsVisibility(launcher.mAppsCustomizeTabHost.getVisibility())
            || (!helpers.userWasInRecents() && helpers.isListOpen())) {

            if (prefs == null) {
                prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
            }

            if (!checkIfPinned()) return;

            firstPip = prefs.getBoolean(Keys.PIP_FIRST, false);
            secondPip = prefs.getBoolean(Keys.PIP_SECOND, false);
            thirdPip = prefs.getBoolean(Keys.PIP_THIRD, false);
            fourthPip = prefs.getBoolean(Keys.PIP_FOURTH, false);
            if (firstPip && firstPipPinned && isPipPackageInstalled(firstPkg)) {
                openAsPinnedPip(firstPkg, Keys.PIP_FIRST_KEY, Keys.PIP_FIRST_SCREEN);
            }
            
            if (secondPip && secondPipPinned && isPipPackageInstalled(secondPkg)) {
                openAsPinnedPip(secondPkg, Keys.PIP_SECOND_KEY, Keys.PIP_SECOND_SCREEN);
            }
            
            final String thirdPkg = prefs.getString(Keys.PIP_THIRD_PACKAGE, "");
            if (thirdPip && thirdPipPinned && isPipPackageInstalled(thirdPkg)) {
                openAsPinnedPip(thirdPkg, Keys.PIP_THIRD_KEY, Keys.PIP_THIRD_SCREEN);
            }
            
            final String fourthPkg = prefs.getString(Keys.PIP_FOURTH_PACKAGE, "");
            if (fourthPip && fourthPipPinned && isPipPackageInstalled(fourthPkg)) {
                openAsPinnedPip(fourthPkg, Keys.PIP_FOURTH_KEY, Keys.PIP_FOURTH_SCREEN);
            }            
        }
    }

    public static boolean checkIfPinned() {
        if (prefs == null) {
            prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp); 
        }
        firstPipPinned = prefs.getBoolean(Keys.PIP_FIRST_MODE, false);
        secondPipPinned = prefs.getBoolean(Keys.PIP_SECOND_MODE, false);
        thirdPipPinned = prefs.getBoolean(Keys.PIP_THIRD_MODE, false);
        fourthPipPinned = prefs.getBoolean(Keys.PIP_FOURTH_MODE, false);
        return firstPipPinned || secondPipPinned || thirdPipPinned || fourthPipPinned;
    }

    private static void openAsPinnedPip(String packageName, String pipKey, String screenKey) {
        final Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        // Update screen
        SharedPreferences.Editor editor = prefs.edit();
        int pipScreen = prefs.getInt(screenKey, 1) - 1;
        editor.putInt(Keys.PINNED_PIP_SCREEN, pipScreen + 1);
        editor.apply();
        Workspace workspace = workspace();
        if (workspace == null) return;
        int currentScreen = workspace.getCurrentPage();

        if (helpers == null) {
            helpers = new Helpers();
        }

        SystemProperties.set("persist.syu.launcher.haspip", "true");

        if (currentScreen == pipScreen && launcher.mAppsCustomizeTabHost != null
                && !helpers.allAppsVisibility(launcher.mAppsCustomizeTabHost.getVisibility())) {
            String currentPackage = SystemProperties.get("persist.launcher.packagename", "");
            if (DEFAULT_SOURCE_STEALERS.contains(packageName)) {
                Log.i(TAG, "reassertLauncherTop() started for stealer in pinned PiP");
                reassertLauncherTop();
            }
            if (!packageName.equals(currentPackage) || checkIfMapSizeChanged(pipKey)) {
                // save previous values
                editor.putInt("prevPinnedPipTopLeftX", prefs.getInt(pipKey + "TopLeftX", 107));  
                editor.putInt("prevPinnedPipTopLeftY", prefs.getInt(pipKey + "TopLeftY", 57));  
                editor.putInt("prevPinnedPipBottomRightX", prefs.getInt(pipKey + "BottomRightX", 687));   
                editor.putInt("prevPinnedPipBottomRightY", prefs.getInt(pipKey + "BottomRightY", 513));
                editor.apply();

                setPinnedPipBounds(pipKey, screenKey);         
                SystemProperties.set("persist.launcher.packagename", packageName);
                AppPackageName = packageName; 
                restartPinnedPipApp();
                
                launcher.handler.postDelayed(() -> startPinnedPip(packageName), 1000);
            } else {
                setPinnedPipBounds(pipKey, screenKey);         
                SystemProperties.set("persist.launcher.packagename", packageName);
                AppPackageName = packageName; 
                startPinnedPip(packageName); 
            }
        }
    }

    private static void startPinnedPip(String packageName) {
        final Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        Intent intent = FytPackage.getIntent(LauncherApplication.sApp, packageName);
        intent.putExtra("force_pip", true);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        SystemProperties.set("sys.lsec.force_pip", "true");
        if (intent.resolveActivity(LauncherApplication.sApp.getPackageManager()) != null) {
            launcher.handler.postDelayed(() -> LauncherApplication.sApp.startActivity(intent), 100);
        }  
        checkIfOpenedOnTheRightScreen(500);
        checkIfOpenedOnTheRightScreen(1500);
        checkIfOpenedOnTheRightScreen(2000);      
    }

    // removes an error where windows shows up when user quickly changes to the screen on which it shouldn't appear
    private static void checkIfOpenedOnTheRightScreen(int delay) {
        final Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        launcher.handler.postDelayed(() -> {
            Workspace workspace = workspace();
            if (workspace == null) return;
            int pipScreen = prefs.getInt(Keys.PINNED_PIP_SCREEN, 1) - 1;
            if (workspace.getChildCount() > 1 && workspace.getCurrentPage() != pipScreen) {
                removePinnedPip();
            }
        }, delay);
    }

    public static void restartPinnedPipApp() {
        if (!LauncherApplication.isFytDevice()) return;
        final Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        final WindowHost host = host();
        if (host != null) {
            launcher.handler.post(() -> {
                host.cleanup();
                setHost(null);
            });
        }
        if (AppPackageName != null && !AppPackageName.isEmpty()) {
            if (FytPackage.GMAPS.equals(AppPackageName)) {
                Log.i(TAG, "restartPinnedPipApp: skip force-stop for Google Maps");
                return;
            }
            ActivityManager activityManager = (ActivityManager) LauncherApplication.sApp.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
            try {
                Method forceStopPackage = activityManager.getClass().getDeclaredMethod("forceStopPackage", String.class);
                forceStopPackage.setAccessible(true);
                forceStopPackage.invoke(activityManager, AppPackageName);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                Log.e(TAG, "restartPinnedPipApp() failed: " + e);
            }
        }
    }

    private static boolean checkIfMapSizeChanged(String pipKey) {
        int prevPinnedPipTopLeftX = prefs.getInt("prevPinnedPipTopLeftX", 107);
        int prevPinnedPipTopLeftY = prefs.getInt("prevPinnedPipTopLeftY", 57);
        int prevPinnedPipBottomRightX = prefs.getInt("prevPinnedPipBottomRightX", 687);
        int prevPinnedPipBottomRightY = prefs.getInt("prevPinnedPipBottomRightY", 513);

        int curMapTopLeftX = prefs.getInt(pipKey + "TopLeftX", 107);
        int curMapTopLeftY = prefs.getInt(pipKey + "TopLeftY", 57);
        int curMapBottomRightX = prefs.getInt(pipKey + "BottomRightX", 687);
        int curMapBottomRightY = prefs.getInt(pipKey + "BottomRightY", 513);

        return prevPinnedPipTopLeftX != curMapTopLeftX
                || prevPinnedPipTopLeftY != curMapTopLeftY
                || prevPinnedPipBottomRightX != curMapBottomRightX
                || prevPinnedPipBottomRightY != curMapBottomRightY;
    }

    public static void removePinnedPip() {
        if (!LauncherApplication.isFytDevice()) return;
        if (prefs == null) {
            prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp); 
        }
        boolean userLayout  = prefs.getBoolean(Keys.USER_LAYOUT, false);
        if (userLayout) {
            try {
                // Get and call the setPinnedStackVisible(false) method via reflection to remove pinned PiP
                Method getServiceMethod = ActivityManager.class.getMethod("getService");
                Object activityManager = getServiceMethod.invoke(null);
                Class<?> activityManagerClass = Class.forName("android.app.IActivityManager");
                Method setPinnedStackVisibleMethod = activityManagerClass.getMethod("setPinnedStackVisible", boolean.class);
                setPinnedStackVisibleMethod.invoke(activityManager, false);
                Log.i(TAG, "removePinnedPip() pane: dismissed");
            } catch (Throwable t) {
                Log.w(TAG, "removePinnedPip() pane: dismiss failed", t);
            }
        }
    }

    private static void setPinnedPipBounds(String pipKey, String screenKey) {
        final Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        boolean leftBar = prefs.getBoolean(Keys.LEFT_BAR, false);
        int pipScreen = prefs.getInt(screenKey, 1) - 1;
        int margin = Integer.parseInt(prefs.getString("layout_margin", "10"));
        int mapTopLeftX, mapBottomRightX; 

        // Get the specific key for the PiP
        String topLeftXKey = pipKey + "TopLeftX";
        String topLeftYKey = pipKey + "TopLeftY";
        String bottomRightXKey = pipKey + "BottomRightX";
        String bottomRightYKey = pipKey + "BottomRightY";

        int mapMinWidth = Launcher.calculatedPipMinWidth / countEnabledPips();

        if (leftBar && pipScreen == 0) {
            mapTopLeftX = prefs.getInt(topLeftXKey, margin) + Launcher.calculatedLeftBarWidth;
            mapBottomRightX = prefs.getInt(bottomRightXKey, margin + mapMinWidth) + Launcher.calculatedLeftBarWidth;
        } else {
            mapTopLeftX = prefs.getInt(topLeftXKey, margin);
            mapBottomRightX = prefs.getInt(bottomRightXKey, margin + mapMinWidth);
        }

        int mapTopLeftY = prefs.getInt(topLeftYKey, margin + Launcher.calculatedDateMinHeight + margin)
                + launcher.getStatusBarHeight();
        int mapBottomRightY = prefs.getInt(bottomRightYKey,
                margin + Launcher.calculatedDateMinHeight + margin + Launcher.calculatedPipMinHeight)
                + launcher.getStatusBarHeight();

        // top-left x, top left y, bottom right x, bottom right y
        SystemProperties.set("sys.lsec.pip_rect", mapTopLeftX + " " + mapTopLeftY + " " + mapBottomRightX + " " + mapBottomRightY);
    }

    // Never returns 0, max value is 2
    private static int countEnabledPips() {
        int count = 0;
        if (firstPip) count++;
        if (secondPip) count++;
        if (thirdPip) count++;
        if (fourthPip) count++;
        return Math.min(Math.max(1, count), 2);
    }

    // =====================================================================================
    // FAB
    // =====================================================================================

    public static void swapAllPanes() {
        try {
            if (prefs == null) {
                prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
            }
            dualPip         = prefs.getBoolean(Keys.PIP_DUAL, false);
            firstPip        = prefs.getBoolean(Keys.PIP_FIRST, false);
            secondPip       = prefs.getBoolean(Keys.PIP_SECOND, false);
            thirdPip        = prefs.getBoolean(Keys.PIP_THIRD, false);
            fourthPip       = prefs.getBoolean(Keys.PIP_FOURTH, false);
            thirdPipPinned  = prefs.getBoolean(Keys.PIP_THIRD_MODE, false);
            fourthPipPinned = prefs.getBoolean(Keys.PIP_FOURTH_MODE, false);

            int covers = coverForRightAndFourthSwap() + coverForLeftAndThirdSwap();

            if (covers <= 0) {
                swapRightAndFourth();
                new Handler(Looper.getMainLooper()).postDelayed(WindowUtil::swapLeftAndThird, 100);
                return;
            }

            WindowHostSplash.beginSyncedReveal(covers, 4000L);

            final Handler main = new Handler(Looper.getMainLooper());
            main.postDelayed(() -> {
                try {
                    swapRightAndFourth();
                } catch (Throwable t) {
                    Log.w(TAG, "swapAllPanes: right/fourth failed", t);
                }
                main.postDelayed(() -> {
                    try {
                        swapLeftAndThird();
                    } catch (Throwable t) {
                        Log.w(TAG, "swapAllPanes: left/third failed", t);
                    }
                }, 32);
            }, 48);
        } catch (Throwable t) {
            Log.w(TAG, "swapAllPanes failed", t);
            WindowHostSplash.cancelSyncedReveal();
        }
    }

    /**
     * Raises the covers for the left/first <-> third pair, each with the app icon that is coming
     * INTO that window (the panel fields are replaced only later, so the panel itself does not know).
     *
     * @return the number of covers actually raised -- needed for the reveal barrier
     */
    private static int coverForLeftAndThirdSwap() {
        int covered = 0;
        try {
            WindowHost host = host();
            if (host == null) return 0;

            Object dual  = reflectGetField(host, "dual");
            Object third = reflectGetField(host, "third");
            Object first = reflectGetField(host, "first");

            String dualLeftPkgNow = (String) reflectGetField(dual, "leftPkg");
            String thirdPkgNow    = (String) reflectGetField(third, "currentPkg");
            String firstPkgNow    = (String) reflectGetField(first, "currentPkg");

            boolean dualBranch = (dualPip && thirdPip && !thirdPipPinned)
                    && (dual != null && third != null);

            if (dualBranch) {
                invokeIfExists(dual,  "coverLeftForHandoff", thirdPkgNow);
                invokeIfExists(third, "coverForHandoff", dualLeftPkgNow);
                covered += 2;
            } else if (first != null && third != null) {
                invokeIfExists(first, "coverForHandoff", thirdPkgNow);
                invokeIfExists(third, "coverForHandoff", firstPkgNow);
                covered += 2;
            }
        } catch (Throwable t) {
            Log.w(TAG, "coverForLeftAndThirdSwap failed", t);
        }
        return covered;
    }

    /**
     * Raises the covers for the right/second <-> fourth pair. See coverForLeftAndThirdSwap().
     *
     * @return the number of covers actually raised
     */
    private static int coverForRightAndFourthSwap() {
        int covered = 0;
        try {
            WindowHost host = host();
            if (host == null) return 0;

            Object dual   = reflectGetField(host, "dual");
            Object fourth = reflectGetField(host, "fourth");
            Object second = reflectGetField(host, "second");

            String dualRightPkgNow = (String) reflectGetField(dual, "rightPkg");
            String fourthPkgNow    = (String) reflectGetField(fourth, "currentPkg");
            String secondPkgNow    = (String) reflectGetField(second, "currentPkg");

            boolean dualBranch = (dualPip && fourthPip && !fourthPipPinned)
                    && (dual != null && fourth != null);

            if (dualBranch) {
                invokeIfExists(dual,   "coverRightForHandoff", fourthPkgNow);
                invokeIfExists(fourth, "coverForHandoff", dualRightPkgNow);
                covered += 2;
            } else if (second != null && fourth != null) {
                invokeIfExists(second, "coverForHandoff", fourthPkgNow);
                invokeIfExists(fourth, "coverForHandoff", secondPkgNow);
                covered += 2;
            }
        } catch (Throwable t) {
            Log.w(TAG, "coverForRightAndFourthSwap failed", t);
        }
        return covered;
    }

    // --------- left/first <-> third ----------
    public static void swapLeftAndThird() {
        try {
            // Block floating button while swapping (preserve existing behavior)
            try {
                if (Launcher.mLauncher != null) {
                    Launcher.mLauncher.sendBroadcast(new Intent(Keys.BLOCK_FLOATING_BUTTON));
                }
            } catch (Throwable ignore) {}

            WindowHost host = host();
            if (host == null) {
                Log.w(TAG, "swapLeftAndThird: WindowHost not available");
                return;
            }

            Object dual = reflectGetField(host, "dual");
            Object third = reflectGetField(host, "third");
            Object first = reflectGetField(host, "first");

            dualPip = prefs.getBoolean(Keys.PIP_DUAL, false);
            firstPip = prefs.getBoolean(Keys.PIP_FIRST, false);
            thirdPip = prefs.getBoolean(Keys.PIP_THIRD, false);
            thirdPipPinned = prefs.getBoolean(Keys.PIP_THIRD_MODE, false);

            coverForLeftAndThirdSwap();

            // Try dual.left <-> third first (if dual mode active)
            if ((dualPip && thirdPip && !thirdPipPinned) && (dual != null && third != null)) {
                try {
                    Object dualLeftAV = reflectGetField(dual, "leftAV");
                    ViewGroup dualLeftHost = (ViewGroup) reflectGetField(dual, "leftHost");
                    Object thirdAv = reflectGetField(third, "av");
                    ViewGroup thirdHost = (ViewGroup) reflectGetField(third, "host");

                    String dualLeftPkg = (String) reflectGetField(dual, "leftPkg");
                    String thirdPkg = (String) reflectGetField(third, "currentPkg");

                    final View viewForDualLeft = asView(dualLeftAV);
                    final View viewForThird = asView(thirdAv);

                    // 1) atomic native-surface swap
                    boolean atomicOk = false;
                    try {
                        if (viewForDualLeft != null && viewForThird != null) {
                            atomicOk = WindowHostReparenter.swapActivityViewSurfaces(viewForDualLeft, viewForThird, 1000);
                        } else {
                            Log.w(TAG, "swapLeftAndThird: viewForDualLeft or viewForThird is null, skipping atomic swap");
                        }
                    } catch (Throwable t) {
                        Log.w(TAG, "swapLeftAndThird: atomic swap threw", t);
                    }

                    if (atomicOk) {
                        // Atomic succeeded — update host fields and reattach views after a short delay
                        try {
                            if (dualLeftHost != null) try { dualLeftHost.removeAllViews(); } catch (Throwable ignore) {}
                            if (thirdHost != null)    try { thirdHost.removeAllViews(); }    catch (Throwable ignore) {}

                            reflectSetField(dual, "leftAV", thirdAv);
                            reflectSetField(third, "av", dualLeftAV);

                            Object dualLeftAttached = reflectGetField(dual, "leftAttached");
                            Object thirdChildAttached = reflectGetField(third, "childAttached");
                            if (dualLeftAttached instanceof Boolean && thirdChildAttached instanceof Boolean) {
                                reflectSetField(dual, "leftAttached", thirdChildAttached);
                                reflectSetField(third, "childAttached", dualLeftAttached);
                            }

                            Integer dualLeftTask = (Integer) reflectGetField(dual, "leftTask");
                            Integer thirdTaskId = (Integer) reflectGetField(third, "taskId");
                            reflectSetField(dual, "leftTask", thirdTaskId == null ? -1 : thirdTaskId);
                            reflectSetField(third, "taskId", dualLeftTask == null ? -1 : dualLeftTask);

                            String oldDualLeftPkg = (String) reflectGetField(dual, "leftPkg");
                            String oldThirdPkg = (String) reflectGetField(third, "currentPkg");
                            reflectSetField(dual, "leftPkg", oldThirdPkg);
                            reflectSetField(third, "currentPkg", oldDualLeftPkg);

                            // Update preferences: swapped first <-> third packages (dual.left maps to first)
                            swapPrefsPackages(Keys.PIP_FIRST_PACKAGE, Keys.PIP_THIRD_PACKAGE);

                            final Object dualRef = dual;
                            final Object thirdRef = third;
                            final ViewGroup dualLeftHostFinal = dualLeftHost;
                            final ViewGroup thirdHostFinal = thirdHost;
                            // The views trade places, so each host now holds the other package.
                            final String pkgNowInDualLeft = oldThirdPkg;
                            final String pkgNowInThird = oldDualLeftPkg;

                            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                                try {
                                    Object newDualLeftAV = reflectGetField(dualRef, "leftAV");
                                    Object newThirdAv = reflectGetField(thirdRef, "av");
                                    View newViewForDualLeft = asView(newDualLeftAV);
                                    View newViewForThird = asView(newThirdAv);

                                    // After the swap dual.left holds what used to be in third,
                                    // and vice versa -- so the packages travel with the views.
                                    reparentPairOrdered(dualLeftHostFinal, newViewForDualLeft, pkgNowInDualLeft,
                                                        thirdHostFinal, newViewForThird, pkgNowInThird);

                                    // Force the dual pane to recompute correct per-pane geometry
                                    // (portrait-safe/supersample vs plain match-parent) for the
                                    // pkg that just moved in, instead of leaving it at whatever
                                    // transform reparentHostChild reset it to until the user
                                    // happens to drag the divider.
                                    resyncAfterSwap(dualRef, thirdRef);
                                } catch (Throwable t) {
                                    Log.w(TAG, "swapLeftAndThird: delayed reattach failed", t);
                                }
                            }, 50);

                            Log.i(TAG, "swapLeftAndThird: atomic swap succeeded (scheduled reattach)");
                            return;
                        } catch (Throwable t) {
                            Log.w(TAG, "swapLeftAndThird: atomic followup failed, will try fallback", t);
                            // continue to fallback logic
                        }
                    }

                    // 2) atomic failed — try task-relocate if we have valid task ids
                    Integer leftTaskId = (Integer) reflectGetField(dual, "leftTask");
                    Integer thirdTask = (Integer) reflectGetField(third, "taskId");
                    if (leftTaskId != null && leftTaskId > 0 && thirdTask != null && thirdTask > 0) {
                        boolean started = attemptTaskRelocateSwap(
                                dualLeftHost, thirdHost,
                                dualLeftAV, thirdAv,
                                leftTaskId, thirdTask,
                                dualLeftPkg, thirdPkg,
                                lastPipBounds.getOrDefault("dual", offscreen),
                                lastPipBounds.getOrDefault("third", offscreen)
                        );
                        if (started) {
                            // update prefs for the logical swap (first <-> third)
                            swapPrefsPackages(Keys.PIP_FIRST_PACKAGE, Keys.PIP_THIRD_PACKAGE);
                            Log.i(TAG, "swapLeftAndThird: started task-relocate fallback (async)");
                            return;
                        }
                    }

                    // 3) fallback: overlay double-buffer handoff (keeps old AV until new one ready)
                    safeOverlaySwapPanes(
                            dualLeftHost, thirdHost,
                            dualLeftAV, thirdAv,
                            dualLeftPkg, thirdPkg,
                            lastPipBounds.getOrDefault("dual", offscreen),
                            lastPipBounds.getOrDefault("third", offscreen),
                            "leftAV", dual, third
                    );

                    // Update prefs for fallback overlay swap
                    swapPrefsPackages(Keys.PIP_FIRST_PACKAGE, Keys.PIP_THIRD_PACKAGE);

                    return;

                } catch (Throwable t) {
                    Log.w(TAG, "swapLeftAndThird: error in dual-case fallback", t);
                }
            }

            // If no dual or earlier path did not apply, try standalone first<->third
            if ((firstPip && thirdPip) && (first != null && third != null)) {
                try {
                    Object firstAv = reflectGetField(first, "av");
                    ViewGroup firstHost = (ViewGroup) reflectGetField(first, "host");
                    Object thirdAv = reflectGetField(third, "av");
                    ViewGroup thirdHost = (ViewGroup) reflectGetField(third, "host");

                    String firstPkg = (String) reflectGetField(first, "currentPkg");
                    String thirdPkg = (String) reflectGetField(third, "currentPkg");

                    final View viewFirst = asView(firstAv);
                    final View viewThird = asView(thirdAv);

                    boolean atomicOk = false;
                    try {
                        if (viewFirst != null && viewThird != null) {
                            atomicOk = WindowHostReparenter.swapActivityViewSurfaces(viewFirst, viewThird, 1000);
                        } else {
                            Log.w(TAG, "swapLeftAndThird: viewFirst or viewThird null, skipping atomic");
                        }
                    } catch (Throwable t) {
                        Log.w(TAG, "swapLeftAndThird: atomic swap (standalone) threw", t);
                    }

                    if (atomicOk) {
                        try {
                            if (firstHost != null) try { firstHost.removeAllViews(); } catch (Throwable ignore) {}
                            if (thirdHost != null) try { thirdHost.removeAllViews(); } catch (Throwable ignore) {}

                            reflectSetField(first, "av", thirdAv);
                            reflectSetField(third, "av", firstAv);

                            Object firstAttached = reflectGetField(first, "childAttached");
                            Object thirdAttached = reflectGetField(third, "childAttached");
                            if (firstAttached instanceof Boolean && thirdAttached instanceof Boolean) {
                                reflectSetField(first, "childAttached", thirdAttached);
                                reflectSetField(third, "childAttached", firstAttached);
                            }

                            Integer firstTask = (Integer) reflectGetField(first, "taskId");
                            Integer thirdTask = (Integer) reflectGetField(third, "taskId");
                            reflectSetField(first, "taskId", thirdTask == null ? -1 : thirdTask);
                            reflectSetField(third, "taskId", firstTask == null ? -1 : firstTask);

                            String firstPkgOld = (String) reflectGetField(first, "currentPkg");
                            String thirdPkgOld = (String) reflectGetField(third, "currentPkg");
                            reflectSetField(first, "currentPkg", thirdPkgOld);
                            reflectSetField(third, "currentPkg", firstPkgOld);

                            // Update prefs: swap first <-> third
                            swapPrefsPackages(Keys.PIP_FIRST_PACKAGE, Keys.PIP_THIRD_PACKAGE);

                            final Object firstRef = first;
                            final Object thirdRef = third;
                            final String pkgNowInFirst = thirdPkgOld;
                            final String pkgNowInThird = firstPkgOld;
                            final ViewGroup firstHostFinal = firstHost;
                            final ViewGroup thirdHostFinal = thirdHost;

                            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                                try {
                                    Object newFirstAv = reflectGetField(firstRef, "av");
                                    Object newThirdAv = reflectGetField(thirdRef, "av");
                                    View newViewForFirst = asView(newFirstAv);
                                    View newViewForThird = asView(newThirdAv);

                                    reparentPairOrdered(firstHostFinal, newViewForFirst, pkgNowInFirst,
                                                        thirdHostFinal, newViewForThird, pkgNowInThird);

                                    resyncAfterSwap(firstRef, thirdRef);
                                } catch (Throwable t) {
                                    Log.w(TAG, "swapLeftAndThird: delayed reattach failed (standalone)", t);
                                }
                            }, 50);

                            Log.i(TAG, "swapLeftAndThird: atomic standalone swap scheduled reattach");
                            return;
                        } catch (Throwable t) {
                            Log.w(TAG, "swapLeftAndThird: atomic standalone followup failed", t);
                        }
                    }

                    // Attempt task-relocate for standalone
                    Integer tA = (Integer) reflectGetField(first, "taskId");
                    Integer tB = (Integer) reflectGetField(third, "taskId");
                    if (tA != null && tA > 0 && tB != null && tB > 0) {
                        boolean started = attemptTaskRelocateSwap(
                                firstHost, thirdHost,
                                firstAv, thirdAv,
                                tA, tB,
                                firstPkg, thirdPkg,
                                lastPipBounds.getOrDefault("first", offscreen),
                                lastPipBounds.getOrDefault("third", offscreen)
                        );
                        if (started) {
                            // update prefs for the logical swap (first <-> third)
                            swapPrefsPackages(Keys.PIP_FIRST_PACKAGE, Keys.PIP_THIRD_PACKAGE);
                            Log.i(TAG, "swapLeftAndThird: started task-relocate fallback (standalone)");
                            return;
                        }
                    }

                    // Final fallback: overlay handoff
                    safeOverlaySwapPanes(
                            firstHost, thirdHost,
                            firstAv, thirdAv,
                            firstPkg, thirdPkg,
                            lastPipBounds.getOrDefault("first", offscreen),
                            lastPipBounds.getOrDefault("third", offscreen),
                            "av", first, third
                    );

                    // Update prefs for fallback overlay swap
                    swapPrefsPackages(Keys.PIP_FIRST_PACKAGE, Keys.PIP_THIRD_PACKAGE);

                    return;

                } catch (Throwable t) {
                    Log.w(TAG, "swapLeftAndThird: standalone handling failed", t);
                }
            }

            Log.i(TAG, "swapLeftAndThird: nothing to swap or all strategies failed");
        } catch (Throwable e) {
            Log.w(TAG, "swapLeftAndThird: unexpected error", e);
        }
    }

    // --------- right/second <-> fourth ----------
    public static void swapRightAndFourth() {
        try {
            // Block floating button while swapping
            try {
                if (Launcher.mLauncher != null) {
                    Launcher.mLauncher.sendBroadcast(new Intent(Keys.BLOCK_FLOATING_BUTTON));
                }
            } catch (Throwable ignore) {}

            WindowHost host = host();
            if (host == null) {
                Log.w(TAG, "swapRightAndFourth: WindowHost not available");
                return;
            }

            Object dual = reflectGetField(host, "dual");
            Object fourth = reflectGetField(host, "fourth");
            Object second = reflectGetField(host, "second");

            dualPip = prefs.getBoolean(Keys.PIP_DUAL, false);
            secondPip = prefs.getBoolean(Keys.PIP_SECOND, false);
            fourthPip = prefs.getBoolean(Keys.PIP_FOURTH, false);
            fourthPipPinned = prefs.getBoolean(Keys.PIP_FOURTH_MODE, false);

            coverForRightAndFourthSwap();

            // Prefer dual.right <-> fourth if present
            if ((dualPip && fourthPip && !fourthPipPinned) && (dual != null && fourth != null)) {
                try {
                    Object dualRightAV = reflectGetField(dual, "rightAV");
                    ViewGroup dualRightHost = (ViewGroup) reflectGetField(dual, "rightHost");
                    Object fourthAv = reflectGetField(fourth, "av");
                    ViewGroup fourthHost = (ViewGroup) reflectGetField(fourth, "host");

                    String dualRightPkg = (String) reflectGetField(dual, "rightPkg");
                    String fourthPkg = (String) reflectGetField(fourth, "currentPkg");

                    final View viewForDualRight = asView(dualRightAV);
                    final View viewForFourth = asView(fourthAv);

                    // 1) atomic native-surface swap
                    boolean atomicOk = false;
                    try {
                        if (viewForDualRight != null && viewForFourth != null) {
                            atomicOk = WindowHostReparenter.swapActivityViewSurfaces(viewForDualRight, viewForFourth, 1000);
                        } else {
                            Log.w(TAG, "swapRightAndFourth: viewForDualRight or viewForFourth is null, skipping atomic swap");
                        }
                    } catch (Throwable t) {
                        Log.w(TAG, "swapRightAndFourth: atomic swap threw", t);
                    }

                    if (atomicOk) {
                        try {
                            if (dualRightHost != null) try { dualRightHost.removeAllViews(); } catch (Throwable ignore) {}
                            if (fourthHost != null)    try { fourthHost.removeAllViews(); }    catch (Throwable ignore) {}

                            reflectSetField(dual, "rightAV", fourthAv);
                            reflectSetField(fourth, "av", dualRightAV);

                            Object dualRightAttached = reflectGetField(dual, "rightAttached");
                            Object fourthChildAttached = reflectGetField(fourth, "childAttached");
                            if (dualRightAttached instanceof Boolean && fourthChildAttached instanceof Boolean) {
                                reflectSetField(dual, "rightAttached", fourthChildAttached);
                                reflectSetField(fourth, "childAttached", dualRightAttached);
                            }

                            Integer dualRightTask = (Integer) reflectGetField(dual, "rightTask");
                            Integer fourthTaskId = (Integer) reflectGetField(fourth, "taskId");
                            reflectSetField(dual, "rightTask", fourthTaskId == null ? -1 : fourthTaskId);
                            reflectSetField(fourth, "taskId", dualRightTask == null ? -1 : dualRightTask);

                            String oldDualRightPkg = (String) reflectGetField(dual, "rightPkg");
                            String oldFourthPkg = (String) reflectGetField(fourth, "currentPkg");
                            reflectSetField(dual, "rightPkg", oldFourthPkg);
                            reflectSetField(fourth, "currentPkg", oldDualRightPkg);

                            // Update preferences: swapped second <-> fourth packages (dual.right maps to second)
                            swapPrefsPackages(Keys.PIP_SECOND_PACKAGE, Keys.PIP_FOURTH_PACKAGE);

                            final Object dualRef = dual;
                            final Object fourthRef = fourth;
                            final String pkgNowInDualRight = oldFourthPkg;
                            final String pkgNowInFourth = oldDualRightPkg;
                            final ViewGroup dualRightHostFinal = dualRightHost;
                            final ViewGroup fourthHostFinal = fourthHost;
                            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                                try {
                                    Object newDualRightAV = reflectGetField(dualRef, "rightAV");
                                    Object newFourthAv = reflectGetField(fourthRef, "av");
                                    View newViewForDualRight = asView(newDualRightAV);
                                    View newViewForFourth = asView(newFourthAv);

                                    reparentPairOrdered(dualRightHostFinal, newViewForDualRight, pkgNowInDualRight,
                                                        fourthHostFinal, newViewForFourth, pkgNowInFourth);

                                    resyncAfterSwap(dualRef, fourthRef);
                                } catch (Throwable t) {
                                    Log.w(TAG, "swapRightAndFourth: delayed reattach failed", t);
                                }
                            }, 50);

                            Log.i(TAG, "swapRightAndFourth: atomic swap succeeded (scheduled reattach)");
                            return;
                        } catch (Throwable t) {
                            Log.w(TAG, "swapRightAndFourth: atomic followup failed, will try fallback", t);
                        }
                    }

                    // 2) atomic failed — try task-relocate
                    Integer rightTaskId = (Integer) reflectGetField(dual, "rightTask");
                    Integer fourthTask = (Integer) reflectGetField(fourth, "taskId");
                    if (rightTaskId != null && rightTaskId > 0 && fourthTask != null && fourthTask > 0) {
                        boolean started = attemptTaskRelocateSwap(
                                dualRightHost, fourthHost,
                                dualRightAV, fourthAv,
                                rightTaskId, fourthTask,
                                dualRightPkg, fourthPkg,
                                lastPipBounds.getOrDefault("dual", offscreen),
                                lastPipBounds.getOrDefault("fourth", offscreen)
                        );
                        if (started) {
                            // update prefs for the logical swap (second <-> fourth)
                            swapPrefsPackages(Keys.PIP_SECOND_PACKAGE, Keys.PIP_FOURTH_PACKAGE);
                            Log.i(TAG, "swapRightAndFourth: started task-relocate fallback (async)");
                            return;
                        }
                    }

                    // 3) overlay fallback
                    safeOverlaySwapPanes(
                            dualRightHost, fourthHost,
                            dualRightAV, fourthAv,
                            dualRightPkg, fourthPkg,
                            lastPipBounds.getOrDefault("dual", offscreen),
                            lastPipBounds.getOrDefault("fourth", offscreen),
                            "rightAV", dual, fourth
                    );

                    // Update prefs for fallback overlay swap
                    swapPrefsPackages(Keys.PIP_SECOND_PACKAGE, Keys.PIP_FOURTH_PACKAGE);

                    return;

                } catch (Throwable t) {
                    Log.w(TAG, "swapRightAndFourth: dual-case error", t);
                }
            }

            // Standalone second <-> fourth
            if ((secondPip && fourthPip) && (second != null && fourth != null)) {
                try {
                    Object secondAv = reflectGetField(second, "av");
                    ViewGroup secondHost = (ViewGroup) reflectGetField(second, "host");
                    Object fourthAv = reflectGetField(fourth, "av");
                    ViewGroup fourthHost = (ViewGroup) reflectGetField(fourth, "host");

                    String secondPkg = (String) reflectGetField(second, "currentPkg");
                    String fourthPkg = (String) reflectGetField(fourth, "currentPkg");

                    final View viewSecond = asView(secondAv);
                    final View viewFourth = asView(fourthAv);

                    boolean atomicOk = false;
                    try {
                        if (viewSecond != null && viewFourth != null) {
                            atomicOk = WindowHostReparenter.swapActivityViewSurfaces(viewSecond, viewFourth, 1000);
                        } else {
                            Log.w(TAG, "swapRightAndFourth: viewSecond or viewFourth null, skipping atomic");
                        }
                    } catch (Throwable t) {
                        Log.w(TAG, "swapRightAndFourth: atomic (standalone) threw", t);
                    }

                    if (atomicOk) {
                        try {
                            if (secondHost != null) try { secondHost.removeAllViews(); } catch (Throwable ignore) {}
                            if (fourthHost != null) try { fourthHost.removeAllViews(); } catch (Throwable ignore) {}

                            reflectSetField(second, "av", fourthAv);
                            reflectSetField(fourth, "av", secondAv);

                            Object secondAttached = reflectGetField(second, "childAttached");
                            Object fourthAttached = reflectGetField(fourth, "childAttached");
                            if (secondAttached instanceof Boolean && fourthAttached instanceof Boolean) {
                                reflectSetField(second, "childAttached", fourthAttached);
                                reflectSetField(fourth, "childAttached", secondAttached);
                            }

                            Integer secondTask = (Integer) reflectGetField(second, "taskId");
                            Integer fourthTask = (Integer) reflectGetField(fourth, "taskId");
                            reflectSetField(second, "taskId", fourthTask == null ? -1 : fourthTask);
                            reflectSetField(fourth, "taskId", secondTask == null ? -1 : secondTask);

                            String secondPkgOld = (String) reflectGetField(second, "currentPkg");
                            String fourthPkgOld = (String) reflectGetField(fourth, "currentPkg");
                            reflectSetField(second, "currentPkg", fourthPkgOld);
                            reflectSetField(fourth, "currentPkg", secondPkgOld);

                            // Update prefs: swap second <-> fourth
                            swapPrefsPackages(Keys.PIP_SECOND_PACKAGE, Keys.PIP_FOURTH_PACKAGE);

                            final Object secondRef = second;
                            final Object fourthRef = fourth;
                            final String pkgNowInSecond = fourthPkgOld;
                            final String pkgNowInFourth = secondPkgOld;
                            final ViewGroup secondHostFinal = secondHost;
                            final ViewGroup fourthHostFinal = fourthHost;
                            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                                try {
                                    Object newSecondAv = reflectGetField(secondRef, "av");
                                    Object newFourthAv = reflectGetField(fourthRef, "av");
                                    View newViewForSecond = asView(newSecondAv);
                                    View newViewForFourth = asView(newFourthAv);

                                    reparentPairOrdered(secondHostFinal, newViewForSecond, pkgNowInSecond,
                                                        fourthHostFinal, newViewForFourth, pkgNowInFourth);

                                    resyncAfterSwap(secondRef, fourthRef);
                                } catch (Throwable t) {
                                    Log.w(TAG, "swapRightAndFourth: delayed reattach failed (standalone)", t);
                                }
                            }, 50);

                            Log.i(TAG, "swapRightAndFourth: atomic standalone swap scheduled reattach");
                            return;
                        } catch (Throwable t) {
                            Log.w(TAG, "swapRightAndFourth: atomic standalone followup failed", t);
                        }
                    }

                    // try task-relocate
                    Integer tA = (Integer) reflectGetField(second, "taskId");
                    Integer tB = (Integer) reflectGetField(fourth, "taskId");
                    if (tA != null && tA > 0 && tB != null && tB > 0) {
                        boolean started = attemptTaskRelocateSwap(
                                secondHost, fourthHost,
                                secondAv, fourthAv,
                                tA, tB,
                                secondPkg, fourthPkg,
                                lastPipBounds.getOrDefault("second", offscreen),
                                lastPipBounds.getOrDefault("fourth", offscreen)
                        );
                        if (started) {
                            // update prefs for the logical swap (second <-> fourth)
                            swapPrefsPackages(Keys.PIP_SECOND_PACKAGE, Keys.PIP_FOURTH_PACKAGE);
                            Log.i(TAG, "swapRightAndFourth: started task-relocate fallback (standalone)");
                            return;
                        }
                    }

                    // overlay fallback
                    safeOverlaySwapPanes(
                            secondHost, fourthHost,
                            secondAv, fourthAv,
                            secondPkg, fourthPkg,
                            lastPipBounds.getOrDefault("second", offscreen),
                            lastPipBounds.getOrDefault("fourth", offscreen),
                            "av", second, fourth
                    );

                    // Update prefs for fallback overlay swap
                    swapPrefsPackages(Keys.PIP_SECOND_PACKAGE, Keys.PIP_FOURTH_PACKAGE);

                    return;

                } catch (Throwable t) {
                    Log.w(TAG, "swapRightAndFourth: standalone handling failed", t);
                }
            }

            Log.i(TAG, "swapRightAndFourth: nothing to swap or all strategies failed");
        } catch (Throwable e) {
            Log.w(TAG, "swapRightAndFourth: unexpected error", e);
        }
    }

    private static void invokeIfExists(Object obj, String methodName) {
        if (obj == null) return;
        try {
            Method m = obj.getClass().getDeclaredMethod(methodName);
            m.setAccessible(true);
            m.invoke(obj);
        } catch (NoSuchMethodException nsf) {
            Log.w(TAG, "invokeIfExists: " + obj.getClass().getSimpleName()
                    + " no such method: " + methodName + " — the geometry will not be resynchronized after the swap");
        } catch (Throwable t) {
            Log.w(TAG, "invokeIfExists failed: " + methodName, t);
        }
    }

    private static void invokeIfExists(Object obj, String methodName, String arg) {
        if (obj == null) return;
        try {
            Method m = obj.getClass().getDeclaredMethod(methodName, String.class);
            m.setAccessible(true);
            m.invoke(obj, arg);
        } catch (NoSuchMethodException nsf) {
            invokeIfExists(obj, methodName);
        } catch (Throwable t) {
            Log.w(TAG, "invokeIfExists failed: " + methodName, t);
        }
    }


    private static void resyncAfterSwap(Object... hostRefs) {
        for (Object ref : hostRefs) {
            invokeIfExists(ref, RESYNC_GEOMETRY_METHOD);
        }
    }

    private static Object reflectGetField(Object obj, String name) {
        if (obj == null) return null;
        try {
            Field f = null;
            try { f = obj.getClass().getDeclaredField(name); } catch (NoSuchFieldException ignored) {}
            if (f == null) {
                // fallback case-insensitive search
                for (Field ff : obj.getClass().getDeclaredFields()) {
                    if (ff.getName().equalsIgnoreCase(name)) { f = ff; break; }
                }
            }
            if (f == null) return null;
            f.setAccessible(true);
            return f.get(obj);
        } catch (Throwable t) {
            Log.w(TAG, "reflectGetField failed for " + name + " on " + obj.getClass().getName(), t);
            return null;
        }
    }

    private static void reflectSetField(Object obj, String name, Object value) {
        if (obj == null) return;
        try {
            Field f = null;
            try { f = obj.getClass().getDeclaredField(name); } catch (NoSuchFieldException ignored) {}
            if (f == null) {
                for (Field ff : obj.getClass().getDeclaredFields()) {
                    if (ff.getName().equalsIgnoreCase(name)) { f = ff; break; }
                }
            }
            if (f == null) return;
            f.setAccessible(true);
            f.set(obj, value);
        } catch (Throwable t) {
            Log.w(TAG, "reflectSetField failed for " + name + " on " + obj.getClass().getName(), t);
        }
    }

    private static View asView(Object avObj) {
        if (avObj == null) return null;
        // In this ROM the av objects are ActivityView instances (which are Views)
        if (avObj instanceof View) return (View) avObj;
        try {
            // fallback: try WindowHostActivityView.asView(Object) reflectively if available
            Class<?> whav = Class.forName("com.syu.util.WindowHostActivityView");
            try {
                Method asView = whav.getDeclaredMethod("asView", Object.class);
                asView.setAccessible(true);
                Object res = asView.invoke(null, avObj);
                if (res instanceof View) return (View) res;
            } catch (NoSuchMethodException ignored) {}
        } catch (Throwable ignored) {}
        return null;
    }

    private static void markReparentInFlight(View child) {
        if (child == null) return;
        synchronized (sReparentUnsettledUntil) {
            sReparentUnsettledUntil.put(child, Long.MAX_VALUE);
        }
    }

    private static void markReparentSettled(View child) {
        if (child == null) return;
        synchronized (sReparentUnsettledUntil) {
            sReparentUnsettledUntil.put(child, SystemClock.uptimeMillis() + REPARENT_SETTLE_GRACE_MS);
        }
    }

    /** True while {@code child}'s ActivityView is mid native-reparent or still inside its post-reparent settle window. */
    public static boolean isReparentUnsettled(View child) {
        if (child == null) return false;
        Long until;
        synchronized (sReparentUnsettledUntil) {
            until = sReparentUnsettledUntil.get(child);
        }
        if (until == null) return false;
        return SystemClock.uptimeMillis() < until;
    }

    private static void reparentHostChild(Object hostContainer, View newChild) {
        try {
            if (hostContainer == null) return;
            if (!(hostContainer instanceof ViewGroup vg)) {
                Log.w(TAG, "reparentHostChild: hostContainer is not a ViewGroup: " + hostContainer.getClass().getName());
                return;
            }
            try { vg.removeAllViews(); } catch (Throwable ignore) {}

            if (newChild != null) {
                markReparentInFlight(newChild);
                try {
                    ViewParent p = newChild.getParent();
                    if (p instanceof ViewGroup) {
                        ((ViewGroup) p).removeView(newChild);
                    }
                } catch (Throwable ignore) {}
                try { newChild.setVisibility(View.GONE); } catch (Throwable ignore) {}
                try {
                    newChild.setScaleX(1f);
                    newChild.setScaleY(1f);
                    newChild.setTranslationX(0f);
                    newChild.setTranslationY(0f);
                    newChild.setPivotX(0f);
                    newChild.setPivotY(0f);
                } catch (Throwable ignore) {}

                // Best-effort: attempt native reparent and wait until WindowSession reports success.
                final View finalChild = newChild;
                final ViewGroup finalVg = vg;
                final long deadline = SystemClock.uptimeMillis() + 1000; // 1s timeout
                final Handler mainH = new Handler(Looper.getMainLooper());
                final long[] firstOkAt = { -1L };
                final long MIN_STABLE_WINDOW_MS = 120L;
                // 40 ms steps meant the 120 ms window was only ever detected on the fourth tick,
                // i.e. four reparent binder calls per pane -- sixteen for a four-pane swap. A finer
                // step confirms on the tick the window actually elapses.
                final long REPARENT_POLL_MS = 16L;

                final Runnable waiter = new Runnable() {
                    @Override public void run() {
                        try {
                            boolean ok;
                            try {
                                ok = WindowHostReparenter.notifyReparentDisplayContentToHost(finalChild, finalVg);
                            } catch (Throwable t) {
                                Log.d(TAG, "reparentHostChild: notifyReparentDisplayContentToHost threw", t);
                                ok = false;
                            }

                            if (!ok) {
                                firstOkAt[0] = -1L; // każdy false zeruje okno stabilności
                            } else if (firstOkAt[0] < 0) {
                                firstOkAt[0] = SystemClock.uptimeMillis();
                            }
                            boolean stable = ok && firstOkAt[0] > 0
                                    && (SystemClock.uptimeMillis() - firstOkAt[0]) >= MIN_STABLE_WINDOW_MS;

                            if (stable) {
                                attachNow();
                                return;
                            }

                            if (SystemClock.uptimeMillis() < deadline) {
                                // Every tick is a reparent binder call, so once the first one has
                                // succeeded there is nothing to learn from repeating it on a short
                                // grid -- the stability window is a wait, not a measurement. Sleep
                                // straight to the end of the window and confirm once. A four-pane
                                // swap went from twenty of these calls to eight.
                                long step = REPARENT_POLL_MS;
                                if (ok && firstOkAt[0] > 0) {
                                    long remaining = MIN_STABLE_WINDOW_MS
                                            - (SystemClock.uptimeMillis() - firstOkAt[0]);
                                    if (remaining > step) step = remaining;
                                }
                                mainH.postDelayed(this, step);
                            } else {
                                Log.w(TAG, "reparentHostChild: native reparent did not confirm within timeout; attaching anyway");
                                attachNow();
                            }
                        } catch (Throwable t) {
                            Log.w(TAG, "reparentHostChild: waiter failure", t);
                            attachNow();
                        }
                    }
                    private void attachNow() {
                        try {
                            finalVg.addView(finalChild, new FrameLayout.LayoutParams(
                                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                        } catch (Throwable t) {
                            try { finalVg.addView(finalChild); } catch (Throwable ignore) {}
                        }
                        try { WindowHostActivityView.syncGeometryWithoutIme(finalChild); } catch (Throwable ignore) {}
                        resizeVirtualDisplaySafely(finalChild, finalVg.getWidth(), finalVg.getHeight());
                        mainH.post(() -> {
                            try { WindowHostActivityView.syncGeometryWithoutIme(finalChild); } catch (Throwable ignore) {}
                            markReparentSettled(finalChild);
                            try { finalChild.setVisibility(View.VISIBLE); } catch (Throwable ignore) {}
                        });
                    }
                };
                // start waiting
                mainH.post(waiter);
            }
        } catch (Throwable t) {
            Log.w(TAG, "reparentHostChild failed", t);
        }
    }

    private static int getVirtualDisplayIdSafely(Object avObj) {
        if (avObj == null) return -1;
        try {
            Object vdisp = reflectGetField(avObj, "mVirtualDisplay");
            if (vdisp != null) {
                try {
                    Method getDisplay = vdisp.getClass().getMethod("getDisplay");
                    Object display = getDisplay.invoke(vdisp);
                    if (display != null) {
                        Method getId = display.getClass().getMethod("getDisplayId");
                        Object idObj = getId.invoke(display);
                        if (idObj instanceof Number) return ((Number) idObj).intValue();
                    }
                } catch (Throwable ignore) {}
            }

            String[] altFields = new String[] { "virtualDisplay", "mVirtualDisp", "mVD", "virtualDisplayObj" };
            for (String f : altFields) {
                try {
                    Object vd = reflectGetField(avObj, f);
                    if (vd != null) {
                        try {
                            Method getDisplay = vd.getClass().getMethod("getDisplay");
                            Object display = getDisplay.invoke(vd);
                            if (display != null) {
                                Method getId = display.getClass().getMethod("getDisplayId");
                                Object idObj = getId.invoke(display);
                                if (idObj instanceof Number) return ((Number) idObj).intValue();
                            }
                        } catch (Throwable ignore) {}
                    }
                } catch (Throwable ignore) {}
            }

            try {
                Method m = avObj.getClass().getMethod("getVirtualDisplayId");
                Object res = m.invoke(avObj);
                if (res instanceof Number) return ((Number) res).intValue();
            } catch (Throwable ignore) {}

            try {
                Method m2 = avObj.getClass().getMethod("getDisplayId");
                Object res2 = m2.invoke(avObj);
                if (res2 instanceof Number) return ((Number) res2).intValue();
            } catch (Throwable ignore) {}

            if (avObj instanceof View) {
                for (Field ff : avObj.getClass().getDeclaredFields()) {
                    try {
                        ff.setAccessible(true);
                        Object val = ff.get(avObj);
                        if (val == null) continue;
                        try {
                            Method getDisplay = val.getClass().getMethod("getDisplay");
                            Object display = getDisplay.invoke(val);
                            if (display != null) {
                                Method getId = display.getClass().getMethod("getDisplayId");
                                Object idObj = getId.invoke(display);
                                if (idObj instanceof Number) return ((Number) idObj).intValue();
                            }
                        } catch (Throwable ignore) {}
                    } catch (Throwable ignore) {}
                }
            }
        } catch (Throwable t) {
            Log.w(TAG, "getVirtualDisplayIdSafely: unexpected error", t);
        }
        return -1;
    }

    private static int resolveDensityDpiSafely(View avView) {
        if (avView == null) return 160;
        try {
            Method m = avView.getClass().getDeclaredMethod("getBaseDisplayDensity");
            m.setAccessible(true);
            Object v = m.invoke(avView);
            if (v instanceof Integer && ((Integer) v) > 0) return (Integer) v;
        } catch (Throwable ignore) {}

        try {
            DisplayMetrics dm = avView.getResources().getDisplayMetrics();
            if (dm != null && dm.densityDpi > 0) return dm.densityDpi;
        } catch (Throwable ignore) {}

        return 160;
    }

    /**
     * Same-purpose helper as WindowHostDualPane/WindowHostSinglePane's own
     * kickSurfaceRedraw(), duplicated here as a static so the swap/reparent path
     * (attachNow() below) can call it too. resizeVirtualDisplaySafely() only resizes the
     * embedded app's VirtualDisplay resolution -- it does NOT tell the *outer* SurfaceView
     * (the one compositing that VirtualDisplay's content into our host container) to
     * resize its own native buffer to match. Without this, content renders at the correct,
     * newly-resized resolution internally, but only the OLD buffer's worth of it is
     * actually visible -- shows up as "correctly scaled but cropped" after a swap.
     */
    private static SurfaceView findSurfaceViewStatic(View v) {
        if (v instanceof SurfaceView) return (SurfaceView) v;
        if (v instanceof ViewGroup g) {
            for (int i = 0; i < g.getChildCount(); i++) {
                SurfaceView res = findSurfaceViewStatic(g.getChildAt(i));
                if (res != null) return res;
            }
        }
        return null;
    }

    private static void kickSurfaceRedraw(View avView, int w, int h) {
        if (avView == null || w <= 0 || h <= 0) return;
        try {
            SurfaceView sv = findSurfaceViewStatic(avView);
            if (sv == null) return;
            sv.requestLayout();
            sv.invalidate();
            SurfaceHolder holder = sv.getHolder();
            if (holder != null) {
                holder.setFixedSize(w, h);
                retryHandler.post(() -> {
                    try { holder.setSizeFromLayout(); } catch (Throwable ignore) {}
                });
            }
        } catch (Throwable ignore) {}
    }

    /**
     * Best-effort resize of the ActivityView's underlying VirtualDisplay to match the
     * pane it's about to become visible in. Called from reparentHostChild()'s waiter
     * BEFORE setVisibility(VISIBLE), so the correct-size frame is already queued by the
     * time the surface is shown — instead of flashing the old host's resolution until
     * the separate isReparentUnsettled-guarded resync cycle catches up later.
     */
    private static void resizeVirtualDisplaySafely(View avView, int width, int height) {
        if (avView == null || width < 50 || height < 50) return;
        try {
            Object vd = reflectGetField(avView, "mVirtualDisplay");
            if (vd == null) return;
            int density = Math.max(120, resolveDensityDpiSafely(avView));
            Method resize = vd.getClass().getMethod("resize", int.class, int.class, int.class);
            resize.invoke(vd, width, height, density);
        } catch (Throwable t) {
            Log.w(TAG, "resizeVirtualDisplaySafely failed", t);
        }
        // Resize the outer SurfaceView's own buffer to match -- see kickSurfaceRedraw()
        // above for why this is needed in addition to the VirtualDisplay resize.
        kickSurfaceRedraw(avView, width, height);
    }

    /**
     * Everything that is safe to do to a freshly created ActivityView before it renders.
     *
     * Replaces WindowHostSurfacePreloader.forceInstantSurfaceReady(). That class had already been
     * stripped down to exactly this; what it must NOT do is call lockCanvas()/unlockCanvasAndPost()
     * or pre-measure the view at an arbitrary size -- a stale CPU buffer on the SurfaceView's
     * SurfaceControl clips the embedded display, and a bogus pre-layout makes the embedded app
     * start with a bogus configuration.
     */
    private static void prepareNewActivityViewSurface(View avView) {
        if (avView == null) return;
        try {
            SurfaceView sv = WindowHostActivityView.findSurfaceView(avView);
            if (sv == null) return;

            sv.setVisibility(View.VISIBLE);

            SurfaceHolder holder = sv.getHolder();
            if (holder != null) {
                holder.setFormat(PixelFormat.RGBA_8888);
                holder.setSizeFromLayout();
            }
        } catch (Throwable t) {
            Log.w(TAG, "prepareNewActivityViewSurface failed", t);
        }
    }

    private static boolean attemptTaskRelocateSwap(final ViewGroup hostA, final ViewGroup hostB,
                                                   final Object oldAvA, final Object oldAvB,
                                                   final int taskA, final int taskB,
                                                   final String pkgA, final String pkgB,
                                                   final Rect boundsA, final Rect boundsB) {
        try {
            final Launcher launcher = Launcher.getLauncher();
            if (launcher == null) return false;

            Object newA = WindowHostActivityView.newInstance(launcher);
            Object newB = WindowHostActivityView.newInstance(launcher);

            final View newAView = WindowHostActivityView.asView(newA);
            final View newBView = WindowHostActivityView.asView(newB);

            prepareNewActivityViewSurface(newAView);
            prepareNewActivityViewSurface(newBView);

            ActivityOptions optsA = ActivityOptions.makeBasic();
            ActivityOptions optsB = ActivityOptions.makeBasic();
            try {
                int didA = getVirtualDisplayIdSafely(newA);
                if (didA >= 0) optsA.setLaunchDisplayId(didA);
            } catch (Throwable ignore) {}
            try {
                int didB = getVirtualDisplayIdSafely(newB);
                if (didB >= 0) optsB.setLaunchDisplayId(didB);
            } catch (Throwable ignore) {}

            try {
                Method mA = optsA.getClass().getMethod("setLaunchTaskId", int.class);
                try { mA.invoke(optsA, taskB); } catch (Throwable ignore) {}
            } catch (NoSuchMethodException ignored) {}
            try {
                Method mB = optsB.getClass().getMethod("setLaunchTaskId", int.class);
                try { mB.invoke(optsB, taskA); } catch (Throwable ignore) {}
            } catch (NoSuchMethodException ignored) {}

            Intent intentA = WindowHostActivityView.getLaunchIntentForPackage(launcher, pkgB);
            Intent intentB = WindowHostActivityView.getLaunchIntentForPackage(launcher, pkgA);

            try {
                boolean okA = WindowHostActivityView.startActivitySmartWithProcessCheck(newA, launcher, pkgB, boundsA);
                if (!okA && intentA != null) {
                    try { WindowHostActivityView.startActivitySmart(newA, launcher, intentA, optsA); } catch (Throwable ignore) {}
                }
            } catch (Throwable t) {
                Log.w(TAG, "attemptTaskRelocateSwap: start into newA failed", t);
                if (intentA != null) try { WindowHostActivityView.startActivitySmart(newA, launcher, intentA, optsA); } catch (Throwable ignore) {}
            }
            try {
                boolean okB = WindowHostActivityView.startActivitySmartWithProcessCheck(newB, launcher, pkgA, boundsB);
                if (!okB && intentB != null) {
                    try { WindowHostActivityView.startActivitySmart(newB, launcher, intentB, optsB); } catch (Throwable ignore) {}
                }
            } catch (Throwable t) {
                Log.w(TAG, "attemptTaskRelocateSwap: start into newB failed", t);
                if (intentB != null) try { WindowHostActivityView.startActivitySmart(newB, launcher, intentB, optsB); } catch (Throwable ignore) {}
            }

            final AtomicBoolean readyA = new AtomicBoolean(false);
            final AtomicBoolean readyB = new AtomicBoolean(false);
            WindowHostActivityView.trySetCallback(newA, new WindowHostActivityView.Callback() {
                @Override public void onReady() { readyA.set(true); }
            });
            WindowHostActivityView.trySetCallback(newB, new WindowHostActivityView.Callback() {
                @Override public void onReady() { readyB.set(true); }
            });

            final long deadline = SystemClock.uptimeMillis() + 1200;
            final Handler h = new Handler(Looper.getMainLooper());

            h.post(new Runnable() {
                @Override public void run() {
                    try {
                        if ((readyA.get() || SystemClock.uptimeMillis() >= deadline) &&
                            (readyB.get() || SystemClock.uptimeMillis() >= deadline)) {

                            try {
                                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                                try { hostA.removeView(newAView); } catch (Throwable ignore) {}
                                try { hostA.addView(newAView, lp); } catch (Throwable ignore) {}
                                try { hostB.removeView(newBView); } catch (Throwable ignore) {}
                                try { hostB.addView(newBView, lp); } catch (Throwable ignore) {}

                                try { newAView.setAlpha(0f); newAView.animate().alpha(1f).setDuration(140).start(); } catch (Throwable ignore) {}
                                try { newBView.setAlpha(0f); newBView.animate().alpha(1f).setDuration(140).start(); } catch (Throwable ignore) {}

                                h.postDelayed(() -> {
                                    try {
                                        try { View oldA = asView(oldAvA); if (oldA != null && oldA.getParent() instanceof ViewGroup) ((ViewGroup)oldA.getParent()).removeView(oldA); } catch (Throwable ignore) {}
                                        try { View oldB = asView(oldAvB); if (oldB != null && oldB.getParent() instanceof ViewGroup) ((ViewGroup)oldB.getParent()).removeView(oldB); } catch (Throwable ignore) {}

                                        try { if (oldAvA != null) WindowHostActivityView.release(oldAvA); } catch (Throwable ignore) {}
                                        try { if (oldAvB != null) WindowHostActivityView.release(oldAvB); } catch (Throwable ignore) {}

                                        invokeIfExists(newA, "updateLocationAndTapExcludeRegion");
                                        invokeIfExists(newB, "updateLocationAndTapExcludeRegion");

                                        Log.i(TAG, "attemptTaskRelocateSwap: relocated tasks and attached new AVs");
                                    } catch (Throwable t2) {
                                        Log.w(TAG, "attemptTaskRelocateSwap: finalization failed", t2);
                                    }
                                }, 220);

                            } catch (Throwable t) {
                                Log.w(TAG, "attemptTaskRelocateSwap: attach new views failed", t);
                            }
                            return;
                        }
                        h.postDelayed(this, 30);
                    } catch (Throwable t) {
                        Log.w(TAG, "attemptTaskRelocateSwap: waiter failure", t);
                    }
                }
            });

            return true;

        } catch (Throwable t) {
            Log.w(TAG, "attemptTaskRelocateSwap: unexpected error", t);
            return false;
        }
    }

    private static void safeOverlaySwapPanes(final ViewGroup hostA, final ViewGroup hostB,
                                             final Object oldAvA, final Object oldAvB,
                                             final String pkgA, final String pkgB,
                                             final Rect boundsA, final Rect boundsB,
                                             final String avFieldNameA,
                                             final Object hostObjA, final Object hostObjB) {
        try {
            final Launcher launcher = Launcher.getLauncher();
            if (launcher == null) return;
            if (hostA == null || hostB == null) return;

            Object newA = WindowHostActivityView.newInstance(launcher);
            Object newB = WindowHostActivityView.newInstance(launcher);

            final View newAView = WindowHostActivityView.asView(newA);
            final View newBView = WindowHostActivityView.asView(newB);
            final View oldAView = asView(oldAvA);
            final View oldBView = asView(oldAvB);

            try { newAView.setAlpha(0f); newAView.setVisibility(View.VISIBLE); } catch (Throwable ignore) {}
            try { newBView.setAlpha(0f); newBView.setVisibility(View.VISIBLE); } catch (Throwable ignore) {}

            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            try {
                if (newAView.getParent() instanceof ViewGroup) try { ((ViewGroup)newAView.getParent()).removeView(newAView); } catch (Throwable ignore) {}
                hostA.addView(newAView, lp);
            } catch (Throwable t) {
                Log.w(TAG, "safeOverlaySwapPanes: add newAView failed", t);
            }
            try {
                if (newBView.getParent() instanceof ViewGroup) try { ((ViewGroup)newBView.getParent()).removeView(newBView); } catch (Throwable ignore) {}
                hostB.addView(newBView, lp);
            } catch (Throwable t) {
                Log.w(TAG, "safeOverlaySwapPanes: add newBView failed", t);
            }

            prepareNewActivityViewSurface(newAView);
            prepareNewActivityViewSurface(newBView);

            final AtomicBoolean readyA = new AtomicBoolean(false);
            final AtomicBoolean readyB = new AtomicBoolean(false);
            WindowHostActivityView.trySetCallback(newA, new WindowHostActivityView.Callback() {
                @Override public void onReady() { readyA.set(true); }
            });
            WindowHostActivityView.trySetCallback(newB, new WindowHostActivityView.Callback() {
                @Override public void onReady() { readyB.set(true); }
            });

            try {
                boolean ok = WindowHostActivityView.startActivitySmartWithProcessCheck(newA, launcher, pkgB, boundsA);
                if (!ok) {
                    Intent fallback = WindowHostActivityView.getLaunchIntentForPackage(launcher, pkgB);
                    if (fallback != null) WindowHostActivityView.startActivitySmart(newA, launcher, fallback, WindowHostActivityView.makeOptionsWithBounds(pkgB, boundsA));
                }
            } catch (Throwable t) {
                Log.w(TAG, "safeOverlaySwapPanes: start into newA failed", t);
            }
            try {
                boolean ok = WindowHostActivityView.startActivitySmartWithProcessCheck(newB, launcher, pkgA, boundsB);
                if (!ok) {
                    Intent fallback = WindowHostActivityView.getLaunchIntentForPackage(launcher, pkgA);
                    if (fallback != null) WindowHostActivityView.startActivitySmart(newB, launcher, fallback, WindowHostActivityView.makeOptionsWithBounds(pkgA, boundsB));
                }
            } catch (Throwable t) {
                Log.w(TAG, "safeOverlaySwapPanes: start into newB failed", t);
            }

            final long deadline = SystemClock.uptimeMillis() + 1400;
            final Handler mainH = new Handler(Looper.getMainLooper());
            final Runnable waiter = new Runnable() {
                @Override
                public void run() {
                    try {
                        boolean aReady = readyA.get();
                        boolean bReady = readyB.get();
                        if ((!aReady || !bReady) && SystemClock.uptimeMillis() < deadline) {
                            mainH.postDelayed(this, 30);
                            return;
                        }

                        final long DURATION = 160L;
                        try { newAView.animate().alpha(1f).setDuration(DURATION).start(); } catch (Throwable ignore) {}
                        try { newBView.animate().alpha(1f).setDuration(DURATION).start(); } catch (Throwable ignore) {}
                        try { if (oldAView != null) oldAView.animate().alpha(0f).setDuration(DURATION).start(); } catch (Throwable ignore) {}
                        try { if (oldBView != null) oldBView.animate().alpha(0f).setDuration(DURATION).start(); } catch (Throwable ignore) {}

                        mainH.postDelayed(() -> {
                            try {
                                try { reflectSetField(hostObjA, avFieldNameA, newA); } catch (Throwable ignore) {}
                                try { reflectSetField(hostObjB, "av", newB); } catch (Throwable ignore) {}

                                invokeIfExists(newA, "updateLocationAndTapExcludeRegion");
                                invokeIfExists(newB, "updateLocationAndTapExcludeRegion");

                                try { if (oldAView != null && oldAView.getParent() instanceof ViewGroup) ((ViewGroup)oldAView.getParent()).removeView(oldAView); } catch (Throwable ignore) {}
                                try { if (oldBView != null && oldBView.getParent() instanceof ViewGroup) ((ViewGroup)oldBView.getParent()).removeView(oldBView); } catch (Throwable ignore) {}

                                try { if (oldAvA != null) WindowHostActivityView.release(oldAvA); } catch (Throwable ignore) {}
                                try { if (oldAvB != null) WindowHostActivityView.release(oldAvB); } catch (Throwable ignore) {}

                                Log.i(TAG, "safeOverlaySwapPanes: overlay swap completed successfully");
                            } catch (Throwable t) {
                                Log.w(TAG, "safeOverlaySwapPanes: finalization failed", t);
                            }
                        }, DURATION + 40);

                    } catch (Throwable t) {
                        Log.w(TAG, "safeOverlaySwapPanes: waiter failed", t);
                    }
                }
            };
            mainH.post(waiter);

        } catch (Throwable t) {
            Log.w(TAG, "safeOverlaySwapPanes: unexpected error", t);
        }
    }

    /**
     * Swap two package preference values safely (used when swapping PiP panes so the stored package
     * positions match the new layout).
     */
    private static void swapPrefsPackages(String keyA, String keyB) {
        try {
            if (prefs == null) {
                prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
            }
            String a = prefs.getString(keyA, "");
            String b = prefs.getString(keyB, "");
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(keyA, b);
            editor.putString(keyB, a);
            editor.apply();
            Log.i(TAG, "swapPrefsPackages: swapped " + keyA + " <-> " + keyB + " (" + b + " / " + a + ")");
        } catch (Throwable t) {
            Log.w(TAG, "swapPrefsPackages failed for " + keyA + " and " + keyB, t);
        }
    }
}