package com.microsoft.schemas.office.x2006.encryption.impl;

import com.microsoft.schemas.office.x2006.encryption.CTEncryption;
import com.microsoft.schemas.office.x2006.encryption.EncryptionDocument;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class EncryptionDocumentImpl extends XmlComplexContentImpl implements EncryptionDocument {
    private static final QName ENCRYPTION$0 = new QName("http://schemas.microsoft.com/office/2006/encryption", "encryption");

    public EncryptionDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.EncryptionDocument
    public CTEncryption addNewEncryption() {
        CTEncryption cTEncryptionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEncryptionAdd_element_user = get_store().add_element_user(ENCRYPTION$0);
        }
        return cTEncryptionAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.EncryptionDocument
    public CTEncryption getEncryption() {
        synchronized (monitor()) {
            check_orphaned();
            CTEncryption cTEncryptionFind_element_user = get_store().find_element_user(ENCRYPTION$0, 0);
            if (cTEncryptionFind_element_user == null) {
                return null;
            }
            return cTEncryptionFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.EncryptionDocument
    public void setEncryption(CTEncryption cTEncryption) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTION$0;
            CTEncryption cTEncryptionFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTEncryptionFind_element_user == null) {
                cTEncryptionFind_element_user = (CTEncryption) get_store().add_element_user(qName);
            }
            cTEncryptionFind_element_user.set(cTEncryption);
        }
    }
}
