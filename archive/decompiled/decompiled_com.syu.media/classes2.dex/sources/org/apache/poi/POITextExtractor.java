package org.apache.poi;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class POITextExtractor implements Closeable {
    private Closeable fsToClose = null;

    public abstract POITextExtractor getMetadataTextExtractor();

    public abstract String getText();

    public void setFilesystem(Closeable closeable) {
        this.fsToClose = closeable;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Closeable closeable = this.fsToClose;
        if (closeable != null) {
            closeable.close();
        }
    }
}
