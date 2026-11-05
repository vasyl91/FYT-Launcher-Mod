package com.nostra13.universalimageloader.cache.memory;

import com.nostra13.universalimageloader.utils.L;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public abstract class LimitedMemoryCache<K, V> extends BaseMemoryCache<K, V> {
    private static final int MAX_NORMAL_CACHE_SIZE = 16777216;
    private static final int MAX_NORMAL_CACHE_SIZE_IN_MB = 16;
    private final int sizeLimit;
    private final List<V> hardCache = Collections.synchronizedList(new LinkedList());
    private final AtomicInteger cacheSize = new AtomicInteger();

    protected abstract int getSize(V v);

    protected abstract V removeNext();

    public LimitedMemoryCache(int sizeLimit) {
        this.sizeLimit = sizeLimit;
        if (sizeLimit > 16777216) {
            L.w("You set too large memory cache size (more than %1$d Mb)", 16);
        }
    }

    @Override // com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public boolean put(K key, V value) {
        boolean putSuccessfully = false;
        int valueSize = getSize(value);
        int sizeLimit = getSizeLimit();
        int curCacheSize = this.cacheSize.get();
        if (valueSize < sizeLimit) {
            while (curCacheSize + valueSize > sizeLimit) {
                V removedValue = removeNext();
                if (this.hardCache.remove(removedValue)) {
                    curCacheSize = this.cacheSize.addAndGet(-getSize(removedValue));
                }
            }
            this.hardCache.add(value);
            this.cacheSize.addAndGet(valueSize);
            putSuccessfully = true;
        }
        super.put(key, value);
        return putSuccessfully;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public void remove(K key) {
        Object obj = super.get(key);
        if (obj != null && this.hardCache.remove(obj)) {
            this.cacheSize.addAndGet(-getSize(obj));
        }
        super.remove(key);
    }

    @Override // com.nostra13.universalimageloader.cache.memory.BaseMemoryCache, com.nostra13.universalimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.hardCache.clear();
        this.cacheSize.set(0);
        super.clear();
    }

    protected int getSizeLimit() {
        return this.sizeLimit;
    }
}
