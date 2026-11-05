package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class UsingFreqLimitedMemoryCache extends LimitedMemoryCache<String, Bitmap> {
    private final Map<Bitmap, Integer> usingCounts;

    public UsingFreqLimitedMemoryCache(int sizeLimit) {
        super(sizeLimit);
        this.usingCounts = Collections.synchronizedMap(new HashMap());
    }

    @Override // com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache, com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public boolean put(String key, Bitmap value) {
        if (!super.put(key, value)) {
            return false;
        }
        this.usingCounts.put(value, 0);
        return true;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public Bitmap get(String key) {
        Integer usageCount;
        Bitmap value = (Bitmap) super.get(key);
        if (value != null && (usageCount = this.usingCounts.get(value)) != null) {
            this.usingCounts.put(value, Integer.valueOf(usageCount.intValue() + 1));
        }
        return value;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache, com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public void remove(String key) {
        Bitmap value = (Bitmap) super.get(key);
        if (value != null) {
            this.usingCounts.remove(value);
        }
        super.remove(key);
    }

    @Override // com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache, com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.usingCounts.clear();
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
        Integer minUsageCount = null;
        Bitmap leastUsedValue = null;
        Set<Map.Entry<Bitmap, Integer>> entries = this.usingCounts.entrySet();
        synchronized (this.usingCounts) {
            for (Map.Entry<Bitmap, Integer> entry : entries) {
                if (leastUsedValue == null) {
                    leastUsedValue = entry.getKey();
                    minUsageCount = entry.getValue();
                } else {
                    Integer lastValueUsage = entry.getValue();
                    if (lastValueUsage.intValue() < minUsageCount.intValue()) {
                        minUsageCount = lastValueUsage;
                        leastUsedValue = entry.getKey();
                    }
                }
            }
        }
        this.usingCounts.remove(leastUsedValue);
        return leastUsedValue;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nostra13.universalimageloader.cache.memory.BaseMemoryCache
    public Reference<Bitmap> createReference(Bitmap value) {
        return new WeakReference(value);
    }
}
