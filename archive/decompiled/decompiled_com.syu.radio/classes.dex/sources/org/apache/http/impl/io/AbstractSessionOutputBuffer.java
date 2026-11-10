package org.apache.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public abstract class AbstractSessionOutputBuffer implements SessionOutputBuffer {
    public AbstractSessionOutputBuffer() {
        throw new RuntimeException("Stub!");
    }

    protected void init(OutputStream outstream, int buffersize, HttpParams params) {
        throw new RuntimeException("Stub!");
    }

    protected void flushBuffer() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void flush() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(byte[] b, int off, int len) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(byte[] b) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(int b) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void writeLine(String s) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void writeLine(CharArrayBuffer s) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public HttpTransportMetrics getMetrics() {
        throw new RuntimeException("Stub!");
    }
}
