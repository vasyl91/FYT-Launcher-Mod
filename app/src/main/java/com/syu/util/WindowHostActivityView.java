package com.syu.util;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class WindowHostActivityView {
    private static final String TAG = "WindowHostActivityView";
    private static Class<?> sActivityView, sStateCb;

    static void ensureLoaded() {
        if (sActivityView != null) return;
        try { sActivityView = Class.forName("android.app.ActivityView"); }
        catch (Throwable e) { throw new RuntimeException("ActivityView not available", e); }
        try { sStateCb = Class.forName("android.app.ActivityView$StateCallback"); }
        catch (Throwable ignore) { sStateCb = null; }
    }

    static Object newInstance(Context ctx) {
        ensureLoaded();
        try {
            try {
                Constructor<?> c = sActivityView.getDeclaredConstructor(Context.class, boolean.class);
                c.setAccessible(true);
                return c.newInstance(ctx, Boolean.TRUE);
            } catch (Throwable ignore) {}
            for (Constructor<?> c : sActivityView.getDeclaredConstructors()) {
                try {
                    Class<?>[] p = c.getParameterTypes();
                    c.setAccessible(true);
                    if (p.length == 1 && p[0] == Context.class) return c.newInstance(ctx);
                    if (p.length == 2 && p[0] == Context.class && p[1] == android.util.AttributeSet.class) return c.newInstance(ctx, null);
                    if (p.length == 3 && p[0] == Context.class && p[1] == android.util.AttributeSet.class && p[2] == int.class) return c.newInstance(ctx, null, 0);
                    if (p.length == 4 && p[0] == Context.class && p[1] == android.util.AttributeSet.class && p[2] == int.class && p[3] == int.class) return c.newInstance(ctx, null, 0, 0);
                } catch (Throwable ignore) {}
            }
            throw new IllegalStateException("No compatible ActivityView constructor");
        } catch (Throwable e) {
            throw new RuntimeException("No compatible ActivityView constructor", e);
        }
    }

    static View asView(Object av) { return (View) av; }

    interface Callback {
        default void onReady() {}
        default void onDestroyed() {}
        default void onTaskCreated(int taskId) {}
    }

    static void trySetCallback(Object av, Callback cb) {
        if (sStateCb == null) return;
        try {
            Method setCb = sActivityView.getMethod("setCallback", sStateCb);
            Object proxy = null;
            if (sStateCb.isInterface()) {
                proxy = Proxy.newProxyInstance(sStateCb.getClassLoader(), new Class<?>[]{ sStateCb }, (p, m, a) -> {
                    String n = m.getName();
                    try {
                        if ("onActivityViewReady".equals(n)) cb.onReady();
                        else if ("onActivityViewDestroyed".equals(n)) cb.onDestroyed();
                        else if ("onTaskCreated".equals(n)) {
                            if (a != null && a.length > 0 && a[0] instanceof Integer) cb.onTaskCreated((Integer)a[0]);
                            else cb.onTaskCreated(0);
                        }
                    } catch (Throwable ignore) {}
                    return null;
                });
            } else if (!Modifier.isAbstract(sStateCb.getModifiers())) {
                proxy = sStateCb.getDeclaredConstructor().newInstance();
            }
            setCb.invoke(av, proxy);
        } catch (Throwable t) {
            Log.i(TAG, "ActivityView.setCallback failed/absent", t);
        }
    }

    static boolean startActivitySmart(Object av, Context ctx, Intent intent, Object opts) {
        PendingIntent pi = null;
        try { pi = buildPendingIntent(ctx, intent); } catch (Throwable ignore) {}

        Object bundle = null;
        if (opts instanceof ActivityOptions) {
            try { bundle = ((ActivityOptions) opts).toBundle(); } catch (Throwable ignore) {}
        }

        // Try each method and collect errors
        Exception lastException = null;

        if (pi != null && tryInvokeWithError(av, "startActivity", new Class[]{PendingIntent.class}, new Object[]{pi})) return true;
        if (pi != null && tryInvokeWithError(av, "startActivity", new Class[]{PendingIntent.class, Intent.class}, new Object[]{pi, intent})) return true;
        if (pi != null && opts instanceof ActivityOptions &&
                tryInvokeWithError(av, "startActivity", new Class[]{PendingIntent.class, Intent.class, ActivityOptions.class}, new Object[]{pi, intent, opts})) return true;
        if (pi != null && bundle != null &&
                tryInvokeWithError(av, "startActivity", new Class[]{PendingIntent.class, Intent.class, android.os.Bundle.class}, new Object[]{pi, intent, bundle})) return true;

        if (tryInvokeWithError(av, "startActivity", new Class[]{Intent.class}, new Object[]{intent})) return true;
        if (opts instanceof ActivityOptions &&
                tryInvokeWithError(av, "startActivity", new Class[]{Intent.class, ActivityOptions.class}, new Object[]{intent, opts})) return true;
        if (bundle != null &&
                tryInvokeWithError(av, "startActivity", new Class[]{Intent.class, android.os.Bundle.class}, new Object[]{intent, bundle})) return true;

        Method[] all = sActivityView.getMethods();
        for (Method m : all) {
            if (!"startActivity".equals(m.getName())) continue;
            Class<?>[] p = m.getParameterTypes();
            Object[] args = new Object[p.length];
            boolean ok = true;
            for (int i = 0; i < p.length; i++) {
                Class<?> t = p[i];
                if (t == Intent.class) args[i] = intent;
                else if (t == PendingIntent.class) args[i] = pi;
                else if (t == ActivityOptions.class && opts instanceof ActivityOptions) args[i] = opts;
                else if (t == android.os.Bundle.class && bundle != null) args[i] = bundle;
                else { ok = false; break; }
            }
            if (!ok) continue;
            try { 
                m.invoke(av, args); 
                Log.i(TAG, "WindowHostActivityView.startActivity via sweep: " + sig(m)); 
                return true; 
            }
            catch (InvocationTargetException ite) { 
                Throwable cause = ite.getCause();
                Log.w(TAG, "WindowHostActivityView.startActivity sweep ITE: " + sig(m) + " cause=" + (cause != null ? cause.getMessage() : "null"));
                lastException = ite;
            }
            catch (Throwable ex) { 
                Log.w(TAG, "WindowHostActivityView.startActivity sweep failed: " + sig(m) + " ex=" + ex); 
                if (lastException == null) lastException = (Exception) ex;
            }
        }
        Log.e(TAG, "WindowHostActivityView.startActivity failed for intent=" + intent + " opts=" + (opts!=null) + 
            (lastException != null ? " lastError=" + lastException.getMessage() : ""));
        return false;
    }

    private static boolean tryInvokeWithError(Object av, String name, Class<?>[] sig, Object[] args) {
        try {
            Method m = sActivityView.getMethod(name, sig);
            m.invoke(av, args);
            Log.i(TAG, "WindowHostActivityView.startActivity using " + name + Arrays.toString(sig));
            return true;
        } catch (InvocationTargetException ite) {
            Throwable cause = ite.getCause();
            Log.w(TAG, "ITE in " + name + Arrays.toString(sig) + ": " + (cause != null ? cause.getMessage() : "null"));
            return false;
        } catch (Throwable t) {
            return false;
        }
    }

    private static String sig(Method m) {
        StringBuilder sb = new StringBuilder(m.getName()).append('(');
        Class<?>[] p = m.getParameterTypes();
        for (int i=0;i<p.length;i++) { if (i>0) sb.append(','); sb.append(p[i].getSimpleName()); }
        sb.append(')');
        return sb.toString();
    }

    static void release(Object av) {
        try { sActivityView.getMethod("release").invoke(av); } catch (Throwable ignore) {}
    }

    static Object makeOptionsWithBounds(Rect b) {
        try {
            ActivityOptions o = ActivityOptions.makeBasic();
            if (b != null) o.setLaunchBounds(b);
            try {
                Method m = ActivityOptions.class.getMethod("setLaunchWindowingMode", int.class);
                m.invoke(o, 5 /*WINDOWING_MODE_FREEFORM*/);
            } catch (Throwable ignore) {}
            return o;
        } catch (Throwable t) { return null; }
    }

    private static PendingIntent buildPendingIntent(Context ctx, Intent intent) {
        int flags = 0;
        if (Build.VERSION.SDK_INT >= 23) flags |= PendingIntent.FLAG_UPDATE_CURRENT;
        if (Build.VERSION.SDK_INT >= 31) flags |= PendingIntent.FLAG_IMMUTABLE;
        try {
            return PendingIntent.getActivity(ctx, 0, intent, flags);
        } catch (Throwable t) {
            try {
                int f = flags & ~PendingIntent.FLAG_IMMUTABLE;
                if (Build.VERSION.SDK_INT >= 31) f |= PendingIntent.FLAG_MUTABLE;
                return PendingIntent.getActivity(ctx, 0, intent, f);
            } catch (Throwable t2) {
                throw t2 instanceof RuntimeException ? (RuntimeException) t2 : new RuntimeException(t2);
            }
        }
    }
}