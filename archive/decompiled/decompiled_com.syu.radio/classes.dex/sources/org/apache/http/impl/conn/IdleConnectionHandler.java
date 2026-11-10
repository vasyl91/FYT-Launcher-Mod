package org.apache.http.impl.conn;

import java.util.concurrent.TimeUnit;
import org.apache.http.HttpConnection;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class IdleConnectionHandler {
    public IdleConnectionHandler() {
        throw new RuntimeException("Stub!");
    }

    public void add(HttpConnection connection, long validDuration, TimeUnit unit) {
        throw new RuntimeException("Stub!");
    }

    public boolean remove(HttpConnection connection) {
        throw new RuntimeException("Stub!");
    }

    public void removeAll() {
        throw new RuntimeException("Stub!");
    }

    public void closeIdleConnections(long idleTime) {
        throw new RuntimeException("Stub!");
    }

    public void closeExpiredConnections() {
        throw new RuntimeException("Stub!");
    }
}
