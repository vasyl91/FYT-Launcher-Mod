package com.lsec.core.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ReflectionUtil {
    private ReflectionUtil() {
        throw new AssertionError();
    }

    public static Object getValue(Object target, String fieldName) {
        Class<?> clazz = target.getClass();
        String[] fs = fieldName.split("\\.");
        for (int i = 0; i < fs.length - 1; i++) {
            try {
                Field f = clazz.getDeclaredField(fs[i]);
                f.setAccessible(true);
                target = f.get(target);
                clazz = target.getClass();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        Field f2 = clazz.getDeclaredField(fs[fs.length - 1]);
        f2.setAccessible(true);
        return f2.get(target);
    }

    public static void setValue(Object target, String fieldName, Object value) {
        Class<?> clazz = target.getClass();
        String[] fs = fieldName.split("\\.");
        for (int i = 0; i < fs.length - 1; i++) {
            try {
                Field f = clazz.getDeclaredField(fs[i]);
                f.setAccessible(true);
                Object val = f.get(target);
                if (val == null) {
                    Constructor<?> c = f.getType().getDeclaredConstructor(new Class[0]);
                    c.setAccessible(true);
                    val = c.newInstance(new Object[0]);
                    f.set(target, val);
                }
                target = val;
                clazz = target.getClass();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        Field f2 = clazz.getDeclaredField(fs[fs.length - 1]);
        f2.setAccessible(true);
        f2.set(target, value);
    }
}
