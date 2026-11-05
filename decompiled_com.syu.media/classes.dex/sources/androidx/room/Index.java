package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Target({})
@Retention(RetentionPolicy.CLASS)
public @interface Index {
    String name() default "";

    boolean unique() default false;

    String[] value();
}
