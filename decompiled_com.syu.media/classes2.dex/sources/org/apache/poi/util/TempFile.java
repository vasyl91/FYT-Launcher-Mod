package org.apache.poi.util;

import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class TempFile {
    public static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
    private static TempFileCreationStrategy strategy = new DefaultTempFileCreationStrategy();

    public static class DefaultTempFileCreationStrategy extends org.apache.poi.util.DefaultTempFileCreationStrategy {
    }

    private TempFile() {
    }

    public static void setTempFileCreationStrategy(TempFileCreationStrategy tempFileCreationStrategy) {
        if (tempFileCreationStrategy == null) {
            throw new IllegalArgumentException("strategy == null");
        }
        strategy = tempFileCreationStrategy;
    }

    public static File createTempFile(String str, String str2) throws IOException {
        return strategy.createTempFile(str, str2);
    }

    public static File createTempDirectory(String str) throws IOException {
        return strategy.createTempDirectory(str);
    }
}
