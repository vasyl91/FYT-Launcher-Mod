package org.etsi.uri.x01903.v13.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.CRLValuesType;
import org.etsi.uri.x01903.v13.EncapsulatedPKIDataType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CRLValuesTypeImpl extends XmlComplexContentImpl implements CRLValuesType {
    private static final QName ENCAPSULATEDCRLVALUE$0 = new QName("http://uri.etsi.org/01903/v1.3.2#", "EncapsulatedCRLValue");

    public CRLValuesTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.CRLValuesType
    public EncapsulatedPKIDataType addNewEncapsulatedCRLValue() {
        EncapsulatedPKIDataType encapsulatedPKIDataType;
        synchronized (monitor()) {
            check_orphaned();
            encapsulatedPKIDataType = (EncapsulatedPKIDataType) get_store().add_element_user(ENCAPSULATEDCRLVALUE$0);
        }
        return encapsulatedPKIDataType;
    }

    @Override // org.etsi.uri.x01903.v13.CRLValuesType
    public EncapsulatedPKIDataType getEncapsulatedCRLValueArray(int i) {
        EncapsulatedPKIDataType encapsulatedPKIDataType;
        synchronized (monitor()) {
            check_orphaned();
            encapsulatedPKIDataType = (EncapsulatedPKIDataType) get_store().find_element_user(ENCAPSULATEDCRLVALUE$0, i);
            if (encapsulatedPKIDataType == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return encapsulatedPKIDataType;
    }

    @Override // org.etsi.uri.x01903.v13.CRLValuesType
    public EncapsulatedPKIDataType[] getEncapsulatedCRLValueArray() {
        EncapsulatedPKIDataType[] encapsulatedPKIDataTypeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ENCAPSULATEDCRLVALUE$0, arrayList);
            encapsulatedPKIDataTypeArr = new EncapsulatedPKIDataType[arrayList.size()];
            arrayList.toArray(encapsulatedPKIDataTypeArr);
        }
        return encapsulatedPKIDataTypeArr;
    }

    @Override // org.etsi.uri.x01903.v13.CRLValuesType
    public List<EncapsulatedPKIDataType> getEncapsulatedCRLValueList() {
        1EncapsulatedCRLValueList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1EncapsulatedCRLValueList(this);
        }
        return r1;
    }

    @Override // org.etsi.uri.x01903.v13.CRLValuesType
    public EncapsulatedPKIDataType insertNewEncapsulatedCRLValue(int i) {
        EncapsulatedPKIDataType encapsulatedPKIDataType;
        synchronized (monitor()) {
            check_orphaned();
            encapsulatedPKIDataType = (EncapsulatedPKIDataType) get_store().insert_element_user(ENCAPSULATEDCRLVALUE$0, i);
        }
        return encapsulatedPKIDataType;
    }

    @Override // org.etsi.uri.x01903.v13.CRLValuesType
    public void removeEncapsulatedCRLValue(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENCAPSULATEDCRLVALUE$0, i);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLValuesType
    public void setEncapsulatedCRLValueArray(int i, EncapsulatedPKIDataType encapsulatedPKIDataType) {
        synchronized (monitor()) {
            check_orphaned();
            EncapsulatedPKIDataType encapsulatedPKIDataType2 = (EncapsulatedPKIDataType) get_store().find_element_user(ENCAPSULATEDCRLVALUE$0, i);
            if (encapsulatedPKIDataType2 == null) {
                throw new IndexOutOfBoundsException();
            }
            encapsulatedPKIDataType2.set(encapsulatedPKIDataType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLValuesType
    public void setEncapsulatedCRLValueArray(EncapsulatedPKIDataType[] encapsulatedPKIDataTypeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) encapsulatedPKIDataTypeArr, ENCAPSULATEDCRLVALUE$0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CRLValuesType
    public int sizeOfEncapsulatedCRLValueArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ENCAPSULATEDCRLVALUE$0);
        }
        return iCount_elements;
    }
}
