package com.lsec.core.sharememory;

import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public final class InvokeUtil {
    private static final int INSTANCE_CONV = 2;
    private static final int INSTANCE_DENIED = 0;
    private static final int INSTANCE_OK = 1;
    private static final int METHOD_MATCH_NONE = 0;
    private static final int METHOD_MATCH_PARAMS_TYPE = 2;
    private static final int METHOD_MATCH_PUBLIC = 1;

    public static <T> T newInstanceOrThrow(Class<? extends T> cls, Object... objArr) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors == null || declaredConstructors.length == 0) {
            throw new IllegalArgumentException("Can't get even one available constructor for " + cls);
        }
        Constructor<?> constructor = null;
        for (Constructor<?> constructor2 : declaredConstructors) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if (parameterTypes.length == objArr.length) {
                if (objArr.length == 0) {
                    constructor = constructor2;
                    break;
                }
                boolean z = true;
                for (int i = 0; i < objArr.length; i++) {
                    if (instanceOf(objArr[0], parameterTypes[i]) == 0) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    constructor = constructor2;
                    break;
                }
            }
        }
        if (constructor != null) {
            constructor.setAccessible(true);
            return (T) constructor.newInstance(objArr);
        }
        throw new NoSuchElementException("no Constructor match it!!");
    }

    public static Object invokeMethod(Object o, String methodName, Object... params) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = matchMethod(o.getClass(), methodName, params);
        if (method == null) {
            throw new NoSuchMethodException("class " + o.getClass().getCanonicalName() + " cannot find method " + methodName);
        }
        Object out = method.invoke(o, params);
        return out;
    }

    public static Object invokeStaticMethod(String className, String methodName, Object... params) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Method method = matchMethod(Class.forName(className), methodName, params);
        if (method == null) {
            throw new NoSuchMethodException("class " + className + " cannot find method " + methodName);
        }
        Object out = method.invoke(null, params);
        return out;
    }

    public static Object invokeStaticMethod(Class clz, String methodName, Object... params) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = matchMethod(clz, methodName, params);
        if (method == null) {
            throw new NoSuchMethodException("class " + clz.getCanonicalName() + " cannot find method " + methodName);
        }
        Object out = method.invoke(null, params);
        return out;
    }

    public static Class wrappedClass(Class clz) {
        try {
            return (Class) clz.getField("TYPE").get(null);
        } catch (Exception e) {
            return null;
        }
    }

    public static Method[] methodsForName(Class clz, String name) {
        Method[] methods = clz.getDeclaredMethods();
        if (methods == null || methods.length == 0) {
            return null;
        }
        List<Method> out = new ArrayList<>();
        for (Method method : methods) {
            if (method.getName().equals(name)) {
                out.add(method);
            }
        }
        if (out.size() != 0) {
            return (Method[]) out.toArray(new Method[0]);
        }
        return null;
    }

    public static Method matchMethod(Class clz, String name, Object... params) {
        Method[] methods = methodsForName(clz, name);
        if (methods == null || methods.length == 0) {
            return null;
        }
        Method found = null;
        int maxMatch = 0;
        for (Method method : methods) {
            int v = matchMethodParameterTypes(method, params);
            if (v > maxMatch) {
                maxMatch = v;
                found = method;
            }
        }
        if (maxMatch == 0) {
            return null;
        }
        if ((maxMatch & 1) == 0) {
            found.setAccessible(true);
            return found;
        }
        return found;
    }

    private static int instanceOf(Object o, Class<?> clz) {
        Class<?> clsWrappedClass;
        if (o == null) {
            return clz.isPrimitive() ? 0 : 1;
        }
        if (clz.isPrimitive()) {
            if (clz == Void.TYPE || (clsWrappedClass = wrappedClass(o.getClass())) == null) {
                return 0;
            }
            if (clsWrappedClass == clz) {
                return 1;
            }
            if (clz == Long.TYPE && clsWrappedClass == Integer.TYPE) {
                return 2;
            }
            if (clz == Double.TYPE && (clsWrappedClass == Float.TYPE || clsWrappedClass == Long.TYPE || clsWrappedClass == Integer.TYPE)) {
                return 2;
            }
            if (clz == Float.TYPE && clsWrappedClass == Integer.TYPE) {
                return 2;
            }
            if (clz == Integer.TYPE) {
                return (clsWrappedClass == Byte.TYPE || clsWrappedClass == Short.TYPE || clsWrappedClass == Character.TYPE) ? 2 : 0;
            }
            return 0;
        }
        return clz.isInstance(o) ? 1 : 0;
    }

    private static int matchMethodParameterTypes(Method method, Object... params) {
        int size;
        Class<?>[] parameterTypes = method.getParameterTypes();
        int tlen = 0;
        if (parameterTypes != null) {
            tlen = parameterTypes.length;
        }
        int plen = 0;
        if (params != null) {
            plen = params.length;
        }
        if (tlen != plen) {
            return 0;
        }
        if (plen > 0) {
            int[] pos = new int[plen];
            int i = 0;
            int size2 = 0;
            while (i < plen) {
                int v = instanceOf(params[i], parameterTypes[i]);
                if (v == 0) {
                    return 0;
                }
                if (v == 1) {
                    size = size2;
                } else {
                    size = size2 + 1;
                    pos[size2] = i;
                }
                i++;
                size2 = size;
            }
            if (size2 > 0) {
                for (int index : pos) {
                    Object p = params[index];
                    if (p instanceof Number) {
                        Number n = (Number) p;
                        if (parameterTypes[index] == Integer.TYPE) {
                            params[index] = Integer.valueOf(n.intValue());
                        } else if (parameterTypes[index] == Long.TYPE) {
                            params[index] = Long.valueOf(n.longValue());
                        } else if (parameterTypes[index] == Double.TYPE) {
                            params[index] = Double.valueOf(n.doubleValue());
                        } else if (parameterTypes[index] == Float.TYPE) {
                            params[index] = Float.valueOf(n.floatValue());
                        } else if (parameterTypes[index] == Byte.TYPE) {
                            params[index] = Byte.valueOf(n.byteValue());
                        } else if (parameterTypes[index] == Short.TYPE) {
                            params[index] = Short.valueOf(n.shortValue());
                        }
                    } else if (p instanceof Character) {
                        char c = ((Character) p).charValue();
                        if (parameterTypes[index] == Integer.TYPE) {
                            params[index] = Integer.valueOf(c);
                        } else if (parameterTypes[index] == Long.TYPE) {
                            params[index] = Long.valueOf(c);
                        } else if (parameterTypes[index] == Byte.TYPE) {
                            params[index] = Byte.valueOf((byte) c);
                        } else if (parameterTypes[index] == Short.TYPE) {
                            params[index] = Short.valueOf((short) c);
                        }
                    }
                }
            }
        }
        int value = 0 | 2;
        if (Modifier.isPublic(method.getModifiers())) {
            value |= 1;
        }
        return value;
    }

    public static void setValueOfField(Object o, String fieldName, Object value) throws IllegalAccessException, NoSuchFieldException {
        if (TextUtils.isEmpty(fieldName)) {
            throw new IllegalArgumentException("param fieldName is empty");
        }
        Field field = fieldByNameRecursive(o.getClass(), fieldName);
        if (!Modifier.isPublic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())) {
            field.setAccessible(true);
        }
        field.set(o, value);
    }

    public static Field fieldByNameRecursive(Class clz, String fieldName) throws NoSuchFieldException {
        Class target = clz;
        while (!target.equals(Object.class)) {
            try {
                Field field = target.getDeclaredField(fieldName);
                return field;
            } catch (NoSuchFieldException e) {
                target = clz.getSuperclass();
            }
        }
        throw new NoSuchFieldException(fieldName);
    }
}
