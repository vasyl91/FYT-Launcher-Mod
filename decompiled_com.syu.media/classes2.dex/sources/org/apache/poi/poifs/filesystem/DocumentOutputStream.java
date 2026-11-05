package org.apache.poi.poifs.filesystem;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class DocumentOutputStream extends OutputStream {
    private final int _limit;
    private final OutputStream _stream;
    private int _written = 0;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    DocumentOutputStream(OutputStream outputStream, int i) {
        this._stream = outputStream;
        this._limit = i;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        limitCheck(1);
        this._stream.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        limitCheck(i2);
        this._stream.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this._stream.flush();
    }

    void writeFiller(int i, byte b) throws IOException {
        int i2 = this._written;
        if (i > i2) {
            byte[] bArr = new byte[i - i2];
            Arrays.fill(bArr, b);
            this._stream.write(bArr);
        }
    }

    private void limitCheck(int i) throws IOException {
        int i2 = this._written;
        if (i2 + i > this._limit) {
            throw new IOException("tried to write too much data");
        }
        this._written = i2 + i;
    }
}
