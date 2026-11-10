package org.etsi.uri.x01903.v13.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.DigestAlgAndValueType;
import org.w3.x2000.x09.xmldsig.DigestMethodType;
import org.w3.x2000.x09.xmldsig.DigestValueType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class DigestAlgAndValueTypeImpl extends XmlComplexContentImpl implements DigestAlgAndValueType {
    private static final QName DIGESTMETHOD$0 = new QName("http://www.w3.org/2000/09/xmldsig#", "DigestMethod");
    private static final QName DIGESTVALUE$2 = new QName("http://www.w3.org/2000/09/xmldsig#", "DigestValue");

    public DigestAlgAndValueTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.DigestAlgAndValueType
    public DigestMethodType addNewDigestMethod() {
        DigestMethodType digestMethodTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            digestMethodTypeAdd_element_user = get_store().add_element_user(DIGESTMETHOD$0);
        }
        return digestMethodTypeAdd_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.DigestAlgAndValueType
    public DigestMethodType getDigestMethod() {
        synchronized (monitor()) {
            check_orphaned();
            DigestMethodType digestMethodTypeFind_element_user = get_store().find_element_user(DIGESTMETHOD$0, 0);
            if (digestMethodTypeFind_element_user == null) {
                return null;
            }
            return digestMethodTypeFind_element_user;
        }
    }

    @Override // org.etsi.uri.x01903.v13.DigestAlgAndValueType
    public byte[] getDigestValue() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(DIGESTVALUE$2, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getByteArrayValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.DigestAlgAndValueType
    public void setDigestMethod(DigestMethodType digestMethodType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIGESTMETHOD$0;
            DigestMethodType digestMethodTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (digestMethodTypeFind_element_user == null) {
                digestMethodTypeFind_element_user = (DigestMethodType) get_store().add_element_user(qName);
            }
            digestMethodTypeFind_element_user.set(digestMethodType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.DigestAlgAndValueType
    public void setDigestValue(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIGESTVALUE$2;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setByteArrayValue(bArr);
        }
    }

    @Override // org.etsi.uri.x01903.v13.DigestAlgAndValueType
    public DigestValueType xgetDigestValue() {
        DigestValueType digestValueTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            digestValueTypeFind_element_user = get_store().find_element_user(DIGESTVALUE$2, 0);
        }
        return digestValueTypeFind_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.DigestAlgAndValueType
    public void xsetDigestValue(DigestValueType digestValueType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIGESTVALUE$2;
            DigestValueType digestValueTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (digestValueTypeFind_element_user == null) {
                digestValueTypeFind_element_user = (DigestValueType) get_store().add_element_user(qName);
            }
            digestValueTypeFind_element_user.set(digestValueType);
        }
    }
}
