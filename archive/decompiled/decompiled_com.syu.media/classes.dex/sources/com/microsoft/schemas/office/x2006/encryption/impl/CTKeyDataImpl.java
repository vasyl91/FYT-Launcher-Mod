package com.microsoft.schemas.office.x2006.encryption.impl;

import chip.FinalChip;
import com.microsoft.schemas.office.x2006.encryption.CTKeyData;
import com.microsoft.schemas.office.x2006.encryption.STBlockSize;
import com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm;
import com.microsoft.schemas.office.x2006.encryption.STCipherChaining;
import com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm;
import com.microsoft.schemas.office.x2006.encryption.STHashSize;
import com.microsoft.schemas.office.x2006.encryption.STKeyBits;
import com.microsoft.schemas.office.x2006.encryption.STSaltSize;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class CTKeyDataImpl extends XmlComplexContentImpl implements CTKeyData {
    private static final QName SALTSIZE$0 = new QName(FinalChip.BSP_PLATFORM_Null, "saltSize");
    private static final QName BLOCKSIZE$2 = new QName(FinalChip.BSP_PLATFORM_Null, "blockSize");
    private static final QName KEYBITS$4 = new QName(FinalChip.BSP_PLATFORM_Null, "keyBits");
    private static final QName HASHSIZE$6 = new QName(FinalChip.BSP_PLATFORM_Null, "hashSize");
    private static final QName CIPHERALGORITHM$8 = new QName(FinalChip.BSP_PLATFORM_Null, "cipherAlgorithm");
    private static final QName CIPHERCHAINING$10 = new QName(FinalChip.BSP_PLATFORM_Null, "cipherChaining");
    private static final QName HASHALGORITHM$12 = new QName(FinalChip.BSP_PLATFORM_Null, "hashAlgorithm");
    private static final QName SALTVALUE$14 = new QName(FinalChip.BSP_PLATFORM_Null, "saltValue");

    public CTKeyDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
    public STBlockSize xgetBlockSize() {
        STBlockSize sTBlockSizeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTBlockSizeFind_attribute_user = get_store().find_attribute_user(BLOCKSIZE$2);
        }
        return sTBlockSizeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
    public STCipherAlgorithm xgetCipherAlgorithm() {
        STCipherAlgorithm sTCipherAlgorithmFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTCipherAlgorithmFind_attribute_user = get_store().find_attribute_user(CIPHERALGORITHM$8);
        }
        return sTCipherAlgorithmFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
    public STCipherChaining xgetCipherChaining() {
        STCipherChaining sTCipherChainingFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTCipherChainingFind_attribute_user = get_store().find_attribute_user(CIPHERCHAINING$10);
        }
        return sTCipherChainingFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
    public STHashAlgorithm xgetHashAlgorithm() {
        STHashAlgorithm sTHashAlgorithmFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTHashAlgorithmFind_attribute_user = get_store().find_attribute_user(HASHALGORITHM$12);
        }
        return sTHashAlgorithmFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
    public STHashSize xgetHashSize() {
        STHashSize sTHashSizeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTHashSizeFind_attribute_user = get_store().find_attribute_user(HASHSIZE$6);
        }
        return sTHashSizeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
    public STKeyBits xgetKeyBits() {
        STKeyBits sTKeyBitsFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTKeyBitsFind_attribute_user = get_store().find_attribute_user(KEYBITS$4);
        }
        return sTKeyBitsFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
    public STSaltSize xgetSaltSize() {
        STSaltSize sTSaltSizeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTSaltSizeFind_attribute_user = get_store().find_attribute_user(SALTSIZE$0);
        }
        return sTSaltSizeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
    public XmlBase64Binary xgetSaltValue() {
        XmlBase64Binary xmlBase64BinaryFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64BinaryFind_attribute_user = get_store().find_attribute_user(SALTVALUE$14);
        }
        return xmlBase64BinaryFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyData
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
}
