package com.syu.vdhost;

import android.os.IBinder;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Reflection over the hidden framework classes the host needs.
 *
 * Methods are found by name and shape rather than by exact signature: several of them gained or
 * lost parameters between Android 11 and 16 (callingFeatureId, AttributionSource, ...).
 */
final class Hidden {
    private Hidden() {}

    /** ServiceManager.getService(name) + IXxx.Stub.asInterface(). */
    static Object getService(String name, String interfaceClass) throws ReflectiveOperationException {
        Class<?> sm = Class.forName("android.os.ServiceManager");
        IBinder binder = (IBinder) sm.getMethod("getService", String.class).invoke(null, name);
        if (binder == null) throw new IllegalStateException("service not found: " + name);
        Class<?> stub = Class.forName(interfaceClass + "$Stub");
        return stub.getMethod("asInterface", IBinder.class).invoke(null, binder);
    }

    /** First public method with that name and parameter count (-1 = any count). */
    static Method findMethod(Object target, String name, int paramCount) {
        for (Method m : target.getClass().getMethods()) {
            if (!m.getName().equals(name)) continue;
            if (paramCount >= 0 && m.getParameterTypes().length != paramCount) continue;
            return m;
        }
        return null;
    }

    static Object readField(Object target, String name) {
        Class<?> c = target.getClass();
        while (c != null) {
            try {
                Field f = c.getDeclaredField(name);
                f.setAccessible(true);
                return f.get(target);
            } catch (NoSuchFieldException e) {
                c = c.getSuperclass();
            } catch (Throwable t) {
                return null;
            }
        }
        return null;
    }

    static String getSystemProperty(String key, String def) {
        try {
            Class<?> sp = Class.forName("android.os.SystemProperties");
            return (String) sp.getMethod("get", String.class, String.class).invoke(null, key, def);
        } catch (Throwable t) {
            return def;
        }
    }
}
