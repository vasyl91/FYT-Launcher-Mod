package org.apache.commons.codec.binary;

import java.io.OutputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Base32OutputStream extends BaseNCodecOutputStream {
    public Base32OutputStream(OutputStream outputStream) {
        this(outputStream, true);
    }

    public Base32OutputStream(OutputStream outputStream, boolean z) {
        super(outputStream, new Base32(false), z);
    }

    public Base32OutputStream(OutputStream outputStream, boolean z, int i, byte[] bArr) {
        super(outputStream, new Base32(i, bArr), z);
    }
}
