package com.lsec.core.util;

import com.lsec.core.util.data.FinalChip;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ReflectUtil {
    public static Object getInstance(String className, Object... params) {
        if (className == null || className.equals(FinalChip.BSP_PLATFORM_Null)) {
            return null;
        }
        try {
            Class<?> c = Class.forName(className);
            if (params != null) {
                int plength = params.length;
                Class<?>[] clsArr = new Class[plength];
                for (int i = 0; i < plength; i++) {
                    clsArr[i] = params[i].getClass();
                }
                Constructor<?> declaredConstructor = c.getDeclaredConstructor(clsArr);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(params);
            }
            Constructor<?> declaredConstructor2 = c.getDeclaredConstructor(new Class[0]);
            declaredConstructor2.setAccessible(true);
            return declaredConstructor2.newInstance(new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object invoke(String className, Object instance, String methodName, Object... params) {
        if (className == null || className.equals(FinalChip.BSP_PLATFORM_Null) || methodName == null || methodName.equals(FinalChip.BSP_PLATFORM_Null)) {
            return null;
        }
        try {
            Class<?> c = Class.forName(className);
            if (params != null) {
                int plength = params.length;
                Class<?>[] clsArr = new Class[plength];
                for (int i = 0; i < plength; i++) {
                    clsArr[i] = params[i].getClass();
                }
                Method method = c.getDeclaredMethod(methodName, clsArr);
                method.setAccessible(true);
                return method.invoke(instance, params);
            }
            Method method2 = c.getDeclaredMethod(methodName, new Class[0]);
            method2.setAccessible(true);
            return method2.invoke(instance, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object invokeMethod(Object instance, Method m, Object... params) {
        if (m == null) {
            return null;
        }
        m.setAccessible(true);
        try {
            return m.invoke(instance, params);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object getField(String className, Object instance, String fieldName) {
        if (className == null || className.equals(FinalChip.BSP_PLATFORM_Null) || fieldName == null || fieldName.equals(FinalChip.BSP_PLATFORM_Null)) {
            return null;
        }
        try {
            Field field = Class.forName(className).getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(instance);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setField(String className, Object instance, String fieldName, Object value) {
        if (className != null && !className.equals(FinalChip.BSP_PLATFORM_Null) && fieldName != null && !fieldName.equals(FinalChip.BSP_PLATFORM_Null)) {
            try {
                Class<?> c = Class.forName(className);
                Field field = c.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(instance, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Method getMethod(String className, String methodName, Class... paramsType) {
        if (className == null || className.equals(FinalChip.BSP_PLATFORM_Null) || methodName == null || methodName.equals(FinalChip.BSP_PLATFORM_Null)) {
            return null;
        }
        try {
            Class<?> c = Class.forName(className);
            return c.getDeclaredMethod(methodName, paramsType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
