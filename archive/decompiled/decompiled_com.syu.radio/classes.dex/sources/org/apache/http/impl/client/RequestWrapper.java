package org.apache.http.impl.client;

import java.net.URI;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.AbstractHttpMessage;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class RequestWrapper extends AbstractHttpMessage implements HttpUriRequest {
    public RequestWrapper(HttpRequest request) throws ProtocolException {
        throw new RuntimeException("Stub!");
    }

    public void resetHeaders() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.HttpUriRequest
    public String getMethod() {
        throw new RuntimeException("Stub!");
    }

    public void setMethod(String method) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        throw new RuntimeException("Stub!");
    }

    public void setProtocolVersion(ProtocolVersion version) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.HttpUriRequest
    public URI getURI() {
        throw new RuntimeException("Stub!");
    }

    public void setURI(URI uri) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpRequest
    public RequestLine getRequestLine() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.HttpUriRequest, org.apache.http.client.methods.AbortableHttpRequest
    public void abort() throws UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.HttpUriRequest
    public boolean isAborted() {
        throw new RuntimeException("Stub!");
    }

    public HttpRequest getOriginal() {
        throw new RuntimeException("Stub!");
    }

    public boolean isRepeatable() {
        throw new RuntimeException("Stub!");
    }

    public int getExecCount() {
        throw new RuntimeException("Stub!");
    }

    public void incrementExecCount() {
        throw new RuntimeException("Stub!");
    }
}
