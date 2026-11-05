package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class AtomicLongArrayCodec implements ObjectSerializer, ObjectDeserializer {
    public static final AtomicLongArrayCodec instance = new AtomicLongArrayCodec();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.getWriter();
        if (object == null) {
            if (out.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
                out.write("[]");
                return;
            } else {
                out.writeNull();
                return;
            }
        }
        AtomicLongArray array = (AtomicLongArray) object;
        int len = array.length();
        out.append('[');
        for (int i = 0; i < len; i++) {
            long val = array.get(i);
            if (i != 0) {
                out.write(',');
            }
            out.writeLong(val);
        }
        out.append(']');
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.concurrent.atomic.AtomicLongArray] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (defaultJSONParser.getLexer().token() == 8) {
            defaultJSONParser.getLexer().nextToken(16);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        defaultJSONParser.parseArray(jSONArray);
        ?? r1 = (T) new AtomicLongArray(jSONArray.size());
        for (int i = 0; i < jSONArray.size(); i++) {
            r1.set(i, jSONArray.getLong(i).longValue());
        }
        return r1;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 14;
    }
}
