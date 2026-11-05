package com.nostra13.universalimageloader.cache.memory.impl;

import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class LimitedAgeMemoryCache<K, V> implements MemoryCacheAware<K, V> {
    private final MemoryCacheAware<K, V> cache;
    private final Map<K, Long> loadingDates = Collections.synchronizedMap(new HashMap());
    private final long maxAge;

    public LimitedAgeMemoryCache(MemoryCacheAware<K, V> cache, long maxAge) {
        this.cache = cache;
        this.maxAge = 1000 * maxAge;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public boolean put(K key, V value) {
        boolean putSuccesfully = this.cache.put(key, value);
        if (putSuccesfully) {
            this.loadingDates.put(key, Long.valueOf(System.currentTimeMillis()));
        }
        return putSuccesfully;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public V get(K key) {
        Long loadingDate = this.loadingDates.get(key);
        if (loadingDate != null && System.currentTimeMillis() - loadingDate.longValue() > this.maxAge) {
            this.cache.remove(key);
            this.loadingDates.remove(key);
        }
        return this.cache.get(key);
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public void remove(K key) {
        this.cache.remove(key);
        this.loadingDates.remove(key);
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public Collection<K> keys() {
        return this.cache.keys();
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.cache.clear();
        this.loadingDates.clear();
    }
}
