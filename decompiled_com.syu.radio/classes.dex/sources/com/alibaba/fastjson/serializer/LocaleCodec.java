package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class LocaleCodec implements ObjectSerializer, ObjectDeserializer {
    public static final LocaleCodec instance = new LocaleCodec();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (object == null) {
            serializer.writeNull();
        } else {
            Locale locale = (Locale) object;
            serializer.write(locale.toString());
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        String str = (String) defaultJSONParser.parse();
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("_");
        if (strArrSplit.length == 1) {
            return (T) new Locale(strArrSplit[0]);
        }
        if (strArrSplit.length == 2) {
            return (T) new Locale(strArrSplit[0], strArrSplit[1]);
        }
        return (T) new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }
}
