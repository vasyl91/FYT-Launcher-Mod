package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpMessage;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public abstract class AbstractHttpMessage implements HttpMessage {
    protected HeaderGroup headergroup;
    protected HttpParams params;

    protected AbstractHttpMessage(HttpParams params) {
        throw new RuntimeException("Stub!");
    }

    protected AbstractHttpMessage() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public boolean containsHeader(String name) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public Header[] getHeaders(String name) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public Header getFirstHeader(String name) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public Header getLastHeader(String name) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public Header[] getAllHeaders() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public void addHeader(Header header) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public void addHeader(String name, String value) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public void setHeader(Header header) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public void setHeader(String name, String value) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public void setHeaders(Header[] headers) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public void removeHeader(Header header) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public void removeHeaders(String name) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public HeaderIterator headerIterator() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public HeaderIterator headerIterator(String name) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public HttpParams getParams() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public void setParams(HttpParams params) {
        throw new RuntimeException("Stub!");
    }
}
