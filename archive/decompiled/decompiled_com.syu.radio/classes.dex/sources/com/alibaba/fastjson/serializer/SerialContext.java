package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class SerialContext {
    private int features;
    private int fieldFeatures;
    private final Object fieldName;
    private final Object object;
    private final SerialContext parent;

    public SerialContext(SerialContext parent, Object object, Object fieldName, int features, int fieldFeatures) {
        this.parent = parent;
        this.object = object;
        this.fieldName = fieldName;
        this.features = features;
        this.fieldFeatures = fieldFeatures;
    }

    public SerialContext getParent() {
        return this.parent;
    }

    public Object getObject() {
        return this.object;
    }

    public Object getFieldName() {
        return this.fieldName;
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

    public int getFeatures() {
        return this.features;
    }

    public boolean isEnabled(SerializerFeature feature) {
        return SerializerFeature.isEnabled(this.features, this.fieldFeatures, feature);
    }
}
