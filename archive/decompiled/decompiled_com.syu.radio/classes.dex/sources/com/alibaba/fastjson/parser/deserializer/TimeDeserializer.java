package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import java.lang.reflect.Type;
import java.sql.Time;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class TimeDeserializer implements ObjectDeserializer {
    public static final TimeDeserializer instance = new TimeDeserializer();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        long timeInMillis;
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() == 16) {
            lexer.nextToken(4);
            if (lexer.token() != 4) {
                throw new JSONException("syntax error");
            }
            lexer.nextTokenWithColon(2);
            if (lexer.token() != 2) {
                throw new JSONException("syntax error");
            }
            long jLongValue = lexer.longValue();
            lexer.nextToken(13);
            if (lexer.token() != 13) {
                throw new JSONException("syntax error");
            }
            lexer.nextToken(16);
            return (T) new Time(jLongValue);
        }
        T t = (T) defaultJSONParser.parse();
        if (t == 0) {
            return null;
        }
        if (!(t instanceof Time)) {
            if (t instanceof Number) {
                return (T) new Time(((Number) t).longValue());
            }
            if (t instanceof String) {
                String str = (String) t;
                if (str.length() == 0) {
                    return null;
                }
                JSONScanner jSONScanner = new JSONScanner(str);
                if (jSONScanner.scanISO8601DateIfMatch()) {
                    timeInMillis = jSONScanner.getCalendar().getTimeInMillis();
                } else {
                    timeInMillis = Long.parseLong(str);
                }
                jSONScanner.close();
                return (T) new Time(timeInMillis);
            }
            throw new JSONException("parse error");
        }
        return t;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }
}
