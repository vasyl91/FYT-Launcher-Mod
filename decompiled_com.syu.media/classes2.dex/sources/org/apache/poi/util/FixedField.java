package org.apache.poi.util;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface FixedField {
    void readFromBytes(byte[] bArr) throws ArrayIndexOutOfBoundsException;

    void readFromStream(InputStream inputStream) throws IOException;

    String toString();

    void writeToBytes(byte[] bArr) throws ArrayIndexOutOfBoundsException;
}
