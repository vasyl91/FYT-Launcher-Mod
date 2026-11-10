package org.apache.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public interface HttpEntity {
    void consumeContent() throws IOException;

    InputStream getContent() throws IllegalStateException, IOException;

    Header getContentEncoding();

    long getContentLength();

    Header getContentType();

    boolean isChunked();

    boolean isRepeatable();

    boolean isStreaming();

    void writeTo(OutputStream outputStream) throws IOException;
}
