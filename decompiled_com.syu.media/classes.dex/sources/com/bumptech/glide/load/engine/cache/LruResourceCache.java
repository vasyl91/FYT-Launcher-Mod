package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.LruCache;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {
    private MemoryCache.ResourceRemovedListener listener;

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ Resource put(Key key, Resource resource) {
        return (Resource) super.put(key, resource);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ Resource remove(Key key) {
        return (Resource) super.remove(key);
    }

    public LruResourceCache(long j) {
        super(j);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void setResourceRemovedListener(MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.listener = resourceRemovedListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.LruCache
    public void onItemEvicted(Key key, Resource<?> resource) {
        MemoryCache.ResourceRemovedListener resourceRemovedListener = this.listener;
        if (resourceRemovedListener == null || resource == null) {
            return;
        }
        resourceRemovedListener.onResourceRemoved(resource);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.LruCache
    public int getSize(Resource<?> resource) {
        if (resource == null) {
            return super.getSize((Object) null);
        }
        return resource.getSize();
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void trimMemory(int i) {
        if (i >= 40) {
            clearMemory();
        } else if (i >= 20 || i == 15) {
            trimToSize(getMaxSize() / 2);
        }
    }
}
