package com.fyt.skin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.android.launcher66.LauncherApplication;

import java.lang.reflect.Field;
import java.util.HashMap;

public class SkinActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private final HashMap<Activity, SkinFactory> mLayoutFactoryMap = new HashMap<>();

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        SkinFactory skinLayoutFactory = new SkinFactory();
        // AppCompat has set its factory already; replacing it takes a hidden field that only a
        // platform-signed launcher may reach. Anything else (the standard version on an FYT unit)
        // keeps AppCompat's: setFactory2() would throw.
        if (LauncherApplication.isFytDevice() && LauncherApplication.hasSystemPrivileges()) {
            try {
                @SuppressLint("SoonBlockedPrivateApi") Field field = LayoutInflater.class.getDeclaredField("mFactorySet");
                field.setAccessible(true);
                field.setBoolean(layoutInflater, false);
                layoutInflater.setFactory2(skinLayoutFactory);
                SkinUtils.getSkinManager().addObserver(skinLayoutFactory);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        SkinUtils.getSkinManager().addObserver(skinLayoutFactory); 
        /*if (activity instanceof Launcher) {
            SkinUtils.getSkinManager().addObserver((Launcher) activity);
        }*/
        this.mLayoutFactoryMap.put(activity, skinLayoutFactory);
    }

    @Override
    public void onActivityStarted(Activity activity) {
    }

    @Override
    public void onActivityResumed(Activity activity) {
    }

    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        SkinFactory skinLayoutFactory = this.mLayoutFactoryMap.remove(activity);
        SkinUtils.getSkinManager().deleteObserver(skinLayoutFactory);

        if (skinLayoutFactory != null) {
            skinLayoutFactory.clear();
        }
    }
}