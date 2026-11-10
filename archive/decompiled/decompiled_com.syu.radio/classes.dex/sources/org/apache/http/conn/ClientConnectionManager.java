package org.apache.http.conn;

import java.util.concurrent.TimeUnit;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public interface ClientConnectionManager {
    void closeExpiredConnections();

    void closeIdleConnections(long j, TimeUnit timeUnit);

    SchemeRegistry getSchemeRegistry();

    void releaseConnection(ManagedClientConnection managedClientConnection, long j, TimeUnit timeUnit);

    ClientConnectionRequest requestConnection(HttpRoute httpRoute, Object obj);

    void shutdown();
}
