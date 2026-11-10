package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ExceptionSerializer extends JavaBeanSerializer {
    public ExceptionSerializer(Class<?> clazz) {
        super(clazz);
    }

    @Override // com.alibaba.fastjson.serializer.JavaBeanSerializer
    protected boolean isWriteClassName(JSONSerializer serializer, Object obj, Type fieldType, Object fieldName) {
        return true;
    }
}
