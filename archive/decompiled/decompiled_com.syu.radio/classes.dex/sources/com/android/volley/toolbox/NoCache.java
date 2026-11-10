package com.android.volley.toolbox;

import com.android.volley.Cache;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class NoCache implements Cache {
    @Override // com.android.volley.Cache
    public void clear() {
    }

    @Override // com.android.volley.Cache
    public Cache.Entry get(String key) {
        return null;
    }

    @Override // com.android.volley.Cache
    public void put(String key, Cache.Entry entry) {
    }

    @Override // com.android.volley.Cache
    public void invalidate(String key, boolean fullExpire) {
    }

    @Override // com.android.volley.Cache
    public void remove(String key) {
    }

    @Override // com.android.volley.Cache
    public void initialize() {
    }
}
