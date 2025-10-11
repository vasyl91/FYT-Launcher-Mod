package com.android.launcher66.settings;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.view.Display;

import androidx.annotation.Nullable;
import androidx.preference.PreferenceManager;

import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.Workspace;
import com.syu.util.Utils;
import com.syu.util.WindowUtil;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WakeDetectionService extends Service implements PropertyChangeListener {

    // Intent.ACTION_SCREEN_ON doesn't work on fyt...

    private DisplayManager displayManager;
    private Handler handler;
    private DisplayManager.DisplayListener displayListener;
    private final PropertyChangeClass mPropertyChangeClass = new PropertyChangeClass();
    private SharedPreferences mPrefs;
    private static final String TAG = "WakeDetection";
    private static final String DISPLAY_ON = "display_on";

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
                Log.e(TAG, "Device awakened from sleep");

                helpers.setDisplayStateBoolean(true);

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                if (prefs.getBoolean("night_mode", false)) {
                    new Handler(Looper.getMainLooper()).postDelayed(() -> {
                        Intent nightModeServiceIntent = new Intent(LauncherApplication.sApp, NightModeService.class);
                        LauncherApplication.sApp.startService(nightModeServiceIntent);
                    }, 10000);
                }

                mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
                boolean userMap = mPrefs.getBoolean(Keys.DISPLAY_PIP, true);        
                if (userMap) {
                    resetPip();
                }
            } else if (val.contains("false")) {
                Log.e(TAG, "ACC turned off, device has been put into sleep mode");

                helpers.setDisplayStateBoolean(false);

                Intent nightModeIntent = new Intent(LauncherApplication.sApp, NightModeService.class);
                LauncherApplication.sApp.stopService(nightModeIntent);       
            }    
        } 
    } 

    public void resetPip() {  
        // in some mysterious cases pip won't start when user wakes the device up from the sleep mode 
        // this serves as some sort of checking function to make sure it starts
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Helpers helpers = new Helpers();
            int pipScreen = mPrefs.getInt("pip_first_screen", 1) - 1;
            if (!Utils.topApp(WindowUtil.AppPackageName)
                && !helpers.isFirstPreferenceWindow()
                && !helpers.isWallpaperWindow()
                && !helpers.isInOverviewMode()
                && !Launcher.getLauncher().mDragController.isDragging()
                && !helpers.allAppsVisibility(Launcher.mAppsCustomizeTabHost.getVisibility())
                && Launcher.getWorkspace().getCurrentPage() == pipScreen
                || (!helpers.userWasInRecents() && helpers.isListOpen())) {

                    Log.e(TAG, "reset pip on wake");
                    WindowUtil.removePip(null);
                    WindowUtil.startMapPip(null, true, 500);
            }
        }, 1500);
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