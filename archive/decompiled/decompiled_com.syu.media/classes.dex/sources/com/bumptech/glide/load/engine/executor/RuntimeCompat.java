package com.bumptech.glide.load.engine.executor;

import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
final class RuntimeCompat {
    private static final String CPU_LOCATION = "/sys/devices/system/cpu/";
    private static final String CPU_NAME_REGEX = "cpu[0-9]+";
    private static final String TAG = "GlideRuntimeCompat";

    private RuntimeCompat() {
    }

    static int availableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    private static int getCoreCountPre17() {
        File[] fileArrListFiles;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            File file = new File(CPU_LOCATION);
            final Pattern patternCompile = Pattern.compile(CPU_NAME_REGEX);
            fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: com.bumptech.glide.load.engine.executor.RuntimeCompat.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    return patternCompile.matcher(str).matches();
                }
            });
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        } catch (Throwable th) {
            try {
                if (Log.isLoggable(TAG, 6)) {
                    Log.e(TAG, "Failed to calculate accurate cpu count", th);
                }
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                fileArrListFiles = null;
            } catch (Throwable th2) {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                throw th2;
            }
        }
        return Math.max(1, fileArrListFiles != null ? fileArrListFiles.length : 0);
    }
}
