package org.apache.poi.openxml4j.opc.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class MemoryPackagePartOutputStream extends OutputStream {
    private ByteArrayOutputStream _buff = new ByteArrayOutputStream();
    private MemoryPackagePart _part;

    public MemoryPackagePartOutputStream(MemoryPackagePart memoryPackagePart) {
        this._part = memoryPackagePart;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this._buff.write(i);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this._buff.flush();
        if (this._part.data != null) {
            byte[] bArr = new byte[this._part.data.length + this._buff.size()];
            System.arraycopy(this._part.data, 0, bArr, 0, this._part.data.length);
            byte[] byteArray = this._buff.toByteArray();
            System.arraycopy(byteArray, 0, bArr, this._part.data.length, byteArray.length);
            this._part.data = bArr;
        } else {
            this._part.data = this._buff.toByteArray();
        }
        this._buff.reset();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this._buff.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this._buff.write(bArr);
    }
}
