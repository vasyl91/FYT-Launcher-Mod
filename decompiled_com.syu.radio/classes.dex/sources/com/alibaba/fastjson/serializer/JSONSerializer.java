package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JSONSerializer {
    private List<AfterFilter> afterFilters;
    private List<BeforeFilter> beforeFilters;
    private final SerializeConfig config;
    private SerialContext context;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private String indent;
    private int indentCount;
    private List<LabelFilter> labelFilters;
    private List<NameFilter> nameFilters;
    private final SerializeWriter out;
    private List<PropertyFilter> propertyFilters;
    private List<PropertyPreFilter> propertyPreFilters;
    private IdentityHashMap<Object, SerialContext> references;
    private List<ValueFilter> valueFilters;

    public JSONSerializer() {
        this(new SerializeWriter(), SerializeConfig.getGlobalInstance());
    }

    public JSONSerializer(SerializeWriter out) {
        this(out, SerializeConfig.getGlobalInstance());
    }

    public JSONSerializer(SerializeConfig config) {
        this(new SerializeWriter(), config);
    }

    @Deprecated
    public JSONSerializer(JSONSerializerMap mapping) {
        this(new SerializeWriter(), mapping);
    }

    public JSONSerializer(SerializeWriter out, SerializeConfig config) {
        this.beforeFilters = null;
        this.afterFilters = null;
        this.propertyFilters = null;
        this.valueFilters = null;
        this.nameFilters = null;
        this.propertyPreFilters = null;
        this.labelFilters = null;
        this.indentCount = 0;
        this.indent = "\t";
        this.references = null;
        this.out = out;
        this.config = config;
    }

    public String getDateFormatPattern() {
        return this.dateFormat instanceof SimpleDateFormat ? ((SimpleDateFormat) this.dateFormat).toPattern() : this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null && this.dateFormatPattern != null) {
            this.dateFormat = new SimpleDateFormat(this.dateFormatPattern);
        }
        return this.dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
        if (this.dateFormatPattern != null) {
            this.dateFormatPattern = null;
        }
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormatPattern = dateFormat;
        if (this.dateFormat != null) {
            this.dateFormat = null;
        }
    }

    public SerialContext getContext() {
        return this.context;
    }

    public void setContext(SerialContext context) {
        this.context = context;
    }

    public void setContext(SerialContext parent, Object object, Object fieldName, int features) {
        setContext(parent, object, fieldName, features, 0);
    }

    public void setContext(SerialContext parent, Object object, Object fieldName, int features, int fieldFeatures) {
        if (!isEnabled(SerializerFeature.DisableCircularReferenceDetect)) {
            this.context = new SerialContext(parent, object, fieldName, features, fieldFeatures);
            if (this.references == null) {
                this.references = new IdentityHashMap<>();
            }
            this.references.put(object, this.context);
        }
    }

    public void setContext(Object object, Object fieldName) {
        setContext(this.context, object, fieldName, 0);
    }

    public void popContext() {
        if (this.context != null) {
            this.context = this.context.getParent();
        }
    }

    public final boolean isWriteClassName(Type fieldType, Object obj) {
        boolean result = this.out.isEnabled(SerializerFeature.WriteClassName);
        if (!result) {
            return false;
        }
        if (fieldType == null && isEnabled(SerializerFeature.NotWriteRootClassName)) {
            boolean isRoot = this.context.getParent() == null;
            if (isRoot) {
                return false;
            }
        }
        return true;
    }

    public SerialContext getSerialContext(Object object) {
        if (this.references == null) {
            return null;
        }
        return this.references.get(object);
    }

    public boolean containsReference(Object value) {
        if (this.references == null) {
            return false;
        }
        return this.references.containsKey(value);
    }

    public void writeReference(Object object) {
        SerialContext context = getContext();
        Object current = context.getObject();
        if (object == current) {
            this.out.write("{\"$ref\":\"@\"}");
            return;
        }
        SerialContext parentContext = context.getParent();
        if (parentContext != null && object == parentContext.getObject()) {
            this.out.write("{\"$ref\":\"..\"}");
            return;
        }
        SerialContext rootContext = context;
        while (rootContext.getParent() != null) {
            rootContext = rootContext.getParent();
        }
        if (object == rootContext.getObject()) {
            this.out.write("{\"$ref\":\"$\"}");
            return;
        }
        SerialContext refContext = getSerialContext(object);
        String path = refContext.getPath();
        this.out.write("{\"$ref\":\"");
        this.out.write(path);
        this.out.write("\"}");
    }

    public List<ValueFilter> getValueFilters() {
        if (this.valueFilters == null) {
            this.valueFilters = new ArrayList();
        }
        return this.valueFilters;
    }

    public List<ValueFilter> getValueFiltersDirect() {
        return this.valueFilters;
    }

    public int getIndentCount() {
        return this.indentCount;
    }

    public void incrementIndent() {
        this.indentCount++;
    }

    public void decrementIdent() {
        this.indentCount--;
    }

    public void println() {
        this.out.write('\n');
        for (int i = 0; i < this.indentCount; i++) {
            this.out.write(this.indent);
        }
    }

    public List<BeforeFilter> getBeforeFilters() {
        if (this.beforeFilters == null) {
            this.beforeFilters = new ArrayList();
        }
        return this.beforeFilters;
    }

    public List<BeforeFilter> getBeforeFiltersDirect() {
        return this.beforeFilters;
    }

    public List<AfterFilter> getAfterFilters() {
        if (this.afterFilters == null) {
            this.afterFilters = new ArrayList();
        }
        return this.afterFilters;
    }

    public List<AfterFilter> getAfterFiltersDirect() {
        return this.afterFilters;
    }

    public List<NameFilter> getNameFilters() {
        if (this.nameFilters == null) {
            this.nameFilters = new ArrayList();
        }
        return this.nameFilters;
    }

    public List<NameFilter> getNameFiltersDirect() {
        return this.nameFilters;
    }

    public List<PropertyPreFilter> getPropertyPreFilters() {
        if (this.propertyPreFilters == null) {
            this.propertyPreFilters = new ArrayList();
        }
        return this.propertyPreFilters;
    }

    public List<PropertyPreFilter> getPropertyPreFiltersDirect() {
        return this.propertyPreFilters;
    }

    public List<LabelFilter> getLabelFilters() {
        if (this.labelFilters == null) {
            this.labelFilters = new ArrayList();
        }
        return this.labelFilters;
    }

    public List<LabelFilter> getLabelFiltersDirect() {
        return this.labelFilters;
    }

    public List<PropertyFilter> getPropertyFilters() {
        if (this.propertyFilters == null) {
            this.propertyFilters = new ArrayList();
        }
        return this.propertyFilters;
    }

    public List<PropertyFilter> getPropertyFiltersDirect() {
        return this.propertyFilters;
    }

    public SerializeWriter getWriter() {
        return this.out;
    }

    public String toString() {
        return this.out.toString();
    }

    public void config(SerializerFeature feature, boolean state) {
        this.out.config(feature, state);
    }

    public boolean isEnabled(SerializerFeature feature) {
        return this.out.isEnabled(feature);
    }

    public void writeNull() {
        this.out.writeNull();
    }

    public SerializeConfig getMapping() {
        return this.config;
    }

    public static void write(Writer out, Object object) {
        SerializeWriter writer = new SerializeWriter();
        try {
            try {
                JSONSerializer serializer = new JSONSerializer(writer);
                serializer.write(object);
                writer.writeTo(out);
                writer.close();
            } catch (IOException ex) {
                throw new JSONException(ex.getMessage(), ex);
            }
        } catch (Throwable th) {
            writer.close();
            throw th;
        }
    }

    public static void write(SerializeWriter out, Object object) {
        JSONSerializer serializer = new JSONSerializer(out);
        serializer.write(object);
    }

    public final void write(Object object) {
        if (object == null) {
            this.out.writeNull();
            return;
        }
        Class<?> clazz = object.getClass();
        ObjectSerializer writer = getObjectWriter(clazz);
        try {
            writer.write(this, object, null, null, 0);
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public final void writeWithFieldName(Object object, Object fieldName) {
        writeWithFieldName(object, fieldName, null, 0);
    }

    protected final void writeKeyValue(char seperator, String key, Object value) {
        if (seperator != 0) {
            this.out.write(seperator);
        }
        this.out.writeFieldName(key);
        write(value);
    }

    public final void writeWithFieldName(Object object, Object fieldName, Type fieldType, int fieldFeatures) {
        try {
            if (object == null) {
                this.out.writeNull();
            } else {
                Class<?> clazz = object.getClass();
                ObjectSerializer writer = getObjectWriter(clazz);
                writer.write(this, object, fieldName, fieldType, fieldFeatures);
            }
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public final void writeWithFormat(Object object, String format) {
        if (object instanceof Date) {
            DateFormat dateFormat = getDateFormat();
            if (dateFormat == null) {
                dateFormat = new SimpleDateFormat(format);
            }
            String text = dateFormat.format((Date) object);
            this.out.writeString(text);
            return;
        }
        write(object);
    }

    public final void write(String text) {
        StringCodec.instance.write(this, text);
    }

    public ObjectSerializer getObjectWriter(Class<?> clazz) {
        return this.config.getObjectWriter(clazz);
    }

    public void close() {
        this.out.close();
    }
}
