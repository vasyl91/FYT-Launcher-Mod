package org.apache.poi.hpsf;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HPSFException extends Exception {
    private Throwable reason;

    public HPSFException() {
    }

    public HPSFException(String str) {
        super(str);
    }

    public HPSFException(Throwable th) {
        this.reason = th;
    }

    public HPSFException(String str, Throwable th) {
        super(str);
        this.reason = th;
    }

    public Throwable getReason() {
        return this.reason;
    }
}
