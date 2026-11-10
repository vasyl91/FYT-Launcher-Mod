package androidx.core.os;

import android.os.Message;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    public static void setAsynchronous(Message message, boolean z) {
        message.setAsynchronous(z);
    }

    public static boolean isAsynchronous(Message message) {
        return message.isAsynchronous();
    }

    private MessageCompat() {
    }
}
