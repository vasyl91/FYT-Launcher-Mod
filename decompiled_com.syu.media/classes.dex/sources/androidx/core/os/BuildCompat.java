package androidx.core.os;

import android.os.Build;
import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class BuildCompat {

    public @interface PrereleaseSdkCheck {
    }

    @Deprecated
    public static boolean isAtLeastN() {
        return true;
    }

    @Deprecated
    public static boolean isAtLeastNMR1() {
        return true;
    }

    @Deprecated
    public static boolean isAtLeastO() {
        return true;
    }

    private BuildCompat() {
    }

    protected static boolean isAtLeastPreReleaseCodename(String str, String str2) {
        return !"REL".equals(str2) && str2.compareTo(str) >= 0;
    }

    @Deprecated
    public static boolean isAtLeastOMR1() {
        return Build.VERSION.SDK_INT >= 27;
    }

    @Deprecated
    public static boolean isAtLeastP() {
        return Build.VERSION.SDK_INT >= 28;
    }

    @Deprecated
    public static boolean isAtLeastQ() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Deprecated
    public static boolean isAtLeastR() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean isAtLeastS() {
        return Build.VERSION.SDK_INT >= 31 || isAtLeastPreReleaseCodename(ExifInterface.LATITUDE_SOUTH, Build.VERSION.CODENAME);
    }

    public static boolean isAtLeastT() {
        return isAtLeastPreReleaseCodename(ExifInterface.GPS_DIRECTION_TRUE, Build.VERSION.CODENAME);
    }
}
