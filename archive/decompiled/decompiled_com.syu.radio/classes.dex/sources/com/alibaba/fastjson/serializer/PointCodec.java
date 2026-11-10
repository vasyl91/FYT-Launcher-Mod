package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class PointCodec implements ObjectSerializer, ObjectDeserializer {
    public static final PointCodec instance = null;

    public PointCodec() {
        throw new Error("Unresolved compilation problems: \n\tThe import java.awt.Point cannot be resolved\n\tPoint cannot be resolved to a type\n\tPoint cannot be resolved to a type\n\tPoint cannot be resolved to a type\n\tPoint cannot be resolved to a type\n");
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        throw new Error("Unresolved compilation problems: \n\tPoint cannot be resolved to a type\n\tPoint cannot be resolved to a type\n\tPoint cannot be resolved to a type\n");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        throw new Error("Unresolved compilation problem: \n\tPoint cannot be resolved to a type\n");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        throw new Error("Unresolved compilation problem: \n");
    }
}
