package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.lsec.core.util.data.FinalChip;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class StringCodec implements ObjectSerializer, ObjectDeserializer {
    public static StringCodec instance = new StringCodec();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        write(serializer, (String) object);
    }

    public void write(JSONSerializer serializer, String value) {
        SerializeWriter out = serializer.getWriter();
        if (value == null) {
            if (out.isEnabled(SerializerFeature.WriteNullStringAsEmpty)) {
                out.writeString(FinalChip.BSP_PLATFORM_Null);
                return;
            } else {
                out.writeNull();
                return;
            }
        }
        out.writeString(value);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type == StringBuffer.class) {
            JSONLexer lexer = defaultJSONParser.getLexer();
            if (lexer.token() == 4) {
                String strStringVal = lexer.stringVal();
                lexer.nextToken(16);
                return (T) new StringBuffer(strStringVal);
            }
            Object obj2 = defaultJSONParser.parse();
            if (obj2 != null) {
                return (T) new StringBuffer(obj2.toString());
            }
            return null;
        }
        if (type == StringBuilder.class) {
            JSONLexer lexer2 = defaultJSONParser.getLexer();
            if (lexer2.token() == 4) {
                String strStringVal2 = lexer2.stringVal();
                lexer2.nextToken(16);
                return (T) new StringBuilder(strStringVal2);
            }
            Object obj3 = defaultJSONParser.parse();
            if (obj3 != null) {
                return (T) new StringBuilder(obj3.toString());
            }
            return null;
        }
        return (T) deserialze(defaultJSONParser);
    }

    public static <T> T deserialze(DefaultJSONParser defaultJSONParser) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() == 4) {
            T t = (T) lexer.stringVal();
            lexer.nextToken(16);
            return t;
        }
        if (lexer.token() == 2) {
            T t2 = (T) lexer.numberString();
            lexer.nextToken(16);
            return t2;
        }
        Object obj = defaultJSONParser.parse();
        if (obj == null) {
            return null;
        }
        return (T) obj.toString();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }
}
