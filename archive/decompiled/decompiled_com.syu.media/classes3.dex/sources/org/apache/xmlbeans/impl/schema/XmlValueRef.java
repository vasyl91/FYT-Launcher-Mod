package org.apache.xmlbeans.impl.schema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XmlValueRef {
    Object _initVal;
    XmlAnySimpleType _obj;
    SchemaType.Ref _typeref;

    public XmlValueRef(XmlAnySimpleType xmlAnySimpleType) {
        if (xmlAnySimpleType == null) {
            throw new IllegalArgumentException();
        }
        this._obj = xmlAnySimpleType;
    }

    XmlValueRef(SchemaType.Ref ref, Object obj) {
        if (ref == null) {
            throw new IllegalArgumentException();
        }
        this._typeref = ref;
        this._initVal = obj;
    }

    synchronized XmlAnySimpleType get() {
        if (this._obj == null) {
            SchemaType schemaType = this._typeref.get();
            if (schemaType.getSimpleVariety() != 3) {
                this._obj = schemaType.newValue(this._initVal);
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((List) this._initVal).iterator();
                while (it.hasNext()) {
                    arrayList.add(((XmlValueRef) it.next()).get());
                }
                this._obj = schemaType.newValue(arrayList);
            }
        }
        return this._obj;
    }
}
