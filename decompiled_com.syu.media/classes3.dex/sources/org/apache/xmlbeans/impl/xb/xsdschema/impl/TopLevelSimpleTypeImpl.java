package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class TopLevelSimpleTypeImpl extends SimpleTypeImpl implements TopLevelSimpleType {
    private static final QName NAME$0 = new QName("", "name");
    private static final long serialVersionUID = 1;

    public TopLevelSimpleTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.SimpleTypeImpl, org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public String getName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(NAME$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.SimpleTypeImpl, org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public XmlNCName xgetName() {
        XmlNCName xmlNCNameFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlNCNameFind_attribute_user = get_store().find_attribute_user(NAME$0);
        }
        return xmlNCNameFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.SimpleTypeImpl, org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$0) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.SimpleTypeImpl, org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.SimpleTypeImpl, org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void xsetName(XmlNCName xmlNCName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$0;
            XmlNCName xmlNCNameFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlNCNameFind_attribute_user == null) {
                xmlNCNameFind_attribute_user = (XmlNCName) get_store().add_attribute_user(qName);
            }
            xmlNCNameFind_attribute_user.set(xmlNCName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.SimpleTypeImpl, org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$0);
        }
    }
}
