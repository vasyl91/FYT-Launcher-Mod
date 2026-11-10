package org.apache.http.impl.conn;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.impl.SocketHttpClientConnection;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class DefaultClientConnection extends SocketHttpClientConnection implements OperatedClientConnection {
    public DefaultClientConnection() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.OperatedClientConnection
    public final HttpHost getTargetHost() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.OperatedClientConnection
    public final boolean isSecure() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.SocketHttpClientConnection, org.apache.http.conn.OperatedClientConnection
    public final Socket getSocket() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.OperatedClientConnection
    public void opening(Socket sock, HttpHost target) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.OperatedClientConnection
    public void openCompleted(boolean secure, HttpParams params) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.SocketHttpClientConnection, org.apache.http.HttpConnection
    public void shutdown() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.SocketHttpClientConnection, org.apache.http.HttpConnection
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.SocketHttpClientConnection
    protected SessionInputBuffer createSessionInputBuffer(Socket socket, int buffersize, HttpParams params) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.SocketHttpClientConnection
    protected SessionOutputBuffer createSessionOutputBuffer(Socket socket, int buffersize, HttpParams params) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.AbstractHttpClientConnection
    protected HttpMessageParser createResponseParser(SessionInputBuffer buffer, HttpResponseFactory responseFactory, HttpParams params) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.OperatedClientConnection
    public void update(Socket sock, HttpHost target, boolean secure, HttpParams params) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.AbstractHttpClientConnection, org.apache.http.HttpClientConnection
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.AbstractHttpClientConnection, org.apache.http.HttpClientConnection
    public void sendRequestHeader(HttpRequest request) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }
}
