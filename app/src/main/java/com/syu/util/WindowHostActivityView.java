package com.syu.util;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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
        // Always use compatibility flags for every app
        Intent compatIntent = createCompatibleIntent(ctx, intent);
        
        PendingIntent pi = null;
        try { pi = buildPendingIntent(ctx, compatIntent); } catch (Throwable ignore) {}

        Object bundle = null;
        if (opts instanceof ActivityOptions) {
            try { bundle = ((ActivityOptions) opts).toBundle(); } catch (Throwable ignore) {}
        }

        // Try each method and collect errors
        Exception lastException = null;

        if (pi != null && tryInvokeWithError(av, "startActivity", new Class[]{PendingIntent.class}, new Object[]{pi})) return true;
        if (pi != null && tryInvokeWithError(av, "startActivity", new Class[]{PendingIntent.class, Intent.class}, new Object[]{pi, compatIntent})) return true;
        if (pi != null && opts instanceof ActivityOptions &&
                tryInvokeWithError(av, "startActivity", new Class[]{PendingIntent.class, Intent.class, ActivityOptions.class}, new Object[]{pi, compatIntent, opts})) return true;
        if (pi != null && bundle != null &&
                tryInvokeWithError(av, "startActivity", new Class[]{PendingIntent.class, Intent.class, android.os.Bundle.class}, new Object[]{pi, compatIntent, bundle})) return true;

        if (tryInvokeWithError(av, "startActivity", new Class[]{Intent.class}, new Object[]{compatIntent})) return true;
        if (opts instanceof ActivityOptions &&
                tryInvokeWithError(av, "startActivity", new Class[]{Intent.class, ActivityOptions.class}, new Object[]{compatIntent, opts})) return true;
        if (bundle != null &&
                tryInvokeWithError(av, "startActivity", new Class[]{Intent.class, android.os.Bundle.class}, new Object[]{compatIntent, bundle})) return true;

        Method[] all = sActivityView.getMethods();
        for (Method m : all) {
            if (!"startActivity".equals(m.getName())) continue;
            Class<?>[] p = m.getParameterTypes();
            Object[] args = new Object[p.length];
            boolean ok = true;
            for (int i = 0; i < p.length; i++) {
                Class<?> t = p[i];
                if (t == Intent.class) args[i] = compatIntent;
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
        Log.e(TAG, "WindowHostActivityView.startActivity failed for intent=" + compatIntent + " opts=" + (opts!=null) + 
            (lastException != null ? " lastError=" + lastException.getMessage() : ""));
        return false;
    }

    /**
     * Create compatible intent with flags that prevent fresh instance launches
     * and preserve existing process state
     */
    private static Intent createCompatibleIntent(Context ctx, Intent original) {
        Intent intent;
        
        if (original.getComponent() != null) {
            String pkg = original.getComponent().getPackageName();
            intent = ctx.getPackageManager().getLaunchIntentForPackage(pkg);
            if (intent == null) {
                intent = new Intent(original);
            } else {
                // Copy extras from original
                if (original.getExtras() != null) {
                    intent.putExtras(original.getExtras());
                }
            }
        } else {
            intent = new Intent(original);
        }
        
        // Clear ALL existing flags to start fresh
        intent.setFlags(0);
        
        // Flags that preserve existing activity/process state. These ensure we DON'T create a fresh instance
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);           // Required for ActivityView
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);         // Don't recreate if already top
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);          // Clear activities above, reuse existing
        intent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED); // Reset task state properly
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);   // Bring existing to front instead of new
        
        // Additional flags to prevent fresh launches
        intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);   // Indicates we want existing instance
        intent.addFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY); // Treat like resuming from recents
            
        Log.i(TAG, "Created compatible intent with state-preserving flags for " + 
            (original.getComponent() != null ? original.getComponent().getPackageName() : "unknown"));
        return intent;
    }
    
    /**
     * Get launch intent for package with state-preserving flags
     * This ensures the app resumes its existing state instead of starting fresh
     */
    static Intent getLaunchIntentForPackage(Context ctx, String pkg) {
        try {
            PackageManager pm = ctx.getPackageManager();
            Intent i = pm.getLaunchIntentForPackage(pkg);
            if (i == null) return null;
            
            // Clear and set compatible flags that preserve process state
            i.setFlags(0);
            
            // Core flags for process preservation
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            
            // Additional flags to ensure we resume existing process
            i.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
            i.addFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
            
            // Add this flag to explicitly preserve task affinity. This prevents the system from creating a new task/process
            i.addFlags(Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS);
            
            Log.i(TAG, "Created launch intent with process-preserving flags for " + pkg);
            return i;
        } catch (Throwable t) {
            Log.w(TAG, "getLaunchIntentForPackage failed for " + pkg, t);
            return null;
        }
    }

    /**
     * Create compatible ActivityOptions that preserve activity state
     * and prevent fresh launches after inactivity
     */
    static Object createCompatibleOptions(Rect bounds) {
        try {
            ActivityOptions options = ActivityOptions.makeBasic();
            
            if (bounds != null) {
                options.setLaunchBounds(bounds);
            }
            
            // Set windowing mode for freeform
            try {
                options.getClass()
                    .getMethod("setLaunchWindowingMode", int.class)
                    .invoke(options, 5 /*WINDOWING_MODE_FREEFORM*/);
            } catch (Exception ignore) {}
            
            try {
                // Tell the system to reuse existing task if available
                options.getClass()
                    .getMethod("setTaskAlwaysOnTop", boolean.class)
                    .invoke(options, false);
            } catch (Exception ignore) {}
            
            try {
                // Prefer reusing existing task over creating new one
                options.getClass()
                    .getMethod("setLaunchDisplayId", int.class)
                    .invoke(options, 0); // Default display
            } catch (Exception ignore) {}
            
            try {
                Method setLaunchActivityType = options.getClass()
                    .getMethod("setLaunchActivityType", int.class);
                setLaunchActivityType.invoke(options, 0); // ACTIVITY_TYPE_UNDEFINED (let system decide)
            } catch (Exception ignore) {}
            
            return options;
            
        } catch (Exception e) {
            Log.e(TAG, "Failed to create compatible options", e);
            return null;
        }
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
        return createCompatibleOptions(b);
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

    /**
     * Check if an app's process is still alive
     * Use this before starting to decide if we need special handling
     */
    static boolean isProcessAlive(Context ctx, String packageName) {
        try {
            ActivityManager am = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
            java.util.List<ActivityManager.RunningAppProcessInfo> processes = am.getRunningAppProcesses();
            
            if (processes != null) {
                for (ActivityManager.RunningAppProcessInfo process : processes) {
                    if (process.processName.equals(packageName)) {
                        Log.i(TAG, "Process alive for " + packageName + " (importance=" + process.importance + ")");
                        return true;
                    }
                }
            }
            
            Log.i(TAG, "Process NOT alive for " + packageName);
            return false;
        } catch (Throwable t) {
            Log.w(TAG, "Failed to check process state for " + packageName, t);
            return false;
        }
    }

    /**
     * Get the task ID for a running package
     * Returns -1 if not found
     */
    static int getTaskIdForPackage(Context ctx, String packageName) {
        try {
            ActivityManager am = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
            
            // Try to get recent tasks
            try {
                Method getRecentTasks = am.getClass().getMethod("getRecentTasks", int.class, int.class);
                @SuppressWarnings("unchecked")
                java.util.List<ActivityManager.RecentTaskInfo> tasks = 
                    (java.util.List<ActivityManager.RecentTaskInfo>) getRecentTasks.invoke(am, 20, 0);
                
                if (tasks != null) {
                    for (ActivityManager.RecentTaskInfo task : tasks) {
                        if (task.baseIntent != null && 
                            task.baseIntent.getComponent() != null &&
                            task.baseIntent.getComponent().getPackageName().equals(packageName)) {
                            
                            // Get task ID
                            try {
                                java.lang.reflect.Field idField = task.getClass().getField("id");
                                int taskId = idField.getInt(task);
                                Log.i(TAG, "Found existing task " + taskId + " for " + packageName);
                                return taskId;
                            } catch (Exception ignore) {}
                        }
                    }
                }
            } catch (Exception ignore) {}
            
            Log.i(TAG, "No existing task found for " + packageName);
            return -1;
            
        } catch (Throwable t) {
            Log.w(TAG, "Failed to get task ID for " + packageName, t);
            return -1;
        }
    }

    /**
     * Enhanced start that checks for existing process first
     * and uses optimal flags based on process state
     */
    static boolean startActivitySmartWithProcessCheck(Object av, Context ctx, String packageName, Rect bounds) {
        boolean processAlive = isProcessAlive(ctx, packageName);
        int existingTaskId = getTaskIdForPackage(ctx, packageName);
        
        Intent intent = getLaunchIntentForPackage(ctx, packageName);
        if (intent == null) {
            Log.e(TAG, "No launch intent for " + packageName);
            return false;
        }
        
        // If process is alive or task exists, ensure we use resume flags
        if (processAlive || existingTaskId >= 0) {
            Log.i(TAG, "Existing process/task detected for " + packageName + 
                " - using resume mode (processAlive=" + processAlive + ", taskId=" + existingTaskId + ")");
            
            // Add extra flags to ensure we resume instead of recreate
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
            intent.addFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
            
            // If we have a task ID, try to move it to front instead of starting fresh
            if (existingTaskId >= 0) {
                try {
                    ActivityManager am = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
                    Method moveTaskToFront = am.getClass().getMethod("moveTaskToFront", int.class, int.class);
                    moveTaskToFront.invoke(am, existingTaskId, 0);
                    Log.i(TAG, "Moved task " + existingTaskId + " to front for " + packageName);
                } catch (Exception e) {
                    Log.w(TAG, "Failed to move task to front, will try normal start", e);
                }
            }
        } else {
            Log.i(TAG, "Fresh start for " + packageName + " - no existing process");
        }
        
        Object opts = createCompatibleOptions(bounds);
        return startActivitySmart(av, ctx, intent, opts);
    }
}