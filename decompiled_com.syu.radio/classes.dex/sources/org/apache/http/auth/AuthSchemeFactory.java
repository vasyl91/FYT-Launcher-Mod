package org.apache.http.auth;

import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public interface AuthSchemeFactory {
    AuthScheme newInstance(HttpParams httpParams);
}
