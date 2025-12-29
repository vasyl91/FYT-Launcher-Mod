package android;

import android.util.Log;
import java.lang.reflect.Method;

/**
 * Wrapper class for android.os.SystemProperties using reflection.
 * Allows access to system properties without direct dependency on hidden APIs.
 */
public class SystemProperties {
    private static final String TAG = "SystemProperties";
    private static Class<?> sSystemPropertiesClass;
    
    static {
        try {
            sSystemPropertiesClass = Class.forName("android.os.SystemProperties");
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "Failed to load SystemProperties class", e);
        }
    }
    
    /**
     * Get the value for the given key.
     * @param key the key to lookup
     * @param def a default value to return
     * @return the value for the key, or def if not found
     */
    public static String get(String key, String def) {
        if (sSystemPropertiesClass == null) {
            return def;
        }
        
        try {
            Method method = sSystemPropertiesClass.getMethod("get", String.class, String.class);
            return (String) method.invoke(null, key, def);
        } catch (Exception e) {
            Log.e(TAG, "Failed to get property: " + key, e);
            return def;
        }
    }
    
    /**
     * Get the value for the given key.
     * @param key the key to lookup
     * @return an empty string if the key isn't found
     */
    public static String get(String key) {
        return get(key, "");
    }
    
    /**
     * Get the value for the given key as an integer.
     * @param key the key to lookup
     * @param def a default value to return
     * @return the value for the key as an integer, or def if not found or not a valid integer
     */
    public static int getInt(String key, int def) {
        if (sSystemPropertiesClass == null) {
            return def;
        }
        
        try {
            Method method = sSystemPropertiesClass.getMethod("getInt", String.class, int.class);
            return (Integer) method.invoke(null, key, def);
        } catch (Exception e) {
            Log.e(TAG, "Failed to get int property: " + key, e);
            return def;
        }
    }
    
    /**
     * Get the value for the given key as a boolean.
     * @param key the key to lookup
     * @param def a default value to return
     * @return the value for the key as a boolean, or def if not found
     */
    public static boolean getBoolean(String key, boolean def) {
        if (sSystemPropertiesClass == null) {
            return def;
        }
        
        try {
            Method method = sSystemPropertiesClass.getMethod("getBoolean", String.class, boolean.class);
            return (Boolean) method.invoke(null, key, def);
        } catch (Exception e) {
            Log.e(TAG, "Failed to get boolean property: " + key, e);
            return def;
        }
    }
    
    /**
     * Get the value for the given key as a long.
     * @param key the key to lookup
     * @param def a default value to return
     * @return the value for the key as a long, or def if not found
     */
    public static long getLong(String key, long def) {
        if (sSystemPropertiesClass == null) {
            return def;
        }
        
        try {
            Method method = sSystemPropertiesClass.getMethod("getLong", String.class, long.class);
            return (Long) method.invoke(null, key, def);
        } catch (Exception e) {
            Log.e(TAG, "Failed to get long property: " + key, e);
            return def;
        }
    }
    
    /**
     * Set the value for the given key.
     * @param key the key to set
     * @param val the value to set
     */
    public static void set(String key, String val) {
        if (sSystemPropertiesClass == null) {
            Log.e(TAG, "SystemProperties class not loaded, cannot set property");
            return;
        }
        
        try {
            Method method = sSystemPropertiesClass.getMethod("set", String.class, String.class);
            method.invoke(null, key, val);
        } catch (Exception e) {
            Log.e(TAG, "Failed to set property: " + key, e);
        }
    }
}