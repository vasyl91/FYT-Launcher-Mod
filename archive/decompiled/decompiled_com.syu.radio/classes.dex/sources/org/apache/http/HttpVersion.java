package org.apache.http;

import java.io.Serializable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public final class HttpVersion extends ProtocolVersion implements Serializable {
    public static final String HTTP = "HTTP";
    public static final HttpVersion HTTP_0_9 = null;
    public static final HttpVersion HTTP_1_0 = null;
    public static final HttpVersion HTTP_1_1 = null;

    public HttpVersion(int major, int minor) {
        super((String) null, 0, 0);
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.ProtocolVersion
    public ProtocolVersion forVersion(int major, int minor) {
        throw new RuntimeException("Stub!");
    }
}
