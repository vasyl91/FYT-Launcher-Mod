package org.apache.http.impl.conn;

import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public abstract class AbstractPooledConnAdapter extends AbstractClientConnAdapter {
    protected volatile AbstractPoolEntry poolEntry;

    protected AbstractPooledConnAdapter(ClientConnectionManager manager, AbstractPoolEntry entry) {
        super((ClientConnectionManager) null, (OperatedClientConnection) null);
        throw new RuntimeException("Stub!");
    }

    protected final void assertAttached() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.conn.AbstractClientConnAdapter
    protected void detach() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public HttpRoute getRoute() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void open(HttpRoute route, HttpContext context, HttpParams params) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void tunnelTarget(boolean secure, HttpParams params) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void tunnelProxy(HttpHost next, boolean secure, HttpParams params) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void layerProtocol(HttpContext context, HttpParams params) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public void shutdown() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public Object getState() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void setState(Object state) {
        throw new RuntimeException("Stub!");
    }
}
