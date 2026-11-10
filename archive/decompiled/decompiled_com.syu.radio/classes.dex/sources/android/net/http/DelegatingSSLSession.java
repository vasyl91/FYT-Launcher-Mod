package android.net.http;

import java.security.Principal;
import java.security.cert.Certificate;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class DelegatingSSLSession implements SSLSession {

    public static class CertificateWrap extends DelegatingSSLSession {
        public CertificateWrap(Certificate certificate) {
            throw new RuntimeException("Stub!");
        }

        @Override // android.net.http.DelegatingSSLSession, javax.net.ssl.SSLSession
        public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
            throw new RuntimeException("Stub!");
        }
    }

    protected DelegatingSSLSession() {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public int getApplicationBufferSize() {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public String getCipherSuite() {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public long getCreationTime() {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public byte[] getId() {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public long getLastAccessedTime() {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public Certificate[] getLocalCertificates() {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getLocalPrincipal() {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public int getPacketBufferSize() {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public String getPeerHost() {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public int getPeerPort() {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public String getProtocol() {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public SSLSessionContext getSessionContext() {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public Object getValue(String name) {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public String[] getValueNames() {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public void invalidate() {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public boolean isValid() {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public void putValue(String name, Object value) {
        throw new RuntimeException("Stub!");
    }

    @Override // javax.net.ssl.SSLSession
    public void removeValue(String name) {
        throw new RuntimeException("Stub!");
    }
}
