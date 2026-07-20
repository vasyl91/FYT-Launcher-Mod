package com.android.launcher66;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;

public final class ServiceIntentGate {
    private static final String TAG = "ServiceIntentGate";
    private static final String ACTION_NOOP = "com.android.launcher66.action.NOOP_SERVICE";

    private ServiceIntentGate() {}

    public static boolean hasService(Context context, Intent intent) {
        if (context == null || intent == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        return packageManager != null && packageManager.resolveService(intent, 0) != null;
    }

    public static boolean startIfAvailable(Context context, Intent intent, String label) {
        if (!hasService(context, intent)) {
            Log.d(TAG, "Skipping unavailable service: " + label + " " + intent);
            return false;
        }
        try {
            return context.startService(intent) != null;
        } catch (Throwable t) {
            Log.w(TAG, "Failed to start service: " + label + " " + intent, t);
            return false;
        }
    }

    public static PendingIntent getServiceOrNoop(
            Context context,
            int requestCode,
            Intent intent,
            int flags
    ) {
        if (hasService(context, intent)) {
            return PendingIntent.getService(context, requestCode, intent, flags);
        }
        Intent noop = new Intent(ACTION_NOOP);
        if (context != null) {
            noop.setPackage(context.getPackageName());
        }
        return PendingIntent.getBroadcast(context, requestCode, noop, flags);
    }
}
