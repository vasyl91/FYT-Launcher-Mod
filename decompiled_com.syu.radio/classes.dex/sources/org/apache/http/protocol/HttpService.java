package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.HttpServerConnection;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class HttpService {
    public HttpService(HttpProcessor proc, ConnectionReuseStrategy connStrategy, HttpResponseFactory responseFactory) {
        throw new RuntimeException("Stub!");
    }

    public void setHttpProcessor(HttpProcessor processor) {
        throw new RuntimeException("Stub!");
    }

    public void setConnReuseStrategy(ConnectionReuseStrategy connStrategy) {
        throw new RuntimeException("Stub!");
    }

    public void setResponseFactory(HttpResponseFactory responseFactory) {
        throw new RuntimeException("Stub!");
    }

    public void setHandlerResolver(HttpRequestHandlerResolver handlerResolver) {
        throw new RuntimeException("Stub!");
    }

    public void setExpectationVerifier(HttpExpectationVerifier expectationVerifier) {
        throw new RuntimeException("Stub!");
    }

    public HttpParams getParams() {
        throw new RuntimeException("Stub!");
    }

    public void setParams(HttpParams params) {
        throw new RuntimeException("Stub!");
    }

    public void handleRequest(HttpServerConnection conn, HttpContext context) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    protected void handleException(HttpException ex, HttpResponse response) {
        throw new RuntimeException("Stub!");
    }

    protected void doService(HttpRequest request, HttpResponse response, HttpContext context) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }
}
