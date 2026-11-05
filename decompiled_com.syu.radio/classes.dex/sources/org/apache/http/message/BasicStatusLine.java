package org.apache.http.message;

import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class BasicStatusLine implements StatusLine {
    public BasicStatusLine(ProtocolVersion version, int statusCode, String reasonPhrase) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.StatusLine
    public int getStatusCode() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.StatusLine
    public ProtocolVersion getProtocolVersion() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.StatusLine
    public String getReasonPhrase() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }

    public Object clone() throws CloneNotSupportedException {
        throw new RuntimeException("Stub!");
    }
}
