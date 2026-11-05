package org.w3.x2000.x09.xmldsig.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.w3.x2000.x09.xmldsig.KeyInfoType;
import org.w3.x2000.x09.xmldsig.ObjectType;
import org.w3.x2000.x09.xmldsig.SignatureType;
import org.w3.x2000.x09.xmldsig.SignatureValueType;
import org.w3.x2000.x09.xmldsig.SignedInfoType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class SignatureTypeImpl extends XmlComplexContentImpl implements SignatureType {
    private static final QName SIGNEDINFO$0 = new QName("http://www.w3.org/2000/09/xmldsig#", "SignedInfo");
    private static final QName SIGNATUREVALUE$2 = new QName("http://www.w3.org/2000/09/xmldsig#", "SignatureValue");
    private static final QName KEYINFO$4 = new QName("http://www.w3.org/2000/09/xmldsig#", "KeyInfo");
    private static final QName OBJECT$6 = new QName("http://www.w3.org/2000/09/xmldsig#", "Object");
    private static final QName ID$8 = new QName("", "Id");

    public SignatureTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public KeyInfoType addNewKeyInfo() {
        KeyInfoType keyInfoTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            keyInfoTypeAdd_element_user = get_store().add_element_user(KEYINFO$4);
        }
        return keyInfoTypeAdd_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public ObjectType addNewObject() {
        ObjectType objectTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            objectTypeAdd_element_user = get_store().add_element_user(OBJECT$6);
        }
        return objectTypeAdd_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public SignatureValueType addNewSignatureValue() {
        SignatureValueType signatureValueTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            signatureValueTypeAdd_element_user = get_store().add_element_user(SIGNATUREVALUE$2);
        }
        return signatureValueTypeAdd_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public SignedInfoType addNewSignedInfo() {
        SignedInfoType signedInfoTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            signedInfoTypeAdd_element_user = get_store().add_element_user(SIGNEDINFO$0);
        }
        return signedInfoTypeAdd_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public KeyInfoType getKeyInfo() {
        synchronized (monitor()) {
            check_orphaned();
            KeyInfoType keyInfoTypeFind_element_user = get_store().find_element_user(KEYINFO$4, 0);
            if (keyInfoTypeFind_element_user == null) {
                return null;
            }
            return keyInfoTypeFind_element_user;
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public ObjectType getObjectArray(int i) {
        ObjectType objectTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            objectTypeFind_element_user = get_store().find_element_user(OBJECT$6, i);
            if (objectTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return objectTypeFind_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public ObjectType[] getObjectArray() {
        ObjectType[] objectTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OBJECT$6, arrayList);
            objectTypeArr = new ObjectType[arrayList.size()];
            arrayList.toArray(objectTypeArr);
        }
        return objectTypeArr;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public List<ObjectType> getObjectList() {
        1ObjectList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ObjectList(this);
        }
        return r1;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public SignatureValueType getSignatureValue() {
        synchronized (monitor()) {
            check_orphaned();
            SignatureValueType signatureValueTypeFind_element_user = get_store().find_element_user(SIGNATUREVALUE$2, 0);
            if (signatureValueTypeFind_element_user == null) {
                return null;
            }
            return signatureValueTypeFind_element_user;
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public SignedInfoType getSignedInfo() {
        synchronized (monitor()) {
            check_orphaned();
            SignedInfoType signedInfoTypeFind_element_user = get_store().find_element_user(SIGNEDINFO$0, 0);
            if (signedInfoTypeFind_element_user == null) {
                return null;
            }
            return signedInfoTypeFind_element_user;
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public ObjectType insertNewObject(int i) {
        ObjectType objectTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            objectTypeInsert_element_user = get_store().insert_element_user(OBJECT$6, i);
        }
        return objectTypeInsert_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$8) != null;
        }
        return z;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public boolean isSetKeyInfo() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(KEYINFO$4) != 0;
        }
        return z;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public void removeObject(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OBJECT$6, i);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public void setKeyInfo(KeyInfoType keyInfoType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KEYINFO$4;
            KeyInfoType keyInfoTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (keyInfoTypeFind_element_user == null) {
                keyInfoTypeFind_element_user = (KeyInfoType) get_store().add_element_user(qName);
            }
            keyInfoTypeFind_element_user.set(keyInfoType);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public void setObjectArray(int i, ObjectType objectType) {
        synchronized (monitor()) {
            check_orphaned();
            ObjectType objectTypeFind_element_user = get_store().find_element_user(OBJECT$6, i);
            if (objectTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            objectTypeFind_element_user.set(objectType);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public void setObjectArray(ObjectType[] objectTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(objectTypeArr, OBJECT$6);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public void setSignatureValue(SignatureValueType signatureValueType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATUREVALUE$2;
            SignatureValueType signatureValueTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (signatureValueTypeFind_element_user == null) {
                signatureValueTypeFind_element_user = (SignatureValueType) get_store().add_element_user(qName);
            }
            signatureValueTypeFind_element_user.set(signatureValueType);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public void setSignedInfo(SignedInfoType signedInfoType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNEDINFO$0;
            SignedInfoType signedInfoTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (signedInfoTypeFind_element_user == null) {
                signedInfoTypeFind_element_user = (SignedInfoType) get_store().add_element_user(qName);
            }
            signedInfoTypeFind_element_user.set(signedInfoType);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public int sizeOfObjectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OBJECT$6);
        }
        return iCount_elements;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$8);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public void unsetKeyInfo() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(KEYINFO$4, 0);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public XmlID xgetId() {
        XmlID xmlIDFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIDFind_attribute_user = get_store().find_attribute_user(ID$8);
        }
        return xmlIDFind_attribute_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureType
    public void xsetId(XmlID xmlID) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$8;
            XmlID xmlIDFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIDFind_attribute_user == null) {
                xmlIDFind_attribute_user = (XmlID) get_store().add_attribute_user(qName);
            }
            xmlIDFind_attribute_user.set(xmlID);
        }
    }
}
