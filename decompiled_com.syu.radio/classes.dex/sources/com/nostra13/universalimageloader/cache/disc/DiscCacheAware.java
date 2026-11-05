package com.nostra13.universalimageloader.cache.disc;

import java.io.File;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface DiscCacheAware {
    void clear();

    File get(String str);

    void put(String str, File file);
}
