package android.net.http;

import android.content.ContentResolver;
import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public final class AndroidHttpClient implements HttpClient {
    public static long DEFAULT_SYNC_MIN_GZIP_BYTES;

    AndroidHttpClient() {
        throw new RuntimeException("Stub!");
    }

    public static AndroidHttpClient newInstance(String userAgent, Context context) {
        throw new RuntimeException("Stub!");
    }

    public static AndroidHttpClient newInstance(String userAgent) {
        throw new RuntimeException("Stub!");
    }

    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    public static void modifyRequestToAcceptGzipResponse(HttpRequest request) {
        throw new RuntimeException("Stub!");
    }

    public static InputStream getUngzippedContent(HttpEntity entity) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void close() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public HttpParams getParams() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public ClientConnectionManager getConnectionManager() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpUriRequest request) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpUriRequest request, HttpContext context) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpHost target, HttpRequest request) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpHost target, HttpRequest request, HttpContext context) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpHost target, HttpRequest request, ResponseHandler<? extends T> responseHandler) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpHost target, HttpRequest request, ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public static AbstractHttpEntity getCompressedEntity(byte[] data, ContentResolver resolver) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public static long getMinGzipSize(ContentResolver resolver) {
        throw new RuntimeException("Stub!");
    }

    public void enableCurlLogging(String name, int level) {
        throw new RuntimeException("Stub!");
    }

    public void disableCurlLogging() {
        throw new RuntimeException("Stub!");
    }

    public static long parseDate(String dateString) {
        throw new RuntimeException("Stub!");
    }
}
