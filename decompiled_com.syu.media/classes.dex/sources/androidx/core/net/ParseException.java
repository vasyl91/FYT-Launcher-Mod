package androidx.core.net;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ParseException extends RuntimeException {
    public final String response;

    ParseException(String str) {
        super(str);
        this.response = str;
    }
}
