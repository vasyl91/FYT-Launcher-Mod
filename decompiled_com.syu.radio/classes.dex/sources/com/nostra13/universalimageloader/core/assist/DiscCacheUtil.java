package com.nostra13.universalimageloader.core.assist;

import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import java.io.File;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public final class DiscCacheUtil {
    private DiscCacheUtil() {
    }

    public static File findInCache(String imageUri, DiscCacheAware discCache) {
        File image = discCache.get(imageUri);
        if (image.exists()) {
            return image;
        }
        return null;
    }

    public static boolean removeFromCache(String imageUri, DiscCacheAware discCache) {
        File image = discCache.get(imageUri);
        return image.delete();
    }
}
