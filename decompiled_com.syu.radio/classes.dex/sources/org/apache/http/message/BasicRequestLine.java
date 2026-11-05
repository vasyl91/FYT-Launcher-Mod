package org.apache.http.message;

import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class BasicRequestLine implements RequestLine {
    public BasicRequestLine(String method, String uri, ProtocolVersion version) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.RequestLine
    public String getMethod() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.RequestLine
    public ProtocolVersion getProtocolVersion() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.RequestLine
    public String getUri() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }

    public Object clone() throws CloneNotSupportedException {
        throw new RuntimeException("Stub!");
    }
}
