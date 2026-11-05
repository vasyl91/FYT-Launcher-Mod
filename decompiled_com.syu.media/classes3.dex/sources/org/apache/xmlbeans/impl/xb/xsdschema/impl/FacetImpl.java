package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.Facet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class FacetImpl extends AnnotatedImpl implements Facet {
    private static final long serialVersionUID = 1;
    private static final QName VALUE$0 = new QName("", "value");
    private static final QName FIXED$2 = new QName("", "fixed");

    public FacetImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Facet
    public XmlAnySimpleType getValue() {
        synchronized (monitor()) {
            check_orphaned();
            XmlAnySimpleType xmlAnySimpleTypeFind_attribute_user = get_store().find_attribute_user(VALUE$0);
            if (xmlAnySimpleTypeFind_attribute_user == null) {
                return null;
            }
            return xmlAnySimpleTypeFind_attribute_user;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Facet
    public void setValue(XmlAnySimpleType xmlAnySimpleType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VALUE$0;
            XmlAnySimpleType xmlAnySimpleTypeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlAnySimpleTypeFind_attribute_user == null) {
                xmlAnySimpleTypeFind_attribute_user = (XmlAnySimpleType) get_store().add_attribute_user(qName);
            }
            xmlAnySimpleTypeFind_attribute_user.set(xmlAnySimpleType);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Facet
    public XmlAnySimpleType addNewValue() {
        XmlAnySimpleType xmlAnySimpleTypeAdd_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnySimpleTypeAdd_attribute_user = get_store().add_attribute_user(VALUE$0);
        }
        return xmlAnySimpleTypeAdd_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Facet
    public boolean getFixed() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIXED$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Facet
    public XmlBoolean xgetFixed() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIXED$2;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Facet
    public boolean isSetFixed() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FIXED$2) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Facet
    public void setFixed(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIXED$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Facet
    public void xsetFixed(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIXED$2;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Facet
    public void unsetFixed() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FIXED$2);
        }
    }
}
