package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.preference.PreferenceManager;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.LauncherGlideBitmapLoader;

public class Helpers {

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


    private boolean leftBarHasChanged = false;
    public boolean hasLeftBarChanged() {
        leftBarHasChanged = sharedPrefs.getBoolean("leftBarHasChanged", false);
        return leftBarHasChanged;
    }
    public void setLeftBarChanged(boolean leftBarHasChanged) {
        this.leftBarHasChanged = leftBarHasChanged;
        editor.putBoolean("leftBarHasChanged", leftBarHasChanged);
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


    private int windowHeight = 0;
    public int returnWindowHeight() {
        windowHeight = sharedPrefs.getInt("windowHeight", 0);
        return windowHeight;
    }
    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
        editor.putInt("windowHeight", windowHeight);
        editor.apply();
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

    public void resetPrefs() {
        Log.i("helpers", "resetprefs");
        if ((hasLayoutTypeChanged() || hasLeftBarChanged()) && !hasUserOpenedCreator()) {
            Log.i("helpers", "resetprefs passed if statement");
            SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
            int margin = Integer.valueOf(mPrefs.getString("layout_margin", "10")); 
            int mapMinWidth = 561;
            int mapMinHeight;
            int dateMinWidth = 561;
            int dateMinHeight = 145;
            int musicMinWidth = 320;
            int musicMinHeight;
            int radioMinWidth = 320;
            int radioMinHeight = 145;
            if (LauncherApplication.sApp.getResources().getDisplayMetrics().widthPixels <= 1024
                || (LauncherApplication.sApp.getResources().getDisplayMetrics().heightPixels <= 1024 && LauncherApplication.sApp.getResources().getDisplayMetrics().heightPixels != 720)) {
                mapMinHeight = 284;
                musicMinHeight = 284;
            } else {
                mapMinHeight = 340;
                musicMinHeight = 340;               
            } 
            if (margin < 0) {
                margin = 10;
            }
            
            SharedPreferences.Editor editorReset = mPrefs.edit();
            editorReset.putInt("mapTopLeftX", margin);  
            editorReset.putInt("mapTopLeftY", margin + dateMinHeight + margin); 
            editorReset.putInt("mapTopRightX", margin + mapMinWidth);    
            editorReset.putInt("mapTopRightY", margin + dateMinHeight + margin); 
            editorReset.putInt("mapBottomRightX", margin + mapMinWidth);   
            editorReset.putInt("mapBottomRightY", margin + dateMinHeight + margin + mapMinHeight);  
            editorReset.putInt("mapBottomLeftX", margin);  
            editorReset.putInt("mapBottomLeftY", margin + dateMinHeight + margin + mapMinHeight);
            editorReset.putInt("dateTopLeftX", margin);  
            editorReset.putInt("dateTopLeftY", margin);          
            editorReset.putInt("dateTopRightX", margin + dateMinWidth);    
            editorReset.putInt("dateTopRightY", margin); 
            editorReset.putInt("dateBottomRightX", margin + dateMinWidth);  
            editorReset.putInt("dateBottomRightY", margin + dateMinHeight); 
            editorReset.putInt("dateBottomLeftX", margin);  
            editorReset.putInt("dateBottomLeftY", margin + dateMinHeight);
            editorReset.putInt("musicTopLeftX", margin + mapMinWidth + margin);  
            editorReset.putInt("musicTopLeftY", margin + radioMinHeight + margin);         
            editorReset.putInt("musicTopRightX", margin + mapMinWidth + margin + musicMinWidth);  
            editorReset.putInt("musicTopRightY", margin + radioMinHeight + margin); 
            editorReset.putInt("musicBottomRightX", margin + mapMinWidth + margin + musicMinWidth);  
            editorReset.putInt("musicBottomRightY", margin + radioMinHeight + margin + musicMinHeight); 
            editorReset.putInt("musicBottomLeftX", margin + mapMinWidth + margin);  
            editorReset.putInt("musicBottomLeftY", margin + radioMinHeight + margin + musicMinHeight);            
            editorReset.putInt("radioTopLeftX", margin + dateMinWidth + margin);
            editorReset.putInt("radioTopLeftY", margin);
            editorReset.putInt("radioTopRightX", margin + dateMinWidth + margin  + radioMinWidth);   
            editorReset.putInt("radioTopRightY", margin); 
            editorReset.putInt("radioBottomRightX", margin + dateMinWidth + margin  + radioMinWidth);  
            editorReset.putInt("radioBottomRightY", margin + radioMinHeight); 
            editorReset.putInt("radioBottomLeftX", margin + dateMinWidth + margin); 
            editorReset.putInt("radioBottomLeftY", margin + radioMinHeight);         
            editorReset.putInt("statsTopLeftX", 20);
            editorReset.putInt("statsTopLeftY", 20);         
            editorReset.apply();
        }
    }
    
    public static boolean isPackageInstalled(String packageName, PackageManager packageManager) {
        try {
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
}