package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTUnderlineProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STUnderlineValues;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTUnderlinePropertyImpl extends XmlComplexContentImpl implements CTUnderlineProperty {
    private static final QName VAL$0 = new QName("", "val");

    public CTUnderlinePropertyImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTUnderlineProperty
    public STUnderlineValues.Enum getVal() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STUnderlineValues.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTUnderlineProperty
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VAL$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTUnderlineProperty
    public void setVal(STUnderlineValues.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTUnderlineProperty
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VAL$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTUnderlineProperty
    public STUnderlineValues xgetVal() {
        STUnderlineValues sTUnderlineValues;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            sTUnderlineValues = (STUnderlineValues) typeStore.find_attribute_user(qName);
            if (sTUnderlineValues == null) {
                sTUnderlineValues = (STUnderlineValues) get_default_attribute_value(qName);
            }
        }
        return sTUnderlineValues;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTUnderlineProperty
    public void xsetVal(STUnderlineValues sTUnderlineValues) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STUnderlineValues sTUnderlineValues2 = (STUnderlineValues) typeStore.find_attribute_user(qName);
            if (sTUnderlineValues2 == null) {
                sTUnderlineValues2 = (STUnderlineValues) get_store().add_attribute_user(qName);
            }
            sTUnderlineValues2.set((XmlObject) sTUnderlineValues);
        }
    }
}
