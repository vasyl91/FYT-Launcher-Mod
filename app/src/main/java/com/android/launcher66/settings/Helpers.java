package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.preference.PreferenceManager;

import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.LauncherGlideBitmapLoader;

public class Helpers {

    private static final String TAG = "Helpers";
    private static SharedPreferences mPrefs;
    // These prefs are reseted on each onCreate or on recreateView in Launcher.java
    private final SharedPreferences sharedPrefs = LauncherApplication.sApp.getSharedPreferences("HelpersPrefs", Context.MODE_PRIVATE);
    private final SharedPreferences.Editor editor = sharedPrefs.edit();
    // These prefs remain
    private final SharedPreferences sharedPrefsSus = LauncherApplication.sApp.getSharedPreferences("HelpersPrefsSus", Context.MODE_PRIVATE);
    private final SharedPreferences.Editor editorSus = sharedPrefsSus.edit();

    private boolean day = false;
    public boolean isDay() {
        day = sharedPrefsSus.getBoolean("day", false);
        return day;
    }
    public void setDay(boolean day) {
        this.day = day;
        editorSus.putBoolean("day", day);
        editorSus.apply();
    }


    private boolean backFromCreator = false;
    public boolean isBackFromCreator() {
        backFromCreator = sharedPrefs.getBoolean("backFromCreator", false);
        return backFromCreator;
    }
    public void setBackFromCreator(boolean backFromCreator) {
        this.backFromCreator = backFromCreator;
        editor.putBoolean("backFromCreator", backFromCreator);
        editor.apply();
    }


    private boolean polarDay = false;    
    public boolean isPolarDay() {
        polarDay = sharedPrefsSus.getBoolean("polarDay", false);
        return polarDay;
    }
    public void setPolarDay(boolean polarDay) {
        this.polarDay = polarDay;
        editorSus.putBoolean("polarDay", polarDay);
        editorSus.apply();
    }


    private boolean perpetualNight = false;
    public boolean isPerpetualNight() {
        perpetualNight = sharedPrefsSus.getBoolean("perpetualNight", false);
        return perpetualNight;
    }
    public void setPerpetualNight(boolean perpetualNight) {
        this.perpetualNight = perpetualNight;
        editorSus.putBoolean("perpetualNight", perpetualNight);
        editorSus.apply();
    }


    private boolean barSettingsChanged = false;
    public boolean hasBarSettingsChanged() {
        barSettingsChanged = sharedPrefs.getBoolean("barSettingsChanged", false);
        return barSettingsChanged;
    }
    public void setBarSettingsChanged(boolean barSettingsChanged) {
        this.barSettingsChanged = barSettingsChanged;
        editor.putBoolean("barSettingsChanged", barSettingsChanged);
        editor.apply();
    }


    private boolean userOpenedCreator = false;
    public boolean hasUserOpenedCreator() {
        userOpenedCreator = sharedPrefs.getBoolean("userOpenedCreator", false);
        return userOpenedCreator;
    }
    public void setUserOpenedCreator(boolean userOpenedCreator) {
        this.userOpenedCreator = userOpenedCreator;
        editor.putBoolean("userOpenedCreator", userOpenedCreator);
        editor.apply();
    }


    private boolean firstPreferenceWindow = false;
    public boolean isFirstPreferenceWindow() {
        firstPreferenceWindow = sharedPrefs.getBoolean("firstPreferenceWindow", false);
        return firstPreferenceWindow;
    }
    public void setFirstPreferenceWindow(boolean firstPreferenceWindow) {
        this.firstPreferenceWindow = firstPreferenceWindow;
        editor.putBoolean("firstPreferenceWindow", firstPreferenceWindow);
        editor.apply();
    }


    private boolean wallpaperWindow = false;
    public boolean isWallpaperWindow() {
        wallpaperWindow = sharedPrefs.getBoolean("wallpaperWindow", false);
        return wallpaperWindow;
    }
    public void setWallpaperWindow(boolean wallpaperWindow) {
        this.wallpaperWindow = wallpaperWindow;
        editor.putBoolean("wallpaperWindow", wallpaperWindow);
        editor.apply();
    }


    private boolean controllerTimeBool = false; 
    public boolean returnControllerTimeBool() {
        controllerTimeBool = sharedPrefs.getBoolean("controllerTimeBool", false);
        return controllerTimeBool;
    }
    public void updateControllerTimeBool(boolean controllerTimeBool) {
        this.controllerTimeBool = controllerTimeBool;
        editor.putBoolean("controllerTimeBool", controllerTimeBool);
        editor.apply();
    }


    private boolean overviewMode = false;
    public boolean isInOverviewMode() {
        overviewMode = sharedPrefs.getBoolean("overviewMode", false);
        return overviewMode;
    }
    public void setInOverviewMode(boolean overviewMode) {
        this.overviewMode = overviewMode;
        editor.putBoolean("overviewMode", overviewMode);
        editor.apply();
    }


    private boolean inAllApps = false;
    public boolean isInAllApps() {
        inAllApps = sharedPrefs.getBoolean("inAllApps", false);
        return inAllApps;
    }
    public void setInAllApps(boolean inAllApps) {
        this.inAllApps = inAllApps;
        editor.putBoolean("inAllApps", inAllApps);
        editor.apply();
    }


    private boolean inWidgets = false;
    public boolean isInWidgets() {
        inWidgets = sharedPrefs.getBoolean("inWidgets", false);
        return inWidgets;
    }
    public void setInWidgets(boolean inWidgets) {
        this.inWidgets = inWidgets;
        editor.putBoolean("inWidgets", inWidgets);
        editor.apply();
    }


    private boolean foregroundAppOpened = false;
    public boolean isForegroundAppOpened() {
        foregroundAppOpened = sharedPrefs.getBoolean("foregroundAppOpened", false);
        return foregroundAppOpened;
    }
    public void setForegroundAppOpened(boolean foregroundAppOpened) {
        this.foregroundAppOpened = foregroundAppOpened;
        editor.putBoolean("foregroundAppOpened", foregroundAppOpened);
        editor.apply();
    }


    private boolean pipStarted = true;
    public boolean hasPipStarted() {
        pipStarted = sharedPrefs.getBoolean("pipStarted", true);
        return pipStarted;
    }
    public void setPipStarted(boolean pipStarted) {
        this.pipStarted = pipStarted;
        editor.putBoolean("pipStarted", pipStarted);
        editor.apply();
    }


    private boolean listOpen = false;
    public boolean isListOpen() {
        listOpen = sharedPrefs.getBoolean("listOpen", false);
        return listOpen;
    }
    public void setListOpen(boolean listOpen) {
        this.listOpen = listOpen;
        editor.putBoolean("listOpen", listOpen);
        editor.apply();
    }


    private boolean inRecent = false;
    public boolean isInRecent() {
        inRecent = sharedPrefs.getBoolean("inRecent", false);
        return inRecent;
    }
    public void setInRecent(boolean inRecent) {
        this.inRecent = inRecent;
        editor.putBoolean("inRecent", inRecent);
        editor.apply();
    }


    private boolean wasInRecents = false;
    public boolean userWasInRecents() {
        wasInRecents = sharedPrefs.getBoolean("wasInRecents", false);
        return wasInRecents;
    }
    public void setWasInRecents(boolean wasInRecents) {
        this.wasInRecents = wasInRecents;
        editor.putBoolean("wasInRecents", wasInRecents);
        editor.apply();
    }


    private boolean allAppsShouldBVisible = false;
    public boolean shouldAllAppsBeVisible() {
        allAppsShouldBVisible = sharedPrefs.getBoolean("allAppsShouldBVisible", false);
        return allAppsShouldBVisible;
    }
    public void setAllAppsShouldBeVisible(boolean allAppsShouldBVisible) {
        this.allAppsShouldBVisible = allAppsShouldBVisible;
        editor.putBoolean("allAppsShouldBVisible", allAppsShouldBVisible);
        editor.apply();
    }


    private boolean correctionChanged = false;
    public boolean hasCorrectionChanged() {
        correctionChanged = sharedPrefs.getBoolean("correctionChanged", false);
        return correctionChanged;
    }
    public void setCorrectionChanged(boolean correctionChanged) {
        this.correctionChanged = correctionChanged;
        editor.putBoolean("correctionChanged", correctionChanged);
        editor.apply();
    }


    private boolean layoutTypeChanged = false;
    public boolean hasLayoutTypeChanged() {
        layoutTypeChanged = sharedPrefs.getBoolean("layoutTypeChanged", false);
        return layoutTypeChanged;
    }
    public void setLayoutTypeChanged(boolean layoutTypeChanged) {
        this.layoutTypeChanged = layoutTypeChanged;
        editor.putBoolean("layoutTypeChanged", layoutTypeChanged);
        editor.apply();
    }


    private boolean displayState = true;
    public boolean displayStateBoolean() {
        displayState = sharedPrefs.getBoolean("displayState", true);
        return displayState;
    }
    public void setDisplayStateBoolean(boolean displayState) {
        this.displayState = displayState;
        editor.putBoolean("displayState", displayState);
        editor.apply();
    }


    private boolean settingsOpened = false;
    public boolean settingsOpenedBoolean() {
        settingsOpened = sharedPrefs.getBoolean("settingsOpened", false);
        return settingsOpened;
    }
    public void setSettingsOpenedBoolean(boolean settingsOpened) {
        this.settingsOpened = settingsOpened;
        editor.putBoolean("settingsOpened", settingsOpened);
        editor.apply();
    }


    private boolean openedFromOverview = false;
    public boolean openedFromOverviewBoolean() {
        openedFromOverview = sharedPrefs.getBoolean("openedFromOverview", false);
        return openedFromOverview;
    }
    public void setOpenedFromOverviewBoolean(boolean openedFromOverview) {
        this.openedFromOverview = openedFromOverview;
        editor.putBoolean("openedFromOverview", openedFromOverview);
        editor.apply();
    }


    private boolean isWidgetClicked = false;
    public boolean isWidgetClickedBool() {
        isWidgetClicked = sharedPrefs.getBoolean("isWidgetClicked", false);
        return isWidgetClicked;
    }
    public void setWidgetClicked(boolean isWidgetClicked) {
        this.isWidgetClicked = isWidgetClicked;
        editor.putBoolean("isWidgetClicked", isWidgetClicked);
        editor.apply();
    }


    private boolean onWidgetDropPip = false;
    public boolean onWidgetDropPipBool() {
        onWidgetDropPip = sharedPrefs.getBoolean("onWidgetDropPip", false);
        return onWidgetDropPip;
    }
    public void setWidgetDropPip(boolean onWidgetDropPip) {
        this.onWidgetDropPip = onWidgetDropPip;
        editor.putBoolean("onWidgetDropPip", onWidgetDropPip);
        editor.apply();
    }


    private boolean arePipsAdded = false;
    public boolean pipsAdded() {
        arePipsAdded = sharedPrefs.getBoolean("arePipsAdded", false);
        return arePipsAdded;
    }
    public void setPipsAdded(boolean arePipsAdded) {
        this.arePipsAdded = arePipsAdded;
        editor.putBoolean("arePipsAdded", arePipsAdded);
        editor.apply();
    }


    private boolean codeInspector = false;
    public boolean codeInspectorBoolean() {
        codeInspector = sharedPrefsSus.getBoolean("codeInspector", false);
        return codeInspector;
    }
    public void setCodeInspectorBoolean(boolean codeInspector) {
        this.codeInspector = codeInspector;
        editorSus.putBoolean("codeInspector", codeInspector);
        editorSus.apply();
    }
    

    private boolean codeLogger = false;
    public boolean codeLoggerBoolean() {
        codeLogger = sharedPrefsSus.getBoolean("codeLogger", false);
        return codeLogger;
    }
    public void setCodeLoggerBoolean(boolean codeLogger) {
        this.codeLogger = codeLogger;
        editorSus.putBoolean("codeLogger", codeLogger);
        editorSus.apply();
    }


    private boolean logcatRun = false;
    public boolean logcatRunBoolean() {
        logcatRun = sharedPrefsSus.getBoolean("logcatRun", false);
        return logcatRun;
    }
    public void setLogcatRunBoolean(boolean logcatRun) {
        this.logcatRun = logcatRun;
        editorSus.putBoolean("logcatRun", logcatRun);
        editorSus.apply();
    }


    private boolean allAppsTextSize = false;
    public boolean allAppsTextSizeBoolean() {
        allAppsTextSize = sharedPrefsSus.getBoolean("allAppsTextSize", false);
        return allAppsTextSize;
    }
    public void allAppsTextSizeChanged(boolean allAppsTextSize) {
        this.allAppsTextSize = allAppsTextSize;
        editorSus.putBoolean("allAppsTextSize", allAppsTextSize);
        editorSus.apply();
    }
    

    private boolean workspaceTextSize = false;
    public boolean workspaceTextSizeBoolean() {
        workspaceTextSize = sharedPrefsSus.getBoolean("workspaceTextSize", false);
        return workspaceTextSize;
    }
    public void workspaceTextSizeChanged(boolean workspaceTextSize) {
        this.workspaceTextSize = workspaceTextSize;
        editorSus.putBoolean("workspaceTextSize", workspaceTextSize);
        editorSus.apply();
    }


    // FYT sometimes updates data with some delay. This Boolean exist to not to interrupt changed media source.
    private boolean fytMusicAllowed = true;
    public boolean isFytMusicAllowed() {
        fytMusicAllowed = sharedPrefs.getBoolean("fytMusicAllowed", true);
        return fytMusicAllowed;
    }
    public void setFytMusicAllowed(boolean fytMusicAllowed) {
        this.fytMusicAllowed = fytMusicAllowed;
        editor.putBoolean("fytMusicAllowed", fytMusicAllowed);
        editor.apply();
    }


    private String mediaSourcePre = "";
    public String returnMediaSourcePre() {
        mediaSourcePre = sharedPrefs.getString("mediaSourcePre", "");
        return mediaSourcePre;
    }
    public void setMediaSourcePre(String mediaSourcePre) {
        this.mediaSourcePre = mediaSourcePre;
        editor.putString("mediaSourcePre", mediaSourcePre);
        editor.apply();
    }


    private int counter = 0;
    public int returnCounter() {
        counter = sharedPrefs.getInt("counter", 0);
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
        editor.putInt("counter", counter);
        editor.apply();
    }


    private int countDownInspector = 0;
    public int returnCountDownInspector() {
        countDownInspector = sharedPrefsSus.getInt("countDownInspector", 0);
        return countDownInspector;
    }
    public void setCountDownInspector(int countDownInspector) {
        this.countDownInspector = countDownInspector;
        editorSus.putInt("countDownInspector", countDownInspector);
        editorSus.apply();
    }


    private int countDownLogger = 0;
    public int returnCountDownLogger() {
        countDownLogger = sharedPrefsSus.getInt("countDownLogger", 0);
        return countDownLogger;
    }
    public void setCountDownLogger(int countDownLogger) {
        this.countDownLogger = countDownLogger;
        editorSus.putInt("countDownLogger", countDownLogger);
        editorSus.apply();
    }


    private int countDownLogcat = 0;
    public int returnCountDownLogcat() {
        countDownLogcat = sharedPrefsSus.getInt("countDownLogcat", 0);
        return countDownLogcat;
    }
    public void setCountDownLogcat(int countDownLogcat) {
        this.countDownLogcat = countDownLogcat;
        editorSus.putInt("countDownLogcat", countDownLogcat);
        editorSus.apply();
    }

    public boolean allAppsVisibility(int visibility) {
        if (visibility == View.INVISIBLE || visibility == View.GONE) {
            return false;
        } else if ((!isInRecent() && !userWasInRecents()) || visibility == View.VISIBLE) {
            return true;
        }
        return false;
    }    

    public static String getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "N/A";
        }
    }

    /** -1 Check all screens, reset overlapping rectangles on same screen
     *   0 Check only screen 0, reset overlapping rectangles on that screen
     *   1 Check only screen 1, reset overlapping rectangles on that screen
     *   and so on..
     */
    public boolean checkAndResetIfOverlappingOnScreen(int screenToCompare) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        
        // Rectangle configurations with their screen keys
        String[] rectangleKeys = {"pipDual", "pipFirst", "pipSecond", "pipThird", "pipFourth", "date", "music", "radio"};
        String[] screenKeys = {Keys.PIP_DUAL_SCREEN, Keys.PIP_FIRST_SCREEN, Keys.PIP_SECOND_SCREEN, 
                              Keys.PIP_THIRD_SCREEN, Keys.PIP_FOURTH_SCREEN, Keys.DATE_SCREEN, 
                              Keys.MUSIC_SCREEN, Keys.RADIO_SCREEN};
        
        // Check which rectangles are enabled
        boolean dualPip = mPrefs.getBoolean(Keys.PIP_DUAL, false);
        boolean firstPip = mPrefs.getBoolean(Keys.PIP_FIRST, false);
        boolean secondPip = mPrefs.getBoolean(Keys.PIP_SECOND, false);
        boolean thirdPip = mPrefs.getBoolean(Keys.PIP_THIRD, false);
        boolean fourthPip = mPrefs.getBoolean(Keys.PIP_FOURTH, false);
        boolean pip = mPrefs.getBoolean(Keys.DISPLAY_PIP, false);
        boolean date = mPrefs.getBoolean(Keys.USER_DATE, false);
        boolean music = mPrefs.getBoolean(Keys.USER_MUSIC, false);
        boolean radio = mPrefs.getBoolean(Keys.USER_RADIO, false);
        
        boolean[] enabledStates = {
            pip && dualPip && !firstPip && !secondPip,  // pipDual
            pip && firstPip && !dualPip,                // pipFirst
            pip && secondPip && !dualPip,               // pipSecond
            pip && thirdPip,                            // pipThird
            pip && fourthPip,                           // pipFourth
            date,                                       // date
            music,                                      // music
            radio,                                      // radio
        };
        
        // Get screen assignments for each rectangle
        int[] screens = new int[rectangleKeys.length];
        for (int i = 0; i < screenKeys.length; i++) {
            screens[i] = mPrefs.getInt(screenKeys[i], 1) - 1;
        }
        
        boolean foundOverlap = false;
        boolean[] needsReset = new boolean[rectangleKeys.length];
        
        // Calculate bottom bar area if needed
        RectF bottomBarRect = null;
        boolean leftBar = mPrefs.getBoolean(Keys.LEFT_BAR, false);
        boolean autoHideBottomBar = mPrefs.getBoolean(Keys.AUTO_HIDE_BOTTOM_BAR, false);
        int orientation = LauncherApplication.sApp.getResources().getConfiguration().orientation;
        
        // Only create bottom bar rect if we're checking screen 0 (or all screens)
        if (screenToCompare == -1 || screenToCompare == 0) {
            int screenWidth = Launcher.screenWidth;
            int screenHeight = Launcher.screenHeight;
            int bottomBarHeight;
            int bottomBarWidth;
            
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                bottomBarHeight = (int) (screenWidth * 0.142);
            } else {
                bottomBarHeight = (int) (screenHeight * 0.1638);
            }
            
            float bottomBarTop = screenHeight - bottomBarHeight;
            
            if (!leftBar) {
                // Bottom bar at bottom of screen
                if (!autoHideBottomBar) {
                    // Full width bottom bar
                    bottomBarRect = new RectF(0, bottomBarTop, screenWidth, screenHeight);
                } else {
                    // Only first cell when auto-hide is enabled
                    bottomBarWidth = (int) (screenWidth * 0.071f); // 7.1% of screen width
                    bottomBarRect = new RectF(0, bottomBarTop, bottomBarWidth, screenHeight);
                }
            } else {
                // Left bar configuration
                if (!autoHideBottomBar) {
                    // Full width bottom bar
                    bottomBarRect = new RectF(0, bottomBarTop, screenWidth, screenHeight);
                }
                // When leftBar && autoHideBottomBar, no bottom bar area to reserve
            }
        }
        
        // Calculate right border exclusion area for left bar mode
        float leftBarWidth = Launcher.screenWidth * 0.071f;
        int margin = Integer.valueOf(mPrefs.getString("layout_margin", "10"));
        
        // Check for overlaps between rectangles
        for (int i = 0; i < rectangleKeys.length; i++) {
            if (!enabledStates[i]) continue;
            
            // Skip if screenToCompare is specified and this rectangle is not on that screen
            if (screenToCompare >= 0 && screens[i] != screenToCompare) continue;
            
            // Get rectangle bounds for first rectangle
            RectF rectA = getRectangleBounds(mPrefs, rectangleKeys[i]);
            if (rectA.isEmpty()) {
                // If rectA is empty it means that it has never been set before (app's fresh start)
                foundOverlap = true;
                needsReset[i] = true;
                Log.i(TAG, "Rectangle " + rectangleKeys[i] + " is empty");
                continue;
            }
            
            // Check for overlap with bottom bar (only on screen 0)
            if (screens[i] == 0 && bottomBarRect != null && overlapsOrTouches(rectA, bottomBarRect)) {
                foundOverlap = true;
                needsReset[i] = true;
                Log.i(TAG, "Rectangle " + rectangleKeys[i] + " overlaps with bottom bar");
            }

            // Check for overlap with right border (only in left bar mode AND only on screen 0)
            if (leftBar && screens[i] == 0 && overlapsOrTouchesBorder(rectA, leftBarWidth, margin)) {
                foundOverlap = true;
                needsReset[i] = true;
                Log.i(TAG, "Rectangle " + rectangleKeys[i] + " overlaps with right border");
            }
            
            // Check for overlap with other rectangles
            for (int j = i + 1; j < rectangleKeys.length; j++) {
                if (!enabledStates[j]) continue;
                
                // Check if rectangles are on the same screen
                if (screenToCompare == -1) {
                    // Check all screens - rectangles must be on same screen to overlap
                    if (screens[i] != screens[j]) continue;
                } else {
                    // Check specific screen - both rectangles must be on the specified screen
                    if (screens[j] != screenToCompare) continue;
                }
                
                // Get rectangle bounds for second rectangle
                RectF rectB = getRectangleBounds(mPrefs, rectangleKeys[j]);
                if (rectB.isEmpty()) continue;
                
                // Check for overlap (including touching edges)
                if (overlapsOrTouches(rectA, rectB)) {
                    foundOverlap = true;
                    needsReset[i] = true;
                    needsReset[j] = true;
                    Log.i(TAG, "Rectangle " + rectangleKeys[i] + " overlaps with: " + rectangleKeys[j]);
                }
            }
        }
        
        // Reset overlapping rectangles if any were found
        if (foundOverlap) {
            resetOverlappingRectangles(mPrefs, rectangleKeys, needsReset, enabledStates, screenToCompare);
        }
        
        return foundOverlap;
    }

    private RectF getRectangleBounds(SharedPreferences mPrefs, String key) {
        int topLeftX = mPrefs.getInt(key + "TopLeftX", 0);
        int topLeftY = mPrefs.getInt(key + "TopLeftY", 0);
        int topRightX = mPrefs.getInt(key + "TopRightX", 0);
        int topRightY = mPrefs.getInt(key + "TopRightY", 0);
        int bottomRightX = mPrefs.getInt(key + "BottomRightX", 0);
        int bottomRightY = mPrefs.getInt(key + "BottomRightY", 0);
        int bottomLeftX = mPrefs.getInt(key + "BottomLeftX", 0);
        int bottomLeftY = mPrefs.getInt(key + "BottomLeftY", 0);
        
        // Calculate bounds from the four corner points
        float left = Math.min(topLeftX, bottomLeftX);
        float right = Math.max(topRightX, bottomRightX);
        float top = Math.min(topLeftY, topRightY);
        float bottom = Math.max(bottomLeftY, bottomRightY);
        
        if (right <= left || bottom <= top) return new RectF();
        return new RectF(left, top, right, bottom);
    }

    private static boolean overlapsOrTouches(RectF a, RectF b) {
        // If there is any separating gap, they don't intersect.
        return !(a.right < b.left || b.right < a.left || a.bottom < b.top || b.bottom < a.top);
    }

    private static boolean overlapsOrTouchesBorder(RectF a, float leftBarWidth, int margin) {
        int width = Launcher.screenWidth;
        return ((a.right + leftBarWidth) > (width - margin));
    }

    private void resetOverlappingRectangles(SharedPreferences mPrefs, String[] rectangleKeys, 
                                          boolean[] needsReset, boolean[] enabledStates, int screenToCompare) {
        SharedPreferences.Editor editorReset = mPrefs.edit();
        int margin = Integer.valueOf(mPrefs.getString("layout_margin", "10"));
        if (margin < 0) margin = 10;
        
        // Get dimensions
        int pipMinWidth = Launcher.calculatedPipMinWidth;
        int pipMinWidthStandard = pipMinWidth;
        int pipMinHeight = Launcher.calculatedPipMinHeight;
        int dateMinWidth = Launcher.calculatedDateMinWidth;
        int dateMinHeight = Launcher.calculatedDateMinHeight;
        int musicMinWidth = Launcher.calculatedMusicMinWidth;
        int musicMinHeight = Launcher.calculatedMusicMinHeight;
        int radioMinWidth = Launcher.calculatedRadioMinWidth;
        int radioMinHeight = Launcher.calculatedRadioMinHeight;
        
        boolean dualPip = mPrefs.getBoolean(Keys.PIP_DUAL, false);
        boolean firstPip = mPrefs.getBoolean(Keys.PIP_FIRST, false);
        boolean secondPip = mPrefs.getBoolean(Keys.PIP_SECOND, false);
        boolean thirdPip = mPrefs.getBoolean(Keys.PIP_THIRD, false);
        boolean fourthPip = mPrefs.getBoolean(Keys.PIP_FOURTH, false);
        
        // Calculate adjusted pip width
        pipMinWidth = (pipMinWidth / countEnabledPips(dualPip, firstPip, secondPip, thirdPip, fourthPip)) - (margin / 2);
        
        // Get actual count of enabled individual pips for positioning logic
        int enabledPipCount = 0;
        if (dualPip) {
            enabledPipCount = 2;
        } else {
            if (firstPip) enabledPipCount++;
            if (secondPip) enabledPipCount++;
        }
        if (thirdPip) enabledPipCount++;
        if (fourthPip) enabledPipCount++;
        
        // Calculate bottom bar area to avoid
        boolean leftBar = mPrefs.getBoolean(Keys.LEFT_BAR, false);
        boolean autoHideBottomBar = mPrefs.getBoolean(Keys.AUTO_HIDE_BOTTOM_BAR, false);
        int orientation = LauncherApplication.sApp.getResources().getConfiguration().orientation;
        int screenWidth = Launcher.screenWidth;
        int screenHeight = Launcher.screenHeight;
        int bottomBarHeight;
        
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            bottomBarHeight = (int) (screenWidth * 0.142);
        } else {
            bottomBarHeight = (int) (screenHeight * 0.1638);
        }
        
        float bottomBarTop = screenHeight - bottomBarHeight;
        
        // Base position for first PIP - ensure it doesn't overlap with bottom bar
        int baseX = margin;
        int baseY = margin + dateMinHeight + margin;
        
        // Adjust baseY if it would overlap with bottom bar on screen 0
        float pipBottom = baseY + pipMinHeight;
        if (screenToCompare == 0 && !leftBar && !autoHideBottomBar && pipBottom > bottomBarTop) {
            // Calculate available space above bottom bar
            float availableHeight = bottomBarTop - (margin + dateMinHeight + margin);
            
            if (availableHeight >= pipMinHeight) {
                // Can fit PIPs above bottom bar
                baseY = (int) (bottomBarTop - pipMinHeight - margin);
            } else {
                // Not enough space, need to reduce PIP height or adjust layout
                // For now, just position at the top of available space
                baseY = margin + dateMinHeight + margin;
            }
        }
        
        int pipIndex = 0;
        
        for (int i = 0; i < rectangleKeys.length; i++) {
            if (!needsReset[i] || !enabledStates[i]) continue;
            
            String key = rectangleKeys[i];
            
            switch (key) {
                case "pipDual":
                    if (compareScreensForReset(Keys.PIP_DUAL_SCREEN, screenToCompare, mPrefs)) {
                        int x = baseX;
                        int y = baseY;
                        
                        // Ensure PIP doesn't overlap with bottom bar on screen 0
                        int pipScreen = mPrefs.getInt(Keys.PIP_DUAL_SCREEN, 1) - 1;
                        if (pipScreen == 0 && !leftBar && !autoHideBottomBar && (y + pipMinHeight) > bottomBarTop) {
                            y = (int) (bottomBarTop - pipMinHeight - margin);
                        }
                        
                        editorReset.putInt("pipDualTopLeftX", x);
                        editorReset.putInt("pipDualTopLeftY", y);
                        editorReset.putInt("pipDualTopRightX", x + pipMinWidthStandard);
                        editorReset.putInt("pipDualTopRightY", y);
                        editorReset.putInt("pipDualBottomRightX", x + pipMinWidthStandard);
                        editorReset.putInt("pipDualBottomRightY", y + pipMinHeight);
                        editorReset.putInt("pipDualBottomLeftX", x);
                        editorReset.putInt("pipDualBottomLeftY", y + pipMinHeight);
                        pipIndex++;
                    }
                    break;
                    
                case "pipFirst":
                    if (compareScreensForReset(Keys.PIP_FIRST_SCREEN, screenToCompare, mPrefs)) {
                        int x = baseX;
                        int y = baseY;
                        
                        // Ensure PIP doesn't overlap with bottom bar on screen 0
                        int pipScreen = mPrefs.getInt(Keys.PIP_FIRST_SCREEN, 1) - 1;
                        if (pipScreen == 0 && !leftBar && !autoHideBottomBar && (y + pipMinHeight) > bottomBarTop) {
                            y = (int) (bottomBarTop - pipMinHeight - margin);
                        }
                        
                        editorReset.putInt("pipFirstTopLeftX", x);
                        editorReset.putInt("pipFirstTopLeftY", y);
                        editorReset.putInt("pipFirstTopRightX", x + pipMinWidth);
                        editorReset.putInt("pipFirstTopRightY", y);
                        editorReset.putInt("pipFirstBottomRightX", x + pipMinWidth);
                        editorReset.putInt("pipFirstBottomRightY", y + pipMinHeight);
                        editorReset.putInt("pipFirstBottomLeftX", x);
                        editorReset.putInt("pipFirstBottomLeftY", y + pipMinHeight);
                        pipIndex++;
                    }
                    break;
                    
                case "pipSecond":
                    if (compareScreensForReset(Keys.PIP_SECOND_SCREEN, screenToCompare, mPrefs)) {
                        int x, y;
                        
                        if (enabledPipCount == 1) {
                            x = baseX;
                            y = baseY;
                        } else if (enabledPipCount == 2) {
                            if (firstPip) {
                                x = baseX + pipMinWidth + margin;
                            } else {
                                x = baseX;
                            }
                            y = baseY;
                        } else {
                            x = baseX + pipMinWidth + margin;
                            y = baseY;
                        }
                        
                        // Ensure PIP doesn't overlap with bottom bar on screen 0
                        int pipScreen = mPrefs.getInt(Keys.PIP_SECOND_SCREEN, 1) - 1;
                        if (pipScreen == 0 && !leftBar && !autoHideBottomBar && (y + pipMinHeight) > bottomBarTop) {
                            y = (int) (bottomBarTop - pipMinHeight - margin);
                        }
                        
                        editorReset.putInt("pipSecondTopLeftX", x);
                        editorReset.putInt("pipSecondTopLeftY", y);
                        editorReset.putInt("pipSecondTopRightX", x + pipMinWidth);
                        editorReset.putInt("pipSecondTopRightY", y);
                        editorReset.putInt("pipSecondBottomRightX", x + pipMinWidth);
                        editorReset.putInt("pipSecondBottomRightY", y + pipMinHeight);
                        editorReset.putInt("pipSecondBottomLeftX", x);
                        editorReset.putInt("pipSecondBottomLeftY", y + pipMinHeight);
                        pipIndex++;
                    }
                    break;
                    
                case "pipThird":
                    if (compareScreensForReset(Keys.PIP_THIRD_SCREEN, screenToCompare, mPrefs)) {
                        int x, y;
                        
                        if (enabledPipCount == 1) {
                            x = baseX;
                            y = baseY;
                        } else if (enabledPipCount == 2) {
                            if (pipIndex == 0) {
                                x = baseX;
                            } else {
                                x = baseX + pipMinWidth + margin;
                            }
                            y = baseY;
                        } else {
                            if (dualPip) {
                                x = baseX;
                            } else {
                                x = baseX;
                            }
                            y = baseY + pipMinHeight + margin;
                        }
                        
                        // Ensure PIP doesn't overlap with bottom bar on screen 0
                        int pipScreen = mPrefs.getInt(Keys.PIP_THIRD_SCREEN, 1) - 1;
                        if (pipScreen == 0 && !leftBar && !autoHideBottomBar && (y + pipMinHeight) > bottomBarTop) {
                            y = (int) (bottomBarTop - pipMinHeight - margin);
                        }
                        
                        editorReset.putInt("pipThirdTopLeftX", x);
                        editorReset.putInt("pipThirdTopLeftY", y);
                        editorReset.putInt("pipThirdTopRightX", x + pipMinWidth);
                        editorReset.putInt("pipThirdTopRightY", y);
                        editorReset.putInt("pipThirdBottomRightX", x + pipMinWidth);
                        editorReset.putInt("pipThirdBottomRightY", y + pipMinHeight);
                        editorReset.putInt("pipThirdBottomLeftX", x);
                        editorReset.putInt("pipThirdBottomLeftY", y + pipMinHeight);
                        pipIndex++;
                    }
                    break;
                    
                case "pipFourth":
                    if (compareScreensForReset(Keys.PIP_FOURTH_SCREEN, screenToCompare, mPrefs)) {
                        int x, y;
                        
                        if (enabledPipCount == 1) {
                            x = baseX;
                            y = baseY;
                        } else if (enabledPipCount == 2) {
                            if (pipIndex == 0) {
                                x = baseX;
                            } else {
                                x = baseX + pipMinWidth + margin;
                            }
                            y = baseY;
                        } else {
                            x = baseX + pipMinWidth + margin;
                            y = baseY + pipMinHeight + margin;
                        }
                        
                        // Ensure PIP doesn't overlap with bottom bar on screen 0
                        int pipScreen = mPrefs.getInt(Keys.PIP_FOURTH_SCREEN, 1) - 1;
                        if (pipScreen == 0 && !leftBar && !autoHideBottomBar && (y + pipMinHeight) > bottomBarTop) {
                            y = (int) (bottomBarTop - pipMinHeight - margin);
                        }
                        
                        editorReset.putInt("pipFourthTopLeftX", x);
                        editorReset.putInt("pipFourthTopLeftY", y);
                        editorReset.putInt("pipFourthTopRightX", x + pipMinWidth);
                        editorReset.putInt("pipFourthTopRightY", y);
                        editorReset.putInt("pipFourthBottomRightX", x + pipMinWidth);
                        editorReset.putInt("pipFourthBottomRightY", y + pipMinHeight);
                        editorReset.putInt("pipFourthBottomLeftX", x);
                        editorReset.putInt("pipFourthBottomLeftY", y + pipMinHeight);
                    }
                    break;
                    
                case "date":
                    if (compareScreensForReset(Keys.DATE_SCREEN, screenToCompare, mPrefs)) {
                        int dateY = margin;
                        
                        // Ensure date doesn't overlap with bottom bar on screen 0
                        int dateScreen = mPrefs.getInt(Keys.DATE_SCREEN, 1) - 1;
                        if (dateScreen == 0 && !leftBar && !autoHideBottomBar && (dateY + dateMinHeight) > bottomBarTop) {
                            dateY = (int) (bottomBarTop - dateMinHeight - margin);
                        }
                        
                        editorReset.putInt("dateTopLeftX", margin);
                        editorReset.putInt("dateTopLeftY", dateY);
                        editorReset.putInt("dateTopRightX", margin + dateMinWidth);
                        editorReset.putInt("dateTopRightY", dateY);
                        editorReset.putInt("dateBottomRightX", margin + dateMinWidth);
                        editorReset.putInt("dateBottomRightY", dateY + dateMinHeight);
                        editorReset.putInt("dateBottomLeftX", margin);
                        editorReset.putInt("dateBottomLeftY", dateY + dateMinHeight);
                    }
                    break;
                    
                case "music":
                    if (compareScreensForReset(Keys.MUSIC_SCREEN, screenToCompare, mPrefs)) {
                        int musicScreen = mPrefs.getInt(Keys.MUSIC_SCREEN, 1) - 1;
                        
                        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                            int musicY = margin + dateMinHeight + margin + ((pipMinHeight + margin) * 2);
                            
                            // Ensure music doesn't overlap with bottom bar on screen 0
                            if (musicScreen == 0 && !leftBar && !autoHideBottomBar && (musicY + musicMinHeight) > bottomBarTop) {
                                musicY = (int) (bottomBarTop - musicMinHeight - margin);
                            }
                            
                            editorReset.putInt("musicTopLeftX", margin);
                            editorReset.putInt("musicTopLeftY", musicY);
                            editorReset.putInt("musicTopRightX", margin + musicMinWidth);
                            editorReset.putInt("musicTopRightY", musicY);
                            editorReset.putInt("musicBottomRightX", margin + musicMinWidth);
                            editorReset.putInt("musicBottomRightY", musicY + musicMinHeight);
                            editorReset.putInt("musicBottomLeftX", margin);
                            editorReset.putInt("musicBottomLeftY", musicY + musicMinHeight);
                        } else {
                            int musicY = margin + radioMinHeight + margin;
                            
                            // Ensure music doesn't overlap with bottom bar on screen 0
                            if (musicScreen == 0 && !leftBar && !autoHideBottomBar && (musicY + musicMinHeight) > bottomBarTop) {
                                musicY = (int) (bottomBarTop - musicMinHeight - margin);
                            }
                            
                            editorReset.putInt("musicTopLeftX", margin + pipMinWidthStandard + margin);
                            editorReset.putInt("musicTopLeftY", musicY);
                            editorReset.putInt("musicTopRightX", margin + pipMinWidthStandard + margin + musicMinWidth);
                            editorReset.putInt("musicTopRightY", musicY);
                            editorReset.putInt("musicBottomRightX", margin + pipMinWidthStandard + margin + musicMinWidth);
                            editorReset.putInt("musicBottomRightY", musicY + musicMinHeight);
                            editorReset.putInt("musicBottomLeftX", margin + pipMinWidthStandard + margin);
                            editorReset.putInt("musicBottomLeftY", musicY + musicMinHeight);
                        }
                    }
                    break;
                    
                case "radio":
                    if (compareScreensForReset(Keys.RADIO_SCREEN, screenToCompare, mPrefs)) {
                        int radioScreen = mPrefs.getInt(Keys.RADIO_SCREEN, 1) - 1;
                        
                        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                            int radioY = margin + dateMinHeight + margin + ((pipMinHeight + margin) * 2);
                            
                            // Ensure radio doesn't overlap with bottom bar on screen 0
                            if (radioScreen == 0 && !leftBar && !autoHideBottomBar && (radioY + radioMinHeight) > bottomBarTop) {
                                radioY = (int) (bottomBarTop - radioMinHeight - margin);
                            }
                            
                            editorReset.putInt("radioTopLeftX", margin + musicMinWidth + margin);
                            editorReset.putInt("radioTopLeftY", radioY);
                            editorReset.putInt("radioTopRightX", margin + musicMinWidth + margin + radioMinWidth);
                            editorReset.putInt("radioTopRightY", radioY);
                            editorReset.putInt("radioBottomRightX", margin + musicMinWidth + margin + radioMinWidth);
                            editorReset.putInt("radioBottomRightY", radioY + radioMinHeight);
                            editorReset.putInt("radioBottomLeftX", margin + musicMinWidth + margin);
                            editorReset.putInt("radioBottomLeftY", radioY + radioMinHeight);
                        } else {
                            int radioY = margin;
                            
                            // Ensure radio doesn't overlap with bottom bar on screen 0
                            if (radioScreen == 0 && !leftBar && !autoHideBottomBar && (radioY + radioMinHeight) > bottomBarTop) {
                                radioY = (int) (bottomBarTop - radioMinHeight - margin);
                            }
                            
                            editorReset.putInt("radioTopLeftX", margin + dateMinWidth + margin);
                            editorReset.putInt("radioTopLeftY", radioY);
                            editorReset.putInt("radioTopRightX", margin + dateMinWidth + margin + radioMinWidth);
                            editorReset.putInt("radioTopRightY", radioY);
                            editorReset.putInt("radioBottomRightX", margin + dateMinWidth + margin + radioMinWidth);
                            editorReset.putInt("radioBottomRightY", radioY + radioMinHeight);
                            editorReset.putInt("radioBottomLeftX", margin + dateMinWidth + margin);
                            editorReset.putInt("radioBottomLeftY", radioY + radioMinHeight);
                        }
                    }
                    break;
            }
        }
        
        editorReset.apply();
    }

    private boolean compareScreensForReset(String pipScreenKey, int screenToCompare, SharedPreferences mPrefs) {
        if (screenToCompare == -1) return true;
        int pipScreen = mPrefs.getInt(pipScreenKey, 1) - 1;
        return screenToCompare == pipScreen;
    }

    // Never returns 0, max value is 2
    private static int countEnabledPips(boolean dualPip, boolean firstPip, boolean secondPip, boolean thirdPip, boolean fourthPip) {
        int count = 0;
        if (firstPip || dualPip) count++;
        if (secondPip || dualPip) count++;
        if (thirdPip) count++;
        if (fourthPip) count++;
        return Math.min(Math.max(1, count), 2);
    }
    
    public static boolean isPackageInstalled(String packageName) {
        try {
            PackageManager packageManager = LauncherApplication.sApp.getPackageManager();
            return packageManager.getApplicationInfo(packageName, 0).enabled;
        }
        catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static Bitmap glideLoader(int drawable) {
        final Bitmap[] iconBitmap = new Bitmap[1];
        LauncherGlideBitmapLoader.loadBitmapAsync(drawable, new LauncherGlideBitmapLoader.BitmapLoadListener() {
            @Override
            public void onBitmapLoaded(@NonNull Bitmap bitmap) {
                iconBitmap[0] = bitmap;
            }

            @Override
            public void onLoadFailed() {
                Log.i("glideLoader", "load failed for drawable: " + drawable);
                iconBitmap[0] = BitmapFactory.decodeResource(LauncherApplication.sApp.getResources(), drawable);
            }
        });
        return iconBitmap[0];
    }

    public static void applyColorFilterToButton(Button button) {
        Drawable buttonDrawable = button.getBackground();
        if (buttonDrawable != null) {
            buttonDrawable.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
        }
    }

    public static void applyColorFilterToImageView(ImageView imageView) {
        Drawable imageDrawable = imageView.getDrawable();
        if (imageDrawable != null) {
            imageDrawable.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
        }
    }

    public static void removeColorFilterFromImageView(ImageView imageView) {
        Drawable imageDrawable = imageView.getDrawable();
        if (imageDrawable != null) {
            imageDrawable.clearColorFilter();
        }
        imageView.clearColorFilter();
        imageView.invalidate();
    }
}