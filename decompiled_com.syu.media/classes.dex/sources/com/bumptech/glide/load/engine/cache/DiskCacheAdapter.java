package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import java.io.File;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class DiskCacheAdapter implements DiskCache {
    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void clear() {
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key key) {
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File get(Key key) {
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void put(Key key, DiskCache.Writer writer) {
    }

    public static final class Factory implements DiskCache.Factory {
        @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
        public DiskCache build() {
            return new DiskCacheAdapter();
        }
    }
}
