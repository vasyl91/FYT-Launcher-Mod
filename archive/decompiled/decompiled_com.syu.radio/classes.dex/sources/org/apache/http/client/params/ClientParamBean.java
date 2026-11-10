package org.apache.http.client.params;

import java.util.Collection;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.conn.ClientConnectionManagerFactory;
import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class ClientParamBean extends HttpAbstractParamBean {
    public ClientParamBean(HttpParams params) {
        super((HttpParams) null);
        throw new RuntimeException("Stub!");
    }

    public void setConnectionManagerFactoryClassName(String factory) {
        throw new RuntimeException("Stub!");
    }

    public void setConnectionManagerFactory(ClientConnectionManagerFactory factory) {
        throw new RuntimeException("Stub!");
    }

    public void setHandleRedirects(boolean handle) {
        throw new RuntimeException("Stub!");
    }

    public void setRejectRelativeRedirect(boolean reject) {
        throw new RuntimeException("Stub!");
    }

    public void setMaxRedirects(int maxRedirects) {
        throw new RuntimeException("Stub!");
    }

    public void setAllowCircularRedirects(boolean allow) {
        throw new RuntimeException("Stub!");
    }

    public void setHandleAuthentication(boolean handle) {
        throw new RuntimeException("Stub!");
    }

    public void setCookiePolicy(String policy) {
        throw new RuntimeException("Stub!");
    }

    public void setVirtualHost(HttpHost host) {
        throw new RuntimeException("Stub!");
    }

    public void setDefaultHeaders(Collection<Header> headers) {
        throw new RuntimeException("Stub!");
    }

    public void setDefaultHost(HttpHost host) {
        throw new RuntimeException("Stub!");
    }
}
