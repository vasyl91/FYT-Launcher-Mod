package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class CursorWindowCompat {
    private CursorWindowCompat() {
    }

    public static CursorWindow create(String str, long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new CursorWindow(str, j);
        }
        return new CursorWindow(str);
    }
}
