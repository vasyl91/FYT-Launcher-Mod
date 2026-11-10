package com.alibaba.fastjson.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.lsec.core.util.data.FinalChip;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FieldInfo implements Comparable<FieldInfo> {
    private final Class<?> declaringClass;
    private final Field field;
    private final Class<?> fieldClass;
    private final Type fieldType;
    private boolean getOnly;
    private String label;
    private final Method method;
    private final String name;
    private int ordinal;
    private int serialzeFeatures;

    public FieldInfo(String name, Class<?> declaringClass, Class<?> fieldClass, Type fieldType, Field field) {
        this(name, declaringClass, fieldClass, fieldType, field, 0, 0);
    }

    public FieldInfo(String name, Class<?> declaringClass, Class<?> fieldClass, Type fieldType, Field field, int ordinal, int serialzeFeatures) {
        this.ordinal = 0;
        this.getOnly = false;
        this.label = FinalChip.BSP_PLATFORM_Null;
        this.name = name;
        this.declaringClass = declaringClass;
        this.fieldClass = fieldClass;
        this.fieldType = fieldType;
        this.method = null;
        this.field = field;
        this.ordinal = ordinal;
        this.serialzeFeatures = serialzeFeatures;
        if (field != null) {
            TypeUtils.setAccessible(field);
        }
    }

    public FieldInfo(String name, Method method, Field field) {
        this(name, method, field, (Class<?>) null, (Type) null);
    }

    public FieldInfo(String name, Method method, Field field, int ordinal, int serialzeFeatures) {
        this(name, method, field, ordinal, serialzeFeatures, null);
    }

    public FieldInfo(String name, Method method, Field field, int ordinal, int serialzeFeatures, String label) {
        this(name, method, field, (Class<?>) null, (Type) null, ordinal, serialzeFeatures);
        if (label != null && label.length() > 0) {
            this.label = label;
        }
    }

    public FieldInfo(String name, Method method, Field field, Class<?> clazz, Type type) {
        this(name, method, field, clazz, type, 0, 0);
    }

    public FieldInfo(String name, Method method, Field field, Class<?> clazz, Type type, int ordinal, int serialzeFeatures) {
        Class<?> fieldClass;
        Type fieldType;
        this.ordinal = 0;
        this.getOnly = false;
        this.label = FinalChip.BSP_PLATFORM_Null;
        this.name = name;
        this.method = method;
        this.field = field;
        this.ordinal = ordinal;
        this.serialzeFeatures = serialzeFeatures;
        if (method != null) {
            TypeUtils.setAccessible(method);
        }
        if (field != null) {
            TypeUtils.setAccessible(field);
        }
        if (method != null) {
            if (method.getParameterTypes().length == 1) {
                fieldClass = method.getParameterTypes()[0];
                fieldType = method.getGenericParameterTypes()[0];
            } else {
                fieldClass = method.getReturnType();
                fieldType = method.getGenericReturnType();
                this.getOnly = true;
            }
            this.declaringClass = method.getDeclaringClass();
        } else {
            fieldClass = field.getType();
            fieldType = field.getGenericType();
            this.declaringClass = field.getDeclaringClass();
        }
        if (clazz != null && fieldClass == Object.class && (fieldType instanceof TypeVariable)) {
            TypeVariable<?> tv = (TypeVariable) fieldType;
            Type genericFieldType = getInheritGenericType(clazz, tv);
            if (genericFieldType != null) {
                this.fieldClass = TypeUtils.getClass(genericFieldType);
                this.fieldType = genericFieldType;
                return;
            }
        }
        Type genericFieldType2 = getFieldType(clazz, type, fieldType);
        if (genericFieldType2 != fieldType && ((genericFieldType2 instanceof ParameterizedType) || (genericFieldType2 instanceof Class))) {
            fieldClass = TypeUtils.getClass(genericFieldType2);
        }
        this.fieldType = genericFieldType2;
        this.fieldClass = fieldClass;
    }

    public String getLabel() {
        return this.label;
    }

    public static Type getFieldType(Class<?> clazz, Type type, Type fieldType) {
        if (clazz == null || type == null) {
            return fieldType;
        }
        if (fieldType instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) fieldType;
            Type componentType = genericArrayType.getGenericComponentType();
            Type componentTypeX = getFieldType(clazz, type, componentType);
            return componentType != componentTypeX ? Array.newInstance(TypeUtils.getClass(componentTypeX), 0).getClass() : fieldType;
        }
        if (!TypeUtils.isGenericParamType(type)) {
            return fieldType;
        }
        if (fieldType instanceof TypeVariable) {
            ParameterizedType paramType = (ParameterizedType) TypeUtils.getGenericParamType(type);
            Class<?> parameterizedClass = TypeUtils.getClass(paramType);
            TypeVariable<?> typeVar = (TypeVariable) fieldType;
            for (int i = 0; i < parameterizedClass.getTypeParameters().length; i++) {
                if (parameterizedClass.getTypeParameters()[i].getName().equals(typeVar.getName())) {
                    return paramType.getActualTypeArguments()[i];
                }
            }
        }
        if (fieldType instanceof ParameterizedType) {
            ParameterizedType parameterizedFieldType = (ParameterizedType) fieldType;
            Type[] arguments = parameterizedFieldType.getActualTypeArguments();
            boolean changed = false;
            for (int i2 = 0; i2 < arguments.length; i2++) {
                Type feildTypeArguement = arguments[i2];
                if (feildTypeArguement instanceof TypeVariable) {
                    TypeVariable<?> typeVar2 = (TypeVariable) feildTypeArguement;
                    if (type instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) type;
                        for (int j = 0; j < clazz.getTypeParameters().length; j++) {
                            if (clazz.getTypeParameters()[j].getName().equals(typeVar2.getName())) {
                                arguments[i2] = parameterizedType.getActualTypeArguments()[j];
                                changed = true;
                            }
                        }
                    }
                }
            }
            if (changed) {
                return new ParameterizedTypeImpl(arguments, parameterizedFieldType.getOwnerType(), parameterizedFieldType.getRawType());
            }
        }
        return fieldType;
    }

    public static Type getInheritGenericType(Class<?> clazz, TypeVariable<?> tv) {
        Type type;
        GenericDeclaration gd = tv.getGenericDeclaration();
        do {
            type = clazz.getGenericSuperclass();
            if (type == null) {
                return null;
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType ptype = (ParameterizedType) type;
                if (ptype.getRawType() == gd) {
                    TypeVariable<?>[] typeParameters = gd.getTypeParameters();
                    Type[] types = ptype.getActualTypeArguments();
                    for (int i = 0; i < typeParameters.length; i++) {
                        if (typeParameters[i] == tv) {
                            return types[i];
                        }
                    }
                    return null;
                }
            }
            clazz = TypeUtils.getClass(type);
        } while (type != null);
        return null;
    }

    public String toString() {
        return this.name;
    }

    public Class<?> getDeclaringClass() {
        return this.declaringClass;
    }

    public Class<?> getFieldClass() {
        return this.fieldClass;
    }

    public Type getFieldType() {
        return this.fieldType;
    }

    public String getName() {
        return this.name;
    }

    public String getQualifiedName() {
        Member member = getMember();
        return String.valueOf(member.getDeclaringClass().getName()) + "." + member.getName();
    }

    public Member getMember() {
        return this.method != null ? this.method : this.field;
    }

    public Method getMethod() {
        return this.method;
    }

    public Field getField() {
        return this.field;
    }

    @Override // java.lang.Comparable
    public int compareTo(FieldInfo o) {
        if (this.ordinal < o.ordinal) {
            return -1;
        }
        if (this.ordinal > o.ordinal) {
            return 1;
        }
        return this.name.compareTo(o.name);
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        T t = null;
        if (this.method != null) {
            t = (T) this.method.getAnnotation(cls);
        }
        return (t != null || this.field == null) ? t : (T) this.field.getAnnotation(cls);
    }

    public String getFormat() {
        JSONField annotation = (JSONField) getAnnotation(JSONField.class);
        if (annotation == null) {
            return null;
        }
        String format = annotation.format();
        if (format.trim().length() == 0) {
            return null;
        }
        return format;
    }

    public Object get(Object javaObject) throws IllegalAccessException, InvocationTargetException {
        return this.method != null ? this.method.invoke(javaObject, new Object[0]) : this.field.get(javaObject);
    }

    public void set(Object javaObject, Object value) throws IllegalAccessException, InvocationTargetException {
        if (this.method != null) {
            this.method.invoke(javaObject, value);
        } else {
            this.field.set(javaObject, value);
        }
    }

    public void setAccessible(boolean flag) throws SecurityException {
        if (this.method != null) {
            TypeUtils.setAccessible(this.method);
        } else {
            TypeUtils.setAccessible(this.field);
        }
    }

    public boolean isGetOnly() {
        return this.getOnly;
    }

    public int getSerialzeFeatures() {
        return this.serialzeFeatures;
    }
}
