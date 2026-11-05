package com.nostra13.universalimageloader.cache.disc.impl;

import com.nostra13.universalimageloader.cache.disc.BaseDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class UnlimitedDiscCache extends BaseDiscCache {
    public UnlimitedDiscCache(File cacheDir) {
        this(cacheDir, DefaultConfigurationFactory.createFileNameGenerator());
    }

    public UnlimitedDiscCache(File cacheDir, FileNameGenerator fileNameGenerator) {
        super(cacheDir, fileNameGenerator);
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiscCacheAware
    public void put(String key, File file) {
    }
}
