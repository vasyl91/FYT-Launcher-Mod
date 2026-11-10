package com.nostra13.universalimageloader.cache.disc;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public abstract class LimitedDiscCache extends BaseDiscCache {
    private static final int INVALID_SIZE = -1;
    private final AtomicInteger cacheSize;
    private final Map<File, Long> lastUsageDates;
    private final int sizeLimit;

    protected abstract int getSize(File file);

    public LimitedDiscCache(File cacheDir, int sizeLimit) {
        this(cacheDir, DefaultConfigurationFactory.createFileNameGenerator(), sizeLimit);
    }

    public LimitedDiscCache(File cacheDir, FileNameGenerator fileNameGenerator, int sizeLimit) {
        super(cacheDir, fileNameGenerator);
        this.lastUsageDates = Collections.synchronizedMap(new HashMap());
        this.sizeLimit = sizeLimit;
        this.cacheSize = new AtomicInteger();
        calculateCacheSizeAndFillUsageMap();
    }

    private void calculateCacheSizeAndFillUsageMap() {
        new Thread(new Runnable() { // from class: com.nostra13.universalimageloader.cache.disc.LimitedDiscCache.1
            @Override // java.lang.Runnable
            public void run() {
                int size = 0;
                File[] cachedFiles = LimitedDiscCache.this.cacheDir.listFiles();
                if (cachedFiles != null) {
                    for (File cachedFile : cachedFiles) {
                        size += LimitedDiscCache.this.getSize(cachedFile);
                        LimitedDiscCache.this.lastUsageDates.put(cachedFile, Long.valueOf(cachedFile.lastModified()));
                    }
                    LimitedDiscCache.this.cacheSize.set(size);
                }
            }
        }).start();
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiscCacheAware
    public void put(String key, File file) {
        int freedSize;
        int valueSize = getSize(file);
        int curCacheSize = this.cacheSize.get();
        while (curCacheSize + valueSize > this.sizeLimit && (freedSize = removeNext()) != -1) {
            curCacheSize = this.cacheSize.addAndGet(-freedSize);
        }
        this.cacheSize.addAndGet(valueSize);
        Long currentTime = Long.valueOf(System.currentTimeMillis());
        file.setLastModified(currentTime.longValue());
        this.lastUsageDates.put(file, currentTime);
    }

    @Override // com.nostra13.universalimageloader.cache.disc.BaseDiscCache, com.nostra13.universalimageloader.cache.disc.DiscCacheAware
    public File get(String key) {
        File file = super.get(key);
        Long currentTime = Long.valueOf(System.currentTimeMillis());
        file.setLastModified(currentTime.longValue());
        this.lastUsageDates.put(file, currentTime);
        return file;
    }

    @Override // com.nostra13.universalimageloader.cache.disc.BaseDiscCache, com.nostra13.universalimageloader.cache.disc.DiscCacheAware
    public void clear() {
        this.lastUsageDates.clear();
        this.cacheSize.set(0);
        super.clear();
    }

    private int removeNext() {
        if (this.lastUsageDates.isEmpty()) {
            return -1;
        }
        Long oldestUsage = null;
        File mostLongUsedFile = null;
        Set<Map.Entry<File, Long>> entries = this.lastUsageDates.entrySet();
        synchronized (this.lastUsageDates) {
            for (Map.Entry<File, Long> entry : entries) {
                if (mostLongUsedFile == null) {
                    mostLongUsedFile = entry.getKey();
                    oldestUsage = entry.getValue();
                } else {
                    Long lastValueUsage = entry.getValue();
                    if (lastValueUsage.longValue() < oldestUsage.longValue()) {
                        oldestUsage = lastValueUsage;
                        mostLongUsedFile = entry.getKey();
                    }
                }
            }
        }
        if (mostLongUsedFile == null) {
            return 0;
        }
        if (mostLongUsedFile.exists()) {
            int fileSize = getSize(mostLongUsedFile);
            if (mostLongUsedFile.delete()) {
                this.lastUsageDates.remove(mostLongUsedFile);
                return fileSize;
            }
            return fileSize;
        }
        this.lastUsageDates.remove(mostLongUsedFile);
        return 0;
    }
}
