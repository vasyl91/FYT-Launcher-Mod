package org.apache.http;

import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public interface HttpMessage {
    void addHeader(String str, String str2);

    void addHeader(Header header);

    boolean containsHeader(String str);

    Header[] getAllHeaders();

    Header getFirstHeader(String str);

    Header[] getHeaders(String str);

    Header getLastHeader(String str);

    HttpParams getParams();

    ProtocolVersion getProtocolVersion();

    HeaderIterator headerIterator();

    HeaderIterator headerIterator(String str);

    void removeHeader(Header header);

    void removeHeaders(String str);

    void setHeader(String str, String str2);

    void setHeader(Header header);

    void setHeaders(Header[] headerArr);

    void setParams(HttpParams httpParams);
}
