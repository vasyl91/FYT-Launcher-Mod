package androidx.core.util;

import java.util.Objects;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class ObjectsCompat {
    private ObjectsCompat() {
    }

    public static boolean equals(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static int hashCode(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static int hash(Object... objArr) {
        return Objects.hash(objArr);
    }

    public static String toString(Object obj, String str) {
        return obj != null ? obj.toString() : str;
    }

    public static <T> T requireNonNull(T t) {
        t.getClass();
        return t;
    }

    public static <T> T requireNonNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
