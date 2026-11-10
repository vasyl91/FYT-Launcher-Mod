package com.fasterxml.aalto.out;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class ByteWName extends WName {
    final byte[] _bytes;

    protected ByteWName(String str, byte[] bArr) {
        super(str);
        this._bytes = bArr;
    }

    protected ByteWName(String str, String str2, byte[] bArr) {
        super(str, str2);
        this._bytes = bArr;
    }

    @Override // com.fasterxml.aalto.out.WName
    public final int serializedLength() {
        return this._bytes.length;
    }

    @Override // com.fasterxml.aalto.out.WName
    public int appendBytes(byte[] bArr, int i) {
        byte[] bArr2 = this._bytes;
        int length = bArr2.length;
        System.arraycopy(bArr2, 0, bArr, i, length);
        return length;
    }

    @Override // com.fasterxml.aalto.out.WName
    public void writeBytes(OutputStream outputStream) throws IOException {
        outputStream.write(this._bytes);
    }

    @Override // com.fasterxml.aalto.out.WName
    public int appendChars(char[] cArr, int i) {
        throw new RuntimeException("Internal error: appendChars() should never be called");
    }

    @Override // com.fasterxml.aalto.out.WName
    public void writeChars(Writer writer) throws IOException {
        throw new RuntimeException("Internal error: writeChars() should never be called");
    }
}
