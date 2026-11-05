package org.apache.http.message;

import org.apache.http.FormattedHeader;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class BufferedHeader implements FormattedHeader {
    public BufferedHeader(CharArrayBuffer buffer) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.Header
    public String getName() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.Header
    public String getValue() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.Header
    public HeaderElement[] getElements() throws ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.FormattedHeader
    public int getValuePos() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.FormattedHeader
    public CharArrayBuffer getBuffer() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }

    public Object clone() throws CloneNotSupportedException {
        throw new RuntimeException("Stub!");
    }
}
