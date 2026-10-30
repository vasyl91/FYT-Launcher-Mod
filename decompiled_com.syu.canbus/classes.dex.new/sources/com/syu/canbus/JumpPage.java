package com.syu.canbus;

import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class JumpPage {
    public static void startActivity(String packageName, String ActivityName) {
        ComponentName componetName = new ComponentName(packageName, ActivityName);
        try {
            Intent intent = new Intent();
            intent.setComponent(componetName);
            defIntentSetForStartActivity(intent);
            TheApp.getInstance().startActivity(intent);
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
