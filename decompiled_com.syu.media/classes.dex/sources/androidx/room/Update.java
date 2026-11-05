package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Retention(RetentionPolicy.CLASS)
public @interface Update {
    Class<?> entity() default Object.class;

    int onConflict() default 3;
}
