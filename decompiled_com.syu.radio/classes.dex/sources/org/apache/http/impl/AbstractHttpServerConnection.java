package org.apache.http.impl;

import java.io.IOException;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpServerConnection;
import org.apache.http.impl.entity.EntityDeserializer;
import org.apache.http.impl.entity.EntitySerializer;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public abstract class AbstractHttpServerConnection implements HttpServerConnection {
    protected abstract void assertOpen() throws IllegalStateException;

    public AbstractHttpServerConnection() {
        throw new RuntimeException("Stub!");
    }

    protected EntityDeserializer createEntityDeserializer() {
        throw new RuntimeException("Stub!");
    }

    protected EntitySerializer createEntitySerializer() {
        throw new RuntimeException("Stub!");
    }

    protected HttpRequestFactory createHttpRequestFactory() {
        throw new RuntimeException("Stub!");
    }

    protected HttpMessageParser createRequestParser(SessionInputBuffer buffer, HttpRequestFactory requestFactory, HttpParams params) {
        throw new RuntimeException("Stub!");
    }

    protected HttpMessageWriter createResponseWriter(SessionOutputBuffer buffer, HttpParams params) {
        throw new RuntimeException("Stub!");
    }

    protected void init(SessionInputBuffer inbuffer, SessionOutputBuffer outbuffer, HttpParams params) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpServerConnection
    public HttpRequest receiveRequestHeader() throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpServerConnection
    public void receiveRequestEntity(HttpEntityEnclosingRequest request) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    protected void doFlush() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpServerConnection
    public void flush() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpServerConnection
    public void sendResponseHeader(HttpResponse response) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpServerConnection
    public void sendResponseEntity(HttpResponse response) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public boolean isStale() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        throw new RuntimeException("Stub!");
    }
}
