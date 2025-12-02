package com.syu.util;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

/**
 * Handles app compatibility issues with ActivityView
 * Some apps crash when run in ActivityView due to:
 * - Missing context/permissions
 * - Activity lifecycle issues
 * - Hardware requirements
 */
public class WindowHostAppCompatibility {
    private static final String TAG = "AppCompatibility";
    
    // Known problematic apps that crash in ActivityView
    private static final Set<String> KNOWN_PROBLEMATIC_APPS = new HashSet<>();
    
    // Apps that need special launch flags
    private static final Set<String> NEEDS_SPECIAL_FLAGS = new HashSet<>();
    
    // Apps that require specific permissions to be pre-granted
    private static final Set<String> NEEDS_STORAGE_PERMISSION = new HashSet<>();
    
    static {
        // Music players often have issues
        KNOWN_PROBLEMATIC_APPS.add("in.krosbits.musicolet");  // Musicolet
        KNOWN_PROBLEMATIC_APPS.add("com.jrtstudio.AnotherMusicPlayer");
        KNOWN_PROBLEMATIC_APPS.add("com.maxmpz.audioplayer");  // Poweramp
        
        // Apps that need READ_EXTERNAL_STORAGE
        NEEDS_STORAGE_PERMISSION.add("in.krosbits.musicolet");
        NEEDS_STORAGE_PERMISSION.add("com.jrtstudio.AnotherMusicPlayer");
        
        // Apps that need special flags
        NEEDS_SPECIAL_FLAGS.add("in.krosbits.musicolet");
    }
    
    /**
     * Check if an app is known to have compatibility issues
     */
    public static boolean isProblematic(String packageName) {
        return KNOWN_PROBLEMATIC_APPS.contains(packageName);
    }
    
    /**
     * Check if we have required permissions for this app
     */
    public static boolean hasRequiredPermissions(Context ctx, String packageName) {
        if (NEEDS_STORAGE_PERMISSION.contains(packageName)) {
            // Check if the app has storage permission
            try {
                PackageManager pm = ctx.getPackageManager();
                int hasPermission = pm.checkPermission(
                    android.Manifest.permission.READ_EXTERNAL_STORAGE, 
                    packageName
                );
                
                if (hasPermission != PackageManager.PERMISSION_GRANTED) {
                    Log.w(TAG, packageName + " needs READ_EXTERNAL_STORAGE but doesn't have it");
                    return false;
                }
            } catch (Exception e) {
                Log.e(TAG, "Failed to check permissions for " + packageName, e);
                return false;
            }
        }
        return true;
    }
    
    /**
     * Create optimized intent for problematic apps
     */
    public static Intent createCompatibleIntent(Context ctx, String packageName) {
        Intent intent = ctx.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent == null) {
            Log.e(TAG, "No launch intent for " + packageName);
            return null;
        }
        
        // Clear existing flags
        intent.setFlags(0);
        
        // Base flags
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        
        if (NEEDS_SPECIAL_FLAGS.contains(packageName)) {
            // Apps like Musicolet need these specific flags
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            
            // Don't exclude from recents for music players
            // They need to maintain their service state
            // intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS); // REMOVED
            
            // Don't use NO_HISTORY for apps that need persistent state
            // intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY); // REMOVED
            
            Log.i(TAG, "Applied special flags for " + packageName);
        } else {
            // Standard flags for other apps
            intent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        }
        
        return intent;
    }
    
    /**
     * Create optimized ActivityOptions for problematic apps
     */
    public static Object createCompatibleOptions(String packageName, Rect bounds) {
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
            
            // For problematic apps, don't set TASK_OVERLAY flag
            // This can cause lifecycle issues
            if (!KNOWN_PROBLEMATIC_APPS.contains(packageName)) {
                try {
                    // Only for stable apps
                    options.getClass()
                        .getMethod("setTaskOverlay", boolean.class, boolean.class)
                        .invoke(options, true, true);
                } catch (Exception ignore) {}
            }
            
            return options;
            
        } catch (Exception e) {
            Log.e(TAG, "Failed to create compatible options", e);
            return null;
        }
    }
    
    /**
     * Check if app can run in ActivityView mode
     */
    public static boolean canRunInActivityView(Context ctx, String packageName) {
        try {
            PackageManager pm = ctx.getPackageManager();
            ApplicationInfo appInfo = pm.getApplicationInfo(packageName, 0);
            
            // Check if app targets SDK that might have issues
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                // Apps targeting very old SDK versions might crash
                if (appInfo.targetSdkVersion < Build.VERSION_CODES.M) {
                    Log.w(TAG, packageName + " targets old SDK: " + appInfo.targetSdkVersion);
                    // Still return true but log warning
                }
            }
            
            // Check permissions
            if (!hasRequiredPermissions(ctx, packageName)) {
                Log.e(TAG, packageName + " missing required permissions");
                return false;
            }
            
            return true;
            
        } catch (Exception e) {
            Log.e(TAG, "Failed to check compatibility for " + packageName, e);
            return false;
        }
    }
    
    /**
     * Get user-friendly error message for incompatible apps
     */
    public static String getIncompatibilityReason(Context ctx, String packageName) {
        if (!hasRequiredPermissions(ctx, packageName)) {
            return "App requires storage permissions. Please grant permissions in Settings.";
        }
        
        if (KNOWN_PROBLEMATIC_APPS.contains(packageName)) {
            return "This app has known compatibility issues with windowed mode.";
        }
        
        return "App cannot run in windowed mode.";
    }
    
    /**
     * Register a problematic app at runtime
     */
    public static void registerProblematicApp(String packageName) {
        KNOWN_PROBLEMATIC_APPS.add(packageName);
        Log.i(TAG, "Registered problematic app: " + packageName);
    }
    
    /**
     * Check if app is a music player (needs special handling)
     */
    public static boolean isMusicPlayer(Context ctx, String packageName) {
        // Common music player packages
        return packageName.contains("music") 
            || packageName.contains("player")
            || packageName.contains("audio")
            || packageName.equals("in.krosbits.musicolet")
            || packageName.equals("com.jrtstudio.AnotherMusicPlayer")
            || packageName.equals("com.maxmpz.audioplayer");
    }
}