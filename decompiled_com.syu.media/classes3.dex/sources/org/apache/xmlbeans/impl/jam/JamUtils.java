package org.apache.xmlbeans.impl.jam;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class JamUtils {
    private static final JamUtils INSTANCE = new JamUtils();
    private static Comparator SOURCE_POSITION_COMPARATOR = new Comparator() { // from class: org.apache.xmlbeans.impl.jam.JamUtils.1
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            JSourcePosition sourcePosition = ((JElement) obj).getSourcePosition();
            JSourcePosition sourcePosition2 = ((JElement) obj2).getSourcePosition();
            if (sourcePosition == null) {
                return sourcePosition2 == null ? 0 : -1;
            }
            if (sourcePosition2 == null) {
                return 1;
            }
            if (sourcePosition.getLine() < sourcePosition2.getLine()) {
                return -1;
            }
            return sourcePosition.getLine() > sourcePosition2.getLine() ? 1 : 0;
        }
    };

    public static final JamUtils getInstance() {
        return INSTANCE;
    }

    private JamUtils() {
    }

    public Method getMethodOn(JMethod jMethod, Class cls) throws NoSuchMethodException, ClassNotFoundException {
        Class<?>[] clsArr;
        if (cls == null) {
            throw new IllegalArgumentException("null class");
        }
        if (jMethod == null) {
            throw new IllegalArgumentException("null method");
        }
        JParameter[] parameters = jMethod.getParameters();
        if (parameters == null || parameters.length <= 0) {
            clsArr = null;
        } else {
            int length = parameters.length;
            clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = loadClass(parameters[i].getType(), cls.getClassLoader());
            }
        }
        return cls.getMethod(jMethod.getSimpleName(), clsArr);
    }

    public Constructor getConstructorOn(JConstructor jConstructor, Class cls) throws NoSuchMethodException, ClassNotFoundException {
        Class<?>[] clsArr;
        if (cls == null) {
            throw new IllegalArgumentException("null class");
        }
        if (jConstructor == null) {
            throw new IllegalArgumentException("null ctor");
        }
        JParameter[] parameters = jConstructor.getParameters();
        if (parameters == null || parameters.length <= 0) {
            clsArr = null;
        } else {
            int length = parameters.length;
            clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = loadClass(parameters[i].getType(), cls.getClassLoader());
            }
        }
        return cls.getConstructor(clsArr);
    }

    public Field getFieldOn(JField jField, Class cls) throws NoSuchFieldException {
        if (cls == null) {
            throw new IllegalArgumentException("null class");
        }
        if (jField == null) {
            throw new IllegalArgumentException("null field");
        }
        return cls.getField(jField.getSimpleName());
    }

    public Class loadClass(JClass jClass, ClassLoader classLoader) throws ClassNotFoundException {
        return classLoader.loadClass(jClass.getQualifiedName());
    }

    public void placeInSourceOrder(JElement[] jElementArr) {
        if (jElementArr == null) {
            throw new IllegalArgumentException("null elements");
        }
        Arrays.sort(jElementArr, SOURCE_POSITION_COMPARATOR);
    }
}
