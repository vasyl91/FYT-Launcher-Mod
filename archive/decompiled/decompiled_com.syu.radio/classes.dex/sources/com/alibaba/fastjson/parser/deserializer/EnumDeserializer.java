package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class EnumDeserializer implements ObjectDeserializer {
    private final Class<?> enumClass;
    private final Map<Integer, Enum> ordinalMap = new HashMap();
    private final Map<String, Enum> nameMap = new HashMap();

    public EnumDeserializer(Class<?> enumClass) {
        this.enumClass = enumClass;
        try {
            Method valueMethod = enumClass.getMethod("values", new Class[0]);
            Object[] values = (Object[]) valueMethod.invoke(null, new Object[0]);
            for (Object value : values) {
                Enum e = (Enum) value;
                this.ordinalMap.put(Integer.valueOf(e.ordinal()), e);
                this.nameMap.put(e.name(), e);
            }
        } catch (Exception e2) {
            throw new JSONException("init enum values error, " + enumClass.getName());
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            JSONLexer lexer = defaultJSONParser.getLexer();
            if (lexer.token() == 2) {
                Integer numValueOf = Integer.valueOf(lexer.intValue());
                lexer.nextToken(16);
                T t = (T) this.ordinalMap.get(numValueOf);
                if (t == null) {
                    throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + numValueOf);
                }
                return t;
            }
            if (lexer.token() == 4) {
                String strStringVal = lexer.stringVal();
                lexer.nextToken(16);
                if (strStringVal.length() == 0) {
                    return null;
                }
                this.nameMap.get(strStringVal);
                return (T) Enum.valueOf(this.enumClass, strStringVal);
            }
            if (lexer.token() == 8) {
                lexer.nextToken(16);
                return null;
            }
            throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + defaultJSONParser.parse());
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }
}
