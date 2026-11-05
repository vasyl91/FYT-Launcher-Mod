package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class DateFormatSerializer implements ObjectSerializer {
    public static final DateFormatSerializer instance = new DateFormatSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.getWriter();
        if (object == null) {
            out.writeNull();
            return;
        }
        String pattern = ((SimpleDateFormat) object).toPattern();
        if (out.isEnabled(SerializerFeature.WriteClassName) && object.getClass() != fieldType) {
            out.write('{');
            out.writeFieldName(JSON.DEFAULT_TYPE_KEY);
            serializer.write(object.getClass().getName());
            out.writeFieldValue(',', "val", pattern);
            out.write('}');
            return;
        }
        out.writeString(pattern);
    }
}
