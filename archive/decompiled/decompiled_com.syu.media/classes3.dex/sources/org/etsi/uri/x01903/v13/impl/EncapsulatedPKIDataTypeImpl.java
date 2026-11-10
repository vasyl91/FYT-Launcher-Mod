package org.etsi.uri.x01903.v13.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.JavaBase64HolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.etsi.uri.x01903.v13.EncapsulatedPKIDataType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class EncapsulatedPKIDataTypeImpl extends JavaBase64HolderEx implements EncapsulatedPKIDataType {
    private static final QName ID$0 = new QName("", "Id");
    private static final QName ENCODING$2 = new QName("", "Encoding");

    public EncapsulatedPKIDataTypeImpl(SchemaType schemaType) {
        super(schemaType, true);
    }

    protected EncapsulatedPKIDataTypeImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public String getEncoding() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ENCODING$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public boolean isSetEncoding() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ENCODING$2) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$0) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public void setEncoding(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCODING$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public void unsetEncoding() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ENCODING$2);
        }
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public XmlAnyURI xgetEncoding() {
        XmlAnyURI xmlAnyURIFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURIFind_attribute_user = get_store().find_attribute_user(ENCODING$2);
        }
        return xmlAnyURIFind_attribute_user;
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public XmlID xgetId() {
        XmlID xmlIDFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIDFind_attribute_user = get_store().find_attribute_user(ID$0);
        }
        return xmlIDFind_attribute_user;
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public void xsetEncoding(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCODING$2;
            XmlAnyURI xmlAnyURIFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlAnyURIFind_attribute_user == null) {
                xmlAnyURIFind_attribute_user = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURIFind_attribute_user.set(xmlAnyURI);
        }
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public void xsetId(XmlID xmlID) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$0;
            XmlID xmlIDFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIDFind_attribute_user == null) {
                xmlIDFind_attribute_user = (XmlID) get_store().add_attribute_user(qName);
            }
            xmlIDFind_attribute_user.set(xmlID);
        }
    }
}
