package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class StackTraceElementDeserializer implements ObjectDeserializer {
    public static final StackTraceElementDeserializer instance = new StackTraceElementDeserializer();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() == 8) {
            lexer.nextToken();
            return null;
        }
        if (lexer.token() != 12 && lexer.token() != 16) {
            throw new JSONException("syntax error: " + JSONToken.name(lexer.token()));
        }
        String strStringVal = null;
        String strStringVal2 = null;
        String strStringVal3 = null;
        int iIntValue = 0;
        while (true) {
            String strScanSymbol = lexer.scanSymbol(defaultJSONParser.getSymbolTable());
            if (strScanSymbol == null) {
                if (lexer.token() == 13) {
                    lexer.nextToken(16);
                    break;
                }
                if (lexer.token() != 16 || !lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                }
            }
            lexer.nextTokenWithColon(4);
            if ("className".equals(strScanSymbol)) {
                if (lexer.token() == 8) {
                    strStringVal = null;
                } else if (lexer.token() == 4) {
                    strStringVal = lexer.stringVal();
                } else {
                    throw new JSONException("syntax error");
                }
            } else if ("methodName".equals(strScanSymbol)) {
                if (lexer.token() == 8) {
                    strStringVal2 = null;
                } else if (lexer.token() == 4) {
                    strStringVal2 = lexer.stringVal();
                } else {
                    throw new JSONException("syntax error");
                }
            } else if ("fileName".equals(strScanSymbol)) {
                if (lexer.token() == 8) {
                    strStringVal3 = null;
                } else if (lexer.token() == 4) {
                    strStringVal3 = lexer.stringVal();
                } else {
                    throw new JSONException("syntax error");
                }
            } else if ("lineNumber".equals(strScanSymbol)) {
                if (lexer.token() == 8) {
                    iIntValue = 0;
                } else if (lexer.token() == 2) {
                    iIntValue = lexer.intValue();
                } else {
                    throw new JSONException("syntax error");
                }
            } else if ("nativeMethod".equals(strScanSymbol)) {
                if (lexer.token() == 8 || lexer.token() == 6 || lexer.token() == 7) {
                    lexer.nextToken(16);
                } else {
                    throw new JSONException("syntax error");
                }
            } else if (strScanSymbol == JSON.DEFAULT_TYPE_KEY) {
                if (lexer.token() == 4) {
                    String strStringVal4 = lexer.stringVal();
                    if (!strStringVal4.equals("java.lang.StackTraceElement")) {
                        throw new JSONException("syntax error : " + strStringVal4);
                    }
                } else if (lexer.token() != 8) {
                    throw new JSONException("syntax error");
                }
            } else {
                throw new JSONException("syntax error : " + strScanSymbol);
            }
            if (lexer.token() == 13) {
                lexer.nextToken(16);
                break;
            }
        }
        return (T) new StackTraceElement(strStringVal, strStringVal2, strStringVal3, iIntValue);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
