package com.syu.car;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

import com.android.launcher66.AppFilter;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.syu.remote.Callback;
import com.syu.util.FytPackage;
import com.syu.util.JTools;

import java.util.HashMap;

public class CustomFilter extends AppFilter implements Callback.OnRefreshLisenter, Runnable {
    public static HashMap<String, Boolean> mHideApps;
    public static final HashMap<ComponentName, Integer> mIcons = new HashMap<>();
    RefreshCallback mCallback;
    Looper workLooper = null;
    Handler mHandler = null;

    public interface RefreshCallback {
        void onRefresh();
    }

    static {
        mHideApps = null;
        mHideApps = new HashMap<>();
        mHideApps.put("com.android.calendar", true);
        mHideApps.put("com.android.inputmethod.latin", false);
        mHideApps.put(FytPackage.OUTER_DVR, false);
        mHideApps.put(FytPackage.INNER_DVR, false);
        mHideApps.put(FytPackage.ipodAction, true);
        mHideApps.put(FytPackage.dvdAction, false);
        mHideApps.put(FytPackage.cdcAction, true);
        mHideApps.put(FytPackage.carBus, false);
        mHideApps.put(FytPackage.calibrationAction, true);
        mHideApps.put(FytPackage.tvAction, false);
        mHideApps.put(FytPackage.sysSetAction, true);
        mHideApps.put("com.syu.radio", true);
        mHideApps.put("com.syu.bt", true);
        mHideApps.put(FytPackage.allappAction, false);
        mHideApps.put("com.syu.camera360", false);
    }

    @Override
    public boolean shouldShowApp(ComponentName app) {
        if (app == null) {
            return false;
        }
        String pkg = app.getPackageName();
        if (pkg == null || !mHideApps.containsKey(pkg)) {
            return true;
        }
        boolean result = mHideApps.get(pkg).booleanValue();
        return result;
    }

    @Override
    public void onRefresh(int updateCode, int[] ints, float[] flts, String[] strs) {
        switch (updateCode) {
            case 39:
                if (JTools.check(ints, 1) && JTools.check(strs, 1)) {
                    String pkg = strs[0];
                    boolean changed = false;
                    boolean has = mHideApps.containsKey(pkg);
                    if (ints[0] == 1 && has) {
                        mHideApps.remove(pkg);
                        changed = true;
                    } else if (ints[0] != 1 && !has) {
                        mHideApps.put(pkg, false);
                        changed = true;
                    }
                    if (changed && this.mCallback != null && this.mHandler != null) {
                        this.mHandler.removeCallbacks(this);
                        this.mHandler.postDelayed(this, 150L);
                    }
                    if (changed && LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_all_disable)) {
                        LauncherApplication.appEnable(pkg, ints[0]);
                        break;
                    }
                }
                break;
        }
    }

    @Override
    public void run() {
        if (this.mCallback != null) {
            this.mCallback.onRefresh();
        }
    }

    @Override
    public void register() {
        if (this.workLooper == null) {
            HandlerThread work = new HandlerThread("app_visibility_handler");
            work.start();
            this.workLooper = work.getLooper();
        }
        this.mHandler = new Handler(this.workLooper);
        CarStates mStates = CarStates.getCar(LauncherApplication.sApp);
        mStates.getTools().addRefreshLisenter(0, this, 39);
    }

    @Override
    public void unregister() {
        if (this.workLooper != null) {
            this.workLooper.quit();
            this.mHandler = null;
        }
        CarStates mStates = CarStates.getCar(LauncherApplication.sApp);
        mStates.getTools().removeRefreshLisenter(0, this);
    }

    public void setCallback(RefreshCallback mCallback) {
        this.mCallback = mCallback;
    }

    public static boolean loadCustomIcons(Context context, int res) {
        return false;
    }

    @Override
    public String getAppTitle(ComponentName app) {
        return null;
    }
}
