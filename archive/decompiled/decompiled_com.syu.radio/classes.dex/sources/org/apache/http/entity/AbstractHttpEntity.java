package org.apache.http.entity;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public abstract class AbstractHttpEntity implements HttpEntity {
    protected boolean chunked;
    protected Header contentEncoding;
    protected Header contentType;

    protected AbstractHttpEntity() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentType() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public boolean isChunked() {
        throw new RuntimeException("Stub!");
    }

    public void setContentType(Header contentType) {
        throw new RuntimeException("Stub!");
    }

    public void setContentType(String ctString) {
        throw new RuntimeException("Stub!");
    }

    public void setContentEncoding(Header contentEncoding) {
        throw new RuntimeException("Stub!");
    }

    public void setContentEncoding(String ceString) {
        throw new RuntimeException("Stub!");
    }

    public void setChunked(boolean b) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public void consumeContent() throws UnsupportedOperationException, IOException {
        throw new RuntimeException("Stub!");
    }
}
