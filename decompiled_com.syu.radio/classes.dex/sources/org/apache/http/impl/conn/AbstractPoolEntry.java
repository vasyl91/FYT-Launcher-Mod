package org.apache.http.impl.conn;

import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public abstract class AbstractPoolEntry {
    protected final ClientConnectionOperator connOperator;
    protected final OperatedClientConnection connection;
    protected volatile HttpRoute route;
    protected volatile Object state;
    protected volatile RouteTracker tracker;

    protected AbstractPoolEntry(ClientConnectionOperator connOperator, HttpRoute route) {
        throw new RuntimeException("Stub!");
    }

    public Object getState() {
        throw new RuntimeException("Stub!");
    }

    public void setState(Object state) {
        throw new RuntimeException("Stub!");
    }

    public void open(HttpRoute route, HttpContext context, HttpParams params) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void tunnelTarget(boolean secure, HttpParams params) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void tunnelProxy(HttpHost next, boolean secure, HttpParams params) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void layerProtocol(HttpContext context, HttpParams params) throws IOException {
        throw new RuntimeException("Stub!");
    }

    protected void shutdownEntry() {
        throw new RuntimeException("Stub!");
    }
}
