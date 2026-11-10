package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface PropertyPreFilter extends SerializeFilter {
    boolean apply(JSONSerializer jSONSerializer, Object obj, String str);
}
