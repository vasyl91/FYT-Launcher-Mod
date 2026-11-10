package org.apache.http.auth;

import java.security.Principal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public interface Credentials {
    String getPassword();

    Principal getUserPrincipal();
}
