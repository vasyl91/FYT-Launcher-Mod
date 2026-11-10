package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JavaBeanSerializer implements ObjectSerializer {
    private int features;
    private transient Map<String, FieldSerializer> getterMap;
    private final FieldSerializer[] getters;
    private final FieldSerializer[] sortedGetters;

    public FieldSerializer[] getGetters() {
        return this.getters;
    }

    public JavaBeanSerializer(Class<?> clazz) {
        this(clazz, (Map<String, String>) null);
    }

    public JavaBeanSerializer(Class<?> clazz, String... aliasList) {
        this(clazz, createAliasMap(aliasList));
    }

    static Map<String, String> createAliasMap(String... aliasList) {
        Map<String, String> aliasMap = new HashMap<>();
        for (String alias : aliasList) {
            aliasMap.put(alias, alias);
        }
        return aliasMap;
    }

    public JavaBeanSerializer(Class<?> clazz, Map<String, String> aliasMap) {
        this.features = 0;
        this.features = TypeUtils.getSerializeFeatures(clazz);
        List<FieldSerializer> getterList = new ArrayList<>();
        List<FieldInfo> fieldInfoList = TypeUtils.computeGetters(clazz, aliasMap, false);
        for (FieldInfo fieldInfo : fieldInfoList) {
            getterList.add(createFieldSerializer(fieldInfo));
        }
        this.getters = (FieldSerializer[]) getterList.toArray(new FieldSerializer[getterList.size()]);
        List<FieldSerializer> getterList2 = new ArrayList<>();
        List<FieldInfo> fieldInfoList2 = TypeUtils.computeGetters(clazz, aliasMap, true);
        for (FieldInfo fieldInfo2 : fieldInfoList2) {
            getterList2.add(createFieldSerializer(fieldInfo2));
        }
        this.sortedGetters = (FieldSerializer[]) getterList2.toArray(new FieldSerializer[getterList2.size()]);
    }

    protected boolean isWriteClassName(JSONSerializer serializer, Object obj, Type fieldType, Object fieldName) {
        return serializer.isWriteClassName(fieldType, obj);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x028e */
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r30, java.lang.Object r31, java.lang.Object r32, java.lang.reflect.Type r33, int r34) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 686
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int):void");
    }

    public boolean writeReference(JSONSerializer serializer, Object object, int fieldFeatures) {
        SerialContext context = serializer.getContext();
        if ((context != null && SerializerFeature.isEnabled(context.getFeatures(), fieldFeatures, SerializerFeature.DisableCircularReferenceDetect)) || !serializer.containsReference(object)) {
            return false;
        }
        serializer.writeReference(object);
        return true;
    }

    public FieldSerializer createFieldSerializer(FieldInfo fieldInfo) {
        Class<?> clazz = fieldInfo.getFieldClass();
        return clazz == Number.class ? new NumberFieldSerializer(fieldInfo) : new ObjectFieldSerializer(fieldInfo);
    }

    public boolean isWriteAsArray(JSONSerializer serializer) {
        if (SerializerFeature.isEnabled(this.features, SerializerFeature.BeanToArray) || serializer.isEnabled(SerializerFeature.BeanToArray)) {
            return true;
        }
        return false;
    }

    public Map<String, FieldSerializer> getGetterMap() {
        if (this.getterMap == null) {
            HashMap<String, FieldSerializer> map = new HashMap<>(this.getters.length);
            for (FieldSerializer getter : this.sortedGetters) {
                map.put(getter.getName(), getter);
            }
            this.getterMap = map;
        }
        return this.getterMap;
    }

    public Object getFieldValue(Object object, String name) throws Exception {
        Map<String, FieldSerializer> map = getGetterMap();
        FieldSerializer getter = map.get(name);
        if (getter == null) {
            return null;
        }
        return getter.getPropertyValue(object);
    }

    public List<Object> getFieldValues(Object object) throws Exception {
        List<Object> fieldValues = new ArrayList<>(this.sortedGetters.length);
        for (FieldSerializer getter : this.sortedGetters) {
            fieldValues.add(getter.getPropertyValue(object));
        }
        return fieldValues;
    }
}
