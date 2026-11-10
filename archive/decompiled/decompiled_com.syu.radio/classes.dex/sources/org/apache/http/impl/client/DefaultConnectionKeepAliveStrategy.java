package org.apache.http.impl.client;

import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class DefaultConnectionKeepAliveStrategy implements ConnectionKeepAliveStrategy {
    public DefaultConnectionKeepAliveStrategy() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ConnectionKeepAliveStrategy
    public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
        throw new RuntimeException("Stub!");
    }
}
