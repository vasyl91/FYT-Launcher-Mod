package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XmlAnySimpleTypeImpl extends XmlObjectBase implements XmlAnySimpleType {
    private SchemaType _schemaType;
    String _textvalue;

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int get_wscanon_rule() {
        return 1;
    }

    public XmlAnySimpleTypeImpl(SchemaType schemaType, boolean z) {
        this._textvalue = "";
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    public XmlAnySimpleTypeImpl() {
        this._textvalue = "";
        this._schemaType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected String compute_text(NamespaceManager namespaceManager) {
        return this._textvalue;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        this._textvalue = str;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._textvalue = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        return this._textvalue.equals(((XmlAnySimpleType) xmlObject).getStringValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        String str = this._textvalue;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }
}
