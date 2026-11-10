package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface ObjectSerializer {
    void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException;
}
