package org.etsi.uri.x01903.v13.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.CertIDType;
import org.etsi.uri.x01903.v13.DigestAlgAndValueType;
import org.w3.x2000.x09.xmldsig.X509IssuerSerialType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CertIDTypeImpl extends XmlComplexContentImpl implements CertIDType {
    private static final QName CERTDIGEST$0 = new QName("http://uri.etsi.org/01903/v1.3.2#", "CertDigest");
    private static final QName ISSUERSERIAL$2 = new QName("http://uri.etsi.org/01903/v1.3.2#", "IssuerSerial");
    private static final QName URI$4 = new QName("", "URI");

    public CertIDTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public DigestAlgAndValueType addNewCertDigest() {
        DigestAlgAndValueType digestAlgAndValueType;
        synchronized (monitor()) {
            check_orphaned();
            digestAlgAndValueType = (DigestAlgAndValueType) get_store().add_element_user(CERTDIGEST$0);
        }
        return digestAlgAndValueType;
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public X509IssuerSerialType addNewIssuerSerial() {
        X509IssuerSerialType x509IssuerSerialTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            x509IssuerSerialTypeAdd_element_user = get_store().add_element_user(ISSUERSERIAL$2);
        }
        return x509IssuerSerialTypeAdd_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public DigestAlgAndValueType getCertDigest() {
        synchronized (monitor()) {
            check_orphaned();
            DigestAlgAndValueType digestAlgAndValueType = (DigestAlgAndValueType) get_store().find_element_user(CERTDIGEST$0, 0);
            if (digestAlgAndValueType == null) {
                return null;
            }
            return digestAlgAndValueType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public X509IssuerSerialType getIssuerSerial() {
        synchronized (monitor()) {
            check_orphaned();
            X509IssuerSerialType x509IssuerSerialTypeFind_element_user = get_store().find_element_user(ISSUERSERIAL$2, 0);
            if (x509IssuerSerialTypeFind_element_user == null) {
                return null;
            }
            return x509IssuerSerialTypeFind_element_user;
        }
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public String getURI() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(URI$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public boolean isSetURI() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(URI$4) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public void setCertDigest(DigestAlgAndValueType digestAlgAndValueType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CERTDIGEST$0;
            DigestAlgAndValueType digestAlgAndValueType2 = (DigestAlgAndValueType) typeStore.find_element_user(qName, 0);
            if (digestAlgAndValueType2 == null) {
                digestAlgAndValueType2 = (DigestAlgAndValueType) get_store().add_element_user(qName);
            }
            digestAlgAndValueType2.set(digestAlgAndValueType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public void setIssuerSerial(X509IssuerSerialType x509IssuerSerialType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISSUERSERIAL$2;
            X509IssuerSerialType x509IssuerSerialTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (x509IssuerSerialTypeFind_element_user == null) {
                x509IssuerSerialTypeFind_element_user = (X509IssuerSerialType) get_store().add_element_user(qName);
            }
            x509IssuerSerialTypeFind_element_user.set(x509IssuerSerialType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public void setURI(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public void unsetURI() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(URI$4);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public XmlAnyURI xgetURI() {
        XmlAnyURI xmlAnyURIFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURIFind_attribute_user = get_store().find_attribute_user(URI$4);
        }
        return xmlAnyURIFind_attribute_user;
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public void xsetURI(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$4;
            XmlAnyURI xmlAnyURIFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlAnyURIFind_attribute_user == null) {
                xmlAnyURIFind_attribute_user = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURIFind_attribute_user.set(xmlAnyURI);
        }
    }
}
