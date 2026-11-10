package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTField;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTFieldImpl extends XmlComplexContentImpl implements CTField {
    private static final QName X$0 = new QName("", "x");

    public CTFieldImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTField
    public int getX() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(X$0);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTField
    public void setX(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = X$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTField
    public XmlInt xgetX() {
        XmlInt xmlIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIntFind_attribute_user = get_store().find_attribute_user(X$0);
        }
        return xmlIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTField
    public void xsetX(XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = X$0;
            XmlInt xmlIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIntFind_attribute_user == null) {
                xmlIntFind_attribute_user = (XmlInt) get_store().add_attribute_user(qName);
            }
            xmlIntFind_attribute_user.set(xmlInt);
        }
    }
}
