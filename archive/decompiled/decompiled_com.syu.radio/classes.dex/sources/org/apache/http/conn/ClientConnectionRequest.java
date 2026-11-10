package org.apache.http.conn;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public interface ClientConnectionRequest {
    void abortRequest();

    ManagedClientConnection getConnection(long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException;
}
