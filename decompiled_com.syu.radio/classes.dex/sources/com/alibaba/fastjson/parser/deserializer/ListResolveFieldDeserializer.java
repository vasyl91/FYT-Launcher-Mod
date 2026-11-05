package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public final class ListResolveFieldDeserializer extends FieldDeserializer {
    private final int index;
    private final List list;
    private final DefaultJSONParser parser;

    public ListResolveFieldDeserializer(DefaultJSONParser parser, List list, int index) {
        super(null, null);
        this.parser = parser;
        this.index = index;
        this.list = list;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void setValue(Object object, Object value) {
        JSONArray jsonArray;
        Object array;
        Object item;
        this.list.set(this.index, value);
        if ((this.list instanceof JSONArray) && (array = (jsonArray = (JSONArray) this.list).getRelatedArray()) != null) {
            int arrayLength = Array.getLength(array);
            if (arrayLength > this.index) {
                if (jsonArray.getComponentType() != null) {
                    item = TypeUtils.cast(value, jsonArray.getComponentType(), this.parser.getConfig());
                } else {
                    item = value;
                }
                Array.set(array, this.index, item);
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser parser, Object object, Type objectType, Map<String, Object> fieldValues) {
    }
}
