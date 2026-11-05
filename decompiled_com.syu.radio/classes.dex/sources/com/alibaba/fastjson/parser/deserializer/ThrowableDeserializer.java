package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig mapping, Class<?> clazz) {
        super(mapping, clazz);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object obj2;
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() == 8) {
            lexer.nextToken();
            return null;
        }
        if (defaultJSONParser.getResolveStatus() == 2) {
            defaultJSONParser.setResolveStatus(0);
        } else if (lexer.token() != 12) {
            throw new JSONException("syntax error");
        }
        Throwable th = null;
        Class<?> clsLoadClass = null;
        if (type != null && (type instanceof Class)) {
            Class<?> cls = (Class) type;
            if (Throwable.class.isAssignableFrom(cls)) {
                clsLoadClass = cls;
            }
        }
        String strStringVal = null;
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) null;
        HashMap map = new HashMap();
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
            if (JSON.DEFAULT_TYPE_KEY.equals(strScanSymbol)) {
                if (lexer.token() == 4) {
                    clsLoadClass = TypeUtils.loadClass(lexer.stringVal());
                    lexer.nextToken(16);
                } else {
                    throw new JSONException("syntax error");
                }
            } else if ("message".equals(strScanSymbol)) {
                if (lexer.token() == 8) {
                    strStringVal = null;
                } else if (lexer.token() == 4) {
                    strStringVal = lexer.stringVal();
                } else {
                    throw new JSONException("syntax error");
                }
                lexer.nextToken();
            } else if ("cause".equals(strScanSymbol)) {
                th = (Throwable) deserialze(defaultJSONParser, null, "cause");
            } else if ("stackTrace".equals(strScanSymbol)) {
                stackTraceElementArr = (StackTraceElement[]) defaultJSONParser.parseObject((Class) StackTraceElement[].class);
            } else {
                map.put(strScanSymbol, defaultJSONParser.parse());
            }
            if (lexer.token() == 13) {
                lexer.nextToken(16);
                break;
            }
        }
        if (clsLoadClass == null) {
            obj2 = (T) new Exception(strStringVal, th);
        } else {
            try {
                obj2 = (T) createException(strStringVal, th, clsLoadClass);
                if (obj2 == null) {
                    obj2 = (T) new Exception(strStringVal, th);
                }
            } catch (Exception e) {
                throw new JSONException("create instance error", e);
            }
        }
        if (stackTraceElementArr == null) {
            return (T) obj2;
        }
        ((Throwable) obj2).setStackTrace(stackTraceElementArr);
        return (T) obj2;
    }

    private Throwable createException(String message, Throwable cause, Class<?> exClass) throws Exception {
        Constructor<?> defaultConstructor = null;
        Constructor<?> messageConstructor = null;
        Constructor<?> causeConstructor = null;
        for (Constructor<?> constructor : exClass.getConstructors()) {
            if (constructor.getParameterTypes().length == 0) {
                defaultConstructor = constructor;
            } else if (constructor.getParameterTypes().length == 1 && constructor.getParameterTypes()[0] == String.class) {
                messageConstructor = constructor;
            } else if (constructor.getParameterTypes().length == 2 && constructor.getParameterTypes()[0] == String.class && constructor.getParameterTypes()[1] == Throwable.class) {
                causeConstructor = constructor;
            }
        }
        if (causeConstructor != null) {
            return (Throwable) causeConstructor.newInstance(message, cause);
        }
        if (messageConstructor != null) {
            return (Throwable) messageConstructor.newInstance(message);
        }
        if (defaultConstructor != null) {
            return (Throwable) defaultConstructor.newInstance(new Object[0]);
        }
        return null;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
