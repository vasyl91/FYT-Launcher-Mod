package com.microsoft.schemas.office.x2006.keyEncryptor.certificate.impl;

import chip.FinalChip;
import com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CTCertificateKeyEncryptorImpl extends XmlComplexContentImpl implements CTCertificateKeyEncryptor {
    private static final QName ENCRYPTEDKEYVALUE$0 = new QName(FinalChip.BSP_PLATFORM_Null, "encryptedKeyValue");
    private static final QName X509CERTIFICATE$2 = new QName(FinalChip.BSP_PLATFORM_Null, "X509Certificate");
    private static final QName CERTVERIFIER$4 = new QName(FinalChip.BSP_PLATFORM_Null, "certVerifier");

    public CTCertificateKeyEncryptorImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor
    public byte[] getCertVerifier() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CERTVERIFIER$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor
    public byte[] getEncryptedKeyValue() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ENCRYPTEDKEYVALUE$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor
    public byte[] getX509Certificate() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(X509CERTIFICATE$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor
    public void setCertVerifier(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CERTVERIFIER$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor
    public void setEncryptedKeyValue(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDKEYVALUE$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor
    public void setX509Certificate(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = X509CERTIFICATE$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor
    public XmlBase64Binary xgetCertVerifier() {
        XmlBase64Binary xmlBase64BinaryFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_attribute_user = get_store().find_attribute_user(CERTVERIFIER$4);
        }
        return xmlBase64BinaryFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor
    public XmlBase64Binary xgetEncryptedKeyValue() {
        XmlBase64Binary xmlBase64BinaryFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_attribute_user = get_store().find_attribute_user(ENCRYPTEDKEYVALUE$0);
        }
        return xmlBase64BinaryFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor
    public XmlBase64Binary xgetX509Certificate() {
        XmlBase64Binary xmlBase64BinaryFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_attribute_user = get_store().find_attribute_user(X509CERTIFICATE$2);
        }
        return xmlBase64BinaryFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor
    public void xsetCertVerifier(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CERTVERIFIER$4;
            XmlBase64Binary xmlBase64BinaryFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBase64BinaryFind_attribute_user == null) {
                xmlBase64BinaryFind_attribute_user = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64BinaryFind_attribute_user.set(xmlBase64Binary);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor
    public void xsetEncryptedKeyValue(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDKEYVALUE$0;
            XmlBase64Binary xmlBase64BinaryFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBase64BinaryFind_attribute_user == null) {
                xmlBase64BinaryFind_attribute_user = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64BinaryFind_attribute_user.set(xmlBase64Binary);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor
    public void xsetX509Certificate(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = X509CERTIFICATE$2;
            XmlBase64Binary xmlBase64BinaryFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBase64BinaryFind_attribute_user == null) {
                xmlBase64BinaryFind_attribute_user = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64BinaryFind_attribute_user.set(xmlBase64Binary);
        }
    }
}
