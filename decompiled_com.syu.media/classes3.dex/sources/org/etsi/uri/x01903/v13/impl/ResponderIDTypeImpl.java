package org.etsi.uri.x01903.v13.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.ResponderIDType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ResponderIDTypeImpl extends XmlComplexContentImpl implements ResponderIDType {
    private static final QName BYNAME$0 = new QName("http://uri.etsi.org/01903/v1.3.2#", "ByName");
    private static final QName BYKEY$2 = new QName("http://uri.etsi.org/01903/v1.3.2#", "ByKey");

    public ResponderIDTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public byte[] getByKey() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(BYKEY$2, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getByteArrayValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public String getByName() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(BYNAME$0, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public boolean isSetByKey() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BYKEY$2) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public boolean isSetByName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BYNAME$0) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public void setByKey(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BYKEY$2;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public void setByName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BYNAME$0;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public void unsetByKey() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BYKEY$2, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public void unsetByName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BYNAME$0, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public XmlBase64Binary xgetByKey() {
        XmlBase64Binary xmlBase64BinaryFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_element_user = get_store().find_element_user(BYKEY$2, 0);
        }
        return xmlBase64BinaryFind_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public XmlString xgetByName() {
        XmlString xmlStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlStringFind_element_user = get_store().find_element_user(BYNAME$0, 0);
        }
        return xmlStringFind_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public void xsetByKey(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BYKEY$2;
            XmlBase64Binary xmlBase64BinaryFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlBase64BinaryFind_element_user == null) {
                xmlBase64BinaryFind_element_user = (XmlBase64Binary) get_store().add_element_user(qName);
            }
            xmlBase64BinaryFind_element_user.set(xmlBase64Binary);
        }
    }

    @Override // org.etsi.uri.x01903.v13.ResponderIDType
    public void xsetByName(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BYNAME$0;
            XmlString xmlStringFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlStringFind_element_user == null) {
                xmlStringFind_element_user = (XmlString) get_store().add_element_user(qName);
            }
            xmlStringFind_element_user.set(xmlString);
        }
    }
}
