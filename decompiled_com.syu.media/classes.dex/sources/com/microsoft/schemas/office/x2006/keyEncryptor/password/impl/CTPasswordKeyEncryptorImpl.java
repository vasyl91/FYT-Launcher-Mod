package com.microsoft.schemas.office.x2006.keyEncryptor.password.impl;

import chip.FinalChip;
import com.microsoft.schemas.office.x2006.encryption.STBlockSize;
import com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm;
import com.microsoft.schemas.office.x2006.encryption.STCipherChaining;
import com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm;
import com.microsoft.schemas.office.x2006.encryption.STHashSize;
import com.microsoft.schemas.office.x2006.encryption.STKeyBits;
import com.microsoft.schemas.office.x2006.encryption.STSaltSize;
import com.microsoft.schemas.office.x2006.encryption.STSpinCount;
import com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CTPasswordKeyEncryptorImpl extends XmlComplexContentImpl implements CTPasswordKeyEncryptor {
    private static final QName SALTSIZE$0 = new QName(FinalChip.BSP_PLATFORM_Null, "saltSize");
    private static final QName BLOCKSIZE$2 = new QName(FinalChip.BSP_PLATFORM_Null, "blockSize");
    private static final QName KEYBITS$4 = new QName(FinalChip.BSP_PLATFORM_Null, "keyBits");
    private static final QName HASHSIZE$6 = new QName(FinalChip.BSP_PLATFORM_Null, "hashSize");
    private static final QName CIPHERALGORITHM$8 = new QName(FinalChip.BSP_PLATFORM_Null, "cipherAlgorithm");
    private static final QName CIPHERCHAINING$10 = new QName(FinalChip.BSP_PLATFORM_Null, "cipherChaining");
    private static final QName HASHALGORITHM$12 = new QName(FinalChip.BSP_PLATFORM_Null, "hashAlgorithm");
    private static final QName SALTVALUE$14 = new QName(FinalChip.BSP_PLATFORM_Null, "saltValue");
    private static final QName SPINCOUNT$16 = new QName(FinalChip.BSP_PLATFORM_Null, "spinCount");
    private static final QName ENCRYPTEDVERIFIERHASHINPUT$18 = new QName(FinalChip.BSP_PLATFORM_Null, "encryptedVerifierHashInput");
    private static final QName ENCRYPTEDVERIFIERHASHVALUE$20 = new QName(FinalChip.BSP_PLATFORM_Null, "encryptedVerifierHashValue");
    private static final QName ENCRYPTEDKEYVALUE$22 = new QName(FinalChip.BSP_PLATFORM_Null, "encryptedKeyValue");

    public CTPasswordKeyEncryptorImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public int getBlockSize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(BLOCKSIZE$2);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STCipherAlgorithm.Enum getCipherAlgorithm() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CIPHERALGORITHM$8);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STCipherAlgorithm.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STCipherChaining.Enum getCipherChaining() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(CIPHERCHAINING$10);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STCipherChaining.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public byte[] getEncryptedKeyValue() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ENCRYPTEDKEYVALUE$22);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public byte[] getEncryptedVerifierHashInput() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ENCRYPTEDVERIFIERHASHINPUT$18);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public byte[] getEncryptedVerifierHashValue() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ENCRYPTEDVERIFIERHASHVALUE$20);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STHashAlgorithm.Enum getHashAlgorithm() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HASHALGORITHM$12);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STHashAlgorithm.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public int getHashSize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(HASHSIZE$6);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public long getKeyBits() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(KEYBITS$4);
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public int getSaltSize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SALTSIZE$0);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public byte[] getSaltValue() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SALTVALUE$14);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getByteArrayValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public int getSpinCount() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SPINCOUNT$16);
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setBlockSize(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOCKSIZE$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setCipherAlgorithm(STCipherAlgorithm.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CIPHERALGORITHM$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setCipherChaining(STCipherChaining.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CIPHERCHAINING$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setEncryptedKeyValue(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDKEYVALUE$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setEncryptedVerifierHashInput(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDVERIFIERHASHINPUT$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setEncryptedVerifierHashValue(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDVERIFIERHASHVALUE$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setHashAlgorithm(STHashAlgorithm.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASHALGORITHM$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setHashSize(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASHSIZE$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setKeyBits(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KEYBITS$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setSaltSize(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SALTSIZE$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setSaltValue(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SALTVALUE$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setByteArrayValue(bArr);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setSpinCount(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPINCOUNT$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STBlockSize xgetBlockSize() {
        STBlockSize sTBlockSizeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTBlockSizeFind_attribute_user = get_store().find_attribute_user(BLOCKSIZE$2);
        }
        return sTBlockSizeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STCipherAlgorithm xgetCipherAlgorithm() {
        STCipherAlgorithm sTCipherAlgorithmFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTCipherAlgorithmFind_attribute_user = get_store().find_attribute_user(CIPHERALGORITHM$8);
        }
        return sTCipherAlgorithmFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STCipherChaining xgetCipherChaining() {
        STCipherChaining sTCipherChainingFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTCipherChainingFind_attribute_user = get_store().find_attribute_user(CIPHERCHAINING$10);
        }
        return sTCipherChainingFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public XmlBase64Binary xgetEncryptedKeyValue() {
        XmlBase64Binary xmlBase64BinaryFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_attribute_user = get_store().find_attribute_user(ENCRYPTEDKEYVALUE$22);
        }
        return xmlBase64BinaryFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public XmlBase64Binary xgetEncryptedVerifierHashInput() {
        XmlBase64Binary xmlBase64BinaryFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_attribute_user = get_store().find_attribute_user(ENCRYPTEDVERIFIERHASHINPUT$18);
        }
        return xmlBase64BinaryFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public XmlBase64Binary xgetEncryptedVerifierHashValue() {
        XmlBase64Binary xmlBase64BinaryFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_attribute_user = get_store().find_attribute_user(ENCRYPTEDVERIFIERHASHVALUE$20);
        }
        return xmlBase64BinaryFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STHashAlgorithm xgetHashAlgorithm() {
        STHashAlgorithm sTHashAlgorithmFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTHashAlgorithmFind_attribute_user = get_store().find_attribute_user(HASHALGORITHM$12);
        }
        return sTHashAlgorithmFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STHashSize xgetHashSize() {
        STHashSize sTHashSizeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTHashSizeFind_attribute_user = get_store().find_attribute_user(HASHSIZE$6);
        }
        return sTHashSizeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STKeyBits xgetKeyBits() {
        STKeyBits sTKeyBitsFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTKeyBitsFind_attribute_user = get_store().find_attribute_user(KEYBITS$4);
        }
        return sTKeyBitsFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STSaltSize xgetSaltSize() {
        STSaltSize sTSaltSizeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTSaltSizeFind_attribute_user = get_store().find_attribute_user(SALTSIZE$0);
        }
        return sTSaltSizeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public XmlBase64Binary xgetSaltValue() {
        XmlBase64Binary xmlBase64BinaryFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_attribute_user = get_store().find_attribute_user(SALTVALUE$14);
        }
        return xmlBase64BinaryFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STSpinCount xgetSpinCount() {
        STSpinCount sTSpinCountFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTSpinCountFind_attribute_user = get_store().find_attribute_user(SPINCOUNT$16);
        }
        return sTSpinCountFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetBlockSize(STBlockSize sTBlockSize) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOCKSIZE$2;
            STBlockSize sTBlockSizeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTBlockSizeFind_attribute_user == null) {
                sTBlockSizeFind_attribute_user = (STBlockSize) get_store().add_attribute_user(qName);
            }
            sTBlockSizeFind_attribute_user.set((XmlObject) sTBlockSize);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetCipherAlgorithm(STCipherAlgorithm sTCipherAlgorithm) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CIPHERALGORITHM$8;
            STCipherAlgorithm sTCipherAlgorithmFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTCipherAlgorithmFind_attribute_user == null) {
                sTCipherAlgorithmFind_attribute_user = (STCipherAlgorithm) get_store().add_attribute_user(qName);
            }
            sTCipherAlgorithmFind_attribute_user.set((XmlObject) sTCipherAlgorithm);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetCipherChaining(STCipherChaining sTCipherChaining) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CIPHERCHAINING$10;
            STCipherChaining sTCipherChainingFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTCipherChainingFind_attribute_user == null) {
                sTCipherChainingFind_attribute_user = (STCipherChaining) get_store().add_attribute_user(qName);
            }
            sTCipherChainingFind_attribute_user.set((XmlObject) sTCipherChaining);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetEncryptedKeyValue(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDKEYVALUE$22;
            XmlBase64Binary xmlBase64BinaryFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBase64BinaryFind_attribute_user == null) {
                xmlBase64BinaryFind_attribute_user = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64BinaryFind_attribute_user.set(xmlBase64Binary);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetEncryptedVerifierHashInput(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDVERIFIERHASHINPUT$18;
            XmlBase64Binary xmlBase64BinaryFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBase64BinaryFind_attribute_user == null) {
                xmlBase64BinaryFind_attribute_user = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64BinaryFind_attribute_user.set(xmlBase64Binary);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetEncryptedVerifierHashValue(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDVERIFIERHASHVALUE$20;
            XmlBase64Binary xmlBase64BinaryFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBase64BinaryFind_attribute_user == null) {
                xmlBase64BinaryFind_attribute_user = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64BinaryFind_attribute_user.set(xmlBase64Binary);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetHashAlgorithm(STHashAlgorithm sTHashAlgorithm) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASHALGORITHM$12;
            STHashAlgorithm sTHashAlgorithmFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTHashAlgorithmFind_attribute_user == null) {
                sTHashAlgorithmFind_attribute_user = (STHashAlgorithm) get_store().add_attribute_user(qName);
            }
            sTHashAlgorithmFind_attribute_user.set((XmlObject) sTHashAlgorithm);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetHashSize(STHashSize sTHashSize) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASHSIZE$6;
            STHashSize sTHashSizeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTHashSizeFind_attribute_user == null) {
                sTHashSizeFind_attribute_user = (STHashSize) get_store().add_attribute_user(qName);
            }
            sTHashSizeFind_attribute_user.set((XmlObject) sTHashSize);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetKeyBits(STKeyBits sTKeyBits) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KEYBITS$4;
            STKeyBits sTKeyBitsFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTKeyBitsFind_attribute_user == null) {
                sTKeyBitsFind_attribute_user = (STKeyBits) get_store().add_attribute_user(qName);
            }
            sTKeyBitsFind_attribute_user.set(sTKeyBits);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetSaltSize(STSaltSize sTSaltSize) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SALTSIZE$0;
            STSaltSize sTSaltSizeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTSaltSizeFind_attribute_user == null) {
                sTSaltSizeFind_attribute_user = (STSaltSize) get_store().add_attribute_user(qName);
            }
            sTSaltSizeFind_attribute_user.set((XmlObject) sTSaltSize);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetSaltValue(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SALTVALUE$14;
            XmlBase64Binary xmlBase64BinaryFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBase64BinaryFind_attribute_user == null) {
                xmlBase64BinaryFind_attribute_user = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64BinaryFind_attribute_user.set(xmlBase64Binary);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetSpinCount(STSpinCount sTSpinCount) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPINCOUNT$16;
            STSpinCount sTSpinCountFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTSpinCountFind_attribute_user == null) {
                sTSpinCountFind_attribute_user = (STSpinCount) get_store().add_attribute_user(qName);
            }
            sTSpinCountFind_attribute_user.set((XmlObject) sTSpinCount);
        }
    }
}
