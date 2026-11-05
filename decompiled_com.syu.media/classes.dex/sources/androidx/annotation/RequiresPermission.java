package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface RequiresPermission {

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public @interface Read {
        RequiresPermission value() default @RequiresPermission;
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public @interface Write {
        RequiresPermission value() default @RequiresPermission;
    }

    String[] allOf() default {};

    String[] anyOf() default {};

    boolean conditional() default false;

    String value() default "";
}
