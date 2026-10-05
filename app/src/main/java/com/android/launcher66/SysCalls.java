package com.android.launcher66;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.os.UserHandle;
import android.util.Log;

import java.lang.reflect.Method;

/**
 * sendBroadcast() / startService() / stopService() with the user named, for the system uid.
 *
 * Running as the system uid, every call without a user makes ContextImpl log "Calling a method in
 * the system process without a qualified user", with a stack walk (Debug.getCallers) for each --
 * hundreds a minute in the captures. The *AsUser variants with this process's own user (user 0 on
 * a head unit) do the same thing without that. Any other uid uses the plain calls.
 */
public final class SysCalls {

    private static final String TAG = "SysCalls";
    private static final boolean SYSTEM_UID = Process.myUid() == Process.SYSTEM_UID;
    private static final UserHandle USER = Process.myUserHandle();

    // Hidden in the SDK, present on every Android version this runs on.
    private static volatile Method sStartServiceAsUser;
    private static volatile Method sStopServiceAsUser;
    private static volatile boolean sResolved;

    private SysCalls() {
    }

    public static void sendBroadcast(Context context, Intent intent) {
        if (SYSTEM_UID) {
            context.sendBroadcastAsUser(intent, USER);
        } else {
            context.sendBroadcast(intent);
        }
    }

    public static ComponentName startService(Context context, Intent intent) {
        if (SYSTEM_UID) {
            resolve();
            Method m = sStartServiceAsUser;
            if (m != null) {
                try {
                    return (ComponentName) m.invoke(context, intent, USER);
                } catch (java.lang.reflect.InvocationTargetException e) {
                    throwCause(e);
                } catch (Throwable t) {
                    Log.w(TAG, "startServiceAsUser failed, using startService: " + t);
                }
            }
        }
        return context.startService(intent);
    }

    public static boolean stopService(Context context, Intent intent) {
        if (SYSTEM_UID) {
            resolve();
            Method m = sStopServiceAsUser;
            if (m != null) {
                try {
                    return (Boolean) m.invoke(context, intent, USER);
                } catch (java.lang.reflect.InvocationTargetException e) {
                    throwCause(e);
                } catch (Throwable t) {
                    Log.w(TAG, "stopServiceAsUser failed, using stopService: " + t);
                }
            }
        }
        return context.stopService(intent);
    }

    private static void resolve() {
        if (sResolved) {
            return;
        }
        try {
            sStartServiceAsUser = Context.class.getMethod("startServiceAsUser", Intent.class, UserHandle.class);
        } catch (Throwable ignored) {
        }
        try {
            sStopServiceAsUser = Context.class.getMethod("stopServiceAsUser", Intent.class, UserHandle.class);
        } catch (Throwable ignored) {
        }
        sResolved = true;
    }

    /** The service call's own exception (IllegalStateException, SecurityException) reaches the caller as before. */
    private static void throwCause(java.lang.reflect.InvocationTargetException e) {
        Throwable cause = e.getCause();
        if (cause instanceof RuntimeException) {
            throw (RuntimeException) cause;
        }
        if (cause instanceof Error) {
            throw (Error) cause;
        }
        throw new RuntimeException(cause);
    }
}
