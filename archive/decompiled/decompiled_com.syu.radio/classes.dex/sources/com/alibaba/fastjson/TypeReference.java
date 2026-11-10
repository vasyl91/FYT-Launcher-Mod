package com.alibaba.fastjson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class TypeReference<T> {
    public static final Type LIST_STRING = new TypeReference<List<String>>() { // from class: com.alibaba.fastjson.TypeReference.1
    }.getType();
    private final Type type;

    protected TypeReference() {
        Type superClass = getClass().getGenericSuperclass();
        this.type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
    }

    public Type getType() {
        return this.type;
    }
}
