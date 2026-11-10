package org.apache.http;

import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public interface HttpResponse extends HttpMessage {
    HttpEntity getEntity();

    Locale getLocale();

    StatusLine getStatusLine();

    void setEntity(HttpEntity httpEntity);

    void setLocale(Locale locale);

    void setReasonPhrase(String str) throws IllegalStateException;

    void setStatusCode(int i) throws IllegalStateException;

    void setStatusLine(ProtocolVersion protocolVersion, int i);

    void setStatusLine(ProtocolVersion protocolVersion, int i, String str);

    void setStatusLine(StatusLine statusLine);
}
