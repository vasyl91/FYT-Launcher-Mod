package com.syu.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Tools {
    public static final Method getMethod(String clazzName, String methodName, Class<?>... clsArr) {
        try {
            Class<?> clazz = Class.forName(clazzName);
            if (clazz != null) {
                return getMethod(clazz, methodName, clsArr);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static final Method getMethod(Class clazz, String methodName, Class<?>... clsArr) {
        try {
            Method method = clazz.getMethod(methodName, clsArr);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final Object callMethod(Object obj, Method method, Object... params) {
        if (method == null) {
            return null;
        }
        try {
            Object ret = method.invoke(obj, params);
            return ret;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
