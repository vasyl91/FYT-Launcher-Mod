package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FloatCodec implements ObjectSerializer, ObjectDeserializer {
    public static FloatCodec instance = new FloatCodec();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.getWriter();
        if (object == null) {
            if (serializer.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
                out.write('0');
                return;
            } else {
                out.writeNull();
                return;
            }
        }
        float floatValue = ((Float) object).floatValue();
        if (Float.isNaN(floatValue)) {
            out.writeNull();
            return;
        }
        if (Float.isInfinite(floatValue)) {
            out.writeNull();
            return;
        }
        String floatText = Float.toString(floatValue);
        if (floatText.endsWith(".0")) {
            floatText = floatText.substring(0, floatText.length() - 2);
        }
        out.write(floatText);
        if (serializer.isEnabled(SerializerFeature.WriteClassName)) {
            out.write('F');
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser);
    }

    public static <T> T deserialze(DefaultJSONParser defaultJSONParser) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() == 2) {
            String strNumberString = lexer.numberString();
            lexer.nextToken(16);
            return (T) Float.valueOf(Float.parseFloat(strNumberString));
        }
        if (lexer.token() == 3) {
            float fFloatValue = lexer.floatValue();
            lexer.nextToken(16);
            return (T) Float.valueOf(fFloatValue);
        }
        Object obj = defaultJSONParser.parse();
        if (obj == null) {
            return null;
        }
        return (T) TypeUtils.castToFloat(obj);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }
}
