package com.nostra13.universalimageloader.cache.memory.impl;

import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import java.util.Collection;
import java.util.Comparator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FuzzyKeyMemoryCache<K, V> implements MemoryCacheAware<K, V> {
    private final MemoryCacheAware<K, V> cache;
    private final Comparator<K> keyComparator;

    public FuzzyKeyMemoryCache(MemoryCacheAware<K, V> cache, Comparator<K> keyComparator) {
        this.cache = cache;
        this.keyComparator = keyComparator;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public boolean put(K key, V value) {
        synchronized (this.cache) {
            K keyToRemove = null;
            for (K cacheKey : this.cache.keys()) {
                if (this.keyComparator.compare(key, cacheKey) == 0) {
                    keyToRemove = cacheKey;
                    break;
                }
            }
            if (keyToRemove != null) {
                this.cache.remove(keyToRemove);
            }
        }
        return this.cache.put(key, value);
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public V get(K key) {
        return this.cache.get(key);
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public void remove(K key) {
        this.cache.remove(key);
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.cache.clear();
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public Collection<K> keys() {
        return this.cache.keys();
    }
}
