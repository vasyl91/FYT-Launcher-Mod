package com.syu.canbus;

import android.content.ComponentName;
import android.content.Intent;

import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class JumpPage {
    public static void startActivity(String packageName, String ActivityName) {
        ComponentName componetName = new ComponentName(packageName, ActivityName);
        try {
            Intent intent = new Intent();
            intent.setComponent(componetName);
            defIntentSetForStartActivity(intent);
            LauncherApplication.getInstance().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void defIntentSetForStartActivity(Intent intent) {
        intent.addFlags(131072);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        intent.addFlags(16777216);
        intent.addFlags(268435456);
    }
}
