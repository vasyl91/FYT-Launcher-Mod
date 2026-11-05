package org.apache.poi.poifs.crypt.cryptoapi;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CipherProvider;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.standard.StandardEncryptionHeader;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CryptoAPIEncryptionHeader extends StandardEncryptionHeader implements Cloneable {
    public CryptoAPIEncryptionHeader(LittleEndianInput littleEndianInput) throws IOException {
        super(littleEndianInput);
    }

    protected CryptoAPIEncryptionHeader(CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        super(cipherAlgorithm, hashAlgorithm, i, i2, chainingMode);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionHeader
    public void setKeySize(int i) {
        boolean z = false;
        for (int i2 : getCipherAlgorithm().allowedKeySize) {
            if (i2 == i) {
                z = true;
                break;
            }
        }
        if (!z) {
            throw new EncryptedDocumentException("invalid keysize " + i + " for cipher algorithm " + getCipherAlgorithm());
        }
        super.setKeySize(i);
        if (i > 40) {
            setCspName("Microsoft Enhanced Cryptographic Provider v1.0");
        } else {
            setCspName(CipherProvider.rc4.cipherProviderName);
        }
    }

    @Override // org.apache.poi.poifs.crypt.standard.StandardEncryptionHeader, org.apache.poi.poifs.crypt.EncryptionHeader
    public CryptoAPIEncryptionHeader clone() throws CloneNotSupportedException {
        return (CryptoAPIEncryptionHeader) super.clone();
    }
}
