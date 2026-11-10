package org.etsi.uri.x01903.v13.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.QualifyingPropertiesType;
import org.etsi.uri.x01903.v13.SignedPropertiesType;
import org.etsi.uri.x01903.v13.UnsignedPropertiesType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class QualifyingPropertiesTypeImpl extends XmlComplexContentImpl implements QualifyingPropertiesType {
    private static final QName SIGNEDPROPERTIES$0 = new QName("http://uri.etsi.org/01903/v1.3.2#", "SignedProperties");
    private static final QName UNSIGNEDPROPERTIES$2 = new QName("http://uri.etsi.org/01903/v1.3.2#", "UnsignedProperties");
    private static final QName TARGET$4 = new QName("", "Target");
    private static final QName ID$6 = new QName("", "Id");

    public QualifyingPropertiesTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public SignedPropertiesType addNewSignedProperties() {
        SignedPropertiesType signedPropertiesType;
        synchronized (monitor()) {
            check_orphaned();
            signedPropertiesType = (SignedPropertiesType) get_store().add_element_user(SIGNEDPROPERTIES$0);
        }
        return signedPropertiesType;
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public UnsignedPropertiesType addNewUnsignedProperties() {
        UnsignedPropertiesType unsignedPropertiesType;
        synchronized (monitor()) {
            check_orphaned();
            unsignedPropertiesType = (UnsignedPropertiesType) get_store().add_element_user(UNSIGNEDPROPERTIES$2);
        }
        return unsignedPropertiesType;
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$6);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public SignedPropertiesType getSignedProperties() {
        synchronized (monitor()) {
            check_orphaned();
            SignedPropertiesType signedPropertiesType = (SignedPropertiesType) get_store().find_element_user(SIGNEDPROPERTIES$0, 0);
            if (signedPropertiesType == null) {
                return null;
            }
            return signedPropertiesType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public String getTarget() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(TARGET$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public UnsignedPropertiesType getUnsignedProperties() {
        synchronized (monitor()) {
            check_orphaned();
            UnsignedPropertiesType unsignedPropertiesType = (UnsignedPropertiesType) get_store().find_element_user(UNSIGNEDPROPERTIES$2, 0);
            if (unsignedPropertiesType == null) {
                return null;
            }
            return unsignedPropertiesType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$6) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public boolean isSetSignedProperties() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIGNEDPROPERTIES$0) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public boolean isSetUnsignedProperties() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UNSIGNEDPROPERTIES$2) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public void setSignedProperties(SignedPropertiesType signedPropertiesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNEDPROPERTIES$0;
            SignedPropertiesType signedPropertiesType2 = (SignedPropertiesType) typeStore.find_element_user(qName, 0);
            if (signedPropertiesType2 == null) {
                signedPropertiesType2 = (SignedPropertiesType) get_store().add_element_user(qName);
            }
            signedPropertiesType2.set(signedPropertiesType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public void setTarget(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public void setUnsignedProperties(UnsignedPropertiesType unsignedPropertiesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UNSIGNEDPROPERTIES$2;
            UnsignedPropertiesType unsignedPropertiesType2 = (UnsignedPropertiesType) typeStore.find_element_user(qName, 0);
            if (unsignedPropertiesType2 == null) {
                unsignedPropertiesType2 = (UnsignedPropertiesType) get_store().add_element_user(qName);
            }
            unsignedPropertiesType2.set(unsignedPropertiesType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$6);
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public void unsetSignedProperties() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNEDPROPERTIES$0, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public void unsetUnsignedProperties() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UNSIGNEDPROPERTIES$2, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public XmlID xgetId() {
        XmlID xmlIDFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIDFind_attribute_user = get_store().find_attribute_user(ID$6);
        }
        return xmlIDFind_attribute_user;
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public XmlAnyURI xgetTarget() {
        XmlAnyURI xmlAnyURIFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURIFind_attribute_user = get_store().find_attribute_user(TARGET$4);
        }
        return xmlAnyURIFind_attribute_user;
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public void xsetId(XmlID xmlID) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            XmlID xmlIDFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIDFind_attribute_user == null) {
                xmlIDFind_attribute_user = (XmlID) get_store().add_attribute_user(qName);
            }
            xmlIDFind_attribute_user.set(xmlID);
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public void xsetTarget(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$4;
            XmlAnyURI xmlAnyURIFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlAnyURIFind_attribute_user == null) {
                xmlAnyURIFind_attribute_user = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURIFind_attribute_user.set(xmlAnyURI);
        }
    }
}
