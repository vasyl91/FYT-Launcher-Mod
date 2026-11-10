package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class CharArrayDeserializer implements ObjectDeserializer {
    public static final CharArrayDeserializer instance = new CharArrayDeserializer();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T deserialze(DefaultJSONParser defaultJSONParser) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() == 4) {
            String strStringVal = lexer.stringVal();
            lexer.nextToken(16);
            return (T) strStringVal.toCharArray();
        }
        if (lexer.token() == 2) {
            Number numberIntegerValue = lexer.integerValue();
            lexer.nextToken(16);
            return (T) numberIntegerValue.toString().toCharArray();
        }
        Object obj = defaultJSONParser.parse();
        if (obj == null) {
            return null;
        }
        return (T) JSON.toJSONString(obj).toCharArray();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }
}
