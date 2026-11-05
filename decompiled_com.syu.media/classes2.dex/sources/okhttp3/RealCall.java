package okhttp3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.Transmitter;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.Timeout;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class RealCall implements Call {
    final OkHttpClient client;
    private boolean executed;
    final boolean forWebSocket;
    final Request originalRequest;
    private Transmitter transmitter;

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
    }

    static RealCall newRealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, request, z);
        realCall.transmitter = new Transmitter(okHttpClient, realCall);
        return realCall;
    }

    @Override // okhttp3.Call
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.Call
    public Response execute() throws IOException {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.transmitter.timeoutEnter();
        this.transmitter.callStart();
        try {
            this.client.dispatcher().executed(this);
            return getResponseWithInterceptorChain();
        } finally {
            this.client.dispatcher().finished(this);
        }
    }

    @Override // okhttp3.Call
    public void enqueue(Callback callback) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.transmitter.callStart();
        this.client.dispatcher().enqueue(new AsyncCall(callback));
    }

    @Override // okhttp3.Call
    public void cancel() {
        this.transmitter.cancel();
    }

    @Override // okhttp3.Call
    public Timeout timeout() {
        return this.transmitter.timeout();
    }

    @Override // okhttp3.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.transmitter.isCanceled();
    }

    @Override // okhttp3.Call
    public RealCall clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile AtomicInteger callsPerHost;
        private final Callback responseCallback;

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.callsPerHost = new AtomicInteger(0);
            this.responseCallback = callback;
        }

        AtomicInteger callsPerHost() {
            return this.callsPerHost;
        }

        void reuseCallsPerHostFrom(AsyncCall asyncCall) {
            this.callsPerHost = asyncCall.callsPerHost;
        }

        String host() {
            return RealCall.this.originalRequest.url().host();
        }

        Request request() {
            return RealCall.this.originalRequest;
        }

        RealCall get() {
            return RealCall.this;
        }

        void executeOn(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    RealCall.this.transmitter.noMoreExchanges(interruptedIOException);
                    this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                    RealCall.this.client.dispatcher().finished(this);
                }
            } catch (Throwable th) {
                RealCall.this.client.dispatcher().finished(this);
                throw th;
            }
        }

        @Override // okhttp3.internal.NamedRunnable
        protected void execute() {
            RealCall.this.transmitter.timeoutEnter();
            boolean z = false;
            try {
                try {
                    try {
                        this.responseCallback.onResponse(RealCall.this, RealCall.this.getResponseWithInterceptorChain());
                    } catch (IOException e) {
                        e = e;
                        z = true;
                        if (z) {
                            Platform.get().log(4, "Callback failure for " + RealCall.this.toLoggableString(), e);
                        } else {
                            this.responseCallback.onFailure(RealCall.this, e);
                        }
                    } catch (Throwable th) {
                        th = th;
                        z = true;
                        RealCall.this.cancel();
                        if (!z) {
                            IOException iOException = new IOException("canceled due to " + th);
                            iOException.addSuppressed(th);
                            this.responseCallback.onFailure(RealCall.this, iOException);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    RealCall.this.client.dispatcher().finished(this);
                    throw th2;
                }
            } catch (IOException e2) {
                e = e2;
            } catch (Throwable th3) {
                th = th3;
            }
            RealCall.this.client.dispatcher().finished(this);
        }
    }

    String toLoggableString() {
        return (isCanceled() ? "canceled " : "") + (this.forWebSocket ? "web socket" : "call") + " to " + redactedUrl();
    }

    String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x00a6  */
    Response getResponseWithInterceptorChain() throws Throwable {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.client.interceptors());
        arrayList.add(new RetryAndFollowUpInterceptor(this.client));
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.internalCache()));
        arrayList.add(new ConnectInterceptor(this.client));
        if (!this.forWebSocket) {
            arrayList.addAll(this.client.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.forWebSocket));
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(arrayList, this.transmitter, null, 0, this.originalRequest, this, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis());
        boolean z = false;
        try {
            Response responseProceed = realInterceptorChain.proceed(this.originalRequest);
            if (this.transmitter.isCanceled()) {
                Util.closeQuietly(responseProceed);
                throw new IOException("Canceled");
            }
            this.transmitter.noMoreExchanges(null);
            return responseProceed;
        } catch (IOException e) {
            try {
                throw this.transmitter.noMoreExchanges(e);
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    this.transmitter.noMoreExchanges(null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (!z) {
                this.transmitter.noMoreExchanges(null);
            }
            throw th;
        }
    }
}
