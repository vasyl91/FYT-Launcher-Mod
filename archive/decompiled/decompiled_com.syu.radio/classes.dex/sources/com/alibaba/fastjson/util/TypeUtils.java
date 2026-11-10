package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.asm.ASMException;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class TypeUtils {
    public static boolean compatibleWithJavaBean;
    private static ConcurrentMap<String, Class<?>> mappings;
    private static Method oracleDateMethod;
    private static Method oracleTimestampMethod;
    private static boolean setAccessibleEnable = true;
    private static boolean oracleTimestampMethodInited = false;
    private static boolean oracleDateMethodInited = false;

    static {
        compatibleWithJavaBean = false;
        try {
            String prop = System.getProperty("fastjson.compatibleWithJavaBean");
            if ("true".equals(prop)) {
                compatibleWithJavaBean = true;
            } else if ("false".equals(prop)) {
                compatibleWithJavaBean = false;
            }
        } catch (Throwable th) {
        }
        mappings = new ConcurrentHashMap();
        addBaseClassMappings();
    }

    public static String castToString(Object value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    public static Byte castToByte(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Number) {
            return Byte.valueOf(((Number) value).byteValue());
        }
        if (value instanceof String) {
            String strVal = (String) value;
            if (strVal.length() == 0 || "null".equals(strVal) || "NULL".equals(strVal)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(strVal));
        }
        throw new JSONException("can not cast to byte, value : " + value);
    }

    public static Character castToChar(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Character) {
            return (Character) value;
        }
        if (value instanceof String) {
            String strVal = (String) value;
            if (strVal.length() == 0) {
                return null;
            }
            if (strVal.length() != 1) {
                throw new JSONException("can not cast to byte, value : " + value);
            }
            return Character.valueOf(strVal.charAt(0));
        }
        throw new JSONException("can not cast to byte, value : " + value);
    }

    public static Short castToShort(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Number) {
            return Short.valueOf(((Number) value).shortValue());
        }
        if (value instanceof String) {
            String strVal = (String) value;
            if (strVal.length() == 0 || "null".equals(strVal) || "NULL".equals(strVal)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(strVal));
        }
        throw new JSONException("can not cast to short, value : " + value);
    }

    public static BigDecimal castToBigDecimal(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof BigDecimal) {
            return (BigDecimal) value;
        }
        if (value instanceof BigInteger) {
            return new BigDecimal((BigInteger) value);
        }
        String strVal = value.toString();
        if (strVal.length() == 0) {
            return null;
        }
        return new BigDecimal(strVal);
    }

    public static BigInteger castToBigInteger(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof BigInteger) {
            return (BigInteger) value;
        }
        if ((value instanceof Float) || (value instanceof Double)) {
            return BigInteger.valueOf(((Number) value).longValue());
        }
        String strVal = value.toString();
        if (strVal.length() == 0) {
            return null;
        }
        return new BigInteger(strVal);
    }

    public static Float castToFloat(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Number) {
            return Float.valueOf(((Number) value).floatValue());
        }
        if (value instanceof String) {
            String strVal = value.toString();
            if (strVal.length() == 0 || "null".equals(strVal) || "NULL".equals(strVal)) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(strVal));
        }
        throw new JSONException("can not cast to float, value : " + value);
    }

    public static Double castToDouble(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Number) {
            return Double.valueOf(((Number) value).doubleValue());
        }
        if (value instanceof String) {
            String strVal = value.toString();
            if (strVal.length() == 0 || "null".equals(strVal) || "NULL".equals(strVal)) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(strVal));
        }
        throw new JSONException("can not cast to double, value : " + value);
    }

    public static Date castToDate(Object value) {
        String format;
        if (value == null) {
            return null;
        }
        if (value instanceof Calendar) {
            return ((Calendar) value).getTime();
        }
        if (value instanceof Date) {
            return (Date) value;
        }
        long longValue = -1;
        if (value instanceof Number) {
            long longValue2 = ((Number) value).longValue();
            return new Date(longValue2);
        }
        if (value instanceof String) {
            String strVal = (String) value;
            if (strVal.indexOf(45) != -1) {
                if (strVal.length() == JSON.DEFFAULT_DATE_FORMAT.length()) {
                    format = JSON.DEFFAULT_DATE_FORMAT;
                } else if (strVal.length() == 10) {
                    format = "yyyy-MM-dd";
                } else if (strVal.length() == "yyyy-MM-dd HH:mm:ss".length()) {
                    format = "yyyy-MM-dd HH:mm:ss";
                } else {
                    format = "yyyy-MM-dd HH:mm:ss.SSS";
                }
                SimpleDateFormat dateFormat = new SimpleDateFormat(format);
                try {
                    return dateFormat.parse(strVal);
                } catch (ParseException e) {
                    throw new JSONException("can not cast to Date, value : " + strVal);
                }
            }
            if (strVal.length() == 0) {
                return null;
            }
            longValue = Long.parseLong(strVal);
        }
        if (longValue < 0) {
            Class<?> clazz = value.getClass();
            if ("oracle.sql.TIMESTAMP".equals(clazz.getName())) {
                if (oracleTimestampMethod == null && !oracleTimestampMethodInited) {
                    try {
                        oracleTimestampMethod = clazz.getMethod("toJdbc", new Class[0]);
                    } catch (NoSuchMethodException e2) {
                    } finally {
                        oracleTimestampMethodInited = true;
                    }
                }
                try {
                    Object result = oracleTimestampMethod.invoke(value, new Object[0]);
                    return (Date) result;
                } catch (Exception e3) {
                    throw new JSONException("can not cast oracle.sql.TIMESTAMP to Date", e3);
                }
            }
            if ("oracle.sql.DATE".equals(clazz.getName())) {
                if (oracleDateMethod == null && !oracleDateMethodInited) {
                    try {
                        oracleDateMethod = clazz.getMethod("toJdbc", new Class[0]);
                    } catch (NoSuchMethodException e4) {
                    } finally {
                        oracleDateMethodInited = true;
                    }
                }
                try {
                    Object result2 = oracleDateMethod.invoke(value, new Object[0]);
                    return (Date) result2;
                } catch (Exception e5) {
                    throw new JSONException("can not cast oracle.sql.DATE to Date", e5);
                }
            }
            throw new JSONException("can not cast to Date, value : " + value);
        }
        return new Date(longValue);
    }

    public static java.sql.Date castToSqlDate(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Calendar) {
            return new java.sql.Date(((Calendar) value).getTimeInMillis());
        }
        if (value instanceof java.sql.Date) {
            return (java.sql.Date) value;
        }
        if (value instanceof Date) {
            return new java.sql.Date(((Date) value).getTime());
        }
        long longValue = 0;
        if (value instanceof Number) {
            longValue = ((Number) value).longValue();
        }
        if (value instanceof String) {
            String strVal = (String) value;
            if (strVal.length() == 0) {
                return null;
            }
            longValue = Long.parseLong(strVal);
        }
        if (longValue <= 0) {
            throw new JSONException("can not cast to Date, value : " + value);
        }
        return new java.sql.Date(longValue);
    }

    public static Timestamp castToTimestamp(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Calendar) {
            return new Timestamp(((Calendar) value).getTimeInMillis());
        }
        if (value instanceof Timestamp) {
            return (Timestamp) value;
        }
        if (value instanceof Date) {
            return new Timestamp(((Date) value).getTime());
        }
        long longValue = 0;
        if (value instanceof Number) {
            longValue = ((Number) value).longValue();
        }
        if (value instanceof String) {
            String strVal = (String) value;
            if (strVal.length() == 0) {
                return null;
            }
            longValue = Long.parseLong(strVal);
        }
        if (longValue <= 0) {
            throw new JSONException("can not cast to Date, value : " + value);
        }
        return new Timestamp(longValue);
    }

    public static Long castToLong(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Number) {
            return Long.valueOf(((Number) value).longValue());
        }
        if (value instanceof String) {
            String strVal = (String) value;
            if (strVal.length() == 0 || "null".equals(strVal) || "NULL".equals(strVal)) {
                return null;
            }
            try {
                return Long.valueOf(Long.parseLong(strVal));
            } catch (NumberFormatException e) {
                JSONScanner dateParser = new JSONScanner(strVal);
                Calendar calendar = null;
                if (dateParser.scanISO8601DateIfMatch(false)) {
                    calendar = dateParser.getCalendar();
                }
                dateParser.close();
                if (calendar != null) {
                    return Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        throw new JSONException("can not cast to long, value : " + value);
    }

    public static Integer castToInt(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Integer) {
            return (Integer) value;
        }
        if (value instanceof Number) {
            return Integer.valueOf(((Number) value).intValue());
        }
        if (value instanceof String) {
            String strVal = (String) value;
            if (strVal.length() != 0 && !"null".equals(strVal)) {
                if ("null".equals(strVal) || "NULL".equals(strVal)) {
                    return null;
                }
                return Integer.valueOf(Integer.parseInt(strVal));
            }
            return null;
        }
        if (value instanceof Boolean) {
            return Integer.valueOf(((Boolean) value).booleanValue() ? 1 : 0);
        }
        throw new JSONException("can not cast to int, value : " + value);
    }

    public static byte[] castToBytes(Object value) {
        if (value instanceof byte[]) {
            return (byte[]) value;
        }
        if (value instanceof String) {
            return Base64.decodeFast((String) value);
        }
        throw new JSONException("can not cast to int, value : " + value);
    }

    public static Boolean castToBoolean(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        if (value instanceof Number) {
            return ((Number) value).intValue() == 1;
        }
        if (value instanceof String) {
            String strVal = (String) value;
            if (strVal.length() == 0) {
                return null;
            }
            if ("true".equalsIgnoreCase(strVal)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(strVal)) {
                return Boolean.FALSE;
            }
            if ("1".equals(strVal)) {
                return Boolean.TRUE;
            }
            if ("0".equals(strVal)) {
                return Boolean.FALSE;
            }
            if ("null".equals(strVal) || "NULL".equals(strVal)) {
                return null;
            }
        }
        throw new JSONException("can not cast to boolean, value : " + value);
    }

    public static <T> T castToJavaBean(Object obj, Class<T> cls) {
        return (T) cast(obj, (Class) cls, ParserConfig.getGlobalInstance());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig) {
        Calendar calendar;
        if (obj == 0) {
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        }
        if (cls != obj.getClass()) {
            if (obj instanceof Map) {
                if (cls != Map.class) {
                    Map map = (Map) obj;
                    if (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) {
                        return (T) castToJavaBean((Map) obj, cls, parserConfig);
                    }
                    return obj;
                }
                return obj;
            }
            if (cls.isArray()) {
                if (obj instanceof Collection) {
                    Collection collection = (Collection) obj;
                    int i = 0;
                    T t = (T) Array.newInstance(cls.getComponentType(), collection.size());
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        Array.set(t, i, cast(it.next(), (Class) cls.getComponentType(), parserConfig));
                        i++;
                    }
                    return t;
                }
                if (cls == byte[].class) {
                    return (T) castToBytes(obj);
                }
            }
            if (!cls.isAssignableFrom(obj.getClass())) {
                if (cls == Boolean.TYPE || cls == Boolean.class) {
                    return (T) castToBoolean(obj);
                }
                if (cls == Byte.TYPE || cls == Byte.class) {
                    return (T) castToByte(obj);
                }
                if (cls == Short.TYPE || cls == Short.class) {
                    return (T) castToShort(obj);
                }
                if (cls == Integer.TYPE || cls == Integer.class) {
                    return (T) castToInt(obj);
                }
                if (cls == Long.TYPE || cls == Long.class) {
                    return (T) castToLong(obj);
                }
                if (cls == Float.TYPE || cls == Float.class) {
                    return (T) castToFloat(obj);
                }
                if (cls == Double.TYPE || cls == Double.class) {
                    return (T) castToDouble(obj);
                }
                if (cls == String.class) {
                    return (T) castToString(obj);
                }
                if (cls == BigDecimal.class) {
                    return (T) castToBigDecimal(obj);
                }
                if (cls == BigInteger.class) {
                    return (T) castToBigInteger(obj);
                }
                if (cls == Date.class) {
                    return (T) castToDate(obj);
                }
                if (cls == java.sql.Date.class) {
                    return (T) castToSqlDate(obj);
                }
                if (cls == Timestamp.class) {
                    return (T) castToTimestamp(obj);
                }
                if (cls.isEnum()) {
                    return (T) castToEnum(obj, cls, parserConfig);
                }
                if (Calendar.class.isAssignableFrom(cls)) {
                    Date dateCastToDate = castToDate(obj);
                    if (cls == Calendar.class) {
                        calendar = Calendar.getInstance();
                    } else {
                        try {
                            calendar = (Calendar) cls.newInstance();
                        } catch (Exception e) {
                            throw new JSONException("can not cast to : " + cls.getName(), e);
                        }
                    }
                    calendar.setTime(dateCastToDate);
                    return (T) calendar;
                }
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.length() == 0) {
                        return null;
                    }
                    if (cls == Currency.class) {
                        return (T) Currency.getInstance(str);
                    }
                }
                throw new JSONException("can not cast to : " + cls.getName());
            }
            return obj;
        }
        return obj;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Enum] */
    public static <T> T castToEnum(Object obj, Class<T> cls, ParserConfig parserConfig) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return (T) Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                int iIntValue = ((Number) obj).intValue();
                for (Object obj2 : (Object[]) cls.getMethod("values", new Class[0]).invoke(null, new Object[0])) {
                    ?? r0 = (T) ((Enum) obj2);
                    if (r0.ordinal() == iIntValue) {
                        return r0;
                    }
                }
            }
            throw new JSONException("can not cast to : " + cls.getName());
        } catch (Exception e) {
            throw new JSONException("can not cast to : " + cls.getName(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object obj, Type type, ParserConfig parserConfig) {
        if (obj == 0) {
            return null;
        }
        if (type instanceof Class) {
            return (T) cast(obj, (Class) type, parserConfig);
        }
        if (type instanceof ParameterizedType) {
            return (T) cast(obj, (ParameterizedType) type, parserConfig);
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new JSONException("can not cast to : " + type);
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [T, java.util.HashMap, java.util.Map] */
    public static <T> T cast(Object obj, ParameterizedType parameterizedType, ParserConfig parserConfig) {
        T t;
        Type rawType = parameterizedType.getRawType();
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                if (rawType == Set.class || rawType == HashSet.class) {
                    t = (T) new HashSet();
                } else if (rawType == TreeSet.class) {
                    t = (T) new TreeSet();
                } else {
                    t = (T) new ArrayList();
                }
                Iterator<T> it = ((Iterable) obj).iterator();
                while (it.hasNext()) {
                    ((Collection) t).add(cast(it.next(), type, parserConfig));
                }
                return t;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                ?? r10 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    r10.put(cast(entry.getKey(), type2, parserConfig), cast(entry.getValue(), type3, parserConfig));
                }
                return r10;
            }
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) cast(obj, rawType, parserConfig);
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }

    public static <T> T castToJavaBean(Map<String, Object> map, Class<T> cls, ParserConfig parserConfig) {
        JSONObject jSONObject;
        int iIntValue;
        try {
            if (cls == StackTraceElement.class) {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number == null) {
                    iIntValue = 0;
                } else {
                    iIntValue = number.intValue();
                }
                return (T) new StackTraceElement(str, str2, str3, iIntValue);
            }
            Object obj = map.get(JSON.DEFAULT_TYPE_KEY);
            if (obj instanceof String) {
                String str4 = (String) obj;
                Class<?> clsLoadClass = loadClass(str4);
                if (clsLoadClass == null) {
                    throw new ClassNotFoundException(String.valueOf(str4) + " not found");
                }
                if (!clsLoadClass.equals(cls)) {
                    return (T) castToJavaBean(map, clsLoadClass, parserConfig);
                }
            }
            if (cls.isInterface()) {
                if (map instanceof JSONObject) {
                    jSONObject = (JSONObject) map;
                } else {
                    jSONObject = new JSONObject(map);
                }
                return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, jSONObject);
            }
            if (parserConfig == null) {
                parserConfig = ParserConfig.getGlobalInstance();
            }
            Map<String, FieldDeserializer> fieldDeserializers = parserConfig.getFieldDeserializers(cls);
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            T tNewInstance = declaredConstructor.newInstance(new Object[0]);
            for (Map.Entry<String, FieldDeserializer> entry : fieldDeserializers.entrySet()) {
                String key = entry.getKey();
                FieldDeserializer value = entry.getValue();
                if (map.containsKey(key)) {
                    Object obj2 = map.get(key);
                    Method method = value.getMethod();
                    if (method != null) {
                        method.invoke(tNewInstance, cast(obj2, method.getGenericParameterTypes()[0], parserConfig));
                    } else {
                        value.getField().set(tNewInstance, cast(obj2, value.getFieldType(), parserConfig));
                    }
                }
            }
            return tNewInstance;
        } catch (Exception e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public static void addClassMapping(String className, Class<?> clazz) {
        if (className == null) {
            className = clazz.getName();
        }
        mappings.put(className, clazz);
    }

    public static void addBaseClassMappings() {
        mappings.put("byte", Byte.TYPE);
        mappings.put("short", Short.TYPE);
        mappings.put("int", Integer.TYPE);
        mappings.put("long", Long.TYPE);
        mappings.put("float", Float.TYPE);
        mappings.put("double", Double.TYPE);
        mappings.put("boolean", Boolean.TYPE);
        mappings.put("char", Character.TYPE);
        mappings.put("[byte", byte[].class);
        mappings.put("[short", short[].class);
        mappings.put("[int", int[].class);
        mappings.put("[long", long[].class);
        mappings.put("[float", float[].class);
        mappings.put("[double", double[].class);
        mappings.put("[boolean", boolean[].class);
        mappings.put("[char", char[].class);
        mappings.put(HashMap.class.getName(), HashMap.class);
    }

    public static void clearClassMapping() {
        mappings.clear();
        addBaseClassMappings();
    }

    public static Class<?> loadClass(String className) {
        if (className == null || className.length() == 0) {
            return null;
        }
        Class<?> clazz = mappings.get(className);
        if (clazz == null) {
            if (className.charAt(0) == '[') {
                Class<?> componentType = loadClass(className.substring(1));
                return Array.newInstance(componentType, 0).getClass();
            }
            if (className.startsWith("L") && className.endsWith(";")) {
                String newClassName = className.substring(1, className.length() - 1);
                return loadClass(newClassName);
            }
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            if (classLoader != null) {
                clazz = classLoader.loadClass(className);
                addClassMapping(className, clazz);
                return clazz;
            }
            try {
                clazz = Class.forName(className);
                addClassMapping(className, clazz);
                return clazz;
            } catch (Throwable th) {
                return clazz;
            }
        }
        return clazz;
    }

    public static List<FieldInfo> computeGetters(Class<?> clazz, Map<String, String> aliasMap) {
        return computeGetters(clazz, aliasMap, true);
    }

    /* JADX WARN: Code duplicated, block: B:118:0x024c A[PHI: r3
  0x024c: PHI (r3v11 'propertyName' java.lang.String) = (r3v10 'propertyName' java.lang.String), (r3v13 'propertyName' java.lang.String) binds: [B:115:0x0240, B:117:0x024a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:169:0x03c5 A[PHI: r6 r7
  0x03c5: PHI (r6v4 'ordinal' int) = (r6v3 'ordinal' int), (r6v11 'ordinal' int) binds: [B:40:0x00c0, B:53:0x0110] A[DONT_GENERATE, DONT_INLINE]
  0x03c5: PHI (r7v4 'serialzeFeatures' int) = (r7v3 'serialzeFeatures' int), (r7v11 'serialzeFeatures' int) binds: [B:40:0x00c0, B:53:0x0110] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:185:0x0069 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0120  */
    /* JADX WARN: Code duplicated, block: B:89:0x01bd A[PHI: r6 r7 r8
  0x01bd: PHI (r6v6 'ordinal' int) = (r6v5 'ordinal' int), (r6v9 'ordinal' int) binds: [B:56:0x011e, B:88:0x01b3] A[DONT_GENERATE, DONT_INLINE]
  0x01bd: PHI (r7v6 'serialzeFeatures' int) = (r7v5 'serialzeFeatures' int), (r7v9 'serialzeFeatures' int) binds: [B:56:0x011e, B:88:0x01b3] A[DONT_GENERATE, DONT_INLINE]
  0x01bd: PHI (r8v5 'label' java.lang.String) = (r8v4 'label' java.lang.String), (r8v8 'label' java.lang.String) binds: [B:56:0x011e, B:88:0x01b3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:91:0x01c7  */
    public static List<FieldInfo> computeGetters(Class<?> clazz, Map<String, String> aliasMap, boolean sorted) {
        String label;
        String propertyName;
        JSONField fieldAnnotation;
        String propertyName2;
        JSONField fieldAnnotation2;
        Map<String, FieldInfo> fieldInfoMap = new LinkedHashMap<>();
        for (Method method : clazz.getMethods()) {
            String methodName = method.getName();
            int ordinal = 0;
            int serialzeFeatures = 0;
            if (!Modifier.isStatic(method.getModifiers()) && !method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 0 && method.getReturnType() != ClassLoader.class && (!method.getName().equals("getMetaClass") || !method.getReturnType().getName().equals("groovy.lang.MetaClass"))) {
                JSONField annotation = (JSONField) method.getAnnotation(JSONField.class);
                if (annotation == null) {
                    annotation = getSupperMethodAnnotation(clazz, method);
                }
                if (annotation == null) {
                    label = null;
                    if (!methodName.startsWith("get")) {
                        if (methodName.length() < 4 && !methodName.equals("getClass")) {
                            char c3 = methodName.charAt(3);
                            if (Character.isUpperCase(c3) || c3 > 512) {
                                if (compatibleWithJavaBean) {
                                    propertyName2 = decapitalize(methodName.substring(3));
                                } else {
                                    propertyName2 = String.valueOf(Character.toLowerCase(methodName.charAt(3))) + methodName.substring(4);
                                }
                            } else if (c3 == '_') {
                                propertyName2 = methodName.substring(4);
                            } else if (c3 == 'f') {
                                propertyName2 = methodName.substring(3);
                            } else if (methodName.length() >= 5 && Character.isUpperCase(methodName.charAt(4))) {
                                propertyName2 = decapitalize(methodName.substring(3));
                            }
                            boolean ignore = isJSONTypeIgnore(clazz, propertyName2);
                            if (!ignore) {
                                Field field = ParserConfig.getField(clazz, propertyName2);
                                if (field != null && (fieldAnnotation2 = (JSONField) field.getAnnotation(JSONField.class)) != null) {
                                    if (fieldAnnotation2.serialize()) {
                                        ordinal = fieldAnnotation2.ordinal();
                                        serialzeFeatures = SerializerFeature.of(fieldAnnotation2.serialzeFeatures());
                                        if (fieldAnnotation2.name().length() != 0) {
                                            propertyName2 = fieldAnnotation2.name();
                                            if (aliasMap == null || (propertyName2 = aliasMap.get(propertyName2)) != null) {
                                            }
                                        }
                                        if (fieldAnnotation2.label().length() != 0) {
                                            label = fieldAnnotation2.label();
                                        }
                                        if (aliasMap != null) {
                                        }
                                        fieldInfoMap.put(propertyName2, new FieldInfo(propertyName2, method, field, ordinal, serialzeFeatures, label));
                                        if (!methodName.startsWith("is")) {
                                        }
                                    }
                                } else if (aliasMap != null || (propertyName2 = aliasMap.get(propertyName2)) != null) {
                                    fieldInfoMap.put(propertyName2, new FieldInfo(propertyName2, method, field, ordinal, serialzeFeatures, label));
                                    if (!methodName.startsWith("is")) {
                                    }
                                }
                            }
                        }
                    } else if (!methodName.startsWith("is") && methodName.length() >= 3) {
                        char c2 = methodName.charAt(2);
                        if (Character.isUpperCase(c2)) {
                            if (compatibleWithJavaBean) {
                                propertyName = decapitalize(methodName.substring(2));
                            } else {
                                propertyName = String.valueOf(Character.toLowerCase(methodName.charAt(2))) + methodName.substring(3);
                            }
                        } else if (c2 == '_') {
                            propertyName = methodName.substring(3);
                        } else if (c2 == 'f') {
                            propertyName = methodName.substring(2);
                        }
                        Field field2 = ParserConfig.getField(clazz, propertyName);
                        if (field2 == null) {
                            field2 = ParserConfig.getField(clazz, methodName);
                        }
                        if (field2 != null && (fieldAnnotation = (JSONField) field2.getAnnotation(JSONField.class)) != null) {
                            if (fieldAnnotation.serialize()) {
                                ordinal = fieldAnnotation.ordinal();
                                serialzeFeatures = SerializerFeature.of(fieldAnnotation.serialzeFeatures());
                                if (fieldAnnotation.name().length() != 0) {
                                    propertyName = fieldAnnotation.name();
                                    if (aliasMap == null || (propertyName = aliasMap.get(propertyName)) != null) {
                                    }
                                }
                                if (fieldAnnotation.label().length() != 0) {
                                    label = fieldAnnotation.label();
                                }
                                if (aliasMap != null) {
                                    fieldInfoMap.put(propertyName, new FieldInfo(propertyName, method, field2, ordinal, serialzeFeatures, label));
                                } else {
                                    fieldInfoMap.put(propertyName, new FieldInfo(propertyName, method, field2, ordinal, serialzeFeatures, label));
                                }
                            }
                        } else if (aliasMap != null || (propertyName = aliasMap.get(propertyName)) != null) {
                            fieldInfoMap.put(propertyName, new FieldInfo(propertyName, method, field2, ordinal, serialzeFeatures, label));
                        }
                    }
                } else if (annotation.serialize()) {
                    ordinal = annotation.ordinal();
                    serialzeFeatures = SerializerFeature.of(annotation.serialzeFeatures());
                    if (annotation.name().length() != 0) {
                        String propertyName3 = annotation.name();
                        if (aliasMap == null || (propertyName3 = aliasMap.get(propertyName3)) != null) {
                            fieldInfoMap.put(propertyName3, new FieldInfo(propertyName3, method, null, ordinal, serialzeFeatures, annotation.label()));
                        }
                    } else {
                        if (annotation.label().length() == 0) {
                            label = null;
                        } else {
                            label = annotation.label();
                        }
                        if (!methodName.startsWith("get")) {
                            if (methodName.length() < 4) {
                            }
                        } else if (!methodName.startsWith("is")) {
                        }
                    }
                }
            }
        }
        for (Field field3 : clazz.getFields()) {
            if (!Modifier.isStatic(field3.getModifiers())) {
                JSONField fieldAnnotation3 = (JSONField) field3.getAnnotation(JSONField.class);
                int ordinal2 = 0;
                int serialzeFeatures2 = 0;
                String propertyName4 = field3.getName();
                String label2 = null;
                if (fieldAnnotation3 != null) {
                    if (fieldAnnotation3.serialize()) {
                        ordinal2 = fieldAnnotation3.ordinal();
                        serialzeFeatures2 = SerializerFeature.of(fieldAnnotation3.serialzeFeatures());
                        if (fieldAnnotation3.name().length() != 0) {
                            propertyName4 = fieldAnnotation3.name();
                        }
                        if (fieldAnnotation3.label().length() != 0) {
                            label2 = fieldAnnotation3.label();
                        }
                        if (aliasMap != null) {
                            fieldInfoMap.put(propertyName4, new FieldInfo(propertyName4, null, field3, ordinal2, serialzeFeatures2, label2));
                        } else {
                            fieldInfoMap.put(propertyName4, new FieldInfo(propertyName4, null, field3, ordinal2, serialzeFeatures2, label2));
                        }
                    }
                } else if ((aliasMap != null || (propertyName4 = aliasMap.get(propertyName4)) != null) && !fieldInfoMap.containsKey(propertyName4)) {
                    fieldInfoMap.put(propertyName4, new FieldInfo(propertyName4, null, field3, ordinal2, serialzeFeatures2, label2));
                }
            }
        }
        List<FieldInfo> fieldInfoList = new ArrayList<>();
        boolean containsAll = false;
        String[] orders = (String[]) null;
        JSONType annotation2 = (JSONType) clazz.getAnnotation(JSONType.class);
        if (annotation2 != null) {
            orders = annotation2.orders();
            if (orders != null && orders.length == fieldInfoMap.size()) {
                containsAll = true;
                for (String item : orders) {
                    if (!fieldInfoMap.containsKey(item)) {
                        containsAll = false;
                        break;
                    }
                }
            } else {
                containsAll = false;
            }
        }
        if (containsAll) {
            for (String item2 : orders) {
                FieldInfo fieldInfo = fieldInfoMap.get(item2);
                fieldInfoList.add(fieldInfo);
            }
        } else {
            for (FieldInfo fieldInfo2 : fieldInfoMap.values()) {
                fieldInfoList.add(fieldInfo2);
            }
            if (sorted) {
                Collections.sort(fieldInfoList);
            }
        }
        return fieldInfoList;
    }

    public static JSONField getSupperMethodAnnotation(Class<?> clazz, Method method) {
        JSONField annotation;
        for (Class<?> interfaceClass : clazz.getInterfaces()) {
            for (Method interfaceMethod : interfaceClass.getMethods()) {
                if (interfaceMethod.getName().equals(method.getName()) && interfaceMethod.getParameterTypes().length == method.getParameterTypes().length) {
                    boolean match = true;
                    for (int i = 0; i < interfaceMethod.getParameterTypes().length; i++) {
                        if (!interfaceMethod.getParameterTypes()[i].equals(method.getParameterTypes()[i])) {
                            match = false;
                            break;
                        }
                    }
                    if (match && (annotation = (JSONField) interfaceMethod.getAnnotation(JSONField.class)) != null) {
                        return annotation;
                    }
                }
            }
        }
        return null;
    }

    private static boolean isJSONTypeIgnore(Class<?> clazz, String propertyName) {
        JSONType jsonType = (JSONType) clazz.getAnnotation(JSONType.class);
        if (jsonType != null) {
            String[] fields = jsonType.includes();
            if (fields.length > 0) {
                for (String str : fields) {
                    if (propertyName.equals(str)) {
                        return false;
                    }
                }
                return true;
            }
            for (String str2 : jsonType.ignores()) {
                if (propertyName.equals(str2)) {
                    return true;
                }
            }
        }
        return (clazz.getSuperclass() == Object.class || clazz.getSuperclass() == null || !isJSONTypeIgnore(clazz.getSuperclass(), propertyName)) ? false : true;
    }

    public static boolean isGenericParamType(Type type) {
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (type instanceof Class) {
            return isGenericParamType(((Class) type).getGenericSuperclass());
        }
        return false;
    }

    public static Type getGenericParamType(Type type) {
        if (!(type instanceof ParameterizedType) && (type instanceof Class)) {
            return getGenericParamType(((Class) type).getGenericSuperclass());
        }
        return type;
    }

    public static Type unwrap(Type type) {
        if (type instanceof GenericArrayType) {
            Type componentType = ((GenericArrayType) type).getGenericComponentType();
            if (componentType == Byte.TYPE) {
                return byte[].class;
            }
            if (componentType == Character.TYPE) {
                return char[].class;
            }
            return type;
        }
        return type;
    }

    public static Class<?> getClass(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        return Object.class;
    }

    public static Field getField(Class<?> clazz, String fieldName) {
        for (Field field : clazz.getDeclaredFields()) {
            if (fieldName.equals(field.getName())) {
                return field;
            }
        }
        Class<?> superClass = clazz.getSuperclass();
        if (superClass != null && superClass != Object.class) {
            return getField(superClass, fieldName);
        }
        return null;
    }

    public static JSONType getJSONType(Class<?> clazz) {
        return (JSONType) clazz.getAnnotation(JSONType.class);
    }

    public static int getSerializeFeatures(Class<?> clazz) {
        JSONType annotation = (JSONType) clazz.getAnnotation(JSONType.class);
        if (annotation == null) {
            return 0;
        }
        return SerializerFeature.of(annotation.serialzeFeatures());
    }

    public static int getParserFeatures(Class<?> clazz) {
        JSONType annotation = (JSONType) clazz.getAnnotation(JSONType.class);
        if (annotation == null) {
            return 0;
        }
        return Feature.of(annotation.parseFeatures());
    }

    public static String decapitalize(String name) {
        if (name != null && name.length() != 0) {
            if (name.length() <= 1 || !Character.isUpperCase(name.charAt(1)) || !Character.isUpperCase(name.charAt(0))) {
                char[] chars = name.toCharArray();
                chars[0] = Character.toLowerCase(chars[0]);
                return new String(chars);
            }
            return name;
        }
        return name;
    }

    static void setAccessible(AccessibleObject obj) {
        if (setAccessibleEnable && !obj.isAccessible()) {
            try {
                obj.setAccessible(true);
            } catch (AccessControlException e) {
                setAccessibleEnable = false;
            }
        }
    }

    public static Class<?> getCollectionItemClass(Type fieldType) {
        if (fieldType instanceof ParameterizedType) {
            Type actualTypeArgument = ((ParameterizedType) fieldType).getActualTypeArguments()[0];
            if (actualTypeArgument instanceof Class) {
                Class<?> itemClass = (Class) actualTypeArgument;
                if (Modifier.isPublic(itemClass.getModifiers())) {
                    return itemClass;
                }
                throw new ASMException("can not create ASMParser");
            }
            throw new ASMException("can not create ASMParser");
        }
        return Object.class;
    }
}
