package org.apache.poi.hpsf;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HPSFRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -7804271670232727159L;
    private Throwable reason;

    public HPSFRuntimeException() {
    }

    public HPSFRuntimeException(String str) {
        super(str);
    }

    public HPSFRuntimeException(Throwable th) {
        this.reason = th;
    }

    public HPSFRuntimeException(String str, Throwable th) {
        super(str);
        this.reason = th;
    }

    public Throwable getReason() {
        return this.reason;
    }
}
