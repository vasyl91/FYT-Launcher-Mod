package com.android.internal.http.multipart;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface PartSource {
    InputStream createInputStream() throws IOException;

    String getFileName();

    long getLength();
}
