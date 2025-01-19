package com.syu.canbus;

import android.content.ComponentName;
import android.content.Intent;

import com.android.launcher66.LauncherApplication;

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
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }
}
