package com.microsoft.schemas.office.x2006.encryption.impl;

import chip.FinalChip;
import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor;
import com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor;
import com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CTKeyEncryptorImpl extends XmlComplexContentImpl implements CTKeyEncryptor {
    private static final QName ENCRYPTEDPASSWORDKEY$0 = new QName("http://schemas.microsoft.com/office/2006/keyEncryptor/password", "encryptedKey");
    private static final QName ENCRYPTEDCERTIFICATEKEY$2 = new QName("http://schemas.microsoft.com/office/2006/keyEncryptor/certificate", "encryptedKey");
    private static final QName URI$4 = new QName(FinalChip.BSP_PLATFORM_Null, "uri");

    public static class UriImpl extends JavaStringEnumerationHolderEx implements CTKeyEncryptor.Uri {
        public UriImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected UriImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    public CTKeyEncryptorImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public CTCertificateKeyEncryptor addNewEncryptedCertificateKey() {
        CTCertificateKeyEncryptor cTCertificateKeyEncryptorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCertificateKeyEncryptorAdd_element_user = get_store().add_element_user(ENCRYPTEDCERTIFICATEKEY$2);
        }
        return cTCertificateKeyEncryptorAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public CTPasswordKeyEncryptor addNewEncryptedPasswordKey() {
        CTPasswordKeyEncryptor cTPasswordKeyEncryptorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPasswordKeyEncryptorAdd_element_user = get_store().add_element_user(ENCRYPTEDPASSWORDKEY$0);
        }
        return cTPasswordKeyEncryptorAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public CTCertificateKeyEncryptor getEncryptedCertificateKey() {
        synchronized (monitor()) {
            check_orphaned();
            CTCertificateKeyEncryptor cTCertificateKeyEncryptorFind_element_user = get_store().find_element_user(ENCRYPTEDCERTIFICATEKEY$2, 0);
            if (cTCertificateKeyEncryptorFind_element_user == null) {
                return null;
            }
            return cTCertificateKeyEncryptorFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public CTPasswordKeyEncryptor getEncryptedPasswordKey() {
        synchronized (monitor()) {
            check_orphaned();
            CTPasswordKeyEncryptor cTPasswordKeyEncryptorFind_element_user = get_store().find_element_user(ENCRYPTEDPASSWORDKEY$0, 0);
            if (cTPasswordKeyEncryptorFind_element_user == null) {
                return null;
            }
            return cTPasswordKeyEncryptorFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public CTKeyEncryptor.Uri.Enum getUri() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(URI$4);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (CTKeyEncryptor.Uri.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public boolean isSetEncryptedCertificateKey() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ENCRYPTEDCERTIFICATEKEY$2) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public boolean isSetEncryptedPasswordKey() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ENCRYPTEDPASSWORDKEY$0) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public boolean isSetUri() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(URI$4) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public void setEncryptedCertificateKey(CTCertificateKeyEncryptor cTCertificateKeyEncryptor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDCERTIFICATEKEY$2;
            CTCertificateKeyEncryptor cTCertificateKeyEncryptorFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCertificateKeyEncryptorFind_element_user == null) {
                cTCertificateKeyEncryptorFind_element_user = (CTCertificateKeyEncryptor) get_store().add_element_user(qName);
            }
            cTCertificateKeyEncryptorFind_element_user.set(cTCertificateKeyEncryptor);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public void setEncryptedPasswordKey(CTPasswordKeyEncryptor cTPasswordKeyEncryptor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDPASSWORDKEY$0;
            CTPasswordKeyEncryptor cTPasswordKeyEncryptorFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTPasswordKeyEncryptorFind_element_user == null) {
                cTPasswordKeyEncryptorFind_element_user = (CTPasswordKeyEncryptor) get_store().add_element_user(qName);
            }
            cTPasswordKeyEncryptorFind_element_user.set(cTPasswordKeyEncryptor);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public void setUri(CTKeyEncryptor.Uri.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public void unsetEncryptedCertificateKey() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENCRYPTEDCERTIFICATEKEY$2, 0);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public void unsetEncryptedPasswordKey() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENCRYPTEDPASSWORDKEY$0, 0);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public void unsetUri() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(URI$4);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public CTKeyEncryptor.Uri xgetUri() {
        CTKeyEncryptor.Uri uriFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            uriFind_attribute_user = get_store().find_attribute_user(URI$4);
        }
        return uriFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public void xsetUri(CTKeyEncryptor.Uri uri) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$4;
            CTKeyEncryptor.Uri uriFind_attribute_user = typeStore.find_attribute_user(qName);
            if (uriFind_attribute_user == null) {
                uriFind_attribute_user = (CTKeyEncryptor.Uri) get_store().add_attribute_user(qName);
            }
            uriFind_attribute_user.set((XmlObject) uri);
        }
    }
}
