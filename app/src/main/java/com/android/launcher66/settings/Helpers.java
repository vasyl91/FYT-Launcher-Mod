package com.android.launcher66.settings;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Helpers implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    }

    public static boolean backFromCreator = false;
    public static boolean leftBarHasChanged = false;
    public static boolean firstPreferenceWindow = false;
    public static boolean wallpaperWindow = false;
    public static boolean updateControllerTimeBool = false;
    public static boolean backFromApp = false;
    public static boolean overviewMode = false;
    public static boolean inAllApps = false;
    public static boolean foregroundAppOpened = false;
    public static boolean pipStarted = true;
    public static boolean listOpen = false;
    public static boolean isInRecent = false;
    public static boolean wasInRecents = false;
    public static boolean shouldAllAppsBeVisible = false;
    public static boolean isDay = false;
    public static boolean polarDay = false;
    public static boolean perpetualNight = false;
    public static boolean onCreateJobInit = false;
    public static String mediaSourcePre = "";
    public static int counter = 0;
    public static int windowHeight = 0;
}