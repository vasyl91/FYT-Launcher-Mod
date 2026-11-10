package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public InternalCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, 262144000L);
    }

    public InternalCacheDiskCacheFactory(Context context, long j) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, j);
    }

    public InternalCacheDiskCacheFactory(final Context context, final String str, long j) {
        super(new DiskLruCacheFactory.CacheDirectoryGetter() { // from class: com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory.1
            @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                return str != null ? new File(cacheDir, str) : cacheDir;
            }
        }, j);
    }
}
