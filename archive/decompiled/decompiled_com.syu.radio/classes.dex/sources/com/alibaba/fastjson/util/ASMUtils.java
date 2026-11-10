package com.alibaba.fastjson.util;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ASMUtils {
    public static final String JAVA_VM_NAME = System.getProperty("java.vm.name");
    public static final boolean IS_ANDROID = isAndroid(JAVA_VM_NAME);

    public static boolean isAndroid(String vmName) {
        if (vmName == null) {
            return false;
        }
        String lowerVMName = vmName.toLowerCase();
        return lowerVMName.contains("dalvik") || lowerVMName.contains("lemur");
    }

    public static boolean isAndroid() {
        return IS_ANDROID;
    }

    public static String getDesc(Method method) {
        StringBuffer buf = new StringBuffer();
        buf.append("(");
        for (Class<?> cls : method.getParameterTypes()) {
            buf.append(getDesc(cls));
        }
        buf.append(")");
        buf.append(getDesc(method.getReturnType()));
        return buf.toString();
    }

    public static String getDesc(Class<?> returnType) {
        if (returnType.isPrimitive()) {
            return getPrimitiveLetter(returnType);
        }
        if (returnType.isArray()) {
            return "[" + getDesc(returnType.getComponentType());
        }
        return "L" + getType(returnType) + ";";
    }

    public static String getType(Class<?> parameterType) {
        if (parameterType.isArray()) {
            return "[" + getDesc(parameterType.getComponentType());
        }
        if (!parameterType.isPrimitive()) {
            String clsName = parameterType.getName();
            return clsName.replaceAll("\\.", "/");
        }
        return getPrimitiveLetter(parameterType);
    }

    public static String getPrimitiveLetter(Class<?> type) {
        if (Integer.TYPE.equals(type)) {
            return "I";
        }
        if (Void.TYPE.equals(type)) {
            return "V";
        }
        if (Boolean.TYPE.equals(type)) {
            return "Z";
        }
        if (Character.TYPE.equals(type)) {
            return "C";
        }
        if (Byte.TYPE.equals(type)) {
            return "B";
        }
        if (Short.TYPE.equals(type)) {
            return "S";
        }
        if (Float.TYPE.equals(type)) {
            return "F";
        }
        if (Long.TYPE.equals(type)) {
            return "J";
        }
        if (Double.TYPE.equals(type)) {
            return "D";
        }
        throw new IllegalStateException("Type: " + type.getCanonicalName() + " is not a primitive type");
    }

    public static Type getMethodType(Class<?> clazz, String methodName) {
        try {
            Method method = clazz.getMethod(methodName, new Class[0]);
            return method.getGenericReturnType();
        } catch (Exception e) {
            return null;
        }
    }

    public static Type getFieldType(Class<?> clazz, String fieldName) {
        try {
            Field field = clazz.getField(fieldName);
            return field.getGenericType();
        } catch (Exception e) {
            return null;
        }
    }

    public static void parseArray(Collection collection, ObjectDeserializer deser, DefaultJSONParser parser, Type type, Object fieldName) {
        JSONLexer lexer = parser.getLexer();
        if (lexer.token() == 8) {
            lexer.nextToken(16);
        }
        parser.accept(14, 14);
        int index = 0;
        while (true) {
            Object item = deser.deserialze(parser, type, Integer.valueOf(index));
            collection.add(item);
            index++;
            if (lexer.token() == 16) {
                lexer.nextToken(14);
            } else {
                parser.accept(15, 16);
                return;
            }
        }
    }

    public static boolean checkName(String name) {
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c < 1 || c > 127) {
                return false;
            }
        }
        return true;
    }
}
