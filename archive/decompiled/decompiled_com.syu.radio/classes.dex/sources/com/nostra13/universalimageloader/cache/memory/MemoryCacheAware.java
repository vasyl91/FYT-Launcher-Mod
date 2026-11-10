package com.nostra13.universalimageloader.cache.memory;

import java.util.Collection;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface MemoryCacheAware<K, V> {
    void clear();

    V get(K k);

    Collection<K> keys();

    boolean put(K k, V v);

    void remove(K k);
}
