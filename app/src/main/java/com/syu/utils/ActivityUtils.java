package com.syu.utils;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class ActivityUtils {
    public static boolean startActivitySafely(@NonNull Context context, Intent intent, int... flags) {
        if (context == null || intent == null) {
            return false;
        }
        if (flags != null && flags.length > 0) {
            for (int flag : flags) {
                intent.addFlags(flag);
            }
        } else {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean startActivitySafelyForAction(@NonNull Context context, String action, String pkg, int... flags) {
        if (action == null || action.length() <= 0) {
            return false;
        }
        Intent intent = new Intent(action);
        if (pkg != null && pkg.length() > 0) {
            intent.setPackage(pkg);
        }
        boolean success = startActivitySafely(context, intent, new int[0]);
        return success;
    }

    public static boolean startActivitySafelyForComponentName(@NonNull Context context, String clazz, String pkg, int... flags) {
        boolean hasClazz = clazz != null && clazz.length() > 0;
        boolean hasPkg = pkg != null && pkg.length() > 0;
        if (!hasClazz || !hasPkg) {
            return false;
        }
        Intent intent = new Intent();
        ComponentName c = new ComponentName(pkg, clazz);
        intent.setComponent(c);
        boolean success = startActivitySafely(context, intent, new int[0]);
        return success;
    }
}
