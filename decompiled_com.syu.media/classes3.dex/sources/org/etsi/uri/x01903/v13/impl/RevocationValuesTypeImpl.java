package org.etsi.uri.x01903.v13.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.CRLValuesType;
import org.etsi.uri.x01903.v13.OCSPValuesType;
import org.etsi.uri.x01903.v13.OtherCertStatusValuesType;
import org.etsi.uri.x01903.v13.RevocationValuesType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class RevocationValuesTypeImpl extends XmlComplexContentImpl implements RevocationValuesType {
    private static final QName CRLVALUES$0 = new QName("http://uri.etsi.org/01903/v1.3.2#", "CRLValues");
    private static final QName OCSPVALUES$2 = new QName("http://uri.etsi.org/01903/v1.3.2#", "OCSPValues");
    private static final QName OTHERVALUES$4 = new QName("http://uri.etsi.org/01903/v1.3.2#", "OtherValues");
    private static final QName ID$6 = new QName("", "Id");

    public RevocationValuesTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
    public CRLValuesType addNewCRLValues() {
        CRLValuesType cRLValuesType;
        synchronized (monitor()) {
            check_orphaned();
            cRLValuesType = (CRLValuesType) get_store().add_element_user(CRLVALUES$0);
        }
        return cRLValuesType;
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
    public OCSPValuesType addNewOCSPValues() {
        OCSPValuesType oCSPValuesType;
        synchronized (monitor()) {
            check_orphaned();
            oCSPValuesType = (OCSPValuesType) get_store().add_element_user(OCSPVALUES$2);
        }
        return oCSPValuesType;
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
    public OtherCertStatusValuesType addNewOtherValues() {
        OtherCertStatusValuesType otherCertStatusValuesTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            otherCertStatusValuesTypeAdd_element_user = get_store().add_element_user(OTHERVALUES$4);
        }
        return otherCertStatusValuesTypeAdd_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
    public CRLValuesType getCRLValues() {
        synchronized (monitor()) {
            check_orphaned();
            CRLValuesType cRLValuesType = (CRLValuesType) get_store().find_element_user(CRLVALUES$0, 0);
            if (cRLValuesType == null) {
                return null;
            }
            return cRLValuesType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
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

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
    public OCSPValuesType getOCSPValues() {
        synchronized (monitor()) {
            check_orphaned();
            OCSPValuesType oCSPValuesType = (OCSPValuesType) get_store().find_element_user(OCSPVALUES$2, 0);
            if (oCSPValuesType == null) {
                return null;
            }
            return oCSPValuesType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
    public OtherCertStatusValuesType getOtherValues() {
        synchronized (monitor()) {
            check_orphaned();
            OtherCertStatusValuesType otherCertStatusValuesTypeFind_element_user = get_store().find_element_user(OTHERVALUES$4, 0);
            if (otherCertStatusValuesTypeFind_element_user == null) {
                return null;
            }
            return otherCertStatusValuesTypeFind_element_user;
        }
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
    public boolean isSetCRLValues() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CRLVALUES$0) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$6) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
    public boolean isSetOCSPValues() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OCSPVALUES$2) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
    public boolean isSetOtherValues() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OTHERVALUES$4) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
    public void setCRLValues(CRLValuesType cRLValuesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRLVALUES$0;
            CRLValuesType cRLValuesType2 = (CRLValuesType) typeStore.find_element_user(qName, 0);
            if (cRLValuesType2 == null) {
                cRLValuesType2 = (CRLValuesType) get_store().add_element_user(qName);
            }
            cRLValuesType2.set(cRLValuesType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
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

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
    public void setOCSPValues(OCSPValuesType oCSPValuesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OCSPVALUES$2;
            OCSPValuesType oCSPValuesType2 = (OCSPValuesType) typeStore.find_element_user(qName, 0);
            if (oCSPValuesType2 == null) {
                oCSPValuesType2 = (OCSPValuesType) get_store().add_element_user(qName);
            }
            oCSPValuesType2.set(oCSPValuesType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
    public void setOtherValues(OtherCertStatusValuesType otherCertStatusValuesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OTHERVALUES$4;
            OtherCertStatusValuesType otherCertStatusValuesTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (otherCertStatusValuesTypeFind_element_user == null) {
                otherCertStatusValuesTypeFind_element_user = (OtherCertStatusValuesType) get_store().add_element_user(qName);
            }
            otherCertStatusValuesTypeFind_element_user.set(otherCertStatusValuesType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
    public void unsetCRLValues() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CRLVALUES$0, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$6);
        }
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
    public void unsetOCSPValues() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OCSPVALUES$2, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
    public void unsetOtherValues() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OTHERVALUES$4, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
    public XmlID xgetId() {
        XmlID xmlIDFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIDFind_attribute_user = get_store().find_attribute_user(ID$6);
        }
        return xmlIDFind_attribute_user;
    }

    @Override // org.etsi.uri.x01903.v13.RevocationValuesType
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
