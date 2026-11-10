package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;
import java.util.Collection;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JSONArrayDeserializer implements ObjectDeserializer {
    public static final JSONArrayDeserializer instance = new JSONArrayDeserializer();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.alibaba.fastjson.JSONArray, java.util.Collection] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        ?? r0 = (T) new JSONArray();
        defaultJSONParser.parseArray((Collection) r0);
        return r0;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 14;
    }
}
