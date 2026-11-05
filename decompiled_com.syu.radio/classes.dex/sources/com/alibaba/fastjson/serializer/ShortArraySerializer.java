package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ShortArraySerializer implements ObjectSerializer {
    public static ShortArraySerializer instance = new ShortArraySerializer();

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
        short[] array = (short[]) object;
        out.write('[');
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                out.write(',');
            }
            out.writeInt(array[i]);
        }
        out.write(']');
    }
}
