package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class ExceptionPassthroughInputStream extends InputStream {
    private static final Queue<ExceptionPassthroughInputStream> POOL = Util.createQueue(0);
    private IOException exception;
    private InputStream wrapped;

    public static ExceptionPassthroughInputStream obtain(InputStream inputStream) {
        ExceptionPassthroughInputStream exceptionPassthroughInputStreamPoll;
        Queue<ExceptionPassthroughInputStream> queue = POOL;
        synchronized (queue) {
            exceptionPassthroughInputStreamPoll = queue.poll();
        }
        if (exceptionPassthroughInputStreamPoll == null) {
            exceptionPassthroughInputStreamPoll = new ExceptionPassthroughInputStream();
        }
        exceptionPassthroughInputStreamPoll.setInputStream(inputStream);
        return exceptionPassthroughInputStreamPoll;
    }

    static void clearQueue() {
        synchronized (POOL) {
            while (true) {
                Queue<ExceptionPassthroughInputStream> queue = POOL;
                if (!queue.isEmpty()) {
                    queue.remove();
                }
            }
        }
    }

    ExceptionPassthroughInputStream() {
    }

    void setInputStream(InputStream inputStream) {
        this.wrapped = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.wrapped.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.wrapped.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.wrapped.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.wrapped.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.wrapped.read();
        } catch (IOException e) {
            this.exception = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.wrapped.read(bArr);
        } catch (IOException e) {
            this.exception = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.wrapped.read(bArr, i, i2);
        } catch (IOException e) {
            this.exception = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.wrapped.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            return this.wrapped.skip(j);
        } catch (IOException e) {
            this.exception = e;
            throw e;
        }
    }

    public IOException getException() {
        return this.exception;
    }

    public void release() {
        this.exception = null;
        this.wrapped = null;
        Queue<ExceptionPassthroughInputStream> queue = POOL;
        synchronized (queue) {
            queue.offer(this);
        }
    }
}
