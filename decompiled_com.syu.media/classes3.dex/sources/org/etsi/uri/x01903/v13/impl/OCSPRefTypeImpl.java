package org.etsi.uri.x01903.v13.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.DigestAlgAndValueType;
import org.etsi.uri.x01903.v13.OCSPIdentifierType;
import org.etsi.uri.x01903.v13.OCSPRefType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class OCSPRefTypeImpl extends XmlComplexContentImpl implements OCSPRefType {
    private static final QName OCSPIDENTIFIER$0 = new QName("http://uri.etsi.org/01903/v1.3.2#", "OCSPIdentifier");
    private static final QName DIGESTALGANDVALUE$2 = new QName("http://uri.etsi.org/01903/v1.3.2#", "DigestAlgAndValue");

    public OCSPRefTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.OCSPRefType
    public DigestAlgAndValueType addNewDigestAlgAndValue() {
        DigestAlgAndValueType digestAlgAndValueType;
        synchronized (monitor()) {
            check_orphaned();
            digestAlgAndValueType = (DigestAlgAndValueType) get_store().add_element_user(DIGESTALGANDVALUE$2);
        }
        return digestAlgAndValueType;
    }

    @Override // org.etsi.uri.x01903.v13.OCSPRefType
    public OCSPIdentifierType addNewOCSPIdentifier() {
        OCSPIdentifierType oCSPIdentifierType;
        synchronized (monitor()) {
            check_orphaned();
            oCSPIdentifierType = (OCSPIdentifierType) get_store().add_element_user(OCSPIDENTIFIER$0);
        }
        return oCSPIdentifierType;
    }

    @Override // org.etsi.uri.x01903.v13.OCSPRefType
    public DigestAlgAndValueType getDigestAlgAndValue() {
        synchronized (monitor()) {
            check_orphaned();
            DigestAlgAndValueType digestAlgAndValueType = (DigestAlgAndValueType) get_store().find_element_user(DIGESTALGANDVALUE$2, 0);
            if (digestAlgAndValueType == null) {
                return null;
            }
            return digestAlgAndValueType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPRefType
    public OCSPIdentifierType getOCSPIdentifier() {
        synchronized (monitor()) {
            check_orphaned();
            OCSPIdentifierType oCSPIdentifierType = (OCSPIdentifierType) get_store().find_element_user(OCSPIDENTIFIER$0, 0);
            if (oCSPIdentifierType == null) {
                return null;
            }
            return oCSPIdentifierType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPRefType
    public boolean isSetDigestAlgAndValue() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DIGESTALGANDVALUE$2) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.OCSPRefType
    public void setDigestAlgAndValue(DigestAlgAndValueType digestAlgAndValueType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIGESTALGANDVALUE$2;
            DigestAlgAndValueType digestAlgAndValueType2 = (DigestAlgAndValueType) typeStore.find_element_user(qName, 0);
            if (digestAlgAndValueType2 == null) {
                digestAlgAndValueType2 = (DigestAlgAndValueType) get_store().add_element_user(qName);
            }
            digestAlgAndValueType2.set(digestAlgAndValueType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPRefType
    public void setOCSPIdentifier(OCSPIdentifierType oCSPIdentifierType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OCSPIDENTIFIER$0;
            OCSPIdentifierType oCSPIdentifierType2 = (OCSPIdentifierType) typeStore.find_element_user(qName, 0);
            if (oCSPIdentifierType2 == null) {
                oCSPIdentifierType2 = (OCSPIdentifierType) get_store().add_element_user(qName);
            }
            oCSPIdentifierType2.set(oCSPIdentifierType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.OCSPRefType
    public void unsetDigestAlgAndValue() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DIGESTALGANDVALUE$2, 0);
        }
    }
}
