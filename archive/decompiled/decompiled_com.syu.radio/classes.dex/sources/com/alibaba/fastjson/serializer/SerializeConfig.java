package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.ServiceLoader;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class SerializeConfig extends IdentityHashMap<Type, ObjectSerializer> {
    private boolean asm;
    private ASMSerializerFactory asmFactory;
    private String typeKey;
    private static final SerializeConfig globalInstance = new SerializeConfig();
    private static boolean awtError = false;
    private static boolean jdk8Error = false;
    private static boolean oracleJdbcError = false;

    public String getTypeKey() {
        return this.typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey;
    }

    public final ObjectSerializer createASMSerializer(Class<?> clazz) throws Exception {
        return this.asmFactory.createJavaBeanSerializer(clazz, null);
    }

    public ObjectSerializer createJavaBeanSerializer(Class<?> clazz) {
        if (!Modifier.isPublic(clazz.getModifiers())) {
            return new JavaBeanSerializer(clazz);
        }
        boolean asm = this.asm;
        if ((asm && this.asmFactory.isExternalClass(clazz)) || clazz == Serializable.class || clazz == Object.class) {
            asm = false;
        }
        JSONType annotation = (JSONType) clazz.getAnnotation(JSONType.class);
        if (annotation != null && !annotation.asm()) {
            asm = false;
        }
        if (asm && !ASMUtils.checkName(clazz.getName())) {
            asm = false;
        }
        if (asm) {
            for (Field field : clazz.getDeclaredFields()) {
                JSONField annotation2 = (JSONField) field.getAnnotation(JSONField.class);
                if (annotation2 != null && !ASMUtils.checkName(annotation2.name())) {
                    asm = false;
                    break;
                }
            }
        }
        if (asm) {
            try {
                ObjectSerializer asmSerializer = createASMSerializer(clazz);
                if (asmSerializer != null) {
                    return asmSerializer;
                }
            } catch (ClassCastException e) {
            } catch (Throwable e2) {
                throw new JSONException("create asm serializer error, class " + clazz, e2);
            }
        }
        return new JavaBeanSerializer(clazz);
    }

    public boolean isAsmEnable() {
        return this.asm;
    }

    public void setAsmEnable(boolean asmEnable) {
        this.asm = asmEnable;
    }

    public static SerializeConfig getGlobalInstance() {
        return globalInstance;
    }

    public SerializeConfig() {
        this(1024);
    }

    public SerializeConfig(int tableSize) {
        super(tableSize);
        this.asm = !ASMUtils.isAndroid();
        this.typeKey = JSON.DEFAULT_TYPE_KEY;
        try {
            this.asmFactory = new ASMSerializerFactory();
        } catch (ExceptionInInitializerError e) {
            this.asm = false;
        } catch (NoClassDefFoundError e2) {
            this.asm = false;
        }
        put(Boolean.class, BooleanCodec.instance);
        put(Character.class, CharacterCodec.instance);
        put(Byte.class, IntegerCodec.instance);
        put(Short.class, IntegerCodec.instance);
        put(Integer.class, IntegerCodec.instance);
        put(Long.class, LongCodec.instance);
        put(Float.class, FloatCodec.instance);
        put(Double.class, DoubleSerializer.instance);
        put(BigDecimal.class, BigDecimalCodec.instance);
        put(BigInteger.class, BigIntegerCodec.instance);
        put(String.class, StringCodec.instance);
        put(byte[].class, ByteArraySerializer.instance);
        put(short[].class, ShortArraySerializer.instance);
        put(int[].class, IntArraySerializer.instance);
        put(long[].class, LongArraySerializer.instance);
        put(float[].class, FloatArraySerializer.instance);
        put(double[].class, DoubleArraySerializer.instance);
        put(boolean[].class, BooleanArraySerializer.instance);
        put(char[].class, CharArraySerializer.instance);
        put(Object[].class, ObjectArraySerializer.instance);
        put(Class.class, ClassSerializer.instance);
        put(SimpleDateFormat.class, DateFormatSerializer.instance);
        put(Locale.class, LocaleCodec.instance);
        put(Currency.class, CurrencyCodec.instance);
        put(TimeZone.class, TimeZoneCodec.instance);
        put(UUID.class, UUIDCodec.instance);
        put(InetAddress.class, InetAddressCodec.instance);
        put(Inet4Address.class, InetAddressCodec.instance);
        put(Inet6Address.class, InetAddressCodec.instance);
        put(InetSocketAddress.class, InetSocketAddressCodec.instance);
        put(File.class, FileCodec.instance);
        put(URI.class, URICodec.instance);
        put(URL.class, URLCodec.instance);
        put(Appendable.class, AppendableSerializer.instance);
        put(StringBuffer.class, AppendableSerializer.instance);
        put(StringBuilder.class, AppendableSerializer.instance);
        put(Pattern.class, PatternCodec.instance);
        put(Charset.class, CharsetCodec.instance);
        put(AtomicBoolean.class, AtomicBooleanSerializer.instance);
        put(AtomicInteger.class, AtomicIntegerSerializer.instance);
        put(AtomicLong.class, AtomicLongSerializer.instance);
        put(AtomicReference.class, ReferenceCodec.instance);
        put(AtomicIntegerArray.class, AtomicIntegerArrayCodec.instance);
        put(AtomicLongArray.class, AtomicLongArrayCodec.instance);
        put(WeakReference.class, ReferenceCodec.instance);
        put(SoftReference.class, ReferenceCodec.instance);
        if (!awtError) {
            try {
                put(Class.forName("java.awt.Color"), ColorCodec.instance);
                put(Class.forName("java.awt.Font"), FontCodec.instance);
                put(Class.forName("java.awt.Point"), PointCodec.instance);
                put(Class.forName("java.awt.Rectangle"), RectangleCodec.instance);
            } catch (Throwable th) {
                awtError = true;
            }
        }
        if (!jdk8Error) {
            try {
                put(Class.forName("java.time.LocalDateTime"), Jdk8DateCodec.instance);
                put(Class.forName("java.time.LocalDate"), Jdk8DateCodec.instance);
                put(Class.forName("java.time.LocalTime"), Jdk8DateCodec.instance);
                put(Class.forName("java.time.ZonedDateTime"), Jdk8DateCodec.instance);
                put(Class.forName("java.time.OffsetDateTime"), Jdk8DateCodec.instance);
                put(Class.forName("java.time.OffsetTime"), Jdk8DateCodec.instance);
                put(Class.forName("java.time.ZoneOffset"), Jdk8DateCodec.instance);
                put(Class.forName("java.time.ZoneRegion"), Jdk8DateCodec.instance);
                put(Class.forName("java.time.Period"), Jdk8DateCodec.instance);
                put(Class.forName("java.time.Duration"), Jdk8DateCodec.instance);
                put(Class.forName("java.time.Instant"), Jdk8DateCodec.instance);
            } catch (Throwable th2) {
                jdk8Error = true;
            }
        }
        if (!oracleJdbcError) {
            try {
                put(Class.forName("oracle.sql.DATE"), DateSerializer.instance);
                put(Class.forName("oracle.sql.TIMESTAMP"), DateSerializer.instance);
            } catch (Throwable th3) {
                oracleJdbcError = true;
            }
        }
    }

    public ObjectSerializer getObjectWriter(Class<?> clazz) {
        ClassLoader classLoader;
        ObjectSerializer writer = get(clazz);
        if (writer == null) {
            try {
                for (Object o : ServiceLoader.load(AutowiredObjectSerializer.class, Thread.currentThread().getContextClassLoader())) {
                    if (o instanceof AutowiredObjectSerializer) {
                        AutowiredObjectSerializer autowired = (AutowiredObjectSerializer) o;
                        for (Type forType : autowired.getAutowiredFor()) {
                            put(forType, autowired);
                        }
                    }
                }
            } catch (ClassCastException e) {
            }
            writer = get(clazz);
        }
        if (writer == null && (classLoader = JSON.class.getClassLoader()) != Thread.currentThread().getContextClassLoader()) {
            try {
                for (Object o2 : ServiceLoader.load(AutowiredObjectSerializer.class, classLoader)) {
                    if (o2 instanceof AutowiredObjectSerializer) {
                        AutowiredObjectSerializer autowired2 = (AutowiredObjectSerializer) o2;
                        for (Type forType2 : autowired2.getAutowiredFor()) {
                            put(forType2, autowired2);
                        }
                    }
                }
            } catch (ClassCastException e2) {
            }
            writer = get(clazz);
        }
        if (writer == null) {
            if (Map.class.isAssignableFrom(clazz)) {
                put(clazz, MapSerializer.instance);
            } else if (List.class.isAssignableFrom(clazz)) {
                put(clazz, ListSerializer.instance);
            } else if (Collection.class.isAssignableFrom(clazz)) {
                put(clazz, CollectionSerializer.instance);
            } else if (Date.class.isAssignableFrom(clazz)) {
                put(clazz, DateSerializer.instance);
            } else if (JSONAware.class.isAssignableFrom(clazz)) {
                put(clazz, JSONAwareSerializer.instance);
            } else if (JSONSerializable.class.isAssignableFrom(clazz)) {
                put(clazz, JSONSerializableSerializer.instance);
            } else if (JSONStreamAware.class.isAssignableFrom(clazz)) {
                put(clazz, JSONStreamAwareSerializer.instance);
            } else if (clazz.isEnum() || (clazz.getSuperclass() != null && clazz.getSuperclass().isEnum())) {
                put(clazz, EnumSerializer.instance);
            } else if (clazz.isArray()) {
                Class<?> componentType = clazz.getComponentType();
                ObjectSerializer compObjectSerializer = getObjectWriter(componentType);
                put(clazz, new ArraySerializer(componentType, compObjectSerializer));
            } else if (Throwable.class.isAssignableFrom(clazz)) {
                put(clazz, new ExceptionSerializer(clazz));
            } else if (TimeZone.class.isAssignableFrom(clazz)) {
                put(clazz, TimeZoneCodec.instance);
            } else if (Appendable.class.isAssignableFrom(clazz)) {
                put(clazz, AppendableSerializer.instance);
            } else if (Charset.class.isAssignableFrom(clazz)) {
                put(clazz, CharsetCodec.instance);
            } else if (Enumeration.class.isAssignableFrom(clazz)) {
                put(clazz, EnumerationSeriliazer.instance);
            } else if (Calendar.class.isAssignableFrom(clazz)) {
                put(clazz, CalendarCodec.instance);
            } else if (Clob.class.isAssignableFrom(clazz)) {
                put(clazz, ClobSeriliazer.instance);
            } else {
                boolean isCglibProxy = false;
                boolean isJavassistProxy = false;
                for (Class<?> item : clazz.getInterfaces()) {
                    if (item.getName().equals("net.sf.cglib.proxy.Factory") || item.getName().equals("org.springframework.cglib.proxy.Factory")) {
                        isCglibProxy = true;
                        break;
                    }
                    if (item.getName().equals("javassist.util.proxy.ProxyObject")) {
                        isJavassistProxy = true;
                        break;
                    }
                }
                if (isCglibProxy || isJavassistProxy) {
                    Class<?> superClazz = clazz.getSuperclass();
                    ObjectSerializer superWriter = getObjectWriter(superClazz);
                    put(clazz, superWriter);
                    return superWriter;
                }
                if (Proxy.isProxyClass(clazz)) {
                    put(clazz, createJavaBeanSerializer(clazz));
                } else {
                    put(clazz, createJavaBeanSerializer(clazz));
                }
            }
            writer = get(clazz);
        }
        return writer;
    }
}
