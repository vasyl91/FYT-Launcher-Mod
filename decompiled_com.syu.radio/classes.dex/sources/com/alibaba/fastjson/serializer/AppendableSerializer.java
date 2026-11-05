package com.alibaba.fastjson.serializer;

import com.lsec.core.util.data.FinalChip;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class AppendableSerializer implements ObjectSerializer {
    public static final AppendableSerializer instance = new AppendableSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (object == null) {
            SerializeWriter out = serializer.getWriter();
            if (out.isEnabled(SerializerFeature.WriteNullStringAsEmpty)) {
                out.writeString(FinalChip.BSP_PLATFORM_Null);
                return;
            } else {
                out.writeNull();
                return;
            }
        }
        serializer.write(object.toString());
    }
}
