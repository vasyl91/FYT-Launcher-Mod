package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Deprecated
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE);
    }

    public ExternalCacheDiskCacheFactory(Context context, int i) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, i);
    }

    public ExternalCacheDiskCacheFactory(final Context context, final String str, int i) {
        super(new DiskLruCacheFactory.CacheDirectoryGetter() { // from class: com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory.1
            @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null) {
                    return null;
                }
                return str != null ? new File(externalCacheDir, str) : externalCacheDir;
            }
        }, i);
    }
}
