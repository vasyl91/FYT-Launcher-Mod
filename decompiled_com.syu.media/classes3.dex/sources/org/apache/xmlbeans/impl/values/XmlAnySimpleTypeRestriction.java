package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XmlAnySimpleTypeRestriction extends XmlAnySimpleTypeImpl {
    private SchemaType _schemaType;

    public XmlAnySimpleTypeRestriction(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlAnySimpleTypeImpl, org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return this._schemaType;
    }
}
