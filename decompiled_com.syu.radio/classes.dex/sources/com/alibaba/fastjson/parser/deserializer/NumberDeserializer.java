package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class NumberDeserializer implements ObjectDeserializer {
    public static final NumberDeserializer instance = new NumberDeserializer();

    /* JADX WARN: Type inference failed for: r2v7, types: [T, java.math.BigDecimal] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String strNumberString = lexer.numberString();
                lexer.nextToken(16);
                return (T) Double.valueOf(Double.parseDouble(strNumberString));
            }
            long jLongValue = lexer.longValue();
            lexer.nextToken(16);
            if (type == Short.TYPE || type == Short.class) {
                return (T) Short.valueOf((short) jLongValue);
            }
            if (type == Byte.TYPE || type == Byte.class) {
                return (T) Byte.valueOf((byte) jLongValue);
            }
            if (jLongValue >= -2147483648L && jLongValue <= 2147483647L) {
                return (T) Integer.valueOf((int) jLongValue);
            }
            return (T) Long.valueOf(jLongValue);
        }
        if (lexer.token() == 3) {
            if (type == Double.TYPE || type == Double.class) {
                String strNumberString2 = lexer.numberString();
                lexer.nextToken(16);
                return (T) Double.valueOf(Double.parseDouble(strNumberString2));
            }
            ?? r2 = (T) lexer.decimalValue();
            lexer.nextToken(16);
            if (type == Short.TYPE || type == Short.class) {
                return (T) Short.valueOf(r2.shortValue());
            }
            if (type == Byte.TYPE || type == Byte.class) {
                return (T) Byte.valueOf(r2.byteValue());
            }
            return r2;
        }
        Object obj2 = defaultJSONParser.parse();
        if (obj2 == null) {
            return null;
        }
        if (type == Double.TYPE || type == Double.class) {
            return (T) TypeUtils.castToDouble(obj2);
        }
        if (type == Short.TYPE || type == Short.class) {
            return (T) TypeUtils.castToShort(obj2);
        }
        if (type == Byte.TYPE || type == Byte.class) {
            return (T) TypeUtils.castToByte(obj2);
        }
        return (T) TypeUtils.castToBigDecimal(obj2);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }
}
