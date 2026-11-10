package org.etsi.uri.x01903.v13.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.CertIDListType;
import org.etsi.uri.x01903.v13.CompleteCertificateRefsType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CompleteCertificateRefsTypeImpl extends XmlComplexContentImpl implements CompleteCertificateRefsType {
    private static final QName CERTREFS$0 = new QName("http://uri.etsi.org/01903/v1.3.2#", "CertRefs");
    private static final QName ID$2 = new QName("", "Id");

    public CompleteCertificateRefsTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.CompleteCertificateRefsType
    public CertIDListType addNewCertRefs() {
        CertIDListType certIDListType;
        synchronized (monitor()) {
            check_orphaned();
            certIDListType = (CertIDListType) get_store().add_element_user(CERTREFS$0);
        }
        return certIDListType;
    }

    @Override // org.etsi.uri.x01903.v13.CompleteCertificateRefsType
    public CertIDListType getCertRefs() {
        synchronized (monitor()) {
            check_orphaned();
            CertIDListType certIDListType = (CertIDListType) get_store().find_element_user(CERTREFS$0, 0);
            if (certIDListType == null) {
                return null;
            }
            return certIDListType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteCertificateRefsType
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteCertificateRefsType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$2) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.CompleteCertificateRefsType
    public void setCertRefs(CertIDListType certIDListType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CERTREFS$0;
            CertIDListType certIDListType2 = (CertIDListType) typeStore.find_element_user(qName, 0);
            if (certIDListType2 == null) {
                certIDListType2 = (CertIDListType) get_store().add_element_user(qName);
            }
            certIDListType2.set(certIDListType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteCertificateRefsType
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteCertificateRefsType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$2);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteCertificateRefsType
    public XmlID xgetId() {
        XmlID xmlIDFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIDFind_attribute_user = get_store().find_attribute_user(ID$2);
        }
        return xmlIDFind_attribute_user;
    }

    @Override // org.etsi.uri.x01903.v13.CompleteCertificateRefsType
    public void xsetId(XmlID xmlID) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$2;
            XmlID xmlIDFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIDFind_attribute_user == null) {
                xmlIDFind_attribute_user = (XmlID) get_store().add_attribute_user(qName);
            }
            xmlIDFind_attribute_user.set(xmlID);
        }
    }
}
