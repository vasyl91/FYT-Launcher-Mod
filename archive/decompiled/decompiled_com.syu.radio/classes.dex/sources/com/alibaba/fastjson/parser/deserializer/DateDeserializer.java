package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONScanner;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class DateDeserializer extends AbstractDateDeserializer implements ObjectDeserializer {
    public static final DateDeserializer instance = new DateDeserializer();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.util.Calendar] */
    @Override // com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer
    protected <T> T cast(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        if (obj2 == 0) {
            return null;
        }
        if (obj2 instanceof Date) {
            return obj2;
        }
        if (obj2 instanceof Number) {
            return (T) new Date(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new JSONException("parse error");
        }
        String str = (String) obj2;
        if (str.length() == 0) {
            return null;
        }
        JSONScanner jSONScanner = new JSONScanner(str);
        try {
            if (!jSONScanner.scanISO8601DateIfMatch(false)) {
                jSONScanner.close();
                try {
                    return (T) defaultJSONParser.getDateFormat().parse(str);
                } catch (ParseException e) {
                    return (T) new Date(Long.parseLong(str));
                }
            }
            ?? r0 = (T) jSONScanner.getCalendar();
            if (type == Calendar.class) {
                jSONScanner.close();
                return r0;
            }
            T t = (T) r0.getTime();
            jSONScanner.close();
            return t;
        } catch (Throwable th) {
            jSONScanner.close();
            throw th;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }
}
