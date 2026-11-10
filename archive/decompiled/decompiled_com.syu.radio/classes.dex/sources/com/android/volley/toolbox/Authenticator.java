package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface Authenticator {
    String getAuthToken() throws AuthFailureError;

    void invalidateAuthToken(String str);
}
