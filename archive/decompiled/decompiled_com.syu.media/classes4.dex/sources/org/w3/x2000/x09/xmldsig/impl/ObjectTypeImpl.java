package org.w3.x2000.x09.xmldsig.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.w3.x2000.x09.xmldsig.ObjectType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class ObjectTypeImpl extends XmlComplexContentImpl implements ObjectType {
    private static final QName ID$0 = new QName("", "Id");
    private static final QName MIMETYPE$2 = new QName("", "MimeType");
    private static final QName ENCODING$4 = new QName("", "Encoding");

    public ObjectTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.w3.x2000.x09.xmldsig.ObjectType
    public String getEncoding() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ENCODING$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ObjectType
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

    @Override // org.w3.x2000.x09.xmldsig.ObjectType
    public String getMimeType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(MIMETYPE$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ObjectType
    public boolean isSetEncoding() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ENCODING$4) != null;
        }
        return z;
    }

    @Override // org.w3.x2000.x09.xmldsig.ObjectType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$0) != null;
        }
        return z;
    }

    @Override // org.w3.x2000.x09.xmldsig.ObjectType
    public boolean isSetMimeType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MIMETYPE$2) != null;
        }
        return z;
    }

    @Override // org.w3.x2000.x09.xmldsig.ObjectType
    public void setEncoding(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCODING$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ObjectType
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

    @Override // org.w3.x2000.x09.xmldsig.ObjectType
    public void setMimeType(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MIMETYPE$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ObjectType
    public void unsetEncoding() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ENCODING$4);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ObjectType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$0);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ObjectType
    public void unsetMimeType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MIMETYPE$2);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ObjectType
    public XmlAnyURI xgetEncoding() {
        XmlAnyURI xmlAnyURIFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURIFind_attribute_user = get_store().find_attribute_user(ENCODING$4);
        }
        return xmlAnyURIFind_attribute_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.ObjectType
    public XmlID xgetId() {
        XmlID xmlIDFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIDFind_attribute_user = get_store().find_attribute_user(ID$0);
        }
        return xmlIDFind_attribute_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.ObjectType
    public XmlString xgetMimeType() {
        XmlString xmlStringFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_attribute_user = get_store().find_attribute_user(MIMETYPE$2);
        }
        return xmlStringFind_attribute_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.ObjectType
    public void xsetEncoding(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCODING$4;
            XmlAnyURI xmlAnyURIFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlAnyURIFind_attribute_user == null) {
                xmlAnyURIFind_attribute_user = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURIFind_attribute_user.set(xmlAnyURI);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ObjectType
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

    @Override // org.w3.x2000.x09.xmldsig.ObjectType
    public void xsetMimeType(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MIMETYPE$2;
            XmlString xmlStringFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlStringFind_attribute_user == null) {
                xmlStringFind_attribute_user = (XmlString) get_store().add_attribute_user(qName);
            }
            xmlStringFind_attribute_user.set(xmlString);
        }
    }
}
