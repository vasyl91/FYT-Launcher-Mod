package com.android.internal.http.multipart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66.apk\dexFile\classes.dex */
public class FilePartSource implements PartSource {
    public FilePartSource(File file) throws FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    public FilePartSource(String fileName, File file) throws FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    @Override // com.android.internal.http.multipart.PartSource
    public long getLength() {
        throw new RuntimeException("Stub!");
    }

    @Override // com.android.internal.http.multipart.PartSource
    public String getFileName() {
        throw new RuntimeException("Stub!");
    }

    @Override // com.android.internal.http.multipart.PartSource
    public InputStream createInputStream() throws IOException {
        throw new RuntimeException("Stub!");
    }
}
