package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class AtomicIntegerSerializer implements ObjectSerializer {
    public static final AtomicIntegerSerializer instance = new AtomicIntegerSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.getWriter();
        AtomicInteger val = (AtomicInteger) object;
        out.writeInt(val.get());
    }
}
