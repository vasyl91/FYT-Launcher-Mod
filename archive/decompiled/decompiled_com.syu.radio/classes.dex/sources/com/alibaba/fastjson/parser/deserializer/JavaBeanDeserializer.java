package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.FilterUtils;
import com.alibaba.fastjson.util.DeserializeBeanInfo;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.lsec.core.util.data.FinalChip;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    private DeserializeBeanInfo beanInfo;
    private final Class<?> clazz;
    private final Map<String, FieldDeserializer> feildDeserializerMap;
    private final List<FieldDeserializer> fieldDeserializers;
    private final List<FieldDeserializer> sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig config, Class<?> clazz) {
        this(config, clazz, clazz);
    }

    public JavaBeanDeserializer(ParserConfig config, Class<?> clazz, Type type) {
        this.feildDeserializerMap = new IdentityHashMap();
        this.fieldDeserializers = new ArrayList();
        this.sortedFieldDeserializers = new ArrayList();
        this.clazz = clazz;
        this.beanInfo = DeserializeBeanInfo.computeSetters(clazz, type);
        for (FieldInfo fieldInfo : this.beanInfo.getFieldList()) {
            addFieldDeserializer(config, clazz, fieldInfo);
        }
        for (FieldInfo fieldInfo2 : this.beanInfo.getSortedFieldList()) {
            FieldDeserializer fieldDeserializer = this.feildDeserializerMap.get(fieldInfo2.getName().intern());
            this.sortedFieldDeserializers.add(fieldDeserializer);
        }
    }

    public Map<String, FieldDeserializer> getFieldDeserializerMap() {
        return this.feildDeserializerMap;
    }

    public FieldDeserializer getFieldDeserializer(String name) {
        FieldDeserializer feildDeser = this.feildDeserializerMap.get(name);
        if (feildDeser == null) {
            for (Map.Entry<String, FieldDeserializer> entry : this.feildDeserializerMap.entrySet()) {
                if (name.equals(entry.getKey())) {
                    return entry.getValue();
                }
            }
            return null;
        }
        return feildDeser;
    }

    public Class<?> getClazz() {
        return this.clazz;
    }

    private void addFieldDeserializer(ParserConfig mapping, Class<?> clazz, FieldInfo fieldInfo) {
        String interName = fieldInfo.getName().intern();
        FieldDeserializer fieldDeserializer = createFieldDeserializer(mapping, clazz, fieldInfo);
        this.feildDeserializerMap.put(interName, fieldDeserializer);
        this.fieldDeserializers.add(fieldDeserializer);
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig mapping, Class<?> clazz, FieldInfo fieldInfo) {
        return mapping.createFieldDeserializer(mapping, this.beanInfo, fieldInfo);
    }

    public Object createInstance(DefaultJSONParser parser, Type type) {
        Object object;
        if ((type instanceof Class) && this.clazz.isInterface()) {
            Class<?> clazz = (Class) type;
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            JSONObject obj = new JSONObject();
            return Proxy.newProxyInstance(loader, new Class[]{clazz}, obj);
        }
        if (this.beanInfo.getDefaultConstructor() == null) {
            return null;
        }
        try {
            Constructor<?> constructor = this.beanInfo.getDefaultConstructor();
            if (constructor.getParameterTypes().length == 0) {
                object = constructor.newInstance(new Object[0]);
            } else {
                object = constructor.newInstance(parser.getContext().getObject());
            }
            if (parser.isEnabled(Feature.InitStringFieldAsEmpty)) {
                for (FieldInfo fieldInfo : this.beanInfo.getFieldList()) {
                    if (fieldInfo.getFieldClass() == String.class) {
                        try {
                            fieldInfo.set(object, FinalChip.BSP_PLATFORM_Null);
                        } catch (Exception e) {
                            throw new JSONException("create instance error, class " + this.clazz.getName(), e);
                        }
                    }
                }
            }
            return object;
        } catch (Exception e2) {
            throw new JSONException("create instance error, class " + this.clazz.getName(), e2);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null);
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() != 14) {
            throw new JSONException("error");
        }
        T t = (T) createInstance(defaultJSONParser, type);
        int size = this.sortedFieldDeserializers.size();
        int i = 0;
        while (i < size) {
            char c = i == size + (-1) ? ']' : ',';
            FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers.get(i);
            Class<?> fieldClass = fieldDeserializer.getFieldClass();
            if (fieldClass == Integer.TYPE) {
                fieldDeserializer.setValue((Object) t, lexer.scanInt(c));
            } else if (fieldClass == String.class) {
                fieldDeserializer.setValue((Object) t, lexer.scanString(c));
            } else if (fieldClass == Long.TYPE) {
                fieldDeserializer.setValue(t, lexer.scanLong(c));
            } else if (fieldClass.isEnum()) {
                fieldDeserializer.setValue(t, lexer.scanEnum(fieldClass, defaultJSONParser.getSymbolTable(), c));
            } else {
                lexer.nextToken(14);
                fieldDeserializer.setValue(t, defaultJSONParser.parseObject(fieldDeserializer.getFieldType()));
                if (c == ']') {
                    if (lexer.token() != 15) {
                        throw new JSONException("syntax error");
                    }
                    lexer.nextToken(16);
                } else if (c == ',' && lexer.token() != 16) {
                    throw new JSONException("syntax error");
                }
            }
            i++;
        }
        lexer.nextToken(16);
        return t;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00d2  */
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) throws Throwable {
        if (type == JSON.class || type == JSONObject.class) {
            return (T) defaultJSONParser.parse();
        }
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() == 8) {
            lexer.nextToken(16);
            return null;
        }
        ParseContext context = defaultJSONParser.getContext();
        if (obj2 != null && context != null) {
            context = context.getParentContext();
        }
        ParseContext context2 = null;
        Map<String, Object> map = null;
        try {
            if (lexer.token() == 13) {
                lexer.nextToken(16);
                if (obj2 == null) {
                    obj2 = createInstance(defaultJSONParser, type);
                }
                if (0 != 0) {
                    context2.setObject(obj2);
                }
                defaultJSONParser.setContext(context);
                return (T) obj2;
            }
            if (lexer.token() == 14 && isSupportArrayToBean(lexer)) {
                T t = (T) deserialzeArrayMapping(defaultJSONParser, type, obj, obj2);
                if (0 != 0) {
                    context2.setObject(obj2);
                }
                defaultJSONParser.setContext(context);
                return t;
            }
            if (lexer.token() != 12 && lexer.token() != 16) {
                StringBuffer stringBufferAppend = new StringBuffer().append("syntax error, expect {, actual ").append(lexer.tokenName()).append(", pos ").append(lexer.pos());
                if (obj instanceof String) {
                    stringBufferAppend.append(", fieldName ").append(obj);
                }
                throw new JSONException(stringBufferAppend.toString());
            }
            if (defaultJSONParser.getResolveStatus() == 2) {
                defaultJSONParser.setResolveStatus(0);
            }
            loop0: while (true) {
                Map<String, Object> map2 = map;
                while (true) {
                    try {
                        String strScanSymbol = lexer.scanSymbol(defaultJSONParser.getSymbolTable());
                        if (strScanSymbol == null) {
                            if (lexer.token() == 13) {
                                lexer.nextToken(16);
                                map = map2;
                                break loop0;
                            }
                            if (lexer.token() != 16 || !defaultJSONParser.isEnabled(Feature.AllowArbitraryCommas)) {
                            }
                        }
                        if ("$ref" == strScanSymbol) {
                            lexer.nextTokenWithColon(4);
                            if (lexer.token() != 4) {
                                throw new JSONException("illegal ref, " + JSONToken.name(lexer.token()));
                            }
                            String strStringVal = lexer.stringVal();
                            if ("@".equals(strStringVal)) {
                                obj2 = context.getObject();
                            } else if ("..".equals(strStringVal)) {
                                ParseContext parentContext = context.getParentContext();
                                if (parentContext.getObject() != null) {
                                    obj2 = parentContext.getObject();
                                } else {
                                    defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parentContext, strStringVal));
                                    defaultJSONParser.setResolveStatus(1);
                                }
                            } else if ("$".equals(strStringVal)) {
                                ParseContext parentContext2 = context;
                                while (parentContext2.getParentContext() != null) {
                                    parentContext2 = parentContext2.getParentContext();
                                }
                                if (parentContext2.getObject() != null) {
                                    obj2 = parentContext2.getObject();
                                } else {
                                    defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parentContext2, strStringVal));
                                    defaultJSONParser.setResolveStatus(1);
                                }
                            } else {
                                defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(context, strStringVal));
                                defaultJSONParser.setResolveStatus(1);
                            }
                            lexer.nextToken(13);
                            if (lexer.token() != 13) {
                                throw new JSONException("illegal ref");
                            }
                            lexer.nextToken(16);
                            defaultJSONParser.setContext(context, obj2, obj);
                            if (context2 != null) {
                                context2.setObject(obj2);
                            }
                            defaultJSONParser.setContext(context);
                            return (T) obj2;
                        }
                        if (JSON.DEFAULT_TYPE_KEY == strScanSymbol) {
                            lexer.nextTokenWithColon(4);
                            if (lexer.token() != 4) {
                                throw new JSONException("syntax error");
                            }
                            String strStringVal2 = lexer.stringVal();
                            lexer.nextToken(16);
                            if (!(type instanceof Class) || !strStringVal2.equals(((Class) type).getName())) {
                                Type typeLoadClass = TypeUtils.loadClass(strStringVal2);
                                T t2 = (T) defaultJSONParser.getConfig().getDeserializer(typeLoadClass).deserialze(defaultJSONParser, typeLoadClass, obj);
                                if (context2 != null) {
                                    context2.setObject(obj2);
                                }
                                defaultJSONParser.setContext(context);
                                return t2;
                            }
                            if (lexer.token() == 13) {
                                lexer.nextToken();
                                map = map2;
                                break loop0;
                            }
                        } else {
                            if (obj2 == null && map2 == null) {
                                obj2 = createInstance(defaultJSONParser, type);
                                map = obj2 == null ? new HashMap<>(this.fieldDeserializers.size()) : map2;
                                context2 = defaultJSONParser.setContext(context, obj2, obj);
                            } else {
                                map = map2;
                            }
                            if (!parseField(defaultJSONParser, strScanSymbol, obj2, type, map)) {
                                if (lexer.token() != 13) {
                                    break;
                                }
                                lexer.nextToken();
                                break;
                            }
                            if (lexer.token() != 16) {
                                if (lexer.token() != 13) {
                                    if (lexer.token() != 18 && lexer.token() != 1) {
                                        break;
                                    }
                                    throw new JSONException("syntax error, unexpect token " + JSONToken.name(lexer.token()));
                                }
                                lexer.nextToken(16);
                                break;
                            }
                            map2 = map;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (context2 != null) {
                            context2.setObject(obj2);
                        }
                        defaultJSONParser.setContext(context);
                        throw th;
                    }
                }
            }
            if (obj2 == null) {
                if (map == null) {
                    T t3 = (T) createInstance(defaultJSONParser, type);
                    if (context2 == null) {
                        context2 = defaultJSONParser.setContext(context, t3, obj);
                    }
                    if (context2 != null) {
                        context2.setObject(t3);
                    }
                    defaultJSONParser.setContext(context);
                    return t3;
                }
                List<FieldInfo> fieldList = this.beanInfo.getFieldList();
                int size = fieldList.size();
                Object[] objArr = new Object[size];
                for (int i = 0; i < size; i++) {
                    objArr[i] = map.get(fieldList.get(i).getName());
                }
                if (this.beanInfo.getCreatorConstructor() != null) {
                    try {
                        obj2 = this.beanInfo.getCreatorConstructor().newInstance(objArr);
                    } catch (Exception e) {
                        throw new JSONException("create instance error, " + this.beanInfo.getCreatorConstructor().toGenericString(), e);
                    }
                } else if (this.beanInfo.getFactoryMethod() != null) {
                    try {
                        obj2 = this.beanInfo.getFactoryMethod().invoke(null, objArr);
                    } catch (Exception e2) {
                        throw new JSONException("create factory method error, " + this.beanInfo.getFactoryMethod().toString(), e2);
                    }
                }
            }
            T t4 = (T) handleBuilder(obj2);
            if (context2 != null) {
                context2.setObject(obj2);
            }
            defaultJSONParser.setContext(context);
            return t4;
        } catch (Throwable th2) {
            th = th2;
            if (context2 != null) {
                context2.setObject(obj2);
            }
            defaultJSONParser.setContext(context);
            throw th;
        }
    }

    private Object handleBuilder(Object obj) {
        Method buildMethod = this.beanInfo.getBuildMethod();
        if (buildMethod != null) {
            try {
                Object builtObj = buildMethod.invoke(obj, new Object[0]);
                return builtObj;
            } catch (Exception e) {
                throw new JSONException("build object error", e);
            }
        }
        return obj;
    }

    public boolean parseField(DefaultJSONParser parser, String key, Object object, Type objectType, Map<String, Object> fieldValues) {
        JSONLexer lexer = parser.getLexer();
        FieldDeserializer fieldDeserializer = this.feildDeserializerMap.get(key);
        if (fieldDeserializer == null) {
            for (Map.Entry<String, FieldDeserializer> entry : this.feildDeserializerMap.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(key)) {
                    fieldDeserializer = entry.getValue();
                    break;
                }
            }
        }
        if (fieldDeserializer == null) {
            parseExtra(parser, object, key);
            return false;
        }
        lexer.nextTokenWithColon(fieldDeserializer.getFastMatchToken());
        fieldDeserializer.parseField(parser, object, objectType, fieldValues);
        return true;
    }

    void parseExtra(DefaultJSONParser parser, Object object, String key) {
        Object value;
        JSONLexer lexer = parser.getLexer();
        if (!lexer.isEnabled(Feature.IgnoreNotMatch)) {
            throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + key);
        }
        lexer.nextTokenWithColon();
        Type type = FilterUtils.getExtratype(parser, object, key);
        if (type == null) {
            value = parser.parse();
        } else {
            value = parser.parseObject(type);
        }
        FilterUtils.processExtra(parser, object, key, value);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public List<FieldDeserializer> getSortedFieldDeserializers() {
        return this.sortedFieldDeserializers;
    }

    public final boolean isSupportArrayToBean(JSONLexer lexer) {
        return Feature.isEnabled(this.beanInfo.getParserFeatures(), Feature.SupportArrayToBean) || lexer.isEnabled(Feature.SupportArrayToBean);
    }
}
