package org.apache.http.message;

import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.ReasonPhraseCatalog;
import org.apache.http.StatusLine;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class BasicHttpResponse extends AbstractHttpMessage implements HttpResponse {
    public BasicHttpResponse(StatusLine statusline, ReasonPhraseCatalog catalog, Locale locale) {
        throw new RuntimeException("Stub!");
    }

    public BasicHttpResponse(StatusLine statusline) {
        throw new RuntimeException("Stub!");
    }

    public BasicHttpResponse(ProtocolVersion ver, int code, String reason) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpResponse
    public StatusLine getStatusLine() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpResponse
    public HttpEntity getEntity() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpResponse
    public Locale getLocale() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpResponse
    public void setStatusLine(StatusLine statusline) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpResponse
    public void setStatusLine(ProtocolVersion ver, int code) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpResponse
    public void setStatusLine(ProtocolVersion ver, int code, String reason) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpResponse
    public void setStatusCode(int code) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpResponse
    public void setReasonPhrase(String reason) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpResponse
    public void setEntity(HttpEntity entity) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpResponse
    public void setLocale(Locale loc) {
        throw new RuntimeException("Stub!");
    }

    protected String getReason(int code) {
        throw new RuntimeException("Stub!");
    }
}
