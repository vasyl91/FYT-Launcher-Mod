package org.apache.poi.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DocumentFormatException extends RuntimeException {
    public DocumentFormatException(String str) {
        super(str);
    }

    public DocumentFormatException(String str, Throwable th) {
        super(str, th);
    }

    public DocumentFormatException(Throwable th) {
        super(th);
    }

    public static void check(boolean z, String str) {
        if (!z) {
            throw new DocumentFormatException(str);
        }
    }
}
