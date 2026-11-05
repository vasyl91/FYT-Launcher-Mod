package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ArrayDeserializer implements ObjectDeserializer {
    public static final ArrayDeserializer instance = new ArrayDeserializer();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Class<?> componentType;
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() == 8) {
            lexer.nextToken(16);
            return null;
        }
        if (lexer.token() == 4) {
            T t = (T) lexer.bytesValue();
            lexer.nextToken(16);
            return t;
        }
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            if (genericComponentType instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) genericComponentType;
                Type type2 = defaultJSONParser.getContext().getType();
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type2;
                    Type rawType = parameterizedType.getRawType();
                    Type type3 = null;
                    if (rawType instanceof Class) {
                        TypeVariable<Class<T>>[] typeParameters = ((Class) rawType).getTypeParameters();
                        for (int i = 0; i < typeParameters.length; i++) {
                            if (typeParameters[i].getName().equals(typeVariable.getName())) {
                                type3 = parameterizedType.getActualTypeArguments()[i];
                            }
                        }
                    }
                    if (type3 instanceof Class) {
                        componentType = (Class) type3;
                    } else {
                        componentType = Object.class;
                    }
                } else {
                    componentType = Object.class;
                }
            } else {
                componentType = (Class) genericComponentType;
            }
        } else {
            componentType = ((Class) type).getComponentType();
        }
        JSONArray jSONArray = new JSONArray();
        defaultJSONParser.parseArray(componentType, jSONArray, obj);
        return (T) toObjectArray(defaultJSONParser, componentType, jSONArray);
    }

    private <T> T toObjectArray(DefaultJSONParser defaultJSONParser, Class<?> cls, JSONArray jSONArray) {
        Object objectArray;
        if (jSONArray == null) {
            return null;
        }
        int size = jSONArray.size();
        T t = (T) Array.newInstance(cls, size);
        for (int i = 0; i < size; i++) {
            Object obj = jSONArray.get(i);
            if (obj == jSONArray) {
                Array.set(t, i, t);
            } else if (cls.isArray()) {
                if (cls.isInstance(obj)) {
                    objectArray = obj;
                } else {
                    objectArray = toObjectArray(defaultJSONParser, cls, (JSONArray) obj);
                }
                Array.set(t, i, objectArray);
            } else {
                Object objCast = null;
                if (obj instanceof JSONArray) {
                    boolean z = false;
                    JSONArray jSONArray2 = (JSONArray) obj;
                    int size2 = jSONArray2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (jSONArray2.get(i2) == jSONArray) {
                            jSONArray2.set(i, t);
                            z = true;
                        }
                    }
                    if (z) {
                        objCast = jSONArray2.toArray();
                    }
                }
                if (objCast == null) {
                    objCast = TypeUtils.cast(obj, (Class<Object>) cls, defaultJSONParser.getConfig());
                }
                Array.set(t, i, objCast);
            }
        }
        jSONArray.setRelatedArray(t);
        jSONArray.setComponentType(cls);
        return t;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 14;
    }
}
