package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class BasicLineParser implements LineParser {
    public static final BasicLineParser DEFAULT = null;
    protected final ProtocolVersion protocol;

    public BasicLineParser(ProtocolVersion proto) {
        throw new RuntimeException("Stub!");
    }

    public BasicLineParser() {
        throw new RuntimeException("Stub!");
    }

    public static final ProtocolVersion parseProtocolVersion(String value, LineParser parser) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.LineParser
    public ProtocolVersion parseProtocolVersion(CharArrayBuffer buffer, ParserCursor cursor) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    protected ProtocolVersion createProtocolVersion(int major, int minor) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.LineParser
    public boolean hasProtocolVersion(CharArrayBuffer buffer, ParserCursor cursor) {
        throw new RuntimeException("Stub!");
    }

    public static final RequestLine parseRequestLine(String value, LineParser parser) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.LineParser
    public RequestLine parseRequestLine(CharArrayBuffer buffer, ParserCursor cursor) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    protected RequestLine createRequestLine(String method, String uri, ProtocolVersion ver) {
        throw new RuntimeException("Stub!");
    }

    public static final StatusLine parseStatusLine(String value, LineParser parser) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.LineParser
    public StatusLine parseStatusLine(CharArrayBuffer buffer, ParserCursor cursor) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    protected StatusLine createStatusLine(ProtocolVersion ver, int status, String reason) {
        throw new RuntimeException("Stub!");
    }

    public static final Header parseHeader(String value, LineParser parser) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.LineParser
    public Header parseHeader(CharArrayBuffer buffer) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    protected void skipWhitespace(CharArrayBuffer buffer, ParserCursor cursor) {
        throw new RuntimeException("Stub!");
    }
}
