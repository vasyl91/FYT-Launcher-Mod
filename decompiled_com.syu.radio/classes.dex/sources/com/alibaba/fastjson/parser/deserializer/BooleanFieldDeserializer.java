package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class BooleanFieldDeserializer extends FieldDeserializer {
    public BooleanFieldDeserializer(ParserConfig mapping, Class<?> clazz, FieldInfo fieldInfo) {
        super(clazz, fieldInfo);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser parser, Object object, Type objectType, Map<String, Object> fieldValues) {
        JSONLexer lexer = parser.getLexer();
        if (lexer.token() == 6) {
            lexer.nextToken(16);
            if (object == null) {
                fieldValues.put(this.fieldInfo.getName(), Boolean.TRUE);
                return;
            } else {
                setValue(object, true);
                return;
            }
        }
        if (lexer.token() == 2) {
            int val = lexer.intValue();
            lexer.nextToken(16);
            boolean booleanValue = val == 1;
            if (object == null) {
                fieldValues.put(this.fieldInfo.getName(), Boolean.valueOf(booleanValue));
                return;
            } else {
                setValue(object, booleanValue);
                return;
            }
        }
        if (lexer.token() == 8) {
            lexer.nextToken(16);
            if (getFieldClass() != Boolean.TYPE && object != null) {
                setValue(object, (String) null);
                return;
            }
            return;
        }
        if (lexer.token() == 7) {
            lexer.nextToken(16);
            if (object == null) {
                fieldValues.put(this.fieldInfo.getName(), Boolean.FALSE);
                return;
            } else {
                setValue(object, false);
                return;
            }
        }
        Object obj = parser.parse();
        Boolean value = TypeUtils.castToBoolean(obj);
        if (value != null || getFieldClass() != Boolean.TYPE) {
            if (object == null) {
                fieldValues.put(this.fieldInfo.getName(), value);
            } else {
                setValue(object, value);
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public int getFastMatchToken() {
        return 6;
    }
}
