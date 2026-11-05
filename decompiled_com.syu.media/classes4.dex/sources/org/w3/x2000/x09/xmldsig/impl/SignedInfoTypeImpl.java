package org.w3.x2000.x09.xmldsig.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.w3.x2000.x09.xmldsig.CanonicalizationMethodType;
import org.w3.x2000.x09.xmldsig.ReferenceType;
import org.w3.x2000.x09.xmldsig.SignatureMethodType;
import org.w3.x2000.x09.xmldsig.SignedInfoType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class SignedInfoTypeImpl extends XmlComplexContentImpl implements SignedInfoType {
    private static final QName CANONICALIZATIONMETHOD$0 = new QName("http://www.w3.org/2000/09/xmldsig#", "CanonicalizationMethod");
    private static final QName SIGNATUREMETHOD$2 = new QName("http://www.w3.org/2000/09/xmldsig#", "SignatureMethod");
    private static final QName REFERENCE$4 = new QName("http://www.w3.org/2000/09/xmldsig#", "Reference");
    private static final QName ID$6 = new QName("", "Id");

    public SignedInfoTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
    public CanonicalizationMethodType addNewCanonicalizationMethod() {
        CanonicalizationMethodType canonicalizationMethodTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            canonicalizationMethodTypeAdd_element_user = get_store().add_element_user(CANONICALIZATIONMETHOD$0);
        }
        return canonicalizationMethodTypeAdd_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
    public ReferenceType addNewReference() {
        ReferenceType referenceTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            referenceTypeAdd_element_user = get_store().add_element_user(REFERENCE$4);
        }
        return referenceTypeAdd_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
    public SignatureMethodType addNewSignatureMethod() {
        SignatureMethodType signatureMethodTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            signatureMethodTypeAdd_element_user = get_store().add_element_user(SIGNATUREMETHOD$2);
        }
        return signatureMethodTypeAdd_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
    public CanonicalizationMethodType getCanonicalizationMethod() {
        synchronized (monitor()) {
            check_orphaned();
            CanonicalizationMethodType canonicalizationMethodTypeFind_element_user = get_store().find_element_user(CANONICALIZATIONMETHOD$0, 0);
            if (canonicalizationMethodTypeFind_element_user == null) {
                return null;
            }
            return canonicalizationMethodTypeFind_element_user;
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
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

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
    public ReferenceType getReferenceArray(int i) {
        ReferenceType referenceTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            referenceTypeFind_element_user = get_store().find_element_user(REFERENCE$4, i);
            if (referenceTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return referenceTypeFind_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
    public ReferenceType[] getReferenceArray() {
        ReferenceType[] referenceTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(REFERENCE$4, arrayList);
            referenceTypeArr = new ReferenceType[arrayList.size()];
            arrayList.toArray(referenceTypeArr);
        }
        return referenceTypeArr;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
    public List<ReferenceType> getReferenceList() {
        1ReferenceList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ReferenceList(this);
        }
        return r1;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
    public SignatureMethodType getSignatureMethod() {
        synchronized (monitor()) {
            check_orphaned();
            SignatureMethodType signatureMethodTypeFind_element_user = get_store().find_element_user(SIGNATUREMETHOD$2, 0);
            if (signatureMethodTypeFind_element_user == null) {
                return null;
            }
            return signatureMethodTypeFind_element_user;
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
    public ReferenceType insertNewReference(int i) {
        ReferenceType referenceTypeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            referenceTypeInsert_element_user = get_store().insert_element_user(REFERENCE$4, i);
        }
        return referenceTypeInsert_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$6) != null;
        }
        return z;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
    public void removeReference(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(REFERENCE$4, i);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
    public void setCanonicalizationMethod(CanonicalizationMethodType canonicalizationMethodType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CANONICALIZATIONMETHOD$0;
            CanonicalizationMethodType canonicalizationMethodTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (canonicalizationMethodTypeFind_element_user == null) {
                canonicalizationMethodTypeFind_element_user = (CanonicalizationMethodType) get_store().add_element_user(qName);
            }
            canonicalizationMethodTypeFind_element_user.set(canonicalizationMethodType);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
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

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
    public void setReferenceArray(int i, ReferenceType referenceType) {
        synchronized (monitor()) {
            check_orphaned();
            ReferenceType referenceTypeFind_element_user = get_store().find_element_user(REFERENCE$4, i);
            if (referenceTypeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            referenceTypeFind_element_user.set(referenceType);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
    public void setReferenceArray(ReferenceType[] referenceTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(referenceTypeArr, REFERENCE$4);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
    public void setSignatureMethod(SignatureMethodType signatureMethodType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATUREMETHOD$2;
            SignatureMethodType signatureMethodTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (signatureMethodTypeFind_element_user == null) {
                signatureMethodTypeFind_element_user = (SignatureMethodType) get_store().add_element_user(qName);
            }
            signatureMethodTypeFind_element_user.set(signatureMethodType);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
    public int sizeOfReferenceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(REFERENCE$4);
        }
        return iCount_elements;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$6);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
    public XmlID xgetId() {
        XmlID xmlIDFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIDFind_attribute_user = get_store().find_attribute_user(ID$6);
        }
        return xmlIDFind_attribute_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignedInfoType
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
}
