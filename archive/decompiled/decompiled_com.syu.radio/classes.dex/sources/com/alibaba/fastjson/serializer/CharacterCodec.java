package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import com.lsec.core.util.data.FinalChip;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class CharacterCodec implements ObjectSerializer, ObjectDeserializer {
    public static final CharacterCodec instance = new CharacterCodec();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.getWriter();
        Character value = (Character) object;
        if (value == null) {
            out.writeString(FinalChip.BSP_PLATFORM_Null);
            return;
        }
        char c = value.charValue();
        if (c == 0) {
            out.writeString("\u0000");
        } else {
            out.writeString(value.toString());
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object obj2 = defaultJSONParser.parse();
        if (obj2 == null) {
            return null;
        }
        return (T) TypeUtils.castToChar(obj2);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }
}
