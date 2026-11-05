package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public abstract class AbstractDateDeserializer implements ObjectDeserializer {
    protected abstract <T> T cast(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2);

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object objValueOf;
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() == 2) {
            objValueOf = Long.valueOf(lexer.longValue());
            lexer.nextToken(16);
        } else if (lexer.token() == 4) {
            String strStringVal = lexer.stringVal();
            objValueOf = strStringVal;
            lexer.nextToken(16);
            if (lexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                JSONScanner jSONScanner = new JSONScanner(strStringVal);
                if (jSONScanner.scanISO8601DateIfMatch()) {
                    objValueOf = jSONScanner.getCalendar().getTime();
                }
                jSONScanner.close();
            }
        } else if (lexer.token() == 8) {
            lexer.nextToken();
            objValueOf = null;
        } else if (lexer.token() == 12) {
            lexer.nextToken();
            if (lexer.token() == 4) {
                if (JSON.DEFAULT_TYPE_KEY.equals(lexer.stringVal())) {
                    lexer.nextToken();
                    defaultJSONParser.accept(17);
                    Class<?> clsLoadClass = TypeUtils.loadClass(lexer.stringVal());
                    if (clsLoadClass != null) {
                        type = clsLoadClass;
                    }
                    defaultJSONParser.accept(4);
                    defaultJSONParser.accept(16);
                }
                lexer.nextTokenWithColon(2);
                if (lexer.token() == 2) {
                    long jLongValue = lexer.longValue();
                    lexer.nextToken();
                    objValueOf = Long.valueOf(jLongValue);
                    defaultJSONParser.accept(13);
                } else {
                    throw new JSONException("syntax error : " + lexer.tokenName());
                }
            } else {
                throw new JSONException("syntax error");
            }
        } else if (defaultJSONParser.getResolveStatus() == 2) {
            defaultJSONParser.setResolveStatus(0);
            defaultJSONParser.accept(16);
            if (lexer.token() == 4) {
                if (!"val".equals(lexer.stringVal())) {
                    throw new JSONException("syntax error");
                }
                lexer.nextToken();
                defaultJSONParser.accept(17);
                objValueOf = defaultJSONParser.parse();
                defaultJSONParser.accept(13);
            } else {
                throw new JSONException("syntax error");
            }
        } else {
            objValueOf = defaultJSONParser.parse();
        }
        return (T) cast(defaultJSONParser, type, obj, objValueOf);
    }
}
