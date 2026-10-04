package com.android.launcher66;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Keeps the start restrictions of the Unisoc (Spreadtrum) power manager in line with the
 * launcher's autostart list.
 *
 * <p>Unisoc's PowerController keeps per-app settings for "autolaunch" (an app is started for a
 * broadcast or a service binding) and "secondary launch" (an app is started by another app). With
 * VALUE_OPTIMIZE an app is on the matching black list after every boot, and every start of it that
 * the user did not trigger is denied ("in autolaunch black list: ... denyed!" in logcat):
 * notification listener bindings, services started by other apps, broadcasts such as the WAKE
 * broadcast of Display Media Titles. Only activities the user starts still work. The FYT unit has
 * such settings, e.g. for com.syu.widget.music.
 *
 * <p>Apps on the autostart list are set to VALUE_NO_OPTIMIZE (not restricted). For every setting
 * this class changes, the value it had before is stored, and when the app leaves the list (unticked
 * or uninstalled) exactly that value is restored: VALUE_OPTIMIZE for an app that was restricted,
 * VALUE_AUTO for one the system manages by itself. A setting that was not restricted already is
 * neither changed nor restored, and a setting someone else changed meanwhile is left alone. Removing
 * an app from the list therefore never leaves it more restricted than the system had it.
 *
 * <p>The launcher runs with the system UID, which may change these settings for any app (hidden
 * vendor service "power_ex", reached by reflection). The system persists them. Without this power
 * manager create() returns null.
 */
public final class UnisocPowerWhitelist {

    private static final String TAG = "UnisocPower";
    private static final String SERVICE = "power_ex";
    private static final String CONFIG_CLASS = "android.os.sprdpower.AppPowerSaveConfig";

    /** Settings to lift, with their values from the Unisoc sources as fallback. */
    private static final String[] TYPE_NAMES = {"TYPE_AUTOLAUNCH", "TYPE_SECONDARYLAUNCH"};
    private static final int[] FALLBACK_TYPES = {4, 5};
    private static final int FALLBACK_NO_OPTIMIZE = 2;

    /**
     * Stored per app this class changed: key prefix + package name, value
     * "TYPE_AUTOLAUNCH=1,TYPE_SECONDARYLAUNCH=0" (the values before the change, by setting name).
     */
    static final String ORIGINAL_PREFIX = "unisoc_original:";

    private final Object manager;
    private final Method setter;
    private final Method getter; // null if the service has none: nothing is recorded then
    private final int noOptimize;
    private final int[] types;

    private UnisocPowerWhitelist(Object manager, Method setter, Method getter, int noOptimize, int[] types) {
        this.manager = manager;
        this.setter = setter;
        this.getter = getter;
        this.noOptimize = noOptimize;
        this.types = types;
    }

    /**
     * The power manager of this device, or null if it has none (not a Unisoc device) or its per-app
     * settings cannot be changed. Reflection and a service lookup: call it off the main thread.
     */
    public static UnisocPowerWhitelist create(Context context) {
        return forManager(powerManagerEx(context));
    }

    /** For a PowerManagerEx (or IPowerManagerEx) instance; package-private for tests. */
    static UnisocPowerWhitelist forManager(Object manager) {
        if (manager == null) {
            return null;
        }
        Method setter = null;
        Method getter = null;
        for (Method method : manager.getClass().getMethods()) {
            if (matches(method, "setAppPowerSaveConf", String.class, int.class, int.class)) {
                setter = method;
            } else if (matches(method, "getAppPowerSaveConf", String.class, int.class)) {
                getter = method;
            }
        }
        if (setter == null) {
            Log.i(TAG, "power_ex has no per-app setter; nothing is changed");
            return null;
        }
        int[] types = new int[TYPE_NAMES.length];
        for (int i = 0; i < TYPE_NAMES.length; i++) {
            types[i] = configType(TYPE_NAMES[i], FALLBACK_TYPES[i]);
        }
        return new UnisocPowerWhitelist(manager, setter, getter,
                intConstant("VALUE_NO_OPTIMIZE", FALLBACK_NO_OPTIMIZE), types);
    }

    /**
     * Brings the settings in line with selected, the installed apps of the autostart list: those
     * are not restricted, and apps that left the list get their original values back. store keeps
     * the original values. Blocking binder calls: call it off the main thread.
     */
    public void sync(SharedPreferences store, Collection<String> selected) {
        SharedPreferences.Editor editor = store.edit();
        for (String pkg : selected) {
            allow(store, editor, pkg);
        }
        for (String key : store.getAll().keySet()) {
            if (key.startsWith(ORIGINAL_PREFIX)) {
                String pkg = key.substring(ORIGINAL_PREFIX.length());
                // Kept when a restore failed, so the next sync tries again.
                if (!selected.contains(pkg) && restore(pkg, parseOriginals(store.getString(key, "")))) {
                    editor.remove(key);
                }
            }
        }
        editor.apply();
    }

    /** Not restricted; the value a setting had is recorded when this class changes it first. */
    private void allow(SharedPreferences store, SharedPreferences.Editor editor, String pkg) {
        Map<String, Integer> originals = parseOriginals(store.getString(ORIGINAL_PREFIX + pkg, ""));
        boolean recorded = false;
        for (int i = 0; i < types.length; i++) {
            Integer current = get(pkg, types[i]);
            if (current != null && current == noOptimize) {
                continue; // not restricted already: by the system, by the user or by an earlier sync
            }
            if (!set(pkg, types[i], noOptimize)) {
                continue;
            }
            Log.i(TAG, TYPE_NAMES[i] + " of " + pkg + ": " + current + " -> " + noOptimize + " (not restricted)");
            // An unknown original (no getter) is not recorded, so it is never restored either.
            if (current != null && !originals.containsKey(TYPE_NAMES[i])) {
                originals.put(TYPE_NAMES[i], current);
                recorded = true;
            }
        }
        if (recorded) {
            editor.putString(ORIGINAL_PREFIX + pkg, formatOriginals(originals));
        }
    }

    /**
     * The original values back, for every setting that still has the value this class set.
     * False if a setting could not be written back.
     */
    private boolean restore(String pkg, Map<String, Integer> originals) {
        boolean done = true;
        for (int i = 0; i < types.length; i++) {
            Integer original = originals.get(TYPE_NAMES[i]);
            if (original == null) {
                continue; // not changed by this class
            }
            Integer current = get(pkg, types[i]);
            if (current == null || current != noOptimize) {
                // Changed by someone else meanwhile, or gone with the uninstalled app: left alone.
                continue;
            }
            if (set(pkg, types[i], original)) {
                Log.i(TAG, TYPE_NAMES[i] + " of " + pkg + ": " + current + " -> " + original + " (restored)");
            } else {
                done = false;
            }
        }
        return done;
    }

    private Integer get(String pkg, int type) {
        if (getter == null) {
            return null;
        }
        try {
            Object value = getter.invoke(manager, pkg, type);
            return value instanceof Integer ? (Integer) value : null;
        } catch (ReflectiveOperationException | RuntimeException e) {
            Log.w(TAG, "Cannot read setting " + type + " of " + pkg, e);
            return null;
        }
    }

    private boolean set(String pkg, int type, int value) {
        try {
            setter.invoke(manager, pkg, type, value);
            return true;
        } catch (ReflectiveOperationException | RuntimeException e) {
            // InvocationTargetException wraps e.g. a SecurityException of the service
            Log.w(TAG, "Cannot change setting " + type + " of " + pkg, e);
            return false;
        }
    }

    /** "TYPE_AUTOLAUNCH=1,TYPE_SECONDARYLAUNCH=0" -> {TYPE_AUTOLAUNCH=1, TYPE_SECONDARYLAUNCH=0}. */
    static Map<String, Integer> parseOriginals(String raw) {
        Map<String, Integer> out = new LinkedHashMap<>();
        if (raw == null || raw.isEmpty()) {
            return out;
        }
        for (String part : raw.split(",")) {
            int eq = part.indexOf('=');
            if (eq <= 0) {
                continue;
            }
            try {
                out.put(part.substring(0, eq).trim(), Integer.parseInt(part.substring(eq + 1).trim()));
            } catch (NumberFormatException ignored) {
                // a damaged entry is skipped
            }
        }
        return out;
    }

    /** The inverse of {@link #parseOriginals}. */
    static String formatOriginals(Map<String, Integer> originals) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : originals.entrySet()) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            sb.append(entry.getKey()).append('=').append(entry.getValue());
        }
        return sb.toString();
    }

    /** setAppPowerSaveConfigWithType / getAppPowerSaveConfgWithType (the vendor sources contain typos). */
    private static boolean matches(Method method, String prefix, Class<?>... params) {
        String name = method.getName();
        return name.startsWith(prefix) && name.endsWith("WithType")
                && Arrays.equals(method.getParameterTypes(), params);
    }

    private static Object powerManagerEx(Context context) {
        try {
            Object manager = context.getSystemService(SERVICE);
            if (manager != null) {
                return manager;
            }
            IBinder binder = (IBinder) Class.forName("android.os.ServiceManager")
                    .getMethod("getService", String.class)
                    .invoke(null, SERVICE);
            if (binder == null) {
                return null;
            }
            return Class.forName("android.os.sprdpower.IPowerManagerEx$Stub")
                    .getMethod("asInterface", IBinder.class)
                    .invoke(null, binder);
        } catch (ReflectiveOperationException | RuntimeException | LinkageError e) {
            return null; // not a Unisoc device
        }
    }

    private static int intConstant(String field, int fallback) {
        try {
            return Class.forName(CONFIG_CLASS).getField(field).getInt(null);
        } catch (ReflectiveOperationException | RuntimeException | LinkageError e) {
            return fallback;
        }
    }

    /** Numeric value of AppPowerSaveConfig.ConfigType.name, or fallback if it cannot be read. */
    private static int configType(String name, int fallback) {
        try {
            Class<?> enumClass = Class.forName(CONFIG_CLASS + "$ConfigType");
            Object[] constants = enumClass.getEnumConstants();
            if (constants == null) {
                return fallback;
            }
            for (Object constant : constants) {
                if (!((Enum<?>) constant).name().equals(name)) {
                    continue;
                }
                try {
                    return (Integer) enumClass.getMethod("getValue").invoke(constant);
                } catch (ReflectiveOperationException | RuntimeException ignored) {
                    // no getter: read the field
                }
                for (String fieldName : new String[] {"value", "mValue"}) {
                    try {
                        Field field = enumClass.getDeclaredField(fieldName);
                        field.setAccessible(true);
                        return field.getInt(constant);
                    } catch (ReflectiveOperationException | RuntimeException ignored) {
                        // try the next name
                    }
                }
            }
        } catch (ReflectiveOperationException | RuntimeException | LinkageError e) {
            // not readable: fallback
        }
        return fallback;
    }
}
