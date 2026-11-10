package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public abstract class ASMJavaBeanSerializer implements ObjectSerializer {
    protected JavaBeanSerializer nature;

    public ASMJavaBeanSerializer(Class<?> clazz) {
        this.nature = new JavaBeanSerializer(clazz);
    }

    public JavaBeanSerializer getJavaBeanSerializer() {
        return this.nature;
    }
}
