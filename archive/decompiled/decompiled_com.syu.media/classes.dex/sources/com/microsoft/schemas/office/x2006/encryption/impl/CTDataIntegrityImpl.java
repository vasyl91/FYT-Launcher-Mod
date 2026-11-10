package com.microsoft.schemas.office.x2006.encryption.impl;

import chip.FinalChip;
import com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CTDataIntegrityImpl extends XmlComplexContentImpl implements CTDataIntegrity {
    private static final QName ENCRYPTEDHMACKEY$0 = new QName(FinalChip.BSP_PLATFORM_Null, "encryptedHmacKey");
    private static final QName ENCRYPTEDHMACVALUE$2 = new QName(FinalChip.BSP_PLATFORM_Null, "encryptedHmacValue");

    public CTDataIntegrityImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity
    public byte[] getEncryptedHmacKey() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ENCRYPTEDHMACKEY$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity
    public byte[] getEncryptedHmacValue() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ENCRYPTEDHMACVALUE$2);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity
    public void setEncryptedHmacKey(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDHMACKEY$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity
    public void setEncryptedHmacValue(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDHMACVALUE$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity
    public XmlBase64Binary xgetEncryptedHmacKey() {
        XmlBase64Binary xmlBase64BinaryFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_attribute_user = get_store().find_attribute_user(ENCRYPTEDHMACKEY$0);
        }
        return xmlBase64BinaryFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity
    public XmlBase64Binary xgetEncryptedHmacValue() {
        XmlBase64Binary xmlBase64BinaryFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_attribute_user = get_store().find_attribute_user(ENCRYPTEDHMACVALUE$2);
        }
        return xmlBase64BinaryFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity
    public void xsetEncryptedHmacKey(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDHMACKEY$0;
            XmlBase64Binary xmlBase64BinaryFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBase64BinaryFind_attribute_user == null) {
                xmlBase64BinaryFind_attribute_user = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64BinaryFind_attribute_user.set(xmlBase64Binary);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity
    public void xsetEncryptedHmacValue(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDHMACVALUE$2;
            XmlBase64Binary xmlBase64BinaryFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBase64BinaryFind_attribute_user == null) {
                xmlBase64BinaryFind_attribute_user = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64BinaryFind_attribute_user.set(xmlBase64Binary);
        }
    }
}
