package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class JavaStringHolder extends XmlObjectBase {
    private String _value;

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int get_wscanon_rule() {
        return 1;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean is_defaultable_ws(String str) {
        return false;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_STRING;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        this._value = str;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        return this._value.equals(((XmlObjectBase) xmlObject).stringValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        return this._value.hashCode();
    }
}
