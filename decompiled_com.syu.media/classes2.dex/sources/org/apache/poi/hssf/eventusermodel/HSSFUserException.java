package org.apache.poi.hssf.eventusermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HSSFUserException extends Exception {
    private Throwable reason;

    public HSSFUserException() {
    }

    public HSSFUserException(String str) {
        super(str);
    }

    public HSSFUserException(Throwable th) {
        this.reason = th;
    }

    public HSSFUserException(String str, Throwable th) {
        super(str);
        this.reason = th;
    }

    public Throwable getReason() {
        return this.reason;
    }
}
