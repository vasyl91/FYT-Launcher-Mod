package org.apache.http.impl.conn.tsccm;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class ConnPoolByRoute extends AbstractConnPool {
    protected Queue<BasicPoolEntry> freeConnections;
    protected final int maxTotalConnections;
    protected final ClientConnectionOperator operator;
    protected final Map<HttpRoute, RouteSpecificPool> routeToPool;
    protected Queue<WaitingThread> waitingThreads;

    public ConnPoolByRoute(ClientConnectionOperator operator, HttpParams params) {
        throw new RuntimeException("Stub!");
    }

    protected Queue<BasicPoolEntry> createFreeConnQueue() {
        throw new RuntimeException("Stub!");
    }

    protected Queue<WaitingThread> createWaitingThreadQueue() {
        throw new RuntimeException("Stub!");
    }

    protected Map<HttpRoute, RouteSpecificPool> createRouteToPoolMap() {
        throw new RuntimeException("Stub!");
    }

    protected RouteSpecificPool newRouteSpecificPool(HttpRoute route) {
        throw new RuntimeException("Stub!");
    }

    protected WaitingThread newWaitingThread(Condition cond, RouteSpecificPool rospl) {
        throw new RuntimeException("Stub!");
    }

    protected RouteSpecificPool getRoutePool(HttpRoute route, boolean create) {
        throw new RuntimeException("Stub!");
    }

    public int getConnectionsInPool(HttpRoute route) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.conn.tsccm.AbstractConnPool
    public PoolEntryRequest requestPoolEntry(HttpRoute route, Object state) {
        throw new RuntimeException("Stub!");
    }

    protected BasicPoolEntry getEntryBlocking(HttpRoute route, Object state, long timeout, TimeUnit tunit, WaitingThreadAborter aborter) throws ConnectionPoolTimeoutException, InterruptedException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.conn.tsccm.AbstractConnPool
    public void freeEntry(BasicPoolEntry entry, boolean reusable, long validDuration, TimeUnit timeUnit) {
        throw new RuntimeException("Stub!");
    }

    protected BasicPoolEntry getFreeEntry(RouteSpecificPool rospl, Object state) {
        throw new RuntimeException("Stub!");
    }

    protected BasicPoolEntry createEntry(RouteSpecificPool rospl, ClientConnectionOperator op) {
        throw new RuntimeException("Stub!");
    }

    protected void deleteEntry(BasicPoolEntry entry) {
        throw new RuntimeException("Stub!");
    }

    protected void deleteLeastUsedEntry() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.conn.tsccm.AbstractConnPool
    protected void handleLostEntry(HttpRoute route) {
        throw new RuntimeException("Stub!");
    }

    protected void notifyWaitingThread(RouteSpecificPool rospl) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.conn.tsccm.AbstractConnPool
    public void deleteClosedConnections() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.conn.tsccm.AbstractConnPool
    public void shutdown() {
        throw new RuntimeException("Stub!");
    }
}
