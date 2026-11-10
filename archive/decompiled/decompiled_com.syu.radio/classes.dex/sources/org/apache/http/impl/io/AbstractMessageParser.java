package org.apache.http.impl.io;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public abstract class AbstractMessageParser implements HttpMessageParser {
    protected final LineParser lineParser;

    protected abstract HttpMessage parseHead(SessionInputBuffer sessionInputBuffer) throws HttpException, ParseException, IOException;

    public AbstractMessageParser(SessionInputBuffer buffer, LineParser parser, HttpParams params) {
        throw new RuntimeException("Stub!");
    }

    public static Header[] parseHeaders(SessionInputBuffer inbuffer, int maxHeaderCount, int maxLineLen, LineParser parser) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.HttpMessageParser
    public HttpMessage parse() throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }
}
