package org.apache.http.entity;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public interface ContentProducer {
    void writeTo(OutputStream outputStream) throws IOException;
}
