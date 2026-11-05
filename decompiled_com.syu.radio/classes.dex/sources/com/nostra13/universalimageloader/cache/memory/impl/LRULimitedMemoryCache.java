package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class LRULimitedMemoryCache extends LimitedMemoryCache<String, Bitmap> {
    private static final int INITIAL_CAPACITY = 10;
    private static final float LOAD_FACTOR = 1.1f;
    private final Map<String, Bitmap> lruCache;

    public LRULimitedMemoryCache(int maxSize) {
        super(maxSize);
        this.lruCache = Collections.synchronizedMap(new LinkedHashMap(10, LOAD_FACTOR, true));
    }

    @Override // com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache, com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public boolean put(String key, Bitmap value) {
        if (!super.put(key, value)) {
            return false;
        }
        this.lruCache.put(key, value);
        return true;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public Bitmap get(String key) {
        this.lruCache.get(key);
        return (Bitmap) super.get(key);
    }

    @Override // com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache, com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public void remove(String key) {
        this.lruCache.remove(key);
        super.remove(key);
    }

    @Override // com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache, com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.lruCache.clear();
        super.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache
    public int getSize(Bitmap value) {
        return value.getRowBytes() * value.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache
    public Bitmap removeNext() {
        Bitmap mostLongUsedValue = null;
        synchronized (this.lruCache) {
            Iterator<Map.Entry<String, Bitmap>> it = this.lruCache.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, Bitmap> entry = it.next();
                mostLongUsedValue = entry.getValue();
                it.remove();
            }
        }
        return mostLongUsedValue;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nostra13.universalimageloader.cache.memory.BaseMemoryCache
    public Reference<Bitmap> createReference(Bitmap value) {
        return new WeakReference(value);
    }
}
