package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class BasicHeaderValueParser implements HeaderValueParser {
    public static final BasicHeaderValueParser DEFAULT = null;

    public BasicHeaderValueParser() {
        throw new RuntimeException("Stub!");
    }

    public static final HeaderElement[] parseElements(String value, HeaderValueParser parser) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueParser
    public HeaderElement[] parseElements(CharArrayBuffer buffer, ParserCursor cursor) {
        throw new RuntimeException("Stub!");
    }

    public static final HeaderElement parseHeaderElement(String value, HeaderValueParser parser) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueParser
    public HeaderElement parseHeaderElement(CharArrayBuffer buffer, ParserCursor cursor) {
        throw new RuntimeException("Stub!");
    }

    protected HeaderElement createHeaderElement(String name, String value, NameValuePair[] params) {
        throw new RuntimeException("Stub!");
    }

    public static final NameValuePair[] parseParameters(String value, HeaderValueParser parser) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueParser
    public NameValuePair[] parseParameters(CharArrayBuffer buffer, ParserCursor cursor) {
        throw new RuntimeException("Stub!");
    }

    public static final NameValuePair parseNameValuePair(String value, HeaderValueParser parser) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueParser
    public NameValuePair parseNameValuePair(CharArrayBuffer buffer, ParserCursor cursor) {
        throw new RuntimeException("Stub!");
    }

    public NameValuePair parseNameValuePair(CharArrayBuffer buffer, ParserCursor cursor, char[] delimiters) {
        throw new RuntimeException("Stub!");
    }

    protected NameValuePair createNameValuePair(String name, String value) {
        throw new RuntimeException("Stub!");
    }
}
