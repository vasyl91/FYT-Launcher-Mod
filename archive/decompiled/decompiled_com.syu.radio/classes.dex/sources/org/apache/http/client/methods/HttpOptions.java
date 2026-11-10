package org.apache.http.client.methods;

import java.net.URI;
import java.util.Set;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class HttpOptions extends HttpRequestBase {
    public static final String METHOD_NAME = "OPTIONS";

    public HttpOptions() {
        throw new RuntimeException("Stub!");
    }

    public HttpOptions(URI uri) {
        throw new RuntimeException("Stub!");
    }

    public HttpOptions(String uri) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
    public String getMethod() {
        throw new RuntimeException("Stub!");
    }

    public Set<String> getAllowedMethods(HttpResponse response) {
        throw new RuntimeException("Stub!");
    }
}
