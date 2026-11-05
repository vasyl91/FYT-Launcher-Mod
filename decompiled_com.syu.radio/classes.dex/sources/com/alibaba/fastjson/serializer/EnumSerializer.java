package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class EnumSerializer implements ObjectSerializer {
    public static final EnumSerializer instance = new EnumSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.getWriter();
        if (object == null) {
            serializer.getWriter().writeNull();
            return;
        }
        Enum<?> e = (Enum) object;
        if (serializer.isEnabled(SerializerFeature.WriteEnumUsingName)) {
            serializer.write(e.name());
        } else if (serializer.isEnabled(SerializerFeature.WriteEnumUsingToString)) {
            serializer.write(e.toString());
        } else {
            out.writeInt(e.ordinal());
        }
    }
}
