package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FontCodec implements ObjectSerializer, ObjectDeserializer {
    public static final FontCodec instance = null;

    public FontCodec() {
        throw new Error("Unresolved compilation problems: \n\tThe import java.awt.Font cannot be resolved\n\tFont cannot be resolved to a type\n\tFont cannot be resolved to a type\n\tFont cannot be resolved to a type\n\tFont cannot be resolved to a type\n");
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        throw new Error("Unresolved compilation problems: \n\tFont cannot be resolved to a type\n\tFont cannot be resolved to a type\n\tFont cannot be resolved to a type\n");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        throw new Error("Unresolved compilation problem: \n\tFont cannot be resolved to a type\n");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        throw new Error("Unresolved compilation problem: \n");
    }
}
