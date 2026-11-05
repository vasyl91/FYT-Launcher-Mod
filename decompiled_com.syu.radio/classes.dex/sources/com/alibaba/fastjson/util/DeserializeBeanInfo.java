package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONPOJOBuilder;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class DeserializeBeanInfo {
    private Method buildMethod;
    private final Class<?> builderClass;
    private final Class<?> clazz;
    private Constructor<?> creatorConstructor;
    private Constructor<?> defaultConstructor;
    private Method factoryMethod;
    private final List<FieldInfo> fieldList;
    private int parserFeatures;
    private final List<FieldInfo> sortedFieldList;

    public DeserializeBeanInfo(Class<?> clazz) {
        this(clazz, getBuilderClass(clazz));
    }

    public DeserializeBeanInfo(Class<?> clazz, Class<?> builderClass) {
        this.fieldList = new ArrayList();
        this.sortedFieldList = new ArrayList();
        this.parserFeatures = 0;
        this.clazz = clazz;
        this.builderClass = builderClass;
        this.parserFeatures = TypeUtils.getParserFeatures(clazz);
    }

    public Constructor<?> getDefaultConstructor() {
        return this.defaultConstructor;
    }

    public void setDefaultConstructor(Constructor<?> defaultConstructor) {
        this.defaultConstructor = defaultConstructor;
    }

    public Constructor<?> getCreatorConstructor() {
        return this.creatorConstructor;
    }

    public void setCreatorConstructor(Constructor<?> createConstructor) {
        this.creatorConstructor = createConstructor;
    }

    public Method getFactoryMethod() {
        return this.factoryMethod;
    }

    public void setFactoryMethod(Method factoryMethod) {
        this.factoryMethod = factoryMethod;
    }

    public Method getBuildMethod() {
        return this.buildMethod;
    }

    public void setBuildMethod(Method buildMethod) {
        this.buildMethod = buildMethod;
    }

    public Class<?> getClazz() {
        return this.clazz;
    }

    public Class<?> getBuilderClass() {
        return this.builderClass;
    }

    public List<FieldInfo> getFieldList() {
        return this.fieldList;
    }

    public List<FieldInfo> getSortedFieldList() {
        return this.sortedFieldList;
    }

    public FieldInfo getField(String propertyName) {
        for (FieldInfo item : this.fieldList) {
            if (item.getName().equals(propertyName)) {
                return item;
            }
        }
        return null;
    }

    public boolean add(FieldInfo field) {
        for (FieldInfo item : this.fieldList) {
            if (item.getName().equals(field.getName()) && (!item.isGetOnly() || field.isGetOnly())) {
                if (item.getFieldClass().isAssignableFrom(field.getFieldClass())) {
                    this.fieldList.remove(item);
                    break;
                }
                return false;
            }
        }
        this.fieldList.add(field);
        this.sortedFieldList.add(field);
        Collections.sort(this.sortedFieldList);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:126:0x032b A[PHI: r8 r9
  0x032b: PHI (r8v6 'ordinal' int) = (r8v5 'ordinal' int), (r8v9 'ordinal' int) binds: [B:120:0x02f2, B:124:0x030e] A[DONT_GENERATE, DONT_INLINE]
  0x032b: PHI (r9v6 'serialzeFeatures' int) = (r9v5 'serialzeFeatures' int), (r9v9 'serialzeFeatures' int) binds: [B:120:0x02f2, B:124:0x030e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:128:0x0335  */
    /* JADX WARN: Code duplicated, block: B:132:0x0348  */
    /* JADX WARN: Code duplicated, block: B:134:0x034c  */
    /* JADX WARN: Code duplicated, block: B:137:0x035f  */
    /* JADX WARN: Code duplicated, block: B:141:0x0395  */
    /* JADX WARN: Code duplicated, block: B:146:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:158:0x0432 A[PHI: r8 r9
  0x0432: PHI (r8v7 'ordinal' int) = (r8v6 'ordinal' int), (r8v6 'ordinal' int), (r8v8 'ordinal' int) binds: [B:140:0x0393, B:142:0x039d, B:144:0x03b3] A[DONT_GENERATE, DONT_INLINE]
  0x0432: PHI (r9v7 'serialzeFeatures' int) = (r9v6 'serialzeFeatures' int), (r9v6 'serialzeFeatures' int), (r9v8 'serialzeFeatures' int) binds: [B:140:0x0393, B:142:0x039d, B:144:0x03b3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:230:0x02b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0211 A[PHI: r8 r9
  0x0211: PHI (r8v11 'ordinal' int) = (r8v10 'ordinal' int), (r8v12 'ordinal' int) binds: [B:81:0x01d8, B:85:0x01f4] A[DONT_GENERATE, DONT_INLINE]
  0x0211: PHI (r9v11 'serialzeFeatures' int) = (r9v10 'serialzeFeatures' int), (r9v12 'serialzeFeatures' int) binds: [B:81:0x01d8, B:85:0x01f4] A[DONT_GENERATE, DONT_INLINE]] */
    public static DeserializeBeanInfo computeSetters(Class<?> clazz, Type type) {
        String propertyName;
        char c3;
        String propertyName2;
        Field field;
        JSONField fieldAnnotation;
        String methodName;
        DeserializeBeanInfo beanInfo = new DeserializeBeanInfo(clazz);
        Class<?> builderClass = beanInfo.getBuilderClass();
        Constructor<?> defaultConstructor = getDefaultConstructor(builderClass == null ? clazz : builderClass);
        if (defaultConstructor != null) {
            TypeUtils.setAccessible(defaultConstructor);
            beanInfo.setDefaultConstructor(defaultConstructor);
        } else {
            if (defaultConstructor == null && !clazz.isInterface() && !Modifier.isAbstract(clazz.getModifiers())) {
                Constructor<?> creatorConstructor = getCreatorConstructor(clazz);
                if (creatorConstructor != null) {
                    TypeUtils.setAccessible(creatorConstructor);
                    beanInfo.setCreatorConstructor(creatorConstructor);
                    for (int i = 0; i < creatorConstructor.getParameterTypes().length; i++) {
                        Annotation[] paramAnnotations = creatorConstructor.getParameterAnnotations()[i];
                        JSONField fieldAnnotation2 = null;
                        for (Annotation paramAnnotation : paramAnnotations) {
                            if (paramAnnotation instanceof JSONField) {
                                fieldAnnotation2 = (JSONField) paramAnnotation;
                                break;
                            }
                        }
                        if (fieldAnnotation2 == null) {
                            throw new JSONException("illegal json creator");
                        }
                        Class<?> fieldClass = creatorConstructor.getParameterTypes()[i];
                        Type fieldType = creatorConstructor.getGenericParameterTypes()[i];
                        Field field2 = TypeUtils.getField(clazz, fieldAnnotation2.name());
                        int ordinal = fieldAnnotation2.ordinal();
                        int serialzeFeatures = SerializerFeature.of(fieldAnnotation2.serialzeFeatures());
                        FieldInfo fieldInfo = new FieldInfo(fieldAnnotation2.name(), clazz, fieldClass, fieldType, field2, ordinal, serialzeFeatures);
                        beanInfo.add(fieldInfo);
                    }
                } else {
                    Method factoryMethod = getFactoryMethod(clazz);
                    if (factoryMethod != null) {
                        TypeUtils.setAccessible(factoryMethod);
                        beanInfo.setFactoryMethod(factoryMethod);
                        for (int i2 = 0; i2 < factoryMethod.getParameterTypes().length; i2++) {
                            Annotation[] paramAnnotations2 = factoryMethod.getParameterAnnotations()[i2];
                            JSONField fieldAnnotation3 = null;
                            for (Annotation paramAnnotation2 : paramAnnotations2) {
                                if (paramAnnotation2 instanceof JSONField) {
                                    fieldAnnotation3 = (JSONField) paramAnnotation2;
                                    break;
                                }
                            }
                            if (fieldAnnotation3 == null) {
                                throw new JSONException("illegal json creator");
                            }
                            Class<?> fieldClass2 = factoryMethod.getParameterTypes()[i2];
                            Type fieldType2 = factoryMethod.getGenericParameterTypes()[i2];
                            Field field3 = TypeUtils.getField(clazz, fieldAnnotation3.name());
                            int ordinal2 = fieldAnnotation3.ordinal();
                            int serialzeFeatures2 = SerializerFeature.of(fieldAnnotation3.serialzeFeatures());
                            FieldInfo fieldInfo2 = new FieldInfo(fieldAnnotation3.name(), clazz, fieldClass2, fieldType2, field3, ordinal2, serialzeFeatures2);
                            beanInfo.add(fieldInfo2);
                        }
                    } else {
                        throw new JSONException("default constructor not found. " + clazz);
                    }
                }
            }
            return beanInfo;
        }
        if (builderClass != null) {
            String withPrefix = null;
            JSONPOJOBuilder builderAnno = (JSONPOJOBuilder) builderClass.getAnnotation(JSONPOJOBuilder.class);
            if (builderAnno != null) {
                withPrefix = builderAnno.withPrefix();
            }
            if (withPrefix == null || withPrefix.length() == 0) {
                withPrefix = "with";
            }
            for (Method method : builderClass.getMethods()) {
                if (!Modifier.isStatic(method.getModifiers()) && method.getReturnType().equals(builderClass)) {
                    int ordinal3 = 0;
                    int serialzeFeatures3 = 0;
                    JSONField annotation = (JSONField) method.getAnnotation(JSONField.class);
                    if (annotation == null) {
                        annotation = TypeUtils.getSupperMethodAnnotation(clazz, method);
                    }
                    if (annotation != null) {
                        if (annotation.deserialize()) {
                            ordinal3 = annotation.ordinal();
                            serialzeFeatures3 = SerializerFeature.of(annotation.serialzeFeatures());
                            if (annotation.name().length() != 0) {
                                String propertyName3 = annotation.name();
                                beanInfo.add(new FieldInfo(propertyName3, method, (Field) null, clazz, type, ordinal3, serialzeFeatures3));
                                TypeUtils.setAccessible(method);
                            } else {
                                methodName = method.getName();
                                if (!methodName.startsWith(withPrefix)) {
                                }
                            }
                        }
                    } else {
                        methodName = method.getName();
                        if (!methodName.startsWith(withPrefix) && methodName.length() > withPrefix.length()) {
                            char c0 = methodName.charAt(withPrefix.length());
                            if (Character.isUpperCase(c0)) {
                                StringBuilder properNameBuilder = new StringBuilder(methodName.substring(withPrefix.length()));
                                properNameBuilder.setCharAt(0, Character.toLowerCase(c0));
                                String propertyName4 = properNameBuilder.toString();
                                beanInfo.add(new FieldInfo(propertyName4, method, (Field) null, clazz, type, ordinal3, serialzeFeatures3));
                                TypeUtils.setAccessible(method);
                            }
                        }
                    }
                }
            }
            if (builderClass != null) {
                JSONPOJOBuilder builderAnnotation = (JSONPOJOBuilder) builderClass.getAnnotation(JSONPOJOBuilder.class);
                String buildMethodName = null;
                if (builderAnnotation != null) {
                    buildMethodName = builderAnnotation.buildMethod();
                }
                if (buildMethodName == null || buildMethodName.length() == 0) {
                    buildMethodName = "build";
                }
                Method buildMethod = null;
                try {
                    buildMethod = builderClass.getMethod(buildMethodName, new Class[0]);
                } catch (NoSuchMethodException e) {
                } catch (SecurityException e2) {
                }
                if (buildMethod == null) {
                    try {
                        buildMethod = builderClass.getMethod("create", new Class[0]);
                    } catch (NoSuchMethodException e3) {
                    } catch (SecurityException e4) {
                    }
                }
                if (buildMethod == null) {
                    throw new JSONException("buildMethod not found.");
                }
                beanInfo.setBuildMethod(buildMethod);
                TypeUtils.setAccessible(buildMethod);
            }
        }
        for (Method method2 : clazz.getMethods()) {
            int ordinal4 = 0;
            int serialzeFeatures4 = 0;
            String methodName2 = method2.getName();
            if (methodName2.length() >= 4 && !Modifier.isStatic(method2.getModifiers()) && ((method2.getReturnType().equals(Void.TYPE) || method2.getReturnType().equals(clazz)) && method2.getParameterTypes().length == 1)) {
                JSONField annotation2 = (JSONField) method2.getAnnotation(JSONField.class);
                if (annotation2 == null) {
                    annotation2 = TypeUtils.getSupperMethodAnnotation(clazz, method2);
                }
                if (annotation2 != null) {
                    if (annotation2.deserialize()) {
                        ordinal4 = annotation2.ordinal();
                        serialzeFeatures4 = SerializerFeature.of(annotation2.serialzeFeatures());
                        if (annotation2.name().length() != 0) {
                            String propertyName5 = annotation2.name();
                            beanInfo.add(new FieldInfo(propertyName5, method2, (Field) null, clazz, type, ordinal4, serialzeFeatures4));
                            TypeUtils.setAccessible(method2);
                        } else if (methodName2.startsWith("set")) {
                            c3 = methodName2.charAt(3);
                            if (!Character.isUpperCase(c3)) {
                                if (TypeUtils.compatibleWithJavaBean) {
                                    propertyName2 = TypeUtils.decapitalize(methodName2.substring(3));
                                } else {
                                    propertyName2 = String.valueOf(Character.toLowerCase(methodName2.charAt(3))) + methodName2.substring(4);
                                }
                                field = TypeUtils.getField(clazz, propertyName2);
                                if (field == null) {
                                    String isFieldName = "is" + Character.toUpperCase(propertyName2.charAt(0)) + propertyName2.substring(1);
                                    field = TypeUtils.getField(clazz, isFieldName);
                                }
                                if (field == null) {
                                    beanInfo.add(new FieldInfo(propertyName2, method2, (Field) null, clazz, type, ordinal4, serialzeFeatures4));
                                    TypeUtils.setAccessible(method2);
                                } else {
                                    beanInfo.add(new FieldInfo(propertyName2, method2, (Field) null, clazz, type, ordinal4, serialzeFeatures4));
                                    TypeUtils.setAccessible(method2);
                                }
                            } else {
                                if (TypeUtils.compatibleWithJavaBean) {
                                    propertyName2 = TypeUtils.decapitalize(methodName2.substring(3));
                                } else {
                                    propertyName2 = String.valueOf(Character.toLowerCase(methodName2.charAt(3))) + methodName2.substring(4);
                                }
                                field = TypeUtils.getField(clazz, propertyName2);
                                if (field == null) {
                                    String isFieldName2 = "is" + Character.toUpperCase(propertyName2.charAt(0)) + propertyName2.substring(1);
                                    field = TypeUtils.getField(clazz, isFieldName2);
                                }
                                if (field == null) {
                                    beanInfo.add(new FieldInfo(propertyName2, method2, (Field) null, clazz, type, ordinal4, serialzeFeatures4));
                                    TypeUtils.setAccessible(method2);
                                } else {
                                    beanInfo.add(new FieldInfo(propertyName2, method2, (Field) null, clazz, type, ordinal4, serialzeFeatures4));
                                    TypeUtils.setAccessible(method2);
                                }
                            }
                        }
                    }
                } else if (methodName2.startsWith("set")) {
                    c3 = methodName2.charAt(3);
                    if (!Character.isUpperCase(c3) || c3 > 512) {
                        if (TypeUtils.compatibleWithJavaBean) {
                            propertyName2 = TypeUtils.decapitalize(methodName2.substring(3));
                        } else {
                            propertyName2 = String.valueOf(Character.toLowerCase(methodName2.charAt(3))) + methodName2.substring(4);
                        }
                    } else if (c3 == '_') {
                        propertyName2 = methodName2.substring(4);
                    } else if (c3 == 'f') {
                        propertyName2 = methodName2.substring(3);
                    } else if (methodName2.length() >= 5 && Character.isUpperCase(methodName2.charAt(4))) {
                        propertyName2 = TypeUtils.decapitalize(methodName2.substring(3));
                    }
                    field = TypeUtils.getField(clazz, propertyName2);
                    if (field == null && method2.getParameterTypes()[0] == Boolean.TYPE) {
                        String isFieldName3 = "is" + Character.toUpperCase(propertyName2.charAt(0)) + propertyName2.substring(1);
                        field = TypeUtils.getField(clazz, isFieldName3);
                    }
                    if (field == null && (fieldAnnotation = (JSONField) field.getAnnotation(JSONField.class)) != null) {
                        ordinal4 = fieldAnnotation.ordinal();
                        serialzeFeatures4 = SerializerFeature.of(fieldAnnotation.serialzeFeatures());
                        if (fieldAnnotation.name().length() != 0) {
                            String propertyName6 = fieldAnnotation.name();
                            beanInfo.add(new FieldInfo(propertyName6, method2, field, clazz, type, ordinal4, serialzeFeatures4));
                        } else {
                            beanInfo.add(new FieldInfo(propertyName2, method2, (Field) null, clazz, type, ordinal4, serialzeFeatures4));
                            TypeUtils.setAccessible(method2);
                        }
                    } else {
                        beanInfo.add(new FieldInfo(propertyName2, method2, (Field) null, clazz, type, ordinal4, serialzeFeatures4));
                        TypeUtils.setAccessible(method2);
                    }
                }
            }
        }
        for (Field field4 : clazz.getFields()) {
            if (!Modifier.isStatic(field4.getModifiers())) {
                boolean contains = false;
                for (FieldInfo item : beanInfo.getFieldList()) {
                    if (item.getName().equals(field4.getName())) {
                        contains = true;
                    }
                }
                if (!contains) {
                    int ordinal5 = 0;
                    int serialzeFeatures5 = 0;
                    String propertyName7 = field4.getName();
                    JSONField fieldAnnotation4 = (JSONField) field4.getAnnotation(JSONField.class);
                    if (fieldAnnotation4 != null) {
                        ordinal5 = fieldAnnotation4.ordinal();
                        serialzeFeatures5 = SerializerFeature.of(fieldAnnotation4.serialzeFeatures());
                        if (fieldAnnotation4.name().length() != 0) {
                            propertyName7 = fieldAnnotation4.name();
                        }
                    }
                    beanInfo.add(new FieldInfo(propertyName7, (Method) null, field4, clazz, type, ordinal5, serialzeFeatures5));
                }
            }
        }
        for (Method method3 : clazz.getMethods()) {
            String methodName3 = method3.getName();
            if (methodName3.length() >= 4 && !Modifier.isStatic(method3.getModifiers()) && methodName3.startsWith("get") && Character.isUpperCase(methodName3.charAt(3)) && method3.getParameterTypes().length == 0 && (Collection.class.isAssignableFrom(method3.getReturnType()) || Map.class.isAssignableFrom(method3.getReturnType()) || AtomicBoolean.class == method3.getReturnType() || AtomicInteger.class == method3.getReturnType() || AtomicLong.class == method3.getReturnType())) {
                JSONField annotation3 = (JSONField) method3.getAnnotation(JSONField.class);
                if (annotation3 != null && annotation3.name().length() > 0) {
                    propertyName = annotation3.name();
                } else {
                    propertyName = String.valueOf(Character.toLowerCase(methodName3.charAt(3))) + methodName3.substring(4);
                }
                FieldInfo fieldInfo3 = beanInfo.getField(propertyName);
                if (fieldInfo3 == null) {
                    beanInfo.add(new FieldInfo(propertyName, method3, (Field) null, clazz, type));
                    TypeUtils.setAccessible(method3);
                }
            }
        }
        return beanInfo;
    }

    public static Constructor<?> getDefaultConstructor(Class<?> clazz) {
        if (Modifier.isAbstract(clazz.getModifiers())) {
            return null;
        }
        Constructor<?> defaultConstructor = null;
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if (constructor.getParameterTypes().length == 0) {
                defaultConstructor = constructor;
                break;
            }
        }
        if (defaultConstructor == null && clazz.isMemberClass() && !Modifier.isStatic(clazz.getModifiers())) {
            for (Constructor<?> constructor2 : clazz.getDeclaredConstructors()) {
                if (constructor2.getParameterTypes().length == 1 && constructor2.getParameterTypes()[0].equals(clazz.getDeclaringClass())) {
                    return constructor2;
                }
            }
            return defaultConstructor;
        }
        return defaultConstructor;
    }

    public static Constructor<?> getCreatorConstructor(Class<?> clazz) {
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            JSONCreator annotation = (JSONCreator) constructor.getAnnotation(JSONCreator.class);
            if (annotation != null) {
                if (0 != 0) {
                    throw new JSONException("multi-json creator");
                }
                return constructor;
            }
        }
        return null;
    }

    public static Method getFactoryMethod(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (Modifier.isStatic(method.getModifiers()) && clazz.isAssignableFrom(method.getReturnType())) {
                JSONCreator annotation = (JSONCreator) method.getAnnotation(JSONCreator.class);
                if (annotation != null) {
                    if (0 != 0) {
                        throw new JSONException("multi-json creator");
                    }
                    return method;
                }
            }
        }
        return null;
    }

    public int getParserFeatures() {
        return this.parserFeatures;
    }

    public static Class<?> getBuilderClass(Class<?> clazz) {
        Class<?> builderClass;
        JSONType type = (JSONType) clazz.getAnnotation(JSONType.class);
        if (type == null || (builderClass = type.builder()) == Void.class) {
            return null;
        }
        return builderClass;
    }
}
