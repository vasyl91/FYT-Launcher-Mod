package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Retention(RetentionPolicy.CLASS)
public @interface OnConflictStrategy {
    public static final int ABORT = 3;

    @Deprecated
    public static final int FAIL = 4;
    public static final int IGNORE = 5;
    public static final int REPLACE = 1;

    @Deprecated
    public static final int ROLLBACK = 2;
}
