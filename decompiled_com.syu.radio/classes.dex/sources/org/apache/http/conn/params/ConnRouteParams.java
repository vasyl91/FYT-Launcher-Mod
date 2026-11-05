package org.apache.http.conn.params;

import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class ConnRouteParams implements ConnRoutePNames {
    public static final HttpHost NO_HOST = null;
    public static final HttpRoute NO_ROUTE = null;

    ConnRouteParams() {
        throw new RuntimeException("Stub!");
    }

    public static HttpHost getDefaultProxy(HttpParams params) {
        throw new RuntimeException("Stub!");
    }

    public static void setDefaultProxy(HttpParams params, HttpHost proxy) {
        throw new RuntimeException("Stub!");
    }

    public static HttpRoute getForcedRoute(HttpParams params) {
        throw new RuntimeException("Stub!");
    }

    public static void setForcedRoute(HttpParams params, HttpRoute route) {
        throw new RuntimeException("Stub!");
    }

    public static InetAddress getLocalAddress(HttpParams params) {
        throw new RuntimeException("Stub!");
    }

    public static void setLocalAddress(HttpParams params, InetAddress local) {
        throw new RuntimeException("Stub!");
    }
}
