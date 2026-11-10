package org.apache.xmlbeans.impl.inst2xsd;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Inst2XsdOptions {
    public static final int DESIGN_RUSSIAN_DOLL = 1;
    public static final int DESIGN_SALAMI_SLICE = 2;
    public static final int DESIGN_VENETIAN_BLIND = 3;
    public static final int ENUMERATION_NEVER = 1;
    public static final int ENUMERATION_NOT_MORE_THAN_DEFAULT = 10;
    public static final int SIMPLE_CONTENT_TYPES_SMART = 1;
    public static final int SIMPLE_CONTENT_TYPES_STRING = 2;
    private int _design = 3;
    private int _simpleContentTypes = 1;
    private int _enumerations = 10;
    private boolean _verbose = false;

    public int getDesign() {
        return this._design;
    }

    public void setDesign(int i) {
        if (i != 1 && i != 2 && i != 3) {
            throw new IllegalArgumentException("Unknown value for design type.");
        }
        this._design = i;
    }

    public boolean isUseEnumerations() {
        return this._enumerations > 1;
    }

    public int getUseEnumerations() {
        return this._enumerations;
    }

    public void setUseEnumerations(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("UseEnumerations must be set to a value bigger than 1");
        }
        this._enumerations = i;
    }

    public int getSimpleContentTypes() {
        return this._simpleContentTypes;
    }

    public void setSimpleContentTypes(int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("Unknown value for simpleContentTypes.");
        }
        this._simpleContentTypes = i;
    }

    public boolean isVerbose() {
        return this._verbose;
    }

    public void setVerbose(boolean z) {
        this._verbose = z;
    }
}
