package com.fyt.skin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.android.launcher66.Launcher;
import java.lang.reflect.Field;
import java.util.HashMap;

public class SkinActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private HashMap<Activity, SkinFactory> mLayoutFactoryMap = new HashMap<>();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        try {
            @SuppressLint("SoonBlockedPrivateApi") Field field = LayoutInflater.class.getDeclaredField("mFactorySet");
            field.setAccessible(true);
            field.setBoolean(layoutInflater, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SkinFactory skinLayoutFactory = new SkinFactory();
        layoutInflater.setFactory2(skinLayoutFactory);
        SkinUtils.getSkinManager().addObserver(skinLayoutFactory);
        if (activity instanceof Launcher) {
            SkinUtils.getSkinManager().addObserver((Launcher) activity);
        }
        this.mLayoutFactoryMap.put(activity, skinLayoutFactory);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        SkinFactory skinLayoutFactory = this.mLayoutFactoryMap.remove(activity);
        SkinUtils.getSkinManager().deleteObserver(skinLayoutFactory);
    }
}