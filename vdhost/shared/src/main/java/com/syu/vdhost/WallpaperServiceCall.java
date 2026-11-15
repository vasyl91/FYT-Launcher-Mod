package com.syu.vdhost;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import android.util.Log;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Asks the system's wallpaper service for the picture of the home screen's wallpaper, as the host itself.
 *
 * <p>The host that runs as shell (Shizuku) cannot open the wallpaper's file: it belongs to the system. The
 * wallpaper service hands the same picture out to a caller it trusts, and shell may be one. Whether it is on
 * a given Android version is the service's to say: a refusal is an answer like any other, the host then
 * gives nothing and the launcher goes on to its next way (the wallpaper's colours and the picker).
 *
 * <p>The call is {@code IWallpaperManager.getWallpaperWithFeature} (before Android 11:
 * {@code getWallpaper}), and its parameters changed from version to version. They are therefore filled by
 * their types and their order, not by a list per version ({@link #arguments}):
 * <ul>
 * <li>the first String is the calling package, any later String (the attribution tag) is null;</li>
 * <li>the first int is which wallpaper (the home screen's, never the lock screen's), the second the user;</li>
 * <li>a boolean (the cropped picture, as it is shown) is true;</li>
 * <li>a Bundle is a new one, for the service to write into;</li>
 * <li>any other reference (the callback) is null.</li>
 * </ul>
 * A parameter of a kind not listed means a signature this code does not know: no call is made.
 */
final class WallpaperServiceCall {

    private static final String TAG = "VdHost";
    /** WallpaperManager.FLAG_SYSTEM. */
    static final int HOME_SCREEN = 1;

    private WallpaperServiceCall() {
    }

    /**
     * @param types   the parameter types of the service's method
     * @param pkg     the package the host runs as
     * @param userId  the user whose wallpaper is asked for
     * @param bundle  what to pass for a Bundle parameter
     * @return the arguments, or null for a signature that is not known
     */
    static Object[] arguments(Class<?>[] types, String pkg, int userId, Object bundle) {
        Object[] args = new Object[types.length];
        int strings = 0;
        int ints = 0;
        for (int i = 0; i < types.length; i++) {
            Class<?> type = types[i];
            if (type == String.class) {
                args[i] = strings++ == 0 ? pkg : null;
            } else if (type == int.class) {
                if (ints == 0) {
                    args[i] = HOME_SCREEN;
                } else if (ints == 1) {
                    args[i] = userId;
                } else {
                    return null;
                }
                ints++;
            } else if (type == boolean.class) {
                args[i] = Boolean.TRUE;
            } else if (type.isPrimitive()) {
                return null;
            } else if ("android.os.Bundle".equals(type.getName())) {
                args[i] = bundle;
            } else {
                args[i] = null;
            }
        }
        // Without a package or without "which" it is not the call this code means
        return strings >= 1 && ints >= 2 ? args : null;
    }

    /** The service's method that gives the picture: the newer name first. */
    static Method method(Class<?> service) {
        Method older = null;
        for (Method method : service.getMethods()) {
            if (method.getReturnType() != ParcelFileDescriptor.class) {
                continue;
            }
            if ("getWallpaperWithFeature".equals(method.getName())) {
                return method;
            }
            if ("getWallpaper".equals(method.getName())) {
                older = method;
            }
        }
        return older;
    }

    /**
     * @param pkg    the package the host runs as
     * @param userId the user whose wallpaper is asked for
     * @return the picture's file, or null: refused, no picture set, or a service this code does not know
     */
    static ParcelFileDescriptor read(String pkg, int userId) {
        ParcelFileDescriptor file = null;
        try {
            Object service = Hidden.getService("wallpaper", "android.app.IWallpaperManager");
            Method method = method(service.getClass());
            if (method == null) {
                Log.i(TAG, "readHomeWallpaper: wallpaper service has no call for the picture");
                return null;
            }
            Object[] args = arguments(method.getParameterTypes(), pkg, userId, new Bundle());
            if (args == null) {
                Log.i(TAG, "readHomeWallpaper: wallpaper service call not known: " + method);
                return null;
            }
            file = (ParcelFileDescriptor) method.invoke(service, args);
            if (file == null) {
                Log.i(TAG, "readHomeWallpaper: wallpaper service gave no picture (none set, or a live wallpaper)");
                return null;
            }
            StructStat stat = Os.fstat(file.getFileDescriptor());
            if (!OsConstants.S_ISREG(stat.st_mode) || stat.st_size <= 0
                    || stat.st_size > HostFilePolicy.WALLPAPER_MAX_BYTES) {
                Log.i(TAG, "readHomeWallpaper: wallpaper service's file not used (size=" + stat.st_size + ")");
                file.close();
                return null;
            }
            Log.i(TAG, "readHomeWallpaper: wallpaper service gave the picture (" + stat.st_size + " bytes)");
            ParcelFileDescriptor result = file;
            file = null;
            return result;
        } catch (InvocationTargetException e) {
            // A SecurityException here is the service's answer: this caller may not have the picture
            Log.i(TAG, "readHomeWallpaper: wallpaper service refused: " + e.getCause());
            return null;
        } catch (ReflectiveOperationException | RuntimeException | ErrnoException | IOException e) {
            Log.w(TAG, "readHomeWallpaper: wallpaper service call failed: " + e);
            return null;
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException ignored) {
                    // already refused
                }
            }
        }
    }
}
