package com.alibaba.fastjson.serializer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class EnumerationSeriliazer implements ObjectSerializer {
    public static EnumerationSeriliazer instance = new EnumerationSeriliazer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws Throwable {
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
        Type elementType = null;
        if (serializer.isEnabled(SerializerFeature.WriteClassName) && (fieldType instanceof ParameterizedType)) {
            ParameterizedType param = (ParameterizedType) fieldType;
            elementType = param.getActualTypeArguments()[0];
        }
        Enumeration<?> e = (Enumeration) object;
        SerialContext context = serializer.getContext();
        serializer.setContext(context, object, fieldName, 0);
        try {
            out.append('[');
            int i = 0;
            while (e.hasMoreElements()) {
                try {
                    Object item = e.nextElement();
                    i++;
                    if (i != 0) {
                        out.append(',');
                    }
                    if (item == null) {
                        out.writeNull();
                    } else {
                        Class<?> clazz = item.getClass();
                        ObjectSerializer itemSerializer = serializer.getObjectWriter(clazz);
                        itemSerializer.write(serializer, item, Integer.valueOf(i - 1), elementType, 0);
                    }
                } catch (Throwable th) {
                    th = th;
                    serializer.setContext(context);
                    throw th;
                }
            }
            out.append(']');
            serializer.setContext(context);
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
