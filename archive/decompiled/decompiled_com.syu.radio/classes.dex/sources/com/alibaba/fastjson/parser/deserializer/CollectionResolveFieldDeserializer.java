package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public final class CollectionResolveFieldDeserializer extends FieldDeserializer {
    private final Collection collection;

    public CollectionResolveFieldDeserializer(DefaultJSONParser parser, Collection collection) {
        super(null, null);
        this.collection = collection;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void setValue(Object object, Object value) {
        this.collection.add(value);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser parser, Object object, Type objectType, Map<String, Object> fieldValues) {
    }
}
