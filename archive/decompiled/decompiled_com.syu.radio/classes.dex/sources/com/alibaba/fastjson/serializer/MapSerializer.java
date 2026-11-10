package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class MapSerializer implements ObjectSerializer {
    public static MapSerializer instance = new MapSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.getWriter();
        if (object == null) {
            out.writeNull();
            return;
        }
        Map<?, ?> map = (Map) object;
        if (serializer.containsReference(object)) {
            serializer.writeReference(object);
            return;
        }
        SerialContext parent = serializer.getContext();
        serializer.setContext(parent, object, fieldName, 0);
        try {
            out.write('{');
            serializer.incrementIndent();
            Class<?> preClazz = null;
            ObjectSerializer preWriter = null;
            boolean first = true;
            if (out.isEnabled(SerializerFeature.WriteClassName)) {
                out.writeFieldName(JSON.DEFAULT_TYPE_KEY);
                out.writeString(object.getClass().getName());
                first = false;
            }
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                Object value = entry.getValue();
                Object entryKey = entry.getKey();
                List<PropertyPreFilter> preFilters = serializer.getPropertyPreFiltersDirect();
                if (preFilters != null && preFilters.size() > 0) {
                    if (entryKey == null || (entryKey instanceof String)) {
                        if (FilterUtils.applyName(serializer, object, (String) entryKey)) {
                        }
                    } else if (entryKey.getClass().isPrimitive() || (entryKey instanceof Number)) {
                        String strKey = JSON.toJSONString(entryKey);
                        if (!FilterUtils.applyName(serializer, object, strKey)) {
                        }
                    }
                }
                List<PropertyFilter> propertyFilters = serializer.getPropertyFiltersDirect();
                if (propertyFilters != null && propertyFilters.size() > 0) {
                    if (entryKey == null || (entryKey instanceof String)) {
                        if (FilterUtils.apply(serializer, object, (String) entryKey, value)) {
                        }
                    } else if (entryKey.getClass().isPrimitive() || (entryKey instanceof Number)) {
                        String strKey2 = JSON.toJSONString(entryKey);
                        if (!FilterUtils.apply(serializer, object, strKey2, value)) {
                        }
                    }
                }
                List<NameFilter> nameFilters = serializer.getNameFiltersDirect();
                if (nameFilters != null && nameFilters.size() > 0) {
                    if (entryKey == null || (entryKey instanceof String)) {
                        entryKey = FilterUtils.processKey(serializer, object, (String) entryKey, value);
                    } else if (entryKey.getClass().isPrimitive() || (entryKey instanceof Number)) {
                        String strKey3 = JSON.toJSONString(entryKey);
                        entryKey = FilterUtils.processKey(serializer, object, strKey3, value);
                    }
                }
                List<ValueFilter> valueFilters = serializer.getValueFiltersDirect();
                if (valueFilters != null && valueFilters.size() > 0) {
                    if (entryKey == null || (entryKey instanceof String)) {
                        value = FilterUtils.processValue(serializer, object, (String) entryKey, value);
                    } else if (entryKey.getClass().isPrimitive() || (entryKey instanceof Number)) {
                        String strKey4 = JSON.toJSONString(entryKey);
                        value = FilterUtils.processValue(serializer, object, strKey4, value);
                    }
                }
                if (value != null || serializer.isEnabled(SerializerFeature.WriteMapNullValue)) {
                    if (entryKey instanceof String) {
                        String key = (String) entryKey;
                        if (!first) {
                            out.write(',');
                        }
                        if (out.isEnabled(SerializerFeature.PrettyFormat)) {
                            serializer.println();
                        }
                        out.writeFieldName(key, true);
                    } else {
                        if (!first) {
                            out.write(',');
                        }
                        if (out.isEnabled(SerializerFeature.BrowserCompatible) || out.isEnabled(SerializerFeature.WriteNonStringKeyAsString) || out.isEnabled(SerializerFeature.BrowserSecure)) {
                            String strEntryKey = JSON.toJSONString(entryKey);
                            serializer.write(strEntryKey);
                        } else {
                            serializer.write(entryKey);
                        }
                        out.write(':');
                    }
                    first = false;
                    if (value == null) {
                        out.writeNull();
                    } else {
                        Class<?> clazz = value.getClass();
                        if (clazz == preClazz) {
                            preWriter.write(serializer, value, entryKey, null, 0);
                        } else {
                            preClazz = clazz;
                            preWriter = serializer.getObjectWriter(clazz);
                            preWriter.write(serializer, value, entryKey, null, 0);
                        }
                    }
                }
            }
            serializer.setContext(parent);
            serializer.decrementIdent();
            if (out.isEnabled(SerializerFeature.PrettyFormat) && map.size() > 0) {
                serializer.println();
            }
            out.write('}');
        } catch (Throwable th) {
            serializer.setContext(parent);
            throw th;
        }
    }
}
