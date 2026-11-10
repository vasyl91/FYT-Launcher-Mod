package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class LruMemoryCache implements MemoryCacheAware<String, Bitmap> {
    private final LinkedHashMap<String, Bitmap> map;
    private final int maxSize;
    private int size;

    public LruMemoryCache(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = maxSize;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public final Bitmap get(String key) {
        Bitmap bitmap;
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            bitmap = this.map.get(key);
        }
        return bitmap;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public final boolean put(String key, Bitmap value) {
        if (key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.size += sizeOf(key, value);
            Bitmap previous = this.map.put(key, value);
            if (previous != null) {
                this.size -= sizeOf(key, previous);
            }
        }
        trimToSize(this.maxSize);
        return true;
    }

    private void trimToSize(int maxSize) {
        while (true) {
            synchronized (this) {
                if (this.size < 0 || (this.map.isEmpty() && this.size != 0)) {
                    break;
                }
                if (this.size > maxSize && !this.map.isEmpty()) {
                    Map.Entry<String, Bitmap> toEvict = this.map.entrySet().iterator().next();
                    if (toEvict != null) {
                        String key = toEvict.getKey();
                        Bitmap value = toEvict.getValue();
                        this.map.remove(key);
                        this.size -= sizeOf(key, value);
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public final void remove(String key) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Bitmap previous = this.map.remove(key);
            if (previous != null) {
                this.size -= sizeOf(key, previous);
            }
        }
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.map.keySet());
        }
        return hashSet;
    }

    @Override // com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        trimToSize(-1);
    }

    private int sizeOf(String key, Bitmap value) {
        return value.getRowBytes() * value.getHeight();
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.maxSize));
    }
}
