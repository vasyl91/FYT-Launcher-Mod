package com.alibaba.fastjson.annotation;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JSONType {
    boolean alphabetic() default true;

    boolean asm() default true;

    Class<?> builder() default Void.class;

    String[] ignores() default {};

    String[] includes() default {};

    Class<?> mappingTo() default Void.class;

    String[] orders() default {};

    Feature[] parseFeatures() default {};

    SerializerFeature[] serialzeFeatures() default {};
}
