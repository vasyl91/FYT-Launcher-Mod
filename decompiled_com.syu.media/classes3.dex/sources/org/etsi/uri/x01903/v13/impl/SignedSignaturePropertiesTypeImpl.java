package org.etsi.uri.x01903.v13.impl;

import java.util.Calendar;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.CertIDListType;
import org.etsi.uri.x01903.v13.SignaturePolicyIdentifierType;
import org.etsi.uri.x01903.v13.SignatureProductionPlaceType;
import org.etsi.uri.x01903.v13.SignedSignaturePropertiesType;
import org.etsi.uri.x01903.v13.SignerRoleType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SignedSignaturePropertiesTypeImpl extends XmlComplexContentImpl implements SignedSignaturePropertiesType {
    private static final QName SIGNINGTIME$0 = new QName("http://uri.etsi.org/01903/v1.3.2#", "SigningTime");
    private static final QName SIGNINGCERTIFICATE$2 = new QName("http://uri.etsi.org/01903/v1.3.2#", "SigningCertificate");
    private static final QName SIGNATUREPOLICYIDENTIFIER$4 = new QName("http://uri.etsi.org/01903/v1.3.2#", "SignaturePolicyIdentifier");
    private static final QName SIGNATUREPRODUCTIONPLACE$6 = new QName("http://uri.etsi.org/01903/v1.3.2#", "SignatureProductionPlace");
    private static final QName SIGNERROLE$8 = new QName("http://uri.etsi.org/01903/v1.3.2#", "SignerRole");
    private static final QName ID$10 = new QName("", "Id");

    public SignedSignaturePropertiesTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public SignaturePolicyIdentifierType addNewSignaturePolicyIdentifier() {
        SignaturePolicyIdentifierType signaturePolicyIdentifierType;
        synchronized (monitor()) {
            check_orphaned();
            signaturePolicyIdentifierType = (SignaturePolicyIdentifierType) get_store().add_element_user(SIGNATUREPOLICYIDENTIFIER$4);
        }
        return signaturePolicyIdentifierType;
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public SignatureProductionPlaceType addNewSignatureProductionPlace() {
        SignatureProductionPlaceType signatureProductionPlaceTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            signatureProductionPlaceTypeAdd_element_user = get_store().add_element_user(SIGNATUREPRODUCTIONPLACE$6);
        }
        return signatureProductionPlaceTypeAdd_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public SignerRoleType addNewSignerRole() {
        SignerRoleType signerRoleTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            signerRoleTypeAdd_element_user = get_store().add_element_user(SIGNERROLE$8);
        }
        return signerRoleTypeAdd_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public CertIDListType addNewSigningCertificate() {
        CertIDListType certIDListType;
        synchronized (monitor()) {
            check_orphaned();
            certIDListType = (CertIDListType) get_store().add_element_user(SIGNINGCERTIFICATE$2);
        }
        return certIDListType;
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public SignaturePolicyIdentifierType getSignaturePolicyIdentifier() {
        synchronized (monitor()) {
            check_orphaned();
            SignaturePolicyIdentifierType signaturePolicyIdentifierType = (SignaturePolicyIdentifierType) get_store().find_element_user(SIGNATUREPOLICYIDENTIFIER$4, 0);
            if (signaturePolicyIdentifierType == null) {
                return null;
            }
            return signaturePolicyIdentifierType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public SignatureProductionPlaceType getSignatureProductionPlace() {
        synchronized (monitor()) {
            check_orphaned();
            SignatureProductionPlaceType signatureProductionPlaceTypeFind_element_user = get_store().find_element_user(SIGNATUREPRODUCTIONPLACE$6, 0);
            if (signatureProductionPlaceTypeFind_element_user == null) {
                return null;
            }
            return signatureProductionPlaceTypeFind_element_user;
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public SignerRoleType getSignerRole() {
        synchronized (monitor()) {
            check_orphaned();
            SignerRoleType signerRoleTypeFind_element_user = get_store().find_element_user(SIGNERROLE$8, 0);
            if (signerRoleTypeFind_element_user == null) {
                return null;
            }
            return signerRoleTypeFind_element_user;
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public CertIDListType getSigningCertificate() {
        synchronized (monitor()) {
            check_orphaned();
            CertIDListType certIDListType = (CertIDListType) get_store().find_element_user(SIGNINGCERTIFICATE$2, 0);
            if (certIDListType == null) {
                return null;
            }
            return certIDListType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public Calendar getSigningTime() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_element_user = get_store().find_element_user(SIGNINGTIME$0, 0);
            if (simpleValueFind_element_user == null) {
                return null;
            }
            return simpleValueFind_element_user.getCalendarValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$10) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public boolean isSetSignaturePolicyIdentifier() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIGNATUREPOLICYIDENTIFIER$4) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public boolean isSetSignatureProductionPlace() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIGNATUREPRODUCTIONPLACE$6) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public boolean isSetSignerRole() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIGNERROLE$8) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public boolean isSetSigningCertificate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIGNINGCERTIFICATE$2) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public boolean isSetSigningTime() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIGNINGTIME$0) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public void setSignaturePolicyIdentifier(SignaturePolicyIdentifierType signaturePolicyIdentifierType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATUREPOLICYIDENTIFIER$4;
            SignaturePolicyIdentifierType signaturePolicyIdentifierType2 = (SignaturePolicyIdentifierType) typeStore.find_element_user(qName, 0);
            if (signaturePolicyIdentifierType2 == null) {
                signaturePolicyIdentifierType2 = (SignaturePolicyIdentifierType) get_store().add_element_user(qName);
            }
            signaturePolicyIdentifierType2.set(signaturePolicyIdentifierType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public void setSignatureProductionPlace(SignatureProductionPlaceType signatureProductionPlaceType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATUREPRODUCTIONPLACE$6;
            SignatureProductionPlaceType signatureProductionPlaceTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (signatureProductionPlaceTypeFind_element_user == null) {
                signatureProductionPlaceTypeFind_element_user = (SignatureProductionPlaceType) get_store().add_element_user(qName);
            }
            signatureProductionPlaceTypeFind_element_user.set(signatureProductionPlaceType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public void setSignerRole(SignerRoleType signerRoleType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNERROLE$8;
            SignerRoleType signerRoleTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (signerRoleTypeFind_element_user == null) {
                signerRoleTypeFind_element_user = (SignerRoleType) get_store().add_element_user(qName);
            }
            signerRoleTypeFind_element_user.set(signerRoleType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public void setSigningCertificate(CertIDListType certIDListType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNINGCERTIFICATE$2;
            CertIDListType certIDListType2 = (CertIDListType) typeStore.find_element_user(qName, 0);
            if (certIDListType2 == null) {
                certIDListType2 = (CertIDListType) get_store().add_element_user(qName);
            }
            certIDListType2.set(certIDListType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public void setSigningTime(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNINGTIME$0;
            SimpleValue simpleValueFind_element_user = typeStore.find_element_user(qName, 0);
            if (simpleValueFind_element_user == null) {
                simpleValueFind_element_user = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValueFind_element_user.setCalendarValue(calendar);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$10);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public void unsetSignaturePolicyIdentifier() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNATUREPOLICYIDENTIFIER$4, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public void unsetSignatureProductionPlace() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNATUREPRODUCTIONPLACE$6, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public void unsetSignerRole() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNERROLE$8, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public void unsetSigningCertificate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNINGCERTIFICATE$2, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public void unsetSigningTime() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNINGTIME$0, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public XmlID xgetId() {
        XmlID xmlIDFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlIDFind_attribute_user = get_store().find_attribute_user(ID$10);
        }
        return xmlIDFind_attribute_user;
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public XmlDateTime xgetSigningTime() {
        XmlDateTime xmlDateTimeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTimeFind_element_user = get_store().find_element_user(SIGNINGTIME$0, 0);
        }
        return xmlDateTimeFind_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public void xsetId(XmlID xmlID) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$10;
            XmlID xmlIDFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlIDFind_attribute_user == null) {
                xmlIDFind_attribute_user = (XmlID) get_store().add_attribute_user(qName);
            }
            xmlIDFind_attribute_user.set(xmlID);
        }
    }

    @Override // org.etsi.uri.x01903.v13.SignedSignaturePropertiesType
    public void xsetSigningTime(XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNINGTIME$0;
            XmlDateTime xmlDateTimeFind_element_user = typeStore.find_element_user(qName, 0);
            if (xmlDateTimeFind_element_user == null) {
                xmlDateTimeFind_element_user = (XmlDateTime) get_store().add_element_user(qName);
            }
            xmlDateTimeFind_element_user.set(xmlDateTime);
        }
    }
}
