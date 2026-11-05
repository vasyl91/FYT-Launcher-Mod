package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.alibaba.fastjson.serializer.AfterFilter;
import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.LabelFilter;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.ThreadLocalCache;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public abstract class JSON implements JSONStreamAware, JSONAware {
    public static int DEFAULT_GENERATE_FEATURE = 0;
    public static int DEFAULT_PARSER_FEATURE = 0;
    public static String DEFFAULT_DATE_FORMAT = null;
    public static final String VERSION = "1.2.8";
    public static String DEFAULT_TYPE_KEY = "@type";
    public static String DUMP_CLASS = null;

    static {
        int features = 0 | Feature.AutoCloseSource.getMask();
        DEFAULT_PARSER_FEATURE = features | Feature.InternFieldNames.getMask() | Feature.UseBigDecimal.getMask() | Feature.AllowUnQuotedFieldNames.getMask() | Feature.AllowSingleQuotes.getMask() | Feature.AllowArbitraryCommas.getMask() | Feature.SortFeidFastMatch.getMask() | Feature.IgnoreNotMatch.getMask();
        DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        int features2 = 0 | SerializerFeature.QuoteFieldNames.getMask();
        DEFAULT_GENERATE_FEATURE = features2 | SerializerFeature.SkipTransientField.getMask() | SerializerFeature.WriteEnumUsingName.getMask() | SerializerFeature.SortField.getMask();
    }

    public static Object parse(String text) {
        return parse(text, DEFAULT_PARSER_FEATURE);
    }

    public static Object parse(String text, int features) {
        if (text == null) {
            return null;
        }
        DefaultJSONParser parser = new DefaultJSONParser(text, ParserConfig.getGlobalInstance(), features);
        Object value = parser.parse();
        parser.handleResovleTask(value);
        parser.close();
        return value;
    }

    public static Object parse(byte[] input, Feature... features) {
        return parse(input, 0, input.length, ThreadLocalCache.getUTF8Decoder(), features);
    }

    public static Object parse(byte[] input, int off, int len, CharsetDecoder charsetDecoder, Feature... features) {
        if (input == null || input.length == 0) {
            return null;
        }
        int featureValues = DEFAULT_PARSER_FEATURE;
        for (Feature feature : features) {
            featureValues = Feature.config(featureValues, feature, true);
        }
        return parse(input, off, len, charsetDecoder, featureValues);
    }

    public static Object parse(byte[] input, int off, int len, CharsetDecoder charsetDecoder, int features) {
        charsetDecoder.reset();
        int scaleLength = (int) (((double) len) * ((double) charsetDecoder.maxCharsPerByte()));
        char[] chars = ThreadLocalCache.getChars(scaleLength);
        ByteBuffer byteBuf = ByteBuffer.wrap(input, off, len);
        CharBuffer charBuf = CharBuffer.wrap(chars);
        IOUtils.decode(charsetDecoder, byteBuf, charBuf);
        int position = charBuf.position();
        DefaultJSONParser parser = new DefaultJSONParser(chars, position, ParserConfig.getGlobalInstance(), features);
        Object value = parser.parse();
        parser.handleResovleTask(value);
        parser.close();
        return value;
    }

    public static Object parse(String text, Feature... features) {
        int featureValues = DEFAULT_PARSER_FEATURE;
        for (Feature feature : features) {
            featureValues = Feature.config(featureValues, feature, true);
        }
        return parse(text, featureValues);
    }

    public static JSONObject parseObject(String text, Feature... features) {
        return (JSONObject) parse(text, features);
    }

    public static JSONObject parseObject(String text) {
        Object obj = parse(text);
        return obj instanceof JSONObject ? (JSONObject) obj : (JSONObject) toJSON(obj);
    }

    public static <T> T parseObject(String str, TypeReference<T> typeReference, Feature... featureArr) {
        return (T) parseObject(str, typeReference.getType(), ParserConfig.getGlobalInstance(), DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(String str, Class<T> cls, Feature... featureArr) {
        return (T) parseObject(str, cls, ParserConfig.getGlobalInstance(), DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(String str, Class<T> cls, ParseProcess parseProcess, Feature... featureArr) {
        return (T) parseObject(str, cls, ParserConfig.getGlobalInstance(), parseProcess, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(String str, Type type, Feature... featureArr) {
        return (T) parseObject(str, type, ParserConfig.getGlobalInstance(), DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(String str, Type type, ParseProcess parseProcess, Feature... featureArr) {
        return (T) parseObject(str, type, ParserConfig.getGlobalInstance(), DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(String str, Type type, int i, Feature... featureArr) {
        if (str == null) {
            return null;
        }
        for (Feature feature : featureArr) {
            i = Feature.config(i, feature, true);
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, ParserConfig.getGlobalInstance(), i);
        T t = (T) defaultJSONParser.parseObject(type);
        defaultJSONParser.handleResovleTask(t);
        defaultJSONParser.close();
        return t;
    }

    public static <T> T parseObject(String str, Type type, ParserConfig parserConfig, int i, Feature... featureArr) {
        return (T) parseObject(str, type, parserConfig, (ParseProcess) null, i, featureArr);
    }

    public static <T> T parseObject(String str, Type type, ParserConfig parserConfig, ParseProcess parseProcess, int i, Feature... featureArr) {
        if (str == null) {
            return null;
        }
        for (Feature feature : featureArr) {
            i = Feature.config(i, feature, true);
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig, i);
        if (parseProcess instanceof ExtraTypeProvider) {
            defaultJSONParser.getExtraTypeProviders().add((ExtraTypeProvider) parseProcess);
        }
        if (parseProcess instanceof ExtraProcessor) {
            defaultJSONParser.getExtraProcessors().add((ExtraProcessor) parseProcess);
        }
        T t = (T) defaultJSONParser.parseObject(type);
        defaultJSONParser.handleResovleTask(t);
        defaultJSONParser.close();
        return t;
    }

    public static <T> T parseObject(byte[] bArr, Type type, Feature... featureArr) {
        return (T) parseObject(bArr, 0, bArr.length, ThreadLocalCache.getUTF8Decoder(), type, featureArr);
    }

    public static <T> T parseObject(byte[] bArr, int i, int i2, CharsetDecoder charsetDecoder, Type type, Feature... featureArr) {
        charsetDecoder.reset();
        char[] chars = ThreadLocalCache.getChars((int) (((double) i2) * ((double) charsetDecoder.maxCharsPerByte())));
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, i2);
        CharBuffer charBufferWrap = CharBuffer.wrap(chars);
        IOUtils.decode(charsetDecoder, byteBufferWrap, charBufferWrap);
        return (T) parseObject(chars, charBufferWrap.position(), type, featureArr);
    }

    public static <T> T parseObject(char[] cArr, int i, Type type, Feature... featureArr) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        int iConfig = DEFAULT_PARSER_FEATURE;
        for (Feature feature : featureArr) {
            iConfig = Feature.config(iConfig, feature, true);
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(cArr, i, ParserConfig.getGlobalInstance(), iConfig);
        T t = (T) defaultJSONParser.parseObject(type);
        defaultJSONParser.handleResovleTask(t);
        defaultJSONParser.close();
        return t;
    }

    public static <T> T parseObject(String str, Class<T> cls) {
        return (T) parseObject(str, (Class) cls, new Feature[0]);
    }

    public static JSONArray parseArray(String text) {
        JSONArray array;
        if (text == null) {
            return null;
        }
        DefaultJSONParser parser = new DefaultJSONParser(text, ParserConfig.getGlobalInstance());
        JSONLexer lexer = parser.getLexer();
        if (lexer.token() == 8) {
            lexer.nextToken();
            array = null;
        } else if (lexer.token() == 20) {
            array = null;
        } else {
            array = new JSONArray();
            parser.parseArray(array);
            parser.handleResovleTask(array);
        }
        parser.close();
        return array;
    }

    public static <T> List<T> parseArray(String text, Class<T> clazz) {
        List<T> list;
        if (text == null) {
            return null;
        }
        DefaultJSONParser parser = new DefaultJSONParser(text, ParserConfig.getGlobalInstance());
        JSONLexer lexer = parser.getLexer();
        if (lexer.token() == 8) {
            lexer.nextToken();
            list = null;
        } else {
            list = new ArrayList<>();
            parser.parseArray((Class<?>) clazz, (Collection) list);
            parser.handleResovleTask(list);
        }
        parser.close();
        return list;
    }

    public static List<Object> parseArray(String text, Type[] types) {
        List<Object> list;
        if (text == null) {
            return null;
        }
        DefaultJSONParser parser = new DefaultJSONParser(text, ParserConfig.getGlobalInstance());
        Object[] objectArray = parser.parseArray(types);
        if (objectArray == null) {
            list = null;
        } else {
            list = Arrays.asList(objectArray);
        }
        parser.handleResovleTask(list);
        parser.close();
        return list;
    }

    public static String toJSONString(Object object) {
        return toJSONString(object, new SerializerFeature[0]);
    }

    public static String toJSONString(Object object, SerializerFeature... features) {
        SerializeWriter out = new SerializeWriter();
        try {
            JSONSerializer serializer = new JSONSerializer(out);
            for (SerializerFeature feature : features) {
                serializer.config(feature, true);
            }
            serializer.write(object);
            return out.toString();
        } finally {
            out.close();
        }
    }

    public static String toJSONStringWithDateFormat(Object object, String dateFormat, SerializerFeature... features) {
        SerializeWriter out = new SerializeWriter();
        try {
            JSONSerializer serializer = new JSONSerializer(out);
            for (SerializerFeature feature : features) {
                serializer.config(feature, true);
            }
            serializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            if (dateFormat != null) {
                serializer.setDateFormat(dateFormat);
            }
            serializer.write(object);
            return out.toString();
        } finally {
            out.close();
        }
    }

    public static String toJSONString(Object object, SerializeFilter filter, SerializerFeature... features) {
        SerializeWriter out = new SerializeWriter();
        try {
            JSONSerializer serializer = new JSONSerializer(out);
            for (SerializerFeature feature : features) {
                serializer.config(feature, true);
            }
            serializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            setFilter(serializer, filter);
            serializer.write(object);
            return out.toString();
        } finally {
            out.close();
        }
    }

    public static String toJSONString(Object object, SerializeFilter[] filters, SerializerFeature... features) {
        SerializeWriter out = new SerializeWriter();
        try {
            JSONSerializer serializer = new JSONSerializer(out);
            for (SerializerFeature feature : features) {
                serializer.config(feature, true);
            }
            serializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            setFilter(serializer, filters);
            serializer.write(object);
            return out.toString();
        } finally {
            out.close();
        }
    }

    public static byte[] toJSONBytes(Object object, SerializerFeature... features) {
        SerializeWriter out = new SerializeWriter();
        try {
            JSONSerializer serializer = new JSONSerializer(out);
            for (SerializerFeature feature : features) {
                serializer.config(feature, true);
            }
            serializer.write(object);
            return out.toBytes(HTTP.UTF_8);
        } finally {
            out.close();
        }
    }

    public static String toJSONString(Object object, SerializeConfig config, SerializerFeature... features) {
        return toJSONString(object, config, (SerializeFilter) null, features);
    }

    public static String toJSONString(Object object, SerializeConfig config, SerializeFilter filter, SerializerFeature... features) {
        SerializeWriter out = new SerializeWriter();
        try {
            JSONSerializer serializer = new JSONSerializer(out, config);
            for (SerializerFeature feature : features) {
                serializer.config(feature, true);
            }
            setFilter(serializer, filter);
            serializer.write(object);
            return out.toString();
        } finally {
            out.close();
        }
    }

    public static String toJSONString(Object object, SerializeConfig config, SerializeFilter[] filters, SerializerFeature... features) {
        SerializeWriter out = new SerializeWriter();
        try {
            JSONSerializer serializer = new JSONSerializer(out, config);
            for (SerializerFeature feature : features) {
                serializer.config(feature, true);
            }
            setFilter(serializer, filters);
            serializer.write(object);
            return out.toString();
        } finally {
            out.close();
        }
    }

    public static String toJSONStringZ(Object object, SerializeConfig mapping, SerializerFeature... features) {
        SerializeWriter out = new SerializeWriter(features);
        try {
            JSONSerializer serializer = new JSONSerializer(out, mapping);
            serializer.write(object);
            return out.toString();
        } finally {
            out.close();
        }
    }

    public static byte[] toJSONBytes(Object object, SerializeConfig config, SerializerFeature... features) {
        SerializeWriter out = new SerializeWriter();
        try {
            JSONSerializer serializer = new JSONSerializer(out, config);
            for (SerializerFeature feature : features) {
                serializer.config(feature, true);
            }
            serializer.write(object);
            return out.toBytes(HTTP.UTF_8);
        } finally {
            out.close();
        }
    }

    public static String toJSONString(Object object, boolean prettyFormat) {
        return !prettyFormat ? toJSONString(object) : toJSONString(object, SerializerFeature.PrettyFormat);
    }

    public static void writeJSONStringTo(Object object, Writer writer, SerializerFeature... features) {
        SerializeWriter out = new SerializeWriter(writer);
        try {
            JSONSerializer serializer = new JSONSerializer(out);
            for (SerializerFeature feature : features) {
                serializer.config(feature, true);
            }
            serializer.write(object);
        } finally {
            out.close();
        }
    }

    public String toString() {
        return toJSONString();
    }

    @Override // com.alibaba.fastjson.JSONAware
    public String toJSONString() {
        SerializeWriter out = new SerializeWriter();
        try {
            new JSONSerializer(out).write(this);
            return out.toString();
        } finally {
            out.close();
        }
    }

    @Override // com.alibaba.fastjson.JSONStreamAware
    public void writeJSONString(Appendable appendable) {
        SerializeWriter out = new SerializeWriter();
        try {
            try {
                new JSONSerializer(out).write(this);
                appendable.append(out.toString());
                out.close();
            } catch (IOException e) {
                throw new JSONException(e.getMessage(), e);
            }
        } catch (Throwable th) {
            out.close();
            throw th;
        }
    }

    public static Object toJSON(Object javaObject) {
        return toJSON(javaObject, ParserConfig.getGlobalInstance());
    }

    public static Object toJSON(Object javaObject, ParserConfig mapping) {
        if (javaObject == null) {
            return null;
        }
        if (!(javaObject instanceof JSON)) {
            if (javaObject instanceof Map) {
                Map<Object, Object> map = (Map) javaObject;
                JSONObject json = new JSONObject(map.size());
                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    Object key = entry.getKey();
                    String jsonKey = TypeUtils.castToString(key);
                    Object jsonValue = toJSON(entry.getValue());
                    json.put(jsonKey, jsonValue);
                }
                return json;
            }
            if (javaObject instanceof Collection) {
                Collection<Object> collection = (Collection) javaObject;
                JSONArray array = new JSONArray(collection.size());
                for (Object item : collection) {
                    Object jsonValue2 = toJSON(item);
                    array.add(jsonValue2);
                }
                return array;
            }
            Class<?> clazz = javaObject.getClass();
            if (clazz.isEnum()) {
                return ((Enum) javaObject).name();
            }
            if (clazz.isArray()) {
                int len = Array.getLength(javaObject);
                JSONArray array2 = new JSONArray(len);
                for (int i = 0; i < len; i++) {
                    Object item2 = Array.get(javaObject, i);
                    Object jsonValue3 = toJSON(item2);
                    array2.add(jsonValue3);
                }
                return array2;
            }
            if (!mapping.isPrimitive(clazz)) {
                try {
                    List<FieldInfo> getters = TypeUtils.computeGetters(clazz, null);
                    JSONObject json2 = new JSONObject(getters.size());
                    for (FieldInfo field : getters) {
                        Object value = field.get(javaObject);
                        Object jsonValue4 = toJSON(value);
                        json2.put(field.getName(), jsonValue4);
                    }
                    return json2;
                } catch (IllegalAccessException e) {
                    throw new JSONException("toJSON error", e);
                } catch (InvocationTargetException e2) {
                    throw new JSONException("toJSON error", e2);
                }
            }
            return javaObject;
        }
        return javaObject;
    }

    public static <T> T toJavaObject(JSON json, Class<T> cls) {
        return (T) TypeUtils.cast((Object) json, (Class) cls, ParserConfig.getGlobalInstance());
    }

    private static void setFilter(JSONSerializer serializer, SerializeFilter... filters) {
        for (SerializeFilter filter : filters) {
            setFilter(serializer, filter);
        }
    }

    private static void setFilter(JSONSerializer serializer, SerializeFilter filter) {
        if (filter != null) {
            if (filter instanceof PropertyPreFilter) {
                serializer.getPropertyPreFilters().add((PropertyPreFilter) filter);
            }
            if (filter instanceof NameFilter) {
                serializer.getNameFilters().add((NameFilter) filter);
            }
            if (filter instanceof ValueFilter) {
                serializer.getValueFilters().add((ValueFilter) filter);
            }
            if (filter instanceof PropertyFilter) {
                serializer.getPropertyFilters().add((PropertyFilter) filter);
            }
            if (filter instanceof BeforeFilter) {
                serializer.getBeforeFilters().add((BeforeFilter) filter);
            }
            if (filter instanceof AfterFilter) {
                serializer.getAfterFilters().add((AfterFilter) filter);
            }
            if (filter instanceof LabelFilter) {
                serializer.getLabelFilters().add((LabelFilter) filter);
            }
        }
    }
}
