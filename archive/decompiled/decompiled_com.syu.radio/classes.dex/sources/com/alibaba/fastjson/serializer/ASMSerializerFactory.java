package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldVisitor;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.lsec.core.util.data.FinalChip;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ASMSerializerFactory implements Opcodes {
    private ASMClassLoader classLoader = new ASMClassLoader();
    private final AtomicLong seed = new AtomicLong();

    public String getGenClassName(Class<?> clazz) {
        return "Serializer_" + this.seed.incrementAndGet();
    }

    public boolean isExternalClass(Class<?> clazz) {
        return this.classLoader.isExternalClass(clazz);
    }

    static class Context {
        private final int beanSerializeFeatures;
        private final String className;
        private int variantIndex = 9;
        private Map<String, Integer> variants = new HashMap();

        public Context(String className, int beanSerializeFeatures) {
            this.className = className;
            this.beanSerializeFeatures = beanSerializeFeatures;
        }

        public int serializer() {
            return 1;
        }

        public String getClassName() {
            return this.className;
        }

        public int obj() {
            return 2;
        }

        public int paramFieldName() {
            return 3;
        }

        public int paramFieldType() {
            return 4;
        }

        public int features() {
            return 5;
        }

        public int fieldName() {
            return 6;
        }

        public int original() {
            return 7;
        }

        public int processValue() {
            return 8;
        }

        public int getVariantCount() {
            return this.variantIndex;
        }

        public int var(String name) {
            Integer i = this.variants.get(name);
            if (i == null) {
                Map<String, Integer> map = this.variants;
                int i2 = this.variantIndex;
                this.variantIndex = i2 + 1;
                map.put(name, Integer.valueOf(i2));
            }
            Integer i3 = this.variants.get(name);
            return i3.intValue();
        }

        public int var(String name, int increment) {
            Integer i = this.variants.get(name);
            if (i == null) {
                this.variants.put(name, Integer.valueOf(this.variantIndex));
                this.variantIndex += increment;
            }
            Integer i2 = this.variants.get(name);
            return i2.intValue();
        }
    }

    public ObjectSerializer createJavaBeanSerializer(Class<?> clazz, Map<String, String> aliasMap) throws Exception {
        if (clazz.isPrimitive()) {
            throw new JSONException("unsupportd class " + clazz.getName());
        }
        List<FieldInfo> getters = TypeUtils.computeGetters(clazz, aliasMap, false);
        if (getters.size() > 256) {
            return null;
        }
        for (FieldInfo getter : getters) {
            if (!ASMUtils.checkName(getter.getMember().getName())) {
                return null;
            }
        }
        String className = getGenClassName(clazz);
        int beanSerializeFeatures = TypeUtils.getSerializeFeatures(clazz);
        ClassWriter cw = new ClassWriter();
        cw.visit(49, 33, className, "com/alibaba/fastjson/serializer/ASMJavaBeanSerializer", new String[]{"com/alibaba/fastjson/serializer/ObjectSerializer"});
        for (FieldInfo fieldInfo : getters) {
            FieldVisitor fw = cw.visitField(1, String.valueOf(fieldInfo.getName()) + "_asm_fieldPrefix", "Ljava/lang/reflect/Type;");
            fw.visitEnd();
            FieldVisitor fw2 = cw.visitField(1, String.valueOf(fieldInfo.getName()) + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            fw2.visitEnd();
        }
        MethodVisitor mw = cw.visitMethod(1, "<init>", "()V", null, null);
        mw.visitVarInsn(25, 0);
        mw.visitLdcInsn(Type.getType(ASMUtils.getDesc(clazz)));
        mw.visitMethodInsn(183, "com/alibaba/fastjson/serializer/ASMJavaBeanSerializer", "<init>", "(Ljava/lang/Class;)V");
        for (FieldInfo fieldInfo2 : getters) {
            mw.visitVarInsn(25, 0);
            mw.visitLdcInsn(Type.getType(ASMUtils.getDesc(fieldInfo2.getDeclaringClass())));
            if (fieldInfo2.getMethod() != null) {
                mw.visitLdcInsn(fieldInfo2.getMethod().getName());
                mw.visitMethodInsn(184, "com/alibaba/fastjson/util/ASMUtils", "getMethodType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
            } else {
                mw.visitLdcInsn(fieldInfo2.getField().getName());
                mw.visitMethodInsn(184, "com/alibaba/fastjson/util/ASMUtils", "getFieldType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
            }
            mw.visitFieldInsn(181, className, String.valueOf(fieldInfo2.getName()) + "_asm_fieldType", "Ljava/lang/reflect/Type;");
        }
        mw.visitInsn(177);
        mw.visitMaxs(4, 4);
        mw.visitEnd();
        Context context = new Context(className, beanSerializeFeatures);
        MethodVisitor mw2 = cw.visitMethod(1, "write", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V", null, new String[]{"java/io/IOException"});
        mw2.visitVarInsn(25, context.serializer());
        mw2.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "getWriter", "()Lcom/alibaba/fastjson/serializer/SerializeWriter;");
        mw2.visitVarInsn(58, context.var("out"));
        JSONType jsonType = (JSONType) clazz.getAnnotation(JSONType.class);
        if (jsonType == null || jsonType.alphabetic()) {
            Label _else = new Label();
            mw2.visitVarInsn(25, context.var("out"));
            mw2.visitFieldInsn(178, "com/alibaba/fastjson/serializer/SerializerFeature", "SortField", "Lcom/alibaba/fastjson/serializer/SerializerFeature;");
            mw2.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "isEnabled", "(Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z");
            mw2.visitJumpInsn(153, _else);
            mw2.visitVarInsn(25, 0);
            mw2.visitVarInsn(25, 1);
            mw2.visitVarInsn(25, 2);
            mw2.visitVarInsn(25, 3);
            mw2.visitVarInsn(25, 4);
            mw2.visitVarInsn(21, 5);
            mw2.visitMethodInsn(182, className, "write1", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            mw2.visitInsn(177);
            mw2.visitLabel(_else);
        }
        mw2.visitVarInsn(25, context.obj());
        mw2.visitTypeInsn(192, ASMUtils.getType(clazz));
        mw2.visitVarInsn(58, context.var("entity"));
        generateWriteMethod(clazz, mw2, getters, context);
        mw2.visitInsn(177);
        mw2.visitMaxs(6, context.getVariantCount() + 1);
        mw2.visitEnd();
        List<FieldInfo> sortedGetters = TypeUtils.computeGetters(clazz, aliasMap, true);
        Context context2 = new Context(className, beanSerializeFeatures);
        MethodVisitor mw3 = cw.visitMethod(1, "write1", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V", null, new String[]{"java/io/IOException"});
        mw3.visitVarInsn(25, context2.serializer());
        mw3.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "getWriter", "()Lcom/alibaba/fastjson/serializer/SerializeWriter;");
        mw3.visitVarInsn(58, context2.var("out"));
        mw3.visitVarInsn(25, context2.obj());
        mw3.visitTypeInsn(192, ASMUtils.getType(clazz));
        mw3.visitVarInsn(58, context2.var("entity"));
        generateWriteMethod(clazz, mw3, sortedGetters, context2);
        mw3.visitInsn(177);
        mw3.visitMaxs(6, context2.getVariantCount() + 1);
        mw3.visitEnd();
        Context context3 = new Context(className, beanSerializeFeatures);
        MethodVisitor mw4 = cw.visitMethod(1, "writeAsArray", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;)V", null, new String[]{"java/io/IOException"});
        mw4.visitVarInsn(25, context3.serializer());
        mw4.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "getWriter", "()Lcom/alibaba/fastjson/serializer/SerializeWriter;");
        mw4.visitVarInsn(58, context3.var("out"));
        mw4.visitVarInsn(25, context3.obj());
        mw4.visitTypeInsn(192, ASMUtils.getType(clazz));
        mw4.visitVarInsn(58, context3.var("entity"));
        generateWriteAsArray(clazz, mw4, sortedGetters, context3);
        mw4.visitInsn(177);
        mw4.visitMaxs(6, context3.getVariantCount() + 1);
        mw4.visitEnd();
        byte[] code = cw.toByteArray();
        if (JSON.DUMP_CLASS != null) {
            FileOutputStream fos = null;
            try {
                try {
                    FileOutputStream fos2 = new FileOutputStream(String.valueOf(JSON.DUMP_CLASS) + File.separator + className + ".class");
                    try {
                        fos2.write(code);
                        if (fos2 != null) {
                            fos2.close();
                        }
                    } catch (Exception e) {
                        ex = e;
                        fos = fos2;
                        System.err.println("FASTJSON dump class:" + className + "失败:" + ex.getMessage());
                        if (fos != null) {
                            fos.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fos = fos2;
                        if (fos != null) {
                            fos.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                ex = e2;
            }
        }
        Class<?> exampleClass = this.classLoader.defineClassPublic(className, code, 0, code.length);
        Object instance = exampleClass.newInstance();
        return (ObjectSerializer) instance;
    }

    private void generateWriteAsArray(Class<?> clazz, MethodVisitor mw, List<FieldInfo> getters, Context context) throws Exception {
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(16, 91);
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "write", "(C)V");
        int size = getters.size();
        if (size == 0) {
            mw.visitVarInsn(25, context.var("out"));
            mw.visitVarInsn(16, 93);
            mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "write", "(C)V");
            return;
        }
        int i = 0;
        while (i < size) {
            char seperator = i == size + (-1) ? ']' : ',';
            FieldInfo property = getters.get(i);
            Class<?> propertyClass = property.getFieldClass();
            mw.visitLdcInsn(property.getName());
            mw.visitVarInsn(58, context.fieldName());
            if (propertyClass == Byte.TYPE || propertyClass == Short.TYPE || propertyClass == Integer.TYPE) {
                mw.visitVarInsn(25, context.var("out"));
                _get(mw, context, property);
                mw.visitVarInsn(16, seperator);
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeIntAndChar", "(IC)V");
            } else if (propertyClass == Long.TYPE) {
                mw.visitVarInsn(25, context.var("out"));
                _get(mw, context, property);
                mw.visitVarInsn(16, seperator);
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeLongAndChar", "(JC)V");
            } else if (propertyClass == Float.TYPE) {
                mw.visitVarInsn(25, context.var("out"));
                _get(mw, context, property);
                mw.visitVarInsn(16, seperator);
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFloatAndChar", "(FC)V");
            } else if (propertyClass == Double.TYPE) {
                mw.visitVarInsn(25, context.var("out"));
                _get(mw, context, property);
                mw.visitVarInsn(16, seperator);
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeDoubleAndChar", "(DC)V");
            } else if (propertyClass == Boolean.TYPE) {
                mw.visitVarInsn(25, context.var("out"));
                _get(mw, context, property);
                mw.visitVarInsn(16, seperator);
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeBooleanAndChar", "(ZC)V");
            } else if (propertyClass == Character.TYPE) {
                mw.visitVarInsn(25, context.var("out"));
                _get(mw, context, property);
                mw.visitVarInsn(16, seperator);
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeCharacterAndChar", "(CC)V");
            } else if (propertyClass == String.class) {
                mw.visitVarInsn(25, context.var("out"));
                _get(mw, context, property);
                mw.visitVarInsn(16, seperator);
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeString", "(Ljava/lang/String;C)V");
            } else if (propertyClass.isEnum()) {
                mw.visitVarInsn(25, context.var("out"));
                _get(mw, context, property);
                mw.visitVarInsn(16, seperator);
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeEnum", "(Ljava/lang/Enum;C)V");
            } else {
                String format = property.getFormat();
                mw.visitVarInsn(25, context.serializer());
                _get(mw, context, property);
                if (format != null) {
                    mw.visitLdcInsn(format);
                    mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
                } else {
                    mw.visitVarInsn(25, context.fieldName());
                    if ((property.getFieldType() instanceof Class) && ((Class) property.getFieldType()).isPrimitive()) {
                        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                    } else {
                        mw.visitVarInsn(25, 0);
                        mw.visitFieldInsn(180, context.getClassName(), String.valueOf(property.getName()) + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                        mw.visitLdcInsn(Integer.valueOf(property.getSerialzeFeatures()));
                        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    }
                }
                mw.visitVarInsn(25, context.var("out"));
                mw.visitVarInsn(16, seperator);
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "write", "(C)V");
            }
            i++;
        }
    }

    private void generateWriteMethod(Class<?> clazz, MethodVisitor mw, List<FieldInfo> getters, Context context) throws Exception {
        Label end = new Label();
        int size = getters.size();
        Label endFormat_ = new Label();
        Label notNull_ = new Label();
        mw.visitVarInsn(25, context.var("out"));
        mw.visitFieldInsn(178, "com/alibaba/fastjson/serializer/SerializerFeature", "PrettyFormat", "Lcom/alibaba/fastjson/serializer/SerializerFeature;");
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "isEnabled", "(Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z");
        mw.visitJumpInsn(153, endFormat_);
        mw.visitVarInsn(25, 0);
        mw.visitFieldInsn(180, context.getClassName(), "nature", "Lcom/alibaba/fastjson/serializer/JavaBeanSerializer;");
        mw.visitJumpInsn(199, notNull_);
        mw.visitLabel(notNull_);
        mw.visitVarInsn(25, 0);
        mw.visitFieldInsn(180, context.getClassName(), "nature", "Lcom/alibaba/fastjson/serializer/JavaBeanSerializer;");
        mw.visitVarInsn(25, 1);
        mw.visitVarInsn(25, 2);
        mw.visitVarInsn(25, 3);
        mw.visitVarInsn(25, 4);
        mw.visitVarInsn(21, 5);
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JavaBeanSerializer", "write", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        mw.visitInsn(177);
        mw.visitLabel(endFormat_);
        Label endRef_ = new Label();
        Label notNull_2 = new Label();
        mw.visitVarInsn(25, 0);
        mw.visitFieldInsn(180, context.getClassName(), "nature", "Lcom/alibaba/fastjson/serializer/JavaBeanSerializer;");
        mw.visitJumpInsn(199, notNull_2);
        mw.visitLabel(notNull_2);
        mw.visitVarInsn(25, 0);
        mw.visitFieldInsn(180, context.getClassName(), "nature", "Lcom/alibaba/fastjson/serializer/JavaBeanSerializer;");
        mw.visitVarInsn(25, 1);
        mw.visitVarInsn(25, 2);
        mw.visitVarInsn(21, 5);
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JavaBeanSerializer", "writeReference", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;I)Z");
        mw.visitJumpInsn(153, endRef_);
        mw.visitInsn(177);
        mw.visitLabel(endRef_);
        Label endWriteAsArray_ = new Label();
        mw.visitVarInsn(25, 0);
        mw.visitFieldInsn(180, context.getClassName(), "nature", "Lcom/alibaba/fastjson/serializer/JavaBeanSerializer;");
        mw.visitVarInsn(25, context.serializer());
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JavaBeanSerializer", "isWriteAsArray", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;)Z");
        mw.visitJumpInsn(153, endWriteAsArray_);
        mw.visitVarInsn(25, 0);
        mw.visitVarInsn(25, 1);
        mw.visitVarInsn(25, 2);
        mw.visitVarInsn(25, 3);
        mw.visitVarInsn(25, 4);
        mw.visitMethodInsn(182, context.getClassName(), "writeAsArray", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;)V");
        mw.visitInsn(177);
        mw.visitLabel(endWriteAsArray_);
        mw.visitVarInsn(25, context.serializer());
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "getContext", "()Lcom/alibaba/fastjson/serializer/SerialContext;");
        mw.visitVarInsn(58, context.var("parent"));
        mw.visitVarInsn(25, context.serializer());
        mw.visitVarInsn(25, context.var("parent"));
        mw.visitVarInsn(25, context.obj());
        mw.visitVarInsn(25, context.paramFieldName());
        mw.visitLdcInsn(Integer.valueOf(context.beanSerializeFeatures));
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "setContext", "(Lcom/alibaba/fastjson/serializer/SerialContext;Ljava/lang/Object;Ljava/lang/Object;I)V");
        Label end_ = new Label();
        Label else_ = new Label();
        Label writeClass_ = new Label();
        mw.visitVarInsn(25, context.serializer());
        mw.visitVarInsn(25, context.paramFieldType());
        mw.visitVarInsn(25, context.obj());
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
        mw.visitJumpInsn(153, else_);
        mw.visitVarInsn(25, context.paramFieldType());
        mw.visitVarInsn(25, context.obj());
        mw.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
        mw.visitJumpInsn(165, else_);
        mw.visitLabel(writeClass_);
        mw.visitVarInsn(25, context.var("out"));
        mw.visitLdcInsn("{\"" + JSON.DEFAULT_TYPE_KEY + "\":\"" + clazz.getName() + "\"");
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "write", "(Ljava/lang/String;)V");
        mw.visitVarInsn(16, 44);
        mw.visitJumpInsn(167, end_);
        mw.visitLabel(else_);
        mw.visitVarInsn(16, 123);
        mw.visitLabel(end_);
        mw.visitVarInsn(54, context.var("seperator"));
        _before(mw, context);
        for (int i = 0; i < size; i++) {
            FieldInfo property = getters.get(i);
            Class<?> propertyClass = property.getFieldClass();
            mw.visitLdcInsn(property.getName());
            mw.visitVarInsn(58, context.fieldName());
            if (propertyClass == Byte.TYPE) {
                _byte(clazz, mw, property, context);
            } else if (propertyClass == Short.TYPE) {
                _short(clazz, mw, property, context);
            } else if (propertyClass == Integer.TYPE) {
                _int(clazz, mw, property, context);
            } else if (propertyClass == Long.TYPE) {
                _long(clazz, mw, property, context);
            } else if (propertyClass == Float.TYPE) {
                _float(clazz, mw, property, context);
            } else if (propertyClass == Double.TYPE) {
                _double(clazz, mw, property, context);
            } else if (propertyClass == Boolean.TYPE) {
                _boolean(clazz, mw, property, context);
            } else if (propertyClass == Character.TYPE) {
                _char(clazz, mw, property, context);
            } else if (propertyClass == String.class) {
                _string(clazz, mw, property, context);
            } else if (propertyClass == BigDecimal.class) {
                _decimal(clazz, mw, property, context);
            } else if (List.class.isAssignableFrom(propertyClass)) {
                _list(clazz, mw, property, context);
            } else if (propertyClass.isEnum()) {
                _enum(clazz, mw, property, context);
            } else {
                _object(clazz, mw, property, context);
            }
        }
        _after(mw, context);
        Label _else = new Label();
        Label _end_if = new Label();
        mw.visitVarInsn(21, context.var("seperator"));
        mw.visitIntInsn(16, 123);
        mw.visitJumpInsn(160, _else);
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(16, 123);
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "write", "(C)V");
        mw.visitLabel(_else);
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(16, 125);
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "write", "(C)V");
        mw.visitLabel(_end_if);
        mw.visitLabel(end);
        mw.visitVarInsn(25, context.serializer());
        mw.visitVarInsn(25, context.var("parent"));
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "setContext", "(Lcom/alibaba/fastjson/serializer/SerialContext;)V");
    }

    private void _object(Class<?> clazz, MethodVisitor mw, FieldInfo property, Context context) {
        Label _end = new Label();
        _nameApply(mw, property, context, _end);
        _get(mw, context, property);
        mw.visitVarInsn(58, context.var("object"));
        _filters(mw, property, context, _end);
        _writeObject(mw, property, context, _end);
        mw.visitLabel(_end);
    }

    private void _enum(Class<?> clazz, MethodVisitor mw, FieldInfo property, Context context) {
        boolean writeEnumUsingToString = false;
        JSONField annotation = (JSONField) property.getAnnotation(JSONField.class);
        if (annotation != null) {
            for (SerializerFeature feature : annotation.serialzeFeatures()) {
                if (feature == SerializerFeature.WriteEnumUsingToString) {
                    writeEnumUsingToString = true;
                }
            }
        }
        Label _not_null = new Label();
        Label _end_if = new Label();
        Label _end = new Label();
        _nameApply(mw, property, context, _end);
        _get(mw, context, property);
        mw.visitTypeInsn(192, "java/lang/Enum");
        mw.visitVarInsn(58, context.var("enum"));
        _filters(mw, property, context, _end);
        mw.visitVarInsn(25, context.var("enum"));
        mw.visitJumpInsn(199, _not_null);
        _if_write_null(mw, property, context);
        mw.visitJumpInsn(167, _end_if);
        mw.visitLabel(_not_null);
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(21, context.var("seperator"));
        mw.visitVarInsn(25, context.fieldName());
        mw.visitVarInsn(25, context.var("enum"));
        if (writeEnumUsingToString) {
            mw.visitMethodInsn(182, "java/lang/Object", "toString", "()Ljava/lang/String;");
            mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldValue", "(CLjava/lang/String;Ljava/lang/Enum;)V");
        }
        _seperator(mw, context);
        mw.visitLabel(_end_if);
        mw.visitLabel(_end);
    }

    private void _long(Class<?> clazz, MethodVisitor mw, FieldInfo property, Context context) {
        Label _end = new Label();
        _nameApply(mw, property, context, _end);
        _get(mw, context, property);
        mw.visitVarInsn(55, context.var("long", 2));
        _filters(mw, property, context, _end);
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(21, context.var("seperator"));
        mw.visitVarInsn(25, context.fieldName());
        mw.visitVarInsn(22, context.var("long", 2));
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldValue", "(CLjava/lang/String;J)V");
        _seperator(mw, context);
        mw.visitLabel(_end);
    }

    private void _float(Class<?> clazz, MethodVisitor mw, FieldInfo property, Context context) {
        Label _end = new Label();
        _nameApply(mw, property, context, _end);
        _get(mw, context, property);
        mw.visitVarInsn(56, context.var("float"));
        _filters(mw, property, context, _end);
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(21, context.var("seperator"));
        mw.visitVarInsn(25, context.fieldName());
        mw.visitVarInsn(23, context.var("float"));
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldValue", "(CLjava/lang/String;F)V");
        _seperator(mw, context);
        mw.visitLabel(_end);
    }

    private void _double(Class<?> clazz, MethodVisitor mw, FieldInfo property, Context context) {
        Label _end = new Label();
        _nameApply(mw, property, context, _end);
        _get(mw, context, property);
        mw.visitVarInsn(57, context.var("double", 2));
        _filters(mw, property, context, _end);
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(21, context.var("seperator"));
        mw.visitVarInsn(25, context.fieldName());
        mw.visitVarInsn(24, context.var("double", 2));
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldValue", "(CLjava/lang/String;D)V");
        _seperator(mw, context);
        mw.visitLabel(_end);
    }

    private void _char(Class<?> clazz, MethodVisitor mw, FieldInfo property, Context context) {
        Label _end = new Label();
        _nameApply(mw, property, context, _end);
        _get(mw, context, property);
        mw.visitVarInsn(54, context.var("char"));
        _filters(mw, property, context, _end);
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(21, context.var("seperator"));
        mw.visitVarInsn(25, context.fieldName());
        mw.visitVarInsn(21, context.var("char"));
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldValue", "(CLjava/lang/String;C)V");
        _seperator(mw, context);
        mw.visitLabel(_end);
    }

    private void _boolean(Class<?> clazz, MethodVisitor mw, FieldInfo property, Context context) {
        Label _end = new Label();
        _nameApply(mw, property, context, _end);
        _get(mw, context, property);
        mw.visitVarInsn(54, context.var("boolean"));
        _filters(mw, property, context, _end);
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(21, context.var("seperator"));
        mw.visitVarInsn(25, context.fieldName());
        mw.visitVarInsn(21, context.var("boolean"));
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldValue", "(CLjava/lang/String;Z)V");
        _seperator(mw, context);
        mw.visitLabel(_end);
    }

    private void _get(MethodVisitor mw, Context context, FieldInfo property) {
        Method method = property.getMethod();
        if (method != null) {
            mw.visitVarInsn(25, context.var("entity"));
            mw.visitMethodInsn(182, ASMUtils.getType(method.getDeclaringClass()), method.getName(), ASMUtils.getDesc(method));
        } else {
            mw.visitVarInsn(25, context.var("entity"));
            mw.visitFieldInsn(180, ASMUtils.getType(property.getDeclaringClass()), property.getField().getName(), ASMUtils.getDesc(property.getFieldClass()));
        }
    }

    private void _byte(Class<?> clazz, MethodVisitor mw, FieldInfo property, Context context) {
        Label _end = new Label();
        _nameApply(mw, property, context, _end);
        _get(mw, context, property);
        mw.visitVarInsn(54, context.var("byte"));
        _filters(mw, property, context, _end);
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(21, context.var("seperator"));
        mw.visitVarInsn(25, context.fieldName());
        mw.visitVarInsn(21, context.var("byte"));
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldValue", "(CLjava/lang/String;I)V");
        _seperator(mw, context);
        mw.visitLabel(_end);
    }

    private void _short(Class<?> clazz, MethodVisitor mw, FieldInfo property, Context context) {
        Label _end = new Label();
        _nameApply(mw, property, context, _end);
        _get(mw, context, property);
        mw.visitVarInsn(54, context.var("short"));
        _filters(mw, property, context, _end);
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(21, context.var("seperator"));
        mw.visitVarInsn(25, context.fieldName());
        mw.visitVarInsn(21, context.var("short"));
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldValue", "(CLjava/lang/String;I)V");
        _seperator(mw, context);
        mw.visitLabel(_end);
    }

    private void _int(Class<?> clazz, MethodVisitor mw, FieldInfo property, Context context) {
        Label _end = new Label();
        _nameApply(mw, property, context, _end);
        _get(mw, context, property);
        mw.visitVarInsn(54, context.var("int"));
        _filters(mw, property, context, _end);
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(21, context.var("seperator"));
        mw.visitVarInsn(25, context.fieldName());
        mw.visitVarInsn(21, context.var("int"));
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldValue", "(CLjava/lang/String;I)V");
        _seperator(mw, context);
        mw.visitLabel(_end);
    }

    private void _decimal(Class<?> clazz, MethodVisitor mw, FieldInfo property, Context context) {
        Label _end = new Label();
        _nameApply(mw, property, context, _end);
        _get(mw, context, property);
        mw.visitVarInsn(58, context.var("decimal"));
        _filters(mw, property, context, _end);
        Label _if = new Label();
        Label _else = new Label();
        Label _end_if = new Label();
        mw.visitLabel(_if);
        mw.visitVarInsn(25, context.var("decimal"));
        mw.visitJumpInsn(199, _else);
        _if_write_null(mw, property, context);
        mw.visitJumpInsn(167, _end_if);
        mw.visitLabel(_else);
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(21, context.var("seperator"));
        mw.visitVarInsn(25, context.fieldName());
        mw.visitVarInsn(25, context.var("decimal"));
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
        _seperator(mw, context);
        mw.visitJumpInsn(167, _end_if);
        mw.visitLabel(_end_if);
        mw.visitLabel(_end);
    }

    private void _string(Class<?> clazz, MethodVisitor mw, FieldInfo property, Context context) {
        Label _end = new Label();
        _nameApply(mw, property, context, _end);
        _get(mw, context, property);
        mw.visitVarInsn(58, context.var("string"));
        _filters(mw, property, context, _end);
        Label _else = new Label();
        Label _end_if = new Label();
        mw.visitVarInsn(25, context.var("string"));
        mw.visitJumpInsn(199, _else);
        _if_write_null(mw, property, context);
        mw.visitJumpInsn(167, _end_if);
        mw.visitLabel(_else);
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(21, context.var("seperator"));
        mw.visitVarInsn(25, context.fieldName());
        mw.visitVarInsn(25, context.var("string"));
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
        _seperator(mw, context);
        mw.visitLabel(_end_if);
        mw.visitLabel(_end);
    }

    private void _list(Class<?> clazz, MethodVisitor mw, FieldInfo property, Context context) {
        java.lang.reflect.Type elementType;
        java.lang.reflect.Type propertyType = property.getFieldType();
        if (propertyType instanceof Class) {
            elementType = Object.class;
        } else {
            elementType = ((ParameterizedType) propertyType).getActualTypeArguments()[0];
        }
        Class<?> elementClass = null;
        if (elementType instanceof Class) {
            elementClass = (Class) elementType;
        }
        Label _end = new Label();
        Label _if = new Label();
        Label _else = new Label();
        Label _end_if = new Label();
        mw.visitLabel(_if);
        _nameApply(mw, property, context, _end);
        _get(mw, context, property);
        mw.visitTypeInsn(192, "java/util/List");
        mw.visitVarInsn(58, context.var("list"));
        _filters(mw, property, context, _end);
        mw.visitVarInsn(25, context.var("list"));
        mw.visitJumpInsn(199, _else);
        _if_write_null(mw, property, context);
        mw.visitJumpInsn(167, _end_if);
        mw.visitLabel(_else);
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(21, context.var("seperator"));
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "write", "(C)V");
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(25, context.fieldName());
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldName", "(Ljava/lang/String;)V");
        mw.visitVarInsn(25, context.var("list"));
        mw.visitMethodInsn(185, "java/util/List", "size", "()I");
        mw.visitVarInsn(54, context.var("int"));
        Label _if_3 = new Label();
        Label _else_3 = new Label();
        Label _end_if_3 = new Label();
        mw.visitLabel(_if_3);
        mw.visitVarInsn(21, context.var("int"));
        mw.visitInsn(3);
        mw.visitJumpInsn(160, _else_3);
        mw.visitVarInsn(25, context.var("out"));
        mw.visitLdcInsn("[]");
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "write", "(Ljava/lang/String;)V");
        mw.visitJumpInsn(167, _end_if_3);
        mw.visitLabel(_else_3);
        mw.visitVarInsn(25, context.serializer());
        mw.visitVarInsn(25, context.var("list"));
        mw.visitVarInsn(25, context.fieldName());
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(16, 91);
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "write", "(C)V");
        mw.visitInsn(1);
        mw.visitTypeInsn(192, "com/alibaba/fastjson/serializer/ObjectSerializer");
        mw.visitVarInsn(58, context.var("list_ser"));
        Label _for = new Label();
        Label _end_for = new Label();
        mw.visitInsn(3);
        mw.visitVarInsn(54, context.var("i"));
        mw.visitLabel(_for);
        mw.visitVarInsn(21, context.var("i"));
        mw.visitVarInsn(21, context.var("int"));
        mw.visitInsn(4);
        mw.visitInsn(100);
        mw.visitJumpInsn(162, _end_for);
        if (elementType == String.class) {
            mw.visitVarInsn(25, context.var("out"));
            mw.visitVarInsn(25, context.var("list"));
            mw.visitVarInsn(21, context.var("i"));
            mw.visitMethodInsn(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
            mw.visitTypeInsn(192, "java/lang/String");
            mw.visitVarInsn(16, 44);
            mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeString", "(Ljava/lang/String;C)V");
        } else {
            mw.visitVarInsn(25, context.serializer());
            mw.visitVarInsn(25, context.var("list"));
            mw.visitVarInsn(21, context.var("i"));
            mw.visitMethodInsn(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
            mw.visitVarInsn(21, context.var("i"));
            mw.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            if (elementClass != null && Modifier.isPublic(elementClass.getModifiers())) {
                mw.visitLdcInsn(Type.getType(ASMUtils.getDesc((Class<?>) elementType)));
                mw.visitLdcInsn(Integer.valueOf(property.getSerialzeFeatures()));
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            } else {
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            }
            mw.visitVarInsn(25, context.var("out"));
            mw.visitVarInsn(16, 44);
            mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "write", "(C)V");
        }
        mw.visitIincInsn(context.var("i"), 1);
        mw.visitJumpInsn(167, _for);
        mw.visitLabel(_end_for);
        if (elementType == String.class) {
            mw.visitVarInsn(25, context.var("out"));
            mw.visitVarInsn(25, context.var("list"));
            mw.visitVarInsn(21, context.var("int"));
            mw.visitInsn(4);
            mw.visitInsn(100);
            mw.visitMethodInsn(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
            mw.visitTypeInsn(192, "java/lang/String");
            mw.visitVarInsn(16, 93);
            mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeString", "(Ljava/lang/String;C)V");
        } else {
            mw.visitVarInsn(25, context.serializer());
            mw.visitVarInsn(25, context.var("list"));
            mw.visitVarInsn(21, context.var("i"));
            mw.visitMethodInsn(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
            mw.visitVarInsn(21, context.var("i"));
            mw.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            if (elementClass != null && Modifier.isPublic(elementClass.getModifiers())) {
                mw.visitLdcInsn(Type.getType(ASMUtils.getDesc((Class<?>) elementType)));
                mw.visitLdcInsn(Integer.valueOf(property.getSerialzeFeatures()));
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            } else {
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            }
            mw.visitVarInsn(25, context.var("out"));
            mw.visitVarInsn(16, 93);
            mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "write", "(C)V");
        }
        mw.visitVarInsn(25, context.serializer());
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "popContext", "()V");
        mw.visitLabel(_end_if_3);
        _seperator(mw, context);
        mw.visitLabel(_end_if);
        mw.visitLabel(_end);
    }

    private void _filters(MethodVisitor mw, FieldInfo property, Context context, Label _end) {
        if (property.getField() != null && Modifier.isTransient(property.getField().getModifiers())) {
            mw.visitVarInsn(25, context.var("out"));
            mw.visitFieldInsn(178, "com/alibaba/fastjson/serializer/SerializerFeature", "SkipTransientField", "Lcom/alibaba/fastjson/serializer/SerializerFeature;");
            mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "isEnabled", "(Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z");
            mw.visitJumpInsn(154, _end);
        }
        _notWriteDefault(mw, property, context, _end);
        _apply(mw, property, context);
        mw.visitJumpInsn(153, _end);
        _processKey(mw, property, context);
        Label _else_processKey = new Label();
        _processValue(mw, property, context);
        mw.visitVarInsn(25, context.original());
        mw.visitVarInsn(25, context.processValue());
        mw.visitJumpInsn(165, _else_processKey);
        _writeObject(mw, property, context, _end);
        mw.visitJumpInsn(167, _end);
        mw.visitLabel(_else_processKey);
    }

    private void _nameApply(MethodVisitor mw, FieldInfo property, Context context, Label _end) {
        mw.visitVarInsn(25, context.serializer());
        mw.visitVarInsn(25, context.obj());
        mw.visitVarInsn(25, context.fieldName());
        mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "applyName", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;)Z");
        mw.visitJumpInsn(153, _end);
        _labelApply(mw, property, context, _end);
        if (property.getField() == null) {
            mw.visitVarInsn(25, context.var("out"));
            mw.visitFieldInsn(178, "com/alibaba/fastjson/serializer/SerializerFeature", "IgnoreNonFieldGetter", "Lcom/alibaba/fastjson/serializer/SerializerFeature;");
            mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "isEnabled", "(Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z");
            mw.visitJumpInsn(154, _end);
        }
    }

    private void _labelApply(MethodVisitor mw, FieldInfo property, Context context, Label _end) {
        mw.visitVarInsn(25, context.serializer());
        mw.visitLdcInsn(property.getLabel());
        mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "applyLabel", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/String;)Z");
        mw.visitJumpInsn(153, _end);
    }

    private void _writeObject(MethodVisitor mw, FieldInfo fieldInfo, Context context, Label _end) {
        String format = fieldInfo.getFormat();
        Label _not_null = new Label();
        mw.visitVarInsn(25, context.processValue());
        mw.visitJumpInsn(199, _not_null);
        _if_write_null(mw, fieldInfo, context);
        mw.visitJumpInsn(167, _end);
        mw.visitLabel(_not_null);
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(21, context.var("seperator"));
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "write", "(C)V");
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(25, context.fieldName());
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldName", "(Ljava/lang/String;)V");
        mw.visitVarInsn(25, context.serializer());
        mw.visitVarInsn(25, context.processValue());
        if (format != null) {
            mw.visitLdcInsn(format);
            mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
        } else {
            mw.visitVarInsn(25, context.fieldName());
            if ((fieldInfo.getFieldType() instanceof Class) && ((Class) fieldInfo.getFieldType()).isPrimitive()) {
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                mw.visitVarInsn(25, 0);
                mw.visitFieldInsn(180, context.getClassName(), String.valueOf(fieldInfo.getName()) + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                mw.visitLdcInsn(Integer.valueOf(fieldInfo.getSerialzeFeatures()));
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/JSONSerializer", "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
        }
        _seperator(mw, context);
    }

    private void _before(MethodVisitor mw, Context context) {
        mw.visitVarInsn(25, context.serializer());
        mw.visitVarInsn(25, context.obj());
        mw.visitVarInsn(21, context.var("seperator"));
        mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "writeBefore", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;C)C");
        mw.visitVarInsn(54, context.var("seperator"));
    }

    private void _after(MethodVisitor mw, Context context) {
        mw.visitVarInsn(25, context.serializer());
        mw.visitVarInsn(25, context.obj());
        mw.visitVarInsn(21, context.var("seperator"));
        mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "writeAfter", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;C)C");
        mw.visitVarInsn(54, context.var("seperator"));
    }

    private void _notWriteDefault(MethodVisitor mw, FieldInfo property, Context context, Label _end) {
        Label elseLabel = new Label();
        mw.visitVarInsn(25, context.var("out"));
        mw.visitFieldInsn(178, "com/alibaba/fastjson/serializer/SerializerFeature", "NotWriteDefaultValue", "Lcom/alibaba/fastjson/serializer/SerializerFeature;");
        mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "isEnabled", "(Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z");
        mw.visitJumpInsn(153, elseLabel);
        Class<?> propertyClass = property.getFieldClass();
        if (propertyClass == Boolean.TYPE) {
            mw.visitVarInsn(21, context.var("boolean"));
            mw.visitJumpInsn(153, _end);
        } else if (propertyClass == Byte.TYPE) {
            mw.visitVarInsn(21, context.var("byte"));
            mw.visitJumpInsn(153, _end);
        } else if (propertyClass == Short.TYPE) {
            mw.visitVarInsn(21, context.var("short"));
            mw.visitJumpInsn(153, _end);
        } else if (propertyClass == Integer.TYPE) {
            mw.visitVarInsn(21, context.var("int"));
            mw.visitJumpInsn(153, _end);
        } else if (propertyClass == Long.TYPE) {
            mw.visitVarInsn(22, context.var("long"));
            mw.visitInsn(9);
            mw.visitInsn(148);
            mw.visitJumpInsn(153, _end);
        } else if (propertyClass == Float.TYPE) {
            mw.visitVarInsn(23, context.var("float"));
            mw.visitInsn(11);
            mw.visitInsn(149);
            mw.visitJumpInsn(153, _end);
        } else if (propertyClass == Double.TYPE) {
            mw.visitVarInsn(24, context.var("double"));
            mw.visitInsn(14);
            mw.visitInsn(151);
            mw.visitJumpInsn(153, _end);
        }
        mw.visitLabel(elseLabel);
    }

    private void _apply(MethodVisitor mw, FieldInfo property, Context context) {
        Class<?> propertyClass = property.getFieldClass();
        mw.visitVarInsn(25, context.serializer());
        mw.visitVarInsn(25, context.obj());
        mw.visitVarInsn(25, context.fieldName());
        if (propertyClass == Byte.TYPE) {
            mw.visitVarInsn(21, context.var("byte"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "apply", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;B)Z");
            return;
        }
        if (propertyClass == Short.TYPE) {
            mw.visitVarInsn(21, context.var("short"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "apply", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;S)Z");
            return;
        }
        if (propertyClass == Integer.TYPE) {
            mw.visitVarInsn(21, context.var("int"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "apply", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;I)Z");
            return;
        }
        if (propertyClass == Character.TYPE) {
            mw.visitVarInsn(21, context.var("char"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "apply", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;C)Z");
            return;
        }
        if (propertyClass == Long.TYPE) {
            mw.visitVarInsn(22, context.var("long", 2));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "apply", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;J)Z");
            return;
        }
        if (propertyClass == Float.TYPE) {
            mw.visitVarInsn(23, context.var("float"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "apply", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;F)Z");
            return;
        }
        if (propertyClass == Double.TYPE) {
            mw.visitVarInsn(24, context.var("double", 2));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "apply", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;D)Z");
            return;
        }
        if (propertyClass == Boolean.TYPE) {
            mw.visitVarInsn(21, context.var("boolean"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "apply", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;B)Z");
            return;
        }
        if (propertyClass == BigDecimal.class) {
            mw.visitVarInsn(25, context.var("decimal"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "apply", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
            return;
        }
        if (propertyClass == String.class) {
            mw.visitVarInsn(25, context.var("string"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "apply", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
        } else if (propertyClass.isEnum()) {
            mw.visitVarInsn(25, context.var("enum"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "apply", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
        } else if (List.class.isAssignableFrom(propertyClass)) {
            mw.visitVarInsn(25, context.var("list"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "apply", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
        } else {
            mw.visitVarInsn(25, context.var("object"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "apply", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
        }
    }

    private void _processValue(MethodVisitor mw, FieldInfo property, Context context) {
        Class<?> propertyClass = property.getFieldClass();
        mw.visitVarInsn(25, context.serializer());
        mw.visitVarInsn(25, context.obj());
        mw.visitVarInsn(25, context.fieldName());
        if (propertyClass == Byte.TYPE) {
            mw.visitVarInsn(21, context.var("byte"));
            mw.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (propertyClass == Short.TYPE) {
            mw.visitVarInsn(21, context.var("short"));
            mw.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (propertyClass == Integer.TYPE) {
            mw.visitVarInsn(21, context.var("int"));
            mw.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (propertyClass == Character.TYPE) {
            mw.visitVarInsn(21, context.var("char"));
            mw.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (propertyClass == Long.TYPE) {
            mw.visitVarInsn(22, context.var("long", 2));
            mw.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (propertyClass == Float.TYPE) {
            mw.visitVarInsn(23, context.var("float"));
            mw.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (propertyClass == Double.TYPE) {
            mw.visitVarInsn(24, context.var("double", 2));
            mw.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (propertyClass == Boolean.TYPE) {
            mw.visitVarInsn(21, context.var("boolean"));
            mw.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (propertyClass == BigDecimal.class) {
            mw.visitVarInsn(25, context.var("decimal"));
        } else if (propertyClass == String.class) {
            mw.visitVarInsn(25, context.var("string"));
        } else if (propertyClass.isEnum()) {
            mw.visitVarInsn(25, context.var("enum"));
        } else if (List.class.isAssignableFrom(propertyClass)) {
            mw.visitVarInsn(25, context.var("list"));
        } else {
            mw.visitVarInsn(25, context.var("object"));
        }
        mw.visitVarInsn(58, context.original());
        mw.visitVarInsn(25, context.original());
        mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "processValue", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;");
        mw.visitVarInsn(58, context.processValue());
    }

    private void _processKey(MethodVisitor mw, FieldInfo property, Context context) {
        Class<?> propertyClass = property.getFieldClass();
        mw.visitVarInsn(25, context.serializer());
        mw.visitVarInsn(25, context.obj());
        mw.visitVarInsn(25, context.fieldName());
        if (propertyClass == Byte.TYPE) {
            mw.visitVarInsn(21, context.var("byte"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "processKey", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;B)Ljava/lang/String;");
        } else if (propertyClass == Short.TYPE) {
            mw.visitVarInsn(21, context.var("short"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "processKey", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;S)Ljava/lang/String;");
        } else if (propertyClass == Integer.TYPE) {
            mw.visitVarInsn(21, context.var("int"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "processKey", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;I)Ljava/lang/String;");
        } else if (propertyClass == Character.TYPE) {
            mw.visitVarInsn(21, context.var("char"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "processKey", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;C)Ljava/lang/String;");
        } else if (propertyClass == Long.TYPE) {
            mw.visitVarInsn(22, context.var("long", 2));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "processKey", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;J)Ljava/lang/String;");
        } else if (propertyClass == Float.TYPE) {
            mw.visitVarInsn(23, context.var("float"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "processKey", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;F)Ljava/lang/String;");
        } else if (propertyClass == Double.TYPE) {
            mw.visitVarInsn(24, context.var("double", 2));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "processKey", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;D)Ljava/lang/String;");
        } else if (propertyClass == Boolean.TYPE) {
            mw.visitVarInsn(21, context.var("boolean"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "processKey", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Z)Ljava/lang/String;");
        } else if (propertyClass == BigDecimal.class) {
            mw.visitVarInsn(25, context.var("decimal"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "processKey", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
        } else if (propertyClass == String.class) {
            mw.visitVarInsn(25, context.var("string"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "processKey", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
        } else if (propertyClass.isEnum()) {
            mw.visitVarInsn(25, context.var("enum"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "processKey", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
        } else if (List.class.isAssignableFrom(propertyClass)) {
            mw.visitVarInsn(25, context.var("list"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "processKey", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
        } else {
            mw.visitVarInsn(25, context.var("object"));
            mw.visitMethodInsn(184, "com/alibaba/fastjson/serializer/FilterUtils", "processKey", "(Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
        }
        mw.visitVarInsn(58, context.fieldName());
    }

    private void _if_write_null(MethodVisitor mw, FieldInfo fieldInfo, Context context) {
        Class<?> propertyClass = fieldInfo.getFieldClass();
        Label _if = new Label();
        Label _else = new Label();
        Label _write_null = new Label();
        Label _end_if = new Label();
        mw.visitLabel(_if);
        boolean writeNull = false;
        boolean writeNullNumberAsZero = false;
        boolean writeNullStringAsEmpty = false;
        boolean writeNullBooleanAsFalse = false;
        boolean writeNullListAsEmpty = false;
        JSONField annotation = (JSONField) fieldInfo.getAnnotation(JSONField.class);
        if (annotation != null) {
            for (SerializerFeature feature : annotation.serialzeFeatures()) {
                if (feature == SerializerFeature.WriteMapNullValue) {
                    writeNull = true;
                } else if (feature == SerializerFeature.WriteNullNumberAsZero) {
                    writeNullNumberAsZero = true;
                } else if (feature == SerializerFeature.WriteNullStringAsEmpty) {
                    writeNullStringAsEmpty = true;
                } else if (feature == SerializerFeature.WriteNullBooleanAsFalse) {
                    writeNullBooleanAsFalse = true;
                } else if (feature == SerializerFeature.WriteNullListAsEmpty) {
                    writeNullListAsEmpty = true;
                }
            }
        }
        if (!writeNull) {
            mw.visitVarInsn(25, context.var("out"));
            mw.visitFieldInsn(178, "com/alibaba/fastjson/serializer/SerializerFeature", "WriteMapNullValue", "Lcom/alibaba/fastjson/serializer/SerializerFeature;");
            mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "isEnabled", "(Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z");
            mw.visitJumpInsn(153, _else);
        }
        mw.visitLabel(_write_null);
        mw.visitVarInsn(25, context.var("out"));
        mw.visitVarInsn(21, context.var("seperator"));
        mw.visitVarInsn(25, context.fieldName());
        if (propertyClass == String.class || propertyClass == Character.class) {
            if (writeNullStringAsEmpty) {
                mw.visitLdcInsn(FinalChip.BSP_PLATFORM_Null);
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
            } else {
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldNullString", "(CLjava/lang/String;)V");
            }
        } else if (Number.class.isAssignableFrom(propertyClass)) {
            if (writeNullNumberAsZero) {
                mw.visitInsn(3);
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldValue", "(CLjava/lang/String;I)V");
            } else {
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldNullNumber", "(CLjava/lang/String;)V");
            }
        } else if (propertyClass == Boolean.class) {
            if (writeNullBooleanAsFalse) {
                mw.visitInsn(3);
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldValue", "(CLjava/lang/String;Z)V");
            } else {
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldNullBoolean", "(CLjava/lang/String;)V");
            }
        } else if (Collection.class.isAssignableFrom(propertyClass) || propertyClass.isArray()) {
            if (writeNullListAsEmpty) {
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldEmptyList", "(CLjava/lang/String;)V");
            } else {
                mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldNullList", "(CLjava/lang/String;)V");
            }
        } else {
            mw.visitMethodInsn(182, "com/alibaba/fastjson/serializer/SerializeWriter", "writeFieldNull", "(CLjava/lang/String;)V");
        }
        _seperator(mw, context);
        mw.visitJumpInsn(167, _end_if);
        mw.visitLabel(_else);
        mw.visitLabel(_end_if);
    }

    private void _seperator(MethodVisitor mw, Context context) {
        mw.visitVarInsn(16, 44);
        mw.visitVarInsn(54, context.var("seperator"));
    }
}
