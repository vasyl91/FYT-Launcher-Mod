package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class DefaultFieldDeserializer extends FieldDeserializer {
    private ObjectDeserializer fieldValueDeserilizer;

    public DefaultFieldDeserializer(ParserConfig mapping, Class<?> clazz, FieldInfo fieldInfo) {
        super(clazz, fieldInfo);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser parser, Object object, Type objectType, Map<String, Object> fieldValues) {
        if (this.fieldValueDeserilizer == null) {
            this.fieldValueDeserilizer = parser.getConfig().getDeserializer(this.fieldInfo);
        }
        if (objectType instanceof ParameterizedType) {
            ParseContext objContext = parser.getContext();
            objContext.setType(objectType);
        }
        Object value = this.fieldValueDeserilizer.deserialze(parser, getFieldType(), this.fieldInfo.getName());
        if (parser.getResolveStatus() == 1) {
            DefaultJSONParser.ResolveTask task = parser.getLastResolveTask();
            task.setFieldDeserializer(this);
            task.setOwnerContext(parser.getContext());
            parser.setResolveStatus(0);
            return;
        }
        if (object == null) {
            fieldValues.put(this.fieldInfo.getName(), value);
        } else {
            setValue(object, value);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public int getFastMatchToken() {
        if (this.fieldValueDeserilizer != null) {
            return this.fieldValueDeserilizer.getFastMatchToken();
        }
        return 2;
    }
}
