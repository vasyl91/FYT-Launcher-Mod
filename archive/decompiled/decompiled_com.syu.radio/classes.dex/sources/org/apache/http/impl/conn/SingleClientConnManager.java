package org.apache.http.impl.conn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class SingleClientConnManager implements ClientConnectionManager {
    public static final String MISUSE_MESSAGE = "Invalid use of SingleClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.";
    protected boolean alwaysShutDown;
    protected ClientConnectionOperator connOperator;
    protected long connectionExpiresTime;
    protected volatile boolean isShutDown;
    protected long lastReleaseTime;
    protected ConnAdapter managedConn;
    protected SchemeRegistry schemeRegistry;
    protected PoolEntry uniquePoolEntry;

    protected class PoolEntry extends AbstractPoolEntry {
        protected PoolEntry() {
            super((ClientConnectionOperator) null, (HttpRoute) null);
            throw new RuntimeException("Stub!");
        }

        protected void close() throws IOException {
            throw new RuntimeException("Stub!");
        }

        protected void shutdown() throws IOException {
            throw new RuntimeException("Stub!");
        }
    }

    protected class ConnAdapter extends AbstractPooledConnAdapter {
        protected ConnAdapter(PoolEntry entry, HttpRoute route) {
            super((ClientConnectionManager) null, (AbstractPoolEntry) null);
            throw new RuntimeException("Stub!");
        }
    }

    public SingleClientConnManager(HttpParams params, SchemeRegistry schreg) {
        throw new RuntimeException("Stub!");
    }

    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ClientConnectionManager
    public SchemeRegistry getSchemeRegistry() {
        throw new RuntimeException("Stub!");
    }

    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry schreg) {
        throw new RuntimeException("Stub!");
    }

    protected final void assertStillUp() throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ClientConnectionManager
    public final ClientConnectionRequest requestConnection(HttpRoute route, Object state) {
        throw new RuntimeException("Stub!");
    }

    public ManagedClientConnection getConnection(HttpRoute route, Object state) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ClientConnectionManager
    public void releaseConnection(ManagedClientConnection conn, long validDuration, TimeUnit timeUnit) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ClientConnectionManager
    public void closeExpiredConnections() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ClientConnectionManager
    public void closeIdleConnections(long idletime, TimeUnit tunit) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ClientConnectionManager
    public void shutdown() {
        throw new RuntimeException("Stub!");
    }

    protected void revokeConnection() {
        throw new RuntimeException("Stub!");
    }
}
