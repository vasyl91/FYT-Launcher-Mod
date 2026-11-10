package org.etsi.uri.x01903.v13.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.CRLRefType;
import org.etsi.uri.x01903.v13.CRLRefsType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CRLRefsTypeImpl extends XmlComplexContentImpl implements CRLRefsType {
    private static final QName CRLREF$0 = new QName("http://uri.etsi.org/01903/v1.3.2#", "CRLRef");

    public CRLRefsTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefsType
    public CRLRefType addNewCRLRef() {
        CRLRefType cRLRefType;
        synchronized (monitor()) {
            check_orphaned();
            cRLRefType = (CRLRefType) get_store().add_element_user(CRLREF$0);
        }
        return cRLRefType;
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefsType
    public CRLRefType getCRLRefArray(int i) {
        CRLRefType cRLRefType;
        synchronized (monitor()) {
            check_orphaned();
            cRLRefType = (CRLRefType) get_store().find_element_user(CRLREF$0, i);
            if (cRLRefType == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cRLRefType;
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefsType
    public CRLRefType[] getCRLRefArray() {
        CRLRefType[] cRLRefTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CRLREF$0, arrayList);
            cRLRefTypeArr = new CRLRefType[arrayList.size()];
            arrayList.toArray(cRLRefTypeArr);
        }
        return cRLRefTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefsType
    public List<CRLRefType> getCRLRefList() {
        1CRLRefList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CRLRefList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefsType
    public CRLRefType insertNewCRLRef(int i) {
        CRLRefType cRLRefType;
        synchronized (monitor()) {
            check_orphaned();
            cRLRefType = (CRLRefType) get_store().insert_element_user(CRLREF$0, i);
        }
        return cRLRefType;
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefsType
    public void removeCRLRef(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CRLREF$0, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefsType
    public void setCRLRefArray(int i, CRLRefType cRLRefType) {
        synchronized (monitor()) {
            check_orphaned();
            CRLRefType cRLRefType2 = (CRLRefType) get_store().find_element_user(CRLREF$0, i);
            if (cRLRefType2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cRLRefType2.set(cRLRefType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefsType
    public void setCRLRefArray(CRLRefType[] cRLRefTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cRLRefTypeArr, CRLREF$0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLRefsType
    public int sizeOfCRLRefArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CRLREF$0);
        }
        return iCount_elements;
    }
}
