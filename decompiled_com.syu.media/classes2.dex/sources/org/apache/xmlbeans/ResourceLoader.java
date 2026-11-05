package org.apache.xmlbeans;

import java.io.InputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface ResourceLoader {
    void close();

    InputStream getResourceAsStream(String str);
}
