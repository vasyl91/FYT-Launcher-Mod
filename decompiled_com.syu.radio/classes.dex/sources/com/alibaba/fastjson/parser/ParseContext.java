package com.alibaba.fastjson.parser;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ParseContext {
    private final Object fieldName;
    private Object object;
    private final ParseContext parent;
    private Type type;

    public ParseContext(ParseContext parent, Object object, Object fieldName) {
        this.parent = parent;
        this.object = object;
        this.fieldName = fieldName;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Object getObject() {
        return this.object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public ParseContext getParentContext() {
        return this.parent;
    }

    public String getPath() {
        if (this.parent == null) {
            return "$";
        }
        if (this.fieldName instanceof Integer) {
            return String.valueOf(this.parent.getPath()) + "[" + this.fieldName + "]";
        }
        return String.valueOf(this.parent.getPath()) + "." + this.fieldName;
    }

    public String toString() {
        return getPath();
    }
}
