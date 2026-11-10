package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public abstract class FieldDeserializer {
    protected final Class<?> clazz;
    protected final FieldInfo fieldInfo;

    public abstract void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map);

    public FieldDeserializer(Class<?> clazz, FieldInfo fieldInfo) {
        this.clazz = clazz;
        this.fieldInfo = fieldInfo;
    }

    public FieldInfo getFieldInfo() {
        return this.fieldInfo;
    }

    public Method getMethod() {
        return this.fieldInfo.getMethod();
    }

    public Field getField() {
        return this.fieldInfo.getField();
    }

    public Class<?> getFieldClass() {
        return this.fieldInfo.getFieldClass();
    }

    public Type getFieldType() {
        return this.fieldInfo.getFieldType();
    }

    public int getFastMatchToken() {
        return 0;
    }

    public void setValue(Object object, boolean value) {
        setValue(object, Boolean.valueOf(value));
    }

    public void setValue(Object object, int value) {
        setValue(object, Integer.valueOf(value));
    }

    public void setValue(Object object, long value) {
        setValue(object, Long.valueOf(value));
    }

    public void setValue(Object object, String value) {
        setValue(object, (Object) value);
    }

    public void setValue(Object object, Object value) {
        Method method = this.fieldInfo.getMethod();
        if (method != null) {
            try {
                if (this.fieldInfo.isGetOnly()) {
                    if (this.fieldInfo.getFieldClass() == AtomicInteger.class) {
                        AtomicInteger atomic = (AtomicInteger) method.invoke(object, new Object[0]);
                        if (atomic != null) {
                            atomic.set(((AtomicInteger) value).get());
                        }
                    } else if (this.fieldInfo.getFieldClass() == AtomicLong.class) {
                        AtomicLong atomic2 = (AtomicLong) method.invoke(object, new Object[0]);
                        if (atomic2 != null) {
                            atomic2.set(((AtomicLong) value).get());
                        }
                    } else if (this.fieldInfo.getFieldClass() == AtomicBoolean.class) {
                        AtomicBoolean atomic3 = (AtomicBoolean) method.invoke(object, new Object[0]);
                        if (atomic3 != null) {
                            atomic3.set(((AtomicBoolean) value).get());
                        }
                    } else if (Map.class.isAssignableFrom(method.getReturnType())) {
                        Map map = (Map) method.invoke(object, new Object[0]);
                        if (map != null) {
                            map.putAll((Map) value);
                        }
                    } else {
                        Collection collection = (Collection) method.invoke(object, new Object[0]);
                        if (collection != null) {
                            collection.addAll((Collection) value);
                        }
                    }
                } else if (value != null || !this.fieldInfo.getFieldClass().isPrimitive()) {
                    method.invoke(object, value);
                }
                return;
            } catch (Exception e) {
                throw new JSONException("set property error, " + this.fieldInfo.getName(), e);
            }
        }
        Field field = this.fieldInfo.getField();
        if (field != null) {
            try {
                field.set(object, value);
            } catch (Exception e2) {
                throw new JSONException("set property error, " + this.fieldInfo.getName(), e2);
            }
        }
    }
}
