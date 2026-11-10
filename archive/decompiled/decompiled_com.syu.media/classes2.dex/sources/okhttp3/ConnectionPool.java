package okhttp3;

import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.RealConnectionPool;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ConnectionPool {
    final RealConnectionPool delegate;

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public ConnectionPool(int i, long j, TimeUnit timeUnit) {
        this.delegate = new RealConnectionPool(i, j, timeUnit);
    }

    public int idleConnectionCount() {
        return this.delegate.idleConnectionCount();
    }

    public int connectionCount() {
        return this.delegate.connectionCount();
    }

    public void evictAll() {
        this.delegate.evictAll();
    }
}
