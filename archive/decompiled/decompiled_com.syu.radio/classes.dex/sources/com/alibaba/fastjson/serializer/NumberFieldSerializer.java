package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.FieldInfo;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
final class NumberFieldSerializer extends FieldSerializer {
    public NumberFieldSerializer(FieldInfo fieldInfo) {
        super(fieldInfo);
    }

    @Override // com.alibaba.fastjson.serializer.FieldSerializer
    public void writeProperty(JSONSerializer serializer, Object propertyValue) throws Exception {
        writePrefix(serializer);
        writeValue(serializer, propertyValue);
    }

    @Override // com.alibaba.fastjson.serializer.FieldSerializer
    public void writeValue(JSONSerializer serializer, Object propertyValue) throws Exception {
        SerializeWriter out = serializer.getWriter();
        if (propertyValue == null) {
            if (out.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
                out.write('0');
                return;
            } else {
                out.writeNull();
                return;
            }
        }
        out.append((CharSequence) propertyValue.toString());
    }
}
