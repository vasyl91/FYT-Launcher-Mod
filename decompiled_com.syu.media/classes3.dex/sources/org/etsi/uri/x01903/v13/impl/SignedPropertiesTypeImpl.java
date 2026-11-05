package org.etsi.uri.x01903.v13.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.SignedDataObjectPropertiesType;
import org.etsi.uri.x01903.v13.SignedPropertiesType;
import org.etsi.uri.x01903.v13.SignedSignaturePropertiesType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SignedPropertiesTypeImpl extends XmlComplexContentImpl implements SignedPropertiesType {
    private static final QName SIGNEDSIGNATUREPROPERTIES$0 = new QName("http://uri.etsi.org/01903/v1.3.2#", "SignedSignatureProperties");
    private static final QName SIGNEDDATAOBJECTPROPERTIES$2 = new QName("http://uri.etsi.org/01903/v1.3.2#", "SignedDataObjectProperties");
    private static final QName ID$4 = new QName("", "Id");

    public SignedPropertiesTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.SignedPropertiesType
    public SignedDataObjectPropertiesType addNewSignedDataObjectProperties() {
        SignedDataObjectPropertiesType signedDataObjectPropertiesTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            signedDataObjectPropertiesTypeAdd_element_user = get_store().add_element_user(SIGNEDDATAOBJECTPROPERTIES$2);
        }
        return signedDataObjectPropertiesTypeAdd_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.SignedPropertiesType
    public SignedSignaturePropertiesType addNewSignedSignatureProperties() {
        SignedSignaturePropertiesType signedSignaturePropertiesType;
        synchronized (monitor()) {
            check_orphaned();
            signedSignaturePropertiesType = (SignedSignaturePropertiesType) get_store().add_element_user(SIGNEDSIGNATUREPROPERTIES$0);
        }
        return signedSignaturePropertiesType;
    }

    @Override // org.etsi.uri.x01903.v13.SignedPropertiesType
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedPropertiesType
    public SignedDataObjectPropertiesType getSignedDataObjectProperties() {
        synchronized (monitor()) {
            check_orphaned();
            SignedDataObjectPropertiesType signedDataObjectPropertiesTypeFind_element_user = get_store().find_element_user(SIGNEDDATAOBJECTPROPERTIES$2, 0);
            if (signedDataObjectPropertiesTypeFind_element_user == null) {
                return null;
            }
            return signedDataObjectPropertiesTypeFind_element_user;
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedPropertiesType
    public SignedSignaturePropertiesType getSignedSignatureProperties() {
        synchronized (monitor()) {
            check_orphaned();
            SignedSignaturePropertiesType signedSignaturePropertiesType = (SignedSignaturePropertiesType) get_store().find_element_user(SIGNEDSIGNATUREPROPERTIES$0, 0);
            if (signedSignaturePropertiesType == null) {
                return null;
            }
            return signedSignaturePropertiesType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedPropertiesType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$4) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.SignedPropertiesType
    public boolean isSetSignedDataObjectProperties() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIGNEDDATAOBJECTPROPERTIES$2) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.SignedPropertiesType
    public boolean isSetSignedSignatureProperties() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIGNEDSIGNATUREPROPERTIES$0) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.SignedPropertiesType
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedPropertiesType
    public void setSignedDataObjectProperties(SignedDataObjectPropertiesType signedDataObjectPropertiesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNEDDATAOBJECTPROPERTIES$2;
            SignedDataObjectPropertiesType signedDataObjectPropertiesTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (signedDataObjectPropertiesTypeFind_element_user == null) {
                signedDataObjectPropertiesTypeFind_element_user = (SignedDataObjectPropertiesType) get_store().add_element_user(qName);
            }
            signedDataObjectPropertiesTypeFind_element_user.set(signedDataObjectPropertiesType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedPropertiesType
    public void setSignedSignatureProperties(SignedSignaturePropertiesType signedSignaturePropertiesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNEDSIGNATUREPROPERTIES$0;
            SignedSignaturePropertiesType signedSignaturePropertiesType2 = (SignedSignaturePropertiesType) typeStore.find_element_user(qName, 0);
            if (signedSignaturePropertiesType2 == null) {
                signedSignaturePropertiesType2 = (SignedSignaturePropertiesType) get_store().add_element_user(qName);
            }
            signedSignaturePropertiesType2.set(signedSignaturePropertiesType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedPropertiesType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$4);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedPropertiesType
    public void unsetSignedDataObjectProperties() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNEDDATAOBJECTPROPERTIES$2, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedPropertiesType
    public void unsetSignedSignatureProperties() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNEDSIGNATUREPROPERTIES$0, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedPropertiesType
    public XmlID xgetId() {
        XmlID xmlIDFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIDFind_attribute_user = get_store().find_attribute_user(ID$4);
        }
        return xmlIDFind_attribute_user;
    }

    @Override // org.etsi.uri.x01903.v13.SignedPropertiesType
    public void xsetId(XmlID xmlID) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$4;
            XmlID xmlIDFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIDFind_attribute_user == null) {
                xmlIDFind_attribute_user = (XmlID) get_store().add_attribute_user(qName);
            }
            xmlIDFind_attribute_user.set(xmlID);
        }
    }
}
