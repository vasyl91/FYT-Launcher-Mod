package org.apache.http.util;

import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class VersionInfo {
    public static final String PROPERTY_MODULE = "info.module";
    public static final String PROPERTY_RELEASE = "info.release";
    public static final String PROPERTY_TIMESTAMP = "info.timestamp";
    public static final String UNAVAILABLE = "UNAVAILABLE";
    public static final String VERSION_PROPERTY_FILE = "version.properties";

    protected VersionInfo(String pckg, String module, String release, String time, String clsldr) {
        throw new RuntimeException("Stub!");
    }

    public final String getPackage() {
        throw new RuntimeException("Stub!");
    }

    public final String getModule() {
        throw new RuntimeException("Stub!");
    }

    public final String getRelease() {
        throw new RuntimeException("Stub!");
    }

    public final String getTimestamp() {
        throw new RuntimeException("Stub!");
    }

    public final String getClassloader() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }

    public static final VersionInfo[] loadVersionInfo(String[] pckgs, ClassLoader clsldr) {
        throw new RuntimeException("Stub!");
    }

    public static final VersionInfo loadVersionInfo(String pckg, ClassLoader clsldr) {
        throw new RuntimeException("Stub!");
    }

    protected static final VersionInfo fromMap(String pckg, Map info, ClassLoader clsldr) {
        throw new RuntimeException("Stub!");
    }
}
