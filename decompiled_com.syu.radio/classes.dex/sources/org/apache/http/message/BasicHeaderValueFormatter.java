package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class BasicHeaderValueFormatter implements HeaderValueFormatter {
    public static final BasicHeaderValueFormatter DEFAULT = null;
    public static final String SEPARATORS = " ;,:@()<>\\\"/[]?={}\t";
    public static final String UNSAFE_CHARS = "\"\\";

    public BasicHeaderValueFormatter() {
        throw new RuntimeException("Stub!");
    }

    public static final String formatElements(HeaderElement[] elems, boolean quote, HeaderValueFormatter formatter) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatElements(CharArrayBuffer buffer, HeaderElement[] elems, boolean quote) {
        throw new RuntimeException("Stub!");
    }

    protected int estimateElementsLen(HeaderElement[] elems) {
        throw new RuntimeException("Stub!");
    }

    public static final String formatHeaderElement(HeaderElement elem, boolean quote, HeaderValueFormatter formatter) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatHeaderElement(CharArrayBuffer buffer, HeaderElement elem, boolean quote) {
        throw new RuntimeException("Stub!");
    }

    protected int estimateHeaderElementLen(HeaderElement elem) {
        throw new RuntimeException("Stub!");
    }

    public static final String formatParameters(NameValuePair[] nvps, boolean quote, HeaderValueFormatter formatter) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatParameters(CharArrayBuffer buffer, NameValuePair[] nvps, boolean quote) {
        throw new RuntimeException("Stub!");
    }

    protected int estimateParametersLen(NameValuePair[] nvps) {
        throw new RuntimeException("Stub!");
    }

    public static final String formatNameValuePair(NameValuePair nvp, boolean quote, HeaderValueFormatter formatter) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatNameValuePair(CharArrayBuffer buffer, NameValuePair nvp, boolean quote) {
        throw new RuntimeException("Stub!");
    }

    protected int estimateNameValuePairLen(NameValuePair nvp) {
        throw new RuntimeException("Stub!");
    }

    protected void doFormatValue(CharArrayBuffer buffer, String value, boolean quote) {
        throw new RuntimeException("Stub!");
    }

    protected boolean isSeparator(char ch) {
        throw new RuntimeException("Stub!");
    }

    protected boolean isUnsafe(char ch) {
        throw new RuntimeException("Stub!");
    }
}
