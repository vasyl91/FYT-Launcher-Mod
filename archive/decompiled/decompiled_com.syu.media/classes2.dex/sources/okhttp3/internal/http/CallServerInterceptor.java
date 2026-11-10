package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okio.BufferedSink;
import okio.Okio;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        Response responseBuild;
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Exchange exchange = realInterceptorChain.exchange();
        Request request = realInterceptorChain.request();
        long jCurrentTimeMillis = System.currentTimeMillis();
        exchange.writeRequestHeaders(request);
        Response.Builder responseHeaders = null;
        if (HttpMethod.permitsRequestBody(request.method()) && request.body() != null) {
            if ("100-continue".equalsIgnoreCase(request.header("Expect"))) {
                exchange.flushRequest();
                exchange.responseHeadersStart();
                responseHeaders = exchange.readResponseHeaders(true);
                z = true;
            } else {
                z = false;
            }
            if (responseHeaders == null) {
                if (request.body().isDuplex()) {
                    exchange.flushRequest();
                    request.body().writeTo(Okio.buffer(exchange.createRequestBody(request, true)));
                } else {
                    BufferedSink bufferedSinkBuffer = Okio.buffer(exchange.createRequestBody(request, false));
                    request.body().writeTo(bufferedSinkBuffer);
                    bufferedSinkBuffer.close();
                }
            } else {
                exchange.noRequestBody();
                if (!exchange.connection().isMultiplexed()) {
                    exchange.noNewExchangesOnConnection();
                }
            }
        } else {
            exchange.noRequestBody();
            z = false;
        }
        if (request.body() == null || !request.body().isDuplex()) {
            exchange.finishRequest();
        }
        if (!z) {
            exchange.responseHeadersStart();
        }
        if (responseHeaders == null) {
            responseHeaders = exchange.readResponseHeaders(false);
        }
        Response responseBuild2 = responseHeaders.request(request).handshake(exchange.connection().handshake()).sentRequestAtMillis(jCurrentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int iCode = responseBuild2.code();
        if (iCode == 100) {
            responseBuild2 = exchange.readResponseHeaders(false).request(request).handshake(exchange.connection().handshake()).sentRequestAtMillis(jCurrentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            iCode = responseBuild2.code();
        }
        exchange.responseHeadersEnd(responseBuild2);
        if (this.forWebSocket && iCode == 101) {
            responseBuild = responseBuild2.newBuilder().body(Util.EMPTY_RESPONSE).build();
        } else {
            responseBuild = responseBuild2.newBuilder().body(exchange.openResponseBody(responseBuild2)).build();
        }
        if ("close".equalsIgnoreCase(responseBuild.request().header("Connection")) || "close".equalsIgnoreCase(responseBuild.header("Connection"))) {
            exchange.noNewExchangesOnConnection();
        }
        if ((iCode == 204 || iCode == 205) && responseBuild.body().contentLength() > 0) {
            throw new ProtocolException("HTTP " + iCode + " had non-zero Content-Length: " + responseBuild.body().contentLength());
        }
        return responseBuild;
    }
}
