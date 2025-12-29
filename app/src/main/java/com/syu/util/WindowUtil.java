package com.syu.util;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.SystemProperties;
import android.util.Log;
import android.view.View;
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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class WindowUtil {
    private static final String TAG = "WindowUtil";
    private static SharedPreferences prefs;
    private static Helpers helpers;
    public static String AppPackageName = "";
    public static int delayMillis = 0;
    private static WindowHost mWindowHost;
    private static String firstPkg;
    private static String secondPkg;
    private static final AtomicInteger SCREEN_SWITCH_GEN = new AtomicInteger();
    private static Rect offscreen = new Rect(-3000, -3000, -2400, -2400);
    private static final Map<String, Boolean> pipOffscreenState = new HashMap<>();
    private static final Map<String, Rect> lastPipBounds = new HashMap<>();

    public static boolean dualPip = true;
    public static boolean firstPip = true;
    public static boolean secondPip = true;
    public static boolean thirdPip = true;
    public static boolean fourthPip = true;
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
            if (AppPackageName.isEmpty() || AppPackageName == null) {
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
        // Pre-warm common ActivityViews on app start
        Context ctx = LauncherApplication.sApp;
        new Thread(() -> {
            try {
                Thread.sleep(2000); // Wait for app to stabilize
                
                WindowHostSurfacePreloader.prewarmActivityView(ctx, "dual_left");
                WindowHostSurfacePreloader.prewarmActivityView(ctx, "dual_right");
                WindowHostSurfacePreloader.prewarmActivityView(ctx, "single_First");
                WindowHostSurfacePreloader.prewarmActivityView(ctx, "single_Second");
                WindowHostSurfacePreloader.prewarmActivityView(ctx, "single_Third");
                WindowHostSurfacePreloader.prewarmActivityView(ctx, "single_Fourth");
                
                Log.i(TAG, "Surface preloader initialized");
            } catch (Exception e) {
                Log.e(TAG, "Failed to initialize surface preloader", e);
            }
        }).start();
    }

    public static void startMapPip(final View v, final boolean show) {
        ThreadManager.getLongPool().execute(() -> WindowUtil.openPip(v, show));
    }

    public static void startMapPip(final View v, final boolean show, int millis) {
        delayMillis = millis;
        ThreadManager.getLongPool().execute(() -> WindowUtil.openPip(v, show));
    }

    public static void openPip(View v, boolean show) {
        if (!LauncherApplication.isFytDevice()) return;
        if (Launcher.getLauncher().allowPip) {
            try {
                if (helpers == null) {
                    helpers = new Helpers();
                }
                Log.i(TAG, "openPip(): " +  "show: "+ String.valueOf(show)
                    + " helpers.pipsAdded(): " + String.valueOf(helpers.pipsAdded())
                    + " Utils.topApp(): " + String.valueOf(Utils.topApp()) 
                    + " helpers.pipsAdded() " + String.valueOf(helpers.pipsAdded()) 
                    + " AppPackageName.isEmpty() " + String.valueOf(AppPackageName.isEmpty())
                    + " helpers.isInWidgets() " + String.valueOf(helpers.isInWidgets()) 
                    + " helpers.isInAllApps() " + String.valueOf(helpers.isInAllApps())  
                    + " helpers.isInOverviewMode() " + String.valueOf(helpers.isInOverviewMode()) 
                    + " helpers.isFirstPreferenceWindow() " + String.valueOf(helpers.isFirstPreferenceWindow()) 
                    + " helpers.allAppsVisibility() " + String.valueOf(helpers.allAppsVisibility(Launcher.mAppsCustomizeTabHost.getVisibility())) 
                    + " helpers.isWallpaperWindow() " + String.valueOf(helpers.isWallpaperWindow())
                    + " helpers.isListOpen() " + String.valueOf(helpers.isListOpen()));
                if ((show && !helpers.pipsAdded()) || (Utils.topApp()
                    && !helpers.pipsAdded()
                    && !helpers.isInWidgets()
                    && !helpers.isInAllApps()
                    && !helpers.isInOverviewMode()
                    && !helpers.isFirstPreferenceWindow()
                    && !helpers.isWallpaperWindow()
                    && !helpers.allAppsVisibility(Launcher.mAppsCustomizeTabHost.getVisibility())
                    || (!helpers.userWasInRecents() && helpers.isListOpen()))) {

                    if (prefs == null) {
                        prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp); 
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
                            if (mWindowHost != null) {
                                Launcher.getLauncher().handler.post(() -> mWindowHost.dismiss());
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
                            Launcher.getLauncher().pipOverview();
                            Launcher.getLauncher().handler.postDelayed(() -> {     
                                if (checkIfPinned()) {
                                    openPinnedPip();
                                }
                            }, delayMillis);
                            Launcher.getLauncher().handler.postDelayed(() -> {
                                openMultiplePips();
                            }, delayMillis + 100);                
                        }
                    } 

                    delayMillis = 0;
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

    public static void removePip(final View v, int millis) {
        delayMillis = millis;
        ThreadManager.getLongPool().execute(() -> WindowUtil.removePip(v));
    }

    public static void removePip(View v) {
        if (!LauncherApplication.isFytDevice()) return;
        if (helpers == null) {
            helpers = new Helpers();
        }
        if (helpers.pipsAdded()) {
            Log.d(TAG, "removePip..");
            Launcher.getLauncher().handler.postDelayed(() -> {
                if (checkIfPinned() && WindowUtil.AppPackageName.equals("com.syu.camera360")) {
                    LauncherApplication.sApp.sendBroadcast(new Intent("com.syu.camera360.hide"));
                }
            }, delayMillis);
            if (AppPackageName.equals(FytPackage.GaodeACTION)) {
                try {
                    LauncherApplication.sApp.removeGaoDeCoverView();
                } catch (Exception e) {
                    e.printStackTrace();
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
            Helpers helpers = new Helpers();
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
                // Dismiss windowed activity
                if (mWindowHost != null) {
                    Launcher.getLauncher().handler.post(() -> mWindowHost.dismiss());
                    prepareNextSurfaceLoad();
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

    public static void prepareNextSurfaceLoad() {
        Context ctx = LauncherApplication.sApp;
        new Thread(() -> {
            WindowHostSurfacePreloader.clearPool();
            
            // Re-warm for next use
            WindowHostSurfacePreloader.prewarmActivityView(ctx, "dual_left");
            WindowHostSurfacePreloader.prewarmActivityView(ctx, "dual_right");
            WindowHostSurfacePreloader.prewarmActivityView(ctx, "single_First");
            WindowHostSurfacePreloader.prewarmActivityView(ctx, "single_Second");
            WindowHostSurfacePreloader.prewarmActivityView(ctx, "single_Third");
            WindowHostSurfacePreloader.prewarmActivityView(ctx, "single_Fourth");
        }).start();
    }
    
    // WINDOWED PIPS

    public static void openMultiplePips() {
        if (!LauncherApplication.isFytDevice()) return;
        dualPip = prefs.getBoolean(Keys.PIP_DUAL, false);
        firstPip = prefs.getBoolean(Keys.PIP_FIRST, false);
        secondPip = prefs.getBoolean(Keys.PIP_SECOND, false);
        thirdPip = prefs.getBoolean(Keys.PIP_THIRD, false);
        fourthPip = prefs.getBoolean(Keys.PIP_FOURTH, false);

        mWindowHost = new WindowHost(Launcher.getLauncher());
        firstPkg = prefs.getString(Keys.PIP_FIRST_PACKAGE, "");
        secondPkg = prefs.getString(Keys.PIP_SECOND_PACKAGE, "");
        
        Workspace workspace = Launcher.getLauncher().getWorkspace();
        
        if (dualPip && !mWindowHost.isDualVisible() && !firstPipPinned && !secondPipPinned 
            && Helpers.isPackageInstalled(firstPkg) && Helpers.isPackageInstalled(secondPkg)) {    
            try {
                Rect rDual = offscreen;
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
                        Rect rFirst = offscreen;
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
                        Rect rSecond = offscreen;
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
        
        final String thirdPkg = prefs.getString(Keys.PIP_THIRD_PACKAGE, "");
        if (thirdPip && !mWindowHost.isThirdVisible() && Helpers.isPackageInstalled(thirdPkg)) {
            if (!thirdPipPinned) {
                try {
                    Rect rThird = offscreen;
                    if (rThird != null) {
                        mWindowHost.showThird(thirdPkg, rThird);
                        Log.i(TAG, "third: show " + thirdPkg);
                    }
                } catch (Throwable t) {
                    Log.w(TAG, "third: open failed", t);
                }
            }
        }
        
        final String fourthPkg = prefs.getString(Keys.PIP_FOURTH_PACKAGE, "");
        if (fourthPip && !mWindowHost.isFourthVisible() && Helpers.isPackageInstalled(fourthPkg)) {
            if (!fourthPipPinned) {
                try {
                    Rect rFourth = offscreen;
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
                Workspace ws = Launcher.getLauncher().getWorkspace();
                if (ws != null) {
                    int currentScroll = ws.mUnboundedScrollX;
                    updatePipPositionsForScroll(currentScroll);
                }
            }, 100); 
        }            
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

    public static void updatePipPositionsForScroll(int scrollOffset) {
        try {
            if (Launcher.getLauncher() == null) return;
            
            Workspace workspace = Launcher.getLauncher().getWorkspace();
            if (workspace == null || mWindowHost == null) return;
            
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
        int pipHomeScreen = prefs.getInt(screenKey, 1) - 1;

        Workspace workspace = Launcher.getLauncher().getWorkspace();
        CellLayout pipHomeCellLayout = (CellLayout) workspace.getChildAt(pipHomeScreen);

        if (pipHomeCellLayout == null) return;

        int[] basePos = pipHomeCellLayout.getPipPlaceholderPosition(pipType);
        if (basePos == null) return;

        int pageWidth = workspace.getViewportWidth();

        // Protect against overscroll: the provided scrollOffset may be "unbounded" (overscroll)
        // while the logical maximum scroll is (pageCount - 1) * pageWidth. If there is only one
        // page (pageCount == 1) or the user is overscrolling at the edges, we should not move PiPs
        // beyond the real pages — they should stay visually anchored. Compute an effectiveScroll
        // clamped to the [0, maxScroll] range and use that for position calculations.
        int pageCount = workspace.getChildCount();
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
            Launcher.getLauncher().handler.post(() -> mWindowHost.cleanup());
        }
    }

    // PINNED PIP

    public static void openPinnedPip() {
        if (!LauncherApplication.isFytDevice()) return;
        if (helpers == null) {
            helpers = new Helpers();
        }
        if (Launcher.getLauncher().allowPip
            && Utils.topApp()
            && !helpers.isInWidgets()
            && !helpers.isInAllApps()
            && !helpers.isInOverviewMode()
            && !helpers.isFirstPreferenceWindow()
            && !helpers.isWallpaperWindow()
            && !helpers.allAppsVisibility(Launcher.mAppsCustomizeTabHost.getVisibility())
            || (!helpers.userWasInRecents() && helpers.isListOpen())) {

            if (prefs == null) {
                prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
            }

            if (!checkIfPinned()) return;

            firstPip = prefs.getBoolean(Keys.PIP_FIRST, false);
            secondPip = prefs.getBoolean(Keys.PIP_SECOND, false);
            thirdPip = prefs.getBoolean(Keys.PIP_THIRD, false);
            fourthPip = prefs.getBoolean(Keys.PIP_FOURTH, false);
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
        // Update screen
        SharedPreferences.Editor editor = prefs.edit();
        int pipScreen = prefs.getInt(screenKey, 1) - 1;
        editor.putInt(Keys.PINNED_PIP_SCREEN, pipScreen + 1);
        editor.apply();
        int currentScreen = Launcher.getLauncher().getWorkspace().getCurrentPage();

        if (helpers == null) {
            helpers = new Helpers();
        }

        SystemProperties.set("persist.syu.launcher.haspip", "true");

        if (currentScreen == pipScreen && !helpers.allAppsVisibility(Launcher.mAppsCustomizeTabHost.getVisibility())) {
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
                
                Launcher.getLauncher().handler.postDelayed(() -> startPinnedPip(packageName), 1000);
            } else {
                setPinnedPipBounds(pipKey, screenKey);         
                SystemProperties.set("persist.launcher.packagename", packageName);
                AppPackageName = packageName; 
                startPinnedPip(packageName); 
            }
        }
    }

    private static void startPinnedPip(String packageName) {
        Intent intent = FytPackage.getIntent(LauncherApplication.sApp, packageName);
        intent.putExtra("force_pip", true);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        SystemProperties.set("sys.lsec.force_pip", "true");
        if (intent.resolveActivity(LauncherApplication.sApp.getPackageManager()) != null) {
            Launcher.getLauncher().handler.postDelayed(() -> LauncherApplication.sApp.startActivity(intent), 100);
        }  
        checkIfOpenedOnTheRightScreen(500);
        checkIfOpenedOnTheRightScreen(1500);
        checkIfOpenedOnTheRightScreen(2000);      
    }

    // removes an error where windows shows up when user quickly changes to the screen on which it shouldn't appear
    private static void checkIfOpenedOnTheRightScreen(int delay) {
        Launcher.getLauncher().handler.postDelayed(() -> {
            int pipScreen = prefs.getInt(Keys.PINNED_PIP_SCREEN, 1) - 1;
            int currentScreen = Launcher.getLauncher().getWorkspace().getCurrentPage();

            if (Launcher.getLauncher().getWorkspace().getChildCount() > 1 && currentScreen != pipScreen) {
                removePinnedPip();
            }
        }, delay);
    }

    public static void restartPinnedPipApp() {
        if (!LauncherApplication.isFytDevice()) return;
        if (mWindowHost != null) {
            Launcher.getLauncher().handler.post(() -> mWindowHost.cleanup());
        }
        if (!AppPackageName.isEmpty() && AppPackageName != null) {
            ActivityManager activityManager = (ActivityManager) LauncherApplication.sApp.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
            try {
                Method forceStopPackage = activityManager.getClass().getDeclaredMethod("forceStopPackage", String.class);
                forceStopPackage.setAccessible(true);
                forceStopPackage.invoke(activityManager, AppPackageName);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
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
}