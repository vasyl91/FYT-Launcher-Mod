package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;

import com.android.launcher66.LauncherApplication;

public class Helpers {

    private final SharedPreferences sharedPrefs = LauncherApplication.sApp.getSharedPreferences("HelpersPrefs", Context.MODE_PRIVATE);
    private final SharedPreferences.Editor editor = sharedPrefs.edit();

    private boolean day = false;
    public boolean isDay() {
        day = sharedPrefs.getBoolean("day", false);
        return day;
    }
    public void setDay(boolean day) {
        this.day = day;
        editor.putBoolean("day", day);
        editor.apply();
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
        polarDay = sharedPrefs.getBoolean("polarDay", false);
        return polarDay;
    }
    public void setPolarDay(boolean polarDay) {
        this.polarDay = polarDay;
        editor.putBoolean("polarDay", polarDay);
        editor.apply();
    }


    private boolean perpetualNight = false;
    public boolean isPerpetualNight() {
        perpetualNight = sharedPrefs.getBoolean("perpetualNight", false);
        return perpetualNight;
    }
    public void setPerpetualNight(boolean perpetualNight) {
        this.perpetualNight = perpetualNight;
        editor.putBoolean("perpetualNight", perpetualNight);
        editor.apply();
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
    public void setAllAppsShouldBVisible(boolean allAppsShouldBVisible) {
        this.allAppsShouldBVisible = allAppsShouldBVisible;
        editor.putBoolean("allAppsShouldBVisible", allAppsShouldBVisible);
        editor.apply();
    }


    private boolean jobInitOnCreate = false;
    public boolean onCreateJobInit() {
        jobInitOnCreate = sharedPrefs.getBoolean("jobInitOnCreate", false);
        return jobInitOnCreate;
    }
    public void setOnCreateJobInit(boolean jobInitOnCreate) {
        this.jobInitOnCreate = jobInitOnCreate;
        editor.putBoolean("jobInitOnCreate", jobInitOnCreate);
        editor.apply();
    }


    private boolean connectionOnCreate = false;
    public boolean onCreateConnection() {
        connectionOnCreate = sharedPrefs.getBoolean("connectionOnCreate", false);
        return connectionOnCreate;
    }
    public void setOnCreateConnection(boolean connectionOnCreate) {
        this.connectionOnCreate = connectionOnCreate;
        editor.putBoolean("connectionOnCreate", connectionOnCreate);
        editor.apply();
    }


    private boolean connectionJobInit = false;
    public boolean onConnectionJobInit() {
        connectionJobInit = sharedPrefs.getBoolean("connectionJobInit", false);
        return connectionJobInit;
    }
    public void setConnectionJobInit(boolean connectionJobInit) {
        this.connectionJobInit = connectionJobInit;
        editor.putBoolean("connectionJobInit", connectionJobInit);
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


    private boolean canbusServiceRunning = false;
    public boolean isCanbusServiceRunning() {
        canbusServiceRunning = sharedPrefs.getBoolean("canbusServiceRunning", false);
        return canbusServiceRunning;
    }
    public void setCanbusServiceRunning(boolean canbusServiceRunning) {
        this.canbusServiceRunning = canbusServiceRunning;
        editor.putBoolean("canbusServiceRunning", canbusServiceRunning);
        editor.apply();
    }


    private boolean appOpenedByUser = false;
    public boolean isAppOpenedByUser() {
        appOpenedByUser = sharedPrefs.getBoolean("appOpenedByUser", false);
        return appOpenedByUser;
    }
    public void setAppOpenedByUser(boolean appOpenedByUser) {
        this.appOpenedByUser = appOpenedByUser;
        editor.putBoolean("appOpenedByUser", appOpenedByUser);
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
    
    public static boolean isPackageInstalled(String packageName, PackageManager packageManager) {
        try {
            return packageManager.getApplicationInfo(packageName, 0).enabled;
        }
        catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}