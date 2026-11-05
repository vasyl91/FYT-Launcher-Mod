package com.android.volley.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class PoolingByteArrayOutputStream extends ByteArrayOutputStream {
    private static final int DEFAULT_SIZE = 256;
    private final ByteArrayPool mPool;

    public PoolingByteArrayOutputStream(ByteArrayPool pool) {
        this(pool, 256);
    }

    public PoolingByteArrayOutputStream(ByteArrayPool pool, int size) {
        this.mPool = pool;
        this.buf = this.mPool.getBuf(Math.max(size, 256));
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mPool.returnBuf(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.mPool.returnBuf(this.buf);
    }

    private void expand(int i) {
        if (this.count + i > this.buf.length) {
            byte[] newbuf = this.mPool.getBuf((this.count + i) * 2);
            System.arraycopy(this.buf, 0, newbuf, 0, this.count);
            this.mPool.returnBuf(this.buf);
            this.buf = newbuf;
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] buffer, int offset, int len) {
        expand(len);
        super.write(buffer, offset, len);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int oneByte) {
        expand(1);
        super.write(oneByte);
    }
}
