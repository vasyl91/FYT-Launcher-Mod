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
public class LargestLimitedMemoryCache extends LimitedMemoryCache<String, Bitmap> {
    private final Map<Bitmap, Integer> valueSizes;

    public LargestLimitedMemoryCache(int sizeLimit) {
        super(sizeLimit);
        this.valueSizes = Collections.synchronizedMap(new HashMap());
    }

    @Override // com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache, com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public boolean put(String key, Bitmap value) {
        if (!super.put(key, value)) {
            return false;
        }
        this.valueSizes.put(value, Integer.valueOf(getSize(value)));
        return true;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache, com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public void remove(String key) {
        Bitmap value = (Bitmap) super.get(key);
        if (value != null) {
            this.valueSizes.remove(value);
        }
        super.remove(key);
    }

    @Override // com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache, com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.valueSizes.clear();
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
        Integer maxSize = null;
        Bitmap largestValue = null;
        Set<Map.Entry<Bitmap, Integer>> entries = this.valueSizes.entrySet();
        synchronized (this.valueSizes) {
            for (Map.Entry<Bitmap, Integer> entry : entries) {
                if (largestValue == null) {
                    largestValue = entry.getKey();
                    maxSize = entry.getValue();
                } else {
                    Integer size = entry.getValue();
                    if (size.intValue() > maxSize.intValue()) {
                        maxSize = size;
                        largestValue = entry.getKey();
                    }
                }
            }
        }
        this.valueSizes.remove(largestValue);
        return largestValue;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nostra13.universalimageloader.cache.memory.BaseMemoryCache
    public Reference<Bitmap> createReference(Bitmap value) {
        return new WeakReference(value);
    }
}
