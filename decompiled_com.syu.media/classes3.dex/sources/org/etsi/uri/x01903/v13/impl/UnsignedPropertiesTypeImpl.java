package org.etsi.uri.x01903.v13.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.UnsignedDataObjectPropertiesType;
import org.etsi.uri.x01903.v13.UnsignedPropertiesType;
import org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class UnsignedPropertiesTypeImpl extends XmlComplexContentImpl implements UnsignedPropertiesType {
    private static final QName UNSIGNEDSIGNATUREPROPERTIES$0 = new QName("http://uri.etsi.org/01903/v1.3.2#", "UnsignedSignatureProperties");
    private static final QName UNSIGNEDDATAOBJECTPROPERTIES$2 = new QName("http://uri.etsi.org/01903/v1.3.2#", "UnsignedDataObjectProperties");
    private static final QName ID$4 = new QName("", "Id");

    public UnsignedPropertiesTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public UnsignedDataObjectPropertiesType addNewUnsignedDataObjectProperties() {
        UnsignedDataObjectPropertiesType unsignedDataObjectPropertiesTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            unsignedDataObjectPropertiesTypeAdd_element_user = get_store().add_element_user(UNSIGNEDDATAOBJECTPROPERTIES$2);
        }
        return unsignedDataObjectPropertiesTypeAdd_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public UnsignedSignaturePropertiesType addNewUnsignedSignatureProperties() {
        UnsignedSignaturePropertiesType unsignedSignaturePropertiesType;
        synchronized (monitor()) {
            check_orphaned();
            unsignedSignaturePropertiesType = (UnsignedSignaturePropertiesType) get_store().add_element_user(UNSIGNEDSIGNATUREPROPERTIES$0);
        }
        return unsignedSignaturePropertiesType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
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

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public UnsignedDataObjectPropertiesType getUnsignedDataObjectProperties() {
        synchronized (monitor()) {
            check_orphaned();
            UnsignedDataObjectPropertiesType unsignedDataObjectPropertiesTypeFind_element_user = get_store().find_element_user(UNSIGNEDDATAOBJECTPROPERTIES$2, 0);
            if (unsignedDataObjectPropertiesTypeFind_element_user == null) {
                return null;
            }
            return unsignedDataObjectPropertiesTypeFind_element_user;
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public UnsignedSignaturePropertiesType getUnsignedSignatureProperties() {
        synchronized (monitor()) {
            check_orphaned();
            UnsignedSignaturePropertiesType unsignedSignaturePropertiesType = (UnsignedSignaturePropertiesType) get_store().find_element_user(UNSIGNEDSIGNATUREPROPERTIES$0, 0);
            if (unsignedSignaturePropertiesType == null) {
                return null;
            }
            return unsignedSignaturePropertiesType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$4) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public boolean isSetUnsignedDataObjectProperties() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UNSIGNEDDATAOBJECTPROPERTIES$2) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public boolean isSetUnsignedSignatureProperties() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UNSIGNEDSIGNATUREPROPERTIES$0) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
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

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public void setUnsignedDataObjectProperties(UnsignedDataObjectPropertiesType unsignedDataObjectPropertiesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UNSIGNEDDATAOBJECTPROPERTIES$2;
            UnsignedDataObjectPropertiesType unsignedDataObjectPropertiesTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (unsignedDataObjectPropertiesTypeFind_element_user == null) {
                unsignedDataObjectPropertiesTypeFind_element_user = (UnsignedDataObjectPropertiesType) get_store().add_element_user(qName);
            }
            unsignedDataObjectPropertiesTypeFind_element_user.set(unsignedDataObjectPropertiesType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public void setUnsignedSignatureProperties(UnsignedSignaturePropertiesType unsignedSignaturePropertiesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UNSIGNEDSIGNATUREPROPERTIES$0;
            UnsignedSignaturePropertiesType unsignedSignaturePropertiesType2 = (UnsignedSignaturePropertiesType) typeStore.find_element_user(qName, 0);
            if (unsignedSignaturePropertiesType2 == null) {
                unsignedSignaturePropertiesType2 = (UnsignedSignaturePropertiesType) get_store().add_element_user(qName);
            }
            unsignedSignaturePropertiesType2.set(unsignedSignaturePropertiesType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$4);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public void unsetUnsignedDataObjectProperties() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UNSIGNEDDATAOBJECTPROPERTIES$2, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public void unsetUnsignedSignatureProperties() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UNSIGNEDSIGNATUREPROPERTIES$0, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public XmlID xgetId() {
        XmlID xmlIDFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIDFind_attribute_user = get_store().find_attribute_user(ID$4);
        }
        return xmlIDFind_attribute_user;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
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
