package com.microsoft.schemas.office.x2006.encryption.impl;

import com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity;
import com.microsoft.schemas.office.x2006.encryption.CTEncryption;
import com.microsoft.schemas.office.x2006.encryption.CTKeyData;
import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptors;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CTEncryptionImpl extends XmlComplexContentImpl implements CTEncryption {
    private static final QName KEYDATA$0 = new QName("http://schemas.microsoft.com/office/2006/encryption", "keyData");
    private static final QName DATAINTEGRITY$2 = new QName("http://schemas.microsoft.com/office/2006/encryption", "dataIntegrity");
    private static final QName KEYENCRYPTORS$4 = new QName("http://schemas.microsoft.com/office/2006/encryption", "keyEncryptors");

    public CTEncryptionImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTEncryption
    public CTDataIntegrity addNewDataIntegrity() {
        CTDataIntegrity cTDataIntegrityAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDataIntegrityAdd_element_user = get_store().add_element_user(DATAINTEGRITY$2);
        }
        return cTDataIntegrityAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTEncryption
    public CTKeyData addNewKeyData() {
        CTKeyData cTKeyDataAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTKeyDataAdd_element_user = get_store().add_element_user(KEYDATA$0);
        }
        return cTKeyDataAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTEncryption
    public CTKeyEncryptors addNewKeyEncryptors() {
        CTKeyEncryptors cTKeyEncryptorsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTKeyEncryptorsAdd_element_user = get_store().add_element_user(KEYENCRYPTORS$4);
        }
        return cTKeyEncryptorsAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTEncryption
    public CTDataIntegrity getDataIntegrity() {
        synchronized (monitor()) {
            check_orphaned();
            CTDataIntegrity cTDataIntegrityFind_element_user = get_store().find_element_user(DATAINTEGRITY$2, 0);
            if (cTDataIntegrityFind_element_user == null) {
                return null;
            }
            return cTDataIntegrityFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTEncryption
    public CTKeyData getKeyData() {
        synchronized (monitor()) {
            check_orphaned();
            CTKeyData cTKeyDataFind_element_user = get_store().find_element_user(KEYDATA$0, 0);
            if (cTKeyDataFind_element_user == null) {
                return null;
            }
            return cTKeyDataFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTEncryption
    public CTKeyEncryptors getKeyEncryptors() {
        synchronized (monitor()) {
            check_orphaned();
            CTKeyEncryptors cTKeyEncryptorsFind_element_user = get_store().find_element_user(KEYENCRYPTORS$4, 0);
            if (cTKeyEncryptorsFind_element_user == null) {
                return null;
            }
            return cTKeyEncryptorsFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTEncryption
    public void setDataIntegrity(CTDataIntegrity cTDataIntegrity) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATAINTEGRITY$2;
            CTDataIntegrity cTDataIntegrityFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTDataIntegrityFind_element_user == null) {
                cTDataIntegrityFind_element_user = (CTDataIntegrity) get_store().add_element_user(qName);
            }
            cTDataIntegrityFind_element_user.set(cTDataIntegrity);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTEncryption
    public void setKeyData(CTKeyData cTKeyData) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KEYDATA$0;
            CTKeyData cTKeyDataFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTKeyDataFind_element_user == null) {
                cTKeyDataFind_element_user = (CTKeyData) get_store().add_element_user(qName);
            }
            cTKeyDataFind_element_user.set(cTKeyData);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTEncryption
    public void setKeyEncryptors(CTKeyEncryptors cTKeyEncryptors) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KEYENCRYPTORS$4;
            CTKeyEncryptors cTKeyEncryptorsFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTKeyEncryptorsFind_element_user == null) {
                cTKeyEncryptorsFind_element_user = (CTKeyEncryptors) get_store().add_element_user(qName);
            }
            cTKeyEncryptorsFind_element_user.set(cTKeyEncryptors);
        }
    }
}
