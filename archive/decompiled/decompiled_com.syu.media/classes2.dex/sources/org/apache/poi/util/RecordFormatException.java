package org.apache.poi.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class RecordFormatException extends RuntimeException {
    public RecordFormatException(String str) {
        super(str);
    }

    public RecordFormatException(String str, Throwable th) {
        super(str, th);
    }

    public RecordFormatException(Throwable th) {
        super(th);
    }

    public static void check(boolean z, String str) {
        if (!z) {
            throw new RecordFormatException(str);
        }
    }
}
