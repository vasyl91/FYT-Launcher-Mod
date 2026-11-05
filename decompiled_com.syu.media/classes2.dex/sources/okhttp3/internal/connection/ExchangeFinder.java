package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.http.ExchangeCodec;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class ExchangeFinder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Address address;
    private final Call call;
    private RealConnection connectingConnection;
    private final RealConnectionPool connectionPool;
    private final EventListener eventListener;
    private boolean hasStreamFailure;
    private Route nextRouteToTry;
    private RouteSelector.Selection routeSelection;
    private final RouteSelector routeSelector;
    private final Transmitter transmitter;

    ExchangeFinder(Transmitter transmitter, RealConnectionPool realConnectionPool, Address address, Call call, EventListener eventListener) {
        this.transmitter = transmitter;
        this.connectionPool = realConnectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
        this.routeSelector = new RouteSelector(address, realConnectionPool.routeDatabase, call, eventListener);
    }

    public ExchangeCodec find(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        try {
            return findHealthyConnection(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).newCodec(okHttpClient, chain);
        } catch (IOException e) {
            trackFailure();
            throw new RouteException(e);
        } catch (RouteException e2) {
            trackFailure();
            throw e2;
        }
    }

    private RealConnection findHealthyConnection(int i, int i2, int i3, int i4, boolean z, boolean z2) throws Throwable {
        while (true) {
            RealConnection realConnectionFindConnection = findConnection(i, i2, i3, i4, z);
            synchronized (this.connectionPool) {
                if (realConnectionFindConnection.successCount == 0 && !realConnectionFindConnection.isMultiplexed()) {
                    return realConnectionFindConnection;
                }
                if (realConnectionFindConnection.isHealthy(z2)) {
                    return realConnectionFindConnection;
                }
                realConnectionFindConnection.noNewExchanges();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0066  */
    private RealConnection findConnection(int i, int i2, int i3, int i4, boolean z) throws Throwable {
        Socket socket;
        Socket socketReleaseConnectionNoEvents;
        RealConnection realConnection;
        RealConnection realConnection2;
        boolean z2;
        Route next;
        boolean z3;
        List<Route> all;
        RouteSelector.Selection selection;
        synchronized (this.connectionPool) {
            if (this.transmitter.isCanceled()) {
                throw new IOException("Canceled");
            }
            this.hasStreamFailure = false;
            RealConnection realConnection3 = this.transmitter.connection;
            socket = null;
            socketReleaseConnectionNoEvents = (this.transmitter.connection == null || !this.transmitter.connection.noNewExchanges) ? null : this.transmitter.releaseConnectionNoEvents();
            if (this.transmitter.connection != null) {
                realConnection2 = this.transmitter.connection;
                realConnection = null;
            } else {
                realConnection = realConnection3;
                realConnection2 = null;
            }
            if (realConnection2 != null) {
                z2 = false;
                next = null;
            } else if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, null, false)) {
                realConnection2 = this.transmitter.connection;
                next = null;
                z2 = true;
            } else {
                next = this.nextRouteToTry;
                if (next != null) {
                    this.nextRouteToTry = null;
                } else if (retryCurrentRoute()) {
                    next = this.transmitter.connection.route();
                } else {
                    z2 = false;
                    next = null;
                }
                z2 = false;
            }
        }
        Util.closeQuietly(socketReleaseConnectionNoEvents);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
        }
        if (realConnection2 != null) {
            return realConnection2;
        }
        if (next != null || ((selection = this.routeSelection) != null && selection.hasNext())) {
            z3 = false;
        } else {
            this.routeSelection = this.routeSelector.next();
            z3 = true;
        }
        synchronized (this.connectionPool) {
            if (this.transmitter.isCanceled()) {
                throw new IOException("Canceled");
            }
            if (z3) {
                all = this.routeSelection.getAll();
                if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, all, false)) {
                    realConnection2 = this.transmitter.connection;
                    z2 = true;
                }
            } else {
                all = null;
            }
            if (!z2) {
                if (next == null) {
                    next = this.routeSelection.next();
                }
                realConnection2 = new RealConnection(this.connectionPool, next);
                this.connectingConnection = realConnection2;
            }
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
            return realConnection2;
        }
        realConnection2.connect(i, i2, i3, i4, z, this.call, this.eventListener);
        this.connectionPool.routeDatabase.connected(realConnection2.route());
        synchronized (this.connectionPool) {
            this.connectingConnection = null;
            if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, all, true)) {
                realConnection2.noNewExchanges = true;
                socket = realConnection2.socket();
                realConnection2 = this.transmitter.connection;
                this.nextRouteToTry = next;
            } else {
                this.connectionPool.put(realConnection2);
                this.transmitter.acquireConnectionNoEvents(realConnection2);
            }
        }
        Util.closeQuietly(socket);
        this.eventListener.connectionAcquired(this.call, realConnection2);
        return realConnection2;
    }

    RealConnection connectingConnection() {
        return this.connectingConnection;
    }

    void trackFailure() {
        synchronized (this.connectionPool) {
            this.hasStreamFailure = true;
        }
    }

    boolean hasStreamFailure() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.hasStreamFailure;
        }
        return z;
    }

    boolean hasRouteToTry() {
        synchronized (this.connectionPool) {
            boolean z = true;
            if (this.nextRouteToTry != null) {
                return true;
            }
            if (retryCurrentRoute()) {
                this.nextRouteToTry = this.transmitter.connection.route();
                return true;
            }
            RouteSelector.Selection selection = this.routeSelection;
            if ((selection == null || !selection.hasNext()) && !this.routeSelector.hasNext()) {
                z = false;
            }
            return z;
        }
    }

    private boolean retryCurrentRoute() {
        return this.transmitter.connection != null && this.transmitter.connection.routeFailureCount == 0 && Util.sameConnection(this.transmitter.connection.route().address().url(), this.address.url());
    }
}
