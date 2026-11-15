package com.android.launcher66;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.util.Log;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.FytCompat;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Looks, once at a start, whether the hidden parts of Android the launcher reaches by name are still there,
 * and writes a report when one is not.
 *
 * <p>The launcher uses classes and methods that are no part of Android's public API: the pane view of
 * Android 8 to 10, the monitor of the touches, the listener of the task stack, the system's properties and
 * services. A new Android version or another firmware can drop or rename one, and the feature that needs it
 * then stops without a word: its lookup fails where it is used, which is logged at best.
 *
 * <p>The rule: every lookup the launcher itself makes by name as the system has a line in {@link #CHECKS},
 * with the Android versions it is made on. A line names what the code looks up, not what could be there
 * instead, so a member that is reported as missing is one a feature will not find. A lookup that has a
 * second way when the first fails has no line: its failure alone breaks nothing. The look is taken only
 * where the launcher runs as the system: an ordinary app is kept from these members by Android itself, and
 * the standard version reaches them through its host, in another process. One report is written per change
 * of what is missing (the report of the compat fuse, {@code compat_pid_<time>.txt}), not one per start.
 * The checking itself is pure Java and has a test.
 */
public final class HiddenApiProbe {

    private static final String TAG = "HiddenApiProbe";
    private static final String KEY_REPORTED = "hidden_api_probe_reported";
    private static final int ANY = Integer.MAX_VALUE;

    /** One lookup the launcher makes: a class, or a method of it by name. */
    static final class Check {
        final String feature;
        final String className;
        /** null for the class alone */
        final String method;
        final int minSdk;
        final int maxSdk;

        Check(String feature, String className, String method, int minSdk, int maxSdk) {
            this.feature = feature;
            this.className = className;
            this.method = method;
            this.minSdk = minSdk;
            this.maxSdk = maxSdk;
        }

        boolean dueOn(int sdk) {
            return sdk >= minSdk && sdk <= maxSdk;
        }

        String describe() {
            return feature + ": " + className + (method != null ? "#" + method : "");
        }
    }

    /** How a class or a method is looked for; the real one reflects, the test's answers from a list. */
    interface Lookup {
        boolean classExists(String className);

        boolean methodExists(String className, String method);
    }

    static final Check[] CHECKS = {
            new Check("system properties", "android.os.SystemProperties", "get", 26, ANY),
            new Check("system services", "android.os.ServiceManager", "getService", 26, ANY),
            new Check("PiP panes of Android 8-10", "android.app.ActivityView", null, 26, 29),
            new Check("PiP panes of Android 8-10", "android.app.ActivityView$StateCallback", null, 26, 29),
            new Check("touch monitor", "android.hardware.input.InputManager", "getInstance", 29, ANY),
            new Check("touch monitor", "android.hardware.input.InputManager", "monitorGestureInput", 29, ANY),
            // Its service is looked up in two places, one after the other, so only the listener is a line
            new Check("task stack listener", "android.app.ITaskStackListener", null, 26, ANY),
    };

    private HiddenApiProbe() {
    }

    /** The lines of {@code checks} that are due on this Android version and not found. */
    static List<String> missing(Check[] checks, int sdk, Lookup lookup) {
        List<String> missing = new ArrayList<>();
        for (Check check : checks) {
            if (!check.dueOn(sdk)) {
                continue;
            }
            boolean found = check.method == null ? lookup.classExists(check.className)
                    : lookup.classExists(check.className) && lookup.methodExists(check.className, check.method);
            if (!found) {
                missing.add(check.describe());
            }
        }
        return missing;
    }

    /** Whether a report is due: something is missing, and it is not what was reported last. */
    static boolean reportDue(String signature, String reportedBefore) {
        return !signature.isEmpty() && !signature.equals(reportedBefore);
    }

    private static final Lookup REFLECTION = new Lookup() {
        @Override
        public boolean classExists(String className) {
            try {
                Class.forName(className);
                return true;
            } catch (Throwable t) {
                return false;
            }
        }

        @Override
        public boolean methodExists(String className, String method) {
            try {
                for (Method m : Class.forName(className).getMethods()) {
                    if (m.getName().equals(method)) {
                        return true;
                    }
                }
                for (Method m : Class.forName(className).getDeclaredMethods()) {
                    if (m.getName().equals(method)) {
                        return true;
                    }
                }
            } catch (Throwable t) {
                return false;
            }
            return false;
        }
    };

    /** Takes the look and writes the report if one is due. Reads classes and preferences: off the main thread. */
    static void run(LauncherApplication app) {
        if (Process.myUid() != Process.SYSTEM_UID) {
            return;
        }
        try {
            List<String> missing = missing(CHECKS, Build.VERSION.SDK_INT, REFLECTION);
            String signature = missing.isEmpty() ? "" : Build.VERSION.SDK_INT + ":" + missing;
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(app);
            String before = prefs.getString(KEY_REPORTED, "");
            if (reportDue(signature, before)) {
                Log.w(TAG, "Hidden parts of Android the launcher uses are missing: " + missing);
                FytCompat.report("hidden_api", new NoSuchMethodException(
                        "Missing on Android API " + Build.VERSION.SDK_INT + ": " + missing));
            }
            if (!signature.equals(before)) {
                prefs.edit().putString(KEY_REPORTED, signature).apply();
            }
        } catch (Throwable t) {
            Log.w(TAG, "The look at the hidden parts failed: " + t);
        }
    }
}
