package org.apache.http.impl.conn.tsccm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.IdleConnectionHandler;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public abstract class AbstractConnPool implements RefQueueHandler {
    protected IdleConnectionHandler idleConnHandler;
    protected volatile boolean isShutDown;
    protected Set<BasicPoolEntryRef> issuedConnections;
    protected int numConnections;
    protected final Lock poolLock;
    protected ReferenceQueue<Object> refQueue;

    public abstract void deleteClosedConnections();

    public abstract void freeEntry(BasicPoolEntry basicPoolEntry, boolean z, long j, TimeUnit timeUnit);

    protected abstract void handleLostEntry(HttpRoute httpRoute);

    public abstract PoolEntryRequest requestPoolEntry(HttpRoute httpRoute, Object obj);

    protected AbstractConnPool() {
        throw new RuntimeException("Stub!");
    }

    public void enableConnectionGC() throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    public final BasicPoolEntry getEntry(HttpRoute route, Object state, long timeout, TimeUnit tunit) throws ConnectionPoolTimeoutException, InterruptedException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.conn.tsccm.RefQueueHandler
    public void handleReference(Reference ref) {
        throw new RuntimeException("Stub!");
    }

    public void closeIdleConnections(long idletime, TimeUnit tunit) {
        throw new RuntimeException("Stub!");
    }

    public void closeExpiredConnections() {
        throw new RuntimeException("Stub!");
    }

    public void shutdown() {
        throw new RuntimeException("Stub!");
    }

    protected void closeConnection(OperatedClientConnection conn) {
        throw new RuntimeException("Stub!");
    }
}
