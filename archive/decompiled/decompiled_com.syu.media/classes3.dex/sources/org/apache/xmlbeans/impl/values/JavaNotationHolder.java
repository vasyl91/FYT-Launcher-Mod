package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class JavaNotationHolder extends XmlQNameImpl {
    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_NOTATION;
    }
}
