package android.net.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.HttpConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpRequest;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class AndroidHttpClientConnection implements HttpInetConnection, HttpConnection {
    public AndroidHttpClientConnection() {
        throw new RuntimeException("Stub!");
    }

    public void bind(Socket socket, HttpParams params) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public boolean isOpen() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getLocalAddress() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpInetConnection
    public int getLocalPort() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getRemoteAddress() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpInetConnection
    public int getRemotePort() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public void setSocketTimeout(int timeout) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public int getSocketTimeout() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public void shutdown() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void sendRequestHeader(HttpRequest request) throws org.apache.http.HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    public void sendRequestEntity(HttpEntityEnclosingRequest request) throws org.apache.http.HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    protected void doFlush() throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void flush() throws IOException {
        throw new RuntimeException("Stub!");
    }

    public StatusLine parseResponseHeader(Headers headers) throws ParseException, IOException {
        throw new RuntimeException("Stub!");
    }

    public HttpEntity receiveResponseEntity(Headers headers) {
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
