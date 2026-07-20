package com.syu.util;

import static com.syu.util.WindowHostActivityView.findSurfaceView;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.SystemProperties;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.preference.PreferenceManager;

import com.android.launcher66.CellLayout;
import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.android.launcher66.Workspace;
import com.android.launcher66.settings.Helpers;
import com.android.launcher66.settings.Keys;
import com.fyt.thread.ThreadManager;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class WindowUtil {
    private static final String TAG = "WindowUtil";
    private static SharedPreferences prefs;
    private static Helpers helpers;
    public static String AppPackageName = "";
    private static WindowHost mWindowHost;
    private static String firstPkg;
    private static String secondPkg;
    private static String activeHostSignature = "";
    private static final long SURFACE_PRELOAD_DELAY_MS = 2000L;
    private static final long PIP_LAYOUT_RETRY_DELAY_MS = 180L;
    private static final long PIP_LAYOUT_REARM_DELAY_MS = 1500L;
    private static final int MAX_PIP_LAYOUT_RETRIES = 50;
    private static final int MAX_PIP_LAYOUT_REARMS = 2;
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    private static final AtomicBoolean SURFACE_PRELOAD_STARTED = new AtomicBoolean(false);
    private static final AtomicInteger SCREEN_SWITCH_GEN = new AtomicInteger();
    private static final AtomicInteger PIP_OPEN_GEN = new AtomicInteger();
    private static Rect offscreen = new Rect(-3000, -3000, -2400, -2400);
    private static final Map<String, Boolean> pipOffscreenState = new HashMap<>();
    private static final Map<String, Rect> lastPipBounds = new HashMap<>();
    private static int pipLayoutRearmCount = 0;

    public static boolean dualPip = false;
    public static boolean firstPip = false;
    public static boolean secondPip = false;
    public static boolean thirdPip = false;
    public static boolean fourthPip = false;
    public static boolean firstPipPinned = false;
    public static boolean secondPipPinned = false;
    public static boolean thirdPipPinned = false;
    public static boolean fourthPipPinned = false;

    static {
        // Initialize state
        pipOffscreenState.put("dual", false);
        pipOffscreenState.put("first", false);
        pipOffscreenState.put("second", false);
        pipOffscreenState.put("third", false);
        pipOffscreenState.put("fourth", false);
    }

    public static void initDefaultApp() {
        if (!LauncherApplication.isFytDevice()) return;
        initSurfacePreloader();
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

    public static void initSurfacePreloader() {
        if (!SURFACE_PRELOAD_STARTED.compareAndSet(false, true)) {
            return;
        }
        MAIN_HANDLER.postDelayed(() -> {
            try {
                WindowHostSurfacePreloader.clearPool();
                Log.i(TAG, "Surface preloader initialized without global ActivityView prewarm");
            } catch (Exception e) {
                Log.e(TAG, "Failed to initialize surface preloader", e);
            }
        }, SURFACE_PRELOAD_DELAY_MS);
    }

    public static void startMapPip(final boolean show) {
        ThreadManager.getLongPool().execute(() -> WindowUtil.openPip(show, 0));
    }

    public static void startMapPip(final boolean show, int millis) {
        final int delayMillis = Math.max(0, millis);
        ThreadManager.getLongPool().execute(() -> WindowUtil.openPip(show, delayMillis));
    }

    public static void openPip(boolean show) {
        openPip(show, 0);
    }

    private static void openPip(boolean show, int delayMillis) {
        if (!LauncherApplication.isFytDevice()) return;
        Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        if (launcher.allowPip) {
            try {
                if (helpers == null) {
                    helpers = new Helpers();
                }
                Log.i(TAG, "openPip(): " +  "show: "+ String.valueOf(show)
                    + " helpers.pipsAdded(): " + String.valueOf(helpers.pipsAdded())
                    + " Utils.topApp(): " + String.valueOf(Utils.topApp()) 
                    + " helpers.pipsAdded() " + String.valueOf(helpers.pipsAdded()) 
                    + " AppPackageName.isEmpty() " + String.valueOf(AppPackageName == null || AppPackageName.isEmpty())
                    + " helpers.isInWidgets() " + String.valueOf(helpers.isInWidgets()) 
                    + " helpers.isInAllApps() " + String.valueOf(helpers.isInAllApps())  
                    + " helpers.isInOverviewMode() " + String.valueOf(helpers.isInOverviewMode()) 
                    + " helpers.isFirstPreferenceWindow() " + String.valueOf(helpers.isFirstPreferenceWindow()) 
                    + " helpers.allAppsVisibility() " + String.valueOf(isAllAppsVisible())
                    + " helpers.isWallpaperWindow() " + String.valueOf(helpers.isWallpaperWindow())
                    + " helpers.isListOpen() " + String.valueOf(helpers.isListOpen()));
                if (shouldOpenPipFromLauncherState(show)) {

                    if (prefs == null) {
                        prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp); 
                    }

                    if (checkIfPinned() && FytPackage.OUT360.equals(AppPackageName)) {
                        launcher.sendBroadcast(new Intent("com.syu.camera360.show"));
                    }

                    boolean userLayout = prefs.getBoolean(Keys.USER_LAYOUT, false);
                   
                    if (userLayout) {
                        launcher.sendBroadcast(new Intent(Keys.BLOCK_FLOATING_BUTTON));
                        boolean userMap = prefs.getBoolean(Keys.DISPLAY_PIP, true);
                        String desiredHostSignature = buildDesiredHostSignature(prefs);
                        if (userMap && canReuseWindowHost(desiredHostSignature)) {
                            Log.i(TAG, "openPip(): reusing visible window host");
                            updateVisiblePipPositions();
                            launcher.showOverlayFab();
                            helpers.setPipsAdded(true);
                            helpers.setFirstPreferenceWindow(false);
                            helpers.setWallpaperWindow(false);
                            helpers.setWasInRecents(false);
                            return;
                        }
                        // Always try to dismiss existing views before adding a new ones
                        // It prevents adding a view twice what results in persistent black rectangle
                        try {
                            // Only dismiss an actually visible host. On Home resume the previous removePip()
                            // usually already detached it and prewarmed the next ActivityViews.
                            if (hasVisibleWindowHost()) {
                                dismissWindowHost("openPip()");
                            } else {
                                Log.i(TAG, "openPip(): no visible window host, reusing warm ActivityView pool");
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
                        if (userMap) {
                            final int openGen = PIP_OPEN_GEN.incrementAndGet();
                            launcher.pipOverview();
                            launcher.handler.postDelayed(() -> {
                                if (openGen != PIP_OPEN_GEN.get()) return;
                                if (Launcher.getLauncher() == null) return;
                                if (checkIfPinned()) {
                                    openPinnedPip();
                                }
                            }, delayMillis);
                            launcher.handler.postDelayed(() -> {
                                if (openGen != PIP_OPEN_GEN.get()) return;
                                if (Launcher.getLauncher() == null) return;
                                openMultiplePips();
                            }, delayMillis + 100);
                            launcher.handler.postDelayed(() -> {
                                if (openGen != PIP_OPEN_GEN.get()) return;
                                Launcher currentLauncher = Launcher.getLauncher();
                                if (currentLauncher == null) return;
                                currentLauncher.showOverlayFab();
                            }, delayMillis + 150);                                           
                        }
                    } 

                    helpers.setPipsAdded(true);
                    helpers.setFirstPreferenceWindow(false);
                    helpers.setWallpaperWindow(false);
                    helpers.setWasInRecents(false);
                }
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void removePip(int millis) {
        final int delayMillis = Math.max(0, millis);
        ThreadManager.getLongPool().execute(() -> WindowUtil.removePipInternal(delayMillis));
    }

    public static void removePip() {
        removePipInternal(0);
    }

    private static void removePipInternal(int delayMillis) {
        if (!LauncherApplication.isFytDevice()) return;
        Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        PIP_OPEN_GEN.incrementAndGet();
        if (helpers == null) {
            helpers = new Helpers();
        }
        if (helpers.pipsAdded()) {
            Log.d(TAG, "removePip..");
            launcher.handler.postDelayed(() -> {
                if (Launcher.getLauncher() == null) return;
                if (checkIfPinned() && FytPackage.OUT360.equals(WindowUtil.AppPackageName)) {
                    LauncherApplication.sApp.sendBroadcast(new Intent("com.syu.camera360.hide"));
                }
            }, delayMillis);
            if (FytPackage.GaodeACTION.equals(AppPackageName)) {
                try {
                    LauncherApplication.sApp.removeGaoDeCoverView();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
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
                dismissWindowHost("removePip()");
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

    private static boolean shouldOpenPipFromLauncherState(boolean show) {
        Launcher launcher = Launcher.getLauncher();
        if (launcher == null || !launcher.allowPip) return false;
        if (helpers == null) {
            helpers = new Helpers();
        }

        boolean pipsMissing = !helpers.pipsAdded() || !hasVisibleWindowHost();
        boolean launcherSurfaceAvailable = !helpers.isInWidgets()
                && !helpers.isInAllApps()
                && !helpers.isInOverviewMode()
                && !helpers.isFirstPreferenceWindow()
                && !helpers.isWallpaperWindow()
                && !isAllAppsVisible();

        if (show && pipsMissing) {
            return launcherSurfaceAvailable;
        }

        boolean homeReady = Utils.topApp() && pipsMissing && launcherSurfaceAvailable;
        boolean listRecovery = !helpers.userWasInRecents()
                && helpers.isListOpen()
                && pipsMissing
                && launcherSurfaceAvailable;
        return homeReady || listRecovery;
    }

    private static boolean isAllAppsVisible() {
        return helpers != null
                && Launcher.mAppsCustomizeTabHost != null
                && helpers.allAppsVisibility(Launcher.mAppsCustomizeTabHost.getVisibility());
    }

    public static void prepareNextSurfaceLoad() {
        MAIN_HANDLER.post(() -> {
            WindowHostSurfacePreloader.clearPool();
            Log.i(TAG, "prepareNextSurfaceLoad: cleared warm ActivityView pool");
        });
    }

    private static boolean hasVisibleWindowHost() {
        return mWindowHost != null
                && (mWindowHost.isDualVisible()
                || mWindowHost.isFirstVisible()
                || mWindowHost.isSecondVisible()
                || mWindowHost.isThirdVisible()
                || mWindowHost.isFourthVisible());
    }

    private static String buildDesiredHostSignature(SharedPreferences sourcePrefs) {
        if (sourcePrefs == null) return "";
        return "dual=" + sourcePrefs.getBoolean(Keys.PIP_DUAL, false)
                + ";first=" + sourcePrefs.getBoolean(Keys.PIP_FIRST, false)
                + ";second=" + sourcePrefs.getBoolean(Keys.PIP_SECOND, false)
                + ";third=" + sourcePrefs.getBoolean(Keys.PIP_THIRD, false)
                + ";fourth=" + sourcePrefs.getBoolean(Keys.PIP_FOURTH, false)
                + ";firstPinned=" + firstPipPinned
                + ";secondPinned=" + secondPipPinned
                + ";thirdPinned=" + thirdPipPinned
                + ";fourthPinned=" + fourthPipPinned
                + ";firstPkg=" + sourcePrefs.getString(Keys.PIP_FIRST_PACKAGE, "")
                + ";secondPkg=" + sourcePrefs.getString(Keys.PIP_SECOND_PACKAGE, "")
                + ";thirdPkg=" + sourcePrefs.getString(Keys.PIP_THIRD_PACKAGE, "")
                + ";fourthPkg=" + sourcePrefs.getString(Keys.PIP_FOURTH_PACKAGE, "");
    }

    private static boolean canReuseWindowHost(String desiredHostSignature) {
        return hasVisibleWindowHost()
                && desiredHostSignature != null
                && desiredHostSignature.equals(activeHostSignature);
    }

    private static void updateVisiblePipPositions() {
        updateVisiblePipPositions(0);
    }

    private static void updateVisiblePipPositions(int attempt) {
        Launcher launcher = Launcher.getLauncher();
        Workspace workspace = launcher == null ? null : launcher.getWorkspace();
        if (!hasVisibleWindowHost()) {
            return;
        }
        if (!isWorkspaceReadyForPip(workspace)) {
            if (attempt < MAX_PIP_LAYOUT_RETRIES) {
                MAIN_HANDLER.postDelayed(() -> updateVisiblePipPositions(attempt + 1), PIP_LAYOUT_RETRY_DELAY_MS);
            } else {
                Log.w(TAG, "updateVisiblePipPositions: giving up, workspace not ready");
            }
            return;
        }
        updatePipPositionsForScroll(workspace.mUnboundedScrollX);
    }

    private static void dismissWindowHost(String source) {
        if (mWindowHost == null) return;
        if (!hasVisibleWindowHost()) {
            Log.i(TAG, source + ": no visible window host, skipping dismiss");
            return;
        }
        activeHostSignature = "";
        WindowHost host = mWindowHost;
        Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        launcher.handler.post(host::dismiss);
        launcher.handler.post(() -> {
            try {
                host.awaitHandoff(() -> {
                    try {
                        cleanupDismissedHost(source, host);
                        WindowHostSurfacePreloader.clearPool();
                        Log.i(TAG, source + ": awaitHandoff completed; cleaned dismissed host and cleared warm pool");
                    } catch (Throwable t) {
                        Log.w(TAG, source + ": cleanup after handoff failed", t);
                    }
                });
            } catch (Throwable t) {
                Log.w(TAG, source + ": awaitHandoff failed, falling back", t);
                Launcher currentLauncher = Launcher.getLauncher();
                if (currentLauncher != null) {
                    currentLauncher.handler.postDelayed(() -> prepareNextSurfaceLoad(), 120);
                }
            }
        });
    }

    private static void cleanupDismissedHost(String source, WindowHost host) {
        if (host == null) return;
        try {
            host.cleanup();
        } catch (Throwable t) {
            Log.w(TAG, source + ": host cleanup failed", t);
        }
        if (mWindowHost == host) {
            mWindowHost = null;
            activeHostSignature = "";
        }
    }

    // WINDOWED PIPS

    public static void openMultiplePips() {
        openMultiplePips(0, PIP_OPEN_GEN.get());
    }

    private static void openMultiplePips(int attempt, int expectedOpenGen) {
        if (!LauncherApplication.isFytDevice()) return;
        if (expectedOpenGen != PIP_OPEN_GEN.get()) return;
        Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        if (prefs == null) {
            prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        }
        dualPip = prefs.getBoolean(Keys.PIP_DUAL, false);
        firstPip = prefs.getBoolean(Keys.PIP_FIRST, false);
        secondPip = prefs.getBoolean(Keys.PIP_SECOND, false);
        thirdPip = prefs.getBoolean(Keys.PIP_THIRD, false);
        fourthPip = prefs.getBoolean(Keys.PIP_FOURTH, false);

        firstPkg = prefs.getString(Keys.PIP_FIRST_PACKAGE, "");
        secondPkg = prefs.getString(Keys.PIP_SECOND_PACKAGE, "");
        final String thirdPkg = prefs.getString(Keys.PIP_THIRD_PACKAGE, "");
        final String fourthPkg = prefs.getString(Keys.PIP_FOURTH_PACKAGE, "");
        String desiredHostSignature = buildDesiredHostSignature(prefs);

        Workspace workspace = launcher.getWorkspace();
        if (canReuseWindowHost(desiredHostSignature)) {
            Log.i(TAG, "openMultiplePips: visible host unchanged, updating bounds only");
            updateVisiblePipPositions();
            return;
        }

        if (!isWorkspaceReadyForPip(workspace)) {
            retryOpenMultiplePips(attempt, expectedOpenGen, "workspace not ready");
            return;
        }

        Rect rDual = null;
        Rect rFirst = null;
        Rect rSecond = null;
        Rect rThird = null;
        Rect rFourth = null;
        boolean needsBoundsRetry = false;

        if (dualPip && !firstPipPinned && !secondPipPinned
                && Helpers.isPackageInstalled(firstPkg) && Helpers.isPackageInstalled(secondPkg)) {
            rDual = getInitialPipBounds(workspace, "dual");
            needsBoundsRetry |= rDual == null;
        } else {
            if (firstPip && !firstPipPinned && Helpers.isPackageInstalled(firstPkg)) {
                rFirst = getInitialPipBounds(workspace, "first");
                needsBoundsRetry |= rFirst == null;
            }

            if (secondPip && !secondPipPinned && Helpers.isPackageInstalled(secondPkg)) {
                rSecond = getInitialPipBounds(workspace, "second");
                needsBoundsRetry |= rSecond == null;
            }
        }

        if (thirdPip && !thirdPipPinned && Helpers.isPackageInstalled(thirdPkg)) {
            rThird = getInitialPipBounds(workspace, "third");
            needsBoundsRetry |= rThird == null;
        }

        if (fourthPip && !fourthPipPinned && Helpers.isPackageInstalled(fourthPkg)) {
            rFourth = getInitialPipBounds(workspace, "fourth");
            needsBoundsRetry |= rFourth == null;
        }

        if (needsBoundsRetry) {
            retryOpenMultiplePips(attempt, expectedOpenGen, "placeholder bounds not ready");
            return;
        }

        releaseInactiveWindowHost("openMultiplePips");
        mWindowHost = new WindowHost(launcher);
        activeHostSignature = desiredHostSignature;
        pipLayoutRearmCount = 0;
        
        if (dualPip && !mWindowHost.isDualVisible() && !firstPipPinned && !secondPipPinned 
            && Helpers.isPackageInstalled(firstPkg) && Helpers.isPackageInstalled(secondPkg)) {    
            try {
                if (rDual != null) {
                    mWindowHost.showDual(firstPkg, secondPkg, rDual);
                    Log.i(TAG, "dual: show " + firstPkg + " and " + secondPkg);
                }
            } catch (Throwable t) {
                Log.w(TAG, "dual: open failed", t);
            }
        } else {
            if (firstPip && !mWindowHost.isFirstVisible() && Helpers.isPackageInstalled(firstPkg)) {
                if (!firstPipPinned) {
                    try {
                        if (rFirst != null) {
                            mWindowHost.showFirst(firstPkg, rFirst);
                            Log.i(TAG, "first: show " + firstPkg);
                        }
                    } catch (Throwable t) {
                        Log.w(TAG, "first: open failed", t);
                    }
                }
            }
            
            if (secondPip && !mWindowHost.isSecondVisible() && Helpers.isPackageInstalled(secondPkg)) {
                if (!secondPipPinned) {
                    try {
                        if (rSecond != null) {
                            mWindowHost.showSecond(secondPkg, rSecond);
                            Log.i(TAG, "second: show " + secondPkg);
                        }
                    } catch (Throwable t) {
                        Log.w(TAG, "second: open failed", t);
                    }
                }
            }
        }
        
        if (thirdPip && !mWindowHost.isThirdVisible() && Helpers.isPackageInstalled(thirdPkg)) {
            if (!thirdPipPinned) {
                try {
                    if (rThird != null) {
                        mWindowHost.showThird(thirdPkg, rThird);
                        Log.i(TAG, "third: show " + thirdPkg);
                    }
                } catch (Throwable t) {
                    Log.w(TAG, "third: open failed", t);
                }
            }
        }
        
        if (fourthPip && !mWindowHost.isFourthVisible() && Helpers.isPackageInstalled(fourthPkg)) {
            if (!fourthPipPinned) {
                try {
                    if (rFourth != null) {
                        mWindowHost.showFourth(fourthPkg, rFourth);
                        Log.i(TAG, "fourth: show " + fourthPkg);
                    }
                } catch (Throwable t) {
                    Log.w(TAG, "fourth: open failed", t);
                }
            }
        }
        
        if (workspace != null) {
            workspace.postDelayed(() -> {
                Launcher currentLauncher = Launcher.getLauncher();
                if (currentLauncher == null) return;
                Workspace ws = currentLauncher.getWorkspace();
                if (ws != null) {
                    int currentScroll = ws.mUnboundedScrollX;
                    updatePipPositionsForScroll(currentScroll);
                }
            }, 100); 
        }            
    }

    private static void releaseInactiveWindowHost(String source) {
        WindowHost host = mWindowHost;
        if (host == null || hasVisibleWindowHost()) {
            return;
        }
        try {
            host.cleanup();
            Log.i(TAG, source + ": released inactive window host before rebuild");
        } catch (Throwable t) {
            Log.w(TAG, source + ": failed to release inactive window host", t);
        }
        if (mWindowHost == host) {
            mWindowHost = null;
            activeHostSignature = "";
        }
    }

    private static void retryOpenMultiplePips(int attempt, int expectedOpenGen, String reason) {
        if (attempt >= MAX_PIP_LAYOUT_RETRIES) {
            Log.w(TAG, "openMultiplePips: giving up after " + attempt + " retries, " + reason);
            activeHostSignature = "";
            if (helpers == null) {
                helpers = new Helpers();
            }
            helpers.setPipsAdded(false);
            if (pipLayoutRearmCount < MAX_PIP_LAYOUT_REARMS) {
                pipLayoutRearmCount++;
                MAIN_HANDLER.postDelayed(() -> {
                    if (expectedOpenGen != PIP_OPEN_GEN.get()) return;
                    if (Launcher.getLauncher() == null) return;
                    if (!hasVisibleWindowHost()) {
                        startMapPip(false);
                    }
                }, PIP_LAYOUT_REARM_DELAY_MS);
            }
            return;
        }
        Log.i(TAG, "openMultiplePips: deferring, " + reason + " attempt=" + attempt);
        MAIN_HANDLER.postDelayed(() -> openMultiplePips(attempt + 1, expectedOpenGen), PIP_LAYOUT_RETRY_DELAY_MS);
    }

    private static boolean isWorkspaceReadyForPip(Workspace workspace) {
        if (workspace == null || workspace.getChildCount() <= 0) return false;
        if (workspace.getWidth() <= 1 || workspace.getHeight() <= 1) return false;
        if (workspace.getViewportWidth() <= 1 || workspace.getViewportHeight() <= 1) return false;
        View firstChild = workspace.getChildAt(0);
        return firstChild != null && firstChild.getWidth() > 1 && firstChild.getHeight() > 1;
    }

    private static String getScreenKeyForType(String pipType) {
        switch (pipType) {
            case "dual": return Keys.PIP_DUAL_SCREEN;
            case "first": return Keys.PIP_FIRST_SCREEN;
            case "second": return Keys.PIP_SECOND_SCREEN;
            case "third": return Keys.PIP_THIRD_SCREEN;
            case "fourth": return Keys.PIP_FOURTH_SCREEN;
            default: return "";
        }
    }

    private static Rect getInitialPipBounds(Workspace workspace, String pipType) {
        try {
            if (workspace == null || prefs == null || !isWorkspaceReadyForPip(workspace)) return null;

            String screenKey = getScreenKeyForType(pipType);
            if (screenKey.isEmpty()) return null;

            int pipHomeScreen = prefs.getInt(screenKey, 1) - 1;
            if (pipHomeScreen < 0 || pipHomeScreen >= workspace.getChildCount()) return null;

            CellLayout pipHomeCellLayout = (CellLayout) workspace.getChildAt(pipHomeScreen);
            if (pipHomeCellLayout == null) return null;

            int[] basePos = pipHomeCellLayout.getPipPlaceholderPosition(pipType);
            if (basePos == null) return null;

            int pageWidth = workspace.getViewportWidth();
            if (pageWidth <= 1) return null;
            int pageCount = workspace.getChildCount();
            int maxScroll = Math.max(0, (pageCount - 1) * pageWidth);
            int currentScroll = Math.max(0, Math.min(workspace.mUnboundedScrollX, maxScroll));
            int pipAbsoluteX = (pipHomeScreen * pageWidth) + basePos[0];
            int pipScreenX = pipAbsoluteX - currentScroll;

            Rect bounds = new Rect(pipScreenX, basePos[1],
                    pipScreenX + basePos[2], basePos[1] + basePos[3]);
            if (!isUsableInitialPipBounds(workspace, bounds)) return null;
            return bounds;
        } catch (Throwable t) {
            Log.w(TAG, "getInitialPipBounds failed for " + pipType, t);
            return null;
        }
    }

    private static boolean isUsableInitialPipBounds(Workspace workspace, Rect bounds) {
        if (workspace == null || bounds == null || bounds.width() <= 1 || bounds.height() <= 1) {
            return false;
        }
        if (offscreen.equals(bounds)) return false;
        int pageWidth = Math.max(1, workspace.getViewportWidth());
        int pageCount = Math.max(1, workspace.getChildCount());
        int minLeft = -pageWidth;
        int maxRight = pageWidth * (pageCount + 1);
        return bounds.right > minLeft
                && bounds.left < maxRight
                && bounds.bottom > 0;
    }

    public static void updatePipPositionsForScroll(int scrollOffset) {
        try {
            Launcher launcher = Launcher.getLauncher();
            if (launcher == null) return;
            
            Workspace workspace = launcher.getWorkspace();
            if (workspace == null || mWindowHost == null) return;
            if (!isWorkspaceReadyForPip(workspace)) return;
            
            if (prefs == null) {
                prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
            }
            
            // Update positions for currently visible PiPs without dismissing them
            updatePipPosition("dual", scrollOffset);
            updatePipPosition("first", scrollOffset);
            updatePipPosition("second", scrollOffset);
            updatePipPosition("third", scrollOffset);
            updatePipPosition("fourth", scrollOffset);
            
        } catch (Exception e) {
            Log.e(TAG, "Error updating PiP positions during scroll", e);
        }
    }

    private static void updatePipPosition(String pipType, int scrollOffset) {
        if (mWindowHost == null) return;

        String screenKey = getScreenKeyForType(pipType);
        Launcher launcher = Launcher.getLauncher();
        if (screenKey.isEmpty() || prefs == null || launcher == null) return;
        int pipHomeScreen = prefs.getInt(screenKey, 1) - 1;

        Workspace workspace = launcher.getWorkspace();
        if (workspace == null) return;
        int pageCount = workspace.getChildCount();
        if (pipHomeScreen < 0 || pipHomeScreen >= pageCount) {
            Log.w(TAG, "Skipping " + pipType + " PiP bounds update for invalid screen " + pipHomeScreen
                    + " pageCount=" + pageCount);
            return;
        }
        CellLayout pipHomeCellLayout = (CellLayout) workspace.getChildAt(pipHomeScreen);

        if (pipHomeCellLayout == null) return;

        int[] basePos = pipHomeCellLayout.getPipPlaceholderPosition(pipType);
        if (basePos == null) return;

        int pageWidth = workspace.getViewportWidth();
        if (pageWidth <= 0) return;

        // Protect against overscroll: the provided scrollOffset may be "unbounded" (overscroll)
        // while the logical maximum scroll is (pageCount - 1) * pageWidth. If there is only one
        // page (pageCount == 1) or the user is overscrolling at the edges, we should not move PiPs
        // beyond the real pages — they should stay visually anchored. Compute an effectiveScroll
        // clamped to the [0, maxScroll] range and use that for position calculations.
        int maxScroll = Math.max(0, (pageCount - 1) * pageWidth);
        int effectiveScroll = Math.max(0, Math.min(scrollOffset, maxScroll));

        // scrollOffset is the absolute scroll position (0 for page 0, pageWidth for page 1, etc.)
        int pipAbsoluteX = (pipHomeScreen * pageWidth) + basePos[0];
        int pipScreenX = pipAbsoluteX - effectiveScroll;

        Rect bounds = new Rect(pipScreenX, basePos[1],
                               pipScreenX + basePos[2], basePos[1] + basePos[3]);

        updatePipBounds(pipType, bounds);
        lastPipBounds.put(pipType, new Rect(bounds));
    }

    private static void updatePipBounds(String pipType, Rect bounds) {
        try {
            switch (pipType) {
                case "dual":
                    if (mWindowHost.isDualVisible()) {
                        mWindowHost.updateDualBounds(bounds);
                    }
                    break;
                case "first":
                    if (mWindowHost.isFirstVisible() && !firstPipPinned) {
                        mWindowHost.updateFirstBounds(bounds);
                    }
                    break;
                case "second":
                    if (mWindowHost.isSecondVisible() && !secondPipPinned) {
                        mWindowHost.updateSecondBounds(bounds);
                    }
                    break;
                case "third":
                    if (mWindowHost.isThirdVisible() && !thirdPipPinned) {
                        mWindowHost.updateThirdBounds(bounds);
                    }
                    break;
                case "fourth":
                    if (mWindowHost.isFourthVisible() && !fourthPipPinned) {
                        mWindowHost.updateFourthBounds(bounds);
                    }
                    break;
            }
        } catch (Exception e) {
            Log.e(TAG, "Error updating bounds for " + pipType, e);
        }
    }

    public static void restartMultiplePips() {
        if (mWindowHost != null) {
            activeHostSignature = "";
            Launcher launcher = Launcher.getLauncher();
            if (launcher != null) {
                launcher.handler.post(() -> mWindowHost.cleanup());
            }
        }
    }

    // PINNED PIP

    public static void openPinnedPip() {
        if (!LauncherApplication.isFytDevice()) return;
        if (helpers == null) {
            helpers = new Helpers();
        }
        Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        if (shouldOpenPipFromLauncherState(false)) {

            if (prefs == null) {
                prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
            }

            if (!checkIfPinned()) return;

            firstPip = prefs.getBoolean(Keys.PIP_FIRST, false);
            secondPip = prefs.getBoolean(Keys.PIP_SECOND, false);
            thirdPip = prefs.getBoolean(Keys.PIP_THIRD, false);
            fourthPip = prefs.getBoolean(Keys.PIP_FOURTH, false);
            firstPkg = prefs.getString(Keys.PIP_FIRST_PACKAGE, "");
            secondPkg = prefs.getString(Keys.PIP_SECOND_PACKAGE, "");
            if (firstPip && firstPipPinned && Helpers.isPackageInstalled(firstPkg)) {
                openAsPinnedPip(firstPkg, Keys.PIP_FIRST_KEY, Keys.PIP_FIRST_SCREEN);
            }
            
            if (secondPip && secondPipPinned && Helpers.isPackageInstalled(secondPkg)) {
                openAsPinnedPip(secondPkg, Keys.PIP_SECOND_KEY, Keys.PIP_SECOND_SCREEN);
            }
            
            final String thirdPkg = prefs.getString(Keys.PIP_THIRD_PACKAGE, "");
            if (thirdPip && thirdPipPinned && Helpers.isPackageInstalled(thirdPkg)) {
                openAsPinnedPip(thirdPkg, Keys.PIP_THIRD_KEY, Keys.PIP_THIRD_SCREEN);
            }
            
            final String fourthPkg = prefs.getString(Keys.PIP_FOURTH_PACKAGE, "");
            if (fourthPip && fourthPipPinned && Helpers.isPackageInstalled(fourthPkg)) {
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
        if (firstPipPinned || secondPipPinned || thirdPipPinned || fourthPipPinned) {
            return true;
        } else return false;
    }

    private static void openAsPinnedPip(String packageName, String pipKey, String screenKey) {
        Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        Workspace workspace = launcher.getWorkspace();
        if (workspace == null) return;
        if (packageName == null || packageName.isEmpty()) return;
        // Update screen
        SharedPreferences.Editor editor = prefs.edit();
        int pipScreen = prefs.getInt(screenKey, 1) - 1;
        editor.putInt(Keys.PINNED_PIP_SCREEN, pipScreen + 1);
        editor.apply();
        int currentScreen = workspace.getCurrentPage();

        if (helpers == null) {
            helpers = new Helpers();
        }

        SystemProperties.set("persist.syu.launcher.haspip", "true");

        if (currentScreen == pipScreen && !isAllAppsVisible()) {
            String currentPackage = SystemProperties.get("persist.launcher.packagename", "");
            if (!packageName.equals(currentPackage) || (packageName.equals(currentPackage) && checkIfMapSizeChanged(pipKey))) { 
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
        Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        if (packageName == null || packageName.isEmpty()) return;
        Intent intent = FytPackage.getIntent(LauncherApplication.sApp, packageName);
        intent.putExtra("force_pip", true);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        SystemProperties.set("sys.lsec.force_pip", "true");
        if (intent.resolveActivity(LauncherApplication.sApp.getPackageManager()) != null) {
            launcher.handler.postDelayed(() -> {
                if (Launcher.getLauncher() == null) return;
                LauncherApplication.sApp.startActivity(intent);
            }, 100);
        }  
        checkIfOpenedOnTheRightScreen(500);
        checkIfOpenedOnTheRightScreen(1500);
        checkIfOpenedOnTheRightScreen(2000);      
    }

    // removes an error where windows shows up when user quickly changes to the screen on which it shouldn't appear
    private static void checkIfOpenedOnTheRightScreen(int delay) {
        Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        launcher.handler.postDelayed(() -> {
            Launcher currentLauncher = Launcher.getLauncher();
            if (currentLauncher == null || prefs == null) return;
            Workspace workspace = currentLauncher.getWorkspace();
            if (workspace == null) return;
            int pipScreen = prefs.getInt(Keys.PINNED_PIP_SCREEN, 1) - 1;
            int currentScreen = workspace.getCurrentPage();

            if (workspace.getChildCount() > 1 && currentScreen != pipScreen) {
                removePinnedPip();
            }
        }, delay);
    }

    public static void restartPinnedPipApp() {
        if (!LauncherApplication.isFytDevice()) return;
        Launcher launcher = Launcher.getLauncher();
        if (mWindowHost != null) {
            if (launcher != null) {
                launcher.handler.post(() -> mWindowHost.cleanup());
            }
        }
        String packageName = AppPackageName;
        if (packageName == null || packageName.isEmpty()) return;
        if (FytPackage.GMAPS.equals(packageName)) {
            Log.i(TAG, "restartPinnedPipApp: skip force-stop for Google Maps");
            return;
        }
        ActivityManager activityManager = (ActivityManager) LauncherApplication.sApp.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager == null) return;
        try {
            Method forceStopPackage = activityManager.getClass().getDeclaredMethod("forceStopPackage", String.class);
            forceStopPackage.setAccessible(true);
            forceStopPackage.invoke(activityManager, packageName);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
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

        if (prevPinnedPipTopLeftX != curMapTopLeftX
            || prevPinnedPipTopLeftY != curMapTopLeftY
            || prevPinnedPipBottomRightX != curMapBottomRightX
            || prevPinnedPipBottomRightY != curMapBottomRightY) {
            return true;
        }  
        return false;
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
        boolean leftBar = prefs.getBoolean(Keys.LEFT_BAR, false);
        int pipScreen = prefs.getInt(screenKey, 1) - 1;
        int margin = Integer.valueOf(prefs.getString("layout_margin", "10"));
        int orientedMargin = margin;
        int orientation = LauncherApplication.sApp.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            orientedMargin = 0;
        } 
        int mapTopLeftX, mapBottomRightX; 

        // Get the specific key for the PiP
        String topLeftXKey = pipKey + "TopLeftX";
        String topLeftYKey = pipKey + "TopLeftY";
        String bottomRightXKey = pipKey + "BottomRightX";
        String bottomRightYKey = pipKey + "BottomRightY";

        int mapMinWidth = Launcher.getLauncher().calculatedPipMinWidth / countEnabledPips();

        if (leftBar && pipScreen == 0) {
            mapTopLeftX = prefs.getInt(topLeftXKey, margin) + orientedMargin + Launcher.getLauncher().calculatedLeftBarWidth;
            mapBottomRightX = prefs.getInt(bottomRightXKey, margin + mapMinWidth) + orientedMargin + Launcher.getLauncher().calculatedLeftBarWidth;
        } else {
            mapTopLeftX = prefs.getInt(topLeftXKey, margin);
            mapBottomRightX = prefs.getInt(bottomRightXKey, margin + mapMinWidth);
        }
        
        int mapTopLeftY = prefs.getInt(topLeftYKey, margin + Launcher.getLauncher().calculatedDateMinHeight + margin) + Launcher.getLauncher().getStatusBarHeight();
        int mapBottomRightY = prefs.getInt(bottomRightYKey, margin + Launcher.getLauncher().calculatedDateMinHeight + margin + Launcher.getLauncher().calculatedPipMinHeight) + Launcher.getLauncher().getStatusBarHeight();

        // top-left x, top left y, bottom right x, bottom right y
        SystemProperties.set("sys.lsec.pip_rect", String.valueOf(mapTopLeftX + " " + mapTopLeftY + " " + mapBottomRightX + " " + mapBottomRightY));
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

    // -------------- FAB ----------------
    // --------- left/first <-> third ----------
    public static void swapLeftAndThird() {
        try {
            // Block floating button while swapping (preserve existing behavior)
            try {
                if (Launcher.mLauncher != null) {
                    Launcher.mLauncher.sendBroadcast(new android.content.Intent(Keys.BLOCK_FLOATING_BUTTON));
                }
            } catch (Throwable ignore) {}

            WindowHost host = WindowHost.sInstance;
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

            // Try dual.left <-> third first (if dual mode active)
            if ((dualPip && thirdPip && !thirdPipPinned) && (dual != null && third != null)) {
                try {
                    Object dualLeftAV = reflectGetField(dual, "leftAV");
                    ViewGroup dualLeftHost = (ViewGroup) reflectGetField(dual, "leftHost");
                    Object thirdAv = reflectGetField(third, "av");
                    ViewGroup thirdHost = (ViewGroup) reflectGetField(third, "host");

                    String dualLeftPkg = (String) reflectGetField(dual, "leftPkg");
                    String thirdPkg = (String) reflectGetField(third, "currentPkg");

                    final View viewForDual = asView(dualLeftAV);
                    final View viewForThird = asView(thirdAv);

                    // 1) atomic native-surface swap
                    boolean atomicOk = false;
                    try {
                        if (viewForDual != null && viewForThird != null) {
                            atomicOk = WindowHostReparenter.swapActivityViewSurfaces(viewForDual, viewForThird, 1000);
                        } else {
                            Log.w(TAG, "swapLeftAndThird: viewForDual or viewForThird is null, skipping atomic swap");
                        }
                    } catch (Throwable t) {
                        Log.w(TAG, "swapLeftAndThird: atomic swap threw", t);
                        atomicOk = false;
                    }

                    if (atomicOk) {
                        // Atomic succeeded — update host fields and reattach views after a short delay
                        try {
                            if (dualLeftHost != null) try { dualLeftHost.removeAllViews(); } catch (Throwable ignore) {}
                            if (thirdHost != null)    try { thirdHost.removeAllViews(); }    catch (Throwable ignore) {}

                            invokeIfExists(dualLeftAV, "clearActivityViewGeometryForIme");
                            invokeIfExists(thirdAv, "clearActivityViewGeometryForIme");

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

                            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                                try {
                                    Object newDualLeftAV = reflectGetField(dualRef, "leftAV");
                                    Object newThirdAv = reflectGetField(thirdRef, "av");
                                    View newViewForDual = asView(newDualLeftAV);
                                    View newViewForThird = asView(newThirdAv);

                                    if (dualLeftHostFinal != null) reparentHostChild(dualLeftHostFinal, newViewForDual);
                                    if (thirdHostFinal != null)    reparentHostChild(thirdHostFinal, newViewForThird);

                                    invokeIfExists(newDualLeftAV, "updateLocationAndTapExcludeRegion");
                                    invokeIfExists(newThirdAv, "updateLocationAndTapExcludeRegion");
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
                                "dual_left", "single_Third",
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
                            "dual_left", "single_Third",
                            lastPipBounds.getOrDefault("dual", offscreen),
                            lastPipBounds.getOrDefault("third", offscreen),
                            "leftAV", "av", dual, third
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
                        atomicOk = false;
                    }

                    if (atomicOk) {
                        try {
                            if (firstHost != null) try { firstHost.removeAllViews(); } catch (Throwable ignore) {}
                            if (thirdHost != null) try { thirdHost.removeAllViews(); } catch (Throwable ignore) {}

                            invokeIfExists(firstAv, "clearActivityViewGeometryForIme");
                            invokeIfExists(thirdAv, "clearActivityViewGeometryForIme");

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
                            final ViewGroup firstHostFinal = firstHost;
                            final ViewGroup thirdHostFinal = thirdHost;

                            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                                try {
                                    Object newFirstAv = reflectGetField(firstRef, "av");
                                    Object newThirdAv = reflectGetField(thirdRef, "av");
                                    View vFirst = asView(newFirstAv);
                                    View vThird = asView(newThirdAv);
                                    if (firstHostFinal != null) reparentHostChild(firstHostFinal, vFirst);
                                    if (thirdHostFinal != null) reparentHostChild(thirdHostFinal, vThird);
                                    invokeIfExists(newFirstAv, "updateLocationAndTapExcludeRegion");
                                    invokeIfExists(newThirdAv, "updateLocationAndTapExcludeRegion");
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
                                "single_First", "single_Third",
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
                            "single_First", "single_Third",
                            lastPipBounds.getOrDefault("first", offscreen),
                            lastPipBounds.getOrDefault("third", offscreen),
                            "av", "av", first, third
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
                    Launcher.mLauncher.sendBroadcast(new android.content.Intent(Keys.BLOCK_FLOATING_BUTTON));
                }
            } catch (Throwable ignore) {}

            WindowHost host = WindowHost.sInstance;
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
                            Log.w(TAG, "swapRightAndFourth: viewForDualRight or viewForFourth null, skipping atomic");
                        }
                    } catch (Throwable t) {
                        Log.w(TAG, "swapRightAndFourth: atomic swap threw", t);
                        atomicOk = false;
                    }

                    if (atomicOk) {
                        try {
                            if (dualRightHost != null) try { dualRightHost.removeAllViews(); } catch (Throwable ignore) {}
                            if (fourthHost != null)    try { fourthHost.removeAllViews(); }    catch (Throwable ignore) {}

                            invokeIfExists(dualRightAV, "clearActivityViewGeometryForIme");
                            invokeIfExists(fourthAv, "clearActivityViewGeometryForIme");

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
                            final ViewGroup dualRightHostFinal = dualRightHost;
                            final ViewGroup fourthHostFinal = fourthHost;
                            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                                try {
                                    Object newDualRightAV = reflectGetField(dualRef, "rightAV");
                                    Object newFourthAv = reflectGetField(fourthRef, "av");
                                    View viewForDualAfter = asView(newDualRightAV);
                                    View viewForFourthAfter = asView(newFourthAv);
                                    if (dualRightHostFinal != null) reparentHostChild(dualRightHostFinal, viewForDualAfter);
                                    if (fourthHostFinal != null)   reparentHostChild(fourthHostFinal, viewForFourthAfter);
                                    invokeIfExists(newDualRightAV, "updateLocationAndTapExcludeRegion");
                                    invokeIfExists(newFourthAv, "updateLocationAndTapExcludeRegion");
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
                                "dual_right", "single_Fourth",
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
                            "dual_right", "single_Fourth",
                            lastPipBounds.getOrDefault("dual", offscreen),
                            lastPipBounds.getOrDefault("fourth", offscreen),
                            "rightAV", "av", dual, fourth
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
                        atomicOk = false;
                    }

                    if (atomicOk) {
                        try {
                            if (secondHost != null) try { secondHost.removeAllViews(); } catch (Throwable ignore) {}
                            if (fourthHost != null) try { fourthHost.removeAllViews(); } catch (Throwable ignore) {}

                            invokeIfExists(secondAv, "clearActivityViewGeometryForIme");
                            invokeIfExists(fourthAv, "clearActivityViewGeometryForIme");

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

                            final Object secondRef = second;
                            final Object fourthRef = fourth;
                            final ViewGroup secondHostFinal = secondHost;
                            final ViewGroup fourthHostFinal = fourthHost;
                            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                                try {
                                    Object newSecondAv = reflectGetField(secondRef, "av");
                                    Object newFourthAv = reflectGetField(fourthRef, "av");
                                    View vSecond = asView(newSecondAv);
                                    View vFourth = asView(newFourthAv);
                                    if (secondHostFinal != null) reparentHostChild(secondHostFinal, vSecond);
                                    if (fourthHostFinal != null) reparentHostChild(fourthHostFinal, vFourth);
                                    invokeIfExists(newSecondAv, "updateLocationAndTapExcludeRegion");
                                    invokeIfExists(newFourthAv, "updateLocationAndTapExcludeRegion");
                                } catch (Throwable t) {
                                    Log.w(TAG, "swapRightAndFourth: delayed reattach failed (standalone)", t);
                                }
                            }, 50);

                            // Update prefs: swap second <-> fourth
                            swapPrefsPackages(Keys.PIP_SECOND_PACKAGE, Keys.PIP_FOURTH_PACKAGE);

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
                                "single_Second", "single_Fourth",
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
                            "single_Second", "single_Fourth",
                            lastPipBounds.getOrDefault("second", offscreen),
                            lastPipBounds.getOrDefault("fourth", offscreen),
                            "av", "av", second, fourth
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
            // method not present; that's fine
        } catch (Throwable t) {
            Log.w("Windowutil", "invokeIfExists failed: " + methodName, t);
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

    private static void reparentHostChild(Object hostContainer, View newChild) {
        try {
            if (hostContainer == null) return;
            if (!(hostContainer instanceof ViewGroup)) {
                Log.w(TAG, "reparentHostChild: hostContainer is not a ViewGroup: " + hostContainer.getClass().getName());
                return;
            }
            ViewGroup vg = (ViewGroup) hostContainer;
            try { vg.removeAllViews(); } catch (Throwable ignore) {}

            if (newChild != null) {
                // detach from previous parent
                try {
                    ViewParent p = newChild.getParent();
                    if (p instanceof ViewGroup) {
                        ((ViewGroup) p).removeView(newChild);
                    }
                } catch (Throwable ignore) {}

                // Add child immediately so view hierarchy is consistent (visual handoff)
                try {
                    vg.addView(newChild, new FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                } catch (Throwable t) {
                    try { vg.addView(newChild); } catch (Throwable ignore) {}
                }

                // Best-effort: attempt native reparent and wait until WindowSession reports success.
                final View finalChild = newChild;
                final ViewGroup finalVg = vg;
                final long deadline = SystemClock.uptimeMillis() + 1000; // 1s timeout
                final Handler mainH = new Handler(Looper.getMainLooper());

                final Runnable waiter = new Runnable() {
                    @Override public void run() {
                        try {
                            boolean ok = false;
                            try {
                                // Try notifyReparentDisplayContentToHost which internally tries WindowSession.reparentDisplayContent
                                ok = WindowHostReparenter.notifyReparentDisplayContentToHost(finalChild, finalVg);
                            } catch (Throwable t) {
                                Log.d(TAG, "reparentHostChild: notifyReparentDisplayContentToHost threw", t);
                                ok = false;
                            }

                            // Additionally accept success if ActivityView reports stable virtual display id or Surface valid
                            if (!ok) {
                                try {
                                    // Try to detect ActivityView readiness (best-effort)
                                    int did = getVirtualDisplayIdSafely(finalChild);
                                    if (did >= 0) ok = true;
                                    else {
                                        // check inner Surface validity
                                        SurfaceView sv = findSurfaceView(finalChild);
                                        if (sv != null) {
                                            SurfaceHolder holder = sv.getHolder();
                                            if (holder != null) {
                                                android.view.Surface s = holder.getSurface();
                                                if (s != null && s.isValid()) ok = true;
                                            }
                                        }
                                    }
                                } catch (Throwable ignore) {}
                            }

                            if (ok) {
                                // Success: now notify ActivityView to update geometry safely
                                try { invokeIfExists(finalChild, "updateLocationAndTapExcludeRegion"); } catch (Throwable ignore) {}
                                try { invokeIfExists(finalChild, "clearActivityViewGeometryForIme"); } catch (Throwable ignore) {}
                                // done
                                return;
                            }

                            // Not yet ok: retry if we have time left
                            if (SystemClock.uptimeMillis() < deadline) {
                                mainH.postDelayed(this, 40);
                                return;
                            } else {
                                // Timed out — log and still attempt the safe notifications (best-effort)
                                Log.w(TAG, "reparentHostChild: native reparent did not confirm within timeout; proceeding anyway");
                                try { invokeIfExists(finalChild, "updateLocationAndTapExcludeRegion"); } catch (Throwable ignore) {}
                                try { invokeIfExists(finalChild, "clearActivityViewGeometryForIme"); } catch (Throwable ignore) {}
                            }
                        } catch (Throwable t) {
                            Log.w(TAG, "reparentHostChild: waiter failure", t);
                        }
                    }
                };

                // start waiting
                mainH.post(waiter);

                // Also attempt native reparent immediately (best-effort)
                try {
                    WindowHostReparenter.reparentActivityViewSurface(finalChild);
                } catch (Throwable t) {
                    Log.w(TAG, "reparentHostChild: reparentActivityViewSurface failed", t);
                }
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

    private static boolean attemptTaskRelocateSwap(final ViewGroup hostA, final ViewGroup hostB,
                                                   final Object oldAvA, final Object oldAvB,
                                                   final int taskA, final int taskB,
                                                   final String pkgA, final String pkgB,
                                                   final String poolKeyA, final String poolKeyB,
                                                   final Rect boundsA, final Rect boundsB) {
        try {
            final Activity act = Launcher.getLauncher();
            if (act == null) return false;

            Object newA = WindowHostSurfacePreloader.getWarmActivityView(poolKeyA);
            if (newA == null) newA = WindowHostActivityView.newInstance(act);
            Object newB = WindowHostSurfacePreloader.getWarmActivityView(poolKeyB);
            if (newB == null) newB = WindowHostActivityView.newInstance(act);

            if (newA == null || newB == null) return false;

            final View newAView = WindowHostActivityView.asView(newA);
            final View newBView = WindowHostActivityView.asView(newB);

            try { WindowHostSurfacePreloader.forceInstantSurfaceReady(newAView); } catch (Throwable ignore) {}
            try { WindowHostSurfacePreloader.forceInstantSurfaceReady(newBView); } catch (Throwable ignore) {}

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

            Intent intentA = WindowHostActivityView.getLaunchIntentForPackage(act, pkgB);
            Intent intentB = WindowHostActivityView.getLaunchIntentForPackage(act, pkgA);

            try {
                boolean okA = WindowHostActivityView.startActivitySmartWithProcessCheck(newA, act, pkgB, boundsA);
                if (!okA && intentA != null) {
                    try { WindowHostActivityView.startActivitySmart(newA, act, intentA, optsA); } catch (Throwable ignore) {}
                }
            } catch (Throwable t) {
                Log.w(TAG, "attemptTaskRelocateSwap: start into newA failed", t);
                if (intentA != null) try { WindowHostActivityView.startActivitySmart(newA, act, intentA, optsA); } catch (Throwable ignore) {}
            }
            try {
                boolean okB = WindowHostActivityView.startActivitySmartWithProcessCheck(newB, act, pkgA, boundsB);
                if (!okB && intentB != null) {
                    try { WindowHostActivityView.startActivitySmart(newB, act, intentB, optsB); } catch (Throwable ignore) {}
                }
            } catch (Throwable t) {
                Log.w(TAG, "attemptTaskRelocateSwap: start into newB failed", t);
                if (intentB != null) try { WindowHostActivityView.startActivitySmart(newB, act, intentB, optsB); } catch (Throwable ignore) {}
            }

            final AtomicBoolean readyA = new AtomicBoolean(false);
            final AtomicBoolean readyB = new AtomicBoolean(false);
            WindowHostActivityView.trySetCallback(newA, new WindowHostActivityView.Callback() {
                @Override public void onReady() { readyA.set(true); }
                @Override public void onTaskCreated(int id) {}
            });
            WindowHostActivityView.trySetCallback(newB, new WindowHostActivityView.Callback() {
                @Override public void onReady() { readyB.set(true); }
                @Override public void onTaskCreated(int id) {}
            });

            final long deadline = SystemClock.uptimeMillis() + 1200;
            final Handler h = new Handler(Looper.getMainLooper());

            Object finalNewA = newA;
            Object finalNewB = newB;
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

                                        invokeIfExists(finalNewA, "updateLocationAndTapExcludeRegion");
                                        invokeIfExists(finalNewB, "updateLocationAndTapExcludeRegion");

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
                                             final String poolKeyA, final String poolKeyB,
                                             final Rect boundsA, final Rect boundsB,
                                             final String avFieldNameA, final String avFieldNameB,
                                             final Object hostObjA, final Object hostObjB) {
        try {
            final Activity act = Launcher.getLauncher();
            if (act == null) return;
            if (hostA == null || hostB == null) return;

            Object newA = WindowHostSurfacePreloader.getWarmActivityView(poolKeyA);
            if (newA == null) newA = WindowHostActivityView.newInstance(act);
            Object newB = WindowHostSurfacePreloader.getWarmActivityView(poolKeyB);
            if (newB == null) newB = WindowHostActivityView.newInstance(act);

            if (newA == null || newB == null) {
                Log.w(TAG, "safeOverlaySwapPanes: failed to obtain new AVs");
                return;
            }

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

            WindowHostSurfacePreloader.forceInstantSurfaceReady(newAView);
            WindowHostSurfacePreloader.forceInstantSurfaceReady(newBView);

            final AtomicBoolean readyA = new AtomicBoolean(false);
            final AtomicBoolean readyB = new AtomicBoolean(false);
            WindowHostActivityView.trySetCallback(newA, new WindowHostActivityView.Callback() {
                @Override public void onReady() { readyA.set(true); }
                @Override public void onTaskCreated(int id) {}
            });
            WindowHostActivityView.trySetCallback(newB, new WindowHostActivityView.Callback() {
                @Override public void onReady() { readyB.set(true); }
                @Override public void onTaskCreated(int id) {}
            });

            try {
                boolean ok = WindowHostActivityView.startActivitySmartWithProcessCheck(newA, act, pkgB, boundsA);
                if (!ok) {
                    Intent fallback = WindowHostActivityView.getLaunchIntentForPackage(act, pkgB);
                    if (fallback != null) WindowHostActivityView.startActivitySmart(newA, act, fallback, (ActivityOptions) WindowHostActivityView.makeOptionsWithBounds(pkgB, boundsA));
                }
            } catch (Throwable t) {
                Log.w(TAG, "safeOverlaySwapPanes: start into newA failed", t);
            }
            try {
                boolean ok = WindowHostActivityView.startActivitySmartWithProcessCheck(newB, act, pkgA, boundsB);
                if (!ok) {
                    Intent fallback = WindowHostActivityView.getLaunchIntentForPackage(act, pkgA);
                    if (fallback != null) WindowHostActivityView.startActivitySmart(newB, act, fallback, (ActivityOptions) WindowHostActivityView.makeOptionsWithBounds(pkgA, boundsB));
                }
            } catch (Throwable t) {
                Log.w(TAG, "safeOverlaySwapPanes: start into newB failed", t);
            }

            final long deadline = SystemClock.uptimeMillis() + 1400;
            final Handler mainH = new Handler(Looper.getMainLooper());
            Object finalNewA = newA;
            Object finalNewB = newB;
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
                                try { reflectSetField(hostObjA, avFieldNameA, finalNewA); } catch (Throwable ignore) {}
                                try { reflectSetField(hostObjB, avFieldNameB, finalNewB); } catch (Throwable ignore) {}

                                invokeIfExists(finalNewA, "updateLocationAndTapExcludeRegion");
                                invokeIfExists(finalNewB, "updateLocationAndTapExcludeRegion");
                                invokeIfExists(finalNewA, "clearActivityViewGeometryForIme");
                                invokeIfExists(finalNewB, "clearActivityViewGeometryForIme");

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
