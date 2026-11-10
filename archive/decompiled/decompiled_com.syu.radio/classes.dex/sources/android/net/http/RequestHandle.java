package android.net.http;

import android.net.compatibility.WebAddress;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class RequestHandle {
    public static final int MAX_REDIRECT_COUNT = 16;

    public RequestHandle(RequestQueue requestQueue, String url, WebAddress uri, String method, Map<String, String> headers, InputStream bodyProvider, int bodyLength, Request request) {
        throw new RuntimeException("Stub!");
    }

    public RequestHandle(RequestQueue requestQueue, String url, WebAddress uri, String method, Map<String, String> headers, InputStream bodyProvider, int bodyLength, Request request, Connection conn) {
        throw new RuntimeException("Stub!");
    }

    public void cancel() {
        throw new RuntimeException("Stub!");
    }

    public void pauseRequest(boolean pause) {
        throw new RuntimeException("Stub!");
    }

    public void handleSslErrorResponse(boolean proceed) {
        throw new RuntimeException("Stub!");
    }

    public boolean isRedirectMax() {
        throw new RuntimeException("Stub!");
    }

    public int getRedirectCount() {
        throw new RuntimeException("Stub!");
    }

    public void setRedirectCount(int count) {
        throw new RuntimeException("Stub!");
    }

    public boolean setupRedirect(String redirectTo, int statusCode, Map<String, String> cacheHeaders) {
        throw new RuntimeException("Stub!");
    }

    public void setupBasicAuthResponse(boolean isProxy, String username, String password) {
        throw new RuntimeException("Stub!");
    }

    public void setupDigestAuthResponse(boolean isProxy, String username, String password, String realm, String nonce, String QOP, String algorithm, String opaque) {
        throw new RuntimeException("Stub!");
    }

    public String getMethod() {
        throw new RuntimeException("Stub!");
    }

    public static String computeBasicAuthResponse(String username, String password) {
        throw new RuntimeException("Stub!");
    }

    public void waitUntilComplete() {
        throw new RuntimeException("Stub!");
    }

    public void processRequest() {
        throw new RuntimeException("Stub!");
    }

    public static String authorizationHeader(boolean isProxy) {
        throw new RuntimeException("Stub!");
    }
}
