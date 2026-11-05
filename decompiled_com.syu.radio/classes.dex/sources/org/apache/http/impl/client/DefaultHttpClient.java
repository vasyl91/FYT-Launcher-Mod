package org.apache.http.impl.client;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestExecutor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class DefaultHttpClient extends AbstractHttpClient {
    public DefaultHttpClient(ClientConnectionManager conman, HttpParams params) {
        super((ClientConnectionManager) null, (HttpParams) null);
        throw new RuntimeException("Stub!");
    }

    public DefaultHttpClient(HttpParams params) {
        super((ClientConnectionManager) null, (HttpParams) null);
        throw new RuntimeException("Stub!");
    }

    public DefaultHttpClient() {
        super((ClientConnectionManager) null, (HttpParams) null);
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected HttpParams createHttpParams() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected HttpRequestExecutor createRequestExecutor() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected ClientConnectionManager createClientConnectionManager() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected HttpContext createHttpContext() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected ConnectionReuseStrategy createConnectionReuseStrategy() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected AuthSchemeRegistry createAuthSchemeRegistry() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected CookieSpecRegistry createCookieSpecRegistry() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected BasicHttpProcessor createHttpProcessor() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected HttpRequestRetryHandler createHttpRequestRetryHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected RedirectHandler createRedirectHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected AuthenticationHandler createTargetAuthenticationHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected AuthenticationHandler createProxyAuthenticationHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected CookieStore createCookieStore() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected CredentialsProvider createCredentialsProvider() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected HttpRoutePlanner createHttpRoutePlanner() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected UserTokenHandler createUserTokenHandler() {
        throw new RuntimeException("Stub!");
    }
}
