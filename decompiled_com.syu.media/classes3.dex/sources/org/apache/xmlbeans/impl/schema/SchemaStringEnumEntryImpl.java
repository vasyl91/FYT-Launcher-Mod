package org.apache.xmlbeans.impl.schema;

import org.apache.xmlbeans.SchemaStringEnumEntry;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaStringEnumEntryImpl implements SchemaStringEnumEntry {
    private String _enumName;
    private int _int;
    private String _string;

    public SchemaStringEnumEntryImpl(String str, int i, String str2) {
        this._string = str;
        this._int = i;
        this._enumName = str2;
    }

    public String getString() {
        return this._string;
    }

    public int getIntValue() {
        return this._int;
    }

    public String getEnumName() {
        return this._enumName;
    }
}
