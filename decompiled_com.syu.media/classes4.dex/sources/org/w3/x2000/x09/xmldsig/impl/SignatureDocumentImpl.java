package org.w3.x2000.x09.xmldsig.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.w3.x2000.x09.xmldsig.SignatureDocument;
import org.w3.x2000.x09.xmldsig.SignatureType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class SignatureDocumentImpl extends XmlComplexContentImpl implements SignatureDocument {
    private static final QName SIGNATURE$0 = new QName("http://www.w3.org/2000/09/xmldsig#", "Signature");

    public SignatureDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureDocument
    public SignatureType addNewSignature() {
        SignatureType signatureTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            signatureTypeAdd_element_user = get_store().add_element_user(SIGNATURE$0);
        }
        return signatureTypeAdd_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureDocument
    public SignatureType getSignature() {
        synchronized (monitor()) {
            check_orphaned();
            SignatureType signatureTypeFind_element_user = get_store().find_element_user(SIGNATURE$0, 0);
            if (signatureTypeFind_element_user == null) {
                return null;
            }
            return signatureTypeFind_element_user;
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureDocument
    public void setSignature(SignatureType signatureType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATURE$0;
            SignatureType signatureTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (signatureTypeFind_element_user == null) {
                signatureTypeFind_element_user = (SignatureType) get_store().add_element_user(qName);
            }
            signatureTypeFind_element_user.set(signatureType);
        }
    }
}
