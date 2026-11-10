package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.FieldInfo;
import java.util.Collection;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ObjectFieldSerializer extends FieldSerializer {
    private String format;
    private RuntimeSerializerInfo runtimeInfo;
    boolean writeEnumUsingName;
    boolean writeEnumUsingToString;
    boolean writeNullBooleanAsFalse;
    boolean writeNullListAsEmpty;
    boolean writeNullStringAsEmpty;
    boolean writeNumberAsZero;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObjectFieldSerializer(FieldInfo fieldInfo) {
        super(fieldInfo);
        this.writeNumberAsZero = false;
        this.writeNullStringAsEmpty = false;
        this.writeNullBooleanAsFalse = false;
        this.writeNullListAsEmpty = false;
        this.writeEnumUsingToString = false;
        this.writeEnumUsingName = false;
        JSONField annotation = (JSONField) fieldInfo.getAnnotation(JSONField.class);
        if (annotation != null) {
            this.format = annotation.format();
            if (this.format.trim().length() == 0) {
                this.format = null;
            }
            for (SerializerFeature feature : annotation.serialzeFeatures()) {
                if (feature == SerializerFeature.WriteNullNumberAsZero) {
                    this.writeNumberAsZero = true;
                } else if (feature == SerializerFeature.WriteNullStringAsEmpty) {
                    this.writeNullStringAsEmpty = true;
                } else if (feature == SerializerFeature.WriteNullBooleanAsFalse) {
                    this.writeNullBooleanAsFalse = true;
                } else if (feature == SerializerFeature.WriteNullListAsEmpty) {
                    this.writeNullListAsEmpty = true;
                } else if (feature == SerializerFeature.WriteEnumUsingToString) {
                    this.writeEnumUsingToString = true;
                } else if (feature == SerializerFeature.WriteEnumUsingName) {
                    this.writeEnumUsingName = true;
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.serializer.FieldSerializer
    public void writeProperty(JSONSerializer serializer, Object propertyValue) throws Exception {
        writePrefix(serializer);
        writeValue(serializer, propertyValue);
    }

    @Override // com.alibaba.fastjson.serializer.FieldSerializer
    public void writeValue(JSONSerializer serializer, Object propertyValue) throws Exception {
        Class<?> runtimeFieldClass;
        if (this.format != null) {
            serializer.writeWithFormat(propertyValue, this.format);
            return;
        }
        if (this.runtimeInfo == null) {
            if (propertyValue == null) {
                runtimeFieldClass = this.fieldInfo.getFieldClass();
            } else {
                runtimeFieldClass = propertyValue.getClass();
            }
            ObjectSerializer fieldSerializer = serializer.getObjectWriter(runtimeFieldClass);
            this.runtimeInfo = new RuntimeSerializerInfo(fieldSerializer, runtimeFieldClass);
        }
        RuntimeSerializerInfo runtimeInfo = this.runtimeInfo;
        int fieldFeatures = this.fieldInfo.getSerialzeFeatures();
        if (propertyValue == null) {
            if (this.writeNumberAsZero && Number.class.isAssignableFrom(runtimeInfo.runtimeFieldClass)) {
                serializer.getWriter().write('0');
                return;
            }
            if (this.writeNullStringAsEmpty && String.class == runtimeInfo.runtimeFieldClass) {
                serializer.getWriter().write("\"\"");
                return;
            }
            if (this.writeNullBooleanAsFalse && Boolean.class == runtimeInfo.runtimeFieldClass) {
                serializer.getWriter().write("false");
                return;
            } else if (this.writeNullListAsEmpty && Collection.class.isAssignableFrom(runtimeInfo.runtimeFieldClass)) {
                serializer.getWriter().write("[]");
                return;
            } else {
                runtimeInfo.fieldSerializer.write(serializer, null, this.fieldInfo.getName(), null, fieldFeatures);
                return;
            }
        }
        if (runtimeInfo.runtimeFieldClass.isEnum()) {
            if (this.writeEnumUsingName) {
                serializer.getWriter().writeString(((Enum) propertyValue).name());
                return;
            } else if (this.writeEnumUsingToString) {
                serializer.getWriter().writeString(((Enum) propertyValue).toString());
                return;
            }
        }
        Class<?> valueClass = propertyValue.getClass();
        if (valueClass == runtimeInfo.runtimeFieldClass) {
            runtimeInfo.fieldSerializer.write(serializer, propertyValue, this.fieldInfo.getName(), this.fieldInfo.getFieldType(), fieldFeatures);
        } else {
            ObjectSerializer valueSerializer = serializer.getObjectWriter(valueClass);
            valueSerializer.write(serializer, propertyValue, this.fieldInfo.getName(), this.fieldInfo.getFieldType(), fieldFeatures);
        }
    }

    static class RuntimeSerializerInfo {
        ObjectSerializer fieldSerializer;
        Class<?> runtimeFieldClass;

        public RuntimeSerializerInfo(ObjectSerializer fieldSerializer, Class<?> runtimeFieldClass) {
            this.fieldSerializer = fieldSerializer;
            this.runtimeFieldClass = runtimeFieldClass;
        }
    }
}
