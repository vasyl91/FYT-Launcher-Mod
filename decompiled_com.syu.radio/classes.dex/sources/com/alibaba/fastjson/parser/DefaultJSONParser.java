package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ASMJavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.CollectionResolveFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ListResolveFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.MapResolveFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class DefaultJSONParser extends AbstractJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    private static final Set<Class<?>> primitiveClasses = new HashSet();
    protected ParserConfig config;
    protected ParseContext context;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private List<ExtraProcessor> extraProcessors;
    private List<ExtraTypeProvider> extraTypeProviders;
    protected final Object input;
    protected final JSONLexer lexer;
    private int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    protected final SymbolTable symbolTable;

    static {
        primitiveClasses.add(Boolean.TYPE);
        primitiveClasses.add(Byte.TYPE);
        primitiveClasses.add(Short.TYPE);
        primitiveClasses.add(Integer.TYPE);
        primitiveClasses.add(Long.TYPE);
        primitiveClasses.add(Float.TYPE);
        primitiveClasses.add(Double.TYPE);
        primitiveClasses.add(Boolean.class);
        primitiveClasses.add(Byte.class);
        primitiveClasses.add(Short.class);
        primitiveClasses.add(Integer.class);
        primitiveClasses.add(Long.class);
        primitiveClasses.add(Float.class);
        primitiveClasses.add(Double.class);
        primitiveClasses.add(BigInteger.class);
        primitiveClasses.add(BigDecimal.class);
        primitiveClasses.add(String.class);
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            this.dateFormat = new SimpleDateFormat(this.dateFormatPattern);
        }
        return this.dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormatPattern = dateFormat;
        this.dateFormat = null;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public DefaultJSONParser(String input) {
        this(input, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    public DefaultJSONParser(String input, ParserConfig config) {
        this(input, new JSONScanner(input, JSON.DEFAULT_PARSER_FEATURE), config);
    }

    public DefaultJSONParser(String input, ParserConfig config, int features) {
        this(input, new JSONScanner(input, features), config);
    }

    public DefaultJSONParser(char[] input, int length, ParserConfig config, int features) {
        this(input, new JSONScanner(input, length, features), config);
    }

    public DefaultJSONParser(JSONLexer lexer) {
        this(lexer, ParserConfig.getGlobalInstance());
    }

    public DefaultJSONParser(JSONLexer lexer, ParserConfig config) {
        this((Object) null, lexer, config);
    }

    public DefaultJSONParser(Object input, JSONLexer lexer, ParserConfig config) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArray = new ParseContext[8];
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.lexer = lexer;
        this.input = input;
        this.config = config;
        this.symbolTable = config.getSymbolTable();
        lexer.nextToken(12);
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public String getInput() {
        return this.input instanceof char[] ? new String((char[]) this.input) : this.input.toString();
    }

    public final Object parseObject(Map object, Object fieldName) {
        Object key;
        Object time;
        JSONLexer lexer = this.lexer;
        if (lexer.token() == 8) {
            lexer.next();
            return null;
        }
        if (lexer.token() != 12 && lexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + lexer.tokenName());
        }
        ParseContext context = getContext();
        boolean setContextFlag = false;
        while (true) {
            try {
                lexer.skipWhitespace();
                char ch = lexer.getCurrent();
                if (isEnabled(Feature.AllowArbitraryCommas)) {
                    while (ch == ',') {
                        lexer.next();
                        lexer.skipWhitespace();
                        ch = lexer.getCurrent();
                    }
                }
                boolean isObjectKey = false;
                if (ch == '\"') {
                    key = lexer.scanSymbol(this.symbolTable, '\"');
                    lexer.skipWhitespace();
                    if (lexer.getCurrent() != ':') {
                        throw new JSONException("expect ':' at " + lexer.pos() + ", name " + key);
                    }
                } else {
                    if (ch == '}') {
                        lexer.next();
                        lexer.resetStringPosition();
                        lexer.nextToken();
                        setContext(context);
                        return object;
                    }
                    if (ch == '\'') {
                        if (!isEnabled(Feature.AllowSingleQuotes)) {
                            throw new JSONException("syntax error");
                        }
                        key = lexer.scanSymbol(this.symbolTable, '\'');
                        lexer.skipWhitespace();
                        if (lexer.getCurrent() != ':') {
                            throw new JSONException("expect ':' at " + lexer.pos());
                        }
                    } else {
                        if (ch == 26) {
                            throw new JSONException("syntax error");
                        }
                        if (ch == ',') {
                            throw new JSONException("syntax error");
                        }
                        if ((ch >= '0' && ch <= '9') || ch == '-') {
                            lexer.resetStringPosition();
                            lexer.scanNumber();
                            key = lexer.token() == 2 ? lexer.integerValue() : lexer.decimalValue(true);
                            if (lexer.getCurrent() != ':') {
                                throw new JSONException("expect ':' at " + lexer.pos() + ", name " + key);
                            }
                        } else if (ch == '{' || ch == '[') {
                            lexer.nextToken();
                            key = parse();
                            isObjectKey = true;
                        } else {
                            if (!isEnabled(Feature.AllowUnQuotedFieldNames)) {
                                throw new JSONException("syntax error");
                            }
                            key = lexer.scanSymbolUnQuoted(this.symbolTable);
                            lexer.skipWhitespace();
                            char ch2 = lexer.getCurrent();
                            if (ch2 != ':') {
                                throw new JSONException("expect ':' at " + lexer.pos() + ", actual " + ch2);
                            }
                        }
                    }
                }
                if (!isObjectKey) {
                    lexer.next();
                    lexer.skipWhitespace();
                }
                char ch3 = lexer.getCurrent();
                lexer.resetStringPosition();
                if (key == JSON.DEFAULT_TYPE_KEY && !isEnabled(Feature.DisableSpecialKeyDetect)) {
                    String typeName = lexer.scanSymbol(this.symbolTable, '\"');
                    Class<?> clazz = TypeUtils.loadClass(typeName);
                    if (clazz != null) {
                        lexer.nextToken(16);
                        if (lexer.token() != 13) {
                            setResolveStatus(2);
                            if (this.context != null && !(fieldName instanceof Integer)) {
                                popContext();
                            }
                            Object objDeserialze = this.config.getDeserializer(clazz).deserialze(this, clazz, fieldName);
                            setContext(context);
                            return objDeserialze;
                        }
                        lexer.nextToken(16);
                        Object instance = null;
                        try {
                            ObjectDeserializer deserializer = this.config.getDeserializer(clazz);
                            if (deserializer instanceof ASMJavaBeanDeserializer) {
                                instance = ((ASMJavaBeanDeserializer) deserializer).createInstance(this, clazz);
                            } else if (deserializer instanceof JavaBeanDeserializer) {
                                instance = ((JavaBeanDeserializer) deserializer).createInstance(this, clazz);
                            }
                            if (instance == null) {
                                instance = clazz == Cloneable.class ? new HashMap() : clazz.newInstance();
                            }
                            setContext(context);
                            return instance;
                        } catch (Exception e) {
                            throw new JSONException("create instance error", e);
                        }
                    }
                    object.put(JSON.DEFAULT_TYPE_KEY, typeName);
                } else {
                    if (key == "$ref" && !isEnabled(Feature.DisableSpecialKeyDetect)) {
                        lexer.nextToken(4);
                        if (lexer.token() != 4) {
                            throw new JSONException("illegal ref, " + JSONToken.name(lexer.token()));
                        }
                        String ref = lexer.stringVal();
                        lexer.nextToken(13);
                        Object refValue = null;
                        if ("@".equals(ref)) {
                            if (getContext() != null) {
                                ParseContext thisContext = getContext();
                                Object thisObj = thisContext.getObject();
                                if ((thisObj instanceof Object[]) || (thisObj instanceof Collection)) {
                                    refValue = thisObj;
                                } else if (thisContext.getParentContext() != null) {
                                    refValue = thisContext.getParentContext().getObject();
                                }
                            }
                        } else if ("..".equals(ref)) {
                            ParseContext parentContext = context.getParentContext();
                            if (parentContext.getObject() != null) {
                                refValue = parentContext.getObject();
                            } else {
                                addResolveTask(new ResolveTask(parentContext, ref));
                                setResolveStatus(1);
                            }
                        } else if ("$".equals(ref)) {
                            ParseContext rootContext = context;
                            while (rootContext.getParentContext() != null) {
                                rootContext = rootContext.getParentContext();
                            }
                            if (rootContext.getObject() != null) {
                                refValue = rootContext.getObject();
                            } else {
                                addResolveTask(new ResolveTask(rootContext, ref));
                                setResolveStatus(1);
                            }
                        } else {
                            addResolveTask(new ResolveTask(context, ref));
                            setResolveStatus(1);
                        }
                        if (lexer.token() != 13) {
                            throw new JSONException("syntax error");
                        }
                        lexer.nextToken(16);
                        setContext(context);
                        return refValue;
                    }
                    if (!setContextFlag) {
                        setContext(object, fieldName);
                        setContextFlag = true;
                    }
                    if (object.getClass() == JSONObject.class) {
                        key = key == null ? "null" : key.toString();
                    }
                    if (ch3 == '\"') {
                        lexer.scanString();
                        String strValue = lexer.stringVal();
                        time = strValue;
                        if (lexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                            JSONScanner iso8601Lexer = new JSONScanner(strValue);
                            if (iso8601Lexer.scanISO8601DateIfMatch()) {
                                time = iso8601Lexer.getCalendar().getTime();
                            }
                            iso8601Lexer.close();
                        }
                        object.put(key, time);
                    } else if ((ch3 >= '0' && ch3 <= '9') || ch3 == '-') {
                        lexer.scanNumber();
                        time = lexer.token() == 2 ? lexer.integerValue() : lexer.decimalValue(isEnabled(Feature.UseBigDecimal));
                        object.put(key, time);
                    } else if (ch3 == '[') {
                        lexer.nextToken();
                        JSONArray list = new JSONArray();
                        parseArray(list, key);
                        object.put(key, list);
                        if (lexer.token() == 13) {
                            lexer.nextToken();
                            setContext(context);
                            return object;
                        }
                        if (lexer.token() != 16) {
                            throw new JSONException("syntax error");
                        }
                    } else if (ch3 == '{') {
                        lexer.nextToken();
                        boolean parentIsArray = fieldName != null && fieldName.getClass() == Integer.class;
                        Map input = new JSONObject(isEnabled(Feature.OrderedField));
                        ParseContext ctxLocal = parentIsArray ? null : setContext(context, input, key);
                        Object obj = parseObject(input, key);
                        if (ctxLocal != null && input != obj) {
                            ctxLocal.setObject(object);
                        }
                        checkMapResolve(object, key.toString());
                        if (object.getClass() == JSONObject.class) {
                            object.put(key.toString(), obj);
                        } else {
                            object.put(key, obj);
                        }
                        if (parentIsArray) {
                            setContext(obj, key);
                        }
                        if (lexer.token() == 13) {
                            lexer.nextToken();
                            setContext(context);
                            setContext(context);
                            return object;
                        }
                        if (lexer.token() != 16) {
                            throw new JSONException("syntax error, " + lexer.tokenName());
                        }
                        if (parentIsArray) {
                            popContext();
                        }
                    } else {
                        lexer.nextToken();
                        Object value = parse();
                        if (object.getClass() == JSONObject.class) {
                            key = key.toString();
                        }
                        object.put(key, value);
                        if (lexer.token() == 13) {
                            lexer.nextToken();
                            setContext(context);
                            return object;
                        }
                        if (lexer.token() != 16) {
                            throw new JSONException("syntax error, position at " + lexer.pos() + ", name " + key);
                        }
                    }
                    lexer.skipWhitespace();
                    char ch4 = lexer.getCurrent();
                    if (ch4 != ',') {
                        if (ch4 != '}') {
                            throw new JSONException("syntax error, position at " + lexer.pos() + ", name " + key);
                        }
                        lexer.next();
                        lexer.resetStringPosition();
                        lexer.nextToken();
                        setContext(time, key);
                        setContext(context);
                        return object;
                    }
                    lexer.next();
                }
            } catch (Throwable th) {
                setContext(context);
                throw th;
            }
        }
    }

    public ParserConfig getConfig() {
        return this.config;
    }

    public void setConfig(ParserConfig config) {
        this.config = config;
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject((Type) cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T parseObject(Type type) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        if (this.lexer.token() == 4) {
            type = TypeUtils.unwrap(type);
            if (type == byte[].class) {
                T t = (T) this.lexer.bytesValue();
                this.lexer.nextToken();
                return t;
            }
            if (type == char[].class) {
                String strStringVal = this.lexer.stringVal();
                this.lexer.nextToken();
                return (T) strStringVal.toCharArray();
            }
        }
        try {
            return (T) this.config.getDeserializer(type).deserialze(this, type, null);
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public <T> List<T> parseArray(Class<T> clazz) {
        List<T> array = new ArrayList<>();
        parseArray((Class<?>) clazz, (Collection) array);
        return array;
    }

    public void parseArray(Class<?> clazz, Collection array) {
        parseArray((Type) clazz, array);
    }

    public void parseArray(Type type, Collection array) {
        parseArray(type, array, null);
    }

    public void parseArray(Type type, Collection array, Object fieldName) {
        ObjectDeserializer deserializer;
        Object objDeserialze;
        String value;
        if (this.lexer.token() == 21 || this.lexer.token() == 22) {
            this.lexer.nextToken();
        }
        if (this.lexer.token() != 14) {
            throw new JSONException("exepct '[', but " + JSONToken.name(this.lexer.token()));
        }
        if (Integer.TYPE == type) {
            deserializer = IntegerCodec.instance;
            this.lexer.nextToken(2);
        } else if (String.class == type) {
            deserializer = StringCodec.instance;
            this.lexer.nextToken(4);
        } else {
            deserializer = this.config.getDeserializer(type);
            this.lexer.nextToken(deserializer.getFastMatchToken());
        }
        ParseContext context = getContext();
        setContext(array, fieldName);
        int i = 0;
        while (true) {
            try {
                if (isEnabled(Feature.AllowArbitraryCommas)) {
                    while (this.lexer.token() == 16) {
                        this.lexer.nextToken();
                    }
                }
                if (this.lexer.token() != 15) {
                    if (Integer.TYPE == type) {
                        Object val = IntegerCodec.instance.deserialze(this, null, null);
                        array.add(val);
                    } else if (String.class == type) {
                        if (this.lexer.token() == 4) {
                            value = this.lexer.stringVal();
                            this.lexer.nextToken(16);
                        } else {
                            Object obj = parse();
                            if (obj == null) {
                                value = null;
                            } else {
                                value = obj.toString();
                            }
                        }
                        array.add(value);
                    } else {
                        if (this.lexer.token() == 8) {
                            this.lexer.nextToken();
                            objDeserialze = null;
                        } else {
                            objDeserialze = deserializer.deserialze(this, type, Integer.valueOf(i));
                        }
                        array.add(objDeserialze);
                        checkListResolve(array);
                    }
                    if (this.lexer.token() == 16) {
                        this.lexer.nextToken(deserializer.getFastMatchToken());
                    }
                    i++;
                } else {
                    setContext(context);
                    this.lexer.nextToken(16);
                    return;
                }
            } catch (Throwable th) {
                setContext(context);
                throw th;
            }
        }
    }

    public Object[] parseArray(Type[] types) {
        Object value;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        }
        if (this.lexer.token() != 14) {
            throw new JSONException("syntax error : " + this.lexer.tokenName());
        }
        Object[] list = new Object[types.length];
        if (types.length == 0) {
            this.lexer.nextToken(15);
            if (this.lexer.token() != 15) {
                throw new JSONException("syntax error");
            }
            this.lexer.nextToken(16);
            return new Object[0];
        }
        this.lexer.nextToken(2);
        for (int i = 0; i < types.length; i++) {
            if (this.lexer.token() == 8) {
                value = null;
                this.lexer.nextToken(16);
            } else {
                Type type = types[i];
                if (type == Integer.TYPE || type == Integer.class) {
                    if (this.lexer.token() == 2) {
                        value = Integer.valueOf(this.lexer.intValue());
                        this.lexer.nextToken(16);
                    } else {
                        Object value2 = parse();
                        value = TypeUtils.cast(value2, type, this.config);
                    }
                } else if (type == String.class) {
                    if (this.lexer.token() == 4) {
                        value = this.lexer.stringVal();
                        this.lexer.nextToken(16);
                    } else {
                        Object value3 = parse();
                        value = TypeUtils.cast(value3, type, this.config);
                    }
                } else {
                    boolean isArray = false;
                    Class<?> componentType = null;
                    if (i == types.length - 1 && (type instanceof Class)) {
                        Class<?> clazz = (Class) type;
                        isArray = clazz.isArray();
                        componentType = clazz.getComponentType();
                    }
                    if (isArray && this.lexer.token() != 14) {
                        List<Object> varList = new ArrayList<>();
                        ObjectDeserializer derializer = this.config.getDeserializer(componentType);
                        int fastMatch = derializer.getFastMatchToken();
                        if (this.lexer.token() != 15) {
                            while (true) {
                                Object item = derializer.deserialze(this, type, null);
                                varList.add(item);
                                if (this.lexer.token() != 16) {
                                    break;
                                }
                                this.lexer.nextToken(fastMatch);
                            }
                            if (this.lexer.token() != 15) {
                                throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                            }
                        }
                        value = TypeUtils.cast(varList, type, this.config);
                    } else {
                        value = this.config.getDeserializer(type).deserialze(this, type, null);
                    }
                }
            }
            list[i] = value;
            if (this.lexer.token() == 15) {
                break;
            }
            if (this.lexer.token() != 16) {
                throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
            }
            if (i == types.length - 1) {
                this.lexer.nextToken(15);
            } else {
                this.lexer.nextToken(2);
            }
        }
        if (this.lexer.token() != 15) {
            throw new JSONException("syntax error");
        }
        this.lexer.nextToken(16);
        return list;
    }

    public void parseObject(Object object) {
        Object fieldValue;
        Class<?> clazz = object.getClass();
        Map<String, FieldDeserializer> setters = this.config.getFieldDeserializers(clazz);
        if (this.lexer.token() != 12 && this.lexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
        }
        while (true) {
            String key = this.lexer.scanSymbol(this.symbolTable);
            if (key == null) {
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                } else if (this.lexer.token() != 16 || !isEnabled(Feature.AllowArbitraryCommas)) {
                }
            }
            FieldDeserializer fieldDeser = setters.get(key);
            if (fieldDeser == null && key != null) {
                for (Map.Entry<String, FieldDeserializer> entry : setters.entrySet()) {
                    if (key.equalsIgnoreCase(entry.getKey())) {
                        fieldDeser = entry.getValue();
                        break;
                    }
                }
            }
            if (fieldDeser == null) {
                if (!isEnabled(Feature.IgnoreNotMatch)) {
                    throw new JSONException("setter not found, class " + clazz.getName() + ", property " + key);
                }
                this.lexer.nextTokenWithColon();
                parse();
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken();
                    return;
                }
            } else {
                Class<?> fieldClass = fieldDeser.getFieldClass();
                Type fieldType = fieldDeser.getFieldType();
                if (fieldClass == Integer.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    fieldValue = IntegerCodec.instance.deserialze(this, fieldType, null);
                } else if (fieldClass == String.class) {
                    this.lexer.nextTokenWithColon(4);
                    fieldValue = StringCodec.deserialze(this);
                } else if (fieldClass == Long.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    fieldValue = LongCodec.instance.deserialze(this, fieldType, null);
                } else {
                    ObjectDeserializer fieldValueDeserializer = this.config.getDeserializer(fieldClass, fieldType);
                    this.lexer.nextTokenWithColon(fieldValueDeserializer.getFastMatchToken());
                    fieldValue = fieldValueDeserializer.deserialze(this, fieldType, null);
                }
                fieldDeser.setValue(object, fieldValue);
                if (this.lexer.token() != 16 && this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                }
            }
        }
    }

    public Object parseArrayWithType(Type collectionType) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        Type[] actualTypes = ((ParameterizedType) collectionType).getActualTypeArguments();
        if (actualTypes.length != 1) {
            throw new JSONException("not support type " + collectionType);
        }
        Type actualTypeArgument = actualTypes[0];
        if (actualTypeArgument instanceof Class) {
            List<Object> array = new ArrayList<>();
            parseArray((Class<?>) actualTypeArgument, (Collection) array);
            return array;
        }
        if (actualTypeArgument instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) actualTypeArgument;
            Type upperBoundType = wildcardType.getUpperBounds()[0];
            if (Object.class.equals(upperBoundType)) {
                if (wildcardType.getLowerBounds().length == 0) {
                    return parse();
                }
                throw new JSONException("not support type : " + collectionType);
            }
            List<Object> array2 = new ArrayList<>();
            parseArray((Class<?>) upperBoundType, (Collection) array2);
            return array2;
        }
        if (actualTypeArgument instanceof TypeVariable) {
            TypeVariable<?> typeVariable = (TypeVariable) actualTypeArgument;
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length != 1) {
                throw new JSONException("not support : " + typeVariable);
            }
            Type boundType = bounds[0];
            if (boundType instanceof Class) {
                List<Object> array3 = new ArrayList<>();
                parseArray((Class<?>) boundType, (Collection) array3);
                return array3;
            }
        }
        if (actualTypeArgument instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) actualTypeArgument;
            List<Object> array4 = new ArrayList<>();
            parseArray(parameterizedType, array4);
            return array4;
        }
        throw new JSONException("TODO : " + collectionType);
    }

    public void acceptType(String typeName) {
        JSONLexer lexer = this.lexer;
        lexer.nextTokenWithColon();
        if (lexer.token() != 4) {
            throw new JSONException("type not match error");
        }
        if (typeName.equals(lexer.stringVal())) {
            lexer.nextToken();
            if (lexer.token() == 16) {
                lexer.nextToken();
                return;
            }
            return;
        }
        throw new JSONException("type not match error");
    }

    public int getResolveStatus() {
        return this.resolveStatus;
    }

    public void setResolveStatus(int resolveStatus) {
        this.resolveStatus = resolveStatus;
    }

    public Object getObject(String path) {
        for (int i = 0; i < this.contextArrayIndex; i++) {
            if (path.equals(this.contextArray[i].getPath())) {
                return this.contextArray[i].getObject();
            }
        }
        return null;
    }

    public void checkListResolve(Collection array) {
        if (this.resolveStatus == 1) {
            if (array instanceof List) {
                int index = array.size() - 1;
                List list = (List) array;
                ResolveTask task = getLastResolveTask();
                task.setFieldDeserializer(new ListResolveFieldDeserializer(this, list, index));
                task.setOwnerContext(this.context);
                setResolveStatus(0);
                return;
            }
            ResolveTask task2 = getLastResolveTask();
            task2.setFieldDeserializer(new CollectionResolveFieldDeserializer(this, array));
            task2.setOwnerContext(this.context);
            setResolveStatus(0);
        }
    }

    public void checkMapResolve(Map object, String fieldName) {
        if (this.resolveStatus == 1) {
            MapResolveFieldDeserializer fieldResolver = new MapResolveFieldDeserializer(object, fieldName);
            ResolveTask task = getLastResolveTask();
            task.setFieldDeserializer(fieldResolver);
            task.setOwnerContext(this.context);
            setResolveStatus(0);
        }
    }

    public Object parseObject(Map object) {
        return parseObject(object, null);
    }

    public JSONObject parseObject() {
        JSONObject object = new JSONObject(isEnabled(Feature.OrderedField));
        return (JSONObject) parseObject((Map) object);
    }

    public final void parseArray(Collection array) {
        parseArray(array, (Object) null);
    }

    public final void parseArray(Collection array, Object fieldName) {
        Object value;
        JSONLexer lexer = getLexer();
        if (lexer.token() == 21 || lexer.token() == 22) {
            lexer.nextToken();
        }
        if (lexer.token() != 14) {
            throw new JSONException("syntax error, expect [, actual " + JSONToken.name(lexer.token()) + ", pos " + lexer.pos());
        }
        lexer.nextToken(4);
        ParseContext context = getContext();
        setContext(array, fieldName);
        int i = 0;
        while (true) {
            try {
                if (isEnabled(Feature.AllowArbitraryCommas)) {
                    while (lexer.token() == 16) {
                        lexer.nextToken();
                    }
                }
                switch (lexer.token()) {
                    case 2:
                        value = lexer.integerValue();
                        lexer.nextToken(16);
                        break;
                    case 3:
                        if (lexer.isEnabled(Feature.UseBigDecimal)) {
                            value = lexer.decimalValue(true);
                        } else {
                            value = lexer.decimalValue(false);
                        }
                        lexer.nextToken(16);
                        break;
                    case 4:
                        String stringLiteral = lexer.stringVal();
                        lexer.nextToken(16);
                        if (lexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                            JSONScanner iso8601Lexer = new JSONScanner(stringLiteral);
                            if (iso8601Lexer.scanISO8601DateIfMatch()) {
                                value = iso8601Lexer.getCalendar().getTime();
                            } else {
                                value = stringLiteral;
                            }
                            iso8601Lexer.close();
                        } else {
                            value = stringLiteral;
                        }
                        break;
                    case 5:
                    case 9:
                    case 10:
                    case 11:
                    case 13:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 21:
                    case 22:
                    default:
                        value = parse();
                        break;
                    case 6:
                        value = Boolean.TRUE;
                        lexer.nextToken(16);
                        break;
                    case 7:
                        value = Boolean.FALSE;
                        lexer.nextToken(16);
                        break;
                    case 8:
                        value = null;
                        lexer.nextToken(4);
                        break;
                    case 12:
                        JSONObject object = new JSONObject(isEnabled(Feature.OrderedField));
                        value = parseObject(object, Integer.valueOf(i));
                        break;
                    case 14:
                        Collection items = new JSONArray();
                        parseArray(items, Integer.valueOf(i));
                        value = items;
                        break;
                    case 15:
                        lexer.nextToken(16);
                        setContext(context);
                        return;
                    case 20:
                        throw new JSONException("unclosed jsonArray");
                    case 23:
                        value = null;
                        lexer.nextToken(4);
                        break;
                }
                array.add(value);
                checkListResolve(array);
                if (lexer.token() == 16) {
                    lexer.nextToken(4);
                }
                i++;
            } catch (Throwable th) {
                setContext(context);
                throw th;
            }
        }
    }

    public ParseContext getContext() {
        return this.context;
    }

    public List<ResolveTask> getResolveTaskList() {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        return this.resolveTaskList;
    }

    public List<ResolveTask> getResolveTaskListDirect() {
        return this.resolveTaskList;
    }

    public void addResolveTask(ResolveTask task) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(task);
    }

    public ResolveTask getLastResolveTask() {
        return this.resolveTaskList.get(this.resolveTaskList.size() - 1);
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraProcessor> getExtraProcessorsDirect() {
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public List<ExtraTypeProvider> getExtraTypeProvidersDirect() {
        return this.extraTypeProviders;
    }

    public void setContext(ParseContext context) {
        if (!isEnabled(Feature.DisableCircularReferenceDetect)) {
            this.context = context;
        }
    }

    public void popContext() {
        if (!isEnabled(Feature.DisableCircularReferenceDetect)) {
            this.context = this.context.getParentContext();
            this.contextArray[this.contextArrayIndex - 1] = null;
            this.contextArrayIndex--;
        }
    }

    public ParseContext setContext(Object object, Object fieldName) {
        if (isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return setContext(this.context, object, fieldName);
    }

    public ParseContext setContext(ParseContext parent, Object object, Object fieldName) {
        if (isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        this.context = new ParseContext(parent, object, fieldName);
        addContext(this.context);
        return this.context;
    }

    private void addContext(ParseContext context) {
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        if (i >= this.contextArray.length) {
            int newLen = (this.contextArray.length * 3) / 2;
            ParseContext[] newArray = new ParseContext[newLen];
            System.arraycopy(this.contextArray, 0, newArray, 0, this.contextArray.length);
            this.contextArray = newArray;
        }
        this.contextArray[i] = context;
    }

    public Object parse() {
        return parse(null);
    }

    public Object parseKey() {
        if (this.lexer.token() != 18) {
            return parse(null);
        }
        String value = this.lexer.stringVal();
        this.lexer.nextToken(16);
        return value;
    }

    public Object parse(Object fieldName) {
        JSONLexer lexer = getLexer();
        switch (lexer.token()) {
            case 2:
                Number intValue = lexer.integerValue();
                lexer.nextToken();
                return intValue;
            case 3:
                Number value = lexer.decimalValue(isEnabled(Feature.UseBigDecimal));
                lexer.nextToken();
                return value;
            case 4:
                String stringLiteral = lexer.stringVal();
                lexer.nextToken(16);
                if (lexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                    JSONScanner iso8601Lexer = new JSONScanner(stringLiteral);
                    try {
                        if (iso8601Lexer.scanISO8601DateIfMatch()) {
                            return iso8601Lexer.getCalendar().getTime();
                        }
                    } finally {
                        iso8601Lexer.close();
                    }
                }
                return stringLiteral;
            case 5:
            case 10:
            case 11:
            case 13:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            default:
                throw new JSONException("syntax error, pos " + lexer.getBufferPosition());
            case 6:
                lexer.nextToken();
                return Boolean.TRUE;
            case 7:
                lexer.nextToken();
                return Boolean.FALSE;
            case 8:
                lexer.nextToken();
                return null;
            case 9:
                lexer.nextToken(18);
                if (lexer.token() != 18) {
                    throw new JSONException("syntax error");
                }
                lexer.nextToken(10);
                accept(10);
                long time = lexer.integerValue().longValue();
                accept(2);
                accept(11);
                return new Date(time);
            case 12:
                JSONObject object = new JSONObject(isEnabled(Feature.OrderedField));
                return parseObject(object, fieldName);
            case 14:
                JSONArray array = new JSONArray();
                parseArray(array, fieldName);
                return array;
            case 20:
                if (lexer.isBlankInput()) {
                    return null;
                }
                throw new JSONException("unterminated json string, pos " + lexer.getBufferPosition());
            case 21:
                lexer.nextToken();
                HashSet<Object> set = new HashSet<>();
                parseArray(set, fieldName);
                return set;
            case 22:
                lexer.nextToken();
                TreeSet<Object> treeSet = new TreeSet<>();
                parseArray(treeSet, fieldName);
                return treeSet;
            case 23:
                lexer.nextToken();
                return null;
        }
    }

    public void config(Feature feature, boolean state) {
        getLexer().config(feature, state);
    }

    public boolean isEnabled(Feature feature) {
        return getLexer().isEnabled(feature);
    }

    public JSONLexer getLexer() {
        return this.lexer;
    }

    public final void accept(int token) {
        JSONLexer lexer = getLexer();
        if (lexer.token() == token) {
            lexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(token) + ", actual " + JSONToken.name(lexer.token()));
    }

    public final void accept(int token, int nextExpectToken) {
        JSONLexer lexer = getLexer();
        if (lexer.token() == token) {
            lexer.nextToken(nextExpectToken);
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(token) + ", actual " + JSONToken.name(lexer.token()));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JSONLexer lexer = getLexer();
        try {
            if (isEnabled(Feature.AutoCloseSource) && lexer.token() != 20) {
                throw new JSONException("not close json text, token : " + JSONToken.name(lexer.token()));
            }
            lexer.close();
        } catch (Throwable th) {
            lexer.close();
            throw th;
        }
    }

    public void handleResovleTask(Object value) {
        Object refValue;
        if (this.resolveTaskList != null) {
            int size = this.resolveTaskList.size();
            for (int i = 0; i < size; i++) {
                ResolveTask task = this.resolveTaskList.get(i);
                FieldDeserializer fieldDeser = task.getFieldDeserializer();
                if (fieldDeser != null) {
                    Object object = null;
                    if (task.getOwnerContext() != null) {
                        object = task.getOwnerContext().getObject();
                    }
                    String ref = task.getReferenceValue();
                    if (ref.startsWith("$")) {
                        refValue = getObject(ref);
                    } else {
                        refValue = task.getContext().getObject();
                    }
                    fieldDeser.setValue(object, refValue);
                }
            }
        }
    }

    public static class ResolveTask {
        private final ParseContext context;
        private FieldDeserializer fieldDeserializer;
        private ParseContext ownerContext;
        private final String referenceValue;

        public ResolveTask(ParseContext context, String referenceValue) {
            this.context = context;
            this.referenceValue = referenceValue;
        }

        public ParseContext getContext() {
            return this.context;
        }

        public String getReferenceValue() {
            return this.referenceValue;
        }

        public FieldDeserializer getFieldDeserializer() {
            return this.fieldDeserializer;
        }

        public void setFieldDeserializer(FieldDeserializer fieldDeserializer) {
            this.fieldDeserializer = fieldDeserializer;
        }

        public ParseContext getOwnerContext() {
            return this.ownerContext;
        }

        public void setOwnerContext(ParseContext ownerContext) {
            this.ownerContext = ownerContext;
        }
    }
}
