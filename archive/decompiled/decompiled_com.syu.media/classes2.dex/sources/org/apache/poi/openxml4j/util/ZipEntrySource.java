package org.apache.poi.openxml4j.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface ZipEntrySource extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    Enumeration<? extends ZipEntry> getEntries();

    InputStream getInputStream(ZipEntry zipEntry) throws IOException;

    boolean isClosed();
}
