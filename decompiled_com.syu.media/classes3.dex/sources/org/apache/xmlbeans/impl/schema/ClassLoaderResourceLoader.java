package org.apache.xmlbeans.impl.schema;

import java.io.InputStream;
import org.apache.xmlbeans.ResourceLoader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ClassLoaderResourceLoader implements ResourceLoader {
    ClassLoader _classLoader;

    public void close() {
    }

    public ClassLoaderResourceLoader(ClassLoader classLoader) {
        this._classLoader = classLoader;
    }

    public InputStream getResourceAsStream(String str) {
        return this._classLoader.getResourceAsStream(str);
    }
}
