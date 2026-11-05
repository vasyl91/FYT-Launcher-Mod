package org.etsi.uri.x01903.v13.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.CRLIdentifierType;
import org.etsi.uri.x01903.v13.CRLRefType;
import org.etsi.uri.x01903.v13.DigestAlgAndValueType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CRLRefTypeImpl extends XmlComplexContentImpl implements CRLRefType {
    private static final QName DIGESTALGANDVALUE$0 = new QName("http://uri.etsi.org/01903/v1.3.2#", "DigestAlgAndValue");
    private static final QName CRLIDENTIFIER$2 = new QName("http://uri.etsi.org/01903/v1.3.2#", "CRLIdentifier");

    public CRLRefTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefType
    public CRLIdentifierType addNewCRLIdentifier() {
        CRLIdentifierType cRLIdentifierType;
        synchronized (monitor()) {
            check_orphaned();
            cRLIdentifierType = (CRLIdentifierType) get_store().add_element_user(CRLIDENTIFIER$2);
        }
        return cRLIdentifierType;
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefType
    public DigestAlgAndValueType addNewDigestAlgAndValue() {
        DigestAlgAndValueType digestAlgAndValueType;
        synchronized (monitor()) {
            check_orphaned();
            digestAlgAndValueType = (DigestAlgAndValueType) get_store().add_element_user(DIGESTALGANDVALUE$0);
        }
        return digestAlgAndValueType;
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefType
    public CRLIdentifierType getCRLIdentifier() {
        synchronized (monitor()) {
            check_orphaned();
            CRLIdentifierType cRLIdentifierType = (CRLIdentifierType) get_store().find_element_user(CRLIDENTIFIER$2, 0);
            if (cRLIdentifierType == null) {
                return null;
            }
            return cRLIdentifierType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefType
    public DigestAlgAndValueType getDigestAlgAndValue() {
        synchronized (monitor()) {
            check_orphaned();
            DigestAlgAndValueType digestAlgAndValueType = (DigestAlgAndValueType) get_store().find_element_user(DIGESTALGANDVALUE$0, 0);
            if (digestAlgAndValueType == null) {
                return null;
            }
            return digestAlgAndValueType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefType
    public boolean isSetCRLIdentifier() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CRLIDENTIFIER$2) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefType
    public void setCRLIdentifier(CRLIdentifierType cRLIdentifierType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRLIDENTIFIER$2;
            CRLIdentifierType cRLIdentifierType2 = (CRLIdentifierType) typeStore.find_element_user(qName, 0);
            if (cRLIdentifierType2 == null) {
                cRLIdentifierType2 = (CRLIdentifierType) get_store().add_element_user(qName);
            }
            cRLIdentifierType2.set(cRLIdentifierType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefType
    public void setDigestAlgAndValue(DigestAlgAndValueType digestAlgAndValueType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIGESTALGANDVALUE$0;
            DigestAlgAndValueType digestAlgAndValueType2 = (DigestAlgAndValueType) typeStore.find_element_user(qName, 0);
            if (digestAlgAndValueType2 == null) {
                digestAlgAndValueType2 = (DigestAlgAndValueType) get_store().add_element_user(qName);
            }
            digestAlgAndValueType2.set(digestAlgAndValueType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefType
    public void unsetCRLIdentifier() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CRLIDENTIFIER$2, 0);
        }
    }
}
