package org.etsi.uri.x01903.v13.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.SignaturePolicyIdType;
import org.etsi.uri.x01903.v13.SignaturePolicyIdentifierType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SignaturePolicyIdentifierTypeImpl extends XmlComplexContentImpl implements SignaturePolicyIdentifierType {
    private static final QName SIGNATUREPOLICYID$0 = new QName("http://uri.etsi.org/01903/v1.3.2#", "SignaturePolicyId");
    private static final QName SIGNATUREPOLICYIMPLIED$2 = new QName("http://uri.etsi.org/01903/v1.3.2#", "SignaturePolicyImplied");

    public SignaturePolicyIdentifierTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.SignaturePolicyIdentifierType
    public SignaturePolicyIdType addNewSignaturePolicyId() {
        SignaturePolicyIdType signaturePolicyIdTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            signaturePolicyIdTypeAdd_element_user = get_store().add_element_user(SIGNATUREPOLICYID$0);
        }
        return signaturePolicyIdTypeAdd_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.SignaturePolicyIdentifierType
    public XmlObject addNewSignaturePolicyImplied() {
        XmlObject xmlObjectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlObjectAdd_element_user = get_store().add_element_user(SIGNATUREPOLICYIMPLIED$2);
        }
        return xmlObjectAdd_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.SignaturePolicyIdentifierType
    public SignaturePolicyIdType getSignaturePolicyId() {
        synchronized (monitor()) {
            check_orphaned();
            SignaturePolicyIdType signaturePolicyIdTypeFind_element_user = get_store().find_element_user(SIGNATUREPOLICYID$0, 0);
            if (signaturePolicyIdTypeFind_element_user == null) {
                return null;
            }
            return signaturePolicyIdTypeFind_element_user;
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignaturePolicyIdentifierType
    public XmlObject getSignaturePolicyImplied() {
        synchronized (monitor()) {
            check_orphaned();
            XmlObject xmlObjectFind_element_user = get_store().find_element_user(SIGNATUREPOLICYIMPLIED$2, 0);
            if (xmlObjectFind_element_user == null) {
                return null;
            }
            return xmlObjectFind_element_user;
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignaturePolicyIdentifierType
    public boolean isSetSignaturePolicyId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIGNATUREPOLICYID$0) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.SignaturePolicyIdentifierType
    public boolean isSetSignaturePolicyImplied() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIGNATUREPOLICYIMPLIED$2) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.SignaturePolicyIdentifierType
    public void setSignaturePolicyId(SignaturePolicyIdType signaturePolicyIdType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATUREPOLICYID$0;
            SignaturePolicyIdType signaturePolicyIdTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (signaturePolicyIdTypeFind_element_user == null) {
                signaturePolicyIdTypeFind_element_user = (SignaturePolicyIdType) get_store().add_element_user(qName);
            }
            signaturePolicyIdTypeFind_element_user.set(signaturePolicyIdType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignaturePolicyIdentifierType
    public void setSignaturePolicyImplied(XmlObject xmlObject) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATUREPOLICYIMPLIED$2;
            XmlObject xmlObjectFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlObjectFind_element_user == null) {
                xmlObjectFind_element_user = (XmlObject) get_store().add_element_user(qName);
            }
            xmlObjectFind_element_user.set(xmlObject);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignaturePolicyIdentifierType
    public void unsetSignaturePolicyId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNATUREPOLICYID$0, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignaturePolicyIdentifierType
    public void unsetSignaturePolicyImplied() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNATUREPOLICYIMPLIED$2, 0);
        }
    }
}
