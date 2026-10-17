package com.android.launcher66;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Which widgets have their content fitted to their cells (LauncherAppWidgetHostView), by
 * appWidgetId. A file of its own: the default preferences are read at every start.
 */
final class WidgetFit {

    private static final String PREFS = "widget_fit";

    private WidgetFit() {
    }

    private static SharedPreferences prefs(Context context) {
        return context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    private static String key(int appWidgetId) {
        return "fit_" + appWidgetId;
    }

    static boolean isOn(Context context, int appWidgetId) {
        return appWidgetId > 0 && prefs(context).getBoolean(key(appWidgetId), false);
    }

    static void set(Context context, int appWidgetId, boolean on) {
        if (appWidgetId <= 0) return;
        SharedPreferences.Editor editor = prefs(context).edit();
        if (on) {
            editor.putBoolean(key(appWidgetId), true);
        } else {
            editor.remove(key(appWidgetId));
        }
        editor.apply();
    }

    /** The widget is gone: so is its setting. */
    static void forget(Context context, int appWidgetId) {
        set(context, appWidgetId, false);
    }
}
