package org.apache.xmlbeans.impl.inst2xsd.util;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Attribute {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private QName _name;
    private Type _type;
    private Attribute _ref = null;
    private boolean _isGlobal = false;
    private boolean _isOptional = false;

    public QName getName() {
        return this._name;
    }

    public void setName(QName qName) {
        this._name = qName;
    }

    public Type getType() {
        return isRef() ? getRef().getType() : this._type;
    }

    public void setType(Type type) {
        this._type = type;
    }

    public boolean isRef() {
        return this._ref != null;
    }

    public Attribute getRef() {
        return this._ref;
    }

    public void setRef(Attribute attribute) {
        this._ref = attribute;
        this._type = null;
    }

    public boolean isGlobal() {
        return this._isGlobal;
    }

    public void setGlobal(boolean z) {
        this._isGlobal = z;
    }

    public boolean isOptional() {
        return this._isOptional;
    }

    public void setOptional(boolean z) {
        this._isOptional = z;
    }

    public String toString() {
        return "\n    Attribute{_name=" + this._name + ", _type=" + this._type + ", _ref=" + (this._ref != null) + ", _isGlobal=" + this._isGlobal + ", _isOptional=" + this._isOptional + "}";
    }
}
