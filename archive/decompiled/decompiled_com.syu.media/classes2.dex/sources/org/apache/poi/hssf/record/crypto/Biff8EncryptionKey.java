package org.apache.poi.hssf.record.crypto;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Biff8EncryptionKey {
    private static final ThreadLocal<String> _userPasswordTLS = new ThreadLocal<>();

    public static void setCurrentUserPassword(String str) {
        if (str == null) {
            _userPasswordTLS.remove();
        } else {
            _userPasswordTLS.set(str);
        }
    }

    public static String getCurrentUserPassword() {
        return _userPasswordTLS.get();
    }
}
