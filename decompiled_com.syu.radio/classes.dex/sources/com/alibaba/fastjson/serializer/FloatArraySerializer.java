package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FloatArraySerializer implements ObjectSerializer {
    public static final FloatArraySerializer instance = new FloatArraySerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
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
        float[] array = (float[]) object;
        int size = array.length;
        int end = size - 1;
        if (end == -1) {
            out.append("[]");
            return;
        }
        out.append('[');
        for (int i = 0; i < end; i++) {
            float item = array[i];
            if (Float.isNaN(item)) {
                out.writeNull();
            } else {
                out.append((CharSequence) Float.toString(item));
            }
            out.append(',');
        }
        float item2 = array[end];
        if (Float.isNaN(item2)) {
            out.writeNull();
        } else {
            out.append((CharSequence) Float.toString(item2));
        }
        out.append(']');
    }
}
