package com.syu.utils;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.view.View;
import androidx.core.app.ActivityOptionsCompat;
import com.syu.library.R;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ActivityUtils {

    public static class StartArg {
        public StartArg(Context context, View view, Bitmap bitmap) {
        }
    }

    public static boolean isInstalled(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationContext().getPackageManager().getApplicationInfo(str, 0);
            return applicationInfo != null && applicationInfo.packageName.equals(str) && applicationInfo.enabled;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean startActivitySafely(Context context, Intent intent, int... iArr) {
        if (context == null || intent == null) {
            return false;
        }
        if (iArr == null || iArr.length <= 0) {
            intent.addFlags(270532608);
        } else {
            for (int i : iArr) {
                intent.addFlags(i);
            }
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException | Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean startActivitySafelyForAction(Context context, String str, String str2, int... iArr) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        Intent intent = new Intent(str);
        if (str2 != null && str2.length() > 0) {
            intent.setPackage(str2);
        }
        return startActivitySafely(context, intent, new int[0]);
    }

    public static boolean startActivitySafelyForComponentName(Context context, String str, String str2, int... iArr) {
        boolean z = str != null && str.length() > 0;
        boolean z2 = str2 != null && str2.length() > 0;
        if (!z || !z2) {
            return false;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str2, str));
        return startActivitySafely(context, intent, new int[0]);
    }

    public static boolean startActivitySafely(Context context, String str, int... iArr) {
        Intent launchIntentForPackage;
        if (context == null || (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str)) == null) {
            return false;
        }
        if (iArr == null || iArr.length <= 0) {
            launchIntentForPackage.addFlags(270532608);
        } else {
            for (int i : iArr) {
                launchIntentForPackage.addFlags(i);
            }
        }
        try {
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (ActivityNotFoundException | Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean startActivitySafely(View view, Intent intent, int... iArr) {
        if (view == null || intent == null) {
            return false;
        }
        if (iArr == null || iArr.length <= 0) {
            intent.addFlags(270532608);
        } else {
            for (int i : iArr) {
                intent.addFlags(i);
            }
        }
        try {
            int width = view.getWidth() / 2;
            int height = view.getHeight() / 2;
            view.getContext().startActivity(intent, ActivityOptionsCompat.makeCustomAnimation(view.getContext(), R.anim.enter_scale, R.anim.exit_scale).toBundle());
            return true;
        } catch (ActivityNotFoundException | Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
