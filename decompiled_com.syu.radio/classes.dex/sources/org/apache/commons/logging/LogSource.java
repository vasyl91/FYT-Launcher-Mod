package org.apache.commons.logging;

import java.lang.reflect.Constructor;
import java.util.Hashtable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class LogSource {
    protected static boolean jdk14IsAvailable;
    protected static boolean log4jIsAvailable;
    protected static Constructor logImplctor;
    protected static Hashtable logs;

    LogSource() {
        throw new RuntimeException("Stub!");
    }

    public static void setLogImplementation(String classname) throws LinkageError, NoSuchMethodException, SecurityException, ClassNotFoundException {
        throw new RuntimeException("Stub!");
    }

    public static void setLogImplementation(Class logclass) throws LinkageError, NoSuchMethodException, SecurityException {
        throw new RuntimeException("Stub!");
    }

    public static Log getInstance(String name) {
        throw new RuntimeException("Stub!");
    }

    public static Log getInstance(Class clazz) {
        throw new RuntimeException("Stub!");
    }

    public static Log makeNewLogInstance(String name) {
        throw new RuntimeException("Stub!");
    }

    public static String[] getLogNames() {
        throw new RuntimeException("Stub!");
    }
}
