package org.apache.http;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public interface Header {
    HeaderElement[] getElements() throws ParseException;

    String getName();

    String getValue();
}
