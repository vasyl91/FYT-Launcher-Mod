package com.fasterxml.aalto.in;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class MergedStream extends InputStream {
    final ReaderConfig mConfig;
    byte[] mData;
    final int mEnd;
    final InputStream mIn;
    int mPtr;

    public MergedStream(ReaderConfig readerConfig, InputStream inputStream, byte[] bArr, int i, int i2) {
        this.mConfig = readerConfig;
        this.mIn = inputStream;
        this.mData = bArr;
        this.mPtr = i;
        this.mEnd = i2;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.mData != null) {
            return this.mEnd - this.mPtr;
        }
        return this.mIn.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        freeBuffers();
        this.mIn.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        if (this.mData == null) {
            this.mIn.mark(i);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.mData == null && this.mIn.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = this.mData;
        if (bArr != null) {
            int i = this.mPtr;
            int i2 = i + 1;
            this.mPtr = i2;
            int i3 = bArr[i] & 255;
            if (i2 >= this.mEnd) {
                freeBuffers();
            }
            return i3;
        }
        return this.mIn.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = this.mData;
        if (bArr2 != null) {
            int i3 = this.mEnd;
            int i4 = this.mPtr;
            int i5 = i3 - i4;
            if (i2 > i5) {
                i2 = i5;
            }
            System.arraycopy(bArr2, i4, bArr, i, i2);
            int i6 = this.mPtr + i2;
            this.mPtr = i6;
            if (i6 >= this.mEnd) {
                freeBuffers();
            }
            return i2;
        }
        return this.mIn.read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        if (this.mData == null) {
            this.mIn.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long j2;
        if (this.mData != null) {
            int i = this.mEnd;
            int i2 = this.mPtr;
            long j3 = i - i2;
            if (j3 > j) {
                this.mPtr = i2 + ((int) j);
                return j;
            }
            freeBuffers();
            j2 = j3 + 0;
            j -= j3;
        } else {
            j2 = 0;
        }
        return j > 0 ? j2 + this.mIn.skip(j) : j2;
    }

    private void freeBuffers() {
        byte[] bArr = this.mData;
        if (bArr != null) {
            this.mData = null;
            ReaderConfig readerConfig = this.mConfig;
            if (readerConfig != null) {
                readerConfig.freeFullBBuffer(bArr);
            }
        }
    }
}
