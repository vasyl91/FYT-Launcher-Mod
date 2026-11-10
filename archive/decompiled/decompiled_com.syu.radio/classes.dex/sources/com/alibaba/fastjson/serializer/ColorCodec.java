package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ColorCodec implements ObjectSerializer, ObjectDeserializer {
    public static final ColorCodec instance = new ColorCodec();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        throw new Error("Unresolved compilation problems: \n\tThe method getRed() is undefined for the type Color\n\tThe method getGreen() is undefined for the type Color\n\tThe method getBlue() is undefined for the type Color\n\tThe method getAlpha() is undefined for the type Color\n\tThe method getAlpha() is undefined for the type Color\n");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        throw new Error("Unresolved compilation problem: \n\tThe constructor Color(int, int, int, int) is undefined\n");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
