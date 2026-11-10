package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.Transmitter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class RealInterceptorChain implements Interceptor.Chain {
    private final Call call;
    private int calls;
    private final int connectTimeout;

    @Nullable
    private final Exchange exchange;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeout;
    private final Request request;
    private final Transmitter transmitter;
    private final int writeTimeout;

    public RealInterceptorChain(List<Interceptor> list, Transmitter transmitter, @Nullable Exchange exchange, int i, Request request, Call call, int i2, int i3, int i4) {
        this.interceptors = list;
        this.transmitter = transmitter;
        this.exchange = exchange;
        this.index = i;
        this.request = request;
        this.call = call;
        this.connectTimeout = i2;
        this.readTimeout = i3;
        this.writeTimeout = i4;
    }

    @Override // okhttp3.Interceptor.Chain
    @Nullable
    public Connection connection() {
        Exchange exchange = this.exchange;
        if (exchange != null) {
            return exchange.connection();
        }
        return null;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, Util.checkDuration("timeout", i, timeUnit), this.readTimeout, this.writeTimeout);
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, this.connectTimeout, Util.checkDuration("timeout", i, timeUnit), this.writeTimeout);
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, this.connectTimeout, this.readTimeout, Util.checkDuration("timeout", i, timeUnit));
    }

    public Transmitter transmitter() {
        return this.transmitter;
    }

    public Exchange exchange() {
        Exchange exchange = this.exchange;
        if (exchange != null) {
            return exchange;
        }
        throw new IllegalStateException();
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // okhttp3.Interceptor.Chain
    public Request request() {
        return this.request;
    }

    @Override // okhttp3.Interceptor.Chain
    public Response proceed(Request request) throws IOException {
        return proceed(request, this.transmitter, this.exchange);
    }

    public Response proceed(Request request, Transmitter transmitter, @Nullable Exchange exchange) throws IOException {
        if (this.index >= this.interceptors.size()) {
            throw new AssertionError();
        }
        this.calls++;
        Exchange exchange2 = this.exchange;
        if (exchange2 != null && !exchange2.connection().supportsUrl(request.url())) {
            throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port");
        }
        if (this.exchange != null && this.calls > 1) {
            throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once");
        }
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, transmitter, exchange, this.index + 1, request, this.call, this.connectTimeout, this.readTimeout, this.writeTimeout);
        Interceptor interceptor = this.interceptors.get(this.index);
        Response responseIntercept = interceptor.intercept(realInterceptorChain);
        if (exchange != null && this.index + 1 < this.interceptors.size() && realInterceptorChain.calls != 1) {
            throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
        }
        if (responseIntercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (responseIntercept.body() != null) {
            return responseIntercept;
        }
        throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
    }
}
