package com.android.launcher66.settings;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;

import androidx.annotation.Nullable;
import androidx.preference.PreferenceManager;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.ServiceIntentGate;
import com.android.recycler.AppListDialogFragment;
import com.syu.util.FytPackage;
import com.syu.util.WindowUtil;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WakeDetectionService extends Service implements PropertyChangeListener {

    // Intent.ACTION_SCREEN_ON doesn't work on fyt...

    private DisplayManager displayManager;
    private Handler handler;
    private DisplayManager.DisplayListener displayListener;
    private final PropertyChangeClass mPropertyChangeClass = new PropertyChangeClass();
    private SharedPreferences mPrefs;

    private static final Object sServiceRunningCacheLock = new Object();
    private static final Map<String, Boolean> sServiceRunningCache = new HashMap<>();
    private static final Map<String, Long> sServiceRunningCacheTime = new HashMap<>();
    private static final long SERVICE_RUNNING_CACHE_MS = 15000L;
    private static final String TAG = "WakeDetection";
    private static final String DISPLAY_ON = "display_on";
    private static final long DISPLAY_ON_DEBOUNCE_MS = 2500L;
    public static final String ACTION_WAKE_REFRESH = "com.android.launcher66.action.WAKE_REFRESH";
    private long lastDisplayOnHandledMs = 0L;

    @Override
    public void onCreate() {
        super.onCreate();
        displayManager = (DisplayManager) getSystemService(Context.DISPLAY_SERVICE);
        handler = new Handler(Looper.getMainLooper());
        mPropertyChangeClass.addObserver(DISPLAY_ON, this);
        setupDisplayListener();
    }

    private void setupDisplayListener() {
        displayListener = new DisplayManager.DisplayListener() {
            @Override
            public void onDisplayAdded(int displayId) {
                //
            }

            @Override
            public void onDisplayRemoved(int displayId) {
                //
            }

            @Override
            public void onDisplayChanged(int displayId) {
                if (displayId == Display.DEFAULT_DISPLAY) {
                    Display display = displayManager.getDisplay(displayId);
                    if (display == null) {
                        Log.w(TAG, "Default display unavailable during display change");
                        return;
                    }
                    int state = display.getState();
                    mPropertyChangeClass.setBoolean(DISPLAY_ON, state == Display.STATE_ON);
                }
            }
        };
        displayManager.registerDisplayListener(displayListener, handler);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPropertyChangeClass.deleteObserver(DISPLAY_ON, this);
        if (displayManager != null && displayListener != null) {
            displayManager.unregisterDisplayListener(displayListener);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(DISPLAY_ON)) {
            String val = String.valueOf(evt.getNewValue());
            Helpers helpers = new Helpers();
            if (val.contains("true")) {
                helpers.setDisplayStateBoolean(true);
                long now = SystemClock.uptimeMillis();
                if (lastDisplayOnHandledMs > 0L
                        && now - lastDisplayOnHandledMs < DISPLAY_ON_DEBOUNCE_MS) {
                    Log.i(TAG, "Ignoring duplicate display-on event after " + (now - lastDisplayOnHandledMs) + " ms");
                    return;
                }
                lastDisplayOnHandledMs = now;
                Log.e(TAG, "Device awakened from sleep");
                mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
                if (mPrefs.getBoolean(Keys.LAUNCHER_HOME, true)) {
                    handler.postDelayed(this::pressHomeButton, 500);
                }
                handler.postDelayed(this::pressHomeButton, 500);
                handler.postDelayed(this::dismissAppListDialog, 500);
                handler.postDelayed(() -> sendWakeRefresh("early"), 900);
                handler.postDelayed(() -> sendWakeRefresh("late"), 1800);
                long lastSleepTimestamp = mPrefs.getLong("sleep_timestamp", -1L);
                boolean resetPip = false;

                if (lastSleepTimestamp > 0) {
                    long currentTime = System.currentTimeMillis();
                    long diff = currentTime - lastSleepTimestamp;

                    // 15 minutes = 10 * 60 * 1000 ms
                    if (diff > 15 * 60 * 1000) {
                        Log.e(TAG, "Sleep duration exceeded 15 minutes: " + diff + " ms");
                        WindowUtil.removePip();
                        getSharedPreferences("HelpersPrefs", 0).edit().clear().apply();
                        resetPip();
                        restartPip();
                        resetPip = true;
                    }
                }
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                if (prefs.getBoolean("night_mode", false)) {
                    handler.postDelayed(() -> {
                        Intent nightModeServiceIntent = new Intent(LauncherApplication.sApp, NightModeService.class);
                        ServiceIntentGate.startIfAvailable(LauncherApplication.sApp, nightModeServiceIntent, "wake night mode");
                    }, 10000);
                }

                boolean userMap = mPrefs.getBoolean(Keys.DISPLAY_PIP, true);        
                if (!resetPip && userMap) {
                    restartPip();
                }

                boolean widgetBar = mPrefs.getBoolean(Keys.WIDGET_BAR, false);
                if (widgetBar) {
                    handler.postDelayed(() -> {
                        Launcher launcher = Launcher.getLauncher();
                        if (launcher != null) {
                            launcher.updateWeather();
                        }
                    }, 2000);
                }
            } else if (val.contains("false")) {
                lastDisplayOnHandledMs = 0L;
                Log.e(TAG, "ACC turned off, device has been put into sleep mode");

                WindowUtil.removePip();

                mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
                long sleepTimestamp = System.currentTimeMillis();
                mPrefs.edit().putLong("sleep_timestamp", sleepTimestamp).apply();

                helpers.setDisplayStateBoolean(false);

                if (isServiceRunning(NightModeService.class)) {
                    NightModeService.cancelSunTask();
                    Intent nightModeIntent = new Intent(LauncherApplication.sApp, NightModeService.class);
                    LauncherApplication.sApp.stopService(nightModeIntent);  
                }     
            }    
        } 
    } 

    private boolean isServiceRunning(Class<? extends Service> serviceClass) {
        String serviceName = serviceClass.getName();
        long now = SystemClock.uptimeMillis();
        synchronized (sServiceRunningCacheLock) {
            Long checkedAt = sServiceRunningCacheTime.get(serviceName);
            Boolean running = sServiceRunningCache.get(serviceName);
            if (checkedAt != null && running != null && now - checkedAt < SERVICE_RUNNING_CACHE_MS) {
                return running;
            }
        }

        ActivityManager activityManager = (ActivityManager) LauncherApplication.sApp.getSystemService(Context.ACTIVITY_SERVICE);
        boolean isRunning = false;
        if (activityManager != null) {
            List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
            for (ActivityManager.RunningServiceInfo service : runningServices) {
                if (serviceName.equals(service.service.getClassName())) {
                    isRunning = true;
                    break;
                }
            }
        }
        setServiceRunningCache(serviceClass, isRunning);
        return isRunning;
    }

    private static void setServiceRunningCache(Class<? extends Service> serviceClass, boolean isRunning) {
        synchronized (sServiceRunningCacheLock) {
            String serviceName = serviceClass.getName();
            sServiceRunningCache.put(serviceName, isRunning);
            sServiceRunningCacheTime.put(serviceName, SystemClock.uptimeMillis());
        }
    }

    public void pressHomeButton() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        homeIntent.setClass(this, Launcher.class);
        startActivity(homeIntent);
    }

    public void dismissAppListDialog() {
        Launcher launcher = Launcher.getLauncher();
        if (launcher == null) return;
        FragmentManager fm = launcher.getSupportFragmentManager();
        DialogFragment dialog = (DialogFragment) fm.findFragmentByTag(AppListDialogFragment.TAG);
        if (dialog != null && dialog.isAdded()) {
            dialog.dismissAllowingStateLoss();
            Log.e(TAG, "AppListDialogFragment dismissed on wake-up");
            Helpers helpers = new Helpers();
            helpers.setListOpen(false);
            Intent intentClose = new Intent(Keys.LIST_CLOSE);
            LauncherApplication.sApp.sendBroadcast(intentClose);
        }
    }

    private void sendWakeRefresh(String phase) {
        Intent intent = new Intent(ACTION_WAKE_REFRESH);
        intent.putExtra("phase", phase);
        LauncherApplication.sApp.sendBroadcast(intent);
    }

    public void restartPip() {
        // in some mysterious cases pinned PiP won't start when user wakes the device up from the sleep mode 
        // this serves as some sort of checking function to make sure it starts
        handler.postDelayed(() -> WindowUtil.openPip(false), 2500);
    }

    public void resetPip() {  
        if (mPrefs == null) {
            mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        }
        boolean firstPip = mPrefs.getBoolean(Keys.PIP_FIRST, false);
        boolean dualPip = mPrefs.getBoolean(Keys.PIP_DUAL, false);
        String firstPackage = mPrefs.getString(Keys.PIP_FIRST_PACKAGE, "");
        if ((firstPip || dualPip) && !firstPackage.isEmpty()) {
            restartPipApp(Keys.PIP_FIRST_PACKAGE);
        } 
        boolean secondPip = mPrefs.getBoolean(Keys.PIP_SECOND, false);
        String secondPackage = mPrefs.getString(Keys.PIP_SECOND_PACKAGE, "");
        if ((secondPip || dualPip) && !secondPackage.isEmpty()) {
            restartPipApp(Keys.PIP_SECOND_PACKAGE);
        }
        boolean thirdPip = mPrefs.getBoolean(Keys.PIP_THIRD, false);
        String thirdPackage = mPrefs.getString(Keys.PIP_THIRD_PACKAGE, "");
        if (thirdPip && !thirdPackage.isEmpty()) {
            restartPipApp(Keys.PIP_THIRD_PACKAGE);
        }
        boolean fourthPip = mPrefs.getBoolean(Keys.PIP_FOURTH, false);
        String fourthPackage = mPrefs.getString(Keys.PIP_FOURTH_PACKAGE, "");
        if (fourthPip && !fourthPackage.isEmpty()) { 
            restartPipApp(Keys.PIP_FOURTH_PACKAGE);  
        }
    }

    public void restartPipApp(String key) {
        String appPackageName = mPrefs.getString(key, "");
        if (!appPackageName.isEmpty()) {
            if (FytPackage.GMAPS.equals(appPackageName)) {
                Log.i(TAG, "Skipping force-stop for Google Maps during wake PiP reset");
                return;
            }
            ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            try {
                Method forceStopPackage = activityManager.getClass().getDeclaredMethod("forceStopPackage", String.class);
                forceStopPackage.setAccessible(true);
                forceStopPackage.invoke(activityManager, appPackageName);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static class PropertyChangeClass {
        private boolean pBoolean = true;
        private final PropertyChangeSupport mPropertyChangeSupport = new  PropertyChangeSupport(this);

        public void setBoolean(String name, boolean bool) {
            boolean old = pBoolean;
            pBoolean = bool;
            mPropertyChangeSupport.firePropertyChange(name, old, bool);
        }

        public void addObserver(String name, PropertyChangeListener listener) {
            mPropertyChangeSupport.addPropertyChangeListener(name, listener);
        }

        public void deleteObserver(String name, PropertyChangeListener listener) {
            mPropertyChangeSupport.removePropertyChangeListener(name, listener);
        }
    }
}
