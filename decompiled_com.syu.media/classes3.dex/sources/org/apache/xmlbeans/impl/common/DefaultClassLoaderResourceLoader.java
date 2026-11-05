package org.apache.xmlbeans.impl.common;

import java.io.InputStream;
import org.apache.xmlbeans.ResourceLoader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class DefaultClassLoaderResourceLoader implements ResourceLoader {
    public void close() {
    }

    public InputStream getResourceAsStream(String str) {
        InputStream resourceAsStream;
        try {
            resourceAsStream = getResourceAsStream(Thread.currentThread().getContextClassLoader(), str);
        } catch (SecurityException unused) {
            resourceAsStream = null;
        }
        if (resourceAsStream == null) {
            resourceAsStream = getResourceAsStream(DefaultClassLoaderResourceLoader.class.getClassLoader(), str);
        }
        return resourceAsStream == null ? DefaultClassLoaderResourceLoader.class.getResourceAsStream(str) : resourceAsStream;
    }

    private InputStream getResourceAsStream(ClassLoader classLoader, String str) {
        if (classLoader == null) {
            return null;
        }
        return classLoader.getResourceAsStream(str);
    }
}
