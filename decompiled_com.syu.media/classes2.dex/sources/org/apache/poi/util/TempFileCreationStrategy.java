package org.apache.poi.util;

import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface TempFileCreationStrategy {
    File createTempDirectory(String str) throws IOException;

    File createTempFile(String str, String str2) throws IOException;
}
