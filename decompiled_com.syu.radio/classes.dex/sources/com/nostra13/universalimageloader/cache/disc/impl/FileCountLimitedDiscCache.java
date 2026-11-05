package com.nostra13.universalimageloader.cache.disc.impl;

import com.nostra13.universalimageloader.cache.disc.LimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FileCountLimitedDiscCache extends LimitedDiscCache {
    public FileCountLimitedDiscCache(File cacheDir, int maxFileCount) {
        this(cacheDir, DefaultConfigurationFactory.createFileNameGenerator(), maxFileCount);
    }

    public FileCountLimitedDiscCache(File cacheDir, FileNameGenerator fileNameGenerator, int maxFileCount) {
        super(cacheDir, fileNameGenerator, maxFileCount);
    }

    @Override // com.nostra13.universalimageloader.cache.disc.LimitedDiscCache
    protected int getSize(File file) {
        return 1;
    }
}
