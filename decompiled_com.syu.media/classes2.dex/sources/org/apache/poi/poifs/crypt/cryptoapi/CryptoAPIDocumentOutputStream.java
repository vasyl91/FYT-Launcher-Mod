package org.apache.poi.poifs.crypt.cryptoapi;

import java.io.ByteArrayOutputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
class CryptoAPIDocumentOutputStream extends ByteArrayOutputStream {
    private final Cipher cipher;
    private final CryptoAPIEncryptor encryptor;
    private final byte[] oneByte = {0};

    public CryptoAPIDocumentOutputStream(CryptoAPIEncryptor cryptoAPIEncryptor) throws GeneralSecurityException {
        this.encryptor = cryptoAPIEncryptor;
        this.cipher = cryptoAPIEncryptor.initCipherForBlock(null, 0);
    }

    public byte[] getBuf() {
        return this.buf;
    }

    public void setSize(int i) {
        this.count = i;
    }

    public void setBlock(int i) throws GeneralSecurityException {
        this.encryptor.initCipherForBlock(this.cipher, i);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public void write(int i) {
        try {
            byte[] bArr = this.oneByte;
            bArr[0] = (byte) i;
            this.cipher.update(bArr, 0, 1, bArr, 0);
            super.write(this.oneByte);
        } catch (Exception e) {
            throw new EncryptedDocumentException(e);
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        try {
            this.cipher.update(bArr, i, i2, bArr, i);
            super.write(bArr, i, i2);
        } catch (Exception e) {
            throw new EncryptedDocumentException(e);
        }
    }
}
