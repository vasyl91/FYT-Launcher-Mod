package com.android.launcher66;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import com.android.launcher66.settings.StateAccessibilityService;

import java.lang.reflect.Method;

/**
 * Opens the notification shade of the system from the home screen ("Swipe down for notifications").
 *
 * <p>Two ways, the first that works is used and logged: the status bar service's {@code expandNotificationsPanel()} (a
 * method of the platform that apps may call with the normal permission {@code EXPAND_STATUS_BAR}; it is not in the
 * SDK, so it is looked up by name and may be refused on a newer Android), and, where the launcher's accessibility
 * service is on, the system's own global action for the shade. On an FYT unit the framework shows its panel of quick
 * settings instead of notifications, which it keeps blocked. Main thread.
 */
final class StatusBarPanel {

    private static final String TAG = "StatusBarPanel";

    private StatusBarPanel() {
    }

    /** Opens the shade; whether one of the ways worked. */
    static boolean expand(Context context) {
        try {
            Object service = context.getSystemService("statusbar");
            if (service != null) {
                String method = Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1
                        ? "expandNotificationsPanel" : "expand";
                Method expand = Class.forName("android.app.StatusBarManager").getMethod(method);
                expand.invoke(service);
                Log.i(TAG, "Home swipe down: the shade opened through StatusBarManager." + method + "()");
                return true;
            }
        } catch (Throwable t) {
            Log.w(TAG, "StatusBarManager did not open the shade: " + t);
        }
        if (StateAccessibilityService.perform(
                android.accessibilityservice.AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS)) {
            Log.i(TAG, "Home swipe down: the shade opened through the accessibility service");
            return true;
        }
        Log.w(TAG, "Home swipe down: no way to open the shade (no StatusBarManager, no accessibility service)");
        return false;
    }
}
