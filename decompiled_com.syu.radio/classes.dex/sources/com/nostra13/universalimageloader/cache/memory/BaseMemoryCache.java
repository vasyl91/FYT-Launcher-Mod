package com.nostra13.universalimageloader.cache.memory;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public abstract class BaseMemoryCache<K, V> implements MemoryCacheAware<K, V> {
    private final Map<K, Reference<V>> softMap = Collections.synchronizedMap(new HashMap());

    protected abstract Reference<V> createReference(V v);

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public V get(K key) {
        Reference<V> reference = this.softMap.get(key);
        if (reference == null) {
            return null;
        }
        V result = reference.get();
        return result;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public boolean put(K key, V value) {
        this.softMap.put(key, createReference(value));
        return true;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public void remove(K key) {
        this.softMap.remove(key);
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public Collection<K> keys() {
        HashSet hashSet;
        synchronized (this.softMap) {
            hashSet = new HashSet(this.softMap.keySet());
        }
        return hashSet;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.softMap.clear();
    }
}
