package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class IntegerFieldDeserializer extends FieldDeserializer {
    public IntegerFieldDeserializer(ParserConfig mapping, Class<?> clazz, FieldInfo fieldInfo) {
        super(clazz, fieldInfo);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser parser, Object object, Type objectType, Map<String, Object> fieldValues) {
        Integer value;
        JSONLexer lexer = parser.getLexer();
        if (lexer.token() == 2) {
            int val = lexer.intValue();
            lexer.nextToken(16);
            if (object == null) {
                fieldValues.put(this.fieldInfo.getName(), Integer.valueOf(val));
                return;
            } else {
                setValue(object, val);
                return;
            }
        }
        if (lexer.token() == 8) {
            value = null;
            lexer.nextToken(16);
        } else {
            Object obj = parser.parse();
            value = TypeUtils.castToInt(obj);
        }
        if (value != null || getFieldClass() != Integer.TYPE) {
            if (object == null) {
                fieldValues.put(this.fieldInfo.getName(), value);
            } else {
                setValue(object, value);
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public int getFastMatchToken() {
        return 2;
    }
}
