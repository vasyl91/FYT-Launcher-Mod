package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ASMJavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.ASMJavaBeanSerializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JSONPath implements ObjectSerializer {
    private static int CACHE_SIZE = 1024;
    private static ConcurrentMap<String, JSONPath> pathCache = new ConcurrentHashMap(128, 0.75f, 1);
    private ParserConfig parserConfig;
    private final String path;
    private Segement[] segments;
    private SerializeConfig serializeConfig;

    interface Filter {
        boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3);
    }

    enum Operator {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Operator[] valuesCustom() {
            Operator[] operatorArrValuesCustom = values();
            int length = operatorArrValuesCustom.length;
            Operator[] operatorArr = new Operator[length];
            System.arraycopy(operatorArrValuesCustom, 0, operatorArr, 0, length);
            return operatorArr;
        }
    }

    interface Segement {
        Object eval(JSONPath jSONPath, Object obj, Object obj2);
    }

    public JSONPath(String path) {
        this(path, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance());
    }

    public JSONPath(String path, SerializeConfig serializeConfig, ParserConfig parserConfig) {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.path = path;
        this.serializeConfig = serializeConfig;
        this.parserConfig = parserConfig;
    }

    protected void init() {
        if (this.segments == null) {
            if ("*".equals(this.path)) {
                this.segments = new Segement[]{WildCardSegement.instance};
            } else {
                JSONPathParser parser = new JSONPathParser(this.path);
                this.segments = parser.explain();
            }
        }
    }

    public Object eval(Object rootObject) {
        if (rootObject == null) {
            return null;
        }
        init();
        Object currentObject = rootObject;
        for (int i = 0; i < this.segments.length; i++) {
            currentObject = this.segments[i].eval(this, rootObject, currentObject);
        }
        return currentObject;
    }

    public boolean contains(Object rootObject) {
        if (rootObject == null) {
            return false;
        }
        init();
        Object currentObject = rootObject;
        for (int i = 0; i < this.segments.length; i++) {
            currentObject = this.segments[i].eval(this, rootObject, currentObject);
            if (currentObject == null) {
                return false;
            }
        }
        return true;
    }

    public boolean containsValue(Object rootObject, Object value) {
        Object currentObject = eval(rootObject);
        if (currentObject == value) {
            return true;
        }
        if (currentObject == null) {
            return false;
        }
        if (currentObject instanceof Iterable) {
            for (Object item : (Iterable) currentObject) {
                if (eq(item, value)) {
                    return true;
                }
            }
            return false;
        }
        return eq(currentObject, value);
    }

    public int size(Object rootObject) {
        if (rootObject == null) {
            return -1;
        }
        init();
        Object currentObject = rootObject;
        for (int i = 0; i < this.segments.length; i++) {
            currentObject = this.segments[i].eval(this, rootObject, currentObject);
        }
        return evalSize(currentObject);
    }

    public void arrayAdd(Object rootObject, Object... values) {
        if (values != null && values.length != 0 && rootObject != null) {
            init();
            Object currentObject = rootObject;
            Object parentObject = null;
            for (int i = 0; i < this.segments.length; i++) {
                if (i == this.segments.length - 1) {
                    parentObject = currentObject;
                }
                currentObject = this.segments[i].eval(this, rootObject, currentObject);
            }
            Object result = currentObject;
            if (result == null) {
                throw new JSONPathException("value not found in path " + this.path);
            }
            if (result instanceof Collection) {
                Collection collection = (Collection) result;
                for (Object value : values) {
                    collection.add(value);
                }
                return;
            }
            Class<?> resultClass = result.getClass();
            if (resultClass.isArray()) {
                int length = Array.getLength(result);
                Object descArray = Array.newInstance(resultClass.getComponentType(), values.length + length);
                System.arraycopy(result, 0, descArray, 0, length);
                for (int i2 = 0; i2 < values.length; i2++) {
                    Array.set(descArray, length + i2, values[i2]);
                }
                Segement lastSegement = this.segments[this.segments.length - 1];
                if (lastSegement instanceof PropertySegement) {
                    PropertySegement propertySegement = (PropertySegement) lastSegement;
                    propertySegement.setValue(this, parentObject, descArray);
                    return;
                } else {
                    if (lastSegement instanceof ArrayAccessSegement) {
                        ((ArrayAccessSegement) lastSegement).setValue(this, parentObject, descArray);
                        return;
                    }
                    throw new UnsupportedOperationException();
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    public boolean set(Object rootObject, Object value) {
        if (rootObject == null) {
            return false;
        }
        init();
        Object currentObject = rootObject;
        Object parentObject = null;
        for (int i = 0; i < this.segments.length; i++) {
            if (i == this.segments.length - 1) {
                parentObject = currentObject;
                break;
            }
            currentObject = this.segments[i].eval(this, rootObject, currentObject);
            if (currentObject == null) {
                break;
            }
        }
        if (parentObject == null) {
            return false;
        }
        Segement lastSegement = this.segments[this.segments.length - 1];
        if (lastSegement instanceof PropertySegement) {
            PropertySegement propertySegement = (PropertySegement) lastSegement;
            propertySegement.setValue(this, parentObject, value);
            return true;
        }
        if (lastSegement instanceof ArrayAccessSegement) {
            return ((ArrayAccessSegement) lastSegement).setValue(this, parentObject, value);
        }
        throw new UnsupportedOperationException();
    }

    public static Object eval(Object rootObject, String path) {
        JSONPath jsonpath = compile(path);
        return jsonpath.eval(rootObject);
    }

    public static int size(Object rootObject, String path) {
        JSONPath jsonpath = compile(path);
        Object result = jsonpath.eval(rootObject);
        return jsonpath.evalSize(result);
    }

    public static boolean contains(Object rootObject, String path) {
        if (rootObject == null) {
            return false;
        }
        JSONPath jsonpath = compile(path);
        return jsonpath.contains(rootObject);
    }

    public static boolean containsValue(Object rootObject, String path, Object value) {
        JSONPath jsonpath = compile(path);
        return jsonpath.containsValue(rootObject, value);
    }

    public static void arrayAdd(Object rootObject, String path, Object... values) {
        JSONPath jsonpath = compile(path);
        jsonpath.arrayAdd(rootObject, values);
    }

    public static boolean set(Object rootObject, String path, Object value) {
        JSONPath jsonpath = compile(path);
        return jsonpath.set(rootObject, value);
    }

    public static JSONPath compile(String path) {
        JSONPath jsonpath = pathCache.get(path);
        if (jsonpath == null) {
            JSONPath jsonpath2 = new JSONPath(path);
            if (pathCache.size() < CACHE_SIZE) {
                pathCache.putIfAbsent(path, jsonpath2);
                return pathCache.get(path);
            }
            return jsonpath2;
        }
        return jsonpath;
    }

    public String getPath() {
        return this.path;
    }

    static class JSONPathParser {
        private char ch;
        private int level;
        private final String path;
        private int pos;

        public JSONPathParser(String path) {
            this.path = path;
            next();
        }

        void next() {
            String str = this.path;
            int i = this.pos;
            this.pos = i + 1;
            this.ch = str.charAt(i);
        }

        boolean isEOF() {
            return this.pos >= this.path.length();
        }

        Segement readSegement() {
            if (this.level == 0 && this.path.length() == 1) {
                if (isDigitFirst(this.ch)) {
                    int index = this.ch - '0';
                    return new ArrayAccessSegement(index);
                }
                if ((this.ch >= 'a' && this.ch <= 'z') || (this.ch >= 'A' && this.ch <= 'Z')) {
                    return new PropertySegement(Character.toString(this.ch));
                }
            }
            while (!isEOF()) {
                skipWhitespace();
                if (this.ch == '@') {
                    next();
                    return SelfSegement.instance;
                }
                if (this.ch == '$') {
                    next();
                } else {
                    if (this.ch == '.' || this.ch == '/') {
                        next();
                        if (this.ch == '*') {
                            if (!isEOF()) {
                                next();
                            }
                            return WildCardSegement.instance;
                        }
                        if (isDigitFirst(this.ch)) {
                            return parseArrayAccess(false);
                        }
                        String propertyName = readName();
                        if (this.ch == '(') {
                            next();
                            if (this.ch == ')') {
                                if (!isEOF()) {
                                    next();
                                }
                                if ("size".equals(propertyName)) {
                                    return SizeSegement.instance;
                                }
                                throw new UnsupportedOperationException();
                            }
                            throw new UnsupportedOperationException();
                        }
                        return new PropertySegement(propertyName);
                    }
                    if (this.ch == '[') {
                        return parseArrayAccess(true);
                    }
                    if (this.level == 0) {
                        return new PropertySegement(readName());
                    }
                    throw new UnsupportedOperationException();
                }
            }
            return null;
        }

        public final void skipWhitespace() {
            while (this.ch < IOUtils.whitespaceFlags.length && IOUtils.whitespaceFlags[this.ch]) {
                next();
            }
        }

        Segement parseArrayAccess(boolean acceptBracket) {
            int end;
            if (acceptBracket) {
                accept('[');
            }
            boolean predicateFlag = false;
            if (this.ch == '?') {
                next();
                accept('(');
                if (this.ch == '@') {
                    next();
                    accept('.');
                }
                predicateFlag = true;
            }
            if (predicateFlag || IOUtils.firstIdentifier(this.ch)) {
                String propertyName = readName();
                skipWhitespace();
                if (predicateFlag && this.ch == ')') {
                    next();
                    if (acceptBracket) {
                        accept(']');
                    }
                    return new FilterSegement(new NotNullSegement(propertyName));
                }
                if (acceptBracket && this.ch == ']') {
                    next();
                    return new FilterSegement(new NotNullSegement(propertyName));
                }
                Operator op = readOp();
                skipWhitespace();
                if (op == Operator.BETWEEN || op == Operator.NOT_BETWEEN) {
                    boolean not = op == Operator.NOT_BETWEEN;
                    Object startValue = readValue();
                    String name = readName();
                    if (!"and".equalsIgnoreCase(name)) {
                        throw new JSONPathException(this.path);
                    }
                    Object endValue = readValue();
                    if (startValue == null || endValue == null) {
                        throw new JSONPathException(this.path);
                    }
                    if (JSONPath.isInt(startValue.getClass()) && JSONPath.isInt(endValue.getClass())) {
                        Filter filter = new IntBetweenSegement(propertyName, ((Number) startValue).longValue(), ((Number) endValue).longValue(), not);
                        return new FilterSegement(filter);
                    }
                    throw new JSONPathException(this.path);
                }
                if (op == Operator.IN || op == Operator.NOT_IN) {
                    boolean not2 = op == Operator.NOT_IN;
                    accept('(');
                    List<Object> valueList = new ArrayList<>();
                    Object value = readValue();
                    valueList.add(value);
                    while (true) {
                        skipWhitespace();
                        if (this.ch != ',') {
                            break;
                        }
                        next();
                        Object value2 = readValue();
                        valueList.add(value2);
                    }
                    accept(')');
                    if (predicateFlag) {
                        accept(')');
                    }
                    if (acceptBracket) {
                        accept(']');
                    }
                    boolean isInt = true;
                    boolean isIntObj = true;
                    boolean isString = true;
                    for (Object item : valueList) {
                        if (item == null) {
                            if (isInt) {
                                isInt = false;
                            }
                        } else {
                            Class<?> clazz = item.getClass();
                            if (isInt && clazz != Byte.class && clazz != Short.class && clazz != Integer.class && clazz != Long.class) {
                                isInt = false;
                                isIntObj = false;
                            }
                            if (isString && clazz != String.class) {
                                isString = false;
                            }
                        }
                    }
                    if (valueList.size() == 1 && valueList.get(0) == null) {
                        if (not2) {
                            return new FilterSegement(new NotNullSegement(propertyName));
                        }
                        return new FilterSegement(new NullSegement(propertyName));
                    }
                    if (isInt) {
                        if (valueList.size() == 1) {
                            long value3 = ((Number) valueList.get(0)).longValue();
                            Operator intOp = not2 ? Operator.NE : Operator.EQ;
                            return new FilterSegement(new IntOpSegement(propertyName, value3, intOp));
                        }
                        long[] values = new long[valueList.size()];
                        for (int i = 0; i < values.length; i++) {
                            values[i] = ((Number) valueList.get(i)).longValue();
                        }
                        return new FilterSegement(new IntInSegement(propertyName, values, not2));
                    }
                    if (isString) {
                        if (valueList.size() == 1) {
                            Object value4 = valueList.get(0);
                            String value5 = (String) value4;
                            Operator intOp2 = not2 ? Operator.NE : Operator.EQ;
                            return new FilterSegement(new StringOpSegement(propertyName, value5, intOp2));
                        }
                        String[] values2 = new String[valueList.size()];
                        valueList.toArray(values2);
                        return new FilterSegement(new StringInSegement(propertyName, values2, not2));
                    }
                    if (isIntObj) {
                        Long[] values3 = new Long[valueList.size()];
                        for (int i2 = 0; i2 < values3.length; i2++) {
                            Number item2 = (Number) valueList.get(i2);
                            if (item2 != null) {
                                values3[i2] = Long.valueOf(item2.longValue());
                            }
                        }
                        return new FilterSegement(new IntObjInSegement(propertyName, values3, not2));
                    }
                    throw new UnsupportedOperationException();
                }
                if (this.ch == '\'' || this.ch == '\"') {
                    String strValue = readString();
                    if (predicateFlag) {
                        accept(')');
                    }
                    if (acceptBracket) {
                        accept(']');
                    }
                    if (op == Operator.RLIKE) {
                        return new FilterSegement(new RlikeSegement(propertyName, strValue, false));
                    }
                    if (op == Operator.NOT_RLIKE) {
                        return new FilterSegement(new RlikeSegement(propertyName, strValue, true));
                    }
                    if (op == Operator.LIKE || op == Operator.NOT_LIKE) {
                        while (strValue.indexOf("%%") != -1) {
                            strValue = strValue.replaceAll("%%", "%");
                        }
                        boolean not3 = op == Operator.NOT_LIKE;
                        int p0 = strValue.indexOf(37);
                        if (p0 == -1) {
                            if (op == Operator.LIKE) {
                                op = Operator.EQ;
                            } else {
                                op = Operator.NE;
                            }
                        } else {
                            String[] items = strValue.split("%");
                            String startsWithValue = null;
                            String endsWithValue = null;
                            String[] containsValues = (String[]) null;
                            if (p0 == 0) {
                                if (strValue.charAt(strValue.length() - 1) == '%') {
                                    containsValues = new String[items.length - 1];
                                    System.arraycopy(items, 1, containsValues, 0, containsValues.length);
                                } else {
                                    endsWithValue = items[items.length - 1];
                                    if (items.length > 2) {
                                        containsValues = new String[items.length - 2];
                                        System.arraycopy(items, 1, containsValues, 0, containsValues.length);
                                    }
                                }
                            } else if (strValue.charAt(strValue.length() - 1) == '%') {
                                containsValues = items;
                            } else if (items.length == 1) {
                                startsWithValue = items[0];
                            } else if (items.length == 2) {
                                startsWithValue = items[0];
                                endsWithValue = items[1];
                            } else {
                                startsWithValue = items[0];
                                endsWithValue = items[items.length - 1];
                                containsValues = new String[items.length - 2];
                                System.arraycopy(items, 1, containsValues, 0, containsValues.length);
                            }
                            return new FilterSegement(new MatchSegement(propertyName, startsWithValue, endsWithValue, containsValues, not3));
                        }
                    }
                    return new FilterSegement(new StringOpSegement(propertyName, strValue, op));
                }
                if (isDigitFirst(this.ch)) {
                    long value6 = readLongValue();
                    if (predicateFlag) {
                        accept(')');
                    }
                    if (acceptBracket) {
                        accept(']');
                    }
                    return new FilterSegement(new IntOpSegement(propertyName, value6, op));
                }
                if (this.ch == 'n') {
                    String name2 = readName();
                    if ("null".equals(name2)) {
                        if (predicateFlag) {
                            accept(')');
                        }
                        accept(']');
                        if (op == Operator.EQ) {
                            return new FilterSegement(new NullSegement(propertyName));
                        }
                        if (op == Operator.NE) {
                            return new FilterSegement(new NotNullSegement(propertyName));
                        }
                        throw new UnsupportedOperationException();
                    }
                }
                throw new UnsupportedOperationException();
            }
            int start = this.pos - 1;
            while (this.ch != ']' && this.ch != '/' && !isEOF()) {
                next();
            }
            if (acceptBracket || this.ch == '/') {
                end = this.pos - 1;
            } else {
                end = this.pos;
            }
            String text = this.path.substring(start, end);
            Segement segementBuildArraySegement = buildArraySegement(text);
            if (acceptBracket && !isEOF()) {
                accept(']');
                return segementBuildArraySegement;
            }
            return segementBuildArraySegement;
        }

        protected long readLongValue() {
            int beginIndex = this.pos - 1;
            if (this.ch == '+' || this.ch == '-') {
                next();
            }
            while (this.ch >= '0' && this.ch <= '9') {
                next();
            }
            int endIndex = this.pos - 1;
            String text = this.path.substring(beginIndex, endIndex);
            long value = Long.parseLong(text);
            return value;
        }

        protected Object readValue() {
            skipWhitespace();
            if (isDigitFirst(this.ch)) {
                return Long.valueOf(readLongValue());
            }
            if (this.ch == '\"' || this.ch == '\'') {
                return readString();
            }
            if (this.ch == 'n') {
                String name = readName();
                if ("null".equals(name)) {
                    return null;
                }
                throw new JSONPathException(this.path);
            }
            throw new UnsupportedOperationException();
        }

        static boolean isDigitFirst(char ch) {
            return ch == '-' || ch == '+' || (ch >= '0' && ch <= '9');
        }

        protected Operator readOp() {
            Operator op = null;
            if (this.ch == '=') {
                next();
                op = Operator.EQ;
            } else if (this.ch == '!') {
                next();
                accept('=');
                op = Operator.NE;
            } else if (this.ch == '<') {
                next();
                if (this.ch == '=') {
                    next();
                    op = Operator.LE;
                } else {
                    op = Operator.LT;
                }
            } else if (this.ch == '>') {
                next();
                if (this.ch == '=') {
                    next();
                    op = Operator.GE;
                } else {
                    op = Operator.GT;
                }
            }
            if (op == null) {
                String name = readName();
                if ("not".equalsIgnoreCase(name)) {
                    skipWhitespace();
                    String name2 = readName();
                    if ("like".equalsIgnoreCase(name2)) {
                        Operator op2 = Operator.NOT_LIKE;
                        return op2;
                    }
                    if ("rlike".equalsIgnoreCase(name2)) {
                        Operator op3 = Operator.NOT_RLIKE;
                        return op3;
                    }
                    if ("in".equalsIgnoreCase(name2)) {
                        Operator op4 = Operator.NOT_IN;
                        return op4;
                    }
                    if ("between".equalsIgnoreCase(name2)) {
                        Operator op5 = Operator.NOT_BETWEEN;
                        return op5;
                    }
                    throw new UnsupportedOperationException();
                }
                if ("like".equalsIgnoreCase(name)) {
                    Operator op6 = Operator.LIKE;
                    return op6;
                }
                if ("rlike".equalsIgnoreCase(name)) {
                    Operator op7 = Operator.RLIKE;
                    return op7;
                }
                if ("in".equalsIgnoreCase(name)) {
                    Operator op8 = Operator.IN;
                    return op8;
                }
                if ("between".equalsIgnoreCase(name)) {
                    Operator op9 = Operator.BETWEEN;
                    return op9;
                }
                throw new UnsupportedOperationException();
            }
            return op;
        }

        String readName() {
            skipWhitespace();
            if (!IOUtils.firstIdentifier(this.ch)) {
                throw new JSONPathException("illeal jsonpath syntax. " + this.path);
            }
            StringBuffer buf = new StringBuffer();
            while (!isEOF()) {
                if (this.ch == '\\') {
                    next();
                    buf.append(this.ch);
                    next();
                } else {
                    boolean identifierFlag = IOUtils.isIdent(this.ch);
                    if (!identifierFlag) {
                        break;
                    }
                    buf.append(this.ch);
                    next();
                }
            }
            if (isEOF() && IOUtils.isIdent(this.ch)) {
                buf.append(this.ch);
            }
            String propertyName = buf.toString();
            return propertyName;
        }

        String readString() {
            char quoate = this.ch;
            next();
            int beginIndex = this.pos - 1;
            while (this.ch != quoate && !isEOF()) {
                next();
            }
            String strValue = this.path.substring(beginIndex, isEOF() ? this.pos : this.pos - 1);
            accept(quoate);
            return strValue;
        }

        void accept(char expect) {
            if (this.ch != expect) {
                throw new JSONPathException("expect '" + expect + ", but '" + this.ch + "'");
            }
            if (!isEOF()) {
                next();
            }
        }

        public Segement[] explain() {
            if (this.path == null || this.path.isEmpty()) {
                throw new IllegalArgumentException();
            }
            Segement[] segements = new Segement[8];
            while (true) {
                Segement segment = readSegement();
                if (segment == null) {
                    break;
                }
                int i = this.level;
                this.level = i + 1;
                segements[i] = segment;
            }
            if (this.level != segements.length) {
                Segement[] result = new Segement[this.level];
                System.arraycopy(segements, 0, result, 0, this.level);
                return result;
            }
            return segements;
        }

        Segement buildArraySegement(String indexText) {
            int end;
            int step;
            int indexTextLen = indexText.length();
            char firstChar = indexText.charAt(0);
            char lastChar = indexText.charAt(indexTextLen - 1);
            int commaIndex = indexText.indexOf(44);
            if (indexText.length() > 2 && firstChar == '\'' && lastChar == '\'') {
                if (commaIndex == -1) {
                    String propertyName = indexText.substring(1, indexTextLen - 1);
                    return new PropertySegement(propertyName);
                }
                String[] indexesText = indexText.split(",");
                String[] propertyNames = new String[indexesText.length];
                for (int i = 0; i < indexesText.length; i++) {
                    String indexesTextItem = indexesText[i];
                    propertyNames[i] = indexesTextItem.substring(1, indexesTextItem.length() - 1);
                }
                return new MultiPropertySegement(propertyNames);
            }
            int colonIndex = indexText.indexOf(58);
            if (commaIndex == -1 && colonIndex == -1) {
                int index = Integer.parseInt(indexText);
                return new ArrayAccessSegement(index);
            }
            if (commaIndex != -1) {
                String[] indexesText2 = indexText.split(",");
                int[] indexes = new int[indexesText2.length];
                for (int i2 = 0; i2 < indexesText2.length; i2++) {
                    indexes[i2] = Integer.parseInt(indexesText2[i2]);
                }
                return new MultiIndexSegement(indexes);
            }
            if (colonIndex != -1) {
                String[] indexesText3 = indexText.split(":");
                int[] indexes2 = new int[indexesText3.length];
                for (int i3 = 0; i3 < indexesText3.length; i3++) {
                    String str = indexesText3[i3];
                    if (str.isEmpty()) {
                        if (i3 == 0) {
                            indexes2[i3] = 0;
                        } else {
                            throw new UnsupportedOperationException();
                        }
                    } else {
                        indexes2[i3] = Integer.parseInt(str);
                    }
                }
                int start = indexes2[0];
                if (indexes2.length > 1) {
                    end = indexes2[1];
                } else {
                    end = -1;
                }
                if (indexes2.length == 3) {
                    step = indexes2[2];
                } else {
                    step = 1;
                }
                if (end >= 0 && end < start) {
                    throw new UnsupportedOperationException("end must greater than or equals start. start " + start + ",  end " + end);
                }
                if (step <= 0) {
                    throw new UnsupportedOperationException("step must greater than zero : " + step);
                }
                return new RangeSegement(start, end, step);
            }
            throw new UnsupportedOperationException();
        }
    }

    static class SelfSegement implements Segement {
        public static final SelfSegement instance = new SelfSegement();

        SelfSegement() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath path, Object rootObject, Object currentObject) {
            return currentObject;
        }
    }

    static class SizeSegement implements Segement {
        public static final SizeSegement instance = new SizeSegement();

        SizeSegement() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Integer eval(JSONPath path, Object rootObject, Object currentObject) {
            return Integer.valueOf(path.evalSize(currentObject));
        }
    }

    static class PropertySegement implements Segement {
        private final String propertyName;

        public PropertySegement(String propertyName) {
            this.propertyName = propertyName;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath path, Object rootObject, Object currentObject) {
            return path.getPropertyValue(currentObject, this.propertyName, true);
        }

        public void setValue(JSONPath path, Object parent, Object value) {
            path.setPropertyValue(parent, this.propertyName, value);
        }
    }

    static class MultiPropertySegement implements Segement {
        private final String[] propertyNames;

        public MultiPropertySegement(String[] propertyNames) {
            this.propertyNames = propertyNames;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath path, Object rootObject, Object currentObject) {
            List<Object> fieldValues = new ArrayList<>(this.propertyNames.length);
            for (String propertyName : this.propertyNames) {
                Object fieldValue = path.getPropertyValue(currentObject, propertyName, true);
                fieldValues.add(fieldValue);
            }
            return fieldValues;
        }
    }

    static class WildCardSegement implements Segement {
        public static WildCardSegement instance = new WildCardSegement();

        WildCardSegement() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath path, Object rootObject, Object currentObject) {
            return path.getPropertyValues(currentObject);
        }
    }

    static class ArrayAccessSegement implements Segement {
        private final int index;

        public ArrayAccessSegement(int index) {
            this.index = index;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath path, Object rootObject, Object currentObject) {
            return path.getArrayItem(currentObject, this.index);
        }

        public boolean setValue(JSONPath path, Object currentObject, Object value) {
            return path.setArrayItem(path, currentObject, this.index, value);
        }
    }

    static class MultiIndexSegement implements Segement {
        private final int[] indexes;

        public MultiIndexSegement(int[] indexes) {
            this.indexes = indexes;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath path, Object rootObject, Object currentObject) {
            List<Object> items = new ArrayList<>(this.indexes.length);
            for (int i = 0; i < this.indexes.length; i++) {
                Object item = path.getArrayItem(currentObject, this.indexes[i]);
                items.add(item);
            }
            return items;
        }
    }

    static class RangeSegement implements Segement {
        private final int end;
        private final int start;
        private final int step;

        public RangeSegement(int start, int end, int step) {
            this.start = start;
            this.end = end;
            this.step = step;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath path, Object rootObject, Object currentObject) {
            int size = SizeSegement.instance.eval(path, rootObject, currentObject).intValue();
            int start = this.start >= 0 ? this.start : this.start + size;
            int end = this.end >= 0 ? this.end : this.end + size;
            List<Object> items = new ArrayList<>(((end - start) / this.step) + 1);
            int i = start;
            while (i <= end && i < size) {
                Object item = path.getArrayItem(currentObject, i);
                items.add(item);
                i += this.step;
            }
            return items;
        }
    }

    static class NotNullSegement implements Filter {
        private final String propertyName;

        public NotNullSegement(String propertyName) {
            this.propertyName = propertyName;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath path, Object rootObject, Object currentObject, Object item) {
            Object propertyValue = path.getPropertyValue(item, this.propertyName, false);
            return propertyValue != null;
        }
    }

    static class NullSegement implements Filter {
        private final String propertyName;

        public NullSegement(String propertyName) {
            this.propertyName = propertyName;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath path, Object rootObject, Object currentObject, Object item) {
            Object propertyValue = path.getPropertyValue(item, this.propertyName, false);
            return propertyValue == null;
        }
    }

    static class IntInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final long[] values;

        public IntInSegement(String propertyName, long[] values, boolean not) {
            this.propertyName = propertyName;
            this.values = values;
            this.not = not;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath path, Object rootObject, Object currentObject, Object item) {
            Object propertyValue = path.getPropertyValue(item, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            if (propertyValue instanceof Number) {
                long longPropertyValue = ((Number) propertyValue).longValue();
                for (long value : this.values) {
                    if (value == longPropertyValue) {
                        return !this.not;
                    }
                }
            }
            return this.not;
        }
    }

    static class IntBetweenSegement implements Filter {
        private final long endValue;
        private final boolean not;
        private final String propertyName;
        private final long startValue;

        public IntBetweenSegement(String propertyName, long startValue, long endValue, boolean not) {
            this.propertyName = propertyName;
            this.startValue = startValue;
            this.endValue = endValue;
            this.not = not;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath path, Object rootObject, Object currentObject, Object item) {
            Object propertyValue = path.getPropertyValue(item, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            if (propertyValue instanceof Number) {
                long longPropertyValue = ((Number) propertyValue).longValue();
                if (longPropertyValue >= this.startValue && longPropertyValue <= this.endValue) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    static class IntObjInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final Long[] values;

        public IntObjInSegement(String propertyName, Long[] values, boolean not) {
            this.propertyName = propertyName;
            this.values = values;
            this.not = not;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath path, Object rootObject, Object currentObject, Object item) {
            Object propertyValue = path.getPropertyValue(item, this.propertyName, false);
            if (propertyValue == null) {
                for (Long l : this.values) {
                    if (l == null) {
                        return !this.not;
                    }
                }
                return this.not;
            }
            if (propertyValue instanceof Number) {
                long longPropertyValue = ((Number) propertyValue).longValue();
                for (Long value : this.values) {
                    if (value != null && value.longValue() == longPropertyValue) {
                        return !this.not;
                    }
                }
            }
            return this.not;
        }
    }

    static class StringInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final String[] values;

        public StringInSegement(String propertyName, String[] values, boolean not) {
            this.propertyName = propertyName;
            this.values = values;
            this.not = not;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath path, Object rootObject, Object currentObject, Object item) {
            Object propertyValue = path.getPropertyValue(item, this.propertyName, false);
            for (String value : this.values) {
                if (value == propertyValue) {
                    return !this.not;
                }
                if (value != null && value.equals(propertyValue)) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    static class IntOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long value;

        public IntOpSegement(String propertyName, long value, Operator op) {
            this.propertyName = propertyName;
            this.value = value;
            this.op = op;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath path, Object rootObject, Object currentObject, Object item) {
            Object propertyValue = path.getPropertyValue(item, this.propertyName, false);
            if (propertyValue == null || !(propertyValue instanceof Number)) {
                return false;
            }
            long longValue = ((Number) propertyValue).longValue();
            if (this.op == Operator.EQ) {
                return longValue == this.value;
            }
            if (this.op == Operator.NE) {
                return longValue != this.value;
            }
            if (this.op == Operator.GE) {
                return longValue >= this.value;
            }
            if (this.op == Operator.GT) {
                return longValue > this.value;
            }
            if (this.op == Operator.LE) {
                return longValue <= this.value;
            }
            return this.op == Operator.LT && longValue < this.value;
        }
    }

    static class MatchSegement implements Filter {
        private final String[] containsValues;
        private final String endsWithValue;
        private final int minLength;
        private final boolean not;
        private final String propertyName;
        private final String startsWithValue;

        public MatchSegement(String propertyName, String startsWithValue, String endsWithValue, String[] containsValues, boolean not) {
            this.propertyName = propertyName;
            this.startsWithValue = startsWithValue;
            this.endsWithValue = endsWithValue;
            this.containsValues = containsValues;
            this.not = not;
            int len = startsWithValue != null ? 0 + startsWithValue.length() : 0;
            len = endsWithValue != null ? len + endsWithValue.length() : len;
            if (containsValues != null) {
                for (String item : containsValues) {
                    len += item.length();
                }
            }
            this.minLength = len;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath path, Object rootObject, Object currentObject, Object item) {
            Object propertyValue = path.getPropertyValue(item, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            String strPropertyValue = propertyValue.toString();
            if (strPropertyValue.length() < this.minLength) {
                return this.not;
            }
            int start = 0;
            if (this.startsWithValue != null) {
                if (strPropertyValue.startsWith(this.startsWithValue)) {
                    start = 0 + this.startsWithValue.length();
                } else {
                    return this.not;
                }
            }
            if (this.containsValues != null) {
                for (String containsValue : this.containsValues) {
                    int index = strPropertyValue.indexOf(containsValue, start);
                    if (index == -1) {
                        return this.not;
                    }
                    start = index + containsValue.length();
                }
            }
            if (this.endsWithValue == null || strPropertyValue.endsWith(this.endsWithValue)) {
                return !this.not;
            }
            return this.not;
        }
    }

    static class RlikeSegement implements Filter {
        private final boolean not;
        private final Pattern pattern;
        private final String propertyName;

        public RlikeSegement(String propertyName, String pattern, boolean not) {
            this.propertyName = propertyName;
            this.pattern = Pattern.compile(pattern);
            this.not = not;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath path, Object rootObject, Object currentObject, Object item) {
            Object propertyValue = path.getPropertyValue(item, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            String strPropertyValue = propertyValue.toString();
            Matcher m = this.pattern.matcher(strPropertyValue);
            boolean match = m.matches();
            if (this.not) {
                match = !match;
            }
            return match;
        }
    }

    static class StringOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final String value;

        public StringOpSegement(String propertyName, String value, Operator op) {
            this.propertyName = propertyName;
            this.value = value;
            this.op = op;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath path, Object rootObject, Object currentObject, Object item) {
            Object propertyValue = path.getPropertyValue(item, this.propertyName, false);
            if (this.op == Operator.EQ) {
                return this.value.equals(propertyValue);
            }
            if (this.op == Operator.NE) {
                return !this.value.equals(propertyValue);
            }
            if (propertyValue == null) {
                return false;
            }
            int compareResult = this.value.compareTo(propertyValue.toString());
            if (this.op == Operator.GE) {
                return compareResult <= 0;
            }
            if (this.op == Operator.GT) {
                return compareResult < 0;
            }
            if (this.op == Operator.LE) {
                return compareResult >= 0;
            }
            return this.op == Operator.LT && compareResult > 0;
        }
    }

    public static class FilterSegement implements Segement {
        private final Filter filter;

        public FilterSegement(Filter filter) {
            this.filter = filter;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath path, Object rootObject, Object currentObject) {
            if (currentObject == null) {
                return null;
            }
            List<Object> items = new ArrayList<>();
            if (currentObject instanceof Iterable) {
                for (Object item : (Iterable) currentObject) {
                    if (this.filter.apply(path, rootObject, currentObject, item)) {
                        items.add(item);
                    }
                }
                return items;
            }
            if (this.filter.apply(path, rootObject, currentObject, currentObject)) {
                return currentObject;
            }
            return null;
        }
    }

    protected Object getArrayItem(Object currentObject, int index) {
        if (currentObject == null) {
            return null;
        }
        if (currentObject instanceof List) {
            List list = (List) currentObject;
            if (index >= 0) {
                if (index < list.size()) {
                    return list.get(index);
                }
                return null;
            }
            if (Math.abs(index) <= list.size()) {
                return list.get(list.size() + index);
            }
            return null;
        }
        if (currentObject.getClass().isArray()) {
            int arrayLenth = Array.getLength(currentObject);
            if (index >= 0) {
                if (index < arrayLenth) {
                    return Array.get(currentObject, index);
                }
                return null;
            }
            if (Math.abs(index) <= arrayLenth) {
                return Array.get(currentObject, arrayLenth + index);
            }
            return null;
        }
        throw new UnsupportedOperationException();
    }

    public boolean setArrayItem(JSONPath path, Object currentObject, int index, Object value) {
        if (currentObject instanceof List) {
            List list = (List) currentObject;
            if (index >= 0) {
                list.set(index, value);
            } else {
                list.set(list.size() + index, value);
            }
        } else if (currentObject.getClass().isArray()) {
            int arrayLenth = Array.getLength(currentObject);
            if (index >= 0) {
                if (index < arrayLenth) {
                    Array.set(currentObject, index, value);
                }
            } else if (Math.abs(index) <= arrayLenth) {
                Array.set(currentObject, arrayLenth + index, value);
            }
        } else {
            throw new UnsupportedOperationException();
        }
        return true;
    }

    protected Collection<Object> getPropertyValues(Object currentObject) {
        Class<?> currentClass = currentObject.getClass();
        JavaBeanSerializer beanSerializer = getJavaBeanSerializer(currentClass);
        if (beanSerializer != null) {
            try {
                return beanSerializer.getFieldValues(currentObject);
            } catch (Exception e) {
                throw new JSONPathException("jsonpath error, path " + this.path, e);
            }
        }
        if (currentObject instanceof Map) {
            Map map = (Map) currentObject;
            return map.values();
        }
        throw new UnsupportedOperationException();
    }

    static boolean eq(Object a, Object b) {
        if (a == b) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.getClass() == b.getClass()) {
            return a.equals(b);
        }
        if (a instanceof Number) {
            if (b instanceof Number) {
                return eqNotNull((Number) a, (Number) b);
            }
            return false;
        }
        return a.equals(b);
    }

    static boolean eqNotNull(Number a, Number b) {
        Class<?> cls = a.getClass();
        boolean isIntA = isInt(cls);
        Class<?> cls2 = a.getClass();
        boolean isIntB = isInt(cls2);
        if (isIntA && isIntB) {
            return a.longValue() == b.longValue();
        }
        boolean isDoubleA = isDouble(cls);
        boolean isDoubleB = isDouble(cls2);
        if ((isDoubleA && isDoubleB) || ((isDoubleA && isIntA) || (isDoubleB && isIntA))) {
            return a.doubleValue() == b.doubleValue();
        }
        return false;
    }

    protected static boolean isDouble(Class<?> clazzA) {
        return clazzA == Float.class || clazzA == Double.class;
    }

    protected static boolean isInt(Class<?> clazzA) {
        return clazzA == Byte.class || clazzA == Short.class || clazzA == Integer.class || clazzA == Long.class;
    }

    protected Object getPropertyValue(Object currentObject, String propertyName, boolean strictMode) {
        if (currentObject == null) {
            return null;
        }
        if (currentObject instanceof Map) {
            Map map = (Map) currentObject;
            return map.get(propertyName);
        }
        Class<?> currentClass = currentObject.getClass();
        JavaBeanSerializer beanSerializer = getJavaBeanSerializer(currentClass);
        if (beanSerializer != null) {
            try {
                return beanSerializer.getFieldValue(currentObject, propertyName);
            } catch (Exception e) {
                throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + propertyName, e);
            }
        }
        if (currentObject instanceof List) {
            List list = (List) currentObject;
            List<Object> fieldValues = new ArrayList<>(list.size());
            for (int i = 0; i < list.size(); i++) {
                Object obj = list.get(i);
                Object itemValue = getPropertyValue(obj, propertyName, strictMode);
                fieldValues.add(itemValue);
            }
            return fieldValues;
        }
        throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + propertyName);
    }

    protected boolean setPropertyValue(Object parent, String name, Object value) {
        if (parent instanceof Map) {
            ((Map) parent).put(name, value);
            return true;
        }
        if (parent instanceof List) {
            for (Object element : (List) parent) {
                if (element != null) {
                    setPropertyValue(element, name, value);
                }
            }
            return true;
        }
        ObjectDeserializer derializer = this.parserConfig.getDeserializer(parent.getClass());
        JavaBeanDeserializer beanDerializer = null;
        if (derializer instanceof JavaBeanDeserializer) {
            beanDerializer = (JavaBeanDeserializer) derializer;
        } else if (derializer instanceof ASMJavaBeanDeserializer) {
            beanDerializer = ((ASMJavaBeanDeserializer) derializer).getInnterSerializer();
        }
        if (beanDerializer != null) {
            FieldDeserializer fieldDeserializer = beanDerializer.getFieldDeserializer(name);
            if (fieldDeserializer == null) {
                return false;
            }
            fieldDeserializer.setValue(parent, value);
            return true;
        }
        throw new UnsupportedOperationException();
    }

    protected JavaBeanSerializer getJavaBeanSerializer(Class<?> currentClass) {
        ObjectSerializer serializer = this.serializeConfig.getObjectWriter(currentClass);
        if (serializer instanceof JavaBeanSerializer) {
            JavaBeanSerializer beanSerializer = (JavaBeanSerializer) serializer;
            return beanSerializer;
        }
        if (!(serializer instanceof ASMJavaBeanSerializer)) {
            return null;
        }
        JavaBeanSerializer beanSerializer2 = ((ASMJavaBeanSerializer) serializer).getJavaBeanSerializer();
        return beanSerializer2;
    }

    int evalSize(Object currentObject) {
        if (currentObject == null) {
            return -1;
        }
        if (currentObject instanceof Collection) {
            return ((Collection) currentObject).size();
        }
        if (currentObject instanceof Object[]) {
            return ((Object[]) currentObject).length;
        }
        if (currentObject.getClass().isArray()) {
            return Array.getLength(currentObject);
        }
        if (currentObject instanceof Map) {
            int count = 0;
            for (Object value : ((Map) currentObject).values()) {
                if (value != null) {
                    count++;
                }
            }
            return count;
        }
        JavaBeanSerializer beanSerializer = getJavaBeanSerializer(currentObject.getClass());
        if (beanSerializer == null) {
            return -1;
        }
        try {
            List<Object> values = beanSerializer.getFieldValues(currentObject);
            int count2 = 0;
            for (int i = 0; i < values.size(); i++) {
                if (values.get(i) != null) {
                    count2++;
                }
            }
            return count2;
        } catch (Exception e) {
            throw new JSONException("evalSize error : " + this.path, e);
        }
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        serializer.write(this.path);
    }
}
