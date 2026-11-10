package com.nostra13.universalimageloader.cache.disc.impl;

import com.nostra13.universalimageloader.cache.disc.BaseDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class LimitedAgeDiscCache extends BaseDiscCache {
    private final Map<File, Long> loadingDates;
    private final long maxFileAge;

    public LimitedAgeDiscCache(File cacheDir, long maxAge) {
        this(cacheDir, DefaultConfigurationFactory.createFileNameGenerator(), maxAge);
    }

    public LimitedAgeDiscCache(File cacheDir, FileNameGenerator fileNameGenerator, long maxAge) {
        super(cacheDir, fileNameGenerator);
        this.loadingDates = Collections.synchronizedMap(new HashMap());
        this.maxFileAge = 1000 * maxAge;
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiscCacheAware
    public void put(String key, File file) {
        long currentTime = System.currentTimeMillis();
        file.setLastModified(currentTime);
        this.loadingDates.put(file, Long.valueOf(currentTime));
    }

    @Override // com.nostra13.universalimageloader.cache.disc.BaseDiscCache, com.nostra13.universalimageloader.cache.disc.DiscCacheAware
    public File get(String key) {
        boolean cached;
        File file = super.get(key);
        if (file.exists()) {
            Long loadingDate = this.loadingDates.get(file);
            if (loadingDate == null) {
                cached = false;
                loadingDate = Long.valueOf(file.lastModified());
            } else {
                cached = true;
            }
            if (System.currentTimeMillis() - loadingDate.longValue() > this.maxFileAge) {
                file.delete();
                this.loadingDates.remove(file);
            } else if (!cached) {
                this.loadingDates.put(file, loadingDate);
            }
        }
        return file;
    }
}
