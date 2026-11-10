package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Transmitter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Call call;

    @Nullable
    private Object callStackTrace;
    private boolean canceled;
    private final OkHttpClient client;
    public RealConnection connection;
    private final RealConnectionPool connectionPool;
    private final EventListener eventListener;

    @Nullable
    private Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private boolean exchangeRequestDone;
    private boolean exchangeResponseDone;
    private boolean noMoreExchanges;
    private Request request;
    private final AsyncTimeout timeout;
    private boolean timeoutEarlyExit;

    public Transmitter(OkHttpClient okHttpClient, Call call) {
        AsyncTimeout asyncTimeout = new AsyncTimeout() { // from class: okhttp3.internal.connection.Transmitter.1
            @Override // okio.AsyncTimeout
            protected void timedOut() {
                Transmitter.this.cancel();
            }
        };
        this.timeout = asyncTimeout;
        this.client = okHttpClient;
        this.connectionPool = Internal.instance.realConnectionPool(okHttpClient.connectionPool());
        this.call = call;
        this.eventListener = okHttpClient.eventListenerFactory().create(call);
        asyncTimeout.timeout(okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    public Timeout timeout() {
        return this.timeout;
    }

    public void timeoutEnter() {
        this.timeout.enter();
    }

    public void timeoutEarlyExit() {
        if (this.timeoutEarlyExit) {
            throw new IllegalStateException();
        }
        this.timeoutEarlyExit = true;
        this.timeout.exit();
    }

    @Nullable
    private IOException timeoutExit(@Nullable IOException iOException) {
        if (this.timeoutEarlyExit || !this.timeout.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void callStart() {
        this.callStackTrace = Platform.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this.call);
    }

    public void prepareToConnect(Request request) {
        Request request2 = this.request;
        if (request2 != null) {
            if (Util.sameConnection(request2.url(), request.url()) && this.exchangeFinder.hasRouteToTry()) {
                return;
            }
            if (this.exchange != null) {
                throw new IllegalStateException();
            }
            if (this.exchangeFinder != null) {
                maybeReleaseConnection(null, true);
                this.exchangeFinder = null;
            }
        }
        this.request = request;
        this.exchangeFinder = new ExchangeFinder(this, this.connectionPool, createAddress(request.url()), this.call, this.eventListener);
    }

    private Address createAddress(HttpUrl httpUrl) {
        SSLSocketFactory sslSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (httpUrl.isHttps()) {
            sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            certificatePinner = this.client.certificatePinner();
        } else {
            sslSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sslSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    Exchange newExchange(Interceptor.Chain chain, boolean z) {
        synchronized (this.connectionPool) {
            if (this.noMoreExchanges) {
                throw new IllegalStateException("released");
            }
            if (this.exchange != null) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
        }
        Exchange exchange = new Exchange(this, this.call, this.eventListener, this.exchangeFinder, this.exchangeFinder.find(this.client, chain, z));
        synchronized (this.connectionPool) {
            this.exchange = exchange;
            this.exchangeRequestDone = false;
            this.exchangeResponseDone = false;
        }
        return exchange;
    }

    void acquireConnectionNoEvents(RealConnection realConnection) {
        if (this.connection != null) {
            throw new IllegalStateException();
        }
        this.connection = realConnection;
        realConnection.transmitters.add(new TransmitterReference(this, this.callStackTrace));
    }

    @Nullable
    Socket releaseConnectionNoEvents() {
        int size = this.connection.transmitters.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            if (this.connection.transmitters.get(i).get() == this) {
                break;
            }
            i++;
        }
        if (i == -1) {
            throw new IllegalStateException();
        }
        RealConnection realConnection = this.connection;
        realConnection.transmitters.remove(i);
        this.connection = null;
        if (realConnection.transmitters.isEmpty()) {
            realConnection.idleAtNanos = System.nanoTime();
            if (this.connectionPool.connectionBecameIdle(realConnection)) {
                return realConnection.socket();
            }
        }
        return null;
    }

    public void exchangeDoneDueToException() {
        synchronized (this.connectionPool) {
            if (this.noMoreExchanges) {
                throw new IllegalStateException();
            }
            this.exchange = null;
        }
    }

    @Nullable
    IOException exchangeMessageDone(Exchange exchange, boolean z, boolean z2, @Nullable IOException iOException) {
        boolean z3;
        synchronized (this.connectionPool) {
            Exchange exchange2 = this.exchange;
            if (exchange != exchange2) {
                return iOException;
            }
            boolean z4 = true;
            if (z) {
                z3 = !this.exchangeRequestDone;
                this.exchangeRequestDone = true;
            } else {
                z3 = false;
            }
            if (z2) {
                if (!this.exchangeResponseDone) {
                    z3 = true;
                }
                this.exchangeResponseDone = true;
            }
            if (this.exchangeRequestDone && this.exchangeResponseDone && z3) {
                exchange2.connection().successCount++;
                this.exchange = null;
            } else {
                z4 = false;
            }
            return z4 ? maybeReleaseConnection(iOException, false) : iOException;
        }
    }

    @Nullable
    public IOException noMoreExchanges(@Nullable IOException iOException) {
        synchronized (this.connectionPool) {
            this.noMoreExchanges = true;
        }
        return maybeReleaseConnection(iOException, false);
    }

    @Nullable
    private IOException maybeReleaseConnection(@Nullable IOException iOException, boolean z) {
        RealConnection realConnection;
        Socket socketReleaseConnectionNoEvents;
        boolean z2;
        synchronized (this.connectionPool) {
            if (z) {
                if (this.exchange != null) {
                    throw new IllegalStateException("cannot release connection while it is in use");
                }
            }
            realConnection = this.connection;
            socketReleaseConnectionNoEvents = (realConnection != null && this.exchange == null && (z || this.noMoreExchanges)) ? releaseConnectionNoEvents() : null;
            if (this.connection != null) {
                realConnection = null;
            }
            z2 = this.noMoreExchanges && this.exchange == null;
        }
        Util.closeQuietly(socketReleaseConnectionNoEvents);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z2) {
            boolean z3 = iOException != null;
            iOException = timeoutExit(iOException);
            if (z3) {
                this.eventListener.callFailed(this.call, iOException);
            } else {
                this.eventListener.callEnd(this.call);
            }
        }
        return iOException;
    }

    public boolean canRetry() {
        return this.exchangeFinder.hasStreamFailure() && this.exchangeFinder.hasRouteToTry();
    }

    public boolean hasExchange() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.exchange != null;
        }
        return z;
    }

    public void cancel() {
        Exchange exchange;
        RealConnection realConnectionConnectingConnection;
        synchronized (this.connectionPool) {
            this.canceled = true;
            exchange = this.exchange;
            ExchangeFinder exchangeFinder = this.exchangeFinder;
            if (exchangeFinder != null && exchangeFinder.connectingConnection() != null) {
                realConnectionConnectingConnection = this.exchangeFinder.connectingConnection();
            } else {
                realConnectionConnectingConnection = this.connection;
            }
        }
        if (exchange != null) {
            exchange.cancel();
        } else if (realConnectionConnectingConnection != null) {
            realConnectionConnectingConnection.cancel();
        }
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.canceled;
        }
        return z;
    }

    static final class TransmitterReference extends WeakReference<Transmitter> {
        final Object callStackTrace;

        TransmitterReference(Transmitter transmitter, Object obj) {
            super(transmitter);
            this.callStackTrace = obj;
        }
    }
}
