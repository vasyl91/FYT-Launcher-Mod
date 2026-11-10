package org.etsi.uri.x01903.v13.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.CertIDListType;
import org.etsi.uri.x01903.v13.CertIDType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CertIDListTypeImpl extends XmlComplexContentImpl implements CertIDListType {
    private static final QName CERT$0 = new QName("http://uri.etsi.org/01903/v1.3.2#", "Cert");

    public CertIDListTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.CertIDListType
    public CertIDType addNewCert() {
        CertIDType certIDType;
        synchronized (monitor()) {
            check_orphaned();
            certIDType = (CertIDType) get_store().add_element_user(CERT$0);
        }
        return certIDType;
    }

    @Override // org.etsi.uri.x01903.v13.CertIDListType
    public CertIDType getCertArray(int i) {
        CertIDType certIDType;
        synchronized (monitor()) {
            check_orphaned();
            certIDType = (CertIDType) get_store().find_element_user(CERT$0, i);
            if (certIDType == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return certIDType;
    }

    @Override // org.etsi.uri.x01903.v13.CertIDListType
    public CertIDType[] getCertArray() {
        CertIDType[] certIDTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CERT$0, arrayList);
            certIDTypeArr = new CertIDType[arrayList.size()];
            arrayList.toArray(certIDTypeArr);
        }
        return certIDTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.CertIDListType
    public List<CertIDType> getCertList() {
        1CertList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CertList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.CertIDListType
    public CertIDType insertNewCert(int i) {
        CertIDType certIDType;
        synchronized (monitor()) {
            check_orphaned();
            certIDType = (CertIDType) get_store().insert_element_user(CERT$0, i);
        }
        return certIDType;
    }

    @Override // org.etsi.uri.x01903.v13.CertIDListType
    public void removeCert(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CERT$0, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CertIDListType
    public void setCertArray(int i, CertIDType certIDType) {
        synchronized (monitor()) {
            check_orphaned();
            CertIDType certIDType2 = (CertIDType) get_store().find_element_user(CERT$0, i);
            if (certIDType2 == null) {
                throw new IndexOutOfBoundsException();
            }
            certIDType2.set(certIDType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CertIDListType
    public void setCertArray(CertIDType[] certIDTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(certIDTypeArr, CERT$0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CertIDListType
    public int sizeOfCertArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CERT$0);
        }
        return iCount_elements;
    }
}
