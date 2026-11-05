package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JavaObjectDeserializer implements ObjectDeserializer {
    public static final JavaObjectDeserializer instance = new JavaObjectDeserializer();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            if (genericComponentType instanceof TypeVariable) {
                genericComponentType = ((TypeVariable) genericComponentType).getBounds()[0];
            }
            ArrayList arrayList = new ArrayList();
            defaultJSONParser.parseArray(genericComponentType, arrayList);
            if (genericComponentType instanceof Class) {
                Class cls = (Class) genericComponentType;
                if (cls == Boolean.TYPE) {
                    return (T) TypeUtils.cast((Object) arrayList, boolean[].class, defaultJSONParser.getConfig());
                }
                if (cls == Short.TYPE) {
                    return (T) TypeUtils.cast((Object) arrayList, short[].class, defaultJSONParser.getConfig());
                }
                if (cls == Integer.TYPE) {
                    return (T) TypeUtils.cast((Object) arrayList, int[].class, defaultJSONParser.getConfig());
                }
                if (cls == Long.TYPE) {
                    return (T) TypeUtils.cast((Object) arrayList, long[].class, defaultJSONParser.getConfig());
                }
                if (cls == Float.TYPE) {
                    return (T) TypeUtils.cast((Object) arrayList, float[].class, defaultJSONParser.getConfig());
                }
                if (cls == Double.TYPE) {
                    return (T) TypeUtils.cast((Object) arrayList, double[].class, defaultJSONParser.getConfig());
                }
                T t = (T) ((Object[]) Array.newInstance((Class<?>) cls, arrayList.size()));
                arrayList.toArray((Object[]) t);
                return t;
            }
            return (T) arrayList.toArray();
        }
        return (T) defaultJSONParser.parse(obj);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
