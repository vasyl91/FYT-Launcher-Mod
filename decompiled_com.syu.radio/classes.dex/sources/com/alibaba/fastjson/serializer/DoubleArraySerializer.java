package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class DoubleArraySerializer implements ObjectSerializer {
    public static final DoubleArraySerializer instance = new DoubleArraySerializer();

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
        double[] array = (double[]) object;
        int size = array.length;
        int end = size - 1;
        if (end == -1) {
            out.append("[]");
            return;
        }
        out.append('[');
        for (int i = 0; i < end; i++) {
            double item = array[i];
            if (Double.isNaN(item)) {
                out.writeNull();
            } else {
                out.append((CharSequence) Double.toString(item));
            }
            out.append(',');
        }
        double item2 = array[end];
        if (Double.isNaN(item2)) {
            out.writeNull();
        } else {
            out.append((CharSequence) Double.toString(item2));
        }
        out.append(']');
    }
}
