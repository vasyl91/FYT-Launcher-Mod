package org.apache.poi.poifs.crypt.agile;

import com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity;
import com.microsoft.schemas.office.x2006.encryption.CTKeyData;
import com.microsoft.schemas.office.x2006.encryption.EncryptionDocument;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionHeader;
import org.apache.poi.poifs.crypt.HashAlgorithm;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class AgileEncryptionHeader extends EncryptionHeader implements Cloneable {
    private byte[] encryptedHmacKey;
    private byte[] encryptedHmacValue;

    public AgileEncryptionHeader(String str) {
        this(AgileEncryptionInfoBuilder.parseDescriptor(str));
    }

    protected AgileEncryptionHeader(EncryptionDocument encryptionDocument) {
        try {
            CTKeyData keyData = encryptionDocument.getEncryption().getKeyData();
            if (keyData == null) {
                throw new NullPointerException("keyData not set");
            }
            int keyBits = (int) keyData.getKeyBits();
            CipherAlgorithm cipherAlgorithmFromXmlId = CipherAlgorithm.fromXmlId(keyData.getCipherAlgorithm().toString(), keyBits);
            setCipherAlgorithm(cipherAlgorithmFromXmlId);
            setCipherProvider(cipherAlgorithmFromXmlId.provider);
            setKeySize(keyBits);
            setFlags(0);
            setSizeExtra(0);
            setCspName(null);
            setBlockSize(keyData.getBlockSize());
            int iIntValue = keyData.getCipherChaining().intValue();
            if (iIntValue == 1) {
                setChainingMode(ChainingMode.cbc);
            } else if (iIntValue == 2) {
                setChainingMode(ChainingMode.cfb);
            } else {
                throw new EncryptedDocumentException("Unsupported chaining mode - " + keyData.getCipherChaining());
            }
            int hashSize = keyData.getHashSize();
            setHashAlgorithm(HashAlgorithm.fromEcmaId(keyData.getHashAlgorithm().toString()));
            if (getHashAlgorithm().hashSize != hashSize) {
                throw new EncryptedDocumentException("Unsupported hash algorithm: " + keyData.getHashAlgorithm() + " @ " + hashSize + " bytes");
            }
            int saltSize = keyData.getSaltSize();
            setKeySalt(keyData.getSaltValue());
            if (getKeySalt().length != saltSize) {
                throw new EncryptedDocumentException("Invalid salt length");
            }
            CTDataIntegrity dataIntegrity = encryptionDocument.getEncryption().getDataIntegrity();
            setEncryptedHmacKey(dataIntegrity.getEncryptedHmacKey());
            setEncryptedHmacValue(dataIntegrity.getEncryptedHmacValue());
        } catch (Exception unused) {
            throw new EncryptedDocumentException("Unable to parse keyData");
        }
    }

    public AgileEncryptionHeader(CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        setCipherAlgorithm(cipherAlgorithm);
        setHashAlgorithm(hashAlgorithm);
        setKeySize(i);
        setBlockSize(i2);
        setChainingMode(chainingMode);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionHeader
    protected void setKeySalt(byte[] bArr) {
        if (bArr == null || bArr.length != getBlockSize()) {
            throw new EncryptedDocumentException("invalid verifier salt");
        }
        super.setKeySalt(bArr);
    }

    public byte[] getEncryptedHmacKey() {
        return this.encryptedHmacKey;
    }

    protected void setEncryptedHmacKey(byte[] bArr) {
        this.encryptedHmacKey = bArr == null ? null : (byte[]) bArr.clone();
    }

    public byte[] getEncryptedHmacValue() {
        return this.encryptedHmacValue;
    }

    protected void setEncryptedHmacValue(byte[] bArr) {
        this.encryptedHmacValue = bArr == null ? null : (byte[]) bArr.clone();
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionHeader
    public AgileEncryptionHeader clone() throws CloneNotSupportedException {
        AgileEncryptionHeader agileEncryptionHeader = (AgileEncryptionHeader) super.clone();
        byte[] bArr = this.encryptedHmacKey;
        agileEncryptionHeader.encryptedHmacKey = bArr == null ? null : (byte[]) bArr.clone();
        byte[] bArr2 = this.encryptedHmacValue;
        agileEncryptionHeader.encryptedHmacValue = bArr2 != null ? (byte[]) bArr2.clone() : null;
        return agileEncryptionHeader;
    }
}
