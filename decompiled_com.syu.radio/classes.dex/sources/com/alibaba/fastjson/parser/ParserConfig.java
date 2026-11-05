package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.asm.ASMException;
import com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory;
import com.alibaba.fastjson.parser.deserializer.ASMJavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ArrayDeserializer;
import com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.BooleanFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.CharArrayDeserializer;
import com.alibaba.fastjson.parser.deserializer.ClassDerializer;
import com.alibaba.fastjson.parser.deserializer.CollectionDeserializer;
import com.alibaba.fastjson.parser.deserializer.DateDeserializer;
import com.alibaba.fastjson.parser.deserializer.DateFormatDeserializer;
import com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.IntegerFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JSONArrayDeserializer;
import com.alibaba.fastjson.parser.deserializer.JSONObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.LongFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
import com.alibaba.fastjson.parser.deserializer.NumberDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer;
import com.alibaba.fastjson.parser.deserializer.StringFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer;
import com.alibaba.fastjson.parser.deserializer.TimeDeserializer;
import com.alibaba.fastjson.parser.deserializer.TimestampDeserializer;
import com.alibaba.fastjson.serializer.AtomicIntegerArrayCodec;
import com.alibaba.fastjson.serializer.AtomicLongArrayCodec;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BigIntegerCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.CharacterCodec;
import com.alibaba.fastjson.serializer.CharsetCodec;
import com.alibaba.fastjson.serializer.ColorCodec;
import com.alibaba.fastjson.serializer.CurrencyCodec;
import com.alibaba.fastjson.serializer.FileCodec;
import com.alibaba.fastjson.serializer.FloatCodec;
import com.alibaba.fastjson.serializer.FontCodec;
import com.alibaba.fastjson.serializer.InetAddressCodec;
import com.alibaba.fastjson.serializer.InetSocketAddressCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LocaleCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.PatternCodec;
import com.alibaba.fastjson.serializer.PointCodec;
import com.alibaba.fastjson.serializer.RectangleCodec;
import com.alibaba.fastjson.serializer.ReferenceCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.serializer.TimeZoneCodec;
import com.alibaba.fastjson.serializer.URICodec;
import com.alibaba.fastjson.serializer.URLCodec;
import com.alibaba.fastjson.serializer.UUIDCodec;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.DeserializeBeanInfo;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.ServiceLoader;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.AccessControlException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ParserConfig {
    private static ParserConfig global = new ParserConfig();
    private boolean asmEnable;
    protected ASMDeserializerFactory asmFactory;
    private final IdentityHashMap<Type, ObjectDeserializer> derializers;
    private final Set<Class<?>> primitiveClasses;
    protected final SymbolTable symbolTable;

    public static ParserConfig getGlobalInstance() {
        return global;
    }

    public ParserConfig() {
        this(null, null);
    }

    public ParserConfig(ClassLoader parentClassLoader) {
        this(null, parentClassLoader);
    }

    public ParserConfig(ASMDeserializerFactory asmFactory) {
        this(asmFactory, null);
    }

    private ParserConfig(ASMDeserializerFactory asmFactory, ClassLoader parentClassLoader) {
        this.primitiveClasses = new HashSet();
        this.derializers = new IdentityHashMap<>();
        this.asmEnable = !ASMUtils.isAndroid();
        this.symbolTable = new SymbolTable();
        if (asmFactory == null) {
            try {
                if (parentClassLoader == null) {
                    asmFactory = ASMDeserializerFactory.getInstance();
                } else {
                    asmFactory = new ASMDeserializerFactory(parentClassLoader);
                }
            } catch (ExceptionInInitializerError e) {
            } catch (NoClassDefFoundError e2) {
            } catch (AccessControlException e3) {
            }
        }
        this.asmFactory = asmFactory;
        if (asmFactory == null) {
            this.asmEnable = false;
        }
        this.primitiveClasses.add(Boolean.TYPE);
        this.primitiveClasses.add(Boolean.class);
        this.primitiveClasses.add(Character.TYPE);
        this.primitiveClasses.add(Character.class);
        this.primitiveClasses.add(Byte.TYPE);
        this.primitiveClasses.add(Byte.class);
        this.primitiveClasses.add(Short.TYPE);
        this.primitiveClasses.add(Short.class);
        this.primitiveClasses.add(Integer.TYPE);
        this.primitiveClasses.add(Integer.class);
        this.primitiveClasses.add(Long.TYPE);
        this.primitiveClasses.add(Long.class);
        this.primitiveClasses.add(Float.TYPE);
        this.primitiveClasses.add(Float.class);
        this.primitiveClasses.add(Double.TYPE);
        this.primitiveClasses.add(Double.class);
        this.primitiveClasses.add(BigInteger.class);
        this.primitiveClasses.add(BigDecimal.class);
        this.primitiveClasses.add(String.class);
        this.primitiveClasses.add(Date.class);
        this.primitiveClasses.add(java.sql.Date.class);
        this.primitiveClasses.add(Time.class);
        this.primitiveClasses.add(Timestamp.class);
        this.derializers.put(SimpleDateFormat.class, DateFormatDeserializer.instance);
        this.derializers.put(Timestamp.class, TimestampDeserializer.instance);
        this.derializers.put(java.sql.Date.class, SqlDateDeserializer.instance);
        this.derializers.put(Time.class, TimeDeserializer.instance);
        this.derializers.put(Date.class, DateDeserializer.instance);
        this.derializers.put(Calendar.class, CalendarCodec.instance);
        this.derializers.put(JSONObject.class, JSONObjectDeserializer.instance);
        this.derializers.put(JSONArray.class, JSONArrayDeserializer.instance);
        this.derializers.put(Map.class, MapDeserializer.instance);
        this.derializers.put(HashMap.class, MapDeserializer.instance);
        this.derializers.put(LinkedHashMap.class, MapDeserializer.instance);
        this.derializers.put(TreeMap.class, MapDeserializer.instance);
        this.derializers.put(ConcurrentMap.class, MapDeserializer.instance);
        this.derializers.put(ConcurrentHashMap.class, MapDeserializer.instance);
        this.derializers.put(Collection.class, CollectionDeserializer.instance);
        this.derializers.put(List.class, CollectionDeserializer.instance);
        this.derializers.put(ArrayList.class, CollectionDeserializer.instance);
        this.derializers.put(Object.class, JavaObjectDeserializer.instance);
        this.derializers.put(String.class, StringCodec.instance);
        this.derializers.put(StringBuffer.class, StringCodec.instance);
        this.derializers.put(StringBuilder.class, StringCodec.instance);
        this.derializers.put(Character.TYPE, CharacterCodec.instance);
        this.derializers.put(Character.class, CharacterCodec.instance);
        this.derializers.put(Byte.TYPE, NumberDeserializer.instance);
        this.derializers.put(Byte.class, NumberDeserializer.instance);
        this.derializers.put(Short.TYPE, NumberDeserializer.instance);
        this.derializers.put(Short.class, NumberDeserializer.instance);
        this.derializers.put(Integer.TYPE, IntegerCodec.instance);
        this.derializers.put(Integer.class, IntegerCodec.instance);
        this.derializers.put(Long.TYPE, LongCodec.instance);
        this.derializers.put(Long.class, LongCodec.instance);
        this.derializers.put(BigInteger.class, BigIntegerCodec.instance);
        this.derializers.put(BigDecimal.class, BigDecimalCodec.instance);
        this.derializers.put(Float.TYPE, FloatCodec.instance);
        this.derializers.put(Float.class, FloatCodec.instance);
        this.derializers.put(Double.TYPE, NumberDeserializer.instance);
        this.derializers.put(Double.class, NumberDeserializer.instance);
        this.derializers.put(Boolean.TYPE, BooleanCodec.instance);
        this.derializers.put(Boolean.class, BooleanCodec.instance);
        this.derializers.put(Class.class, ClassDerializer.instance);
        this.derializers.put(char[].class, CharArrayDeserializer.instance);
        this.derializers.put(AtomicBoolean.class, BooleanCodec.instance);
        this.derializers.put(AtomicInteger.class, IntegerCodec.instance);
        this.derializers.put(AtomicLong.class, LongCodec.instance);
        this.derializers.put(AtomicReference.class, ReferenceCodec.instance);
        this.derializers.put(WeakReference.class, ReferenceCodec.instance);
        this.derializers.put(SoftReference.class, ReferenceCodec.instance);
        this.derializers.put(UUID.class, UUIDCodec.instance);
        this.derializers.put(TimeZone.class, TimeZoneCodec.instance);
        this.derializers.put(Locale.class, LocaleCodec.instance);
        this.derializers.put(Currency.class, CurrencyCodec.instance);
        this.derializers.put(InetAddress.class, InetAddressCodec.instance);
        this.derializers.put(Inet4Address.class, InetAddressCodec.instance);
        this.derializers.put(Inet6Address.class, InetAddressCodec.instance);
        this.derializers.put(InetSocketAddress.class, InetSocketAddressCodec.instance);
        this.derializers.put(File.class, FileCodec.instance);
        this.derializers.put(URI.class, URICodec.instance);
        this.derializers.put(URL.class, URLCodec.instance);
        this.derializers.put(Pattern.class, PatternCodec.instance);
        this.derializers.put(Charset.class, CharsetCodec.instance);
        this.derializers.put(Number.class, NumberDeserializer.instance);
        this.derializers.put(AtomicIntegerArray.class, AtomicIntegerArrayCodec.instance);
        this.derializers.put(AtomicLongArray.class, AtomicLongArrayCodec.instance);
        this.derializers.put(StackTraceElement.class, StackTraceElementDeserializer.instance);
        this.derializers.put(Serializable.class, JavaObjectDeserializer.instance);
        this.derializers.put(Cloneable.class, JavaObjectDeserializer.instance);
        this.derializers.put(Comparable.class, JavaObjectDeserializer.instance);
        this.derializers.put(Closeable.class, JavaObjectDeserializer.instance);
        try {
            this.derializers.put(Class.forName("java.awt.Point"), PointCodec.instance);
            this.derializers.put(Class.forName("java.awt.Font"), FontCodec.instance);
            this.derializers.put(Class.forName("java.awt.Rectangle"), RectangleCodec.instance);
            this.derializers.put(Class.forName("java.awt.Color"), ColorCodec.instance);
        } catch (Throwable th) {
        }
        try {
            this.derializers.put(Class.forName("java.time.LocalDateTime"), Jdk8DateCodec.instance);
            this.derializers.put(Class.forName("java.time.LocalDate"), Jdk8DateCodec.instance);
            this.derializers.put(Class.forName("java.time.LocalTime"), Jdk8DateCodec.instance);
            this.derializers.put(Class.forName("java.time.ZonedDateTime"), Jdk8DateCodec.instance);
            this.derializers.put(Class.forName("java.time.OffsetDateTime"), Jdk8DateCodec.instance);
            this.derializers.put(Class.forName("java.time.OffsetTime"), Jdk8DateCodec.instance);
            this.derializers.put(Class.forName("java.time.ZoneOffset"), Jdk8DateCodec.instance);
            this.derializers.put(Class.forName("java.time.ZoneRegion"), Jdk8DateCodec.instance);
            this.derializers.put(Class.forName("java.time.ZoneId"), Jdk8DateCodec.instance);
            this.derializers.put(Class.forName("java.time.Period"), Jdk8DateCodec.instance);
            this.derializers.put(Class.forName("java.time.Duration"), Jdk8DateCodec.instance);
            this.derializers.put(Class.forName("java.time.Instant"), Jdk8DateCodec.instance);
        } catch (Throwable th2) {
        }
    }

    public boolean isAsmEnable() {
        return this.asmEnable;
    }

    public void setAsmEnable(boolean asmEnable) {
        this.asmEnable = asmEnable;
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public IdentityHashMap<Type, ObjectDeserializer> getDerializers() {
        return this.derializers;
    }

    public ObjectDeserializer getDeserializer(Type type) {
        ObjectDeserializer derializer = this.derializers.get(type);
        if (derializer == null) {
            if (type instanceof Class) {
                return getDeserializer((Class) type, type);
            }
            if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                if (rawType instanceof Class) {
                    return getDeserializer((Class) rawType, type);
                }
                return getDeserializer(rawType);
            }
            return JavaObjectDeserializer.instance;
        }
        return derializer;
    }

    public ObjectDeserializer getDeserializer(Class<?> clazz, Type type) {
        ObjectDeserializer derializer;
        Class<?> mappingTo;
        ObjectDeserializer derializer2 = this.derializers.get(type);
        if (derializer2 != null) {
            return derializer2;
        }
        if (type == null) {
            type = clazz;
        }
        ObjectDeserializer derializer3 = this.derializers.get(type);
        if (derializer3 != null) {
            return derializer3;
        }
        JSONType annotation = (JSONType) clazz.getAnnotation(JSONType.class);
        if (annotation != null && (mappingTo = annotation.mappingTo()) != Void.class) {
            return getDeserializer(mappingTo, mappingTo);
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable) || (type instanceof ParameterizedType)) {
            derializer3 = this.derializers.get(clazz);
        }
        if (derializer3 != null) {
            return derializer3;
        }
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            for (AutowiredObjectDeserializer autowired : ServiceLoader.load(AutowiredObjectDeserializer.class, classLoader)) {
                for (Type forType : autowired.getAutowiredFor()) {
                    this.derializers.put(forType, autowired);
                }
            }
        } catch (Exception e) {
        }
        ObjectDeserializer derializer4 = this.derializers.get(type);
        if (derializer4 != null) {
            return derializer4;
        }
        if (clazz.isEnum()) {
            derializer = new EnumDeserializer(clazz);
        } else if (clazz.isArray()) {
            derializer = ArrayDeserializer.instance;
        } else if (clazz == Set.class || clazz == HashSet.class || clazz == Collection.class || clazz == List.class || clazz == ArrayList.class || Collection.class.isAssignableFrom(clazz)) {
            derializer = CollectionDeserializer.instance;
        } else if (Map.class.isAssignableFrom(clazz)) {
            derializer = MapDeserializer.instance;
        } else if (Throwable.class.isAssignableFrom(clazz)) {
            derializer = new ThrowableDeserializer(this, clazz);
        } else {
            derializer = createJavaBeanDeserializer(clazz, type);
        }
        putDeserializer(type, derializer);
        return derializer;
    }

    public ObjectDeserializer createJavaBeanDeserializer(Class<?> clazz, Type type) {
        boolean asmEnable = this.asmEnable;
        if (asmEnable) {
            Class<?> superClass = DeserializeBeanInfo.getBuilderClass(clazz);
            if (superClass == null) {
                superClass = clazz;
            }
            do {
                if (!Modifier.isPublic(superClass.getModifiers())) {
                    asmEnable = false;
                    break;
                }
                superClass = superClass.getSuperclass();
                if (superClass == Object.class) {
                    break;
                }
            } while (superClass != null);
        }
        if (clazz.getTypeParameters().length != 0) {
            asmEnable = false;
        }
        if (asmEnable && this.asmFactory != null && this.asmFactory.isExternalClass(clazz)) {
            asmEnable = false;
        }
        if (asmEnable) {
            asmEnable = ASMUtils.checkName(clazz.getName());
        }
        if (asmEnable) {
            if (clazz.isInterface()) {
                asmEnable = false;
            }
            DeserializeBeanInfo beanInfo = DeserializeBeanInfo.computeSetters(clazz, type);
            if (asmEnable && beanInfo.getFieldList().size() > 200) {
                asmEnable = false;
            }
            Constructor<?> defaultConstructor = beanInfo.getDefaultConstructor();
            if (asmEnable && defaultConstructor == null && !clazz.isInterface()) {
                asmEnable = false;
            }
            for (FieldInfo fieldInfo : beanInfo.getFieldList()) {
                if (fieldInfo.isGetOnly()) {
                    asmEnable = false;
                    break;
                }
                Class<?> fieldClass = fieldInfo.getFieldClass();
                if (!Modifier.isPublic(fieldClass.getModifiers())) {
                    asmEnable = false;
                    break;
                }
                if (fieldClass.isMemberClass() && !Modifier.isStatic(fieldClass.getModifiers())) {
                    asmEnable = false;
                }
                if (!ASMUtils.checkName(fieldInfo.getMember().getName())) {
                    asmEnable = false;
                }
                JSONField annotation = (JSONField) fieldInfo.getAnnotation(JSONField.class);
                if (annotation != null && !ASMUtils.checkName(annotation.name())) {
                    asmEnable = false;
                }
            }
        }
        if (asmEnable && clazz.isMemberClass() && !Modifier.isStatic(clazz.getModifiers())) {
            asmEnable = false;
        }
        if (!asmEnable) {
            return new JavaBeanDeserializer(this, clazz, type);
        }
        try {
            return this.asmFactory.createJavaBeanDeserializer(this, clazz, type);
        } catch (ASMException e) {
            return new JavaBeanDeserializer(this, clazz, type);
        } catch (NoSuchMethodException e2) {
            return new JavaBeanDeserializer(this, clazz, type);
        } catch (Exception e3) {
            throw new JSONException("create asm deserializer error, " + clazz.getName(), e3);
        }
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig mapping, DeserializeBeanInfo beanInfo, FieldInfo fieldInfo) {
        boolean asmEnable = this.asmEnable;
        Class<?> clazz = beanInfo.getClazz();
        if (asmEnable) {
            Class<?> superClass = beanInfo.getBuilderClass();
            if (superClass == null) {
                superClass = clazz;
            }
            do {
                if (!Modifier.isPublic(superClass.getModifiers())) {
                    asmEnable = false;
                    break;
                }
                superClass = superClass.getSuperclass();
                if (superClass == Object.class) {
                    break;
                }
            } while (superClass != null);
        }
        if (fieldInfo.getFieldClass() == Class.class) {
            asmEnable = false;
        }
        if (asmEnable && this.asmFactory != null && this.asmFactory.isExternalClass(clazz)) {
            asmEnable = false;
        }
        if (!asmEnable) {
            return createFieldDeserializerWithoutASM(mapping, clazz, fieldInfo);
        }
        try {
            return this.asmFactory.createFieldDeserializer(mapping, clazz, fieldInfo);
        } catch (Throwable th) {
            return createFieldDeserializerWithoutASM(mapping, clazz, fieldInfo);
        }
    }

    public FieldDeserializer createFieldDeserializerWithoutASM(ParserConfig mapping, Class<?> clazz, FieldInfo fieldInfo) {
        Class<?> fieldClass = fieldInfo.getFieldClass();
        if (fieldClass == Boolean.TYPE || fieldClass == Boolean.class) {
            return new BooleanFieldDeserializer(mapping, clazz, fieldInfo);
        }
        if (fieldClass == Integer.TYPE || fieldClass == Integer.class) {
            return new IntegerFieldDeserializer(mapping, clazz, fieldInfo);
        }
        if (fieldClass == Long.TYPE || fieldClass == Long.class) {
            return new LongFieldDeserializer(mapping, clazz, fieldInfo);
        }
        if (fieldClass == String.class) {
            return new StringFieldDeserializer(mapping, clazz, fieldInfo);
        }
        if (fieldClass == List.class || fieldClass == ArrayList.class) {
            return new ArrayListTypeFieldDeserializer(mapping, clazz, fieldInfo);
        }
        return new DefaultFieldDeserializer(mapping, clazz, fieldInfo);
    }

    public void putDeserializer(Type type, ObjectDeserializer deserializer) {
        this.derializers.put(type, deserializer);
    }

    public ObjectDeserializer getDeserializer(FieldInfo fieldInfo) {
        return getDeserializer(fieldInfo.getFieldClass(), fieldInfo.getFieldType());
    }

    public boolean isPrimitive(Class<?> clazz) {
        return this.primitiveClasses.contains(clazz);
    }

    public static Field getField(Class<?> clazz, String fieldName) {
        Field field = getField0(clazz, fieldName);
        if (field == null) {
            field = getField0(clazz, "_" + fieldName);
        }
        if (field == null) {
            return getField0(clazz, "m_" + fieldName);
        }
        return field;
    }

    private static Field getField0(Class<?> clazz, String fieldName) {
        for (Field item : clazz.getDeclaredFields()) {
            if (fieldName.equals(item.getName())) {
                return item;
            }
        }
        if (clazz.getSuperclass() != null && clazz.getSuperclass() != Object.class) {
            return getField(clazz.getSuperclass(), fieldName);
        }
        return null;
    }

    public Map<String, FieldDeserializer> getFieldDeserializers(Class<?> clazz) {
        ObjectDeserializer deserizer = getDeserializer(clazz);
        if (deserizer instanceof JavaBeanDeserializer) {
            return ((JavaBeanDeserializer) deserizer).getFieldDeserializerMap();
        }
        if (deserizer instanceof ASMJavaBeanDeserializer) {
            return ((ASMJavaBeanDeserializer) deserizer).getInnterSerializer().getFieldDeserializerMap();
        }
        return Collections.emptyMap();
    }
}
