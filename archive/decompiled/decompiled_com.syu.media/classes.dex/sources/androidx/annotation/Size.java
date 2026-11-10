package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Target({ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface Size {
    long max() default Long.MAX_VALUE;

    long min() default Long.MIN_VALUE;

    long multiple() default 1;

    long value() default -1;
}
