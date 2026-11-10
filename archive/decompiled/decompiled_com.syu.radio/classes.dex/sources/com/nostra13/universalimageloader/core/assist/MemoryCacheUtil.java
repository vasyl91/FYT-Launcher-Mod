package com.nostra13.universalimageloader.core.assist;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public final class MemoryCacheUtil {
    private static final String URI_AND_SIZE_SEPARATOR = "_";
    private static final String WIDTH_AND_HEIGHT_SEPARATOR = "x";

    private MemoryCacheUtil() {
    }

    public static String generateKey(String imageUri, ImageSize targetSize) {
        return imageUri + URI_AND_SIZE_SEPARATOR + targetSize.getWidth() + WIDTH_AND_HEIGHT_SEPARATOR + targetSize.getHeight();
    }

    public static Comparator<String> createFuzzyKeyComparator() {
        return new Comparator<String>() { // from class: com.nostra13.universalimageloader.core.assist.MemoryCacheUtil.1
            @Override // java.util.Comparator
            public int compare(String key1, String key2) {
                String imageUri1 = key1.substring(0, key1.lastIndexOf(MemoryCacheUtil.URI_AND_SIZE_SEPARATOR));
                String imageUri2 = key2.substring(0, key2.lastIndexOf(MemoryCacheUtil.URI_AND_SIZE_SEPARATOR));
                return imageUri1.compareTo(imageUri2);
            }
        };
    }

    public static List<Bitmap> findCachedBitmapsForImageUri(String imageUri, MemoryCacheAware<String, Bitmap> memoryCache) {
        List<Bitmap> values = new ArrayList<>();
        for (String key : memoryCache.keys()) {
            if (key.startsWith(imageUri)) {
                values.add(memoryCache.get(key));
            }
        }
        return values;
    }

    public static List<String> findCacheKeysForImageUri(String imageUri, MemoryCacheAware<String, Bitmap> memoryCache) {
        List<String> values = new ArrayList<>();
        for (String key : memoryCache.keys()) {
            if (key.startsWith(imageUri)) {
                values.add(key);
            }
        }
        return values;
    }

    public static void removeFromCache(String imageUri, MemoryCacheAware<String, Bitmap> memoryCache) {
        List<String> keysToRemove = new ArrayList<>();
        for (String key : memoryCache.keys()) {
            if (key.startsWith(imageUri)) {
                keysToRemove.add(key);
            }
        }
        for (String keyToRemove : keysToRemove) {
            memoryCache.remove(keyToRemove);
        }
    }
}
