package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class SimpleDateFormatSerializer implements ObjectSerializer {
    private final String pattern;

    public SimpleDateFormatSerializer(String pattern) {
        this.pattern = pattern;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (object == null) {
            serializer.getWriter().writeNull();
            return;
        }
        Date date = (Date) object;
        SimpleDateFormat format = new SimpleDateFormat(this.pattern);
        String text = format.format(date);
        serializer.write(text);
    }
}
