package org.apache.poi.util;

import java.io.FilterInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CloseIgnoringInputStream extends FilterInputStream {
    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public CloseIgnoringInputStream(InputStream inputStream) {
        super(inputStream);
    }
}
