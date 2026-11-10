package org.apache.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.io.SessionOutputBuffer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class ChunkedOutputStream extends OutputStream {
    public ChunkedOutputStream(SessionOutputBuffer out, int bufferSize) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public ChunkedOutputStream(SessionOutputBuffer out) throws IOException {
        throw new RuntimeException("Stub!");
    }

    protected void flushCache() throws IOException {
        throw new RuntimeException("Stub!");
    }

    protected void flushCacheWithAppend(byte[] bufferToAppend, int off, int len) throws IOException {
        throw new RuntimeException("Stub!");
    }

    protected void writeClosingChunk() throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void finish() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.OutputStream
    public void write(byte[] b) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.OutputStream
    public void write(byte[] src, int off, int len) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }
}
