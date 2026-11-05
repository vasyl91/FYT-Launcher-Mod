package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class BooleanCodec implements ObjectSerializer, ObjectDeserializer {
    public static final BooleanCodec instance = new BooleanCodec();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.getWriter();
        Boolean value = (Boolean) object;
        if (value == null) {
            if (out.isEnabled(SerializerFeature.WriteNullBooleanAsFalse)) {
                out.write("false");
                return;
            } else {
                out.writeNull();
                return;
            }
        }
        if (value.booleanValue()) {
            out.write("true");
        } else {
            out.write("false");
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object obj2;
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() == 6) {
            lexer.nextToken(16);
            obj2 = (T) Boolean.TRUE;
        } else if (lexer.token() == 7) {
            lexer.nextToken(16);
            obj2 = (T) Boolean.FALSE;
        } else if (lexer.token() == 2) {
            int iIntValue = lexer.intValue();
            lexer.nextToken(16);
            if (iIntValue == 1) {
                obj2 = (T) Boolean.TRUE;
            } else {
                obj2 = (T) Boolean.FALSE;
            }
        } else {
            Object obj3 = defaultJSONParser.parse();
            if (obj3 == null) {
                return null;
            }
            obj2 = (T) TypeUtils.castToBoolean(obj3);
        }
        return type == AtomicBoolean.class ? (T) new AtomicBoolean(((Boolean) obj2).booleanValue()) : (T) obj2;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 6;
    }
}
