package com.syu.util;

import android.app.ActivityOptions;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.view.View;
import android.widget.Toast;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.syu.ipc.ModuleObject;
import com.syu.ipc.RemoteModuleProxy;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class ActivityStartUtils {
    public static boolean startActivitySafely(Context context, View v, Intent intent, Object tag) {
        if (intent == null) {
            Toast.makeText(context, "2131492876intent= null", Toast.LENGTH_SHORT).show();
            return false;
        }
        boolean success = false;
        try {
            success = startActivity(context, v, intent, tag);
            if (!success) {
                Toast.makeText(context, "2131492876:success", Toast.LENGTH_SHORT).show();
                return success;
            }
            return success;
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, "2131492876-ActivityNotFound", Toast.LENGTH_SHORT).show();
            JLog.getInstance().e("Unable to launch. tag=" + tag + " intent=" + intent);
            return success;
        }
    }

    static boolean startActivity(Context context, View v, Intent intent, Object tag) {
        try {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            boolean useLaunchAnimation = (v == null || intent.hasExtra("com.android.launcher66.intent.extra.shortcut.INGORE_LAUNCH_ANIMATION")) ? false : true;
            if (useLaunchAnimation) {
                ActivityOptions opts = ActivityOptions.makeScaleUpAnimation(v, 0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
                context.startActivity(intent, opts.toBundle());
                return true;
            }
            context.startActivity(intent);
            return true;
        } catch (SecurityException e) {
            Toast.makeText(context, "2131492876---startActivity", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    static void startNavi(Context context, View v, Intent intent, Object tag) {
        RemoteModuleProxy proxy = new RemoteModuleProxy();
        LauncherApplication launcherApplication = LauncherApplication.sApp;
        try {
            ModuleObject pkg = proxy.getRemoteModule().get(0, null, null, null);
            if (pkg == null || pkg.strs == null) {
                Toast.makeText(context, R.string.activity_not_found, Toast.LENGTH_SHORT).show();
            }
        } catch (RemoteException e) {
            Toast.makeText(context, R.string.activity_not_found, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
