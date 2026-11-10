package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface JSONSerializable {
    void write(JSONSerializer jSONSerializer, Object obj, Type type, int i) throws IOException;
}
