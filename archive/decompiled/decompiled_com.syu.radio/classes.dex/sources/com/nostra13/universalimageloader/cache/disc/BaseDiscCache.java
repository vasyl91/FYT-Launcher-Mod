package com.nostra13.universalimageloader.cache.disc;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public abstract class BaseDiscCache implements DiscCacheAware {
    private static final String ERROR_ARG_NULL = "\"%s\" argument must be not null";
    protected File cacheDir;
    private FileNameGenerator fileNameGenerator;

    public BaseDiscCache(File cacheDir) {
        this(cacheDir, DefaultConfigurationFactory.createFileNameGenerator());
    }

    public BaseDiscCache(File cacheDir, FileNameGenerator fileNameGenerator) {
        if (cacheDir == null) {
            throw new IllegalArgumentException(String.format(ERROR_ARG_NULL, "cacheDir"));
        }
        if (fileNameGenerator == null) {
            throw new IllegalArgumentException(String.format(ERROR_ARG_NULL, "fileNameGenerator"));
        }
        this.cacheDir = cacheDir;
        this.fileNameGenerator = fileNameGenerator;
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiscCacheAware
    public File get(String key) {
        String fileName = this.fileNameGenerator.generate(key);
        return new File(this.cacheDir, fileName);
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiscCacheAware
    public void clear() {
        File[] files = this.cacheDir.listFiles();
        if (files != null) {
            for (File f : files) {
                f.delete();
            }
        }
    }
}
